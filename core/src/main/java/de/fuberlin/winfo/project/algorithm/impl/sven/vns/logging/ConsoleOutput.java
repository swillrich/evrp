package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.TablePrinter;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.History;
import de.fuberlin.winfo.project.model.network.Solution;

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

	OutputStream stream = null;

	public void writeTo(History history, Solution s, CostFunction f) {
		if (stream == null) {
			try {
				stream = new FileOutputStream("output_" + new Date().getTime() + ".txt", false);
				stream.write("number, timestamp, time, f, distance, cm, time\n".getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Event event = history.getEvents().get(history.getEvents().size() - 1);
		if (event.getType() == EventType.GS_IMPROVEMENT || event.getType() == EventType.INITIAL
				|| event.getType() == EventType.FINAL) {
			Object[] all = new Object[] { history.getEvents().size(), event.getType().name(), event.getTime(),
					event.getValue(), s.getTotalDistance(), s.getTotalVehicleBatteryConsumption(), s.getTotalTime() };
			String collect = Arrays.stream(all).map(o -> o + "").collect(Collectors.joining(","));
			try {
				stream.write((collect + "\n").getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
