package de.fuberlin.winfo.project.algorithm.impl.ricosven.module;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Vehicle;

public class ClusterGenerator {

	NetworkProvider network;
	List<Cluster> clusters = new ArrayList<Cluster>();

	public ClusterGenerator(NetworkProvider networkProvider, Vehicle firstStageVehicle) {
		this.network = networkProvider;
		Locatables locatables = networkProvider.getLocatables();

		Node depot = locatables.getMainDepotAsNode();
		List<Node> transhipmentNodes = locatables.getTranshipmentPointsAsNodes();
		List<Node> customerNodesWithoutTransipmentNodes = locatables.getCustomerWithoutTranshipmentAsNodes();

		clusters.add(new Cluster(depot));

		if (transhipmentNodes != null) {
			initialiseTranshipmentClusters(transhipmentNodes, depot, firstStageVehicle);
			addTranshipmentsToDepotCluster(clusters.get(0), transhipmentNodes);
		}

		clusterCustomerNodes(customerNodesWithoutTransipmentNodes);
	}

	private void addTranshipmentsToDepotCluster(Cluster cluster, List<Node> transhipmentNodes) {
		cluster.addAll(transhipmentNodes);
	}

	private void initialiseTranshipmentClusters(List<Node> transhipmentNodes, Node depot, Vehicle firstStageVehicle) {

		if (transhipmentNodes != null) {
			for (int i = 0; i < transhipmentNodes.size(); i++) {

				Customer customer = (Customer) transhipmentNodes.get(i).getRepresentative();
				((Depot) customer.getHasTranshipmentPoint())
						.setTimeWindow(generateTimewindow(transhipmentNodes.get(i), depot, firstStageVehicle));
				((Depot) customer.getHasTranshipmentPoint())
						.setMaxTourLength(((Depot) depot.getRepresentative()).getMaxTourLength());
				clusters.add(new Cluster(transhipmentNodes.get(i)));
			}
		}
	}

	private Duration generateTimewindow(Node transhipmentNode, Node depot, Vehicle firstStageVehicle) {
		int timeWindowStart = ((Depot) depot.getRepresentative()).getTimeWindow().getStartInSec();
		timeWindowStart += network.getEdges()[depot.getId()][transhipmentNode.getId()].getTime();
		timeWindowStart += (firstStageVehicle.getTranshipmentTimeInMinutes()*60);

		int timeWindowEnd = ((Depot) depot.getRepresentative()).getTimeWindow().getEndInSec();

		Duration timewindow = network.getNetworkFactory().createDuration();

		timewindow.setStartInSec(timeWindowStart);
		timewindow.setEndInSec(timeWindowEnd);

		return timewindow;

	}

	private void clusterCustomerNodes(List<Node> customerNodes) {

		for (int i = 0; i < customerNodes.size(); i++) {

			double shortestTime = Integer.MAX_VALUE;
			int clusterIndex = Integer.MAX_VALUE;

			for (int c = 0; c < clusters.size(); c++) {

				double timeToCluster = network.getEdges()[clusters.get(c).clusterCenterNode.getId()][customerNodes
						.get(i).getId()].getTime();

				if (timeToCluster < shortestTime) {
					shortestTime = timeToCluster;
					clusterIndex = c;
				}
			}
			clusters.get(clusterIndex).add(customerNodes.get(i));
		}

	}

	public List<Cluster> getClusters() {
		return clusters;
	}

	public class Cluster extends ArrayList<Node> {

		public Node clusterCenterNode;

		Cluster(Node clusterCenterNode) {
			this.clusterCenterNode = clusterCenterNode;
		}
	}
}
