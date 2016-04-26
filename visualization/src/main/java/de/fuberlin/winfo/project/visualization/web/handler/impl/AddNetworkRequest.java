package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;

public class AddNetworkRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		ServletInputStream inputStream = baseRequest.getInputStream();
		GZIPInputStream gzipInputStream = new GZIPInputStream(inputStream);
		try {
			log("Unzip and deserialize incoming network object. This process might take serverial seconds.");
			Network deserializeFromXMIString = XMIIO.deserialize(gzipInputStream);
			VisualizationServer.networkCache.add(deserializeFromXMIString);
			log("New Network and Solution update stored (number of nodes: " + deserializeFromXMIString.getVertices().size()
					+ ").");
			log("New total number of networks: " + VisualizationServer.networkCache.size());
		} catch (Exception e) {
			log("No Network input");
		}
	}

	@Override
	public String getKey() throws IOException {
		return "network";
	}

}
