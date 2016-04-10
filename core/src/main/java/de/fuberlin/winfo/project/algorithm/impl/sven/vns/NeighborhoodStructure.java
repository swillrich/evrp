package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	Solution centralSol;
	NetworkProvider np;

	public NeighborhoodStructure(NetworkProvider np) {
		this.np = np;
	}

	public abstract String getName();

	public abstract Solution move(Solution solution);

	public Solution shake(Solution s) {
		this.centralSol = s;
		return null;
	}

	public Solution search(Solution solution, CostFunction f) {
		this.centralSol = solution;
		while (hasNext()) {
			Solution neighbor = next();
			if (f.compare(solution, neighbor) > 0) {
				solution = neighbor;
			}
		}
		return solution;
	}

	@Override
	public Solution next() {
		Solution copy = EcoreUtil.copy(centralSol);
		return move(copy);
	}
}
