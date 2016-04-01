package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.ExtendedRouteWrapper;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Delivery;

public class TimeWindowRestriction implements Restriction {

	private ExtendedRouteWrapper route;

	@Override
	public boolean check(NetworkProvider np, ExtendedRouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		this.route = route;

		double newOrder_TW_StartInSec = Double.MIN_VALUE;
		double newOrder_TW_EndInSec = Double.MAX_VALUE;
		if (newOrder.getTimeWindow() != null) {
			newOrder_TW_StartInSec = newOrder.getTimeWindow().getStartInSec();
			newOrder_TW_EndInSec = newOrder.getTimeWindow().getEndInSec();
		}
		double edgeStartInSec = route.getModelRoute().getWay().get(index).getDuration().getStartInSec();
		double edgeEndInSec = route.getModelRoute().getWay().get(index).getDuration().getEndInSec();

		Node newNode = AlgHelper.getNodeByOrder(np, newOrder);
		double serviceTimeAtNewNode = newOrder.getStandingTimeInSec();
		double timeStartNodeToNewNode = np.getEdges()[route.getModelRoute().getWay().get(index).getEdge().getStart()
				.getId()][newNode.getId()].getTime();
		double timeNewNodeToEndNode = np.getEdges()[newNode.getId()][route.getModelRoute().getWay().get(index)
				.getEdge().getEnd().getId()].getTime();
		double actualUsedTime = route.getModelRoute().getWay().get(index).getEdge().getTime();
		double possibleShiftEdgeStart = getPossibleShiftEdgeStart(index);
		double possibleShiftEdgeEnd = getPossibleShiftEdgeEnd(index);

		double availableTime = possibleShiftEdgeStart + actualUsedTime + possibleShiftEdgeEnd;

		double neededTime = timeStartNodeToNewNode + serviceTimeAtNewNode + timeNewNodeToEndNode;

		if (availableTime >= neededTime) {
			if (edgeStartInSec + timeStartNodeToNewNode - possibleShiftEdgeStart <= newOrder_TW_EndInSec && edgeEndInSec
					- timeNewNodeToEndNode - serviceTimeAtNewNode + possibleShiftEdgeEnd >= newOrder_TW_StartInSec) {
				return true;
			}
		}
		return false;
	}

	private double getPossibleShiftEdgeEnd(int usedEdgeIndex) {
		double possibleShiftEdgeEnd = Double.MAX_VALUE;
		for (int i = usedEdgeIndex; i < route.getModelRoute().getWay().size(); i++) {
			double tmpEdgeEndInSec = route.getModelRoute().getWay().get(i).getDuration().getEndInSec();

			double timewindowEndAtEdgeEnd;

			if (i == route.getModelRoute().getWay().size() - 1) {
				timewindowEndAtEdgeEnd = getTimewindowFromDepot(route.getDepot()).getEndInSec();
			} else {
				timewindowEndAtEdgeEnd = Double.MAX_VALUE;
				Duration timewindowAtEdgeEnd = ((Delivery) route.getModelRoute().getWay().get(i)).getOrder()
						.getTimeWindow();
				if (timewindowAtEdgeEnd != null)
					timewindowEndAtEdgeEnd = timewindowAtEdgeEnd.getEndInSec();
			}
			double possibleShiftEdgeEndAtThisEdge = timewindowEndAtEdgeEnd - tmpEdgeEndInSec;

			if (possibleShiftEdgeEndAtThisEdge < possibleShiftEdgeEnd) {
				possibleShiftEdgeEnd = possibleShiftEdgeEndAtThisEdge;
			}
		}
		return possibleShiftEdgeEnd;
	}

	private double getPossibleShiftEdgeStart(int usedEdgeIndex) {
		double possibleShiftEdgeStart = Double.MAX_VALUE;
		for (int i = 0; i < usedEdgeIndex + 1; i++) {
			double tmpEdgeStartInSec = route.getModelRoute().getWay().get(i).getDuration().getStartInSec();

			double timewindowStartAtEdgeStart;
			double serviceTimeAtEdgeStart;

			if (i == 0) {
				timewindowStartAtEdgeStart = getTimewindowFromDepot(route.getDepot()).getStartInSec();
				serviceTimeAtEdgeStart = 0; // The service time at the depot
											// is
											// zero at the beginning of the
											// route, else
											// getServiceTimeFromDepot(node);
			} else {
				serviceTimeAtEdgeStart = ((Delivery) route.getModelRoute().getWay().get(i - 1)).getOrder()
						.getStandingTimeInSec();

				timewindowStartAtEdgeStart = Double.MIN_VALUE;
				Duration timewindowAtEdgeStart = ((Delivery) route.getModelRoute().getWay().get(i - 1)).getOrder()
						.getTimeWindow();
				if (timewindowAtEdgeStart != null)
					timewindowStartAtEdgeStart = timewindowAtEdgeStart.getStartInSec();
			}
			double possibleShiftEdgeStartAtThisEdge = tmpEdgeStartInSec - serviceTimeAtEdgeStart
					- timewindowStartAtEdgeStart;

			if (possibleShiftEdgeStartAtThisEdge < possibleShiftEdgeStart) {
				possibleShiftEdgeStart = possibleShiftEdgeStartAtThisEdge;
			}
		}
		return possibleShiftEdgeStart;
	}

	private Duration getTimewindowFromDepot(Node node) {

		Locatable l = node.getRepresentative();

		if (l instanceof Depot) {
			return ((Depot) node.getRepresentative()).getTimeWindow();
		} else {
			return ((Customer) node.getRepresentative()).getHasTranshipmentPoint().getTimeWindow();
		}
	}

	@Override
	public String getFailureMessage() {
		return "Time Window violation";
	}

}
