package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNS {
	NetworkProvider networkProvider;

	public VNS(NetworkProvider networkProvider) {
		this.networkProvider = networkProvider;
	}

	public Solution vns(Solution bestSolution, NeighborhoodStructure[] neighborhoodStructures, CostFunction f) {
		int k = 0;
		do {
			Solution initialSolution = neighborhoodStructures[k].shake(bestSolution);
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
