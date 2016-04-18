package de.fuberlin.winfo.project.algorithm;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;

import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class AlgHelper {

	public static int getServiceTimeAtEdgeEnd(UsedEdge usedEdge) {
		if (usedEdge instanceof Delivery) {
			return ((Delivery) usedEdge).getOrder().getStandingTimeInSec();
		} else {
			Locatable o = usedEdge.getEdge().getEnd().getRepresentative();
			if (o instanceof Locatable) {
				if (o instanceof Depot) {
					return ((Depot) o).getServiceTimeInSec();
				}
			}
		}
		return -1;
	}

	public static Duration getTimeWindow(UsedEdge usedEdge, boolean atStart) {
		if (!atStart && usedEdge instanceof Delivery) {
			((Delivery) usedEdge).getOrder().getTimeWindow();
		} else {
			Locatable locatable = null;
			if (atStart) {
				locatable = usedEdge.getEdge().getStart().getRepresentative();
			} else {
				locatable = usedEdge.getEdge().getEnd().getRepresentative();
			}
			if (locatable instanceof Depot) {
				return ((Depot) locatable).getTimeWindow();
			} else if (locatable instanceof Customer) {
				Customer c = (Customer) locatable;
				if (c.getHasTranshipmentPoint() != null) {
					return ((Depot) c.getHasTranshipmentPoint()).getTimeWindow();
				}
			}
		}
		return null;
	}

	public static double computeEnergyConsumptionOfEdge(Vehicle vehicle, double cargoWeightInKg, double distance) {
		double payLoadInPercentage = cargoWeightInKg / (double) vehicle.getMaxCapacatyPayLoadInKg();
		double optimalConsumptionInKWPerKM = (double) vehicle.getBatteryCapacityInWh()
				/ (double) vehicle.getMaxReachInMeter();
		double additionalConsumption = payLoadInPercentage * vehicle.getPayLoadDependingConsumptionRate()
				* optimalConsumptionInKWPerKM;
		double absoluteConsumption = additionalConsumption + optimalConsumptionInKWPerKM;
		return absoluteConsumption * distance;
	}

	public static <T extends Locatable> T getLocatable(Locatable locatable, Class<T> clazz) {
		boolean searchDepot = clazz == Depot.class;
		boolean searchCustomer = clazz == Customer.class;
		if (searchDepot && locatable instanceof Depot) {
			return (T) locatable;
		} else {
			if (locatable instanceof Customer) {
				Customer c = (Customer) locatable;
				if (c.getHasTranshipmentPoint() != null && searchDepot) {
					return (T) c.getHasTranshipmentPoint();
				} else if (searchCustomer) {
					return (T) c;
				}
			}
		}
		return null;
	}

	public static Locatable getLocatableByOrder(Order order) {
		EObject container = order.eContainer();
		while (!(container instanceof Locatable) && container instanceof Order) {
			container = container.eContainer();
		}
		return (Locatable) container;
	}

	public static Node getNodeByLocatable(NetworkProvider np, Locatable locatable) {
		if (locatable.eContainer() instanceof Node) {
			return (Node) locatable.eContainer();
		} else {
			Iterator<Customer> iterator = np.getLocatables().getCustomer().stream().map(l -> (Customer) l)
					.filter(c -> c.getHasTranshipmentPoint() == locatable).iterator();
			if (iterator.hasNext()) {
				return (Node) iterator.next().eContainer();
			} else {
				return null;
			}
		}
	}

	public static Node getNodeByOrder(Order order) {
		return (Node) order.getReceiver().eContainer();
	}

	public static Order getOrderIfDelivery(UsedEdge usedEdge) {
		if (usedEdge instanceof Delivery) {
			return ((Delivery) usedEdge).getOrder();
		} else {
			return null;
		}
	}

	public static int getUniqueTargetId(UsedEdge usedEdge) {
		if (usedEdge instanceof Delivery) {
			return ((Delivery) usedEdge).getOrder().hashCode();
		} else {
			return usedEdge.getEdge().getEnd().getId();
		}
	}
}