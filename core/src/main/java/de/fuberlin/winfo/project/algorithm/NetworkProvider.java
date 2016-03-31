package de.fuberlin.winfo.project.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.StaticLocatables;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.ProgressBar;
import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.impl.EdgeImpl;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.impl.NodeImpl;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

/**
 * @author willrich
 *
 *         The Network Provider provides all the data being relevant for solving
 *         problems. <br>
 *         Furthermore, all the data being relevant, are provided in multiple
 *         ways, so that at most each demand for a specific provision of data is
 *         given.
 */
public class NetworkProvider {

	/**
	 * Creates new Domain Objects
	 */
	private NetworkFactory networkFactory = new NetworkFactoryImpl();
	private SolutionFactoryImpl solutionFactory = new SolutionFactoryImpl();
	private Edge[][] edges;
	private Node[] nodes;
	private Network network;
	private StaticLocatables locatables;

	public NetworkProvider(List<ZMIEdge> zmiEdges, StaticLocatables locatables)
			throws Exception {
		Log.info(Log.NETWORK_PROVIDER, "Nodes and edges are getting preprocessed");
		this.locatables = locatables;
		this.network = networkFactory.createNetwork();
		buildNetwork(zmiEdges);
		addItAllToNetwork();
	}

	public StaticLocatables getLocatables() {
		return locatables;
	}

	private void addItAllToNetwork() {
		for (int i = 0; i < edges.length; i++) {
			for (int j = 0; j < edges[i].length; j++) {
				network.getEdges().add(edges[i][j]);
			}
		}

		for (int k = 0; k < nodes.length; k++) {
			network.getNodes().add(nodes[k]);
		}
	}

	public Network getNetwork() {
		return network;
	}

	public NetworkFactory getNetworkFactory() {
		return networkFactory;
	}

	public SolutionFactoryImpl getSolutionFactory() {
		return solutionFactory;
	}

	public Edge[][] getEdges() {
		return edges;
	}

	public Node[] getNodes() {
		return nodes;
	}

	public List<Node> getNodesAsList() {
		return asCopiedList(nodes);
	}

	/**
	 * This is only a helper method which provides a helper data construct. It
	 * is not planned to use this construct as a part of a solution. Only for
	 * temporarily purposes.
	 */
	public EList<Node> getTmpNodeWay() {
		return new BasicEList<Node>();
	}

	/*
	 * HELPER METHODS FOR BUILDING A NETWORK BY THE GIVEN INPUT
	 */

	private <T> List<T> asCopiedList(T[] arr) {
		ArrayList<T> list = new ArrayList<T>();
		list.addAll(Arrays.asList(arr));
		return list;
	}

	private void buildNetwork(List<ZMIEdge> zmiEdges) throws Exception {
		StopWatch stopWatch = Utils.stopWatchGo();
		int n = 1 + locatables.getCustomer().size();

		Log.info(Log.NETWORK_PROVIDER, "Prepare all edges for the network");
		this.edges = getDistanceMatrixAsArray(zmiEdges, n);
		Log.info(Log.NETWORK_PROVIDER, "Inflate " + n + " nodes for the network");
		this.nodes = inflateNodes();
		Log.info(Log.NETWORK_PROVIDER, "Inflate " + (int) (Math.pow(edges.length, 2) - edges.length)
				+ " edges and assign previous inflated nodes");
		assignEdgesToNodes(edges, nodes);
		String stop = stopWatch.stop();
		Log.info(Log.NETWORK_PROVIDER, "Built network within " + stop + " min");
	}

	private void assignEdgesToNodes(Edge[][] edges, Node[] nodes) {
		ProgressBar showProgress = Utils.showProgress(nodes.length);
		for (int i = 0; i < nodes.length; i++) {
			showProgress.update(i);
			for (int j = 0; j < nodes.length; j++) {
				Edge edge = edges[i][j];
				if (edge == null) {
					System.out.println("is null: " + i + " " + j);
				}
				edge.setStart(nodes[i]);
				edge.setEnd(nodes[j]);
				nodes[i].getEdgeOut().add(edge);
				nodes[j].getEdgeIn().add(edge);
			}
		}
		showProgress.update(nodes.length);
		showProgress.done();
	}

	private Node[] inflateNodes() {
		ProgressBar showProgress = Utils.showProgress(locatables.size());
		Node[] nodes = new NodeImpl[locatables.size()];
		List<Locatable> list = locatables.toList();
		for (int i = 0; i < nodes.length; i++) {
			showProgress.update(i);
			Node node = networkFactory.createNode();
			node.setId(i);
			node.setRepresentative(list.get(i));
			nodes[i] = node;
		}
		showProgress.update(nodes.length);
		showProgress.done();
		return nodes;
	}

	private Edge[][] getDistanceMatrixAsArray(List<ZMIEdge> zmiEdges, int n) throws Exception {
		Edge[][] matrix = new EdgeImpl[n][n];
		ProgressBar showProgress = Utils.showProgress((int) Math.pow(n, 2));
		Iterator<ZMIEdge> iterator = zmiEdges.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			ZMIEdge zmiEdge = iterator.next();
			int originId = zmiEdge.getOriginId();
			int destId = zmiEdge.getDestId();
			int distance = zmiEdge.getDistance();
			int time = zmiEdge.getTime();
			if (originId < n && destId < n) {
				showProgress.update(++i);
				matrix[originId][destId] = networkFactory.createEdge();
				Edge edge = matrix[originId][destId];
				edge.setTime(time);
				edge.setDistance(distance);
				edge.setId(originId + "-" + destId);
			}
		}
		showProgress.done();
		return matrix;
	}
}
