package de.fuberlin.winfo.project.algorithm.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.StaticLocatables;
import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Commissioning;
import de.fuberlin.winfo.project.algorithm.impl.module.ClusterGenerator;
import de.fuberlin.winfo.project.algorithm.impl.module.ClusterGenerator.Cluster;
import de.fuberlin.winfo.project.algorithm.impl.module.DCVRPTW;
import de.fuberlin.winfo.project.algorithm.impl.module.NearesNeighbor;
import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class DCVRPTW_with_SimpleClusters_Alg extends Algorithm {

	@Override
	public String getName() {
		return "DCVRPTW with Cluster";
	}

	Solution solution;
	Vehicle firstStageVehicle;

	@Override
	public void run(Solution solution) throws Exception {

		this.solution = solution;
		firstStageVehicle = solution.getUsecase().getVehicles().get(0);
		Vehicle secondStageVehicle = solution.getUsecase().getVehicles().get(0);
		if (solution.getUsecase().getVehicles().size() > 1) {
			secondStageVehicle = solution.getUsecase().getVehicles().get(1);
		}

		System.out.println("\nCommissioning transhipmentpoint orders!");
		commissioningTranshipmentNodesAsLittleAsPossible(firstStageVehicle.getMaxCapacatyPayLoadInKg());

		System.out.println("\nClustering!");
		ClusterGenerator generator = new ClusterGenerator(networkProvider, firstStageVehicle);
		List<Cluster> clusters = generator.getClusters();

		System.out.println("\nRouting (secondStage)!");
		List<Cluster> secondStageCluster = clusters.subList(1, clusters.size());
		routingCluster(solution, secondStageCluster, secondStageVehicle, false);

		System.out.println("\nCommissioning at transhipmentpoint starting orders!");
		createOrdersAtTranshipmentPointsForAllRoutes(solution.getRoutes());

		System.out.println("\nRouting (firstStage)!");
		Cluster firstStageCluster = clusters.get(0);
		DCVRPTW alg = new DCVRPTW(networkProvider, this);
		solution.getRoutes().addAll(alg.run(firstStageCluster, firstStageCluster.clusterCenterNode, firstStageVehicle));

	}

	private void commissioningTranshipmentNodesAsLittleAsPossible(double maxOrderCapacity) {
		StaticLocatables locatables = networkProvider.getLocatables();

		// for all transhimentpoints
		for (int t = 0; t < locatables.getTranshipmentPointsAsNodes().size(); t++) {
			Node transhipmentPoint = locatables.getTranshipmentPointsAsNodes().get(t);
			int ordersAdded = 0;

			// sammle collective orders
			List<CollectiveOrder> ordersList = new ArrayList<>();

			// get all orders from transhiment-customer
			List<Order> orders = ((Customer) transhipmentPoint.getRepresentative()).getOwnedOrders();

			while (ordersAdded < orders.size()) {
				// init collective Order
				CollectiveOrder collectiveOrder = initCollectiveOrder(transhipmentPoint);

				double availableCapacity = maxOrderCapacity;
				boolean enoughCapacity = true;

				// while enough capacity
				while (enoughCapacity && ordersAdded < orders.size()) {

					for (int o = ordersAdded; o < orders.size(); o++) {
						if (collectiveOrder.getNeedAsWeight() + orders.get(o).getNeedAsWeight() <= availableCapacity) {
							double newWeight = collectiveOrder.getNeedAsWeight() + orders.get(o).getNeedAsWeight();
							double newStandingTime = collectiveOrder.getStandingTimeInSec()
									+ (orders.get(o).getStandingTimeInSec() * 0.75);

							collectiveOrder.setNeedAsWeight(newWeight);
							collectiveOrder.setStandingTimeInSec((int) newStandingTime);

							if (orders.get(o).getTimeWindow() != null) {
								if (collectiveOrder.getTimeWindow().getStartInSec() > orders.get(o).getTimeWindow()
										.getStartInSec()) {
									collectiveOrder.getTimeWindow()
											.setStartInSec(orders.get(o).getTimeWindow().getStartInSec());
								}
								if (collectiveOrder.getTimeWindow().getEndInSec() > orders.get(o).getTimeWindow()
										.getEndInSec()) {
									collectiveOrder.getTimeWindow()
											.setEndInSec(orders.get(o).getTimeWindow().getEndInSec());
								}
							}

							collectiveOrder.getConsistOf().add(orders.get(o));
							ordersAdded++;
						} else {
							enoughCapacity = false;
						}
					}
				}
				if (collectiveOrder.getStandingTimeInSec() > firstStageVehicle.getTranshipmentTimeInMinutes()
						* 60) {
					collectiveOrder
							.setStandingTimeInSec((int) (firstStageVehicle.getTranshipmentTimeInMinutes() * 60));
				}
				if (collectiveOrder.getTimeWindow().getStartInSec() == Integer.MAX_VALUE
						&& collectiveOrder.getTimeWindow().getEndInSec() == Integer.MAX_VALUE) {
					collectiveOrder.setTimeWindow(null);
				}
				ordersList.add(collectiveOrder);
			}

			Customer transhipmentPointAsCustomer = (Customer) transhipmentPoint.getRepresentative();
			Depot transhipmentPointAsDepot = (Depot) transhipmentPointAsCustomer.getHasTranshipmentPoint();
			transhipmentPointAsDepot.getDeliveries().addAll(ordersList);
		}

	}

	private CollectiveOrder initCollectiveOrder(Node transhipmentPoint) {
		CollectiveOrder collectiveOrder = networkProvider.getNetworkFactory().createCollectiveOrder();
		collectiveOrder.setId("c-" + transhipmentPoint.getId());
		collectiveOrder.setNeedAsWeight(0);
		collectiveOrder.setStandingTimeInSec(0);
		Duration timeWindow = networkProvider.getNetworkFactory().createDuration();
		timeWindow.setStartInSec(Integer.MAX_VALUE);
		timeWindow.setEndInSec(Integer.MAX_VALUE);
		collectiveOrder.setTimeWindow(timeWindow);
		collectiveOrder.setReceiver(transhipmentPoint.getRepresentative());
		return collectiveOrder;
	}

	private void commissioningTranshipmentNodes() {
		StaticLocatables locatables = networkProvider.getLocatables();
		List<Locatable> transhipmentNodes = locatables.getTranshipmentPoints();

		for (int t = 0; t < transhipmentNodes.size(); t++) {
			List<CollectiveOrder> orderList = new ArrayList<>();

			Customer transhipmentPoint = (Customer) transhipmentNodes.get(t);
			List<Order> orders = transhipmentPoint.getOwnedOrders();
			int ordersCount = orders.size();
			for (int o = 0; o < ordersCount; o++) {
				Order order = orders.get(0);
				boolean orderAdded = false;

				if (order.getTimeWindow() == null) {
					for (int oL = 0; oL < orderList.size(); oL++) {
						if (orderList.get(oL).getTimeWindow() == null) {
							orderList.get(oL).getConsistOf().add(order);
							double newWeight = orderList.get(oL).getNeedAsWeight() + order.getNeedAsWeight();
							orderList.get(oL).setNeedAsWeight(newWeight);
							double newStandingTime = orderList.get(oL).getStandingTimeInSec()
									+ (order.getStandingTimeInSec() * 0.75);
							orderList.get(oL).setStandingTimeInSec((int) newStandingTime);
							break;
						}
					}
				} else {

					int timeWindowStart = order.getTimeWindow().getStartInSec();
					int timeWindowEnd = order.getTimeWindow().getEndInSec();

					for (int oL = 0; oL < orderList.size(); oL++) {
						boolean sameTimeWindowStart = false;
						boolean sameTimeWindowEnd = false;

						if (orderList.get(oL).getTimeWindow() != null) {
							sameTimeWindowStart = timeWindowStart == orderList.get(oL).getTimeWindow().getStartInSec();
							sameTimeWindowEnd = timeWindowEnd == orderList.get(oL).getTimeWindow().getEndInSec();
						}

						if (sameTimeWindowStart && sameTimeWindowEnd) {
							orderList.get(oL).getConsistOf().add(order);
							double newWeight = orderList.get(oL).getNeedAsWeight() + order.getNeedAsWeight();
							orderList.get(oL).setNeedAsWeight(newWeight);
							double newStandingTime = orderList.get(oL).getStandingTimeInSec()
									+ (order.getStandingTimeInSec() * 0.75);
							orderList.get(oL).setStandingTimeInSec((int) newStandingTime);
							orderAdded = true;
							break;
						}
					}

				}
				if (!orderAdded) {
					CollectiveOrder newOrder = networkProvider.getNetworkFactory().createCollectiveOrder();
					newOrder.setId(
							"c-" + locatables.getTranshipmentPointsAsNodes().get(t).getId() + "-" + orderList.size());
					newOrder.setNeedAsWeight(order.getNeedAsWeight());
					newOrder.setStandingTimeInSec(order.getStandingTimeInSec());

					if (order.getTimeWindow() != null) {
						Duration timeWindow = networkProvider.getNetworkFactory().createDuration();
						timeWindow.setStartInSec(order.getTimeWindow().getStartInSec());
						timeWindow.setEndInSec(order.getTimeWindow().getEndInSec());
						newOrder.setTimeWindow(timeWindow);
					}
					newOrder.setReceiver(transhipmentPoint);

					orderList.add(newOrder);
					orderList.get(orderList.size() - 1).getConsistOf().add(order);
				}
			}
			Depot transhipmentPointAsDepot = (Depot) transhipmentPoint.getHasTranshipmentPoint();
			transhipmentPointAsDepot.getDeliveries().addAll(orderList);
		}
	}

	private void createOrdersAtTranshipmentPointsForAllRoutes(EList<Route> routes) {
		for (int i = 0; i < routes.size(); i++) {

			CollectiveOrder collectiveOrder = networkProvider.getNetworkFactory().createCollectiveOrder();

			// set ID
			collectiveOrder.setId("c-" + routes.get(i).getWay().get(0).getEdge().getStart().getId() + "-" + i);

			// set standing time
			double fixProportion = firstStageVehicle.getTranshipmentTimeInMinutes() * 60 * 0.05;
			double varProportion = firstStageVehicle.getTranshipmentTimeInMinutes() * 60 * 0.95
					/ firstStageVehicle.getMaxCapacatyPayLoadInKg()
					* routes.get(i).getWay().get(0).getCurrentVehicleCargoWeight();

			collectiveOrder.setStandingTimeInSec((int) (fixProportion + varProportion));

			// init NeedAsWight
			collectiveOrder.setNeedAsWeight(0);

			// add Orders and update NeedAsWight
			for (int uE = 0; uE < routes.get(i).getWay().size(); uE++) {
				if (routes.get(i).getWay().get(uE) instanceof Delivery) {
					Order order = ((Delivery) routes.get(i).getWay().get(uE)).getOrder();
					collectiveOrder.getConsistOf().add(order);
					collectiveOrder.setNeedAsWeight(collectiveOrder.getNeedAsWeight() + order.getNeedAsWeight());
				}
			}

			// add timewindow

			Duration timeWindow = networkProvider.getNetworkFactory().createDuration();
			timeWindow.setStartInSec(0);
			timeWindow.setEndInSec(routes.get(i).getWay().get(0).getDuration().getStartInSec()
					- collectiveOrder.getStandingTimeInSec());

			collectiveOrder.setTimeWindow(timeWindow);

			Locatable locatableTP = routes.get(i).getWay().get(0).getEdge().getStart().getRepresentative();
			Customer customerTP = (Customer) locatableTP;
			Depot depotTP = (Depot) customerTP.getHasTranshipmentPoint();

			// set reciever of collective order
			collectiveOrder.setReceiver(depotTP);

			// add collective order to Depot
			depotTP.getDeliveries().add(collectiveOrder);
		}
	}

	private void routingCluster(Solution solution, List<Cluster> clusters, Vehicle vehicle, boolean withNN) {
		/*
		 * With Lambda 8 from Java
		 */

		clusters.stream().peek(c -> System.out.println("\nCluster: " + clusters.indexOf(c))).filter(c -> c.size() > 0)
				.forEach(c -> {
					try {
						if (withNN) {
							NearesNeighbor nearesNeighbor = new NearesNeighbor(networkProvider, this);
							solution.getRoutes().add(nearesNeighbor.run(c, c.clusterCenterNode));
						} else {

							DCVRPTW alg = new DCVRPTW(networkProvider, this);
							solution.getRoutes().addAll(alg.run(c, c.clusterCenterNode, vehicle));
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
				});
	}

	// private void routingFirstStage(List<Cluster> clusters) throws Exception {
	//
	//
	// System.out.println("Add Tour to Cluster:");
	//
	// for (int i = 0; i < clusters.size(); i++) {
	//
	// double howManyVehiclesNeeded = Math.ceil(
	// clusters.get(i).clusterNeedAsWeight /
	// networkProvider.getVehicles()[0].getMaxCapacatyPayLoadInKg());
	//
	// for (int v = 0; v < howManyVehiclesNeeded; v++) {
	//
	// if (clusters.get(i).clusterCenterNode.getRepresentative().getType() !=
	// NodeType.DEPOT) {
	//
	// ModRoute route = new ModRoute(this, networkProvider.getVehicles()[0],
	// networkProvider.getNodes()[0]);
	//
	// TranshipmentPoint tp =
	// AlgHelper.getLocatable(clusters.get(i).clusterCenterNode.getRepresentative(),
	// TranshipmentPoint.class);
	//
	// route.addDelivery(tp.getOrders().get(0));
	//
	// // Order commissioning =
	// // pickAllCustomerOrder(clusters.get(i));
	//
	// System.out.println("Add Tour " + (v + 1) + " to Cluster " + (i + 1));
	// }
	// }
	// }
	// }

}
