package de.fuberlin.winfo.project.algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.Vertex;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

public class RouteWrapper {
	private Route route;
	private NetworkFactory networkFactory = new NetworkFactoryImpl();
	private Vertex depot;
	private Arc[][] E;
	private Set<Vertex> routeVertices;

	public RouteWrapper(Route route, Vertex depot, Arc[][] arcs) {
		this.route = route;
		this.E = arcs;
		if (depot == null) {
			this.depot = route.getWay().get(0).getArc().getStart();
		} else {
			this.depot = depot;
		}
	}

	public List<Vertex> getVertices() {
		return (List<Vertex>) route.getWay().stream().map(w -> w.getArc().getStart()).collect(Collectors.toList());
	}

	public Route getActualRoute() {
		return route;
	}

	public Vertex getDepot() {
		return depot;
	}

	/**
	 * Computation of the remaining vehicle battery capacity in KW. <br>
	 * <br>
	 * Precondition for executing this method is pre-calculating all remaining
	 * cargo capacity values for each vertex.
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
			UsedArc usedArc = route.getWay().get(i);

			capLeft = capLeft - (int) computeEnergyConsumptionOfArc(vehicle,
					usedArc.getCurrentVehicleCargoWeight() + extraNeed, usedArc.getArc().getDistance());

			if (withUpdate) {
				usedArc.setRemainingVehicleBatteryCapacityAtEnd((int) capLeft);
			}
		}
		return capLeft;
	}

	public void reinitializeRoute() throws Exception {
		if (route.getWay().size() < 2) {
			return;
		}
		routeVertices = new TreeSet<Vertex>(new Comparator<Vertex>() {

			@Override
			public int compare(Vertex o1, Vertex o2) {
				return Integer.compare(o1.getId(), o2.getId());
			}
		});
		route.setTotalDistanceInM(0);
		route.setTotalTimeInSec(0);
		for (int i = 0; i < route.getWay().size(); i++) {
			UsedArc usedArc = route.getWay().get(i);

			checkRouteConsistency(i, usedArc);

			computeDepature(i, usedArc);

			computeArrival(usedArc);

			/*
			 * COMPUTATION OF VEHICLE PAYLOAD FOR EACH NODE
			 * 
			 * If the vehicle is driving to a customer, the customer need is
			 * considered. This procedure works inverse. Put another way, it's
			 * an iterative loop, which starts at end and terminates at start.
			 * Only this way it's possible to compute the current weight at each
			 * position correctly.
			 */
			UsedArc fromBehindUsedArc = route.getWay().get(route.getWay().size() - 1 - i);
			if (route.getWay().size() - i < route.getWay().size()) {

				double weightInKg = route.getWay().get(route.getWay().size() - i).getCurrentVehicleCargoWeight();

				Vertex end = fromBehindUsedArc.getArc().getEnd();
				if (end instanceof Order) {
					Order order = (Order) end;
					weightInKg += order.getWeight();
				}
				fromBehindUsedArc.setCurrentVehicleCargoWeight(weightInKg);
			}

			route.setTotalDistanceInM(route.getTotalDistanceInM() + usedArc.getArc().getDistance());
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

	private void checkRouteConsistency(int i, UsedArc usedArc) throws Exception {
		if (i > 0) {
			boolean endEqualsStart = route.getWay().get(i - 1).getArc().getEnd() == route.getWay().get(i).getArc()
					.getStart();
			if (!endEqualsStart) {
				throw new Exception("End id is not equal to start id at index " + i);
			}
		}
		boolean added = routeVertices.add(usedArc.getArc().getEnd());

		if (!added) {
			throw new Exception("Vertex " + usedArc.getArc().getEnd().getId() + " exists twice in route ("
					+ route.getWay().size() + " arcs)");
		}

		if (i == 0 && route.getWay().get(0).getArc().getStart() != route.getWay().get(route.getWay().size() - 1)
				.getArc().getEnd()) {
			throw new Exception("Start and end vertex must be equal");
		}
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

	private void computeArrival(UsedArc usedArc) {
		/*
		 * ARRIVAL COMPUTATION
		 */
		Duration timeWindow = Utils.getTimeWindow(usedArc.getArc().getEnd());
		if (timeWindow != null) {
			int startInSecByTW = timeWindow.getStartInSec();
			int arrival = usedArc.getDuration().getStartInSec() + usedArc.getArc().getTime();
			if (arrival > startInSecByTW) {
				// If the arrival lies behind the Time Window Start
				usedArc.getDuration().setEndInSec(arrival);
			} else {
				usedArc.getDuration().setEndInSec(startInSecByTW);
			}
		} else {
			// without time windows, only the time consumed by the link
			// itself is considered
			usedArc.getDuration().setEndInSec(usedArc.getDuration().getStartInSec() + usedArc.getArc().getTime());
		}
	}

	private void computeDepature(int i, UsedArc usedArc) {
		/*
		 * DEPARTURE COMPUTATION
		 */
		if (i > 0) {
			// retrieves the previous UsedArc
			UsedArc prevUE = route.getWay().get(i - 1);

			// compute start time
			int time = prevUE.getDuration().getEndInSec() + getServiceTime(prevUE.getArc().getEnd());
			usedArc.getDuration().setStartInSec(time);
		} else {
			// compute start time if the first arc is given

			Duration srcTimeWindow = Utils.getTimeWindow(usedArc.getArc().getStart());
			int startInSecFromStartByTW = srcTimeWindow.getStartInSec();
			int driveTime = usedArc.getArc().getTime();
			int start = startInSecFromStartByTW;

			Vertex end = usedArc.getArc().getEnd();

			Duration targetTimeWindow = ((Order) end).getTimeWindow();

			if (targetTimeWindow != null) {
				int startInSec = targetTimeWindow.getStartInSec();
				if (startInSec - driveTime > startInSecFromStartByTW) {
					start = startInSec - driveTime;
				}
			}

			usedArc.getDuration().setStartInSec(start);
		}
	}

	private int getServiceTime(Vertex v) {
		if (v instanceof Locatable) {
			return ((Locatable) v).getServiceTimeInSec();
		} else if (v instanceof Order) {
			return ((Order) v).getStandingTimeInSec();
		} else {
			return Integer.MAX_VALUE;
		}
	}

	public UsedArc initializeUsedArc(Arc arc) {
		if (arc == null) {
			throw new NullPointerException("Arc must not be null");
		}
		UsedArc usedArc = networkFactory.createUsedArc();
		usedArc.setArc(arc);
		usedArc.setDuration(networkFactory.createDuration());
		return usedArc;
	}

	public void useArc(Order order) throws Exception {
		if (route.getWay().isEmpty()) {

			Arc arcToNewVertex = E[depot.getId()][order.getId()];
			UsedArc usedArcToNewVertex = initializeUsedArc(arcToNewVertex);
			route.getWay().add(usedArcToNewVertex);

			Arc arcFromNewVertex = E[order.getId()][depot.getId()];
			UsedArc usedArcFromNewVertex = initializeUsedArc(arcFromNewVertex);
			route.getWay().add(usedArcFromNewVertex);

			reinitializeRoute();

		} else {
			useArcAtIndex(order, route.getWay().size() - 1);
		}
	}

	public void useArcAtIndex(Vertex vertex, int i) throws Exception {
		UsedArc arcToDelete = route.getWay().get(i);
		Arc arcToNewVertex = E[arcToDelete.getArc().getStart().getId()][vertex.getId()];
		UsedArc usedArcToNewVertex = initializeUsedArc(arcToNewVertex);
		Arc arcFromNewVertex = E[vertex.getId()][arcToDelete.getArc().getEnd().getId()];

		UsedArc usedArcFromNewVertex = initializeUsedArc(arcFromNewVertex);

		route.getWay().remove(i);
		route.getWay().add(i, usedArcFromNewVertex);
		route.getWay().add(i, usedArcToNewVertex);

		reinitializeRoute();
	}

	public void replaceSubRoute(List<UsedArc> newUsedArcList, int start, int end) throws Exception {
		for (int i = start; i <= end; i++) {
			route.getWay().remove(start);
		}
		route.getWay().addAll(start, newUsedArcList);
		reinitializeRoute();
	}

	public UsedArc initializeUsedArc(Vertex start, Vertex end) {
		Arc arc = E[start.getId()][end.getId()];
		UsedArc usedArc = initializeUsedArc(arc);
		return usedArc;
	}

	@Override
	public String toString() {
		String way = "";
		for (int i = 0; i < route.getWay().size(); i++) {
			way += route.getWay().get(i).getArc().getStart().getId();
			if (i < route.getWay().size() - 1) {
				way += " -> ";
			}
		}
		return "vehicle id: " + route.getVehicle().getId() + ", way: " + way;
	}

	public static RouteWrapper instantiateByVehicle(Vehicle vehicle, Vertex depot, Arc[][] arcs) {
		Route route = new NetworkFactoryImpl().createRoute();
		route.setVehicle(vehicle);
		return new RouteWrapper(route, depot, arcs);
	}

	public void print() {
		print(route.getWay());
	}

	public static void print(List<UsedArc> way) {
		System.out.print("Arcs = " + way.size() + "\t");
		for (int i = 0; i < way.size(); i++) {
			UsedArc usedArc = way.get(i);
			printArc(usedArc);
			if (i + 1 < way.size()) {
				System.out.print(" ; ");
			}
		}
		System.out.println();
	}

	private static void printArc(UsedArc usedArc) {
		Arc arc = usedArc.getArc();
		System.out.print(arc.getStart().getId() + "->" + arc.getEnd().getId());
	}

	public List<UsedArc> getUsedArcsBetween(Vertex start, Vertex end) {
		List<UsedArc> result = new ArrayList<UsedArc>();
		List<Vertex> vertices = getVertices();

		int startIndex = vertices.indexOf(start);
		int endIndex = vertices.indexOf(end);

		List<Vertex> subList;
		if (startIndex < endIndex) {
			subList = vertices.subList(startIndex, endIndex + 1);
		} else {
			subList = vertices.subList(endIndex, startIndex + 1);
			Collections.reverse(subList);
		}

		for (int i = 0; i + 1 < subList.size(); i++) {
			Vertex arcStart = subList.get(i);
			Vertex arcEnd = subList.get(i + 1);
			Arc arc = E[arcStart.getId()][arcEnd.getId()];
			UsedArc usedArc = initializeUsedArc(arc);
			result.add(usedArc);
		}

		return result;
	}

	public void relocateSingleVertex(int toRemove, RouteWrapper neighborWrapper, int insertionPos) throws Exception {
		UsedArc usedArc = remove(toRemove);
		if (usedArc == null) {
			throw new NullPointerException("UsedArc is null (could not be deleted)");
		}
		Vertex end = usedArc.getArc().getEnd();
		neighborWrapper.useArcAtIndex((Order) end, insertionPos);
		reinitializeRoute();
	}

	private UsedArc remove(int toRemove) throws Exception {
		if (toRemove + 1 >= route.getWay().size() || toRemove < 0) {
			throw new IndexOutOfBoundsException("index is " + toRemove + " / " + (route.getWay().size() - 1));
		}
		UsedArc usedArcToRemove = route.getWay().remove(toRemove);
		UsedArc usedArcToReplace = route.getWay().remove(toRemove);

		Vertex start = usedArcToRemove.getArc().getStart();
		Vertex end = usedArcToReplace.getArc().getEnd();
		Arc newArc = E[start.getId()][end.getId()];
		UsedArc newUsedArc = initializeUsedArc(newArc);

		route.getWay().add(toRemove, newUsedArc);
		return usedArcToRemove;
	}

	public static double computeEnergyConsumptionOfArc(Vehicle vehicle, double cargoWeightInKg, double distance) {
		double payLoadInPercentage = cargoWeightInKg / (double) vehicle.getMaxCapacatyPayLoadInKg();
		double optimalConsumptionInKWPerKM = (double) vehicle.getBatteryCapacityInWh()
				/ (double) vehicle.getMaxReachInMeter();
		double additionalConsumption = payLoadInPercentage * vehicle.getPayLoadDependingConsumptionRate()
				* optimalConsumptionInKWPerKM;
		double absoluteConsumption = additionalConsumption + optimalConsumptionInKWPerKM;
		return absoluteConsumption * distance;
	}

	public List<Order> getOrders() {
		return route.getWay().stream().filter(w -> !(w.getArc().getStart() instanceof Depot))
				.map(w -> w.getArc().getStart()).map(v -> (Order) v).collect(Collectors.toList());
	}
}
