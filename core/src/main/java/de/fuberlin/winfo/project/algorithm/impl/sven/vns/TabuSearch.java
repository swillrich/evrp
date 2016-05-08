package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class TabuSearch extends TreeSet<Move> {

	private NeighborhoodStructure ns;
	private CostFunction f;
	private Solution initial;
	

	public TabuSearch(NeighborhoodStructure neighborhoodStructure, CostFunction costFunction) {
		this.ns = neighborhoodStructure;
		this.f = costFunction;
	}

	public Solution apply(Solution localOptima) throws Exception {
		this.initial = localOptima;
		Solution neighbor = diversify();
		return neighbor;
	}

	private Solution diversify() throws Exception {
		return ns.shake(initial);
	}
}
