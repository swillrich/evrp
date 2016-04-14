package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNS {
	public static Solution vns(NetworkProvider np, CostFunction f, Solution bestSolution,
			NeighborhoodStructure[] neighborhoodStructures) {
		int k = 0;
		do {
			neighborhoodStructures[k].init(np, bestSolution);
			Solution initialSolution = neighborhoodStructures[k].shake();
			Solution bestNeighbor = neighborhoodStructures[k].search(initialSolution, f);
			if (f.compare(bestSolution, bestNeighbor) > 0) {
				k = 0;
				bestSolution = bestNeighbor;
			} else {
				k = k + 1;
			}
		} while (k < neighborhoodStructures.length);
		return bestSolution;
	}
}
