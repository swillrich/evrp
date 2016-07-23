package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.SvensAlg;
import de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch.TabuSearch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("unused")
public class VNS {
	private CostFunction f;
	private NeighborhoodStructure[] neighborhoodStructures;
	private NeighborhoodStructure[] perturbationNeighborhoodStructures;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures) {
		this.f = f;
		this.neighborhoodStructures = neighborhoodStructures;
		Arrays.stream(neighborhoodStructures).forEach(n -> n.setUp(np, f));
	}

	public Solution run(Solution globalOptima) throws Exception {
		int iterations = 3;
		int u = 0;
		TabuSearch tabuSearch = new TabuSearch(f, 0.9, 5);
		Solution localOptima = globalOptima;
		TS: do {
			int k = 0;
			VNS: do {
				Solution bestNeighbor = tabuSearch.searchForBestNonTabuMove(neighborhoodStructures[k], localOptima);
				if (f.isImprovement(localOptima, bestNeighbor)) {
					k = 0;
					Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, localOptima, "VNS RESET");
				} else {
					k++;
					Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, localOptima, "VNS NEXT");
				}
				if (f.compare(localOptima, bestNeighbor) > 0) {
					localOptima = bestNeighbor;
				}
			} while (k < neighborhoodStructures.length);
			tabuSearch.taboo(localOptima);
			if (f.isImprovement(globalOptima, localOptima)) {
				globalOptima = localOptima;
				u = 0;
				Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, localOptima, "TS RESET");
			} else {
				u++;
				Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, localOptima, "TS NEXT");
			}
			if (u < iterations) {
				localOptima = tabuSearch.perturb(-0.20, neighborhoodStructures, globalOptima, 300);
			}
		} while (u < iterations);
		return globalOptima;
	}
}
