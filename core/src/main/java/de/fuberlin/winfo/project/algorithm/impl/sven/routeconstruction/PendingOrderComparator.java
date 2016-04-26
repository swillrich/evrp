package de.fuberlin.winfo.project.algorithm.impl.sven.routeconstruction;

import java.util.Collections;
import java.util.Comparator;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vertex;

public class PendingOrderComparator implements Comparator<PendingOrder> {
	private RouteWrapper route;
	private Arc[][] E;

	public PendingOrderComparator(RouteWrapper route, NetworkProvider np) {
		this.route = route;
		this.E = np.getArcs();
	}

	@Override
	public int compare(PendingOrder o1, PendingOrder o2) {
		Vertex n1 = o1.getOrder();
		Vertex n2 = o2.getOrder();

		if (o1.getOrder().getTimeWindow() != null && o2.getOrder().getTimeWindow() == null) {
			return -1;
		} else if (o1.getOrder().getTimeWindow() == null && o2.getOrder().getTimeWindow() != null) {
			return 1;
		}

		// initial pendulum tour (Nearest Neighbor)
		if (route.getActualRoute().getWay().isEmpty()) {
			return Integer.compare(distance(route.getDepot(), n1), distance(route.getDepot(), n2));
		}

		UsedArc n1UsedArc = returnMin(n1);
		o1.setPos(route.getActualRoute().getWay().indexOf(n1UsedArc));

		UsedArc n2UsedArc = returnMin(n2);
		o2.setPos(route.getActualRoute().getWay().indexOf(n2UsedArc));

		int costs1 = calculateByInsertionHeuristics(n1UsedArc, n1);
		int costs2 = calculateByInsertionHeuristics(n2UsedArc, n2);

		return Integer.compare(costs1, costs2);
	}

	private UsedArc returnMin(Vertex vertex) {
		return Collections.min(route.getActualRoute().getWay(), new Comparator<UsedArc>() {
			@Override
			public int compare(UsedArc o1, UsedArc o2) {
				int a = calculateByInsertionHeuristics(o1, vertex);
				int b = calculateByInsertionHeuristics(o2, vertex);
				return Integer.compare(a, b);
			}
		});
	}

	private int calculateByInsertionHeuristics(UsedArc usedArc, Vertex newVertex) {
		// Insertion Heuristics
		int Dik = E[usedArc.getArc().getStart().getId()][newVertex.getId()].getDistance();
		int Dkj = E[newVertex.getId()][usedArc.getArc().getEnd().getId()].getDistance();
		int Dij = usedArc.getArc().getDistance();
		return Dik + Dkj - Dij;
	}

	private int distance(Vertex a, Vertex b) {
		return E[a.getId()][b.getId()].getDistance();
	}
};