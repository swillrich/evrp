package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class TimeWindowRestriction implements Restriction {

	private RouteWrapper route;

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		this.route = route;

		double newOrder_TW_StartInSec = Double.MIN_VALUE;
		double newOrder_TW_EndInSec = Double.MAX_VALUE;
		if (newOrder.getTimeWindow() != null) {
			newOrder_TW_StartInSec = newOrder.getTimeWindow().getStartInSec();
			newOrder_TW_EndInSec = newOrder.getTimeWindow().getEndInSec();
		}
		double arcStartInSec = route.getActualRoute().getWay().get(index).getDuration().getStartInSec();
		double arcEndInSec = route.getActualRoute().getWay().get(index).getDuration().getEndInSec();

		double serviceTimeAtNewVertex = newOrder.getStandingTimeInSec();
		double timeStartVertexToNewVertex = np.getArcs()[route.getActualRoute().getWay().get(index).getArc().getStart()
				.getId()][newOrder.getId()].getTime();
		double timeNewVertexToEndVertex = np.getArcs()[newOrder.getId()][route.getActualRoute().getWay().get(index)
				.getArc().getEnd().getId()].getTime();
		double actualUsedTime = route.getActualRoute().getWay().get(index).getArc().getTime();
		double possibleShiftarcStart = getPossibleShiftarcStart(index);
		double possibleShiftarcEnd = getPossibleShiftarcEnd(index);

		double availableTime = possibleShiftarcStart + actualUsedTime + possibleShiftarcEnd;

		double neededTime = timeStartVertexToNewVertex + serviceTimeAtNewVertex + timeNewVertexToEndVertex;

		if (availableTime >= neededTime) {
			if (arcStartInSec + timeStartVertexToNewVertex - possibleShiftarcStart <= newOrder_TW_EndInSec
					&& arcEndInSec - timeNewVertexToEndVertex - serviceTimeAtNewVertex
							+ possibleShiftarcEnd >= newOrder_TW_StartInSec) {
				return true;
			}
		}
		return false;
	}

	private double getPossibleShiftarcEnd(int usedarcIndex) {
		double possibleShiftarcEnd = Double.MAX_VALUE;
		for (int i = usedarcIndex; i < route.getActualRoute().getWay().size(); i++) {
			double tmparcEndInSec = route.getActualRoute().getWay().get(i).getDuration().getEndInSec();

			double timewindowEndAtarcEnd;

			if (i == route.getActualRoute().getWay().size() - 1) {
				timewindowEndAtarcEnd = Utils.getTimeWindow(route.getDepot()).getEndInSec();
			} else {
				timewindowEndAtarcEnd = Double.MAX_VALUE;
				Duration timewindowAtarcEnd = Utils
						.getTimeWindow(route.getActualRoute().getWay().get(i).getArc().getEnd());
				if (timewindowAtarcEnd != null)
					timewindowEndAtarcEnd = timewindowAtarcEnd.getEndInSec();
			}
			double possibleShiftarcEndAtThisarc = timewindowEndAtarcEnd - tmparcEndInSec;

			if (possibleShiftarcEndAtThisarc < possibleShiftarcEnd) {
				possibleShiftarcEnd = possibleShiftarcEndAtThisarc;
			}
		}
		return possibleShiftarcEnd;
	}

	private double getPossibleShiftarcStart(int usedarcIndex) {
		double possibleShiftarcStart = Double.MAX_VALUE;
		for (int i = 0; i < usedarcIndex + 1; i++) {
			double tmparcStartInSec = route.getActualRoute().getWay().get(i).getDuration().getStartInSec();

			double timewindowStartAtarcStart;
			double serviceTimeAtArcStart;

			if (i == 0) {
				timewindowStartAtarcStart = Utils.getTimeWindow(route.getDepot()).getStartInSec();
				serviceTimeAtArcStart = 0; // The service time at the depot
											// is
											// zero at the beginning of the
											// route, else
											// getServiceTimeFromDepot(vertex);
			} else {
				serviceTimeAtArcStart = ((Order) route.getActualRoute().getWay().get(i - 1).getArc().getEnd())
						.getStandingTimeInSec();

				timewindowStartAtarcStart = Double.MIN_VALUE;
				Duration timewindowAtArcStart = ((Order) route.getActualRoute().getWay().get(i - 1).getArc().getEnd())
						.getTimeWindow();
				if (timewindowAtArcStart != null)
					timewindowStartAtarcStart = timewindowAtArcStart.getStartInSec();
			}
			double possibleShiftarcStartAtThisarc = tmparcStartInSec - serviceTimeAtArcStart
					- timewindowStartAtarcStart;

			if (possibleShiftarcStartAtThisarc < possibleShiftarcStart) {
				possibleShiftarcStart = possibleShiftarcStartAtThisarc;
			}
		}
		return possibleShiftarcStart;
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
					return true;
				}
				return usedArc.getDuration().getEndInSec() <= orderTW.getEndInSec();
			}
		}
		return true;
	}

}
