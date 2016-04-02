package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Order;

public class VehicleRangeRestriction implements Restriction {

	@Override
	public boolean check(NetworkProvider np, ExtRoute route, Order newOrder, int index)
			throws RestrictionException {

		Node node = AlgHelper.getNodeByOrder(np, newOrder);

		// First new edge
		Edge edgeToNewNode = np.getEdges()[route.getModelRoute().getWay().get(index).getEdge().getStart()
				.getId()][node.getId()];
		// Second new edge
		Edge edgeFromNewNode = np.getEdges()[node.getId()][route.getModelRoute().getWay().get(index).getEdge()
				.getEnd().getId()];

		double need = route.getModelRoute().getWay().get(index).getCurrentVehicleCargoWeight();

		double capacityLeft = 0;
		try {
			capacityLeft = route.computePredictedRemainingVehicleBatteryCapacity(index,
					newOrder.getWeight(), false);
		} catch (Exception e) {
			return false;
		}
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getModelRoute().getVehicle(),
				need + newOrder.getWeight(), edgeToNewNode.getDistance());
		capacityLeft -= AlgHelper.computeEnergyConsumptionOfEdge(route.getModelRoute().getVehicle(), need,
				edgeFromNewNode.getDistance());

		double availableCapacity = route.getModelRoute().getWay().get(route.getModelRoute().getWay().size() - 1)
				.getRemainingVehicleBatteryCapacityAtEnd();

		double oldCapacityLeft = route.getModelRoute().getWay().get(index).getRemainingVehicleBatteryCapacityAtEnd();

		return oldCapacityLeft - capacityLeft <= availableCapacity;
	}

	@Override
	public String getFailureMessage() {
		return "Vehicle maximal range exceedance";
	}
}
