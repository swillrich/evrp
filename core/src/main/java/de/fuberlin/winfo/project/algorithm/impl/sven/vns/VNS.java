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

	public Solution run(Solution bestSolution) throws Exception {
		int k = 0;
		do {
			Solution bestNeighbor = neighborhoodStructures[k].tabuSearch(bestSolution);
			if (f.isImprovement(bestSolution, bestNeighbor)) {
				k = 0;
				bestSolution = bestNeighbor;
			} else {
				k++;
			}
		} while (k < neighborhoodStructures.length);
		return bestSolution;
	}
}
