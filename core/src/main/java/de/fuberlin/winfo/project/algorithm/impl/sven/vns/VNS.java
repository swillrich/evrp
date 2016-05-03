package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class VNS {
	private CostFunction f;
	private NeighborhoodStructure[] neighborhoodStructures;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		this.f = f;
		this.neighborhoodStructures = neighborhoodStructures;
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, history, f));
	}

	public Solution run(Solution bestSolution) {
		int k = 0;
		neighborhoodStructures[0].shake(bestSolution);
		do {
			Solution bestNeighbor = neighborhoodStructures[k].search(bestSolution);
			if (f.getImprovementRatio(bestSolution, bestNeighbor) > f.acceptanceThreshold()) {
				k = 0;
				bestSolution = bestNeighbor;
			} else {
				k++;
			}
		} while (k < neighborhoodStructures.length);
		return bestSolution;
	}
}
