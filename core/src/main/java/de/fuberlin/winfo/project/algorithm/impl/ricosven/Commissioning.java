package de.fuberlin.winfo.project.algorithm.impl.ricosven;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

public class Commissioning {

	public static List<CollectiveOrder> collect(List<Locatable> locatableList) {
		List<Customer> customerList = locatableList.stream().filter(l -> l instanceof Customer).map(l -> (Customer) l)
				.collect(Collectors.toList());
		List<CollectiveOrder> collectiveOrders = new ArrayList<CollectiveOrder>();
		for (Customer customer : customerList) {
			for (Boolean b : new Boolean[] { true, false }) {
				CollectiveOrder orders = pickforCustomerOrders(customer, b);
				if (orders.getConsistOf().size() > 0) {
					orders.setReceiver(customer);
					collectiveOrders.add(orders);
				}
			}
		}
		return collectiveOrders;
	}

	private static CollectiveOrder pickforCustomerOrders(Customer customer, boolean withTW) {
		CollectiveOrder commissioning = newCommissioningOrder();
		EList<Order> ownedOrders = customer.getOwnedOrders();
		for (int i = 0; i < ownedOrders.size(); i++) {
			Order order = ownedOrders.get(i);
			if (withTW && order.getTimeWindow() != null) {
				Duration comTW = new NetworkFactoryImpl().createDuration();
				commissioning.setTimeWindow(comTW);
				pickIfTWIsGiven(commissioning, comTW, order);
			} else if (!withTW && order.getTimeWindow() == null) {
				packInto(commissioning, order);
			}
		}
		return commissioning;
	}

	private static void pickIfTWIsGiven(CollectiveOrder commissioning, Duration comTW, Order order) {
		Duration ordTW = order.getTimeWindow();
		if (comTW.getEndInSec() + comTW.getStartInSec() == 0) {
			comTW.setStartInSec(ordTW.getStartInSec());
			comTW.setEndInSec(ordTW.getEndInSec());
		}
		if (ordTW.getStartInSec() <= comTW.getEndInSec() && ordTW.getEndInSec() >= comTW.getStartInSec()) {
			if (ordTW.getStartInSec() > comTW.getStartInSec()) {
				comTW.setStartInSec(ordTW.getStartInSec());
			}
			if (ordTW.getEndInSec() < comTW.getEndInSec()) {
				comTW.setEndInSec(ordTW.getEndInSec());
			}
			packInto(commissioning, order);
		}
	}

	private static void packInto(CollectiveOrder container, Order sub) {
		container.getConsistOf().add(sub);
		container.setNeedAsVolume(container.getNeedAsVolume() + sub.getNeedAsVolume());
		container.setNeedAsWeight(container.getNeedAsWeight() + sub.getNeedAsWeight());
		container.setStandingTimeInSec((int) (container.getStandingTimeInSec() + (sub.getStandingTimeInSec() * 0.75)));
	}

	private static CollectiveOrder newCommissioningOrder() {
		CollectiveOrder commissioning = new NetworkFactoryImpl().createCollectiveOrder();
		commissioning.setId("c-" + ++commissioningId);
		return commissioning;
	}

	private static int commissioningId = 0;
}
