package de.fuberlin.winfo.project.algorithm.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.AlgHelper.ModRoute;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Commissioning;
import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class NN extends Algorithm {

	@Override
	public String getName() {
		return "NN without TW";
	}

	Edge[][] E = null;

	@Override
	public void run(Solution solution) throws Exception {
		
		List<Locatable> customer = networkProvider.getLocatables().getCustomer();
		E = networkProvider.getEdges();

		List<Locatable> tp = networkProvider.getLocatables().getTranshipmentPoints();
		if (tp.size() == 0) {
			tp.add(networkProvider.getLocatables().getMainDepot());
			runAlgForStage(solution, tp, customer);
		} else {
			runAlgForStage(solution, tp, customer);
			tp.add(networkProvider.getLocatables().getMainDepot());
			ArrayList<Locatable> depots = new ArrayList<Locatable>();
			depots.add(networkProvider.getLocatables().getMainDepot());
			runAlgForStage(solution, depots, tp);
		}
	}

	private void runAlgForStage(Solution solution, List<Locatable> tp, List<Locatable> customer) throws Exception {
		List<Depot> depots = calculateCluster(tp, customer);

		for (Depot d : depots) {
			List<CollectiveOrder> remaining = new ArrayList<CollectiveOrder>(d.getDeliveries());
			while (!remaining.isEmpty()) {
				Vehicle vehicle = getVehicle(solution, d);
				ModRoute route = buildRoute(vehicle, getNode(d));
				while (!remaining.isEmpty()) {
					Order nextOrder = Collections.min(remaining, new OrderComparator(route));
					if (canRouteDealWith(route, nextOrder)) {
						route.addDelivery(nextOrder);
						remaining.remove(nextOrder);
					} else {
						break;
					}
				}
				solution.getRoutes().add(route.getRoute());
			}
		}
	}

	private class OrderComparator implements Comparator<Order> {
		private ModRoute route;

		public OrderComparator(ModRoute route) {
			this.route = route;
		}

		@Override
		public int compare(Order o1, Order o2) {
			Node n1 = AlgHelper.getNodeByOrder(networkProvider, o1);
			Node n2 = AlgHelper.getNodeByOrder(networkProvider, o2);

			Node lastNode = null;
			if (route.getWay().size() == 0) {
				lastNode = route.getDepot();
			} else {
				lastNode = route.getWay().get(route.getWay().size() - 1).getEdge().getStart();
			}

			Edge edge1 = E[lastNode.getId()][n1.getId()];
			Edge edge2 = E[lastNode.getId()][n2.getId()];

			return Integer.compare(edge1.getDistance(), edge2.getDistance());
		}
	};

	/*
	 * CONSTRAINTS
	 */
	private boolean canRouteDealWith(ModRoute route, Order nextOrder) throws Exception {
		if (route.getWay().size() == 0) {
			return true;
		}
		if (!route.isSufficientEnergyAvailable(nextOrder, route.getWay().size() - 1)) {
			return false;
		}
		double remainingCap = route.getVehicle().getMaxCapacatyPayLoadInKg()
				- route.getWay().get(0).getCurrentVehicleCargoWeight() - nextOrder.getNeedAsWeight();
		if (remainingCap < 0) {
			return false;
		}
		return true;
	}

	/*
	 * HELPER & CLUSTERING
	 */

	private Vehicle getVehicle(Solution solution, Locatable l) {
		if (l instanceof Depot) {
			return solution.getUsecase().getVehicles().get(0);
		} else {
			return solution.getUsecase().getVehicles().get(1);
		}
	}

	private List<Depot> calculateCluster(List<Locatable> tp, List<Locatable> allCustomer) {
		Map<Locatable, List<Locatable>> map = new HashMap<Locatable, List<Locatable>>();
		tp.forEach(l -> map.put(l, new ArrayList<Locatable>()));
		Iterator<Locatable> iterator = allCustomer.iterator();

		if (tp.size() > 1) {
			while (iterator.hasNext()) {
				Locatable nextCustomer = iterator.next();
				if (map.keySet().contains(nextCustomer)) {
					map.get(nextCustomer).add(nextCustomer);
				} else {
					Node node = getNode(nextCustomer);
					Locatable min = Collections.min(tp,
							(u, v) -> Integer.compare(E[getNode(u).getId()][node.getId()].getDistance(),
									E[getNode(v).getId()][node.getId()].getDistance()));
					map.get(min).add(nextCustomer);
				}
			}
		} else {
			map.get(tp.get(0)).addAll(allCustomer);
		}

		return extractOrders(map);
	}

	private List<Depot> extractOrders(Map<Locatable, List<Locatable>> map) {
		List<Depot> depots = new ArrayList<Depot>();

		for (Locatable l : map.keySet()) {
			Depot depot = AlgHelper.getLocatable(l, Depot.class);

			Duration duration = networkProvider.getNetworkFactory().createDuration();
			duration.setStartInSec(3600);
			duration.setEndInSec(50000);
			depot.setTimeWindow(duration);

			List<CollectiveOrder> orders = Commissioning.collect(map.get(l));

			depot.getDeliveries().addAll(orders);
			depots.add(depot);
		}
		return depots;
	}

	private Node getNode(Locatable l) {
		return AlgHelper.getNodeByLocatable(networkProvider, l);
	}
}
