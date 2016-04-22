package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;
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

		String[] columns = new String[] { "Id", "NW Nodes", "save / remove", "Creation Time", "Algorithm",
				"Solving time", "Routes", "Total Time", "Total Distance", "Details", "Map", "GeoJson", "VNS History" };
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
				String vnsHistory = getLink(true, "history", "history", i, j);
				vnsHistory += " (" + getLink(true, "history", "csv", i, j, "asCSV=true") + ")";

				Object[] networkLinePart = new Object[] { i, n.getNodes().size(), saveLink + " / " + removeLink };

				Object[] solutionLinePart = new Object[] { FormatConv.asDateTime(s.getHistory().getCreationTime()),
						"", getSolvingTime(s), s.getRoutes().size(),
						FormatConv.asDuration(s.getTotalTime(), "h"),
						FormatConv.numberWithSeparatorAndMeter(s.getTotalDistance()), detailLink, mapLink, geoJsonLink,
						vnsHistory };

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

	private String getSolvingTime(Solution s) {
		if (s.getHistory().getVnsSearches().size() > 0) {
			VNSSearch search = s.getHistory().getVnsSearches().get(s.getHistory().getVnsSearches().size() - 1);
			if (search.getNeighborhoodSearches().size() > 0) {
				NeighborhoodSearch neighborhoodSearch = search.getNeighborhoodSearches()
						.get(search.getNeighborhoodSearches().size() - 1);
				return FormatConv.asDuration(neighborhoodSearch.getTime(), "");
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
