package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	Solution centralSol;
	NetworkProvider networkProvider;

	public abstract String getName();

	public abstract Solution move(Solution solution) throws Exception;

	public void init(NetworkProvider np, Solution sol) {
		this.centralSol = sol;
		networkProvider = np;
	}

	public Solution shake() {
		for (int i = 0; i < Math.random() * 10; i++) {
			next();
		}
		return next();
	}

	public Solution search(Solution solution, CostFunction f) {
		this.centralSol = solution;
		while (hasNext()) {
			Solution neighbor = next();
			if (f.compare(solution, neighbor) > 0) {
				System.out.println("IMPROVEMENT !!!");
				solution = neighbor;
			}
		}
		return solution;
	}

	@Override
	public Solution next() {
		Solution copy = EcoreUtil.copy(centralSol);
		try {
			return move(copy);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
