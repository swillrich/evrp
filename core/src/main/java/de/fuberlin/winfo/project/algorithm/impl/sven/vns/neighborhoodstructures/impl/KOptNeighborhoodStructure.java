package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import java.util.List;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristicRouteAdapter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class KOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current;
	private KOptHeuristic kOptHeuristic;
	private KOptOptions options;
	private List<Pair> pairs;
	protected int k;

	public KOptNeighborhoodStructure(int k) {
		this.k = k;
	}

	@Override
	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		super.setUp(np, history, f);
		setApplyOperationList();
	}

	@Override
	public void initSearch() {
		kOptHeuristic = null;
		options = null;
		pairs = null;
		current = -1;
		initNext();
	}

	@Override
	public String getName() {
		return k + "-Opt";
	}

	@Override
	public boolean hasNext() {
		return hasNextRoute() || hasNextK() || hasNextOption() || hasNextPairs();
	}

	private boolean hasNextK() {
		return kOptHeuristic != null && kOptHeuristic.hasNext();
	}

	private boolean hasNextPairs() {
		return pairs != null && !pairs.isEmpty();
	}

	private boolean hasNextOption() {
		return options != null && !options.isEmpty();
	}

	private boolean hasNextRoute() {
		return current + 1 < initialSol.getRoutes().size();
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		if (initNext()) {
			return actualMove(solution);
		} else {
			return NeighborhoodOperation.getBlank();
		}
	}

	private boolean initNext() {
		if (hasNextPairs()) {
			return true;
		} else if (hasNextOption()) {
			pairs = options.remove(0);
			return true;
		} else if (hasNextK()) {
			options = kOptHeuristic.next();
			return initNext();
		} else if (hasNextRoute()) {
			current++;
			try {
				List<Pair> pairs = KOptHeuristicRouteAdapter.getPairs(initialSol.getRoutes().get(current));
				kOptHeuristic = new KOptHeuristic(k, pairs);
				return initNext();
			} catch (Exception e) {
				return initNext();
			}
		} else {
			return false;
		}
	}

	private KOptNeighborhoodOperation actualMove(Solution solution) throws Exception {
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getArcs());
		List<UsedArc> newUsedArcList = KOptHeuristicRouteAdapter.getRoute(networkProvider, wrapper, pairs);
		pairs = null;
		return new KOptNeighborhoodOperation(current, newUsedArcList, options.getToReplace(),
				networkProvider.getArcs());
	}
}
