package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractStochasticNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Solution;

public class StochasticInterRouteSingleNodeRelocationNeighborhoodStructure
		extends AbstractStochasticNeighborhoodStructure {

	public StochasticInterRouteSingleNodeRelocationNeighborhoodStructure(int iterations) {
		super(iterations);
	}

	@Override
	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		super.setUp(np, history, f);
		isApplyOperationList = true;
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
		return "S-IRSNR";
	}
}
