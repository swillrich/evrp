package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.model.network.Solution;

public class Diversifier {
	private Solution initialSolution;
	private NeighborhoodStructure neighborhoodStructure;
	private CostFunction f;
	private double deviationFrom;
	private double deviationTo;
	private boolean withRange = false;

	public Diversifier(NeighborhoodStructure neighborhoodStructure, Solution initialSolution, CostFunction f) {
		this.initialSolution = initialSolution;
		this.neighborhoodStructure = neighborhoodStructure;
		this.f = f;
	}

	public Solution diversify(int iterations, boolean takeOutputAsInitial) {
		
		return null;
	}

	public void setRange(double from, double to) {
		this.deviationFrom = from;
		this.deviationTo = to;
		this.withRange = true;
	}
}
