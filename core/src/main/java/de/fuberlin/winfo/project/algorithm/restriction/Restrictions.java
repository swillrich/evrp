package de.fuberlin.winfo.project.algorithm.restriction;

import java.util.ArrayList;
import java.util.Arrays;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.restriction.impl.CargoCapacityRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.TimeWindowRestriction;
import de.fuberlin.winfo.project.algorithm.restriction.impl.VehicleRangeRestriction;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;

@SuppressWarnings("serial")
public class Restrictions extends ArrayList<Restriction> {

	private NetworkProvider np;

	public Restrictions(NetworkProvider np) {
		this.np = np;
	}

	public boolean isAllRight(Solution solution) {
		for (Route route : solution.getRoutes()) {
			try {
				checkCompleteRoute(route);
				return true;
			} catch (RestrictionException e) {
				return false;
			}
		}
		return true;
	}

	public void check(Route route, Order newOrder, int index) throws RestrictionException {
		if (route.getWay().size() == 0) {
			return;
		}
		RouteWrapper routeWrapper = wrap(route);
		for (Restriction r : this) {
			if (!r.preliminaryCheck(np, routeWrapper, newOrder, index)) {
				throw new RestrictionException(r.getClass(), r.getFailureMessage());
			}
		}
	}

	private RouteWrapper wrap(Route route) {
		RouteWrapper routeWrapper = new RouteWrapper(route, null, np.getArcs());
		return routeWrapper;
	}

	public void addAll() {
		Restriction[] restrictions = new Restriction[] { new CargoCapacityRestriction(), new TimeWindowRestriction(),
				new VehicleRangeRestriction() };
		addAll(Arrays.asList(restrictions));
	}

	public void checkCompleteRoute(Route route) throws RestrictionException {
		RouteWrapper routeWrapper = wrap(route);
		if (routeWrapper.getActualRoute().getWay().size() == 0) {
			return;
		}
		for (Restriction r : this) {
			if (!r.checkCompleteRoute(np, routeWrapper)) {
				throw new RestrictionException(r.getClass(), r.getFailureMessage());
			}
		}
	}
}
