package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.ExtendedRouteWrapper;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;

public class VehicleRangeRestriction implements Restriction {

	@Override
	public boolean check(NetworkProvider np, ExtendedRouteWrapper route, Order newOrder, int index)
			throws RestrictionException {

		Node node = AlgHelper.getNodeByOrder(np, newOrder);

		// First new edge
		Edge edgeToNewNode = np.getEdges()[route.getOriginalRoute().getWay().get(index).getEdge().getStart()
				.getId()][node.getId()];
		// Second new edge
		Edge edgeFromNewNode = np.getEdges()[node.getId()][route.getOriginalRoute().getWay().get(index).getEdge()
				.getEnd().getId()];

		double need = route.getOriginalRoute().getWay().get(index).getCurrentVehicleCargoWeight();

		double capacityLeft = 0;
		try {
			capacityLeft = route.computePredictedRemainingVehicleBatteryCapacity(index,
					newOrder.getWeight(), false);
		} catch (Exception e) {
			return false;
		}
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getOriginalRoute().getVehicle(),
				need + newOrder.getWeight(), edgeToNewNode.getDistance());
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getOriginalRoute().getVehicle(), need,
				edgeFromNewNode.getDistance());

		double availableCapacity = route.getOriginalRoute().getWay().get(route.getOriginalRoute().getWay().size() - 1)
				.getRemainingVehicleBatteryCapacityAtEnd();

		double oldCapacityLeft = route.getOriginalRoute().getWay().get(index).getRemainingVehicleBatteryCapacityAtEnd();

		return oldCapacityLeft - capacityLeft <= availableCapacity;
	}

	@Override
	public String getFailureMessage() {
		return "Vehicle maximal range exceedance";
	}
}
