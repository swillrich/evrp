package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	protected Restrictions restrictions;
	protected VNSMonitor history;
	protected CostFunction costFunction;

	public abstract String getName();

	public abstract Solution move(Solution solution) throws Exception;

	public abstract void initSearch();

	protected abstract boolean onNonImprovement(Solution incumbentSol, Solution candidate);

	protected abstract boolean onImprovement(Solution incumbent, Solution newSol);

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.costFunction = f;
	}

	public Solution shake(Solution solution) {
		this.initialSol = solution;
		initSearch();
		this.incumbentSol = shakeProcedure(solution);
		history.neighborChange(this, this.initialSol, incumbentSol, "shaked");
		return incumbentSol;
	}

	protected Solution shakeProcedure(Solution solution) {
		for (int i = 0; i < Math.random() * 10000; i++) {
			if (hasNext()) {
				solution = next();
			} else {
				return solution;
			}
		}
		return solution;
	}

	public Solution search(Solution solution) {
		this.initialSol = solution;
		this.incumbentSol = solution;
		initSearch();
		while (hasNext()) {
			Solution candidate = next();
			if (costFunction.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborChange(this, incumbentSol, candidate, "improved");
				if (onImprovement(incumbentSol, candidate)) {
					return initialSol;
				}
				incumbentSol = candidate;
			} else {
				if (onNonImprovement(incumbentSol, candidate)) {
					return incumbentSol;
				}
			}
		}
		return returnBestNeighbor(initialSol, incumbentSol);
	}

	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		return incumbentSol;
	}

	@Override
	public Solution next() {
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(initialSol);
		c.copyReferences();
		try {
			return move(copy);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			return null;
		}
	}

	boolean checkRestrictions(Solution sol) {
		for (Route route : sol.getRoutes()) {
			RouteWrapper routeWrapper = new RouteWrapper(route, null, networkProvider.getEdges());
			try {
				restrictions.checkCompleteRoute(routeWrapper);
				return true;
			} catch (RestrictionException e) {
				return false;
			}
		}
		return true;
	}
}
