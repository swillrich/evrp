package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.routeconstruction.OrderPriorityQueue;
import de.fuberlin.winfo.project.algorithm.impl.sven.routeconstruction.PendingOrder;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.VNS;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.KOptNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.StochasticInterRouteSingleNodeRelocationNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vehicle;

public class SvensAlg extends Algorithm {

	@Override
	public String getName() {
		return "Svens Insertion Heuristic with VNS (2/3-opt)";
	}

	Arc[][] A = null;

	@Override
	public void run(Solution solution) throws Exception {
		A = networkProvider.getArcs();
		restrictions.add(new CargoCapacityRestriction());
		restrictions.add(new VehicleRangeRestriction());
		restrictions.add(new TimeWindowRestriction());

		constructProcedure(solution, networkProvider.getLocatables());
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
		System.out.println("VNS starts with " + FormatConv.withSeparator(f.compute(solution), ""));

		VNSMonitor historyMonitor = new VNSMonitor(f);
		Solution optSolution = VNS
				.vns(networkProvider, f, solution,
						new NeighborhoodStructure[] {
								new StochasticInterRouteSingleNodeRelocationNeighborhoodStructure(),
								new KOptNeighborhoodStructure(2) },
						historyMonitor);
		optSolution.setHistory(historyMonitor.getHistory());
		updateSolution(optSolution);
	}

	private void constructProcedure(Solution solution, Locatables locatables) throws Exception {
		List<Order> remainingOrders = new ArrayList<Order>(locatables.getAllOrders());

		while (!remainingOrders.isEmpty()) {
			Vehicle vehicle = solution.getUsecase().getVehicles().get(0);
			RouteWrapper route = buildRoute(vehicle, locatables.getDepot());
			OrderPriorityQueue priorityQueue = new OrderPriorityQueue(networkProvider, route, remainingOrders);
			RestrictionException exception = null;
			while (!priorityQueue.isEmpty()) {
				PendingOrder nextPendingOrder = priorityQueue.poll();
				try {
					restrictions.check(route, nextPendingOrder.getOrder(), nextPendingOrder.getPos());
					if (route.getActualRoute().getWay().isEmpty()) {
						route.useArc(nextPendingOrder.getOrder());
					} else {
						route.useArcAtIndex(nextPendingOrder.getOrder(), nextPendingOrder.getPos());
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
