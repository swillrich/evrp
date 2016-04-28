package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristicRouteAdapter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractStochasticNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class StochasticKOptNeighborhoodStructure extends AbstractStochasticNeighborhoodStructure {

	private int k;
	private Map<Integer, KOptHeuristic> routeKOptMap;

	public StochasticKOptNeighborhoodStructure(int k, int interations) {
		super(interations);
		this.k = k;
	}

	@Override
	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		super.setUp(np, history, f);
		this.routeKOptMap = new HashMap<Integer, KOptHeuristic>();
		isApplyOperationList = true;
	}

	@Override
	protected NeighborhoodOperation generateRandomOperation(Solution solution) {
		Arc[][] A = networkProvider.getArcs();
		EList<Route> routes = solution.getRoutes();
		int routeIndex = random.nextInt(routes.size());
		KOptHeuristic heuristic = getHeuristic(routes, routeIndex);
		if (heuristic != null && heuristic.hasNext()) {
			KOptOptions next = heuristic.next();
			List<Pair> sequence = next.remove(0);
			RouteWrapper wrapper = new RouteWrapper(routes.get(routeIndex), null, A);
			List<UsedArc> subWay = KOptHeuristicRouteAdapter.getRoute(networkProvider, wrapper, sequence);
			return new KOptNeighborhoodOperation(routeIndex, subWay, next.getToReplace(), A);
		} else {
			return NeighborhoodOperation.getBlank();
		}
	}

	private KOptHeuristic getHeuristic(EList<Route> routes, int nextInt) {
		Route route = routes.get(nextInt);
		KOptHeuristic heuristic = routeKOptMap.get((Integer) nextInt);
		if (heuristic == null) {
			try {
				List<Pair> pairs = KOptHeuristicRouteAdapter.getPairs(route);
				heuristic = new KOptHeuristic(k, pairs);
				routeKOptMap.put(nextInt, heuristic);
			} catch (Exception e) {
				return null;
			}
		}
		return heuristic;
	}

	@Override
	public String getName() {
		return k + "-Opt";
	}

}
