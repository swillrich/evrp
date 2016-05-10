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

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures, VNSMonitor history) {
		this.f = f;
		this.neighborhoodStructures = neighborhoodStructures;
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, history, f));
	}

	public Solution run(Solution globalOptima) throws Exception {
		int u = 0;
		TabuSearch tabuSearch = new TabuSearch(0.7);
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
			if (f.isImprovement(globalOptima, localOptima)) {
				tabuSearch.taboo(localOptima);
				globalOptima = localOptima;
			}
			localOptima = tabuSearch.perturb(-0.2, neighborhoodStructures[0], globalOptima, 500);
		} while (u++ < 5);
		return globalOptima;
	}
}
