package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public interface NeighborhoodStructure {
	public String getName();
	public Solution searchNeighborhood(NetworkProvider np, Solution bestSolution);
}
