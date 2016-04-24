package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import java.util.Date;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.SolutionFactory;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

public class VNSMonitor {

	private CostFunction costFunction;
	private VNSSearch vnsSearch;
	private SolutionFactory factory = new SolutionFactoryImpl();
	private SearchHistory history = factory.createSearchHistory();
	private VNSConsoleOutput output = new VNSConsoleOutput();
	private long start = new Date().getTime() / 1000;

	public VNSMonitor(CostFunction f) {
		this.costFunction = f;
	}

	public SearchHistory getHistory() {
		return history;
	}

	public void startLocalSearch(NeighborhoodStructure nb, Solution initialSol) {
		initVNSSearch(nb);
		vnsSearch.setPrevCost(costFunction.compute(initialSol));
		vnsSearch.setName(nb.getName());
		vnsSearch.setTime(new Date().getTime() / 1000 - start);

		output.vnsStart(history);
	}

	public void neighborChange(NeighborhoodStructure nb, Solution better, String string) {
		NeighborhoodSearch change = factory.createNeighborhoodSearch();
		change.setTime(new Date().getTime() / 1000 - start);
		change.setOperation(string);
		change.setCost(costFunction.compute(better));
		vnsSearch.getNeighborhoodSearches().add(change);
		output.neighborChange(history);
	}

	public void finishedLocalSearch(NeighborhoodStructure neighborhoodStructure, Solution initialSol,
			Solution incumbentSol, int iterations) {
		vnsSearch.setCost(costFunction.compute(incumbentSol));

		long diff = vnsSearch.getPrevCost() - vnsSearch.getCost();
		String operation = "VNS reset";
		if (diff <= 0) {
			operation = "VNS change";
		}
		vnsSearch.setOperation(operation);
		output.vnsFinished(history, iterations);
	}

	private void initVNSSearch(NeighborhoodStructure nb) {
		vnsSearch = factory.createVNSSearch();
		history.getVnsSearches().add(vnsSearch);
		vnsSearch.setName(nb.getName());
	}
}
