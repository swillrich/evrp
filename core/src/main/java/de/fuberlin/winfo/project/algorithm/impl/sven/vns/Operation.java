package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class Operation {
	private Solution result;

	public abstract Solution apply(Solution solution) throws Exception;

	public abstract boolean isPreconditionSatisfied(Solution solution);

	public Solution getResult() {
		return result;
	}

	public void execute(Solution solution, boolean checkPrecondition) throws Exception {
		if (checkPrecondition && !isPreconditionSatisfied(solution)) {
			result = solution;
		} else {
			result = apply(solution);
		}
	}

}