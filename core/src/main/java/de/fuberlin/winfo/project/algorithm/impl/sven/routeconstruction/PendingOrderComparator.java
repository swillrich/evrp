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

		// initial pendulum tour (Nearest Neighbor)
		if (route.getActualRoute().getWay().isEmpty()) {
			return Double.compare(avgEnergyConsumption(route.getDepot(), n1),
					avgEnergyConsumption(route.getDepot(), n2));
		}

		int o1TWDiff = o1.getOrder().getTimeWindow().getEndInSec() - o1.getOrder().getTimeWindow().getStartInSec();
		int o2TWDiff = o2.getOrder().getTimeWindow().getEndInSec() - o2.getOrder().getTimeWindow().getStartInSec();

		UsedArc n1UsedArc = returnMin(n1);
		o1.setPos(route.getActualRoute().getWay().indexOf(n1UsedArc));

		UsedArc n2UsedArc = returnMin(n2);
		o2.setPos(route.getActualRoute().getWay().indexOf(n2UsedArc));

		int costs1 = calculateByInsertionHeuristics(n1UsedArc, n1);
		int costs2 = calculateByInsertionHeuristics(n2UsedArc, n2);
		
		int costsTotal = costs1 + costs2 == 0 ? 1 : costs1 + costs2;

		double totalCosts1 = 0.5 * (costs1 / (costsTotal)) + 0.5 * (o1TWDiff / (o1TWDiff + o2TWDiff));
		double totalCosts2 = 0.5 * (costs2 / (costsTotal)) + 0.5 * (o2TWDiff / (o1TWDiff + o2TWDiff));

		return Double.compare(totalCosts1, totalCosts2);
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
		int DikMax = E[usedArc.getArc().getStart().getId()][newVertex.getId()].getEnergyMax();
		int DikMin = E[usedArc.getArc().getStart().getId()][newVertex.getId()].getEnergyMin();
		int Dik = (DikMax + DikMin) / 2;

		int DkjMax = E[newVertex.getId()][usedArc.getArc().getEnd().getId()].getEnergyMax();
		int DkjMin = E[newVertex.getId()][usedArc.getArc().getEnd().getId()].getEnergyMin();
		int Dkj = (DkjMax + DkjMin) / 2;

		int DijMax = usedArc.getArc().getEnergyMax();
		int DijMin = usedArc.getArc().getEnergyMin();
		int Dij = (DijMax + DijMin) / 2;

		return Dik + Dkj - Dij;
	}

	private double avgEnergyConsumption(Vertex a, Vertex b) {
		Arc arc = E[a.getId()][b.getId()];
		return (arc.getEnergyMax() + arc.getEnergyMin()) / 2;
	}
};