package de.fuberlin.winfo.project.visualization.web.logic;

import java.io.PrintStream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;
import dnl.utils.text.table.TextTable;

public class HistoryVisualizer {
	private Network nw;
	private Solution sol;
	private PrintStream stream;
	private SearchHistory history;
	private String[] titles = "Neighborhood, Operation, Sek, Best Neighbor, Diff (prev), Best Solution".split(", ");
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
		Object[][] oAr = new Object[getTotalRows()][titles.length];
		for (int j = 0, row = 0; j < history.getVnsSearches().size(); j++) {
			VNSSearch vnsSearch = history.getVnsSearches().get(j);
			for (int i = 0; i < vnsSearch.getNeighborhoodSearches().size(); i++) {
				NeighborhoodSearch neighborhoodSearch = vnsSearch.getNeighborhoodSearches().get(i);
				for (int k = 0; k < oAr[row].length; k++) {
					oAr[row][k] = getColumnValue(vnsSearch, neighborhoodSearch, k);
				}
				row++;
			}
			for (int k = 0; k < oAr[row].length; k++) {
				oAr[row][k] = getColumnValue(vnsSearch, null, k);
			}
			row++;
			if (vnsSearch.getNeighborhoodSearches().size() == 0) {
				row++;
			}
		}
		return oAr;
	}

	private Object getColumnValue(VNSSearch vnsSearch, NeighborhoodSearch search, int column) {
		switch (column) {
		case 0:
			return vnsSearch.getName();
		case 1:
			return search != null ? search.getOperation() : vnsSearch.getOperation();
		case 2:
			return FormatConv.asDuration(search != null ? search.getTime() : vnsSearch.getTime(), "");
		case 3:
			return search != null ? FormatConv.withSeparator(search.getCost(), "") : "";
		case 4:
			return search != null ? FormatConv.withSeparator(vnsSearch.getPrevCost() - search.getCost(), "") : "";
		case 5:
			return search == null ? FormatConv.withSeparator(vnsSearch.getCost(), "") : "";
		}
		return "";
	}

	private int getTotalRows() {
		int sum = 0;
		for (int i = 0; i < history.getVnsSearches().size(); i++) {
			sum += history.getVnsSearches().get(i).getNeighborhoodSearches().size() + 1;
		}
		return sum;
	}
}
