package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class Route2KOptPairs {

	private Map<Integer, Order> orderMap = new HashMap<Integer, Order>();
	private List<Pair> pairs;

	public void convert(Route route) {
		pairs = new ArrayList<Pair>();
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
						Order order = AlgHelper.getOrderIfDelivery(prevUsedEdge);
						if (order != null) {
							orderMap.put(order.hashCode(), order);
						}
						return AlgHelper.getUniqueTargetId(prevUsedEdge);
					}
				}

				@Override
				public int getEnd() {
					Order order = AlgHelper.getOrderIfDelivery(usedEdge);
					if (order != null) {
						orderMap.put(order.hashCode(), order);
					}
					return AlgHelper.getUniqueTargetId(usedEdge);
				}

			};
			pairs.add(pair);
		}
	}

	public Map<Integer, Order> getOrderMap() {
		return orderMap;
	}

	public List<Pair> getPairs() {
		return pairs;
	}
}
