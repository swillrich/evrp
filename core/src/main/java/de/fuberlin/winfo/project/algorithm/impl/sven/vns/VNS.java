package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class VNS {
	private CostFunction f;
	private TabuSearch[] tabuSearch;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		this.f = f;
		tabuSearch = new TabuSearch[neighborhoodStructures.length];
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, history, f));
		IntStream.range(0, tabuSearch.length).forEach(i -> tabuSearch[i] = new TabuSearch(neighborhoodStructures[i]));
	}

	public Solution run(Solution bestSolution) throws Exception {
		int k = 0;
		VNS: do {
			Solution initialSolution = bestSolution;
			int u = 0;
			do {
				Solution bestNeighbor = tabuSearch[k].search(initialSolution);
				if (f.isImprovement(bestSolution, bestNeighbor)) {
					k = 0;
					bestSolution = bestNeighbor;
					continue VNS;
				} else {
					initialSolution = tabuSearch[k].perturb(bestSolution, 500);
					u++;
				}
			} while (u < 10);
			k++;
		} while (k < tabuSearch.length);
		return bestSolution;
	}
}
