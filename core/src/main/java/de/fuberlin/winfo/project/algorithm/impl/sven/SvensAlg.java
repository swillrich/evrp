package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.RouteConstructor;
import de.fuberlin.winfo.project.algorithm.impl.Commissioning;
import de.fuberlin.winfo.project.algorithm.impl.sven.datastructures.OrderPriorityQueue;
import de.fuberlin.winfo.project.algorithm.impl.sven.datastructures.PendingOrder;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class SvensAlg extends Algorithm {

	@Override
	public String getName() {
		return "Svens Insertion Heuristic";
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

		createInitilizationSolution(solution, networkProvider.getLocatables().getMainDepot());
	}

	private void createInitilizationSolution(Solution solution, Depot depot) throws Exception {
		List<Order> remainingOrders = new ArrayList<Order>(depot.getDeliveries());

		while (!remainingOrders.isEmpty()) {
			Vehicle vehicle = solution.getUsecase().getVehicles().get(0);
			RouteConstructor route = buildRoute(vehicle, AlgHelper.getNodeByLocatable(networkProvider, depot));
			OrderPriorityQueue priorityQueue = new OrderPriorityQueue(networkProvider, route, remainingOrders);
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
								+ (route.getModelRoute().getWay().size() + 1) + " nodes built (" + e.getMessage()
								+ ")");
					}
				}
			}
			solution.getRoutes().add(route.getModelRoute());
		}
	}
}
