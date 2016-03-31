package de.fuberlin.winfo.project.visualization.web.handler;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

public class Test extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		/*
		 * Do not forget to add this class to RequestHandler collection
		 */
		response.getWriter().write("hello world<br>");
		response.getWriter().write("you come from: " + getBaseURL(baseRequest));
		response.getWriter().write("name is:" + baseRequest.getParameter("name"));
	}

	@Override
	public String getKey() throws IOException {
		return "test";
	}

}
