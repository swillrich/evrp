package de.fuberlin.winfo.project.algorithm;

import static de.fuberlin.winfo.project.algorithm.AlgHelper.computeEnergyConsumptionOfEdge;
import static de.fuberlin.winfo.project.algorithm.AlgHelper.getLocatable;
import static de.fuberlin.winfo.project.algorithm.AlgHelper.getNodeByOrder;
import static de.fuberlin.winfo.project.algorithm.AlgHelper.getTimeWindow;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;

import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class ExtendedRoute implements Route {
	private Route route;
	private NetworkProvider networkProvider;
	private Node depot;

	public ExtendedRoute(Algorithm algorithm, Vehicle vehicle, Node depot) {
		networkProvider = algorithm.networkProvider;
		route = networkProvider.getSolutionFactory().createRoute();
		this.route.setVehicle(vehicle);
		this.depot = depot;
	}

	public Route getRoute() {
		return route;
	}

	public Node getDepot() {
		return depot;
	}

	/**
	 * Returns the remaining amount of vehicle cargo capacity after adding the
	 * given customer.
	 */
	public boolean isSufficientCargoCapacityAvailable(Order newOrder) {

		if (route.getWay().size() == 0) {
			return true;
		}

		double leftCap = route.getVehicle().getMaxCapacatyPayLoadInKg()
				- route.getWay().get(0).getCurrentVehicleCargoWeight() - newOrder.getNeedAsWeight();

		if (leftCap >= 0)
			return true;
		else
			return false;
	}

	/**
	 * Computes the remaining energy after using the given edge. <br>
	 * <br>
	 * There must be sufficient energy for using the given link + the energy
	 * needed for driving back to the depot. If the given edge representing the
	 * depot back link, this is not taking into account.
	 */
	public boolean isSufficientEnergyAvailable(Order newOrder, int atEdgeWithIndex) throws Exception {
		Node node = AlgHelper.getNodeByOrder(networkProvider, newOrder);

		// First new edge
		Edge edgeToNewNode = networkProvider.getEdges()[route.getWay().get(atEdgeWithIndex).getEdge().getStart()
				.getId()][node.getId()];
		// Second new edge
		Edge edgeFromNewNode = networkProvider.getEdges()[node.getId()][route.getWay().get(atEdgeWithIndex).getEdge()
				.getEnd().getId()];

		double need = route.getWay().get(atEdgeWithIndex).getCurrentVehicleCargoWeight();

		double capacityLeft = 0;
		try {
			capacityLeft = computeRemainingVehicleBatteryCapacity(atEdgeWithIndex, newOrder.getNeedAsWeight(), false);
		} catch (Exception e) {
			return false;
		}
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getVehicle(), need + newOrder.getNeedAsWeight(),
				edgeToNewNode.getDistance());
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getVehicle(), need,
				edgeFromNewNode.getDistance());

		double availableCapacity = route.getWay().get(route.getWay().size() - 1)
				.getRemainingVehicleBatteryCapacityAtEnd();

		double oldCapacityLeft = route.getWay().get(atEdgeWithIndex).getRemainingVehicleBatteryCapacityAtEnd();

		return oldCapacityLeft - capacityLeft <= availableCapacity;
	}

	public boolean isSufficientTourLenghtAvailable(Order order, int usedEdgeIndex) {

		int maxTourLenght = getMaxTourLenght();

		if (maxTourLenght == -1) {
			return true;
		}

		List<UsedEdge> way = addTempOrderToRoute(order, usedEdgeIndex);
		int tourLenght = getTourLength(way);

		if (tourLenght <= maxTourLenght) {
			return true;
		} else {
			return false;
		}
	}

	private List<UsedEdge> addTempOrderToRoute(Order order, int usedEdgeIndex) {
		List<UsedEdge> way = new ArrayList<>();
		way.addAll(route.getWay());
		Node nodeBeforeInsertion = route.getWay().get(usedEdgeIndex).getEdge().getStart();
		Node newNode = AlgHelper.getNodeByOrder(networkProvider, order);
		Node nodeAfterInsertion = route.getWay().get(usedEdgeIndex).getEdge().getEnd();

		Edge edgeToNewOrder = networkProvider.getEdges()[nodeBeforeInsertion.getId()][newNode.getId()];
		Edge edgeFromNewOrder = networkProvider.getEdges()[newNode.getId()][nodeAfterInsertion.getId()];

		Delivery deliveryToNewOrder = networkProvider.getSolutionFactory().createDelivery();
		deliveryToNewOrder.setOrder(order);
		deliveryToNewOrder.setEdge(edgeToNewOrder);

		UsedEdge usedEdgeFromNewOrder;

		if (route.getWay().get(usedEdgeIndex) instanceof Delivery) {
			Order orderAfterInsertion = ((Delivery) route.getWay().get(usedEdgeIndex)).getOrder();
			usedEdgeFromNewOrder = networkProvider.getSolutionFactory().createDelivery();
			((Delivery) usedEdgeFromNewOrder).setOrder(orderAfterInsertion);
			((Delivery) usedEdgeFromNewOrder).setEdge(edgeFromNewOrder);
		} else {
			usedEdgeFromNewOrder = networkProvider.getSolutionFactory().createUsedEdge();
			usedEdgeFromNewOrder.setEdge(edgeFromNewOrder);
		}

		way.remove(usedEdgeIndex);
		way.add(usedEdgeIndex, usedEdgeFromNewOrder);
		way.add(usedEdgeIndex, deliveryToNewOrder);

		return way;
	}

	private int getTourLength(List<UsedEdge> way) {
		int tourLenght = 0;
		int tourStart = getLocatable(getDepot().getRepresentative(), Depot.class).getTimeWindow().getStartInSec();
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

	public int getMaxTourLenght() {

		Locatable l = getDepot().getRepresentative();

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

	public boolean isSufficientTimeWindowAvailable(Order newOrder, int usedEdgeIndex) {

		double newOrder_TW_StartInSec = Double.MIN_VALUE;
		double newOrder_TW_EndInSec = Double.MAX_VALUE;
		if (newOrder.getTimeWindow() != null) {
			newOrder_TW_StartInSec = newOrder.getTimeWindow().getStartInSec();
			newOrder_TW_EndInSec = newOrder.getTimeWindow().getEndInSec();
		}
		double edgeStartInSec = route.getWay().get(usedEdgeIndex).getDuration().getStartInSec();
		double edgeEndInSec = route.getWay().get(usedEdgeIndex).getDuration().getEndInSec();

		Node newNode = AlgHelper.getNodeByOrder(networkProvider, newOrder);
		double serviceTimeAtNewNode = newOrder.getStandingTimeInSec();
		double timeStartNodeToNewNode = networkProvider.getEdges()[route.getWay().get(usedEdgeIndex).getEdge()
				.getStart().getId()][newNode.getId()].getTime();
		double timeNewNodeToEndNode = networkProvider.getEdges()[newNode.getId()][route.getWay().get(usedEdgeIndex)
				.getEdge().getEnd().getId()].getTime();
		double actualUsedTime = route.getWay().get(usedEdgeIndex).getEdge().getTime();
		double possibleShiftEdgeStart = getPossibleShiftEdgeStart(usedEdgeIndex);
		double possibleShiftEdgeEnd = getPossibleShiftEdgeEnd(usedEdgeIndex);

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
		for (int i = usedEdgeIndex; i < route.getWay().size(); i++) {
			double tmpEdgeEndInSec = route.getWay().get(i).getDuration().getEndInSec();

			double timewindowEndAtEdgeEnd;

			if (i == route.getWay().size() - 1) {
				timewindowEndAtEdgeEnd = getTimewindowFromDepot(getDepot()).getEndInSec();
			} else {
				timewindowEndAtEdgeEnd = Double.MAX_VALUE;
				Duration timewindowAtEdgeEnd = ((Delivery) route.getWay().get(i)).getOrder().getTimeWindow();
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
			double tmpEdgeStartInSec = route.getWay().get(i).getDuration().getStartInSec();

			double timewindowStartAtEdgeStart;
			double serviceTimeAtEdgeStart;

			if (i == 0) {
				timewindowStartAtEdgeStart = getTimewindowFromDepot(getDepot()).getStartInSec();
				serviceTimeAtEdgeStart = 0; // The service time at the depot
											// is
											// zero at the beginning of the
											// route, else
											// getServiceTimeFromDepot(node);
			} else {
				serviceTimeAtEdgeStart = ((Delivery) route.getWay().get(i - 1)).getOrder().getStandingTimeInSec();

				timewindowStartAtEdgeStart = Double.MIN_VALUE;
				Duration timewindowAtEdgeStart = ((Delivery) route.getWay().get(i - 1)).getOrder().getTimeWindow();
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

	/**
	 * Computation of the remaining vehicle battery capacity in KW. <br>
	 * <br>
	 * Precondition for executing this method is pre-calculating all remaining
	 * cargo capacity values for each node.
	 * 
	 * @throws Exception
	 */
	public double computeRemainingVehicleBatteryCapacity(int until, double extraNeed, boolean withUpdate)
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

			if (capLeft < 0) {
				throw new Exception("Consumption can not be negative at edge with index " + i + " with " + capLeft);
			}

			if (withUpdate) {
				usedEdge.setRemainingVehicleBatteryCapacityAtEnd((int) capLeft);
			}
		}
		return capLeft;
	}

	private void reinitializeRoute() throws Exception {
		for (int i = 0; i < route.getWay().size(); i++) {
			UsedEdge usedEdge = route.getWay().get(i);

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
					weightInKg += delivery.getOrder().getNeedAsWeight();
				}
				fromBehindUsedEdge.setCurrentVehicleCargoWeight(weightInKg);
			}
		}

		/*
		 * COMPUTATION OF THE REMAINING VEHICLE BATTERY KW
		 */
		computeRemainingVehicleBatteryCapacity(-1, 0, true);
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
			int time = prevUE.getDuration().getEndInSec() + AlgHelper.getTimeNeededAtEnd(prevUE);
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

	private UsedEdge initializeUsedEdge(Edge edge, Order order) {
		if (edge == null) {
			throw new NullPointerException("Used must not be null");
		}
		UsedEdge usedEdge = null;
		if (order != null) {
			usedEdge = networkProvider.getSolutionFactory().createDelivery();
			((Delivery) usedEdge).setOrder(order);
		} else {
			usedEdge = networkProvider.getSolutionFactory().createUsedEdge();
		}
		usedEdge.setEdge(edge);
		usedEdge.setDuration(networkProvider.getNetworkFactory().createDuration());
		return usedEdge;
	}

	public void addDelivery(Order order) throws Exception {
		if (route.getWay().isEmpty()) {

			Node newNode = getNodeByOrder(this.networkProvider, order);

			Edge edgeToNewNode = networkProvider.getEdges()[depot.getId()][newNode.getId()];
			UsedEdge usedEdgeToNewNode = initializeUsedEdge(edgeToNewNode, order);
			route.getWay().add(usedEdgeToNewNode);

			Edge edgeFromNewNode = networkProvider.getEdges()[newNode.getId()][depot.getId()];
			UsedEdge usedEdgeFromNewNode = initializeUsedEdge(edgeFromNewNode, null);
			route.getWay().add(usedEdgeFromNewNode);

			reinitializeRoute();

		} else {
			addDeliveryAtIndex(order, route.getWay().size() - 1);
		}
	}

	public void addDeliveryAtIndex(Order order, int i) throws Exception {
		Node newNode = getNodeByOrder(this.networkProvider, order);

		UsedEdge edgeToDelete = route.getWay().get(i);
		Edge edgeToNewNode = networkProvider.getEdges()[edgeToDelete.getEdge().getStart().getId()][newNode.getId()];
		UsedEdge usedEdgeToNewNode = initializeUsedEdge(edgeToNewNode, order);
		Edge edgeFromNewNode = networkProvider.getEdges()[newNode.getId()][edgeToDelete.getEdge().getEnd().getId()];

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

	@Override
	public TreeIterator<EObject> eAllContents() {
		return this.route.eAllContents();
	}

	@Override
	public EClass eClass() {
		return this.route.eClass();
	}

	@Override
	public EObject eContainer() {
		return this.route.eContainer();
	}

	@Override
	public EStructuralFeature eContainingFeature() {
		return this.route.eContainingFeature();
	}

	@Override
	public EReference eContainmentFeature() {
		return this.route.eContainmentFeature();
	}

	@Override
	public EList<EObject> eContents() {
		return this.route.eContents();
	}

	@Override
	public EList<EObject> eCrossReferences() {
		return this.route.eCrossReferences();
	}

	@Override
	public Object eGet(EStructuralFeature arg0) {
		return this.route.eGet(arg0);
	}

	@Override
	public Object eGet(EStructuralFeature arg0, boolean arg1) {
		return this.route.eGet(arg0, arg1);
	}

	@Override
	public Object eInvoke(EOperation arg0, EList<?> arg1) throws InvocationTargetException {
		return this.route.eInvoke(arg0, arg1);
	}

	@Override
	public boolean eIsProxy() {
		return this.route.eIsProxy();
	}

	@Override
	public boolean eIsSet(EStructuralFeature arg0) {
		return this.route.eIsSet(arg0);
	}

	@Override
	public Resource eResource() {
		return this.route.eResource();
	}

	@Override
	public void eSet(EStructuralFeature arg0, Object arg1) {
		this.route.eSet(arg0, arg1);
	}

	@Override
	public void eUnset(EStructuralFeature arg0) {
		this.route.eUnset(arg0);
	}

	@Override
	public EList<Adapter> eAdapters() {
		return this.route.eAdapters();
	}

	@Override
	public boolean eDeliver() {
		return this.route.eDeliver();
	}

	@Override
	public void eNotify(Notification arg0) {
		this.route.eNotify(arg0);
	}

	@Override
	public void eSetDeliver(boolean arg0) {
		this.route.eSetDeliver(arg0);
	}

	@Override
	public Vehicle getVehicle() {
		return this.route.getVehicle();
	}

	@Override
	public void setVehicle(Vehicle value) {
		this.route.setVehicle(value);
	}

	@Override
	public long getTotalDistanceInM() {
		return this.route.getTotalDistanceInM();
	}

	@Override
	public void setTotalDistanceInM(long value) {
		this.route.setTotalDistanceInM(value);
	}

	@Override
	public int getTotalTimeInSec() {
		return this.route.getTotalTimeInSec();
	}

	@Override
	public void setTotalTimeInSec(int value) {
		this.route.setTotalTimeInSec(value);
	}

	@Override
	public EList<UsedEdge> getWay() {
		return this.route.getWay();
	}
}
