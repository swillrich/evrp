package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import static de.fuberlin.winfo.project.FormatConv.asDuration;
import static de.fuberlin.winfo.project.FormatConv.round;
import static de.fuberlin.winfo.project.FormatConv.withSeparator;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;

public class VNSConsoleOutput {
	String[] titles = new String[] { "Neighborhood", "Operation", "Duration", "Time", "Best Neighbor", "Diff", "Cost" };

	private TablePrinter tablePrinter;

	public VNSConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		int i = 0;
		tablePrinter.setParam(i++, 40);
		tablePrinter.setParam(i++, 23);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 23);
		tablePrinter.setParam(i++, true, 20);
		tablePrinter.setParam(i++, true, 20);
	}

	public void vnsFinished(SearchHistory history, int iterations) {
		VNSSearch improvement = lastLS(history);
		long absDiff = history.getVnsSearches().get(0).getPrevCost() - improvement.getCost();
		double diffPrev = improvement.getPrevCost() - improvement.getCost();

		String nhName = improvement.getName();
		String dur = asDuration(improvement.getTime(), "");
		String absImprovement = "(" + round(absDiff / (double) history.getVnsSearches().get(0).getPrevCost(), 4) + "%) "
				+ withSeparator(improvement.getCost(), "");
		String relImprovement = "(" + round(diffPrev / (double) improvement.getPrevCost(), 4) + "%) "
				+ withSeparator(diffPrev, "");
		String it = withSeparator(iterations, "");

		String time = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(nhName, improvement.getOperation() + " (" + it + ")", dur, time, "", relImprovement,
				absImprovement);
	}

	public void neighborChange(SearchHistory history) {
		VNSSearch improvement = lastLS(history);
		EList<NeighborhoodSearch> searches = improvement.getNeighborhoodSearches();
		NeighborhoodSearch search = searches.get(searches.size() - 1);
		String operation = search.getOperation();
		String newCost = withSeparator(search.getCost(), "");
		newCost = "(" + (round((improvement.getPrevCost() - search.getCost()) / (double) improvement.getPrevCost(), 4))
				+ "%) " + newCost;
		String costDiff = withSeparator(search.getCost() - improvement.getPrevCost(), "");

		String dur = asDuration(search.getTime(), "");
		String name = improvement.getName();
		String time = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(name, operation, dur, time, newCost, costDiff, "");
	}

	public void vnsStart(SearchHistory history) {
		VNSSearch lastLS = lastLS(history);

		String time = asDuration(lastLS.getTime(), "");
		String name = lastLS.getName();
		String pc = withSeparator(lastLS.getPrevCost(), "");
		String dateTimeUntilHours = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(name, "start", time, dateTimeUntilHours, "", "", pc);
	}

	private VNSSearch lastLS(SearchHistory history) {
		EList<VNSSearch> list = history.getVnsSearches();
		VNSSearch improvement = list.get(list.size() - 1);
		return improvement;
	}
}
