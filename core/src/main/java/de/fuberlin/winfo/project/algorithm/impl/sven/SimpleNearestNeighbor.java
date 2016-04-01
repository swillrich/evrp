package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.ExtendedRouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.Commissioning;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class SimpleNearestNeighbor extends Algorithm {

	@Override
	public String getName() {
		return "Simple Distance Nearest Neighbor";
	}

	Edge[][] E = null;

	@Override
	public void run(Solution solution) throws Exception {
		E = networkProvider.getEdges();

		restrictions.add(new CargoCapacityRestriction());
		restrictions.add(new VehicleRangeRestriction());
		restrictions.add(new TimeWindowRestriction());

		Commissioning.pickCustomerOrder(networkProvider.getLocatables().getMainDepot(),
				networkProvider.getLocatables().getCustomer());

		runAlgForStage(solution, networkProvider.getLocatables().getMainDepot());
	}

	private void runAlgForStage(Solution solution, Depot depot) throws Exception {
		List<Order> remainingOrders = new ArrayList<Order>(depot.getDeliveries());

		while (!remainingOrders.isEmpty()) {
			Vehicle vehicle = solution.getUsecase().getVehicles().get(0);
			ExtendedRouteWrapper route = buildRoute(vehicle, AlgHelper.getNodeByLocatable(networkProvider, depot));
			OrderPriorityQueue priorityQueue = new OrderPriorityQueue(route, remainingOrders);
			while (!priorityQueue.isEmpty()) {
				PendingOrder nextPendingOrder = priorityQueue.poll();
				try {
					restrictions.check(route, nextPendingOrder.getOrder(), nextPendingOrder.getPos());
					if (route.getModelRoute().getWay().isEmpty()) {
						route.addDelivery(nextPendingOrder.getOrder());
					} else {
						route.addDeliveryAtIndex(nextPendingOrder.getOrder(), nextPendingOrder.getPos());
					}
					remainingOrders.remove(nextPendingOrder.getOrder());
				} catch (RestrictionException e) {
					if (priorityQueue.isEmpty()) {
						System.out.println((solution.getRoutes().size() + 1) + ". Route with "
								+ route.getModelRoute().getWay().size() + " nodes built (" + e.getMessage() + ")");
					}
				}
			}
			solution.getRoutes().add(route.getModelRoute());
		}
	}

	@SuppressWarnings("serial")
	private class OrderPriorityQueue extends PriorityQueue<PendingOrder> {
		public OrderPriorityQueue(ExtendedRouteWrapper route, List<Order> leftOrders) {
			super(new OrderComparator(route));
			for (Order order : leftOrders) {
				PendingOrder pendingOrder = new PendingOrder();
				pendingOrder.setOrder(order);
				add(pendingOrder);
			}
		}
	}

	private class OrderComparator implements Comparator<PendingOrder> {
		private ExtendedRouteWrapper route;

		public OrderComparator(ExtendedRouteWrapper route) {
			this.route = route;
		}

		@Override
		public int compare(PendingOrder o1, PendingOrder o2) {
			Node n1 = AlgHelper.getNodeByOrder(networkProvider, o1.getOrder());
			Node n2 = AlgHelper.getNodeByOrder(networkProvider, o2.getOrder());

			if (o1.getOrder().getTimeWindow() != null && o2.getOrder().getTimeWindow() == null) {
				return -1;
			} else if (o1.getOrder().getTimeWindow() == null && o2.getOrder().getTimeWindow() != null) {
				return 1;
			}

			// initial pendulum tour
			if (route.getModelRoute().getWay().isEmpty()) {
				return Integer.compare(computeCosts(route.getDepot(), n1), computeCosts(route.getDepot(), n2));
			}

			UsedEdge n1UsedEdge = computeMin(n1);
			o1.setPos(route.getModelRoute().getWay().indexOf(n1UsedEdge));

			UsedEdge n2UsedEdge = computeMin(n2);
			o2.setPos(route.getModelRoute().getWay().indexOf(n2UsedEdge));

			int costs1 = computeCosts(n1, n1UsedEdge.getEdge().getEnd());
			int costs2 = computeCosts(n2, n2UsedEdge.getEdge().getEnd());

			return Integer.compare(costs1, costs2);
		}

		private UsedEdge computeMin(Node n1) {
			return Collections.min(route.getModelRoute().getWay(), new Comparator<UsedEdge>() {
				@Override
				public int compare(UsedEdge o1, UsedEdge o2) {
					int a = computeCosts(o1.getEdge().getEnd(), n1);
					int b = computeCosts(o2.getEdge().getEnd(), n1);
					return Integer.compare(a, b);
				}
			});
		}

		private int computeCosts(Node n1, Node n2) {
			return E[n1.getId()][n2.getId()].getDistance();
		}
	};

	private class PendingOrder {
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
}
