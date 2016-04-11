package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {
	public TwoOptNeighborhoodStructure(NetworkProvider np) {
		super(np);
	}

	@Override
	public String getName() {
		return "2-Opt";
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Solution move(Solution solution) {
		return null;
	}
}
