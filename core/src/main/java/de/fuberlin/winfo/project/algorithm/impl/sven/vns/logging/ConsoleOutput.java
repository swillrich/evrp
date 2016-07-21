package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.History;

public class ConsoleOutput {
	String[] titles = new String[] { "KIND", "DATE", "f(s)", "IMPR", "IMPR T", "TEXT" };

	private TablePrinter tablePrinter;

	public ConsoleOutput() {
		tablePrinter = new TablePrinter(System.out, titles);
		int i = 0;
		tablePrinter.setParam(i++, 18);
		tablePrinter.setParam(i++, 18);
		tablePrinter.setParam(i++, 18);
		tablePrinter.setParam(i++, 8);
		tablePrinter.setParam(i++, 8);
		tablePrinter.setParam(i++, 80);
	}

	public void change(History history) {
		EList<Event> list = history.getEvents();
		Event lastE = list.get(list.size() - 1);

		String imprv = "-";
		String imprvTotal = "-";
		if (list.size() > 1) {
			double first = list.get(0).getValue();
			double prev = list.get(list.size() - 2).getValue();
			double cur = lastE.getValue();
			imprv = getImprovementText(prev, cur);
			imprvTotal = getImprovementText(first, cur);
		}

		tablePrinter.print(lastE.getType().name(), FormatConv.asDateTime(lastE.getTime()),
				FormatConv.withSeparator(lastE.getValue(), ""), imprv, imprvTotal,
				lastE.getDescription() != null ? lastE.getDescription() : "");
	}

	private String getImprovementText(double prev, double cur) {
		String imprv;
		double diff = prev - cur;
		imprv = String.valueOf(FormatConv.round(diff / prev * 100d, 4));
		if (imprv.length() > 6) {
			imprv = imprv.substring(0, 6);
		}
		imprv = imprv.concat(" %");
		return imprv;
	}
}
