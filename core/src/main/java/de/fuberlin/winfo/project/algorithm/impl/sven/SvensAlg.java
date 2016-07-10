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
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute.RandomizedCyclingExchangeNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute.RandomizedInterRouteSingleNodeRelocationNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute.KOptNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute.RandomizedKOptNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.MaxTourLengthRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vehicle;

public class SvensAlg extends Algorithm {
	Arc[][] A = null;
	int iterations = 5000 * 5;
	NeighborhoodStructure[] neighborhoodStructures = new NeighborhoodStructure[] {
			new RandomizedCyclingExchangeNeighborhoodStructure(3, iterations),
			new RandomizedCyclingExchangeNeighborhoodStructure(2, iterations),
			new RandomizedInterRouteSingleNodeRelocationNeighborhoodStructure(iterations),
			new RandomizedKOptNeighborhoodStructure(3, iterations), new KOptNeighborhoodStructure(2) };

	@Override
	public String getName() {
		return "VNS (" + getNeighborhoodStructureNames() + ")";
	}

	@Override
	public CostFunction getCostFunction() {
		return new CostFunction() {

			@Override
			public double compute(Solution s) {
				return s.getRoutes().size() * 16000 + s.getTotalVehicleBatteryConsumption() * 0.30;
			}

			@Override
			public double acceptanceThreshold() {
				return 0.01;
			}
		};
	}

	@Override
	public void run(Solution solution) throws Exception {
		A = networkProvider.getArcs();
		restrictions.add(new CargoCapacityRestriction());
		restrictions.add(new VehicleRangeRestriction());
		restrictions.add(new TimeWindowRestriction());
		restrictions.add(new MaxTourLengthRestriction());

		constructProcedure(solution, networkProvider.getLocatables());

		solution = reducingRoutes(solution);

		improvementProcedure(solution);
	}

	private Solution reducingRoutes(Solution solution) {
		while (true) {
			RouteReductionProcedure routeReductionProcedure = new RouteReductionProcedure(networkProvider);
			Solution update = routeReductionProcedure.allocateOrders(solution);
			if (update.getRoutes().size() < solution.getRoutes().size()) {
				System.out.println("Reduced by " + (solution.getRoutes().size() - update.getRoutes().size())
						+ " route(s) --> " + update.getRoutes().size() + " Solution cost: " + f.compute(solution));
				solution = update;
				setSolution(solution);
			} else {
				break;
			}
		}
		return solution;
	}

	private void improvementProcedure(Solution solution) throws Exception {
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
					restrictions.preliminaryCheck(route.getActualRoute(), nextPendingOrder.getOrder(),
							nextPendingOrder.getPos());
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
}
