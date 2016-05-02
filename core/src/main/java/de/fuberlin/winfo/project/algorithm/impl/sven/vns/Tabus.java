package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.Tabus.Tabu;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("serial")
public class Tabus extends TreeSet<Tabu> {
	private CostFunction f;
	private int maxSizeOfSolution;
	private int notAdded;

	public Tabus(CostFunction function, int size) {
		super(getComparator(function));
		f = function;
		this.maxSizeOfSolution = size;
	}

	private static Comparator<? super Tabu> getComparator(CostFunction function) {
		return (tabu1, tabu2) -> {
			int compare = Double.compare(tabu1.orderValue, tabu2.orderValue);
			if (compare == 0) {
				Solution sol1 = tabu1.solution;
				Solution sol2 = tabu2.solution;
				return function.compare(sol1, sol2);	
			} else {
				return compare;
			}
		};
	}

	public boolean add(Solution solution) {
		Tabu tabu = getTabuInstance(solution);
		if (add(tabu)) {
			removeSolutionsIfBelowMaxSize();
			return true;
		} else {
			notAdded++;
			return false;
		}
	}
	
	public int getNotAdded() {
		return notAdded;
	}

	private Tabu getTabuInstance(Solution solution) {
		Tabu tabu = new Tabu();
		tabu.orderValue = f.compute(solution);
		tabu.solution = solution;
		return tabu;
	}

	private void removeSolutionsIfBelowMaxSize() {
		Iterator<Tabu> iterator = iterator();
		for (int i = 0; i <= maxSizeOfSolution && iterator.hasNext(); i++) {
			Tabu next = iterator.next();
			if (i == maxSizeOfSolution) {
				next.solution = null;
			}
		}
	}

	public Solution getBest() {
		return first().solution;
	}

	public int getMaxSizeOfSolution() {
		return maxSizeOfSolution;
	}

	@Override
	public boolean contains(Object o) {
		Tabu tabu = getTabuInstance(((Solution) o));
		return super.contains(tabu);
	}

	class Tabu {
		double orderValue;
		Solution solution;
	}

	@Override
	public String toString() {
		return stream().map(t -> t.orderValue + "").collect(Collectors.joining(", "));
	}
}
