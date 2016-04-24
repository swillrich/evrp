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
	protected SortedOperationList operationList;
	protected int iterations;

	public abstract String getName();

	public abstract Operation generateOperation(Solution solution) throws Exception;

	public abstract void initSearch();

	protected abstract boolean onNonImprovement(Solution incumbentSol, Solution candidate);

	protected abstract boolean onImprovement(Solution incumbent, Solution newSol);

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.costFunction = f;
		operationList = new SortedOperationList(200, f);
		iterations = 0;
	}

	public Solution shake(Solution solution) {
		this.initialSol = solution;
		initSearch();
		this.incumbentSol = shakeProcedure(solution);
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
		history.startLocalSearch(this, initialSol);
		while (hasNext()) {
			iterations++;
			Solution candidate = next();
			if (costFunction.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborChange(this, candidate, "improved");
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
		incumbentSol = returnBestNeighbor(initialSol, incumbentSol);
		history.finishedLocalSearch(this, initialSol, incumbentSol, iterations);
		return incumbentSol;
	}

	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		return incumbentSol;
	}

	@Override
	public Solution next() {
		Solution copy = getCopy(initialSol);
		try {
			Operation operation = generateOperation(initialSol);
			operation.execute(copy, false);
			operationList.add(operation);
			return operation.getResult();
		} catch (Exception e) {
			e.printStackTrace();
			return initialSol;
		}
	}

	protected Solution getCopy(Solution original) {
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(original);
		c.copyReferences();
		return copy;
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

	protected int f(Solution s) {
		return costFunction.compute(s);
	}

	protected void applyOperationList() {
		incumbentSol = getCopy(initialSol);
		int counter = 0;
		for (Operation o : operationList) {
			try {
				Solution copy = getCopy(incumbentSol);
				o.execute(copy, true);
				if (costFunction.compare(incumbentSol, o.getResult()) > 0 && checkRestrictions(o.getResult())) {
					incumbentSol = o.getResult();
					counter++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		history.neighborChange(this, incumbentSol, "OpList applied (" + counter + ")");
		operationList.clear();
	}
}
