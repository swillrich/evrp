package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {

	public TwoOptNeighborhoodStructure(NetworkProvider np, Solution s) {
		super(np);
	}

	@Override
	public String getName() {
		return "2-opt";
	}

	@Override
	public Solution move(Solution x) {
		return x;
	}

}
