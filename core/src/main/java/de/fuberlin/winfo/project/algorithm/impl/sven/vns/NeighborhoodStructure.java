package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	protected Solution centralSol;
	protected NetworkProvider networkProvider;

	public abstract String getName();

	public abstract Solution move(Solution solution) throws Exception;

	public abstract void init();

	public void setNetworkProvider(NetworkProvider np) {
		networkProvider = np;
	}

	public Solution shake(Solution sol) {
		this.centralSol = sol;
		init();
		for (int i = 0; i < Math.random() * 10000; i++) {
			if (hasNext()) {
				sol = next();
			} else {
				return sol;
			}
		}
		return sol;
	}

	public Solution search(Solution solution, CostFunction f) {
		this.centralSol = solution;
		init();
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
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(centralSol);
		c.copyReferences();
		try {
			return move(copy);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}
}
