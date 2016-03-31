package de.fuberlin.winfo.project.visualization.web.logic;

import static de.fuberlin.winfo.project.FormatConv.asTime;
import static de.fuberlin.winfo.project.FormatConv.numberWithSeparator;
import static de.fuberlin.winfo.project.FormatConv.numberWithSeparatorAndMeter;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;
import dnl.utils.text.table.TextTable;

public class ASCIIVisualizer {

	private Solution solution;
	private PrintStream printStream;
	private Statistics statistics;
	private String[] simpleTypeNames = new String[] { Depot.class.getSimpleName(), Customer.class.getSimpleName() };

	public ASCIIVisualizer(Network network, int solId, PrintStream printStream) {
		this.solution = network.getSolution().get(solId);
		this.printStream = printStream;
		this.statistics = new Statistics(network);
	}

	public void visualize() throws UnsupportedEncodingException, IOException {
		String[] title = new String[] { "Source Node", "Target Node", "Departure (h)", "Arrival (h)",
				"Target Node TimeWindow", "Duration (h)", "Real duration (h)", "Distance (m)", "Rem. Weight (Kg)",
				"Rem. KW", "Order Id" };

		out("ASCII Visualization of the following solution solved by " + solution.getProcedure());
		out("");
		out("Explanation:");

		for (String simpleTypeName : simpleTypeNames) {
			out(simpleTypeName.substring(0, 2).toUpperCase() + " = " + simpleTypeName);
		}

		for (Route route : solution.getRoutes()) {
			Object[][] content = null;
			Vehicle vehicle = route.getVehicle();
			out("");
			out("Route #" + solution.getRoutes().indexOf(route));
			out("Vehicle #" + vehicle.getId() + " (Reach: " + numberWithSeparatorAndMeter(vehicle.getMaxReachInMeter())
					+ ", max Cargo Capacity: " + numberWithSeparator(vehicle.getMaxCapacatyPayLoadInKg(), "Kg")
					+ ", max kWH: " + numberWithSeparator(vehicle.getBatteryCapacityInWh(), "") + ", Driver Costs: "
					+ vehicle.getDriverCostsPerHour() + " Euro, " + "Operating Costs per Km: "
					+ vehicle.getOperatingCostsPerMeter() * 1000 + " Euro");

			content = new Object[route.getWay().size()][title.length];
			for (int i = 0; i < route.getWay().size(); i++) {
				UsedEdge usedEdge = route.getWay().get(i);
				Node start = usedEdge.getEdge().getStart();
				Node end = usedEdge.getEdge().getEnd();
				String timeWindow = "-";
				Duration duration = getTimeWindow(usedEdge, false);
				if (duration != null) {
					timeWindow = asTime(duration.getStartInSec(), "") + " - " + asTime(duration.getEndInSec(), "");
				}
				int j = 0;
				content[i][j++] = "#" + start.getId() + "(" + getAbbreviation(start.getRepresentative()) + ")";
				content[i][j++] = "#" + end.getId() + "(" + getAbbreviation(end.getRepresentative()) + ")";
				content[i][j++] = asTime(usedEdge.getDuration().getStartInSec(), "");
				content[i][j++] = asTime(usedEdge.getDuration().getEndInSec(), "");
				content[i][j++] = timeWindow;
				content[i][j++] = asTime(usedEdge.getEdge().getTime(), "");
				content[i][j++] = asTime(usedEdge.getDuration().getEndInSec() - usedEdge.getDuration().getStartInSec(),
						"");
				content[i][j++] = numberWithSeparator(usedEdge.getEdge().getDistance(), "");
				content[i][j++] = numberWithSeparator(usedEdge.getCurrentVehicleCargoWeight(), "");
				content[i][j++] = numberWithSeparator(usedEdge.getRemainingVehicleBatteryCapacityAtEnd(), "");
				content[i][j++] = usedEdge instanceof Delivery ? ((Delivery) usedEdge).getOrder().getId() : "-";
			}

			TextTable textTable = new TextTable(title, content);
			textTable.setAddRowNumbering(true);
			textTable.printTable(printStream, 0);
			out("");
			out("Total distance of this route: " + numberWithSeparatorAndMeter(route.getTotalDistanceInM()));
			out("Total time of this route: " + asTime(route.getTotalTimeInSec(), "h"));
			out("Total waiting time of this route: " + statistics.getTotalWait(route));
			out("Personnal Costs: " + FormatConv.getInEuro(statistics.getPersonnalCosts(route)));
			out("Material Costs: " + FormatConv.getInEuro(statistics.getMaterialCosts(route)));
		}
		out("");
		out("Total number of routes: " + solution.getRoutes().size());
		out("Total distance of this solution: " + numberWithSeparatorAndMeter(solution.getTotalDistance()));
		out("Total time of this solution: " + asTime(solution.getTotalTime(), "h"));
		out("Total waiting time of this solution: " + statistics.getTotalWait(solution));
		out("Total Costs: " + FormatConv.getInEuro(statistics.getTotalCosts(solution)));
	}

	private String getAbbreviation(Locatable locatable) {
		if (locatable instanceof Customer) {
			if (((Customer) locatable).getHasTranshipmentPoint() != null) {
				return "CU, DE";
			}
			return "CU";
		} else if (locatable instanceof Depot) {
			return "DE";
		}
		return null;
	}

	public Duration getTimeWindow(UsedEdge usedEdge, boolean atStart) {
		if (usedEdge instanceof Delivery) {
			return ((Delivery) usedEdge).getOrder().getTimeWindow();
		} else {
			Locatable locatable = null;
			if (atStart) {
				locatable = usedEdge.getEdge().getStart().getRepresentative();
			} else {
				locatable = usedEdge.getEdge().getEnd().getRepresentative();
			}
			if (locatable instanceof Depot) {
				return ((Depot) locatable).getTimeWindow();
			} else if (locatable instanceof Customer) {
				Customer c = (Customer) locatable;
				if (c.getHasTranshipmentPoint() != null) {
					return c.getHasTranshipmentPoint().getTimeWindow();
				}

			}
		}
		return null;
	}

	private void out(String out) throws UnsupportedEncodingException, IOException {
		printStream.write(out.concat("\n").getBytes("UTF-8"));
	}
}
