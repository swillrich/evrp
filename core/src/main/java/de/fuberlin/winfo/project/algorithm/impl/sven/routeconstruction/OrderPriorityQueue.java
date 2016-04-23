package de.fuberlin.winfo.project.algorithm.impl.sven.routeconstruction;

import java.util.List;
import java.util.PriorityQueue;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Order;

public class OrderPriorityQueue extends PriorityQueue<PendingOrder> {
	public OrderPriorityQueue(NetworkProvider np, RouteWrapper route, List<Order> leftOrders) {
		super(new PendingOrderComparator(route, np));
		for (Order order : leftOrders) {
			PendingOrder pendingOrder = new PendingOrder();
			pendingOrder.setOrder(order);
			add(pendingOrder);
		}
	}
}