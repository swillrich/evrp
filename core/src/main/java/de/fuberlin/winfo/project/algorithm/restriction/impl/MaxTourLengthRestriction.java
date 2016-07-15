package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class MaxTourLengthRestriction implements Restriction {

	private Depot getDepot(Route route) {
		UsedArc firstArc = route.getWay().get(0);
		Depot start = (Depot) firstArc.getArc().getStart();
		return start;
	}

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order o, int index)
			throws RestrictionException {
		Route r = route.getActualRoute();
		Arc[][] A = np.getArcs();
		int departureAt0 = r.getWay().get(0).getDuration().getStartInSec();
		int departure = r.getWay().get(index).getDuration().getStartInSec();
		int arrivalO = departure + A[r.getWay().get(index).getArc().getStart().getId()][o.getId()].getTime();
		if (arrivalO < o.getTimeWindow().getStartInSec()) {
			arrivalO = o.getTimeWindow().getStartInSec();
			if (index == 0) {
				departureAt0 = o.getTimeWindow().getStartInSec()
						- A[r.getWay().get(index).getArc().getStart().getId()][o.getId()].getTime();
			}
		}
		Arc toBArc = A[o.getId()][r.getWay().get(index).getArc().getEnd().getId()];
		int arrival = arrivalO + o.getStandingTimeInSec() + toBArc.getTime();

		if (index >= r.getWay().size() - 1) {
			return arrival - departureAt0 <= getDepot(r).getMaxTourLength();
		}

		for (int i = index; i < r.getWay().size() - 1; i++) {
			UsedArc usedArc = r.getWay().get(i);
			Order cO = (Order) usedArc.getArc().getEnd();
			if (arrival < cO.getTimeWindow().getStartInSec()) {
				arrival = cO.getTimeWindow().getStartInSec();
			}
			arrival = arrival + cO.getStandingTimeInSec() + r.getWay().get(i + 1).getArc().getTime();
			if (arrival - departureAt0 > getDepot(r).getMaxTourLength()) {
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException {
		UsedArc firstArc = route.getActualRoute().getWay().get(0);
		int sec = route.getActualRoute().getWay().get(route.getActualRoute().getWay().size() - 1).getDuration()
				.getEndInSec();
		return sec - firstArc.getDuration().getStartInSec() <= getDepot(route.getActualRoute()).getMaxTourLength();
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

	@Override
	public String getFailureMessage() {
		return "Max Tour Length Violation";
	}

}
