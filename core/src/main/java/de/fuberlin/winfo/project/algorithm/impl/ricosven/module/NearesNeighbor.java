package de.fuberlin.winfo.project.algorithm.impl.ricosven.module;

import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper.ModRoute;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Route;

public class NearesNeighbor {

	NetworkProvider network;
	Algorithm algorithm;

	public NearesNeighbor(NetworkProvider network, Algorithm algorithm) {
		this.network = network;
		this.algorithm = algorithm;

	}

	public Route run(List<Node> customers, Node depot) throws Exception {

		return runNearesNeighbor(customers, depot, false);
	}

	public Route runWithDistanceAsTime(List<Node> customers, Node depot) throws Exception {

		return runNearesNeighbor(customers, depot, true);

	}

	private Route runNearesNeighbor(List<Node> customers, Node depot, boolean withTime) throws Exception {

		ModRoute route = new ModRoute(algorithm, algorithm.getSolution().getUsecase().getVehicles().get(0), depot);

		double minDistance = Integer.MAX_VALUE;
		int customerIndex = Integer.MAX_VALUE;

		for (int i = 0; i < customers.size(); i++) {
			int idDepot = depot.getId();
			int idCustomer = customers.get(i).getId();

			double distance;
			if (withTime)
				distance = network.getEdges()[idDepot][idCustomer].getTime();
			else
				distance = network.getEdges()[idDepot][idCustomer].getDistance();

			if (distance < minDistance) {
				minDistance = distance;
				customerIndex = i;
			}
		}

		Node customerToAdd = customers.remove(customerIndex);
		Order orderToAdd = ((Customer) customerToAdd.getRepresentative()).getOwnedOrders().get(0);
		((ModRoute) route).addDelivery(orderToAdd);

		while (!customers.isEmpty()) {
			minDistance = Integer.MAX_VALUE;
			customerIndex = Integer.MAX_VALUE;

			for (int i = 0; i < customers.size(); i++) {
				int idLastCustomerNode = route.getWay().get(route.getWay().size() - 1).getEdge().getStart().getId();
				int idCustomer = customers.get(i).getId();

				double distance;
				if (withTime)
					distance = network.getEdges()[idLastCustomerNode][idCustomer].getTime();
				else
					distance = network.getEdges()[idLastCustomerNode][idCustomer].getDistance();

				if (distance < minDistance) {
					minDistance = distance;
					customerIndex = i;
				}
			}

			customerToAdd = customers.remove(customerIndex);
			orderToAdd = ((Customer) customerToAdd.getRepresentative()).getOwnedOrders().get(0);
			((ModRoute) route).addDelivery(orderToAdd);
		}
		return route.getRoute();
	}
}
