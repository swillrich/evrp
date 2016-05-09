package de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.model.network.Solution;

public class Tabu extends TreeMap<Integer, List<Integer>> {
	Solution solution;

	public Tabu(Solution solution) {
		this.solution = solution;
		IntStream.range(0, solution.getRoutes().size()).forEach(i -> put(i, new ArrayList<Integer>()));
		for (int i = 0; i < solution.getRoutes().size(); i++) {
			final List<Integer> list = get(i);
			solution.getRoutes().get(i).getWay().stream().forEachOrdered(w -> list.add(w.getArc().getEnd().getId()));
		}
	}

	public Solution getSolution() {
		return solution;
	}
}