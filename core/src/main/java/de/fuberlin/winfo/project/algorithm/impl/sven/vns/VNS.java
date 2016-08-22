package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.RouteReductionProcedure;
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
	private RouteReductionProcedure routeReductionProcedure;

	public VNS(NetworkProvider np, CostFunction f, NeighborhoodStructure[] neighborhoodStructures,
			RouteReductionProcedure routeReductionProcedure) {
		this.f = f;
		this.routeReductionProcedure = routeReductionProcedure;
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
				localOptima = routeReductionProcedure.reducingRoutes(localOptima, f);
				Solution bestNeighbor = tabuSearch.searchForBestNonTabuMove(neighborhoodStructures[k], localOptima);
				if (f.isImprovement(localOptima, bestNeighbor)) {
					k = 0;
					Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, bestNeighbor, "VNS RESET");
				} else {
					k++;
					Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, bestNeighbor, "VNS NEXT");
				}
				if (f.compare(localOptima, bestNeighbor) > 0) {
					localOptima = bestNeighbor;
				}
			} while (k < neighborhoodStructures.length);
			tabuSearch.taboo(localOptima);
			if (f.isImprovement(globalOptima, localOptima)) {
				globalOptima = localOptima;
				u = 0;
				Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, globalOptima, "TS RESET");
			} else {
				u++;
				Algorithms.get(SvensAlg.class).addEvent(EventType.GS_IMPROVEMENT, globalOptima, "TS NEXT");
			}
			if (u < iterations) {
				localOptima = tabuSearch.perturb(-0.20, neighborhoodStructures, globalOptima, 500);
			}
		} while (u < iterations);
		return globalOptima;
	}
}
