package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vertex;

public class TimeWindowRestriction implements Restriction {

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int at)
			throws RestrictionException {
		Route r = route.getActualRoute();
		Arc[][] A = np.getArcs();
		int timeToNewOrder = A[r.getWay().get(at).getArc().getStart().getId()][newOrder.getId()].getTime();
		int timeFromNewOrder = A[newOrder.getId()][r.getWay().get(at).getArc().getEnd().getId()].getTime();

		int arrival = r.getWay().get(at).getDuration().getStartInSec() + timeToNewOrder;
		if (arrival < newOrder.getTimeWindow().getStartInSec()) {
			arrival = newOrder.getTimeWindow().getStartInSec();
		}
		int departure = arrival + newOrder.getStandingTimeInSec();
		int offSet = departure + timeFromNewOrder - r.getWay().get(at).getDuration().getEndInSec();
		
		Vertex v;

		for (int i = -1; i < r.getWay().size() - at; i++) {
			if (i < 0) {
				v = newOrder;
			} else {
				arrival = r.getWay().get(at + i).getDuration().getEndInSec() + offSet;
				v = r.getWay().get(at + i).getArc().getEnd();
			}
			if (arrival > RouteWrapper.getTimeWindowEnd(v)) {
				return false;
			}

			if (v instanceof Order && ((Order) v).getOrderId().equalsIgnoreCase("Mu-1327")) {
				// 20:15:35 | 20:15:35 | 00:00:00 - 16:00:00
				int end = RouteWrapper.getTimeWindowEnd(v);
				System.out.println(r.getWay().get(at + i).getDuration().getEndInSec() + " + " + offSet + " (" + arrival
						+ ") <= " + end);
			}
		}
		return true;
	}

	@Override
	public String getFailureMessage() {
		return "Time Window violation";
	}

	@Override
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException {
		for (int i = 0; i < route.getActualRoute().getWay().size(); i++) {
			UsedArc usedArc = route.getActualRoute().getWay().get(i);
			if (usedArc.getArc().getEnd() instanceof Order) {
				Order del = (Order) usedArc.getArc().getEnd();
				Duration orderTW = del.getTimeWindow();
				if (orderTW == null) {
					continue;
				} else if (usedArc.getDuration().getEndInSec() > orderTW.getEndInSec()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean checkSolution(NetworkProvider np, Solution solution) {
		// TODO Auto-generated method stub
		return true;
	}

}
