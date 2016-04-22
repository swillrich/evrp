package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import static de.fuberlin.winfo.project.FormatConv.*;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;

public class VNSConsoleOutput {
	String[] titles = new String[] { "Neighborhood", "Operation", "Time", "Best Neighbor", "Abs. Diff", "Rel. Diff",
			"Best Solution" };

	private TablePrinter tablePrinter;

	public VNSConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		int i = 0;
		tablePrinter.setParam(i++, 15);
		tablePrinter.setParam(i++, 15);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 15);
	}

	public void vnsChange(SearchHistory history) {
		EList<VNSSearch> list = history.getVnsSearches();
		VNSSearch improvement = list.get(list.size() - 1);
		String nhName = improvement.getName();
		String newCost = withSeparator(improvement.getCost(), "");
		long diff = improvement.getPrevCost() - improvement.getCost();
		String sek = asDuration(improvement.getTime(), "");
		tablePrinter.print(nhName, improvement.getOperation(), sek, "", "", "", newCost);
	}

	public void neighborhoodChange(SearchHistory history) {
		VNSSearch improvement = history.getVnsSearches().get(history.getVnsSearches().size() - 1);
		EList<NeighborhoodSearch> searches = improvement.getNeighborhoodSearches();
		NeighborhoodSearch search = searches.get(searches.size() - 1);
		String operation = search.getOperation();
		String newCost = withSeparator(search.getCost(), "");
		String costDiff = withSeparator(improvement.getPrevCost() - search.getCost(), "");
		String costDiffRel = "(-)";
		if (searches.size() > 1) {
			costDiffRel = withSeparator(searches.get(searches.size() - 2).getCost() - search.getCost(), "");
		}

		String sek = asDuration(search.getTime(), "");
		tablePrinter.print(improvement.getName(), operation, sek, newCost, costDiff, costDiffRel, "");
	}

}
