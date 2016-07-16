package de.fuberlin.winfo.project.visualization.web.logic;

import java.io.PrintStream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.History;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Solution;
import dnl.utils.text.table.TextTable;

public class HistoryVisualizer {
	private Network nw;
	private Solution sol;
	private PrintStream stream;
	private History history;
	private String[] titles = "KindOf, Time, f(s), Imprv, Text".split(", ");
	private TextTable table;

	public HistoryVisualizer(Network nw, Solution sol, PrintStream stream) {
		this.nw = nw;
		this.sol = sol;
		this.stream = stream;
		history = sol.getHistory();
		Object[][] data = getData();
		table = new TextTable(titles, data);
		table.setAddRowNumbering(true);
	}

	public void visualizeTable() {
		table.printTable(stream, 0);

	}

	public void visualizeCSV() {
		table.toCsv(stream);
	}

	private Object[][] getData() {
		int totalRows = history.getEvents().size();
		Object[][] oAr = new Object[totalRows][titles.length];
		Event eventPrev = null;
		for (int i = 0; i < totalRows; i++) {
			Event event = history.getEvents().get(i);
			for (int j = 0; j < titles.length; j++) {
				oAr[i][j] = getColumnValue(event, eventPrev, j);
			}
			eventPrev = event;
		}
		return oAr;
	}

	// KindOf, Time, f(s), Imprv, Text
	private Object getColumnValue(Event event, Event eventPrev, int column) {
		switch (column) {
		case 0:
			return event.getType().name();
		case 1:
			return FormatConv.asDuration(event.getTime(), "");
		case 2:
			return FormatConv.withSeparator(event.getValue(), "");
		case 3:
			if (eventPrev == null) {
				return "-";
			} else {
				double prev = eventPrev.getValue();
				double cur = event.getValue();
				return FormatConv.round((prev - cur) / cur * 100d, 2);
			}
		case 4:
			return event.getDescription();
		}
		return null;
	}
}
