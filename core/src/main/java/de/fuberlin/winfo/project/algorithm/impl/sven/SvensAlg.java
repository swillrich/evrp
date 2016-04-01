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
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class SvensAlg extends Algorithm {

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
		// restrictions.add(new TimeWindowRestriction());

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

			// initial pendulum tour (Nearest Neighbor)
			if (route.getModelRoute().getWay().isEmpty()) {
				return Integer.compare(distance(route.getDepot(), n1), distance(route.getDepot(), n2));
			}

			UsedEdge n1UsedEdge = returnMin(n1);
			o1.setPos(route.getModelRoute().getWay().indexOf(n1UsedEdge));

			UsedEdge n2UsedEdge = returnMin(n2);
			o2.setPos(route.getModelRoute().getWay().indexOf(n2UsedEdge));

			int costs1 = computeCheapestInsertion(n1UsedEdge, n1);
			int costs2 = computeCheapestInsertion(n2UsedEdge, n2);

			return Integer.compare(costs1, costs2);
		}

		private UsedEdge returnMin(Node node) {
			return Collections.min(route.getModelRoute().getWay(), new Comparator<UsedEdge>() {
				@Override
				public int compare(UsedEdge o1, UsedEdge o2) {
					int a = computeCheapestInsertion(o1, node);
					int b = computeCheapestInsertion(o2, node);
					return Integer.compare(a, b);
				}
			});
		}

		private int computeCheapestInsertion(UsedEdge usedEdge, Node newNode) {
			// Insertion Heuristics
			int Dik = E[usedEdge.getEdge().getStart().getId()][newNode.getId()].getDistance();
			int Dkj = E[newNode.getId()][usedEdge.getEdge().getEnd().getId()].getDistance();
			int Dij = usedEdge.getEdge().getDistance();
			return Dik + Dkj - Dij;
		}

		private int distance(Node a, Node b) {
			return E[a.getId()][b.getId()].getDistance();
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
