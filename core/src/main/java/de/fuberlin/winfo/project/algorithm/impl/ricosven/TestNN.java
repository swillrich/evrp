package de.fuberlin.winfo.project.algorithm.impl.ricosven;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.impl.ricosven.module.NearesNeighbor;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TestNN extends Algorithm {

	@Override
	public String getName() {
		return "test NN";
	}

	@Override
	public void run(Solution solution) throws Exception {

		 Locatables locatables = networkProvider.getLocatables();
		 Node depot = locatables.getMainDepotAsNode();
		 List<Node> customerNodesWithoutTransipmentNodes =
		 locatables.getCustomerWithoutTranshipmentAsNodes();
		 List<Node> transhipmentNodes =
		 locatables.getTranshipmentPointsAsNodes();
		 List<Node> customerNodes = new ArrayList<>();
		 customerNodes.addAll(transhipmentNodes);
		 customerNodes.addAll(customerNodesWithoutTransipmentNodes);
		
		 NearesNeighbor nN = new NearesNeighbor(networkProvider, this);
		 Route route = nN.run(customerNodes, depot);
		
		 solution.getRoutes().add(route);
	}

}
