package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class Route2KOptPairs {
	public static List<Pair> convert(Route route) {
		List<Pair> list = new ArrayList<Pair>();
		for (int i = 0; i < route.getWay().size(); i++) {
			final int id = i;
			final UsedEdge usedEdge = route.getWay().get(i);
			Pair pair = new Pair() {

				@Override
				public int getStart() {
					if (id == 0) {
						return usedEdge.getEdge().getStart().getId();
					} else {
						UsedEdge prevUsedEdge = route.getWay().get(id - 1);
						if (prevUsedEdge instanceof Delivery) {
							return ((Delivery) prevUsedEdge).getOrder().hashCode();
						} else {
							return prevUsedEdge.getEdge().getEnd().getId();
						}
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

			};
			list.add(pair);
		}
		return list;
	}
}
