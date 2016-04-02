package de.fuberlin.winfo.project.algorithm.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

public class Commissioning {

	public static int MAX_ORDER_WEIGHT_IN_KG = 2000;

	public static void pickCustomerOrder(Depot depot, List<Locatable> list) {
		List<Customer> customerList = list.stream().filter(l -> l instanceof Customer).map(l -> (Customer) l)
				.collect(Collectors.toList());

		for (Customer customer : customerList) {
			for (Boolean b : new Boolean[] { true, false }) {
				pickOrders(depot, customer, b);
			}
		}
	}

	private static void pickOrders(Depot depot, Customer customer, boolean withTW) {
		List<Order> orders = new ArrayList<Order>();
		EList<Order> customerOrders = customer.getOrders();
		Duration comTW = new NetworkFactoryImpl().createDuration();
		for (int i = 0; i < customerOrders.size(); i++) {
			Order order = customerOrders.get(i);
			if (withTW && order.getTimeWindow() != null) {
				pickIfTWIsGiven(orders, comTW, order);
			} else if (!withTW && order.getTimeWindow() == null) {
				orders.add(order);
			}
		}

		while (!orders.isEmpty()) {
			if (orders.size() > 1) {
				CollectiveOrder commissioningOrder = newCommissioningOrder();
				if (withTW) {
					commissioningOrder.setTimeWindow(comTW);
				}
				commissioningOrder.setReceiver(orders.get(0).getReceiver());
				depot.getDeliveries().add(commissioningOrder);
				Iterator<Order> iterator = orders.iterator();
				while (iterator.hasNext()) {
					if (commissioningOrder.getWeight() <= MAX_ORDER_WEIGHT_IN_KG) {
						packInto(commissioningOrder, iterator.next());
						iterator.remove();
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}
	}

	private static void pickIfTWIsGiven(List<Order> orders, Duration comTW, Order order) {
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
			orders.add(order);
		}
	}

	private static void packInto(CollectiveOrder collectiveOrder, Order sub) {
		collectiveOrder.getSubOrder().add(sub);
		collectiveOrder.setVolume(collectiveOrder.getVolume() + sub.getVolume());
		collectiveOrder.setWeight(collectiveOrder.getWeight() + sub.getWeight());
		collectiveOrder.setStandingTimeInSec(
				(int) (collectiveOrder.getStandingTimeInSec() + (sub.getStandingTimeInSec() * 0.75)));
	}

	private static CollectiveOrder newCommissioningOrder() {
		CollectiveOrder commissioning = new NetworkFactoryImpl().createCollectiveOrder();
		commissioning.setId("c-" + ++commissioningId);
		return commissioning;
	}

	private static int commissioningId = 0;
}
