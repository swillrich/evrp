package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.TreeSet;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;

public class TabuSearch extends TreeSet<NeighborhoodOperation> {

	private int iterations;
	private int cacheSize;

	public TabuSearch(int iterations, int cacheSize) {
		this.iterations = iterations;
		this.cacheSize = cacheSize;
	}

}
