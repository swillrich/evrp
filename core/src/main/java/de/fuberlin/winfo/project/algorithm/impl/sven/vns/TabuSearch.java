package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.algorithm.restriction.impl.SolutionCostRangeRestriction;
import de.fuberlin.winfo.project.model.network.Solution;

public class TabuSearch extends TreeSet<Move> {

	private NeighborhoodStructure neighborhoodStructure;
	private CostFunction f;
	private Restrictions restrictions;
	private VNSMonitor history;

	public TabuSearch(NeighborhoodStructure neighborhoodStructure) {
		this.neighborhoodStructure = neighborhoodStructure;
		this.f = neighborhoodStructure.getF();
		this.restrictions = neighborhoodStructure.getRestrictions();
		this.history = neighborhoodStructure.getHistory();
	}

	public Solution perturb(Solution initial, int countOfMoves) throws Exception {
		SolutionCostRangeRestriction restriction = new SolutionCostRangeRestriction(initial, -0.01, 1, f);
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

	public Solution search(Solution bestSolution) throws Exception {
		Solution bestNeighbor = neighborhoodStructure.search(bestSolution);
		return bestNeighbor;
	}
}
