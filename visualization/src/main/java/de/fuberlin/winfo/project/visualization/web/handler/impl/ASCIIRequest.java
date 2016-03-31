package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.ASCIIVisualizer;
import de.fuberlin.winfo.project.visualization.web.logic.NWParamInterpreter;

public class ASCIIRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		int networkID = NWParamInterpreter.getNWId(baseRequest);
		int solId = NWParamInterpreter.getSolId(baseRequest);
		response.setContentType("text/plain");
		PrintStream printWriter = new PrintStream(response.getOutputStream());
		ASCIIVisualizer visualizer = new ASCIIVisualizer(VisualizationServer.networkCache.get(networkID), solId,
				printWriter);
		visualizer.visualize();
	}

	@Override
	public String getKey() throws IOException {
		return "ascii";
	}

}
