package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristicRouteAdapter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractRandomizedNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class RandomizedKOptNeighborhoodStructure extends AbstractRandomizedNeighborhoodStructure {

	private int k;
	private Map<Integer, KOptHeuristic> routeKOptMap;
	private Map<Integer, List<KOptOptions>> routeOptions;
	private List<Integer> routesLeft;
	private Arc[][] A;

	public RandomizedKOptNeighborhoodStructure(int k, int iterations) {
		super(iterations);
		this.k = k;
	}

	@Override
	public void initNewSearch(Solution solution) {
		super.initNewSearch(solution);
		this.routeKOptMap = new HashMap<Integer, KOptHeuristic>();
		this.routeOptions = new HashMap<Integer, List<KOptOptions>>();
		this.routesLeft = new ArrayList<Integer>();
		this.A = networkProvider.getArcs();
		IntStream.range(0, initialSol.getRoutes().size()).forEach(i -> routeKOptMap.put((Integer) i, null));
		IntStream.range(0, initialSol.getRoutes().size()).forEach(i -> routesLeft.add(i));
	}

	@Override
	protected NeighborhoodOperation generateRandomOperation(Solution solution) {
		if (routesLeft.isEmpty()) {
			return NeighborhoodOperation.getBlank();
		}
		int routeRouteIndex = random.nextInt(routesLeft.size());
		Integer routeIndex = this.routesLeft.get(routeRouteIndex);
		KOptOptions options = getOptions(solution, routeIndex);

		if (options == null) {
			routeKOptMap.remove((Integer) routeIndex);
			routesLeft.remove(routeRouteIndex);
			return NeighborhoodOperation.getBlank();
		} else {
			int nextInt = random.nextInt(options.size());
			List<Pair> pairs = options.remove(nextInt);
			RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(routeIndex), null, A);
			List<UsedArc> subWay = KOptHeuristicRouteAdapter.getRoute(networkProvider, wrapper, pairs);
			return new KOptNeighborhoodOperation(routeIndex, subWay, options.getToReplace(), A);
		}
	}

	private KOptOptions getOptions(Solution solution, int routeIndex) {
		KOptHeuristic heuristic = routeKOptMap.get(routeIndex);
		if (heuristic == null) {
			List<Pair> pairs = KOptHeuristicRouteAdapter.getPairs(solution.getRoutes().get(routeIndex));
			try {
				heuristic = new KOptHeuristic(k, pairs);
			} catch (Exception e) {
				return null;
			}
			routeKOptMap.put(routeIndex, heuristic);
			routeOptions.put(routeIndex, new ArrayList<KOptOptions>());
		}
		List<KOptOptions> list = routeOptions.get(routeIndex);
		return nextRandom(heuristic, list);
	}

	private KOptOptions nextRandom(KOptHeuristic heuristic, List<KOptOptions> list) {
		if (list.isEmpty()) {
			for (int i = 0; i < 3000 && heuristic.hasNext(); i++) {
				list.add(heuristic.next());
			}
			if (list.isEmpty()) {
				return null;
			} else {
				return nextRandom(heuristic, list);
			}
		} else {
			while (true) {
				int rndInt = random.nextInt(list.size());
				KOptOptions options = list.get(random.nextInt(list.size()));
				if (!options.isEmpty()) {
					return options;
				} else {
					list.remove(rndInt);
				}
				if (list.isEmpty()) {
					break;
				}
			}
			return nextRandom(heuristic, list);
		}
	}

	@Override
	public String getName() {
		return "R-" + k + "-Opt";
	}

}
