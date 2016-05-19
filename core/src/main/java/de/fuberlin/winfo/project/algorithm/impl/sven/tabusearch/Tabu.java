package de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import de.fuberlin.winfo.project.Random;
import de.fuberlin.winfo.project.algorithm.impl.sven.tabusearch.Tabu.PositionedArc;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class Tabu extends HashMap<Arc, PositionedArc> {
	Solution solution;

	public Tabu(Solution solution) {
		this.solution = solution;
		for (int i = 0; i < this.solution.getRoutes().size(); i++) {
			Route route = this.solution.getRoutes().get(i);
			for (int j = 0; j < route.getWay().size(); j++) {
				UsedArc usedArc = route.getWay().get(j);
				put(usedArc.getArc(), new PositionedArc(i, j));
			}
		}
	}

	public void removeRandomized(int n) {
		int size = keySet().size();
		System.out.println("entries: " + size());
		LinkedList<Arc> ll = new LinkedList<Arc>(keySet());
		Set<Arc> set = new HashSet<Arc>();
		while (size - ll.size() <= n && !ll.isEmpty()) {
			Arc remove = ll.remove(Random.get().nextInt(ll.size()));
			set.add(remove);
		}
		entrySet().removeIf(e -> set.contains(e.getKey()));
		System.out.println("entries after: " + size());
		System.out.println();

	}

	public Solution getSolution() {
		return solution;
	}

	class PositionedArc {
		private int route;
		private int index;

		public PositionedArc(int route, int index) {
			this.route = route;
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		public int getRoute() {
			return route;
		}
	}

}