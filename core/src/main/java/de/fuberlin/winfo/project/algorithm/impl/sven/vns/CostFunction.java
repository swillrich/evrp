package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Comparator;

import de.fuberlin.winfo.project.model.network.Solution;

public abstract class CostFunction implements Comparator<Solution> {

	public abstract double compute(Solution s);

	@Override
	public int compare(Solution s1, Solution s2) {
		if (s1 == null || s2 == null) {
			if (s1 == s2) {
				return 0;
			} else {
				return s1 == null ? 1 : -1;
			}
		}
		return Double.compare(compute(s1), compute(s2));
	}

	public double getImprovementRatio(Solution incumbent, Solution candidate) {
		double can = compute(candidate);
		double inc = compute(incumbent);
		double diff = inc - can;
		return diff / inc;
	}

	public abstract double acceptanceThreshold();

	public boolean isImprovement(Solution incumbent, Solution candidate) {
		return getImprovementRatio(incumbent, candidate) > acceptanceThreshold();
	}
}
