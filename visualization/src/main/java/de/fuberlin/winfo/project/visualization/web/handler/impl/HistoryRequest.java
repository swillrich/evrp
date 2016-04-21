package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.io.PrintStream;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.visualization.web.VisualizationServer;
import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;
import de.fuberlin.winfo.project.visualization.web.logic.HistoryVisualizer;
import de.fuberlin.winfo.project.visualization.web.logic.NWParamInterpreter;

public class HistoryRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		response.setContentType("text/plain");
		int nwId = NWParamInterpreter.getNWId(baseRequest);
		Network network = VisualizationServer.networkCache.get(nwId);
		int solId = NWParamInterpreter.getSolId(baseRequest);
		Solution solution = network.getSolution().get(solId);
		PrintStream printWriter = new PrintStream(response.getOutputStream());
		HistoryVisualizer visualizer = new HistoryVisualizer(network, solution, printWriter);
		visualizer.visualize();
	}

	@Override
	public String getKey() throws IOException {
		return "history";
	}

}
