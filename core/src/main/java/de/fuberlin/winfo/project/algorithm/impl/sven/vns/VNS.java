package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class VNS {
	public static Solution vns(NetworkProvider np, CostFunction f, Solution bestSolution,
			NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		int k = 0;
		do {
			neighborhoodStructures[k].setUp(np, history, f);
			Solution bestNeighbor = neighborhoodStructures[k].search(bestSolution);
			if (f.getImprovementRatio(bestSolution, bestNeighbor) >= f.acceptanceThreshold()) {
				k = 0;
				bestSolution = bestNeighbor;
			} else {
				k = k + 1;
			}
		} while (k < neighborhoodStructures.length);
		return bestSolution;
	}
}
