package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Solution;

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

		runAlgForStage(solution, networkProvider.getLocatables().getMainDepot(),
				networkProvider.getLocatables().getCustomer());
	}

	private void runAlgForStage(Solution solution, Depot depot, List<Locatable> customer) throws Exception {
		List<Order> remaining = new ArrayList<Order>(depot.getDeliveries());
		while (!remaining.isEmpty()) {
			Vehicle vehicle = solution.getUsecase().getVehicles().get(0);
			ExtendedRouteWrapper route = buildRoute(vehicle, AlgHelper.getNodeByLocatable(networkProvider, depot));
			while (!remaining.isEmpty()) {
				Order nextOrder = Collections.min(remaining, new OrderComparator(route));
				try {
					restrictions.check(route, nextOrder, route.getOriginalRoute().getWay().size() - 1);
					route.addDelivery(nextOrder);
					remaining.remove(nextOrder);
				} catch (RestrictionException e) {
					System.out.println((solution.getRoutes().size() + 1) + ". Route built (" + e.getMessage() + ")");
					break;
				}
			}
			solution.getRoutes().add(route.getOriginalRoute());
		}
	}

	private class OrderComparator implements Comparator<Order> {
		private ExtendedRouteWrapper route;

		public OrderComparator(ExtendedRouteWrapper route) {
			this.route = route;
		}

		@Override
		public int compare(Order o1, Order o2) {
			Node n1 = AlgHelper.getNodeByOrder(networkProvider, o1);
			Node n2 = AlgHelper.getNodeByOrder(networkProvider, o2);

			Node lastNode = null;
			if (route.getOriginalRoute().getWay().size() == 0) {
				lastNode = route.getDepot();
			} else {
				lastNode = route.getOriginalRoute().getWay().get(route.getOriginalRoute().getWay().size() - 1).getEdge()
						.getStart();
			}
			Edge edge1 = E[lastNode.getId()][n1.getId()];
			Edge edge2 = E[lastNode.getId()][n2.getId()];

			if (o1.getTimeWindow() == null && o2.getTimeWindow() != null) {
				return 1;
			} else if (o1.getTimeWindow() != null && o2.getTimeWindow() == null) {
				return -1;
			} else {
				return Integer.compare(edge1.getDistance(), edge2.getDistance());
			}
		}
	};
}
