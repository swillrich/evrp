package de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import de.fuberlin.winfo.project.Random;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.impl.sven.SvensAlg;
import de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch.Tabu.PositionedArc;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure.ImprovementListener;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.algorithm.restriction.impl.SolutionCostRangeRestriction;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class TabuSearch extends ArrayList<Tabu> {

	private double tabooThreshold;
	private int maxSize;
	private CostFunction f;

	public TabuSearch(CostFunction f, double tabooThreshold, int maxCache) {
		this.tabooThreshold = tabooThreshold;
		this.maxSize = maxCache;
		this.f = f;
	}

	public Solution perturb(double maxDeterioration, NeighborhoodStructure[] neighborhoodStructures, Solution initial,
			int countOfMoves) throws Exception {
		Moves moves = new Moves();
		SolutionCostRangeRestriction restriction = new SolutionCostRangeRestriction(initial, maxDeterioration, 1,
				neighborhoodStructures[0].getF());
		Restrictions restrictions = neighborhoodStructures[0].getRestrictions();
		restrictions.add(restriction);
		for (NeighborhoodStructure nh : neighborhoodStructures) {
			if (nh.isInterRouteRelated()) {
				moves.addAll(nh.toList(initial, countOfMoves / neighborhoodStructures.length));
			}
		}
		Collections.shuffle(moves, Random.get());
		Solution diversifiedSolution = moves.applySequentially(initial, restrictions, false);
		restrictions.remove(restriction);
		Algorithms.get(SvensAlg.class).addEvent(EventType.PERTURBATION, diversifiedSolution,
				"(" + (countOfMoves - moves.size()) + "/" + countOfMoves + ")");
		return diversifiedSolution;
	}

	private void refresh() {
		Collections.sort(this, new Comparator<Tabu>() {
			@Override
			public int compare(Tabu arg0, Tabu arg1) {
				return f.compare(arg0.solution, arg1.solution);
			}
		});
		for (int i = 0; i < size(); i++) {
			Tabu tabu = get(i);
			int x = i + (maxSize - size());
			int n = (int) (tabu.size() / (double) Math.pow(2, x));
			tabu.removeRandomized(n);
		}
		removeIf(e -> e.size() == 0);
	}

	public Solution searchForBestNonTabuMove(NeighborhoodStructure neighborhoodStructure, Solution localOptima)
			throws Exception {
		neighborhoodStructure.getImprovementListener().add(improvementListener);
		Solution bestNonTabuMove = neighborhoodStructure.search(localOptima);
		neighborhoodStructure.getImprovementListener().remove(improvementListener);
		return bestNonTabuMove;
	}

	private ImprovementListener improvementListener = new ImprovementListener() {
		@Override
		public boolean acceptImprovement(Move move) throws RuntimeException {
			boolean b = !TabuSearch.this.isTabu(move.getResult());
			return b;
		}
	};

	protected boolean isTabu(Solution solution) {
		if (this.size() == 0) {
			return false;
		}
		Tabu max;
		if (this.size() == 1) {
			max = get(0);
		} else {
			max = Collections.max(this, new Comparator<Tabu>() {
				@Override
				public int compare(Tabu o1, Tabu o2) {
					double similarity = computeSimilarity(o1, solution);
					double similarity2 = computeSimilarity(o2, solution);
					return Double.compare(similarity, similarity2);
				}
			});
		}
		double a = computeSimilarity(max, solution);
		return a > tabooThreshold;
	}

	int i;

	public void taboo(Solution solution) {
		Tabu tabu = new Tabu(solution);
		add(tabu);
		System.out.println("TS iteration: " + (++i));
		refresh();
		while (maxSize < size()) {
			remove(size() - 1);
		}
	}

	private double computeSimilarity(Tabu tabu, Solution solution) {
		Solution tabuSol = tabu.getSolution();
		int size = tabuSol.getRoutes().size();
		if (solution.getRoutes().size() != size) {
			return 0;
		}

		int numberOfArcsWithSamePosition = tabu.size();
		for (int i = 0; i < solution.getRoutes().size(); i++) {
			Route route = solution.getRoutes().get(i);
			for (int j = 0; j < route.getWay().size(); j++) {
				UsedArc usedArc = route.getWay().get(j);
				PositionedArc positionedArc = tabu.get(usedArc.getArc());
				if (positionedArc != null && (positionedArc.getRoute() != i || positionedArc.getIndex() != j)) {
					numberOfArcsWithSamePosition--;
				}
			}
		}
		return numberOfArcsWithSamePosition / (double) tabu.size();
	}
}
