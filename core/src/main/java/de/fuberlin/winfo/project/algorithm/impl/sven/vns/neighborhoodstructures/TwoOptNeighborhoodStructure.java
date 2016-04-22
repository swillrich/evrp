package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure extends KOptNeighborhoodStructure {

	public TwoOptNeighborhoodStructure() {
		super(2);
	}
	
	@Override
	protected Solution shakeProcedure(Solution sol) {
		return sol;
	}
}
