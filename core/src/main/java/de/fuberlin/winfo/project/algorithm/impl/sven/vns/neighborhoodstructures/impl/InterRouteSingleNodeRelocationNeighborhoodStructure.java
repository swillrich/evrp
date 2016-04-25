package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class InterRouteSingleNodeRelocationNeighborhoodStructure extends NeighborhoodStructure {

	private int route;
	private int node;
	private int neighborRoute;
	private int neighborNode;
	private Edge[][] E;

	@Override
	public void initSearch() {
		E = networkProvider.getEdges();
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
	public String getName() {
		return "Inter-route single node relocation";
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		NeighborhoodOperation operation;
		if (initilizeNext() && route != neighborRoute) {
			operation = new InterRouteSingleNodeRelocationNeighborhoodOperation(route, node, neighborRoute, neighborNode, E);
		} else {
			operation = new NeighborhoodOperation() {
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
