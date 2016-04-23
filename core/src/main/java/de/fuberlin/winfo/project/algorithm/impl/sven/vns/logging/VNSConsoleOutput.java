package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import static de.fuberlin.winfo.project.FormatConv.*;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;

public class VNSConsoleOutput {
	String[] titles = new String[] { "Neighborhood", "Operation", "Duration", "Time", "Best Neighbor", "Abs. Diff",
			"Rel. Diff", "Best Solution", "Abs. Improvement" };

	private TablePrinter tablePrinter;

	public VNSConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		int i = 0;
		tablePrinter.setParam(i++, 40);
		tablePrinter.setParam(i++, 15);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 13);
		tablePrinter.setParam(i++, true, 13);
		tablePrinter.setParam(i++, true, 15);
		tablePrinter.setParam(i++, true, 20);
	}

	public void vnsChange(SearchHistory history) {
		EList<VNSSearch> list = history.getVnsSearches();
		VNSSearch improvement = list.get(list.size() - 1);
		String nhName = improvement.getName();
		String newCost = withSeparator(improvement.getCost(), "");
		String sek = asDuration(improvement.getTime(), "");
		long absDiff = history.getVnsSearches().get(0).getPrevCost() - improvement.getCost();
		String absImprovement = "(+" + round(absDiff / (double) history.getVnsSearches().get(0).getPrevCost(), 4)
				+ "%) " + withSeparator(absDiff, "");
		tablePrinter.print(nhName, improvement.getOperation(), sek,
				FormatConv.getDateTimeUntilHours(new Date().getTime()), "", "", "", newCost, absImprovement);
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
		tablePrinter.print(improvement.getName(), operation, sek,
				FormatConv.getDateTimeUntilHours(new Date().getTime()), newCost, costDiff, costDiffRel, "", "");
	}

}
