package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Solution;

public class InterRouteSingleNodeRelocationNeighborhoodStructure extends NeighborhoodStructure {

	private int route;
	private int node;
	private int neighborRoute;
	private int neighborNode;
	private Arc[][] A;

	@Override
	public void initNewSearch(Solution solution) {
		super.initNewSearch(solution);
		A = networkProvider.getArcs();
		route = 0;
		node = 0;
		neighborRoute = 0;
		neighborNode = 0;
	}

	@Override
	public boolean hasNext() {
		return hasNextRoute() || hasNextNode() || hasNextNeighborRoute() || hasNextNeighborNode();
	}

	private boolean hasNextNode() {
		return node + 2 < initialSol.getRoutes().get(route).getWay().size();
	}

	private boolean hasNextRoute() {
		return route + 1 < initialSol.getRoutes().size();
	}

	private boolean hasNextNeighborRoute() {
		return neighborRoute + 1 < initialSol.getRoutes().size();
	}

	private boolean hasNextNeighborNode() {
		return neighborNode + 1 < initialSol.getRoutes().get(neighborRoute).getWay().size();
	}

	@Override
	public Move generateOperation(Solution solution) throws Exception {
		Move operation;
		if (initilizeNext() && route != neighborRoute) {
			operation = new InterRouteSingleNodeRelocationMove(route, node, neighborRoute,
					neighborNode, A);
		} else {
			operation = new Move() {
				@Override
				public Solution apply(Solution solution) throws Exception {
					return solution;
				}

				@Override
				public boolean isPreconditionSatisfied(Solution solution) {
					return true;
				}

				@Override
				public int operationHash() {
					return 0;
				}
			};
		}
		neighborNode++;
		return operation;
	}

	private boolean initilizeNext() {
		if (hasNextNeighborNode()) {
			return true;
		} else if (hasNextNeighborRoute()) {
			neighborRoute++;
			neighborNode = 0;
			return initilizeNext();
		} else if (hasNextNode()) {
			node++;
			neighborNode = 0;
			neighborRoute = 0;
			return initilizeNext();
		} else if (hasNextRoute()) {
			route++;
			node = 0;
			neighborNode = 0;
			neighborRoute = 0;
			return initilizeNext();
		} else {
			return false;
		}
	}

	@Override
	public String getName() {
		return "IRSNR";
	}
}
