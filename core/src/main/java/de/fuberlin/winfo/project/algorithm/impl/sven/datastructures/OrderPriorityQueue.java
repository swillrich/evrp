package de.fuberlin.winfo.project.algorithm.impl.sven.datastructures;

import java.util.List;
import java.util.PriorityQueue;

import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Order;

public class OrderPriorityQueue extends PriorityQueue<PendingOrder> {
	public OrderPriorityQueue(NetworkProvider np, ExtRoute route, List<Order> leftOrders) {
		super(new OrderComparator(route, np));
		for (Order order : leftOrders) {
			PendingOrder pendingOrder = new PendingOrder();
			pendingOrder.setOrder(order);
			add(pendingOrder);
		}
	}
}