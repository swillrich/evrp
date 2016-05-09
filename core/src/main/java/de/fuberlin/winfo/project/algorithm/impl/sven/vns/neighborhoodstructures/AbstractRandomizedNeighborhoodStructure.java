package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Set;
import java.util.TreeSet;

import de.fuberlin.winfo.project.Random;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class AbstractRandomizedNeighborhoodStructure extends NeighborhoodStructure {

	private int maxIterations;
	protected Random random = Random.get();
	private Set<Integer> randomlyUsedOperations;

	protected abstract Move generateRandomOperation(Solution solution);

	public AbstractRandomizedNeighborhoodStructure(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public boolean hasNext() {
		return iterations < maxIterations;
	}

	@Override
	public Move generateOperation(Solution solution) throws Exception {
		iterations--;
		Move generateRandomOperation;
		do {
			generateRandomOperation = generateRandomOperation(solution);
			iterations++;
		} while (hasNext() && randomlyUsedOperations.contains(generateRandomOperation.operationHash()));
		randomlyUsedOperations.add(generateRandomOperation.operationHash());
		return generateRandomOperation;
	}

	@Override
	public void initNewSearch(Solution solution) {
		super.initNewSearch(solution);
		randomlyUsedOperations = new TreeSet<Integer>();
		randomlyUsedOperations.add(0);
	}
}
