package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import java.util.Date;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.GlobalSearch;
import de.fuberlin.winfo.project.model.network.LocalSearch;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.SearchHistory;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

public class VNSMonitor {

	private CostFunction costFunction;
	private GlobalSearch globalSearch;
	private NetworkFactory factory = new NetworkFactoryImpl();
	private SearchHistory history = factory.createSearchHistory();
	private VNSConsoleOutput output = new VNSConsoleOutput();
	private long start = new Date().getTime();

	public VNSMonitor(CostFunction f) {
		this.costFunction = f;
	}

	public SearchHistory getHistory() {
		return history;
	}

	public void startLocalSearch(NeighborhoodStructure nb, Solution initialSol) {
		initVNSSearch(nb);
		globalSearch.setPrevCost(costFunction.compute(initialSol));
		globalSearch.setName(nb.getName());

		output.startLocalSearch(history);
	}

	public void neighborChange(NeighborhoodStructure nb, Solution better, String string) {
		LocalSearch ls = factory.createLocalSearch();
		ls.setTime(new Date().getTime() - start);
		ls.setOperation(string);
		ls.setCost(costFunction.compute(better));
		globalSearch.getLocalSearches().add(ls);

		output.neighborChange(history);
	}

	public void finishedLocalSearch(NeighborhoodStructure neighborhoodStructure, Solution initialSol,
			Solution incumbentSol, int iterations) {
		globalSearch.setCost(costFunction.compute(incumbentSol));
		long diff = globalSearch.getPrevCost() - globalSearch.getCost();
		String operation = "VNS reset";
		if (diff <= 0) {
			operation = "VNS change";
		}
		globalSearch.setOperation(operation);

		output.finishedLocalSearch(history, iterations);
	}

	private void initVNSSearch(NeighborhoodStructure nb) {
		globalSearch = factory.createGlobalSearch();
		history.getSearches().add(globalSearch);
		globalSearch.setName(nb.getName());
	}
}
