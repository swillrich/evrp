package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
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
	public Solution move(Solution solution) throws Exception {
		initilizeNext();
		RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(route), null, E);
		RouteWrapper neighborWrapper = new RouteWrapper(solution.getRoutes().get(neighborRoute), null, E);
		wrapper.relocateSingleNode(node, neighborWrapper, neighborNode);
		return solution;
	}

	private void initilizeNext() {
		if (hasNextNeighborNode()) {
			neighborNode++;
		} else if (hasNextNeighborRoute()) {
			neighborRoute++;
			neighborNode = 0;
		} else if (hasNextNode()) {
			node++;
			neighborNode = 0;
			neighborRoute = 0;
		} else if (hasNextRoute()) {
			route++;
			node = 0;
			neighborNode = 0;
			neighborRoute = 0;
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

}
