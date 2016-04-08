package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure implements NeighborhoodStructure {

	@Override
	public String getName() {
		return "2-opt";
	}

	@Override
	public Solution searchNeighborhood(NetworkProvider np, Solution bestSolution) {

		return bestSolution;

	}

}
