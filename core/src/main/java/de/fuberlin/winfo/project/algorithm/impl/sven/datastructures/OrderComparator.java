package de.fuberlin.winfo.project.algorithm.impl.sven.datastructures;

import java.util.Collections;
import java.util.Comparator;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class OrderComparator implements Comparator<PendingOrder> {
	private ExtRoute route;
	private NetworkProvider np;
	private Edge[][] E;

	public OrderComparator(ExtRoute route, NetworkProvider np) {
		this.route = route;
		this.np = np;
		this.E = np.getEdges();
	}

	@Override
	public int compare(PendingOrder o1, PendingOrder o2) {
		Node n1 = AlgHelper.getNodeByOrder(np, o1.getOrder());
		Node n2 = AlgHelper.getNodeByOrder(np, o2.getOrder());

		if (o1.getOrder().getTimeWindow() != null && o2.getOrder().getTimeWindow() == null) {
			return -1;
		} else if (o1.getOrder().getTimeWindow() == null && o2.getOrder().getTimeWindow() != null) {
			return 1;
		}

		// initial pendulum tour (Nearest Neighbor)
		if (route.getModelRoute().getWay().isEmpty()) {
			return Integer.compare(distance(route.getDepot(), n1), distance(route.getDepot(), n2));
		}

		UsedEdge n1UsedEdge = returnMin(n1);
		o1.setPos(route.getModelRoute().getWay().indexOf(n1UsedEdge));

		UsedEdge n2UsedEdge = returnMin(n2);
		o2.setPos(route.getModelRoute().getWay().indexOf(n2UsedEdge));

		int costs1 = computeCheapestInsertion(n1UsedEdge, n1);
		int costs2 = computeCheapestInsertion(n2UsedEdge, n2);

		return Integer.compare(costs1, costs2);
	}

	private UsedEdge returnMin(Node node) {
		return Collections.min(route.getModelRoute().getWay(), new Comparator<UsedEdge>() {
			@Override
			public int compare(UsedEdge o1, UsedEdge o2) {
				int a = computeCheapestInsertion(o1, node);
				int b = computeCheapestInsertion(o2, node);
				return Integer.compare(a, b);
			}
		});
	}

	private int computeCheapestInsertion(UsedEdge usedEdge, Node newNode) {
		// Insertion Heuristics
		int Dik = E[usedEdge.getEdge().getStart().getId()][newNode.getId()].getDistance();
		int Dkj = E[newNode.getId()][usedEdge.getEdge().getEnd().getId()].getDistance();
		int Dij = usedEdge.getEdge().getDistance();
		return Dik + Dkj - Dij;
	}

	private int distance(Node a, Node b) {
		return E[a.getId()][b.getId()].getDistance();
	}
};