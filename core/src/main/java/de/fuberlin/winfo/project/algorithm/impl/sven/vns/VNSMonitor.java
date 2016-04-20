package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import static de.fuberlin.winfo.project.FormatConv.*;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNSMonitor {
	private TablePrinter tablePrinter = new TablePrinter();
	private CostFunction f;

	public VNSMonitor(CostFunction function) {
		this.f = function;
		tablePrinter.setTitles("#, NH, Prev Costs, New Costs, Diff, Reason".split(", "));
	}

	public void vnsUpdate(NeighborhoodStructure nb, int k, Solution prev, Solution better) {
		int prevCost = f.compute(prev);
		int betterCost = f.compute(better);

		String diff = withSeparator((prevCost - betterCost), "");
		String name = k + " (" + nb.getName() + ")";
		String prevString = withSeparator(prevCost, "");
		String betterString = withSeparator(betterCost, "");

		if (prevCost <= betterCost) {
			betterString = "-";
			diff = "-";
		}

		tablePrinter.print(name, prevString, betterString, diff, "no yet implemented");
	}
}
