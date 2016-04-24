package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class NonDeterministicInterRouteSingleNodeRelocationNeighborhoodStructure
		extends NonDeterministicNeighborhoodStructure {

	public NonDeterministicInterRouteSingleNodeRelocationNeighborhoodStructure() {
		super(5000);
	}

	@Override
	protected NeighborhoodOperation generateRandomOperation(Solution solution) {
		int routesN = solution.getRoutes().size();

		int rndRoute = random.nextInt(routesN);
		int rndNode = random.nextInt(solution.getRoutes().get(rndRoute).getWay().size() - 1);
		int rndNeighborRoute = -1;

		while (rndNeighborRoute != rndRoute) {
			rndNeighborRoute = random.nextInt(routesN);
		}
		int rndNeighborNode = random.nextInt(solution.getRoutes().get(rndNeighborRoute).getWay().size() - 1);

		return new InterRouteSingleNodeRelocationNeighborhoodOperation(rndRoute, rndNode, rndNeighborRoute,
				rndNeighborNode, networkProvider.getEdges());
	}

	@Override
	public String getName() {
		return "Non-det inter-route single node rel";
	}

}
