package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Date;
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
	protected long lastImprovement;

	public abstract String getName();

	public abstract Solution move(Solution solution) throws Exception;

	public abstract void initSearch();

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.costFunction = f;
		this.lastImprovement = -1;
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

	public Solution search(Solution solution)  {
		this.initialSol = solution;
		this.incumbentSol = solution;
		initSearch();
		while (hasNext()) {
			Solution candidate = next();
			if (costFunction.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborChange(this, incumbentSol, candidate, "improved");
				if (returnIfConditionReached(incumbentSol, candidate)) {
					return incumbentSol;
				}
				lastImprovement = new Date().getTime();
				incumbentSol = candidate;
			} else {
				if (onNoImprovement(incumbentSol, candidate, lastImprovement)) {
					return incumbentSol;
				}
			}
		}
		return search(incumbentSol);
	}

	protected boolean onNoImprovement(Solution incumbentSol, Solution candidate, long lastImprovement) {
		return false;
	}

	protected boolean returnIfConditionReached(Solution incumbent, Solution newSol) {
		return false;
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
