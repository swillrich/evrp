package de.fuberlin.winfo.project.visualization.web.logic;

import java.io.PrintStream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.History;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Solution;
import dnl.utils.text.table.TextTable;

public class HistoryVisualizer {
	private PrintStream stream;
	private History history;
	private String[] titles = "KindOf, Time, f(s), Imprv, IncVNS, IncTotal, Text".split(", ");
	private TextTable table;
	private double incumbent = 0;
	private double vnsIncumbent = 0;

	public HistoryVisualizer(Network nw, Solution sol, PrintStream stream) {
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
			if (event.getType() == EventType.GS_IMPROVEMENT) {
				vnsIncumbent = 0;
			}
			vnsIncumbent = setVar(event, vnsIncumbent);
			incumbent = setVar(event, incumbent);
			for (int j = 0; j < titles.length; j++) {
				oAr[i][j] = getColumnValue(event, eventPrev, j);
			}
			eventPrev = event;
		}
		return oAr;
	}

	private double setVar(Event event, double incumbent) {
		if (event.getValue() < incumbent || incumbent == 0) {
			incumbent = event.getValue();
		}
		return incumbent;
	}

	// KindOf, Time, f(s), Imprv, ImprvVNS, ImprvTotal, Text
	private Object getColumnValue(Event event, Event eventPrev, int column) {
		switch (column) {
		case 0:
			return event.getType().name();
		case 1:
			return FormatConv.asDuration(event.getTime(), "");
		case 2:
			return event.getValue();
		case 3:
			if (eventPrev == null) {
				return 0;
			} else {
				double prev = eventPrev.getValue();
				double cur = event.getValue();
				return FormatConv.round((prev - cur) / cur * 100d, 2);
			}
		case 4:
			return vnsIncumbent;
		case 5:
			return incumbent;
		case 6:
			return event.getDescription();
		}
		return null;
	}
}
