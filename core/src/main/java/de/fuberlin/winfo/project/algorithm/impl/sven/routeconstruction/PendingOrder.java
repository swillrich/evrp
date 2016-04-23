package de.fuberlin.winfo.project.algorithm.impl.sven.routeconstruction;

import de.fuberlin.winfo.project.model.network.Order;

public class PendingOrder {
	private Order order;
	private int pos = 0;

	public Order getOrder() {
		return order;
	}

	public int getPos() {
		return pos;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
}