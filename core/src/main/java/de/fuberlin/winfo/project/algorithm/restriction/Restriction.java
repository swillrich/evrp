package de.fuberlin.winfo.project.algorithm.restriction;

import de.fuberlin.winfo.project.algorithm.ExtRoute;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.Order;

public interface Restriction {
	public boolean check(NetworkProvider np, ExtRoute route, Order newOrder, int index) throws RestrictionException;
	
	public String getFailureMessage();
}
