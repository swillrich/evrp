package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.HashSet;
import java.util.Set;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class InterRouteSingleNodeRelocationNeighborhoodOperation extends NeighborhoodOperation {

	private int route;
	private int node;
	private int neighborRoute;
	private int neighborNode;
	private Edge[][] E;

	public InterRouteSingleNodeRelocationNeighborhoodOperation(int route, int node, int neighborRoute, int neighborNode,
			Edge[][] E) {
		this.route = route;
		this.node = node;
		this.neighborNode = neighborNode;
		this.neighborRoute = neighborRoute;
		this.E = E;
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
		try {
			Set<Order> all = new HashSet<Order>();
			all.addAll(wrapper.getOrders());
			all.addAll(neighborWrapper.getOrders());
			if (all.size() < wrapper.getOrders().size() + neighborWrapper.getOrders().size()) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	@Override
	public int operationHash() {
		return new String("irsnrns" + route + node + neighborRoute + neighborNode).hashCode();
	}
}