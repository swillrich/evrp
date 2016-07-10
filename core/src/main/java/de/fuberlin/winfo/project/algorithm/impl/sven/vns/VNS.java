package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch.TabuSearch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("unused")
public class VNS {
	private CostFunction f;
	private NeighborhoodStructure[] neighborhoodStructures;
	private NeighborhoodStructure[] perturbationNeighborhoodStructures;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		this.f = f;
		this.neighborhoodStructures = neighborhoodStructures;
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, history, f));
	}

	public Solution run(Solution globalOptima) throws Exception {
		int iterations = 10;
		int u = 0;
		TabuSearch tabuSearch = new TabuSearch(f, 0.7, 10);
		Solution localOptima = globalOptima;
		TS: do {
			int k = 0;
			VNS: do {
				Solution bestNeighbor = tabuSearch.searchForBestNonTabuMove(neighborhoodStructures[k], localOptima);
				if (f.isImprovement(localOptima, bestNeighbor)) {
					localOptima = bestNeighbor;
					k = 0;
				} else {
					k++;
				}
			} while (k < neighborhoodStructures.length);
			tabuSearch.taboo(localOptima);
			if (f.isImprovement(globalOptima, localOptima)) {
				globalOptima = localOptima;
				u = 0;
			} else {
				u++;
			}
			if (u < iterations) {
				localOptima = tabuSearch.perturb(-0.20, neighborhoodStructures, globalOptima, 300);
			}
		} while (u < iterations);
		return globalOptima;
	}
}
