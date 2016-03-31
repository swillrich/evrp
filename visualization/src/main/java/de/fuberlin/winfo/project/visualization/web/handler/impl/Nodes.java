package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LngLatAlt;
import org.geojson.Point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;

public class Nodes extends AbstractRequest {
	private String url;

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		String[] mainDepots = getIfAvailable(baseRequest.getParameter("MD"));
		String[] depots = getIfAvailable(baseRequest.getParameter("D"));
		String[] customer = getIfAvailable(baseRequest.getParameter("C"));
		url = getBaseURL(baseRequest);
		FeatureCollection collection = extract(mainDepots, depots, customer);
		String res = requestHTMLTemplateAndFillAndWriteIt(collection);
		response.getWriter().write(res);
	}

	private String[] getIfAvailable(String string) {
		if (string == null) {
			return null;
		} else {
			if (string.contains(",")) {
				return string.split(",");
			} else {
				return new String[] { string };
			}
		}
	}

	private String requestHTMLTemplateAndFillAndWriteIt(FeatureCollection collection) throws IOException {
		String res = getResourceAsString("map.html");
		return res.replace("<script>", "<script> \nvar nodesAsGeoJson =\n" + providePrettyGeoJson(collection));
	}

	@Override
	public String getKey() throws IOException {
		return "nodes";
	}

	private FeatureCollection extract(String[] md, String[] d, String[] c) {
		FeatureCollection fCollection = new FeatureCollection();
		if (md != null)
			for (String s : md) {
				String[] lanLon = s.split(";");
				fCollection.add(getPointFeature("MD", lanLon[1], lanLon[0]));
			}
		if (d != null)
			for (String s : d) {
				String[] lanLon = s.split(";");
				fCollection.add(getPointFeature("D", lanLon[1], lanLon[0]));
			}
		if (c != null)
			for (String s : c) {
				String[] lanLon = s.split(";");
				fCollection.add(getPointFeature("C", lanLon[1], lanLon[0]));
			}
		return fCollection;
	}

	private Feature getPointFeature(String kindOf, String longitude, String latitude) {
		LngLatAlt lngLatAlt = new LngLatAlt(Double.valueOf(longitude), Double.valueOf(latitude));
		Point point = new Point();
		point.setCoordinates(lngLatAlt);
		Feature feature = new Feature();
		feature.setGeometry(point);
		String finalURL = url + "files/";

		if (kindOf.equalsIgnoreCase("MD")) {
			finalURL += "maindepot.png";
		} else if (kindOf.equalsIgnoreCase("D")) {
			finalURL += "depot.png";
		} else if (kindOf.equalsIgnoreCase("C")) {
			finalURL = "none";
		}

		feature.setProperty("customizedIcon", finalURL);
		return feature;
	}

	private String providePrettyGeoJson(FeatureCollection collection) throws JsonProcessingException {
		String featureCollectionAsString = new ObjectMapper().writeValueAsString(collection);
		featureCollectionAsString = new GsonBuilder().setPrettyPrinting().create()
				.toJson(new JsonParser().parse(featureCollectionAsString));
		return featureCollectionAsString;
	}

	public static void main(String[] args) throws IOException {
		Nodes nodes = new Nodes();
		String[] mainDepots = new String[] { "52.32745;13.259978" };
		String[] depots = new String[] { "52.5360324;13.4519751" };
		String[] customer = new String[] { "52.4579400;13.3389100", "52.5376400;13.2106600" };
		FeatureCollection collection = nodes.extract(mainDepots, depots, customer);
		String res = nodes.requestHTMLTemplateAndFillAndWriteIt(collection);
		System.out.println(res);
	}

}
