package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vertex;

public class InterRouteSingleNodeRelocationMove extends Move {

	private int route;
	private int node;
	private int neighborRoute;
	private int neighborNode;
	private Arc[][] A;

	public InterRouteSingleNodeRelocationMove(int route, int node, int neighborRoute, int neighborNode,
			Arc[][] E) {
		this.route = route;
		this.node = node;
		this.neighborNode = neighborNode;
		this.neighborRoute = neighborRoute;
		this.A = E;
	}

	@Override
	public Solution apply(Solution solution) throws Exception {
		RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(route), null, A);
		RouteWrapper neighborWrapper = new RouteWrapper(solution.getRoutes().get(neighborRoute), null, A);
		wrapper.relocateSingleVertex(node, neighborWrapper, neighborNode);
		return solution;
	}

	@Override
	public boolean isPreconditionSatisfied(Solution sol) {
		if (sol.getRoutes().size() <= route || sol.getRoutes().size() <= neighborRoute) {
			return false;
		}
		RouteWrapper wrapper = new RouteWrapper(sol.getRoutes().get(route), null, A);
		RouteWrapper neighborWrapper = new RouteWrapper(sol.getRoutes().get(neighborRoute), null, A);
		if (wrapper.getActualRoute().getWay().size() < node + 2) {
			return false;
		}
		if (neighborWrapper.getActualRoute().getWay().size() < neighborNode + 2) {
			return false;
		}
		try {
			Set<Vertex> all = new HashSet<Vertex>();
			Collection<? extends Vertex> orders1 = wrapper.getOrders();
			Collection<? extends Vertex> orders2 = neighborWrapper.getOrders();
			all.addAll(orders1);
			all.addAll(orders2);
			if (all.size() < orders1.size() + orders2.size()) {
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