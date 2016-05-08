package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Iterator;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodOperationList;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.TabuSearch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodStructure implements Iterator<NeighborhoodOperation> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	protected int iterations;
	private Restrictions restrictions;
	private VNSMonitor history;
	private CostFunction f;
	private NeighborhoodOperationList operationList;

	public abstract String getName();

	public abstract NeighborhoodOperation generateOperation(Solution solution) throws Exception;

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.f = f;
	}

	public void initNewSearch(Solution initialSolution) {
		this.initialSol = initialSolution;
		operationList = new NeighborhoodOperationList(200, f, history);
		this.iterations = 0;
		this.incumbentSol = initialSol;
	}

	public Solution shake(Solution solution) {
		initNewSearch(solution);
		Diversifier diversifier = new Diversifier(this, this.initialSol, f);
		diversifier.setRange(-0.10d, 0.10d);
		return initialSol;
	}

	public Solution tabuSearch(Solution initialSolution) throws Exception {
		Solution candidate = search(initialSolution);
		if (f.isImprovement(initialSolution, candidate)) {
			return candidate;
		} else {
			TabuSearch ts = new TabuSearch(this, f);
			Solution tsCandidate = ts.apply(candidate);
			return tsCandidate;
		}
	}

	public Solution search(Solution solution) throws Exception {
		initNewSearch(solution);
		operationList.setInitialSolution(solution);
		history.startLocalSearch(this, initialSol);
		while (hasNext()) {
			iterations++;
			NeighborhoodOperation operation = next();
			Solution candidate = operation.execute(initialSol, false);
			operationList.add(operation);
			if (f.compare(incumbentSol, candidate) > 0 && restrictions.isAllRight(candidate)) {
				history.neighborChange(this, candidate, "improved");
				this.incumbentSol = candidate;
			}
		}
		history.finishedLocalSearch(this, initialSol, incumbentSol, iterations, false);
		return incumbentSol;
	}

	@Override
	public NeighborhoodOperation next() {
		try {
			return generateOperation(initialSol);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
