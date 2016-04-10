package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Comparator;

import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class CostFunction implements Comparator<Solution>{

	@Override
	public int compare(Solution sol1, Solution sol2) {
		return Integer.compare(compute(sol1), compute(sol2));
	}
	
	public abstract int compute(Solution s);
}
