package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.KOptHeuristic.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.KOptHeuristic.Pair;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {

	private KOptHeuristic kopt;
	private int current = 0;
	private KOptOptions options;

	@Override
	public String getName() {
		return "2-Opt";
	}

	@Override
	public boolean hasNext() {
		if (current < 0) {
			return kopt.hasNext();
		}
		return true;
	}

	@Override
	public Solution move(Solution solution) {
		if (options != null && !options.isEmpty()) {
			return move();
		} else if (kopt != null && kopt.hasNext()) {
			options = kopt.next();
			System.out.println(kopt.toString());
			System.out.println(options.toString());
			return move();
		} else {
			try {
				kopt = new KOptHeuristic(2, solution.getRoutes().get(current));
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (current + 1 == solution.getRoutes().size()) {
				current = -1;
			}
			options = kopt.next();
			return move();
		}
	}

	private Solution move() {
		List<Integer> list = options.remove(0);
		return centralSol;
	}

	private List<Pair> prepareForKOpt(Route route) {
		List<Pair> list = new ArrayList<Pair>();
		for (int i = 1; i < route.getWay().size(); i++) {
			final int id = i;
			final UsedEdge usedEdge = route.getWay().get(i);
			Pair pair = new Pair() {

				@Override
				public int getId() {
					return id;
				}

				@Override
				public int getStart() {
					UsedEdge previousUsedEdge = route.getWay().get(id - 1);
					if (previousUsedEdge instanceof Delivery) {
						return ((Delivery) usedEdge).getOrder().hashCode();
					} else {
						return usedEdge.getEdge().getStart().getId();
					}
				}

				@Override
				public int getEnd() {
					if (usedEdge instanceof Delivery) {
						return ((Delivery) usedEdge).getOrder().hashCode();
					} else {
						return usedEdge.getEdge().getEnd().getId();
					}
				}

				@Override
				public Object getSrc() {
					return usedEdge;
				}
			};
			list.add(pair);
		}
		return list;
	}
}
