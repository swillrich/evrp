package de.fuberlin.winfo.project.algorithm.restriction;

import java.util.ArrayList;
import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.RouteConstructor;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Order;

@SuppressWarnings("serial")
public class Restrictions extends ArrayList<Restriction> {

	private NetworkProvider np;

	public Restrictions(NetworkProvider np) {
		this.np = np;
	}

	public void check(RouteConstructor route, Order newOrder, int index) throws RestrictionException {
		if (route.getModelRoute().getWay().size() == 0) {
			return;
		}
		for (Restriction r : this) {
			if (!r.check(np, route, newOrder, index)) {
				throw new RestrictionException(r.getClass(), r.getFailureMessage());
			}
		}
	}

	public void addAll() {
		Restriction[] restrictions = new Restriction[] { new CargoCapacityRestriction(), new TimeWindowRestriction(),
				new VehicleRangeRestriction() };
		addAll(Arrays.asList(restrictions));
	}
}
