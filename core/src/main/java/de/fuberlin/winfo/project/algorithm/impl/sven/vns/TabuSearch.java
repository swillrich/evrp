package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class TabuSearch extends TreeSet<NeighborhoodOperation> {

	private NeighborhoodStructure ns;
	private CostFunction f;
	private Solution initial;
	

	public TabuSearch(NeighborhoodStructure neighborhoodStructure, CostFunction costFunction) {
		this.ns = neighborhoodStructure;
		this.f = costFunction;
	}

	public Solution apply(Solution localOptima) {
		this.initial = localOptima;
		Solution neighbor = diversify();
		return null;
	}

	private Solution diversify() {
		Solution copy = Algorithm.getCopy(initial);
		ns.shake(copy);
		return null;
	}
}
