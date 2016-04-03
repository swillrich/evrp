package de.fuberlin.winfo.project.algorithm.restriction;

import de.fuberlin.winfo.project.algorithm.RouteConstructor;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Order;

public interface Restriction {
	public boolean check(NetworkProvider np, RouteConstructor route, Order newOrder, int index) throws RestrictionException;
	
	public String getFailureMessage();
}
