package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Solution;

public class Diversifier {
	private Solution initialSolution;
	private NeighborhoodStructure neighborhoodStructure;
	private CostFunction f;
	private Restrictions restrictions;

	public Diversifier(NeighborhoodStructure neighborhoodStructure, Solution initialSolution, CostFunction f,
			Restrictions restrictions) {
		this.initialSolution = initialSolution;
		this.neighborhoodStructure = neighborhoodStructure;
		this.restrictions = restrictions;
		this.f = f;
	}

	public Solution diversify(int size) throws Exception {
		Moves moves = neighborhoodStructure.toShuffledList(initialSolution, size);
		return moves.applySequentially(restrictions, false);
	}
}
