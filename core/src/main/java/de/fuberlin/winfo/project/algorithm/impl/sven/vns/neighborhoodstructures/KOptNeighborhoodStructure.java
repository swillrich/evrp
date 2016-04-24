package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptOptions;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class KOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current;
	private KOptHeuristic kOptHeuristic;
	private KOptOptions options;
	private List<Pair> pairs;
	private Edge[][] E;
	private Map<Integer, Order> orderMap;
	protected int k;

	public KOptNeighborhoodStructure(int k) {
		this.k = k;
	}

	@Override
	public void initSearch() {
		E = networkProvider.getEdges();
		kOptHeuristic = null;
		options = null;
		pairs = null;
		orderMap = null;
		current = -1;
		initNext();
	}

	@Override
	protected Solution returnBestNeighbor(Solution initialSol, Solution incumbentSol) {
		applyOperationList();
		double ratio = costFunction.getImprovementRatio(initialSol, this.incumbentSol);
		if (ratio < 0.01) {
			return initialSol;
		} else {
			return this.incumbentSol;
		}

	}

	@Override
	public String getName() {
		return k + "-Opt";
	}

	@Override
	public boolean hasNext() {
		return hasNextRoute() || hasNextK() || hasNextOption() || hasNextPairs();
	}

	private boolean hasNextK() {
		return kOptHeuristic != null && kOptHeuristic.hasNext();
	}

	private boolean hasNextPairs() {
		return pairs != null && !pairs.isEmpty();
	}

	private boolean hasNextOption() {
		return options != null && !options.isEmpty();
	}

	private boolean hasNextRoute() {
		return current + 1 < initialSol.getRoutes().size();
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		if (initNext()) {
			return actualMove(solution);
		} else {
			return new NeighborhoodOperation() {
				@Override
				public boolean isPreconditionSatisfied(Solution solution) {
					return false;
				}

				@Override
				public Solution apply(Solution solution) throws Exception {
					return solution;
				}

				@Override
				public int operationHash() {
					return 0;
				}
			};
		}
	}

	private boolean initNext() {
		if (hasNextPairs()) {
			return true;
		} else if (hasNextOption()) {
			pairs = options.remove(0);
			return true;
		} else if (hasNextK()) {
			options = kOptHeuristic.next();
			return initNext();
		} else if (hasNextRoute()) {
			current++;
			try {
				Route2KOptPairs optPairs = new Route2KOptPairs();
				optPairs.convert(initialSol.getRoutes().get(current));
				List<Pair> pairs = optPairs.getPairs();
				kOptHeuristic = new KOptHeuristic(k, pairs);
				orderMap = optPairs.getOrderMap();
				return initNext();
			} catch (Exception e) {
				orderMap = null;
				return initNext();
			}
		} else {
			return false;
		}
	}

	private KoptOperation actualMove(Solution solution) throws Exception {
		Route route = solution.getRoutes().get(current);
		RouteWrapper wrapper = new RouteWrapper(route, null, networkProvider.getEdges());
		int[] toReplace = this.options.getToReplace();
		List<UsedEdge> newUsedEdgeList = new ArrayList<UsedEdge>();
		for (int i = 0; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			UsedEdge newUsedEdge = getNewUsedEdge(wrapper, pair);
			newUsedEdgeList.add(newUsedEdge);
			if (i < pairs.size() - 1) {
				List<UsedEdge> usedEdgesBetween = getUsedEdgesBetween(toReplace, wrapper, pair.getEnd(),
						pairs.get(i + 1).getStart());
				newUsedEdgeList.addAll(usedEdgesBetween);
			}
		}
		pairs = null;
		return new KoptOperation(current, newUsedEdgeList, toReplace);
	}

	private class KoptOperation extends NeighborhoodOperation {
		private int currentRoute;
		private List<UsedEdge> newUsedEdgeList;
		private int[] toReplace;

		public KoptOperation(int current, List<UsedEdge> newUsedEdgeList, int[] toReplace) {
			this.currentRoute = current;
			this.newUsedEdgeList = newUsedEdgeList;
			this.toReplace = toReplace;
		}

		@Override
		public Solution apply(Solution solution) throws Exception {
			RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(currentRoute), null, E);
			wrapper.replaceSubRoute(newUsedEdgeList, toReplace[0], toReplace[toReplace.length - 1]);
			return solution;
		}

		@Override
		public boolean isPreconditionSatisfied(Solution solution) {
			RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(currentRoute), null, E);
			for (int i : toReplace) {
				if (wrapper.getActualRoute().getWay().size() <= i) {
					return false;
				}
			}

			Solution copy = getCopy(solution);
			try {
				apply(copy);
				return true;
			} catch (Exception e) {
				return false;
			}
		}

		@Override
		public int operationHash() {
			return 0;
		}
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
