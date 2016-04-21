package de.fuberlin.winfo.project.visualization.web.logic;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.visualization.web.VisualizationServer;

public class NWParamInterpreter {
	public static int getNWId(Request request) {
		String parameter = request.getParameter("id");
		if (parameter == null) {
			int size = VisualizationServer.networkCache.size();
			if (size == 0) {
				return 0;
			} else {
				return size - 1;
			}
		} else {
			return Integer.valueOf(parameter);
		}
	}
	
	public static int getSolId(Request request) {
		int nwId = getNWId(request);
		String parameter = request.getParameter("solid");
		if (parameter == null) {
			int size = VisualizationServer.networkCache.get(nwId).getSolution().size();
			if (size == 0) {
				return 0;
			} else {
				return size - 1;
			}
		} else {
			return Integer.valueOf(parameter);
		}
	}

}
