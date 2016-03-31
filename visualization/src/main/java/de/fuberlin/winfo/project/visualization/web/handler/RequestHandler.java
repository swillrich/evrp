package de.fuberlin.winfo.project.visualization.web.handler;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import de.fuberlin.winfo.project.visualization.web.handler.impl.ASCIIRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.AddNetworkRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.FileProviderRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.JSONRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.ListRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.MapRequest;
import de.fuberlin.winfo.project.visualization.web.handler.impl.Nodes;
import de.fuberlin.winfo.project.visualization.web.handler.impl.TestRequest;

public class RequestHandler extends AbstractHandler {
	public static Logger LOGGER = Logger.getLogger("RequestHandler");
	AbstractRequest[] col = new AbstractRequest[] { new AddNetworkRequest(), new TestRequest(), new JSONRequest(),
			new MapRequest(), new ListRequest(), new Nodes(), new ASCIIRequest(), new FileProviderRequest() };

	@Override
	public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String dest = baseRequest.getRequestURI().substring(1, baseRequest.getRequestURI().length());
		System.out.println();
		System.out.println(">> NEW REQUEST");
		baseRequest.setHandled(true);
		response.setContentType("text/html;charset=utf-8");
		for (AbstractRequest abstractRequest : col) {
			if (dest.startsWith(abstractRequest.getKey())) {
				String simpleName = abstractRequest.getClass().getSimpleName();
				System.out.println("call class " + simpleName);
				abstractRequest.run(baseRequest, response);
			}
		}
	}
}
