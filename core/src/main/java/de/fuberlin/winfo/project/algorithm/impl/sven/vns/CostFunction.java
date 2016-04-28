package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Comparator;

import de.fuberlin.winfo.project.model.network.Solution;

public abstract class CostFunction implements Comparator<Solution> {

	@Override
	public int compare(Solution previous, Solution candidate) {
		return Long.compare(compute(previous), compute(candidate));
	}

	public abstract int compute(Solution s);

	public double getImprovementRatio(Solution incumbent, Solution candidate) {
		int can = compute(candidate);
		int inc = compute(incumbent);
		int diff = inc - can;
		return (double) diff / (double) inc;
	}

	public abstract double acceptanceThresold();
}
