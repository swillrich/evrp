package de.fuberlin.winfo.project.algorithm.impl.ricosven;

import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.impl.ricosven.module.ClusterGenerator;
import de.fuberlin.winfo.project.algorithm.impl.ricosven.module.NearesNeighbor;
import de.fuberlin.winfo.project.algorithm.impl.ricosven.module.ClusterGenerator.Cluster;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TestClustering extends Algorithm {

	@Override
	public String getName() {
		return "test Cluster";
	}

	@Override
	public void run(Solution solution) throws Exception {

		ClusterGenerator generator = new ClusterGenerator(networkProvider,solution.getUsecase().getVehicles().get(0));
		List<Cluster> clusters = generator.getClusters();
		
		Locatables locatables = networkProvider.getLocatables();
		List<Node> transhipmentNodes = locatables.getTranshipmentPointsAsNodes();
		
		clusters.get(0).removeAll(transhipmentNodes);
		

		for (int i = 0; i < clusters.size(); i++) {
			if (clusters.get(i).size()>0){
				NearesNeighbor nN = new NearesNeighbor(networkProvider, this);
				Route route = nN.run(clusters.get(i), clusters.get(i).clusterCenterNode);
	
				solution.getRoutes().add(route);
			}
		}
	}

}
