package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Comparator;

import de.fuberlin.winfo.project.model.network.Solution;

public abstract class CostFunction implements Comparator<Solution> {

	@Override
	public int compare(Solution previous, Solution candidate) {
		return Long.compare(compute(previous), compute(candidate));
	}

	public abstract long compute(Solution s);

	public double getImprovementRatio(Solution incumbent, Solution candidate) {
		long can = compute(candidate);
		long inc = compute(incumbent);
		long diff = inc - can;
		return (double) diff / (double) inc;
	}

	public abstract double acceptanceThresold();
}
