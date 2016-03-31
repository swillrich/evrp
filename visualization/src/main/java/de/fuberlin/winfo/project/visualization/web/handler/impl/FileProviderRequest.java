package de.fuberlin.winfo.project.visualization.web.handler.impl;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;

import de.fuberlin.winfo.project.visualization.web.handler.AbstractRequest;

public class FileProviderRequest extends AbstractRequest {

	@Override
	public void run(Request baseRequest, HttpServletResponse response) throws IOException {
		String name = baseRequest.getPathInfo().replace("/" + getKey() + "/", "");
		InputStream inputStream = getRessource(name);
		response.setContentType("application/octet-stream");
		byte[] buffer = new byte[1024];
		for (int bytesRead = inputStream.read(buffer); bytesRead != -1; bytesRead = inputStream.read(buffer)) {
			response.getOutputStream().write(buffer);
		}
	}

	@Override
	public String getKey() throws IOException {
		return "files";
	}

}
