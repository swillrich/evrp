package de.fuberlin.winfo.project.algorithm.restriction.impl;

import org.eclipse.emf.common.util.EList;

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
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		Route r = route.getActualRoute();
		Arc[][] A = np.getArcs();
		int maxTourLength = getDepot(r).getMaxTourLength();
		int startA = r.getWay().get(0).getDuration().getStartInSec();
		int stopA = r.getWay().get(index).getDuration().getStartInSec();
		int interDur = A[r.getWay().get(index).getArc().getStart().getId()][newOrder.getId()].getTime();
		if (stopA + interDur < newOrder.getTimeWindow().getStartInSec()) {
			interDur = newOrder.getTimeWindow().getStartInSec();
		}
		interDur += newOrder.getStandingTimeInSec();
		interDur += A[newOrder.getId()][r.getWay().get(index).getArc().getEnd().getId()].getTime();
		int startB = r.getWay().get(index).getDuration().getEndInSec();
		int stopB = r.getWay().get(r.getWay().size() - 1).getDuration().getEndInSec();

		return (stopA - startA) + interDur + (stopB - startB) <= maxTourLength;
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
		return "Max Tour Violation";
	}

}
