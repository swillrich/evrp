package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class TimeWindowRestriction implements Restriction {

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order o, int index)
			throws RestrictionException {
		Route r = route.getActualRoute();
		Arc[][] A = np.getArcs();
		int departure = r.getWay().get(index).getDuration().getStartInSec();
		if (index == 0) {
			int driveTime = A[route.getDepot().getId()][o.getId()].getTime();
			int startInSec = o.getTimeWindow().getStartInSec();
			if (startInSec - driveTime > ((Depot) route.getDepot()).getTimeWindow().getStartInSec()) {
				departure = startInSec - driveTime;
			} else {
				departure = RouteWrapper.getDepot(r).getTimeWindow().getStartInSec();
			}
		}

		int arrivalO = departure + A[r.getWay().get(index).getArc().getStart().getId()][o.getId()].getTime();

		if (arrivalO > o.getTimeWindow().getEndInSec()) {
			return false;
		}

		if (arrivalO < o.getTimeWindow().getStartInSec()) {
			arrivalO = o.getTimeWindow().getStartInSec();
		}

		Arc toBArc = A[o.getId()][r.getWay().get(index).getArc().getEnd().getId()];
		int arrival = arrivalO + o.getStandingTimeInSec() + toBArc.getTime();

		for (int i = index; i < r.getWay().size() - 1; i++) {
			UsedArc usedArc = r.getWay().get(i);
			Order cO = (Order) usedArc.getArc().getEnd();
			// extracted(r, i, arrival, usedArc);
			if (arrival > cO.getTimeWindow().getEndInSec()) {
				return false;
			}
			if (arrival < cO.getTimeWindow().getStartInSec()) {
				arrival = cO.getTimeWindow().getStartInSec();
			}

			arrival = arrival + cO.getStandingTimeInSec() + r.getWay().get(i + 1).getArc().getTime();
		}
		// extracted(r, r.getWay().size() - 1, arrival,
		// r.getWay().get(r.getWay().size() - 1));
		return arrival <= RouteWrapper.getDepot(r).getTimeWindow().getEndInSec();
	}

	private void extracted(Route r, int i, int arrival, UsedArc usedArc) {
		System.out.println("P:" + arrival + " < " + Utils.getTimeWindow(usedArc.getArc().getEnd()).getEndInSec() + " "
				+ i + " / " + (r.getWay().size() - 1));
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
				if (usedArc.getDuration().getEndInSec() > orderTW.getEndInSec()) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	public boolean checkSolution(NetworkProvider np, Solution solution) {
		for (Route route : solution.getRoutes()) {
			try {
				if (!checkCompleteRoute(np, new RouteWrapper(route, null, np.getArcs()))) {
					return false;
				}
			} catch (RestrictionException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

}
