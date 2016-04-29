package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import de.fuberlin.winfo.project.model.network.Solution;

public abstract class AbstractStochasticNeighborhoodStructure extends NeighborhoodStructure {

	private int maxIterations;
	protected Random random = new Random();
	private Set<Integer> randomlyUsedOperations;
	private boolean isDone = false;

	protected abstract NeighborhoodOperation generateRandomOperation(Solution solution);

	public AbstractStochasticNeighborhoodStructure(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public boolean hasNext() {
		return randomlyUsedOperations.size() < maxIterations && !isDone;
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		NeighborhoodOperation generateRandomOperation;
		do {
			generateRandomOperation = generateRandomOperation(solution);
		} while (hasNext() && randomlyUsedOperations.contains(generateRandomOperation.operationHash()));
		randomlyUsedOperations.add(generateRandomOperation.operationHash());
		return generateRandomOperation;
	}

	@Override
	public void initSearch() {
		randomlyUsedOperations = new TreeSet<Integer>();
		randomlyUsedOperations.add(0);
		isDone = false;
	}

	public void isDone() {
		this.isDone = true;
	}
}
