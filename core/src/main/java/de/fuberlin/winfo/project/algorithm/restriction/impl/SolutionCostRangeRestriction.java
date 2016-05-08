package de.fuberlin.winfo.project.algorithm.restriction.impl;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.restriction.Restriction;
import de.fuberlin.winfo.project.algorithm.restriction.RestrictionException;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Solution;

public class SolutionCostRangeRestriction implements Restriction {

	private double from;
	private double to;
	private CostFunction f;
	private Solution initialSolution;
	private double initialCost;

	public SolutionCostRangeRestriction(Solution initialSolution, double from, double to, CostFunction f) {
		this.from = from;
		this.to = to;
		this.f = f;
		this.initialSolution = initialSolution;
		this.initialCost = f.compute(initialSolution);
	}

	@Override
	public boolean preliminaryCheck(NetworkProvider np, RouteWrapper route, Order newOrder, int index)
			throws RestrictionException {
		return true;
	}

	@Override
	public boolean checkCompleteRoute(NetworkProvider np, RouteWrapper route) throws RestrictionException {
		return true;
	}

	@Override
	public boolean checkSolution(NetworkProvider np, Solution solution) {
		double value = f.compute(solution);
		double diff = initialCost - value;
		double ratio = diff / initialCost;
		return ratio >= from && ratio <= to;
	}

	@Override
	public String getFailureMessage() {
		return "Range Restriction Violation";
	}

}
