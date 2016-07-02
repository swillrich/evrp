package de.fuberlin.winfo.project.algorithm.restriction.impl;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class VehicleRangeRestriction implements Restriction {

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		try {
			Route r = route.getActualRoute();
			UsedArc usedArcToRemove = r.getWay().get(index);

			Arc arcToNewVertex = np.getArcs()[usedArcToRemove.getArc().getStart().getId()][newOrder.getId()];
			Arc arcFromNewVertex = np.getArcs()[newOrder.getId()][usedArcToRemove.getArc().getEnd().getId()];

			double need = usedArcToRemove.getCurrentVehicleCargoWeight();

			double capacityLeft = route.computePredictedRemainingVehicleBatteryCapacity(index, newOrder.getWeight(),
					false);
			capacityLeft -= RouteWrapper.computeEnergyConsumptionOfArc(r.getVehicle(), need + newOrder.getWeight(),
					arcToNewVertex);
			capacityLeft -= RouteWrapper.computeEnergyConsumptionOfArc(r.getVehicle(), need, arcFromNewVertex);

			double availableCapacity = r.getWay().get(r.getWay().size() - 1).getRemainingVehicleBatteryCapacityAtEnd();
			double oldCapacityLeft = usedArcToRemove.getRemainingVehicleBatteryCapacityAtEnd();
			return oldCapacityLeft - capacityLeft <= availableCapacity;
		} catch (Exception e) {
			return false;
		}
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

	@Override
	public boolean checkSolution(NetworkProvider np, Solution solution) {
		// TODO Auto-generated method stub
		return true;
	}
}
