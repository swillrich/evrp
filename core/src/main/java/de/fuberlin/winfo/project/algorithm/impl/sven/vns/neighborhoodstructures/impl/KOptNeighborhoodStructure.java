package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vertex;

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
	public void initSearch() {
		kOptHeuristic = null;
		options = null;
		pairs = null;
		current = -1;
		initNext();
	}

	@Override
	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		applyOperationList();
		double ratio = costFunction.getImprovementRatio(initialSol, this.incumbentSol);
		if (ratio < 0.01) {
			return initialSol;
		} else {
			return this.incumbentSol;
		}

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
				List<Pair> pairs = getPairs(initialSol.getRoutes().get(current));
				kOptHeuristic = new KOptHeuristic(k, pairs);
				return initNext();
			} catch (Exception e) {
				return initNext();
			}
		} else {
			return false;
		}
	}

	private KoptNeighborhoodOperation actualMove(Solution solution) throws Exception {
		Vertex[] V = networkProvider.getVertices();
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getArcs());
		int[] toReplace = this.options.getToReplace();
		List<UsedArc> newUsedArcList = new ArrayList<UsedArc>();
		for (int i = 0; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			Vertex startOrder = V[pair.getStart()];
			Vertex endOrder = V[pair.getEnd()];
			Arc arc = networkProvider.getArcs()[startOrder.getId()][endOrder.getId()];
			UsedArc newArc = wrapper.initializeUsedArc(arc);
			newUsedArcList.add(newArc);
			if (i < pairs.size() - 1) {
				Vertex startV = V[pair.getEnd()];
				Vertex endV = V[pairs.get(i + 1).getStart()];
				List<UsedArc> usedArcsBetween = wrapper.getUsedArcsBetween(startV, endV);
				newUsedArcList.addAll(usedArcsBetween);
			}
		}
		pairs = null;
		return new KoptNeighborhoodOperation(current, newUsedArcList, toReplace, networkProvider.getArcs());
	}

	private List<Pair> getPairs(Route route) {
		List<Pair> l = new ArrayList<Pair>();
		for (UsedArc usedArc : route.getWay()) {
			final Arc arc = usedArc.getArc();
			l.add(new Pair() {

				@Override
				public int getStart() {
					return arc.getStart().getId();
				}

				@Override
				public int getEnd() {
					return arc.getEnd().getId();
				}
			});
		}
		return l;
	}

}
