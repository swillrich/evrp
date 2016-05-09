package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure.ImprovementListener;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.algorithm.restriction.impl.SolutionCostRangeRestriction;
import de.fuberlin.winfo.project.model.network.Solution;

public class TabuSearch extends TreeSet<Move> {

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
		public boolean acceptImprovement(Solution solution) throws RuntimeException {
			return true;
		}
	};
}
