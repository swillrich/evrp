package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractRandomizedNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.model.network.Solution;

public class RandomizedInterRouteSingleNodeRelocationNeighborhoodStructure
		extends AbstractRandomizedNeighborhoodStructure {

	public RandomizedInterRouteSingleNodeRelocationNeighborhoodStructure(int iterations) {
		super(iterations);
	}

	@Override
	protected Move generateRandomOperation(Solution solution) {
		int routesN = solution.getRoutes().size();

		int rndRoute = random.nextInt(routesN);
		int rndNode = random.nextInt(solution.getRoutes().get(rndRoute).getWay().size() - 1);
		int rndNeighborRoute = -1;

		do {
			rndNeighborRoute = random.nextInt(routesN);
		} while (rndNeighborRoute == rndRoute);

		int rndNeighborNode = random.nextInt(solution.getRoutes().get(rndNeighborRoute).getWay().size() - 1);

		return new InterRouteSingleNodeRelocationMove(rndRoute, rndNode, rndNeighborRoute,
				rndNeighborNode, networkProvider.getArcs());
	}

	@Override
	public String getName() {
		return "R-IRSNR";
	}

	@Override
	public boolean isInterRouteRelated() {
		return true;
	}
}
