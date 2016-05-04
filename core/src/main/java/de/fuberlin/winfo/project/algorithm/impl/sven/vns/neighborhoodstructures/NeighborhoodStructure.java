package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.SortedOperationList;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.TabuSearch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	protected int iterations;
	private Restrictions restrictions;
	private VNSMonitor history;
	private CostFunction costFunction;
	private SortedOperationList operationList;
	private boolean isApplyOperationList = false;
	private TabuSearch tabuSearch;

	public abstract String getName();

	public abstract NeighborhoodOperation generateOperation(Solution solution) throws Exception;

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.costFunction = f;
	}

	public void initSearch() {
		operationList = new SortedOperationList(200, costFunction);
		this.iterations = 0;
		this.incumbentSol = initialSol;
		this.tabuSearch = new TabuSearch(5000, 1000);
	}

	public Solution shake(Solution solution) {
		this.initialSol = solution;
		initSearch();
		if (this instanceof AbstractRandomizedNeighborhoodStructure) {
			history.startLocalSearch(this, initialSol);
			AbstractRandomizedNeighborhoodStructure nhs = (AbstractRandomizedNeighborhoodStructure) this;
			for (int i = 0; i < 2;) {
				Solution next = nhs.next();
				if (!checkRestrictions(next)) {
					continue;
				} else {
					i++;
				}
				history.neighborChange(this, next, "shaked");
				updateIncumbentSolution(next);
			}
			history.finishedLocalSearch(this, solution, initialSol, iterations, true);
			return initialSol;
		}
		return initialSol;
	}
	
	public void updateIncumbentSolution(Solution incumbentSol) {
		this.incumbentSol = incumbentSol;
//		this.tabuSearch.
	}

	public Solution search(Solution solution) {
		this.initialSol = solution;
		initSearch();
		operationList.setLimit(solution);
		history.startLocalSearch(this, initialSol);
		while (hasNext()) {
			iterations++;
			Solution candidate = next();
			if (costFunction.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborChange(this, candidate, "improved");
				 updateIncumbentSolution(candidate);
			}
		}
		updateIncumbentSolution(returnBestNeighbor(initialSol, incumbentSol));
		history.finishedLocalSearch(this, initialSol, incumbentSol, iterations, false);
		return incumbentSol;
	}

	@Override
	public Solution next() {
		Solution copy = getCopy(initialSol);
		try {
			NeighborhoodOperation operation = generateOperation(initialSol);
			operation.execute(copy, false);
			operationList.add(operation);
			return operation.getResult();
		} catch (Exception e) {
			e.printStackTrace();
			return initialSol;
		}
	}

	private Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		if (isApplyOperationList) {
			applyOperationList();
		}
		if (!costFunction.isImprovement(initialSol, incumbentSol)) {
			
		}
		return this.incumbentSol;
	}

	public static Solution getCopy(Solution original) {
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(original);
		c.copyReferences();
		return copy;
	}

	boolean checkRestrictions(Solution sol) {
		for (Route route : sol.getRoutes()) {
			RouteWrapper routeWrapper = new RouteWrapper(route, null, networkProvider.getArcs());
			try {
				restrictions.checkCompleteRoute(routeWrapper);
				return true;
			} catch (RestrictionException e) {
				return false;
			}
		}
		return true;
	}

	protected double f(Solution s) {
		return costFunction.compute(s);
	}

	protected void applyOperationList() {
		incumbentSol = getCopy(initialSol);
		int counter = 0;
		for (NeighborhoodOperation o : operationList) {
			try {
				Solution copy = getCopy(incumbentSol);
				o.execute(copy, true);
				if (costFunction.compare(incumbentSol, o.getResult()) > 0 && checkRestrictions(o.getResult())) {
					updateIncumbentSolution(o.getResult());
					counter++;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		history.neighborChange(this, incumbentSol, "OpList applied (" + counter + ")");
		operationList.clear();
	}

	public void useApplyOperationList() {
		this.isApplyOperationList = true;
	}
}
