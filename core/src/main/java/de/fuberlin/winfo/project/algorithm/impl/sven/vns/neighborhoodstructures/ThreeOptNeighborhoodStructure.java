package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.model.network.solution.Solution;

public class ThreeOptNeighborhoodStructure extends KOptNeighborhoodStructure {

	public ThreeOptNeighborhoodStructure() {
		super(3);
	}

	@Override
	protected Solution shakeProcedure(Solution sol) {
		return sol;
	}
}
