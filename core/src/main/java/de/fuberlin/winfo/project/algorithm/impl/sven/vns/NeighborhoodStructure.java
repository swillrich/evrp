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

	public abstract String getName();

	public abstract Solution move(Solution solution) throws Exception;

	public abstract void init();

	public void setNetworkProvider(NetworkProvider np, VNSMonitor history) {
		networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
	}

	public Solution shake(Solution solution) {
		this.initialSol = solution;
		init();
		this.incumbentSol = shakeProcedure(solution);
		history.neighborhoodChange(this, this.initialSol, incumbentSol, "shaked");
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
	public Solution search(Solution solution, CostFunction f) {
		this.initialSol = solution;
		this.incumbentSol = solution;
		init();
		while (hasNext()) {
			Solution candidate = next();
			if (f.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborhoodChange(this, incumbentSol, candidate, "improved");
				incumbentSol = candidate;
			}
		}
		return search(incumbentSol, f);
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
