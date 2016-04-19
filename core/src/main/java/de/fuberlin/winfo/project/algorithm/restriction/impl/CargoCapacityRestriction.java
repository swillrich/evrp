package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class CargoCapacityRestriction implements Restriction {

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		if (route.getActualRoute().getWay().size() == 0) {
			return true;
		}

		double leftCap = route.getActualRoute().getVehicle().getMaxCapacatyPayLoadInKg()
				- route.getActualRoute().getWay().get(0).getCurrentVehicleCargoWeight() - newOrder.getWeight();

		return leftCap >= 0;
	}

	@Override
	public String getFailureMessage() {
		return "Cargo capacity exceedance";
	}

	@Override
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException {
		EList<UsedEdge> list = route.getActualRoute().getWay();
		return list.get(list.size() - 1).getCurrentVehicleCargoWeight() >= 0;
	}

}
