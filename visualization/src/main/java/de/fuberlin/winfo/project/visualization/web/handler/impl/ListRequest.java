package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.ArrayUtils;
import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.Statistics;

public class ListRequest extends AbstractRequest {

	private StringBuilder sBuilder;
	private List<Network> networks;
	private Request r;

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		this.r = baseRequest;
		sBuilder = new StringBuilder();
		String html = getResourceAsString("List.html");
		this.networks = VisualizationServer.networkCache;
		if (networks.size() == 0) {
			response.getWriter().write("No Solutions available so far.");
		} else {
			writeContent();
			addSubstitation("content", sBuilder.toString());
			String str = replace(html);
			response.getWriter().write(str);
		}
	}

	private void writeContent() {
		add("<Table id=\"t01\">");

		String[] columns = new String[] { "Id", "NW Nodes", "NW Edges", "Scenario Name", "Routes", "Total Time",
				"Total Distance", "Distance Avg / Route", "Total Wait", "Pers Costs", "Mat Costs", "Total Costs",
				"Details", "Map", "GeoJson" };
		addRow(columns, true, 1, -1);

		for (int i = 0; i < networks.size(); i++) {
			Network n = networks.get(i);
			for (int j = 0; j < n.getSolution().size(); j++) {
				Solution s = n.getSolution().get(j);

				Statistics st = new Statistics(n);

				String geoJsonLink = getLink("json", "GeoJson", i, j);
				String detailLink = getLink("ascii", "Details", i, j);
				String mapLink = getLink("map", "Map", i, j);

				Object[] networkLinePart = new Object[] { i, n.getNodes().size(), n.getEdges().size() };

				Object[] solutionLinePart = new Object[] { s.getUsecase().getName(), s.getRoutes().size(),
						FormatConv.asTime(s.getTotalTime(), "h"),
						FormatConv.numberWithSeparatorAndMeter(s.getTotalDistance()),
						FormatConv.withSeparator(st.getAverageDistance(s), "m"), st.getTotalWait(s),
						FormatConv.getInEuro(st.getPersonnalCosts(s)),
						FormatConv.getInEuro(st.getMaterialCosts(s)),
						FormatConv.getInEuro(st.getTotalCosts(s)), detailLink, mapLink, geoJsonLink };

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

	private String getLink(String urlSuffix, String linkName, int id, int solId) {
		String link = "<a href=\"{0}\" target=\"_blank\">{1}</a>";
		String url = getBaseURL(r).concat(urlSuffix + "?id=" + id + "&solid=" + solId);
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
