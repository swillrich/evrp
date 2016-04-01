package de.fuberlin.winfo.project.algorithm.restriction;

import de.fuberlin.winfo.project.algorithm.ExtendedRouteWrapper;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Order;

public interface Restriction {
	public boolean check(NetworkProvider np, ExtendedRouteWrapper route, Order newOrder, int index) throws RestrictionException;
	
	public String getFailureMessage();
}
