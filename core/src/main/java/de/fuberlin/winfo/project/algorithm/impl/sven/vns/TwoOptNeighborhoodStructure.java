package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptIteratorWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current = -1;
	private KOptIteratorWrapper optionIterator;
	private Edge[][] E;
	private Map<Integer, Order> orderMap;

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
				E = networkProvider.getEdges();
			} else {
				current--;
			}
			String string = "Route #" + current + " with edges " + solution.getRoutes().get(current).getWay().size();
			try {
				Route2KOptPairs optPairs = new Route2KOptPairs();
				optPairs.convert(centralSol.getRoutes().get(current));
				List<Pair> pairs = optPairs.getPairs();
				orderMap = optPairs.getOrderMap();
				optionIterator = new KOptIteratorWrapper(3, pairs);
				System.out.println(string);
			} catch (Exception e) {
				System.out.println(string + ": " + e.getMessage());
			}
			return move(solution);
		}
	}

	private Solution actualMove(Solution solution, List<Pair> option) throws Exception {
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getEdges());

		int[] toReplace = optionIterator.getOptions().getToReplace();
		List<UsedEdge> newUsedEdgeList = new ArrayList<UsedEdge>();

		for (int i = 0; i < option.size(); i++) {
			Pair pair = option.get(i);
			UsedEdge newUsedEdge = getNewUsedEdge(wrapper, pair);
			newUsedEdgeList.add(newUsedEdge);
			if (i < option.size() - 1) {
				List<UsedEdge> usedEdgesBetween = getUsedEdgesBetween(toReplace, wrapper, pair.getEnd(),
						option.get(i + 1).getStart());
				newUsedEdgeList.addAll(usedEdgesBetween);
			}
		}
//		wrapper.replaceSubRoute(newUsedEdgeList, toReplace[0], toReplace[toReplace.length - 1]);
		return solution;
	}

	private List<UsedEdge> getUsedEdgesBetween(int[] toReplace, RouteWrapper wrapper, int start, int end) {
		List<UsedEdge> way = wrapper.getActualRoute().getWay();
		List<UsedEdge> newSubWay = new ArrayList<UsedEdge>();
		boolean isReverse = true;
		int edgeIterator = -1;
		for (int edgeIndex : toReplace) {
			int[] cases = edgeIndex > 0 ? new int[] { 0, 1 } : new int[] { 0 };
			for (int i : cases) {
				UsedEdge usedEdge = way.get(edgeIndex - i);
				Order order = AlgHelper.getOrderIfDelivery(usedEdge);
				if ((order != null && AlgHelper.getOrderId(order) == start)
						|| usedEdge.getEdge().getStart().getId() == start) {
					isReverse = (i != 0);
					edgeIterator = edgeIndex + (i == 0 ? 1 : -1);
					break;
				}
			}
		}
		while (true) {
			UsedEdge usedEdge = way.get(edgeIterator);
			Edge edge = usedEdge.getEdge();
			if (isReverse) {
				edge = E[edge.getEnd().getId()][edge.getStart().getId()];
			}
			Order order = AlgHelper.getOrderIfDelivery(way.get(edgeIterator + (isReverse ? -1 : 0)));
			if (order == null) {
				usedEdge = wrapper.initializeUsedEdge(edge, null);
			} else {
				usedEdge = wrapper.initializeUsedEdge(edge, order);
			}
			newSubWay.add(usedEdge);
			if ((order != null && end == AlgHelper.getOrderId(order)) || (end == edge.getEnd().getId())) {
				break;
			}
			edgeIterator = edgeIterator + (isReverse ? -1 : +1);
		}
		return newSubWay;
	}

	private UsedEdge getNewUsedEdge(RouteWrapper wrapper, Pair pair) {
		Order startOrder = orderMap.get(pair.getStart());
		Order endOrder = orderMap.get(pair.getEnd());
		Node startNode = startOrder == null ? networkProvider.getNodes()[pair.getStart()]
				: AlgHelper.getNodeByOrder(startOrder);
		Node endNode = endOrder == null ? networkProvider.getNodes()[pair.getEnd()]
				: AlgHelper.getNodeByOrder(endOrder);
		if (endOrder == null) {
			return wrapper.initializeUsedEdge(startNode, endNode);
		} else {
			return wrapper.initializeDelivery(startNode, endOrder);
		}
	}
}
