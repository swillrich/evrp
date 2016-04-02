package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Order;

public class CargoCapacityRestriction implements Restriction {

	@Override
	public boolean check(NetworkProvider np, ExtRoute route, Order newOrder, int index)
			throws RestrictionException {
		if (route.getModelRoute().getWay().size() == 0) {
			return true;
		}

		double leftCap = route.getModelRoute().getVehicle().getMaxCapacatyPayLoadInKg()
				- route.getModelRoute().getWay().get(0).getCurrentVehicleCargoWeight() - newOrder.getWeight();

		return leftCap >= 0;
	}

	@Override
	public String getFailureMessage() {
		return "Cargo capacity exceedance";
	}

}
