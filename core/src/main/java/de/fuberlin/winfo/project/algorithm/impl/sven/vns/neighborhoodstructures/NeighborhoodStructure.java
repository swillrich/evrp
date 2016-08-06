package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.impl.sven.SvensAlg;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Moves;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.Solution;

public abstract class NeighborhoodStructure implements Iterator<Move> {

	protected Solution initialSol;
	protected Solution incumbentSol;
	protected NetworkProvider networkProvider;
	protected int iterations;
	protected long start;
	protected long end;
	protected int iterationsRejected;
	private Restrictions restrictions;
	private CostFunction f;
	private Moves operationList;
	private List<ImprovementListener> improvementListener = new ArrayList<ImprovementListener>();

	public abstract String getName();

	public abstract Move generateOperation(Solution solution) throws Exception;

	public abstract boolean isInterRouteRelated();

	public void setUp(NetworkProvider np, CostFunction f) {
		this.networkProvider = np;
		this.restrictions = new Restrictions(networkProvider);
		this.restrictions.addAll();
		this.f = f;
	}

	public void initNewSearch(Solution initialSolution) {
		this.initialSol = initialSolution;
		operationList = new Moves(initialSolution, f, 500);
		operationList.setComparator(new Comparator<Move>() {
			@Override
			public int compare(Move o1, Move o2) {
				return f.compare(o1.getResult(), o2.getResult());
			}
		});
		this.iterations = 0;
		this.incumbentSol = initialSol;
		this.iterationsRejected = 0;
		this.start = new Date().getTime();
	}

	public Solution shake(Solution solution) throws Exception {
		initNewSearch(solution);
		return incumbentSol;
	}

	public Solution search(Solution solution) throws Exception {
		initNewSearch(solution);
		while (hasNext()) {
			iterations++;
			Move move = next();
			Solution candidate = move.execute(initialSol, false);
			if (!improvementListener.stream().filter(i -> !i.acceptImprovement(move)).findFirst().isPresent()) {
				operationList.add(move);
				if (f.compare(incumbentSol, candidate) > 0 && restrictions.checkWholeSolution(candidate)) {
					this.incumbentSol = candidate;
					Algorithms.get(SvensAlg.class).addEvent(EventType.LS_IMPROVEMENT, this.incumbentSol,
							this.getName());
				}
			} else {
				iterationsRejected++;
			}
		}
		int prevSize = operationList.size();
		incumbentSol = operationList.applySequentially(initialSol, restrictions, true);
		int postSize = operationList.size();
		this.end = new Date().getTime();
		long avgDur = (long) (iterations / ((end - start) / 1000d));
		Algorithms.get(SvensAlg.class).addEvent(EventType.LS_IMPROVEMENT, this.incumbentSol,
				this.getName() + ", OQ (" + (prevSize - postSize) + "/" + operationList.getMaxSize() + "), REJ ("
						+ iterationsRejected + " / " + iterations + "), AvgIt(" + avgDur + ")");
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

	public Moves toList(Solution initialSolution, int size) {
		Moves m = new Moves(null, f, 0);
		initNewSearch(initialSolution);
		while (m.size() < size * 100 && hasNext()) {
			m.add(next());
		}
		return m.reduce(size);
	}

	public CostFunction getF() {
		return f;
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	public List<ImprovementListener> getImprovementListener() {
		return improvementListener;
	}

	public static interface ImprovementListener {
		public boolean acceptImprovement(Move move) throws RuntimeException;
	}
}
