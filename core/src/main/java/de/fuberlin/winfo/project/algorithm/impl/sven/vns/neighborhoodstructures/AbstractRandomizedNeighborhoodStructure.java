package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.model.network.Solution;

public abstract class AbstractRandomizedNeighborhoodStructure extends NeighborhoodStructure {

	private int maxIterations;
	protected Random random = new Random();
	private Set<Integer> randomlyUsedOperations;

	protected abstract NeighborhoodOperation generateRandomOperation(Solution solution);

	public AbstractRandomizedNeighborhoodStructure(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public boolean hasNext() {
		return iterations < maxIterations;
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		iterations--;
		NeighborhoodOperation generateRandomOperation;
		do {
			generateRandomOperation = generateRandomOperation(solution);
			iterations++;
		} while (hasNext() && randomlyUsedOperations.contains(generateRandomOperation.operationHash()));
		randomlyUsedOperations.add(generateRandomOperation.operationHash());
		return generateRandomOperation;
	}

	@Override
	public void initSearch() {
		super.initSearch();
		random.setSeed(0);
		randomlyUsedOperations = new TreeSet<Integer>();
		randomlyUsedOperations.add(0);
	}
}
