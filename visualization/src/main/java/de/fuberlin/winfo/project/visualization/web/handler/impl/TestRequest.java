package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;

public class TestRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
//		for (Route route : VisualizationServer.networkCache.get(VisualizationServer.networkCache.size() - 1)
//				.getSolution().getRoutes()) {
//			for (UsedEdge usedEdge : route.getWay()) {
//				response.getWriter().write("@ Vehicle " + route.getVehicle().getId() + " on Edge "
//						+ usedEdge.getEdge().getId() + " --> " + usedEdge.getRemainingCargoWeight());
//				response.getWriter().write("<br>");
//			}
//		}
	}

	@Override
	public String getKey() throws IOException {
		return "test";
	}

}
