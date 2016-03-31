package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.geojson.Feature;
import org.geojson.FeatureCollection;
import org.geojson.LineString;
import org.geojson.LngLatAlt;
import org.geojson.Point;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.Color;
import de.fuberlin.winfo.project.visualization.web.logic.NWParamInterpreter;

public class JSONRequest extends AbstractRequest {

	private String baseURL = "";
	private Locatables locatables;

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		baseURL = getBaseURL(baseRequest);
		if (VisualizationServer.networkCache.size() == 0) {
			response.getWriter().write(
					"No data found. Before requesting data is possible, data must be provided. To provide/store data: /json=network<...json...>");
			return;
		}
		int jsonId = NWParamInterpreter.getNWId(baseRequest);
		int solId = NWParamInterpreter.getSolId(baseRequest);
		log("Requested JSON id network #" + jsonId + ", solution #" + solId);

		FeatureCollection collection = returnSolutionAsGeoJson(VisualizationServer.networkCache.get(jsonId),
				VisualizationServer.networkCache.get(jsonId).getSolution().get(solId));
		String featureCollectionAsString = providePrettyGeoJson(collection);
		response.getWriter().write("var nodesAsGeoJson =\n" + featureCollectionAsString);
	}

	private String providePrettyGeoJson(FeatureCollection collection) throws JsonProcessingException {
		String featureCollectionAsString = new ObjectMapper().writeValueAsString(collection);
		featureCollectionAsString = new GsonBuilder().setPrettyPrinting().create()
				.toJson(new JsonParser().parse(featureCollectionAsString));
		return featureCollectionAsString;
	}

	private FeatureCollection returnSolutionAsGeoJson(Network network, Solution solution) {
		locatables = Locatables.inflateBy(network);
		locatables.assignNew(solution.getUsecase().getTranshipmentPoints());
		Map<Locatable, Feature> featureMap = new HashMap<Locatable, Feature>();

		FeatureCollection fCollection = new FeatureCollection();
		for (int i = 0; i < solution.getRoutes().size(); i++) {
			List<LngLatAlt> coordinatesList = new ArrayList<LngLatAlt>();
			Route route = solution.getRoutes().get(i);

			Feature routesFeature = getRouteConnectorFeature(i, coordinatesList, route);

			for (int j = 0; j < route.getWay().size(); j++) {
				Edge edge = route.getWay().get(j).getEdge();
				Node startNode = edge.getStart();
				Node endNode = edge.getEnd();

				LngLatAlt lngLatAlt = getLatLng(startNode);

				Feature startFeature = featureMap.get(startNode.getRepresentative());
				if (startFeature == null) {
					startFeature = getPointFeature(j, startNode, lngLatAlt);
					featureMap.put(startNode.getRepresentative(), startFeature);
					fCollection.add(startFeature);
				}

				/*
				 * For the network / lines (collect all coordinates)
				 */
				coordinatesList.add(lngLatAlt);
				if (j == route.getWay().size() - 1) {
					LngLatAlt lastNodeCoordinates = getLatLng(endNode);
					coordinatesList.add(lastNodeCoordinates);
				}
			}
			fCollection.add(routesFeature);
		}
		return fCollection;
	}

	private LngLatAlt getLatLng(Node node) {
		Locatable r = node.getRepresentative();
		LngLatAlt lngLatAlt = new LngLatAlt(r.getLongitude(), r.getLatitude());
		return lngLatAlt;
	}

	private Feature getPointFeature(int j, Node node, LngLatAlt lngLatAlt) {
		Point point = new Point();
		point.setCoordinates(lngLatAlt);
		Feature feature = new Feature();
		feature.setGeometry(point);
		feature.setId(String.valueOf(node.getId()));
		feature.setProperty("name", String.valueOf(node.getId()));
		feature.setProperty("popupContent", "Order: " + (j == -1 ? "not included" : (j + 1)) + " --> Node #"
				+ node.getId() + ", Type:" + (node.getRepresentative() instanceof Customer ? "Customer" : "Depot"));
		String icon = baseURL + "files/";

		if (node.getRepresentative() instanceof Depot) {
			icon += "maindepot.png";
		} else if (node.getRepresentative() instanceof Customer) {
			Customer c = (Customer) node.getRepresentative();
			if (c.getHasTranshipmentPoint() != null) {
				icon += "depot.png";
			} else {
				icon = "none";
			}
		}

		feature.setProperty("customizedIcon", icon);
		return feature;
	}

	private Feature getRouteConnectorFeature(int i, List<LngLatAlt> coordinatesList, Route route) {
		Feature routesFeature = new Feature();
		routesFeature.setProperty("popupContent",
				"<p>Route: " + (i + 1) + "</b><br>Vehicle Id: " + route.getVehicle().getId() + "<br>Total distance: "
						+ route.getTotalDistanceInM() + "<br>Total time: " + route.getTotalTimeInSec());
		routesFeature.setProperty("color", Color.getColor(i));

		LineString lineString = new LineString();
		lineString.setCoordinates(coordinatesList);
		routesFeature.setGeometry(lineString);
		return routesFeature;
	}

	@Override
	public String getKey() throws IOException {
		return "json";
	}
}
