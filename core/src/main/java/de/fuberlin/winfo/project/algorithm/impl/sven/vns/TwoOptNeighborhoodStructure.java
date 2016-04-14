package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Arrays;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptIteratorWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current = -1;
	private KOptIteratorWrapper optionIterator;

	@Override
	public String getName() {
		return "2-Opt";
	}

	@Override
	public boolean hasNext() {
		return optionIterator.hasNext() || current != 0;
	}

	@Override
	public Solution move(Solution solution) throws Exception {
		if (optionIterator != null && optionIterator.hasNext()) {
			List<Pair> option = optionIterator.next();
			return actualMove(solution, option);
		} else {
			if (current == -1) {
				current = solution.getRoutes().size() - 1;
			} else {
				current--;
			}
			List<Pair> pairs = Route2KOptPairs.convert(solution.getRoutes().get(current));
			optionIterator = new KOptIteratorWrapper(2, pairs);
			return move(solution);
		}
	}

	private Solution actualMove(Solution solution, List<Pair> option) throws Exception {
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getEdges());

		int[] edgeToReplace = optionIterator.getOptions().getToReplace();
		UsedEdge[] newUsedEdges = new UsedEdge[edgeToReplace.length];
		for (int i = 0; i < edgeToReplace.length; i++) {
			Node start;
			if (edgeToReplace[i] > 0) {
				start = route.getWay().get(edgeToReplace[i] - 1).getEdge().getStart();
			} else {
				start = wrapper.getDepot();
			}

			Order order = getOrderByHash(option.get(i).getEnd(), route, edgeToReplace);
			if (order == null) {
				Node end = networkProvider.getNodes()[option.get(i).getEnd()];
				newUsedEdges[i] = wrapper.initializeUsedEdgeBy(start, end);
			} else {
				newUsedEdges[i] = wrapper.initializeDeliveryBy(start, order);
			}
		}
		System.out.println("to replace: " + Arrays.toString(edgeToReplace));
		wrapper.swapUsedEdge(edgeToReplace, newUsedEdges);
		return solution;
	}

	private Order getOrderByHash(int orderHash, Route route, int[] toReplace) {
		for (int index : toReplace) {
			UsedEdge usedEdge = route.getWay().get(index);
			if (usedEdge instanceof Delivery) {
				Delivery delivery = (Delivery) usedEdge;
				if (delivery.getOrder().hashCode() == orderHash) {
					return delivery.getOrder();
				}
			}
			if (index > 0) {
				UsedEdge prevUsedEdge = route.getWay().get(index - 1);
				if (prevUsedEdge instanceof Delivery) {
					Delivery delivery = (Delivery) prevUsedEdge;
					if (delivery.getOrder().hashCode() == orderHash) {
						return delivery.getOrder();
					}
				}
			}
		}
		return null;
	}
}
