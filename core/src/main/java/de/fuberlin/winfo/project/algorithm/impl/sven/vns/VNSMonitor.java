package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import static de.fuberlin.winfo.project.FormatConv.withSeparator;

import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNSMonitor {
	String[] titles = new String[] { "NH", "Prev Cost", "New Cost", "Diff", "Reason" };
	private TablePrinter tablePrinter;
	private CostFunction f;
	
	public VNSMonitor(CostFunction function) {
		this.f = function;
		tablePrinter = new TablePrinter(System.out, titles);
		tablePrinter.setParam(0, 9);
		tablePrinter.setParam(1, 15);
		tablePrinter.setParam(2, 15);
		tablePrinter.setParam(3, 13);
		tablePrinter.setParam(4, 20);
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
