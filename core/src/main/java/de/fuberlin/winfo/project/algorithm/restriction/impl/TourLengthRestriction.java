package de.fuberlin.winfo.project.algorithm.restriction.impl;

import static de.fuberlin.winfo.project.algorithm.AlgHelper.getLocatable;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class TourLengthRestriction implements Restriction {

	private ExtRoute route;
	private NetworkProvider np;

	@Override
	public boolean check(NetworkProvider np, ExtRoute route, Order newOrder, int index)
			throws RestrictionException {

		this.route = route;
		this.np = np;

		int maxTourLenght = getMaxTourLenght();

		if (maxTourLenght == -1) {
			return true;
		}

		List<UsedEdge> way = addTempOrderToRoute(newOrder, index);
		int tourLenght = getTourLength(way);

		return tourLenght <= maxTourLenght;
	}

	public int getMaxTourLenght() {

		Locatable l = route.getDepot().getRepresentative();

		if (l instanceof Depot) {
			return ((Depot) l).getMaxTourLength();
		} else {
			if (l instanceof Customer) {
				Customer c = (Customer) l;
				if (c.getHasTranshipmentPoint() != null) {
					return ((Depot) c.getHasTranshipmentPoint()).getMaxTourLength();
				}
			}
		}
		return 0;
	}

	private int getTimeWindowStartFromEndNodeFromEdge(List<UsedEdge> way, int edgeIndex) {
		int startTimeWindowAtEdgeEnd = 0;
		if (way.get(edgeIndex) instanceof Delivery) {
			try {
				startTimeWindowAtEdgeEnd = ((Delivery) way.get(edgeIndex)).getOrder().getTimeWindow().getStartInSec();
			} catch (NullPointerException npe) {
				startTimeWindowAtEdgeEnd = 0;
			}
		} else {
			Locatable locatable = way.get(edgeIndex).getEdge().getEnd().getRepresentative();
			if (locatable instanceof Depot) {
				startTimeWindowAtEdgeEnd = ((Depot) locatable).getTimeWindow().getStartInSec();
			} else {
				Depot transhipmentPoint = ((Customer) locatable).getHasTranshipmentPoint();
				if (transhipmentPoint != null) {
					startTimeWindowAtEdgeEnd = transhipmentPoint.getTimeWindow().getStartInSec();
				}
			}
		}
		return startTimeWindowAtEdgeEnd;
	}

	private int getTourLength(List<UsedEdge> way) {
		int tourLenght = 0;
		int tourStart = getLocatable(route.getDepot().getRepresentative(), Depot.class).getTimeWindow().getStartInSec();
		for (int i = 0; i < way.size(); i++) {

			int edgeTime = way.get(i).getEdge().getTime();
			int startTimeWindowAtEdgeEnd = getTimeWindowStartFromEndNodeFromEdge(way, i);
			int serviceTimeAtEdgeEnd = 0;
			if (way.get(i) instanceof Delivery) {
				serviceTimeAtEdgeEnd = ((Delivery) way.get(i)).getOrder().getStandingTimeInSec();
			}

			if (i == 0) {
				if (tourStart + edgeTime < startTimeWindowAtEdgeEnd) {
					tourStart = startTimeWindowAtEdgeEnd - edgeTime;
				}
				tourLenght = edgeTime + serviceTimeAtEdgeEnd;
			} else {

				if (tourStart + tourLenght + edgeTime < startTimeWindowAtEdgeEnd) {
					tourLenght = startTimeWindowAtEdgeEnd - tourStart + serviceTimeAtEdgeEnd;
				} else {
					tourLenght += edgeTime + serviceTimeAtEdgeEnd;
				}
			}
		}
		return tourLenght;
	}

	private List<UsedEdge> addTempOrderToRoute(Order order, int usedEdgeIndex) {
		List<UsedEdge> way = new ArrayList<>();
		way.addAll(route.getModelRoute().getWay());
		Node nodeBeforeInsertion = route.getModelRoute().getWay().get(usedEdgeIndex).getEdge().getStart();
		Node newNode = AlgHelper.getNodeByOrder(np, order);
		Node nodeAfterInsertion = route.getModelRoute().getWay().get(usedEdgeIndex).getEdge().getEnd();

		Edge edgeToNewOrder = np.getEdges()[nodeBeforeInsertion.getId()][newNode.getId()];
		Edge edgeFromNewOrder = np.getEdges()[newNode.getId()][nodeAfterInsertion.getId()];

		Delivery deliveryToNewOrder = np.getSolutionFactory().createDelivery();
		deliveryToNewOrder.setOrder(order);
		deliveryToNewOrder.setEdge(edgeToNewOrder);

		UsedEdge usedEdgeFromNewOrder;

		if (route.getModelRoute().getWay().get(usedEdgeIndex) instanceof Delivery) {
			Order orderAfterInsertion = ((Delivery) route.getModelRoute().getWay().get(usedEdgeIndex)).getOrder();
			usedEdgeFromNewOrder = np.getSolutionFactory().createDelivery();
			((Delivery) usedEdgeFromNewOrder).setOrder(orderAfterInsertion);
			((Delivery) usedEdgeFromNewOrder).setEdge(edgeFromNewOrder);
		} else {
			usedEdgeFromNewOrder = np.getSolutionFactory().createUsedEdge();
			usedEdgeFromNewOrder.setEdge(edgeFromNewOrder);
		}

		way.remove(usedEdgeIndex);
		way.add(usedEdgeIndex, usedEdgeFromNewOrder);
		way.add(usedEdgeIndex, deliveryToNewOrder);

		return way;
	}

	@Override
	public String getFailureMessage() {
		return "Max tour length exceedance";
	}

}
