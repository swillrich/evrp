package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute;

import java.util.List;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristicRouteAdapter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
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
	public void initNewSearch(Solution solution) {
		super.initNewSearch(solution);
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
	public Move generateOperation(Solution solution) throws Exception {
		if (initNext()) {
			return actualMove(solution);
		} else {
			return Move.getBlank();
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

	private KOptMove actualMove(Solution solution) throws Exception {
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getArcs());
		List<UsedArc> newUsedArcList = KOptHeuristicRouteAdapter.getRoute(networkProvider, wrapper, pairs);
		pairs = null;
		return new KOptMove(current, newUsedArcList, options.getToReplace(),
				networkProvider.getArcs());
	}

	@Override
	public boolean isInterRouteRelated() {
		return false;
	}
}
