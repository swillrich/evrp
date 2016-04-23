package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class Operation {
	private Solution result;

	public abstract Solution apply(Solution solution) throws Exception;

	public void execute(Solution solution) throws Exception {
		if (isPreconditionSatisfied(solution)) {
			result = apply(solution);
		} else {
			result = solution;
		}
	}

	public abstract boolean isPreconditionSatisfied(Solution solution);

	public Solution getResult() {
		return result;
	}

}