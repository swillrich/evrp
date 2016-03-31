package de.fuberlin.winfo.project.algorithm.impl.ricosven;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.impl.ricosven.module.DCVRPTW;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TestRouting extends Algorithm {

	@Override
	public String getName() {
		return "test Routing (DCVRPTW)";
	}

	@Override
	public void run(Solution solution) throws Exception {
		Locatables locatables = networkProvider.getLocatables();
		Node depot = locatables.getMainDepotAsNode();
		List<Node> customerNodes = new ArrayList<>();
		customerNodes.addAll(locatables.getTranshipmentPointsAsNodes());
		customerNodes.addAll(locatables.getCustomerWithoutTranshipmentAsNodes());

		DCVRPTW alg = new DCVRPTW(networkProvider, this);

		List<Route> routes = alg.run(customerNodes, depot, solution.getUsecase().getVehicles().get(0));

		solution.getRoutes().addAll(routes);
	}

}
