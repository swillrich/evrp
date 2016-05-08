package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.TabuSearch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.algorithm.restriction.impl.SolutionCostRangeRestriction;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodStructure implements Iterator<Move> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	protected int iterations;
	private Restrictions restrictions;
	private VNSMonitor history;
	private CostFunction f;
	private Moves operationList;

	public abstract String getName();

	public abstract Move generateOperation(Solution solution) throws Exception;

	public void setUp(NetworkProvider np, VNSMonitor history, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.history = history;
		this.f = f;
	}

	public void initNewSearch(Solution initialSolution) {
		this.initialSol = initialSolution;
		operationList = new Moves(200, f, initialSolution);
		operationList.setHistory(history);
		this.iterations = 0;
		this.incumbentSol = initialSol;
	}

	public Solution shake(Solution solution) throws Exception {
		initNewSearch(solution);
		SolutionCostRangeRestriction restriction = new SolutionCostRangeRestriction(this.initialSol, -0.10, 0.10, f);
		restrictions.add(restriction);
		Diversifier diversifier = new Diversifier(this, this.initialSol, f, restrictions);
		Solution diversifiedSolution = diversifier.diversify(500);
		incumbentSol = diversifiedSolution;
		restrictions.remove(restriction);
		return incumbentSol;
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
			Move operation = next();
			Solution candidate = operation.execute(initialSol, false);
			operationList.add(operation);
			if (f.compare(incumbentSol, candidate) > 0 && restrictions.checkWholeSolution(candidate)) {
				history.neighborChange(this, candidate, "improved");
				this.incumbentSol = candidate;
			}
		}
		incumbentSol = operationList.applySequentially(restrictions, true);
		history.finishedLocalSearch(this, initialSol, incumbentSol, iterations, false);
		return incumbentSol;
	}

	@Override
	public Move next() {
		try {
			return generateOperation(initialSol);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public Moves toShuffledList(Solution initialSolution, int size) {
		Moves m = new Moves(initialSolution);
		m.changeComparator(null);
		initNewSearch(initialSolution);
		this.forEachRemaining(m::add);
		Collections.shuffle(m, new Random(0));
		return m.reduce(size);
	}
}
