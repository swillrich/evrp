package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.stream.StreamSupport;

import de.fuberlin.winfo.project.Random;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
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
	private List<ImprovementListener> improvementListener = new ArrayList<ImprovementListener>();

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
		operationList = new Moves(initialSolution, f, 200);
		operationList.setComparator(new Comparator<Move>() {
			@Override
			public int compare(Move o1, Move o2) {
				return f.compare(o1.getResult(), o2.getResult());
			}
		});
		this.iterations = 0;
		this.incumbentSol = initialSol;
	}

	public Solution shake(Solution solution) throws Exception {
		initNewSearch(solution);
		return incumbentSol;
	}

	public Solution search(Solution solution) throws Exception {
		initNewSearch(solution);
		history.startLocalSearch(this, initialSol);
		while (hasNext()) {
			iterations++;
			Move operation = next();
			Solution candidate = operation.execute(initialSol, false);
			operationList.add(operation);
			if (f.compare(incumbentSol, candidate) > 0 && restrictions.checkWholeSolution(candidate)) {
				if (!improvementListener.stream().filter(i -> !i.acceptImprovement(candidate)).findFirst()
						.isPresent()) {
					history.neighborChange(this, candidate, "improved");
					this.incumbentSol = candidate;
				}
			}
		}

		int prevSize = operationList.size();
		incumbentSol = operationList.applySequentially(initialSol, restrictions, true);
		int postSize = operationList.size();
		history.neighborChange(this, incumbentSol, "Moves applied (" + (prevSize - postSize) + "/" + prevSize + ")");
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
		Moves m = new Moves(null, f, 0);
		initNewSearch(initialSolution);
		while (m.size() < size * 10 && hasNext()) {
			m.add(next());
		}
		Collections.shuffle(m, Random.get());
		return m.reduce(size);
	}

	public CostFunction getF() {
		return f;
	}

	public VNSMonitor getHistory() {
		return history;
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public List<ImprovementListener> getImprovementListener() {
		return improvementListener;
	}

	public static interface ImprovementListener {
		public boolean acceptImprovement(Solution solution) throws RuntimeException;
	}
}
