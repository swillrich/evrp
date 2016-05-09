package de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure.ImprovementListener;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.algorithm.restriction.impl.SolutionCostRangeRestriction;
import de.fuberlin.winfo.project.model.network.Solution;

public class TabuSearch extends ArrayList<Tabu> {

	public Solution perturb(NeighborhoodStructure neighborhoodStructure, Solution initial, int countOfMoves)
			throws Exception {
		CostFunction f = neighborhoodStructure.getF();
		Restrictions restrictions = neighborhoodStructure.getRestrictions();
		VNSMonitor history = neighborhoodStructure.getHistory();

		System.out.println("PERTURBATION");
		SolutionCostRangeRestriction restriction = new SolutionCostRangeRestriction(initial, -0.10, 1, f);
		restrictions.add(restriction);
		Moves moves = neighborhoodStructure.toShuffledList(initial, countOfMoves);
		history.startLocalSearch(neighborhoodStructure, initial);
		Solution diversifiedSolution = moves.applySequentially(initial, restrictions, false);
		history.neighborChange(neighborhoodStructure, diversifiedSolution,
				"Exit LO (" + (countOfMoves - moves.size()) + "/" + countOfMoves + ")");
		history.finishedLocalSearch(neighborhoodStructure, initial, diversifiedSolution, countOfMoves, false);
		restrictions.remove(restriction);
		return diversifiedSolution;
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
			return !TabuSearch.this.isTabu(move.getResult());
		}
	};

	private double computeSimilarity(Tabu tabu, Solution solution) {
		Solution tabuSol = tabu.getSolution();
		int size = tabuSol.getRoutes().size();
		if (solution.getRoutes().size() != size) {
			return 0;
		}

		int counter = size;
		for (int i = 0; i < solution.getRoutes().size(); i++) {
			if (solution.getRoutes().get(i).getWay().size() != tabuSol.getRoutes().get(i).getWay().size()) {
				counter--;
			}
		}
		return (double) counter / (double) size;
	}

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
		return computeSimilarity(max, solution) > 0.25;
	}

	public void taboo(Solution solution) {
		Tabu tabu = new Tabu(solution);
		add(tabu);
	}
}
