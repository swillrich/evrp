package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNS {
	public static Solution vns(NetworkProvider np, CostFunction f, Solution bestSolution,
			NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		int k = 0;
		do {
			neighborhoodStructures[k].setUp(np, history, f);
			Solution initialSolution = neighborhoodStructures[k].shake(bestSolution);
			Solution bestNeighbor = neighborhoodStructures[k].search(initialSolution);
			history.vnsSearch(neighborhoodStructures[k], k, bestSolution, bestNeighbor);
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
