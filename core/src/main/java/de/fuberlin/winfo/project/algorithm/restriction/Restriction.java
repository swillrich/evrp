package de.fuberlin.winfo.project.algorithm.restriction;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Solution;

public interface Restriction {
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index) throws RestrictionException;
	
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException;
	
	public boolean checkSolution(NetworkProvider np, Solution solution);
	
	public String getFailureMessage();
}
