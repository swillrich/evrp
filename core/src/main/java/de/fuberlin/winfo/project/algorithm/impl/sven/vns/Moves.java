package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("serial")
public class Moves extends ArrayList<Move> {
	private Comparator<Move> comparator;
	private Solution lowerBound;
	private CostFunction f;
	private int maxSize;

	@Override
	public boolean add(Move e) {
		if (lowerBound != null && f != null && f.compare(lowerBound, e.getResult()) <= 0) {
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

	public Moves() {

	}

	public Moves(Solution lowerBound, CostFunction f, int maxSize) {
		this.lowerBound = lowerBound;
		this.f = f;
		this.maxSize = maxSize;
	}

	public void setComparator(Comparator<Move> comparator) {
		this.comparator = comparator;
	}

	@Override
	public boolean addAll(Collection<? extends Move> c) {
		for (Move p : c) {
			add(p);
		}
		return true;
	}

	public Solution applySequentially(Solution initialSolution, Restrictions restrictions, boolean improvementsOnly)
			throws Exception {
		Solution incumbent = initialSolution;
		for (int i = 0; i < size();) {
			Solution candidate = get(i).execute(incumbent, true);
			if ((!improvementsOnly || f.compare(incumbent, candidate) > 0)
					&& restrictions.checkWholeSolution(candidate)) {
				incumbent = candidate;
				remove(i);
			} else {
				i++;
			}
		}
		return incumbent;
	}

	public Moves reduce(int toIndex) {
		if (toIndex > size()) {
			toIndex = size();
		}
		List<Move> list = subList(0, toIndex);
		Moves moves = new Moves(lowerBound, f, maxSize);
		moves.addAll(list);
		return moves;
	}
	public int getMaxSize() {
		return maxSize;
	}
}
