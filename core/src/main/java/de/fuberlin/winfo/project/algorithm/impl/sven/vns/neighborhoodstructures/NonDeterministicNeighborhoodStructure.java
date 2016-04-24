package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NonDeterministicNeighborhoodStructure extends NeighborhoodStructure {

	protected int maxIterations;
	protected Random random = new Random();
	protected Set<Integer> randomlyUsedOperations;

	protected abstract NeighborhoodOperation generateRandomOperation(Solution solution);

	public NonDeterministicNeighborhoodStructure(int maxIterations) {
		this.maxIterations = maxIterations;
	}

	@Override
	public boolean hasNext() {
		return randomlyUsedOperations.size() < maxIterations;
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		NeighborhoodOperation generateRandomOperation;
		do {
			generateRandomOperation = generateRandomOperation(solution);
		} while (randomlyUsedOperations.contains(generateRandomOperation.operationHash()));
		randomlyUsedOperations.add(generateRandomOperation.operationHash());
		return generateRandomOperation;
	}

	@Override
	public void initSearch() {
		randomlyUsedOperations = new TreeSet<Integer>();
	}
}
