package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vertex;

public class KOptHeuristicRouteAdapter {

	public static List<Pair> getPairs(Route route) {
		List<Pair> l = new ArrayList<Pair>();
		for (UsedArc usedArc : route.getWay()) {
			final Arc arc = usedArc.getArc();
			l.add(new Pair() {

				@Override
				public int getStart() {
					return arc.getStart().getId();
				}

				@Override
				public int getEnd() {
					return arc.getEnd().getId();
				}
			});
		}
		return l;
	}

	public static List<UsedArc> getRoute(NetworkProvider networkProvider, RouteWrapper wrapper, List<Pair> pairs) {
		Vertex[] V = networkProvider.getVertices();
		List<UsedArc> newUsedArcList = new ArrayList<UsedArc>();
		for (int i = 0; i < pairs.size(); i++) {
			Pair pair = pairs.get(i);
			Vertex startOrder = V[pair.getStart()];
			Vertex endOrder = V[pair.getEnd()];
			Arc arc = networkProvider.getArcs()[startOrder.getId()][endOrder.getId()];
			UsedArc newArc = RouteWrapper.initializeUsedArc(arc);
			newUsedArcList.add(newArc);
			if (i < pairs.size() - 1) {
				Vertex startV = V[pair.getEnd()];
				Vertex endV = V[pairs.get(i + 1).getStart()];
				List<UsedArc> usedArcsBetween = wrapper.getUsedArcsBetween(startV, endV);
				newUsedArcList.addAll(usedArcsBetween);
			}
		}
		return newUsedArcList;
	}

}
