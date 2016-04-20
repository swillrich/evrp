package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.Commissioning;
import de.fuberlin.winfo.project.algorithm.impl.sven.datastructures.OrderPriorityQueue;
import de.fuberlin.winfo.project.algorithm.impl.sven.datastructures.PendingOrder;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.VNS;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.KOptNeighborhoodStructure;
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
		constructProcedure(solution, networkProvider.getLocatables().getMainDepot());
		improvementProcedure(solution);
	}

	private void improvementProcedure(Solution solution) {
		CostFunction f = new CostFunction() {

			@Override
			public int compute(Solution s) {
				if (s == null) {
					return Integer.MAX_VALUE;
				}
				int size = s.getRoutes().size();
				long distance = s.getTotalDistance();
				return (int) (distance);
			}
		};
		Solution optSolution = VNS
				.vns(networkProvider, f, solution,
						new NeighborhoodStructure[] { new KOptNeighborhoodStructure(2),
								new KOptNeighborhoodStructure(3), new KOptNeighborhoodStructure(4) },
						new VNSMonitor(f));
		
		updateSolution(optSolution);
	}

	private void constructProcedure(Solution solution, Depot depot) throws Exception {
		List<Order> remainingOrders = new ArrayList<Order>(depot.getDeliveries());

		while (!remainingOrders.isEmpty()) {
			Vehicle vehicle = solution.getUsecase().getVehicles().get(0);
			RouteWrapper route = buildRoute(vehicle, AlgHelper.getNodeByLocatable(networkProvider, depot));
			OrderPriorityQueue priorityQueue = new OrderPriorityQueue(networkProvider, route, remainingOrders);
			RestrictionException exception = null;
			while (!priorityQueue.isEmpty()) {
				PendingOrder nextPendingOrder = priorityQueue.poll();
				try {
					restrictions.check(route, nextPendingOrder.getOrder(), nextPendingOrder.getPos());
					if (route.getActualRoute().getWay().isEmpty()) {
						route.addDelivery(nextPendingOrder.getOrder());
					} else {
						route.addDeliveryAtIndex(nextPendingOrder.getOrder(), nextPendingOrder.getPos());
					}
					remainingOrders.remove(nextPendingOrder.getOrder());
				} catch (RestrictionException e) {
					exception = e;
				}
			}
			String reason = exception != null ? exception.getMessage() : "no restriction violated";
			System.out.println((solution.getRoutes().size() + 1) + ". Route with "
					+ (route.getActualRoute().getWay().size() + 1) + " nodes built (" + reason + ")");
			solution.getRoutes().add(route.getActualRoute());
			route.takeCareOfSolutionValues();
		}
	}
}
