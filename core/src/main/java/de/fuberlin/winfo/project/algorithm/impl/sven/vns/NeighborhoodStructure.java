package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NeighborhoodStructure {
	NetworkProvider np;
	Edge[][] E;
	Restrictions restrictions;
	Solution incumbentSol;
	
	public NeighborhoodStructure(NetworkProvider np) {
		this.np = np;
		this.E = np.getEdges();
		this.restrictions = new Restrictions(np);
		this.restrictions.addAll();
	}
	
	abstract String getName();
	abstract Solution move(Solution x);
	
	public Solution getBestNeighbor(Solution incumbentSol) {
		this.incumbentSol = incumbentSol;
		return null;
	}
}
