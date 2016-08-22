package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.NWParamInterpreter;

public class ListRequest extends AbstractRequest {

	private StringBuilder sBuilder;
	private List<Network> networks;
	private Request r;

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		this.r = baseRequest;
		saveNetworkIfRequested();
		removeNetworkIfRequested();
		sBuilder = new StringBuilder();
		String html = getResourceAsString("List.html");
		this.networks = VisualizationServer.networkCache;
		String thisPageLink = "<a href=\"" + getBaseURL(r).concat(getKey() + "\">Solutions</a>");
		if (networks.size() == 0) {
			response.getWriter().write("No " + thisPageLink + " available so far.");
		} else {
			writeContent();
			addSubstitation("content", sBuilder.toString());
			addSubstitation("title", thisPageLink);
			String str = replace(html);
			response.getWriter().write(str);
		}
	}

	private void removeNetworkIfRequested() throws IOException {
		if (r.getParameter("remove") != null) {
			int id = NWParamInterpreter.getNWId(r);
			VisualizationServer.removeNetwork(id);
		}
	}

	private void saveNetworkIfRequested() throws IOException {
		if (r.getParameter("save") == null) {
			return;
		}
		int id = NWParamInterpreter.getNWId(r);
		VisualizationServer.save(id);
	}

	private void writeContent() {
		add("<Table id=\"t01\">");

		String[] columns = new String[] { "Id", "NW Nodes", "save / remove", "Creation Time", "Name", "Algorithm",
				"Solving time", "Routes", "Improvment Ratio", "Total consumption", "Total Costs", "Details", "Map",
				"GeoJson" };
		addRow(columns, true, 1, -1);

		for (int i = 0; i < networks.size(); i++) {
			Network n = networks.get(i);
			for (int j = 0; j < n.getSolution().size(); j++) {
				Solution s = n.getSolution().get(j);

				String geoJsonLink = getLink(true, "json", "GeoJson", i, j);
				String detailLink = getLink(true, "ascii", "Details", i, j);
				String mapLink = getLink(true, "map", "Map", i, j);
				String saveLink = getSaveLink(i);
				String removeLink = getLink(false, "list", "x", i, -1, "remove=true");

				Object[] networkLinePart = new Object[] { i, n.getVertices().size(), saveLink + " / " + removeLink };

				Object[] solutionLinePart = new Object[] { FormatConv.asDateTime(s.getCreationTime()), getName(s),
						s.getAlgorithmName(), FormatConv.asDuration(s.getSolvingTime(), ""), s.getRoutes().size(),
						getImprovementRatio(s), FormatConv.withSeparator(s.getTotalVehicleBatteryConsumption(), "kwh"),
						getCosts(s), detailLink, mapLink, geoJsonLink };

				if (n.getSolution().size() > 1) {
					if (j == 0) {
						addRow(ArrayUtils.addAll(networkLinePart, solutionLinePart), false, n.getSolution().size(),
								networkLinePart.length);
					} else {
						addRow(solutionLinePart, false, 1, -1);
					}
				} else {
					addRow(ArrayUtils.addAll(networkLinePart, solutionLinePart), false, 1, -1);
				}
			}
		}
		add("</table>");
	}

	private Object getCosts(Solution s) {
		return FormatConv.withSeparator(s.getRoutes().size() * 16000 + s.getTotalVehicleBatteryConsumption() * 0.30,
				"");
	}

	private Object getName(Solution s) {
		return s.getUsecase().getName();
	}

	private Object getImprovementRatio(Solution s) {
		if (s.getHistory() != null) {
			EList<Event> events = s.getHistory().getEvents();
			if (events.size() > 0) {
				double prevCost = events.get(0).getValue();
				double cost = events.get(events.size() - 1).getValue();
				double diff = prevCost - cost;
				return FormatConv.round(diff / prevCost * 100d, 2) + " %";
			}
		}
		return "-";
	}

	private String getSaveLink(int i) {
		Network network = VisualizationServer.networkCache.get(i);
		if (VisualizationServer.map.containsKey(network)) {
			return "saved";
		} else {
			return getLink(false, "list", "save", i, -1, "save=true");
		}
	}

	private String getLink(boolean newPage, String urlSuffix, String linkName, int id, int solId, String... params) {
		String p = "";
		for (int i = 0; i < params.length; i++) {
			p += "&" + params[i];
		}
		String blank = "";
		if (newPage) {
			blank = "target=\"_blank\"";
		}
		String link = "<a href=\"{0}\" " + blank + ">{1}</a>";
		String url = getBaseURL(r).concat(urlSuffix + "?id=" + id + "&solid=" + solId + p);
		return MessageFormat.format(link, url, linkName);
	}

	private void addRow(Object[] line, boolean bold, int rowSpan, int until) {
		add("<tr>");
		for (int i = 0; i < line.length; i++) {
			String embedRowSpan = "";
			if (rowSpan > 1 && i < until) {
				embedRowSpan = " rowspan=\"" + rowSpan + "\"";
			}
			Object str = line[i];
			if (bold) {
				add("<th" + embedRowSpan + ">" + str + "</th>");
			} else {
				add("<td" + embedRowSpan + ">" + str + "</td>");
			}
		}
		add("</tr>");
	}

	private void add(String str) {
		sBuilder.append(str);
	}

	@Override
	public String getKey() throws IOException {
		return "list";
	}
}
