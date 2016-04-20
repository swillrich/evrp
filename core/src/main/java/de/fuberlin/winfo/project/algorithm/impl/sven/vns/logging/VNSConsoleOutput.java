package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import static de.fuberlin.winfo.project.FormatConv.withSeparator;

import java.util.List;

import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSHistory.ChangeListener;

public class VNSConsoleOutput implements ChangeListener {
	String[] titles = new String[] { "Neighborhood", "Operation", "Best Neighbor", "Diff (prev)", "Best Solution",
			"Diff (prev)" };
	private TablePrinter tablePrinter;

	public VNSConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		tablePrinter.setParam(1, 15);

		tablePrinter.setParam(2, true, 15);
		tablePrinter.setParam(4, true, 15);
		tablePrinter.setParam(3, true, 15);
		tablePrinter.setParam(5, true, 15);
	}

	@Override
	public void vnsChange(VNSHistory history) {
		List<VNSChange> list = history.getVnsImprovements();
		VNSChange improvement = list.get(list.size() - 1);
		String nhName = improvement.getNeighborhoodStuctureName();
		String newCost = withSeparator(improvement.getNewCost(), "");
		String diff = withSeparator(improvement.getDiff(), "");
		String operation = "VNS reset";
		if (improvement.getDiff() <= 0) {
			operation = "VNS change";
		}
		tablePrinter.print(nhName, operation, "", "", newCost, diff);
	}

	@Override
	public void neighborhoodChange(VNSHistory history) {
		VNSChange improvement = history.getCurrentNH();
		String nhName = improvement.getNeighborhoodStuctureName();
		List<NeighborhoodChange> changes = improvement.getNeighborhoodChanges();
		NeighborhoodChange change = changes.get(changes.size() - 1);
		String operation = change.getName();
		String newCost = withSeparator(change.getCost(), "");
		String costDiff = "-";
		if (changes.size() > 1) {
			int cost = changes.get(changes.size() - 2).getCost();
			costDiff = withSeparator(cost - changes.get(changes.size() - 1).getCost(), "");
		}
		tablePrinter.print(nhName, operation, newCost, costDiff, "", "");
	}

}
