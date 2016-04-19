package de.fuberlin.winfo.project.algorithm;

import static de.fuberlin.winfo.project.algorithm.AlgHelper.computeEnergyConsumptionOfEdge;
import static de.fuberlin.winfo.project.algorithm.AlgHelper.getNodeByOrder;
import static de.fuberlin.winfo.project.algorithm.AlgHelper.getTimeWindow;

import java.util.List;
import java.util.TreeSet;

import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.SolutionFactory;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

public class RouteWrapper extends TreeSet<UsedEdge> {
	private Route route;
	private SolutionFactory solutionFactory = new SolutionFactoryImpl();
	private NetworkFactory networkFactory = new NetworkFactoryImpl();
	private Node depot;
	private Edge[][] E;

	public RouteWrapper(Route route, Node depot, Edge[][] edges) {
		this.route = route;
		this.E = edges;
		if (depot == null) {
			this.depot = route.getWay().get(0).getEdge().getStart();
		} else {
			this.depot = depot;
		}
	}

	public Route getActualRoute() {
		return route;
	}

	public Node getDepot() {
		return depot;
	}

	/**
	 * Computation of the remaining vehicle battery capacity in KW. <br>
	 * <br>
	 * Precondition for executing this method is pre-calculating all remaining
	 * cargo capacity values for each node.
	 * 
	 * @throws Exception
	 */
	public double computePredictedRemainingVehicleBatteryCapacity(int until, double extraNeed, boolean withUpdate)
			throws Exception {
		if (until == -1) {
			until = route.getWay().size();
		}
		Vehicle vehicle = route.getVehicle();
		int capLeft = vehicle.getBatteryCapacityInWh();

		for (int i = 0; i < until; i++) {
			UsedEdge usedEdge = route.getWay().get(i);

			capLeft = capLeft - (int) computeEnergyConsumptionOfEdge(vehicle,
					usedEdge.getCurrentVehicleCargoWeight() + extraNeed, usedEdge.getEdge().getDistance());

			if (withUpdate) {
				usedEdge.setRemainingVehicleBatteryCapacityAtEnd((int) capLeft);
			}
		}
		return capLeft;
	}

	private void reinitializeRoute() throws Exception {
		route.setTotalDistanceInM(0);
		route.setTotalTimeInSec(0);
		for (int i = 0; i < route.getWay().size(); i++) {
			UsedEdge usedEdge = route.getWay().get(i);

			if (i > 0) {
				boolean endEqualsStart = route.getWay().get(i - 1).getEdge().getEnd() == route.getWay().get(i).getEdge()
						.getStart();
				if (!endEqualsStart) {
					print();
					throw new Exception("End id is not equal to start id at index " + i);
				}
			}

			computeDepature(i, usedEdge);

			computeArrival(usedEdge);

			/*
			 * COMPUTATION OF VEHICLE PAYLOAD FOR EACH NODE
			 * 
			 * If the vehicle is driving to a customer, the customer need is
			 * considered. This procedure works inverse. Put another way, it's
			 * an iterative loop, which starts at end and terminates at start.
			 * Only this way it's possible to compute the current weight at each
			 * position correctly.
			 */
			UsedEdge fromBehindUsedEdge = route.getWay().get(route.getWay().size() - 1 - i);
			if (route.getWay().size() - i < route.getWay().size()) {

				double weightInKg = route.getWay().get(route.getWay().size() - i).getCurrentVehicleCargoWeight();

				if (fromBehindUsedEdge instanceof Delivery) {
					Delivery delivery = (Delivery) fromBehindUsedEdge;
					weightInKg += delivery.getOrder().getWeight();
				}
				fromBehindUsedEdge.setCurrentVehicleCargoWeight(weightInKg);
			}

			route.setTotalDistanceInM(route.getTotalDistanceInM() + usedEdge.getEdge().getDistance());
		}

		/*
		 * COMPUTATION OF THE REMAINING VEHICLE BATTERY KW
		 */
		computePredictedRemainingVehicleBatteryCapacity(-1, 0, true);

		int totalRouteTime = route.getWay().get(route.getWay().size() - 1).getDuration().getEndInSec()
				- route.getWay().get(0).getDuration().getStartInSec();
		route.setTotalTimeInSec(totalRouteTime);

		takeCareOfSolutionValues();
	}

	public void takeCareOfSolutionValues() {
		if (route.eContainer() != null && route.eContainer() instanceof Solution) {
			Solution solution = (Solution) route.eContainer();
			long distance = solution.getRoutes().stream().mapToLong(r -> r.getTotalDistanceInM()).sum();
			solution.setTotalDistance(distance);

			long time = solution.getRoutes().stream().mapToLong(r -> r.getTotalTimeInSec()).sum();
			solution.setTotalTime(time);
		}
	}

	private void computeArrival(UsedEdge usedEdge) {
		/*
		 * ARRIVAL COMPUTATION
		 */
		Duration timeWindow = getTimeWindow(usedEdge, false);
		if (timeWindow != null) {
			int startInSecByTW = timeWindow.getStartInSec();
			int arrival = usedEdge.getDuration().getStartInSec() + usedEdge.getEdge().getTime();
			if (arrival > startInSecByTW) {
				// If the arrival lies behind the Time Window Start
				usedEdge.getDuration().setEndInSec(arrival);
			} else {
				usedEdge.getDuration().setEndInSec(startInSecByTW);
			}
		} else {
			// without time windows, only the time consumed by the link
			// itself is considered
			usedEdge.getDuration().setEndInSec(usedEdge.getDuration().getStartInSec() + usedEdge.getEdge().getTime());
		}
	}

	private void computeDepature(int i, UsedEdge usedEdge) {
		/*
		 * DEPARTURE COMPUTATION
		 */
		if (i > 0) {
			// retrieves the previous UsedEdge
			UsedEdge prevUE = route.getWay().get(i - 1);

			// compute start time
			int time = prevUE.getDuration().getEndInSec() + AlgHelper.getServiceTimeAtEdgeEnd(prevUE);
			usedEdge.getDuration().setStartInSec(time);
		} else {
			// compute start time if the first edge is given

			Duration srcTimeWindow = getTimeWindow(usedEdge, true);
			int startInSecFromStartByTW = srcTimeWindow.getStartInSec();
			int driveTime = usedEdge.getEdge().getTime();
			int start = startInSecFromStartByTW;

			Duration targetTimeWindow = ((Delivery) usedEdge).getOrder().getTimeWindow();

			if (targetTimeWindow != null) {
				int startInSec = targetTimeWindow.getStartInSec();
				if (startInSec - driveTime > startInSecFromStartByTW) {
					start = startInSec - driveTime;
				}
			}

			usedEdge.getDuration().setStartInSec(start);
		}
	}

	public UsedEdge initializeUsedEdge(Edge edge, Order order) {
		if (edge == null) {
			throw new NullPointerException("Edge must not be null");
		}
		UsedEdge usedEdge = null;
		if (order != null) {
			usedEdge = solutionFactory.createDelivery();
			((Delivery) usedEdge).setOrder(order);
		} else {
			usedEdge = solutionFactory.createUsedEdge();
		}
		usedEdge.setEdge(edge);
		usedEdge.setDuration(networkFactory.createDuration());
		return usedEdge;
	}

	public void addDelivery(Order order) throws Exception {
		if (route.getWay().isEmpty()) {

			Node newNode = getNodeByOrder(order);

			Edge edgeToNewNode = E[depot.getId()][newNode.getId()];
			UsedEdge usedEdgeToNewNode = initializeUsedEdge(edgeToNewNode, order);
			route.getWay().add(usedEdgeToNewNode);

			Edge edgeFromNewNode = E[newNode.getId()][depot.getId()];
			UsedEdge usedEdgeFromNewNode = initializeUsedEdge(edgeFromNewNode, null);
			route.getWay().add(usedEdgeFromNewNode);

			reinitializeRoute();

		} else {
			addDeliveryAtIndex(order, route.getWay().size() - 1);
		}
	}

	public void addDeliveryAtIndex(Order order, int i) throws Exception {
		Node newNode = getNodeByOrder(order);

		UsedEdge edgeToDelete = route.getWay().get(i);
		Edge edgeToNewNode = E[edgeToDelete.getEdge().getStart().getId()][newNode.getId()];
		UsedEdge usedEdgeToNewNode = initializeUsedEdge(edgeToNewNode, order);
		Edge edgeFromNewNode = E[newNode.getId()][edgeToDelete.getEdge().getEnd().getId()];

		Order order2 = null;
		if (edgeToDelete instanceof Delivery) {
			order2 = ((Delivery) edgeToDelete).getOrder();
		}
		UsedEdge usedEdgeFromNewNode = initializeUsedEdge(edgeFromNewNode, order2);

		route.getWay().remove(i);
		route.getWay().add(i, usedEdgeFromNewNode);
		route.getWay().add(i, usedEdgeToNewNode);

		reinitializeRoute();
	}

	public void replaceSubRoute(List<UsedEdge> newUsedEdgeList, int start, int end) throws Exception {
		for (int i = start; i <= end; i++) {
			route.getWay().remove(start);
		}
		route.getWay().addAll(start, newUsedEdgeList);
		reinitializeRoute();
	}

	public Delivery initializeDelivery(Node start, Order order) {
		Node end = getNodeByOrder(order);
		Edge edge = E[start.getId()][end.getId()];
		UsedEdge usedEdge = initializeUsedEdge(edge, order);
		return (Delivery) usedEdge;
	}

	public UsedEdge initializeUsedEdge(Node start, Node end) {
		Edge edge = E[start.getId()][end.getId()];
		UsedEdge usedEdge = initializeUsedEdge(edge, null);
		return usedEdge;
	}

	@Override
	public String toString() {
		String way = "";
		for (int i = 0; i < route.getWay().size(); i++) {
			way += route.getWay().get(i).getEdge().getStart().getId();
			if (i < route.getWay().size() - 1) {
				way += " -> ";
			}
		}
		return "vehicle id: " + route.getVehicle().getId() + ", way: " + way;
	}

	public static RouteWrapper instantiateByVehicle(Vehicle vehicle, Node depot, Edge[][] edges) {
		Route route = new SolutionFactoryImpl().createRoute();
		route.setVehicle(vehicle);
		return new RouteWrapper(route, depot, edges);
	}

	public void print() {
		print(route.getWay());
	}

	public static void print(List<UsedEdge> way) {
		System.out.print("Edges = " + way.size() + "\t");
		for (int i = 0; i < way.size(); i++) {
			UsedEdge usedEdge = way.get(i);
			printEdge(usedEdge);
			if (i + 1 < way.size()) {
				System.out.print(" ; ");
			}
		}
		System.out.println();
	}

	private static void printEdge(UsedEdge usedEdge) {
		Edge edge = usedEdge.getEdge();
		System.out.print(edge.getStart().getId() + "->" + edge.getEnd().getId());
		if (usedEdge instanceof Delivery) {
			Order order = ((Delivery) usedEdge).getOrder();
			String id = order.getId();
			System.out.print(" (DEL (" + id + "))");
		}
	}
}
