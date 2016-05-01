package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class VNS {
	private CostFunction f;
	private NeighborhoodStructure[] neighborhoodStructures;
	private Tabus tabus;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		this.f = f;
		this.neighborhoodStructures = neighborhoodStructures;
		this.tabus = new Tabus(f, 10);
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, history, f));
	}

	public Solution run(Solution bestSolution) {
		tabus.add(bestSolution);
		for (int i = 0; i < 10; i++) {
			Solution initialSol = neighborhoodStructures[0].shake(bestSolution);
			bestSolution = descend(initialSol, 0);
			tabus.add(bestSolution);
		}
		return tabus.getBest();
	}

	private Solution descend(Solution bestSolution, int k) {
		if (k >= neighborhoodStructures.length || tabus.contains(bestSolution)) {
			return bestSolution;
		}
		Solution bestNeighbor = neighborhoodStructures[k].search(bestSolution);
		k++;
		if (f.compare(bestSolution, bestNeighbor) > 0) {
			if (f.getImprovementRatio(bestSolution, bestNeighbor) >= f.acceptanceThreshold()) {
				k = 0;
			}
			bestSolution = bestNeighbor;
		}
		return descend(bestSolution, k);
	}
}
