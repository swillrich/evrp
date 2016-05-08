package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("serial")
public class Moves extends ArrayList<Move> {
	private int maxSize;
	private CostFunction f;
	private Comparator<Move> comparator = new Comparator<Move>() {
		@Override
		public int compare(Move o1, Move o2) {
			return f.compare(o1.getResult(), o2.getResult());
		}
	};
	private Solution initialSolution;
	private VNSMonitor history;

	public Moves(int size, CostFunction f, Solution initialSolution) {
		this.maxSize = size;
		this.f = f;
		this.initialSolution = initialSolution;
	}

	public Moves(Solution initialSolution) {
		this.initialSolution = initialSolution;
	}

	public void setHistory(VNSMonitor history) {
		this.history = history;
	}

	public void changeComparator(Comparator<Move> comparator) {
		this.comparator = comparator;
	}

	public void setInitialSolution(Solution solution) {
		this.initialSolution = solution;
	}

	@Override
	public boolean add(Move e) {
		if (initialSolution != null && f != null && f.compare(initialSolution, e.getResult()) <= 0) {
			return false;
		}
		boolean add = super.add(e);
		if (comparator != null) {
			Collections.sort(this, comparator);
		}
		while (maxSize < size() && maxSize > 0) {
			remove(size() - 1);
		}
		return add;
	}

	@Override
	public boolean addAll(Collection<? extends Move> c) {
		for (Move p : c) {
			add(p);
		}
		return true;
	}

	public Solution applySequentially(Restrictions restrictions, boolean improvementsOnly) throws Exception {
		int counter = 0;
		Solution incumbent = initialSolution;
		for (Move operation : this) {
			Solution candidate = operation.execute(incumbent, true);
			if ((!improvementsOnly || f.compare(initialSolution, candidate) > 0)
					&& restrictions.checkWholeSolution(candidate)) {
				incumbent = candidate;
				counter++;
			}
		}
		if (history != null) {
			history.operationListApplied(incumbent, "OpList applied (" + counter + ")");
		}
		return incumbent;
	}

	public Moves reduce(int toIndex) {
		if (toIndex > size()) {
			toIndex = size();
		}
		List<Move> list = subList(0, toIndex);
		Moves moves = new Moves(initialSolution);
		moves.changeComparator(null);
		moves.addAll(list);
		return moves;
	}
}
