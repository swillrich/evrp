package de.fuberlin.winfo.project.algorithm.restriction.impl;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class VehicleRangeRestriction implements Restriction {

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {

		// First new arc
		Arc arcToNewVertex = np.getArcs()[route.getActualRoute().getWay().get(index).getArc().getStart()
				.getId()][newOrder.getId()];
		// Second new arc
		Arc arcFromNewVertex = np.getArcs()[newOrder.getId()][route.getActualRoute().getWay().get(index).getArc()
				.getEnd().getId()];

		double need = route.getActualRoute().getWay().get(index).getCurrentVehicleCargoWeight();

		double capacityLeft = 0;
		try {
			capacityLeft = route.computePredictedRemainingVehicleBatteryCapacity(index, newOrder.getWeight(), false);
		} catch (Exception e) {
			return false;
		}
		capacityLeft -= RouteWrapper.computeEnergyConsumptionOfArc(route.getActualRoute().getVehicle(),
				need + newOrder.getWeight(), arcToNewVertex.getDistance());
		capacityLeft -= RouteWrapper.computeEnergyConsumptionOfArc(route.getActualRoute().getVehicle(), need,
				arcFromNewVertex.getDistance());

		double availableCapacity = route.getActualRoute().getWay().get(route.getActualRoute().getWay().size() - 1)
				.getRemainingVehicleBatteryCapacityAtEnd();

		double oldCapacityLeft = route.getActualRoute().getWay().get(index).getRemainingVehicleBatteryCapacityAtEnd();

		return oldCapacityLeft - capacityLeft <= availableCapacity;
	}

	@Override
	public String getFailureMessage() {
		return "Vehicle maximal range exceedance";
	}

	@Override
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException {
		EList<UsedArc> list = route.getActualRoute().getWay();
		return list.get(list.size() - 1).getRemainingVehicleBatteryCapacityAtEnd() >= 0;
	}
}
