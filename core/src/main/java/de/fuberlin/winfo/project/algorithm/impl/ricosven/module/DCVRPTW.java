package de.fuberlin.winfo.project.algorithm.impl.ricosven.module;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.AlgHelper.ModRoute;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;

public class DCVRPTW {

	NetworkProvider network;
	Algorithm algorithm;
	int ordersCount = 0;

	public DCVRPTW(NetworkProvider network, Algorithm algorithm) {
		this.network = network;
		this.algorithm = algorithm;

	}

	public List<Route> run(List<Node> customers, Node depot, Vehicle vehicle) throws Exception {
		List<Route> routes = new ArrayList<>();
		List<Order> orders = getOrders(customers);
		ordersCount = orders.size();
		System.out.println("Orders: " + ordersCount);

		routes = initializeAndOptimizeRoutes(orders, depot, vehicle);

		List<Route> finalRoutes = new ArrayList<>();
		for (int i = 0; i < routes.size(); i++) {
			finalRoutes.add(((ModRoute) routes.get(i)).getRoute());
		}

		return finalRoutes;
	}

	private List<Order> getOrders(List<Node> customers) {

		List<Order> orders = new ArrayList<>();

		for (int i = 0; i < customers.size(); i++) {

			Locatable l = customers.get(i).getRepresentative();

			if (l instanceof Customer) {
				Locatable hasTP = ((Customer) l).getHasTranshipmentPoint();
				if (hasTP == null) {
					orders.addAll(((Customer) customers.get(i).getRepresentative()).getOwnedOrders());
				} else {
					orders.addAll(((Depot) hasTP).getDeliveries());
				}
			}
		}
		return orders;
	}

	private List<Route> initializeAndOptimizeRoutes(List<Order> orders, Node depot, Vehicle vehicle) throws Exception {

		List<Route> routes = new ArrayList<>();
		String format = "%-12s%-21s%-12s";

		while (!orders.isEmpty()) {
			// initialize with depot-customer-depot tour.
			Order order = orders.get(0);
			Route route = initializeTour(order, vehicle, depot);

			// Remove node from list containing remaining customer nodes
			orders.remove(0);

			// Fill tour until tour is complete
			orders = optimize(route, orders);

			// boolean afterwardsTour = true;
			//
			// while (afterwardsTour) {
			// afterwardsTour = initialize_Optimize_AfterwardsTour(route,
			// customers, depot);
			// if (afterwardsTour) {
			// System.out.println("afterwardsTour initialized");
			// }
			// }

			routes.add(route);

			ordersCount -= (route.getWay().size() - 1);
			String[] o = new String[] { "Route: " + routes.size(), "with orders: " + (route.getWay().size() - 1),
					"| Orders left: " + ordersCount };

			System.out.println(String.format(format, o));
		}
		return routes;
	}

	private List<Order> addOrdersWithoutTWtoRoutes(List<Route> routes, List<Order> orders) throws Exception {

		for (int i = 0; i < routes.size(); i++) {
			orders = optimize(routes.get(i), orders);
		}

		return orders;

	}

	/**
	 * Initialize a first depot-customer-depot route with a new vehicle being
	 * able with regard to PayLoad Capacity and max reach. <br>
	 * <br>
	 * Throws an exception if no vehicle could be found with properties required
	 * by given node.
	 */
	private Route initializeTour(Order firstOrder, Vehicle vehicle, Node depot) throws Exception {

		ModRoute modRoute = algorithm.buildRoute(vehicle, depot);

		modRoute.addDelivery(firstOrder);

		return modRoute;
	}

	private List<Order> optimize(Route route, List<Order> orders) throws Exception {

		while (!orders.isEmpty()) {
			Order bestOrder = getAndAddBestFittingOrder(route, orders);
			if (bestOrder != null) {
				orders.remove(bestOrder);
			} else {
				break;
			}
		}
		return orders;
	}

	private Order getAndAddBestFittingOrder(Route route, List<Order> orders) throws Exception {

		double saveCosts = Integer.MAX_VALUE;
		Order bestOrder = null;
		int indexToAddBestOrder = -1;

		// determine node costs and cache the lowest
		for (int orderIndex = 0; orderIndex < orders.size(); orderIndex++) {

			for (int usedEdgeIndex = 0; usedEdgeIndex < route.getWay().size(); usedEdgeIndex++) {

				if (checkRestrictions(route, orders.get(orderIndex), usedEdgeIndex)) {
					// Once all restrictions are met, cache the current
					// best
					// customer node candidate.
					double costs = calculateTimeCosts(usedEdgeIndex, route, orders.get(orderIndex));
					// double waitingTime =
					// calculateWaitingTime(nodeIndex,
					// usedEdgeIndex, route, customers);

					if (costs < saveCosts) {
						saveCosts = costs;
						bestOrder = orders.get(orderIndex);
						indexToAddBestOrder = usedEdgeIndex;
					}
				}
			}
		}
		if (bestOrder != null)
			((ModRoute) route).addDeliveryAtIndex(bestOrder, indexToAddBestOrder);
		return bestOrder;

	}

	private boolean checkRestrictions(Route route, Order order, int atIndex) throws Exception {

		// Restriction 1: is enough PayLoad available in case of
		// adding
		boolean capacity = ((ModRoute) route).isSufficientCargoCapacityAvailable(order);

		if (capacity) {

			// Restriction 2: are the timewindows respected
			boolean timeWindows = ((ModRoute) route).isSufficientTimeWindowAvailable(order, atIndex);

			if (timeWindows) {

				// Restriction 3: is enough Energie available in case of adding
				boolean energy = ((ModRoute) route).isSufficientEnergyAvailable(order, atIndex);

				if (energy) {
					// Restriction 2: is the max tour lenght respected
					boolean tourLenght = ((ModRoute) route).isSufficientTourLenghtAvailable(order, atIndex);

					if (tourLenght) {
						return true;
					}
				}
			}
		}

		return false;
	}

	private double calculateTimeCosts(int usedEdgeIndex, Route route, Order newOrder) {

		Node node = AlgHelper.getNodeByOrder(network, newOrder);

		double costs = network.getEdges()[route.getWay().get(usedEdgeIndex).getEdge().getStart().getId()][node.getId()]
				.getTime()
				+ network.getEdges()[node.getId()][route.getWay().get(usedEdgeIndex).getEdge().getEnd().getId()]
						.getTime()
				- route.getWay().get(usedEdgeIndex).getEdge().getTime();

		return costs;
	}
}

// private boolean initialize_Optimize_AfterwardsTour(Route route,
// List<Node> customers, Node depo) throws Exception {
// RestrictionChecker checkRestrictions = new RestrictionChecker(network,
// algorithm);
// for (int nodeIndex = 0; nodeIndex < customers.size(); nodeIndex++) {
// boolean foundNode = checkRestrictions.isTimeWindowViolationGivenBy(route,
// customers.get(nodeIndex));
// if (foundNode) {
// algorithm.useEdge(route,
// network.getEdges()[depo.getId()][customers.get(nodeIndex).getId()]);
// algorithm.useEdge(route,
// network.getEdges()[customers.get(nodeIndex).getId()][depo.getId()]);
// return true;
// }
// }
//
// return false;
// }

// /**
// *
// *
// */
// private double calculateWaitingTime(int nodeIndex, int usedEdgeIndex,
// Route route, List<Node> customers) {
//
// double edgeStartInSec =
// route.getWay().get(usedEdgeIndex).getDuration().getStartInSec();
// double timeStartNodeToNewNode =
// network.getEdges()[route.getWay().get(usedEdgeIndex).getEdge()
// .getStart().getId()][customers.get(nodeIndex).getId()].getTime();
// double newNode_TW_StartInSec =
// getTimeframeFromNode(customers.get(nodeIndex)).getStartInSec();
//
// double waitingTime = newNode_TW_StartInSec - timeStartNodeToNewNode -
// edgeStartInSec;
// return waitingTime;
// }
