package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractStochasticNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Solution;

public class StochasticInterRouteSingleNodeRelocationNeighborhoodStructure
		extends AbstractStochasticNeighborhoodStructure {

	public StochasticInterRouteSingleNodeRelocationNeighborhoodStructure() {
		super(10000);
	}

	@Override
	protected NeighborhoodOperation generateRandomOperation(Solution solution) {
		int routesN = solution.getRoutes().size();

		int rndRoute = random.nextInt(routesN);
		int rndNode = random.nextInt(solution.getRoutes().get(rndRoute).getWay().size() - 1);
		int rndNeighborRoute = -1;

		do {
			rndNeighborRoute = random.nextInt(routesN);
		} while (rndNeighborRoute == rndRoute);

		int rndNeighborNode = random.nextInt(solution.getRoutes().get(rndNeighborRoute).getWay().size() - 1);

		return new InterRouteSingleNodeRelocationNeighborhoodOperation(rndRoute, rndNode, rndNeighborRoute,
				rndNeighborNode, networkProvider.getArcs());
	}

	@Override
	public String getName() {
		return "Stoch. inter-route single node rel";
	}

	@Override
	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		applyOperationList();
		double diff = costFunction.getImprovementRatio(initialSol, this.incumbentSol);
		if (diff < 0.01) {
			return initialSol;
		} else {
			return this.incumbentSol;
		}
	}
}
