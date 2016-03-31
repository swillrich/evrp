package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.NWParamInterpreter;

public class MapRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		if (baseRequest.getRequestURI().contains("map")) {
			String geoJsonURL = getGeoJsonLocationLink(baseRequest, baseRequest);
			requestHTMLTemplateAndFillAndWriteIt(response, geoJsonURL);
		}
	}

	@Override
	public String getKey() throws IOException {
		return "map";
	}

	private String getGeoJsonLocationLink(Request baseRequest, HttpServletRequest request) {
		int id = NWParamInterpreter.getNWId(baseRequest);
		int solId = NWParamInterpreter.getSolId(baseRequest);
		String geoJsonURL = "?id=" + id + "&solid=" + solId;
		geoJsonURL = "http://" + request.getServerName() + ":" + request.getServerPort() + "/json" + geoJsonURL;
		return geoJsonURL;
	}

	private void requestHTMLTemplateAndFillAndWriteIt(HttpServletResponse response, String geoJsonURL)
			throws IOException {
		String res = getResourceAsString("map.html");
		addSubstitation("jsonurl", geoJsonURL);
		String html = replace(res);
		response.getWriter().write(html);
	}
}
