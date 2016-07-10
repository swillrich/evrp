package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vehicle;

public class RouteReductionProcedure {

	private NetworkProvider provider;
	private List<InRouteOrder> inRouteOrders;
	private List<Order> orders;

	public RouteReductionProcedure(NetworkProvider provider) {
		this.provider = provider;
		this.inRouteOrders = new ArrayList<InRouteOrder>();
	}

	public Solution allocateOrders(Solution solution) {
		Solution copy = Algorithm.getCopy(solution);
		Route min = Collections.min(copy.getRoutes(),
				(r1, r2) -> Integer.compare(r1.getWay().size(), r2.getWay().size()));
		copy.getRoutes().remove(min);
		RouteWrapper routeWrapper = new RouteWrapper(min, null, provider.getArcs());
		this.orders = routeWrapper.getOrders();
		copy.getRoutes().stream().forEach(r -> {
			RouteWrapper wrapper = new RouteWrapper(r, null, provider.getArcs());
			List<Order> list = wrapper.getOrders();
			for (int i = 0; i < list.size(); i++) {
				this.inRouteOrders.add(new InRouteOrder(wrapper, list.get(i), i));
			}
		});

		Restrictions restrictions = new Restrictions(provider);
		restrictions.addAll();

		Iterator<Order> iterator = orders.iterator();
		a: while (iterator.hasNext()) {
			Order order = iterator.next();
			inRouteOrders.forEach(o -> o.dependingOn(order));
			Collections.sort(inRouteOrders);
			List<InRouteOrder> trials = inRouteOrders.stream().filter(o -> o.isFeasible()).collect(Collectors.toList());
			for (InRouteOrder iRO : trials) {
				RouteWrapper wrapper = new RouteWrapper(iRO.route, null, provider.getArcs());
				try {
					restrictions.preliminaryCheck(wrapper.getActualRoute(), order, iRO.i);
					wrapper.useArcAtIndex(order, iRO.i);
					iterator.remove();
					continue a;
				} catch (Exception e) {
				}
			}
			break;
		}
		return orders.isEmpty() ? copy : solution;
	}

	class InRouteOrder implements Comparable<InRouteOrder> {
		private Order order;
		private Route route;
		private double energy;
		private RouteWrapper wrapper;
		private int i;

		public InRouteOrder(RouteWrapper wrapper, Order order, int i) {
			this.wrapper = wrapper;
			this.order = order;
			this.i = i;
			this.route = wrapper.getActualRoute();
		}

		public void dependingOn(Order refOrder) {
			Arc[][] A = provider.getArcs();
			Arc arc = A[this.order.getId()][refOrder.getId()];
			int a = arc.getEnergyMax();
			int b = arc.getEnergyMin();
			this.energy = (a + b) / 2;
		}

		private double value(Route r) {
			double weight = r.getWay().get(0).getCurrentVehicleCargoWeight();
			UsedArc arc = r.getWay().get(r.getWay().size() - 1);
			int bat = arc.getRemainingVehicleBatteryCapacityAtEnd();

			return (1 / 3)
					* (weight / r.getVehicle().getMaxPayLoadInKg() + bat / r.getVehicle().getMaxBatteryCapacityInWH()
							+ energy / route.getTotalVehicleBatteryConsumption());
		}

		@Override
		public int compareTo(InRouteOrder o) {
			return Double.compare(value(this.route), value(o.route));
		}

		boolean isFeasible() {
			UsedArc usedArc = route.getWay().get(route.getWay().size() - 1);
			Vehicle vehicle = route.getVehicle();
			boolean weightFeasible = order.getWeight() + route.getWay().get(0).getCurrentVehicleCargoWeight() <= vehicle
					.getCargoWeightInKg();
			boolean energyFeasible = energy + usedArc.getRemainingVehicleBatteryCapacityAtEnd() <= vehicle
					.getMaxBatteryCapacityInWH();
			return weightFeasible && energyFeasible;
		}
	}
}
