package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodOperation {
	private Solution result;

	public abstract Solution apply(Solution solution) throws Exception;

	public abstract boolean isPreconditionSatisfied(Solution solution);

	public abstract int operationHash();

	public Solution getResult() {
		return result;
	}

	public Solution execute(Solution solution, boolean checkPrecondition) throws Exception {
		Solution copy = Algorithm.getCopy(solution);
		if (checkPrecondition && !isPreconditionSatisfied(copy)) {
			result = copy;
		} else {
			result = apply(copy);
		}
		return result;
	}

	public static NeighborhoodOperation getBlank() {
		return new NeighborhoodOperation() {

			@Override
			public int operationHash() {
				return 0;
			}

			@Override
			public boolean isPreconditionSatisfied(Solution solution) {
				return false;
			}

			@Override
			public Solution apply(Solution solution) throws Exception {
				return solution;
			}
		};
	}
}