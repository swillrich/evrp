package de.fuberlin.winfo.project.visualization.web;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.server.Server;

import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.visualization.web.handler.RequestHandler;

public class VisualizationServer extends Server {

	public static List<Network> networkCache = new ArrayList<Network>();

	public VisualizationServer(int port) throws Exception {
		super(port);
		setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
		setHandler(new RequestHandler());
	}
}