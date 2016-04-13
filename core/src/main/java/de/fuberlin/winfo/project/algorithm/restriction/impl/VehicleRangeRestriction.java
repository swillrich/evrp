package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;

public class VehicleRangeRestriction implements Restriction {

	@Override
	public boolean check(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {

		Node node = AlgHelper.getNodeByOrder(newOrder);

		// First new edge
		Edge edgeToNewNode = np.getEdges()[route.getActualRoute().getWay().get(index).getEdge().getStart()
				.getId()][node.getId()];
		// Second new edge
		Edge edgeFromNewNode = np.getEdges()[node.getId()][route.getActualRoute().getWay().get(index).getEdge()
				.getEnd().getId()];

		double need = route.getActualRoute().getWay().get(index).getCurrentVehicleCargoWeight();

		double capacityLeft = 0;
		try {
			capacityLeft = route.computePredictedRemainingVehicleBatteryCapacity(index,
					newOrder.getWeight(), false);
		} catch (Exception e) {
			return false;
		}
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getActualRoute().getVehicle(),
				need + newOrder.getWeight(), edgeToNewNode.getDistance());
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getActualRoute().getVehicle(), need,
				edgeFromNewNode.getDistance());

		double availableCapacity = route.getActualRoute().getWay().get(route.getActualRoute().getWay().size() - 1)
				.getRemainingVehicleBatteryCapacityAtEnd();

		double oldCapacityLeft = route.getActualRoute().getWay().get(index).getRemainingVehicleBatteryCapacityAtEnd();

		return oldCapacityLeft - capacityLeft <= availableCapacity;
	}

	@Override
	public String getFailureMessage() {
		return "Vehicle maximal range exceedance";
	}
}
