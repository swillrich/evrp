package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptIteratorWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class KOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current = -1;
	private KOptIteratorWrapper optionIterator;
	private Edge[][] E;
	private Map<Integer, Order> orderMap;
	private int k;

	private int counter;

	public KOptNeighborhoodStructure(int k) {
		this.k = k;
	}

	@Override
	protected boolean onNoImprovement(Solution incumbentSol, Solution candidate, long lastImprovement) {
		if (lastImprovement == -1) {
			return false;
		}
		long diff = new Date().getTime() - lastImprovement;
		long sec = diff / 1000;
		if (sec > 90) {
			return true;
		}
		return false;
	}

	@Override
	protected boolean returnIfConditionReached(Solution incumbent, Solution candidate) {
		if (costFunction.compute(incumbentSol) - costFunction.compute(candidate) < k * 2 * 500) {
			if (++counter == 5) {
				return true;
			} else {
				return false;
			}
		} else {
			counter = 0;
			return false;
		}
	}

	@Override
	protected Solution shakeProcedure(Solution sol) {
		while (true) {
			for (int i = 0; i < Math.random() * 10 * k; i++) {
				if (hasNext()) {
					sol = next();
				} else {
					break;
				}
			}

			takePartialSolutionFromIncumbent(sol);
			if (current == initialSol.getRoutes().size() - 1) {
				return sol;
			} else {
				incumbentSol = sol;
				initNext();
			}
		}
	}

	@Override
	public void initSearch() {
		E = networkProvider.getEdges();
		current = -1;
		optionIterator = null;
		orderMap = null;
		counter = 0;
		current = -1;
		initNext();
	}

	@Override
	public String getName() {
		return k + "-Opt";
	}

	@Override
	public boolean hasNext() {
		return optionIterator.hasNext();
	}

	@Override
	public Solution move(Solution solution) throws Exception {
		List<Pair> option = optionIterator.next();
		actualMove(solution, option);
		if (!optionIterator.hasNext() && current + 1 < initialSol.getRoutes().size()) {
			initNext();
			takePartialSolutionFromIncumbent(solution);
		}
		return solution;

	}

	private void takePartialSolutionFromIncumbent(Solution solution) {
		for (int i = 0; i < current; i++) {
			Collection<UsedEdge> way = EcoreUtil.copyAll(incumbentSol.getRoutes().get(i).getWay());
			solution.getRoutes().get(i).getWay().clear();
			solution.getRoutes().get(i).getWay().addAll(way);
			new RouteWrapper(solution.getRoutes().get(i), null, null);
		}
	}

	private void initNext() {
		current++;
		try {
			Route2KOptPairs optPairs = new Route2KOptPairs();
			optPairs.convert(initialSol.getRoutes().get(current));
			List<Pair> pairs = optPairs.getPairs();
			optionIterator = new KOptIteratorWrapper(k, pairs);
			orderMap = optPairs.getOrderMap();
		} catch (Exception e) {
		}
	}

	private void actualMove(Solution solution, List<Pair> option) throws Exception {
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
		wrapper.replaceSubRoute(newUsedEdgeList, toReplace[0], toReplace[toReplace.length - 1]);
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
