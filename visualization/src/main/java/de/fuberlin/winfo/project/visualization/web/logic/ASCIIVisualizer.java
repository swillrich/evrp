package de.fuberlin.winfo.project.visualization.web.logic;

import static de.fuberlin.winfo.project.FormatConv.asDuration;
import static de.fuberlin.winfo.project.FormatConv.numberWithSeparatorAndMeter;
import static de.fuberlin.winfo.project.FormatConv.withSeparator;

import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.Vertex;
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
		String[] title = new String[] { "Source Vertex", "Target Vertex", "Departure (h)", "Arrival (h)",
				"Target Vertex TimeWindow", "Duration (h)", "Real duration (h)", "Distance (m)", "Rem. Weight (Kg)",
				"Rem. KW", "Order Id" };

		out("ASCII Visualization of the following solution solved by " + solution.getAlgorithmName());
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
			out("Vehicle #" + vehicle.getId() + ", max Cargo Capacity: "
					+ withSeparator(vehicle.getMaxPayLoadInKg(), "Kg") + ", max kWH: "
					+ withSeparator(vehicle.getMaxBatteryCapacityInWH(), ""));

			content = new Object[route.getWay().size()][title.length];
			for (int i = 0; i < route.getWay().size(); i++) {
				UsedArc usedArc = route.getWay().get(i);
				Vertex start = usedArc.getArc().getStart();
				Vertex end = usedArc.getArc().getEnd();
				String timeWindow = "-";
				Duration duration = getTimeWindow(usedArc.getArc().getEnd());
				if (duration != null) {
					timeWindow = asDuration(duration.getStartInSec() * 1000, "") + " - "
							+ asDuration(duration.getEndInSec() * 1000, "");
				}
				int j = 0;
				content[i][j++] = "#" + start.getId();
				content[i][j++] = "#" + end.getId();
				content[i][j++] = asDuration(usedArc.getDuration().getStartInSec() * 1000, "");
				content[i][j++] = asDuration(usedArc.getDuration().getEndInSec() * 1000, "");
				content[i][j++] = timeWindow;
				content[i][j++] = asDuration(usedArc.getArc().getTime() * 1000, "");
				content[i][j++] = asDuration(
						(usedArc.getDuration().getEndInSec() - usedArc.getDuration().getStartInSec()) * 1000, "");
				content[i][j++] = withSeparator(usedArc.getArc().getDistance(), "");
				content[i][j++] = withSeparator(usedArc.getCurrentVehicleCargoWeight(), "");
				content[i][j++] = withSeparator(usedArc.getRemainingVehicleBatteryCapacityAtEnd(), "");
				content[i][j++] = usedArc.getArc().getEnd() instanceof Order
						? ((Order) usedArc.getArc().getEnd()).getOrderId() : "-";
			}

			TextTable textTable = new TextTable(title, content);
			textTable.setAddRowNumbering(true);
			textTable.printTable(printStream, 0);
			out("");
			out("Total distance of this route: " + numberWithSeparatorAndMeter(route.getTotalDistanceInM()));
			out("Total time of this route: " + asDuration(route.getTotalTimeInSec() * 1000, "h"));
			out("Personnal Costs: " + FormatConv.getInEuro(statistics.getPersonnalCosts(route)));
			out("Material Costs: " + FormatConv.getInEuro(statistics.getMaterialCosts(route)));
		}
		out("");
		out("Total number of routes: " + solution.getRoutes().size());
		out("Total distance of this solution: " + numberWithSeparatorAndMeter(solution.getTotalDistance()));
		out("Total time of this solution: " + asDuration(solution.getTotalTime() * 1000, "h"));
		out("Total Costs: " + FormatConv.getInEuro(statistics.getTotalCosts(solution)));
	}

	public Duration getTimeWindow(Vertex v) {
		if (v instanceof Order) {
			return ((Order) v).getTimeWindow();
		} else if (v instanceof Depot) {
			return ((Depot) v).getTimeWindow();
		} else {
			return null;
		}
	}

	private void out(String out) throws UnsupportedEncodingException, IOException {
		printStream.write(out.concat("\n").getBytes("UTF-8"));
	}
}
