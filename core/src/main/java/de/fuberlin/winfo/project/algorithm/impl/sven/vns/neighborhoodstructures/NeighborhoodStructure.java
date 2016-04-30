package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Iterator;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.SortedOperationList;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodStructure implements Iterator<Solution> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	private Restrictions restrictions;
	private VNSMonitor history;
	private CostFunction costFunction;
	private SortedOperationList operationList;
	private int iterations;
	private boolean isApplyOperationList = false;

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
	}

	public Solution shake(Solution solution) {
		this.initialSol = solution;
		initSearch();
		if (this instanceof AbstractStochasticNeighborhoodStructure) {
			AbstractStochasticNeighborhoodStructure nhs = (AbstractStochasticNeighborhoodStructure) this;
			for (int i = 0; i < 10; i++) {
				Solution next = nhs.next();
				initialSol = next;
			}
			return initialSol;
		}
		return incumbentSol;
	}

	public Solution search(Solution solution) {
		this.initialSol = solution;
		this.incumbentSol = solution;
		initSearch();
		operationList.setLimit(solution);
		history.startLocalSearch(this, initialSol);
		while (hasNext()) {
			iterations++;
			Solution candidate = next();
			if (costFunction.compare(incumbentSol, candidate) > 0 && checkRestrictions(candidate)) {
				history.neighborChange(this, candidate, "improved");
				incumbentSol = candidate;
			}
		}
		incumbentSol = returnBestNeighbor(initialSol, incumbentSol);
		history.finishedLocalSearch(this, initialSol, incumbentSol, iterations);
		return incumbentSol;
	}

	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		if (isApplyOperationList) {
			applyOperationList();
		}
		return this.incumbentSol;
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

	public void setApplyOperationList() {
		this.isApplyOperationList = true;
	}
}
