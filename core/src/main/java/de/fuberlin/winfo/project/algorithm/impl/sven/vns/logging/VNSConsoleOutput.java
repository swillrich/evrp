package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import static de.fuberlin.winfo.project.FormatConv.asDuration;
import static de.fuberlin.winfo.project.FormatConv.round;
import static de.fuberlin.winfo.project.FormatConv.withSeparator;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.GlobalSearch;
import de.fuberlin.winfo.project.model.network.LocalSearch;
import de.fuberlin.winfo.project.model.network.SearchHistory;

public class VNSConsoleOutput {
	String[] titles = new String[] { "Neighborhood", "Operation", "Duration", "Time", "Best Neighbor", "Diff", "Cost" };

	private TablePrinter tablePrinter;

	public VNSConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		int i = 0;
		tablePrinter.setParam(i++, 25);
		tablePrinter.setParam(i++, 23);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 10);
		tablePrinter.setParam(i++, true, 23);
		tablePrinter.setParam(i++, true, 20);
		tablePrinter.setParam(i++, true, 20);
	}

	public void startLocalSearch(SearchHistory history) {
		GlobalSearch lastGS = lastGS(history, 0);
		LocalSearch lastLS = lastLS(lastGS(history, 1), 0);

		String dur = "-";
		if (lastLS != null) {
			dur = asDuration(lastLS.getTime(), "");
		}

		String name = lastGS.getName();
		String pc = withSeparator(lastGS.getPrevCost(), "");
		String dateTimeUntilHours = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(name, "start", dur, dateTimeUntilHours, "", "", pc);
	}

	public void neighborChange(SearchHistory history) {
		GlobalSearch gS = lastGS(history, 0);
		LocalSearch search = lastLS(gS, 0);
		String operation = search.getOperation();
		String newCost = withSeparator(search.getCost(), "");
		newCost = "(" + (round((gS.getPrevCost() - search.getCost()) / (double) gS.getPrevCost() * 100d, 4)) + "%) "
				+ newCost;
		String costDiff = withSeparator(search.getCost() - gS.getPrevCost(), "");

		String dur = asDuration(search.getTime(), "");

		String name = gS.getName();
		String time = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(name, operation, dur, time, newCost, costDiff, "");
	}

	public void finishedLocalSearch(SearchHistory history, int iterations) {
		GlobalSearch gs = lastGS(history, 0);
		LocalSearch ls = lastLS(gs, 0);
		double absDiff = history.getSearches().get(0).getPrevCost() - gs.getCost();
		double diffPrev = gs.getPrevCost() - gs.getCost();

		String nhName = gs.getName();
		String dur = asDuration(ls.getTime(), "");
		String absImprovement = "(" + round(absDiff / (double) history.getSearches().get(0).getPrevCost() * 100, 4)
				+ "%) " + withSeparator(gs.getCost(), "");
		String relImprovement = "(" + round(diffPrev / (double) gs.getPrevCost() * 100, 4) + "%) "
				+ withSeparator(diffPrev, "");
		String it = withSeparator(iterations, "");

		String time = FormatConv.getDateTimeUntilHours(new Date().getTime());
		tablePrinter.print(nhName, gs.getOperation() + " (" + it + ")", dur, time, "", relImprovement, absImprovement);
	}

	private GlobalSearch lastGS(SearchHistory history, int i) {
		int size = history.getSearches().size() - i;
		EList<GlobalSearch> list = history.getSearches();
		if (size <= 0) {
			return null;
		}
		GlobalSearch globalSearch = list.get(size - 1);
		return globalSearch;
	}

	private LocalSearch lastLS(GlobalSearch gs, int i) {
		if (gs == null) {
			return null;
		}
		int size = gs.getLocalSearches().size() - i;
		if (size <= 0) {
			return null;
		}
		return gs.getLocalSearches().get(size - 1);
	}
}
