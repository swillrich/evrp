package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute.StochasticCyclingExchangeNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute.StochasticInterRouteSingleNodeRelocationNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute.KOptNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute.StochasticKOptNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vehicle;

public class SvensAlg extends Algorithm {
	Arc[][] A = null;
	NeighborhoodStructure[] neighborhoodStructures = new NeighborhoodStructure[] {
			new StochasticCyclingExchangeNeighborhoodStructure(3, 8000),
			new StochasticInterRouteSingleNodeRelocationNeighborhoodStructure(8000),
			new StochasticKOptNeighborhoodStructure(3, 15000), new KOptNeighborhoodStructure(2) };

	@Override
	public String getName() {
		return "VNS (" + getNeighborhoodStructureNames() + ")";
	}

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
		System.out.println("VNS starts with " + FormatConv.withSeparator(f.compute(solution), ""));
		VNSMonitor historyMonitor = new VNSMonitor(f);
		VNS vns = new VNS(networkProvider, f, neighborhoodStructures, historyMonitor);
		Solution optSolution = vns.run(solution);
		optSolution.setHistory(historyMonitor.getHistory());
		setSolution(optSolution);
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

	private String getNeighborhoodStructureNames() {
		return Arrays.stream(neighborhoodStructures).map(n -> n.getName()).collect(Collectors.joining(", "));
	}

	@Override
	public CostFunction getCostFunction() {
		return new CostFunction() {

			@Override
			public double compute(Solution s) {
				return s.getRoutes().size() * 50000 + s.getTotalVehicleBatteryConsumption() * 0.30;
			}

			@Override
			public double acceptanceThreshold() {
				return 0.01;
			}
		};
	}
}
