package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Operation;
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
		neighborRoute = 1;
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
		return neighborNode + 2 < initialSol.getRoutes().get(neighborRoute).getWay().size();
	}

	@Override
	public String getName() {
		return "Inter-route single node relocation";
	}

	@Override
	protected Solution shakeProcedure(Solution solution) {
		return solution;
	}

	@Override
	public Operation generateOperation(Solution solution) throws Exception {
		Operation operation;
		if (initilizeNext()) {
			operation = new InterRouteSingleNodeRelocationOperation(route, node, neighborRoute, neighborNode);
		} else {
			operation = new Operation() {
				@Override
				public Solution apply(Solution solution) throws Exception {
					return solution;
				}

				@Override
				public boolean isPreconditionSatisfied(Solution solution) {
					return true;
				}
			};
		}
		return operation;
	}

	private class InterRouteSingleNodeRelocationOperation extends Operation {

		private int route;
		private int node;
		private int neighborRoute;
		private int neighborNode;

		public InterRouteSingleNodeRelocationOperation(int route, int node, int neighborRoute, int neighborNode) {
			this.route = route;
			this.node = node;
			this.neighborNode = neighborNode;
			this.neighborRoute = neighborRoute;
		}

		@Override
		public Solution apply(Solution solution) throws Exception {
			RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(route), null, E);
			RouteWrapper neighborWrapper = new RouteWrapper(solution.getRoutes().get(neighborRoute), null, E);
			wrapper.relocateSingleNode(node, neighborWrapper, neighborNode);
			return solution;
		}

		@Override
		public boolean isPreconditionSatisfied(Solution sol) {
			RouteWrapper wrapper = new RouteWrapper(sol.getRoutes().get(route), null, E);
			RouteWrapper neighborWrapper = new RouteWrapper(sol.getRoutes().get(neighborRoute), null, E);
			if (wrapper.getActualRoute().getWay().size() < node + 2) {
				return false;
			}
			if (neighborWrapper.getActualRoute().getWay().size() < neighborNode + 2) {
				return false;
			}
			return true;
		}
	}

	private boolean initilizeNext() {
		if (hasNextNeighborNode()) {
			neighborNode++;
			return true;
		} else if (hasNextNeighborRoute()) {
			neighborRoute++;
			if (neighborRoute == route) {
				if (neighborRoute + 1 >= initialSol.getRoutes().size()) {
					return false;
				} else {
					neighborRoute++;
					return initilizeNext();
				}
			}
			neighborNode = 0;
			return true;
		} else if (hasNextNode()) {
			node++;
			neighborNode = 0;
			neighborRoute = 0;
			return true;
		} else if (hasNextRoute()) {
			route++;
			node = 0;
			neighborNode = 0;
			neighborRoute = 0;
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected boolean onNonImprovement(Solution incumbentSol, Solution candidate) {
		return false;
	}

	@Override
	protected boolean onImprovement(Solution incumbent, Solution newSol) {
		return false;
	}
	
	@Override
	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		applyOperationList();
		return this.incumbentSol;
	}

}
