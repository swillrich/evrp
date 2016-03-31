package de.fuberlin.winfo.project.visualization.web.handler;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.text.StrSubstitutor;
import org.eclipse.jetty.server.Request;

public abstract class AbstractRequest {

	public abstract void run(Request baseRequest, HttpServletResponse response) throws IOException;

	public abstract String getKey() throws IOException;

	public void log(String msg) {
		// RequestHandler.LOGGER.info(msg);
		System.out.println(msg);
	}

	public String getResourceAsString(String nameOfFile) throws IOException {
		return IOUtils.toString(getClass().getClassLoader().getResourceAsStream(nameOfFile), "UTF-8");
	}
	
	public InputStream getRessource(String fileName) throws IOException {
		return getClass().getClassLoader().getResourceAsStream(fileName);
	}

	Map<String, String> values = new HashMap<String, String>();

	public void addSubstitation(String key, String content) {
		values.put(key, content);
	}

	public String replace(String wholeContent) {
		StrSubstitutor sub = new StrSubstitutor(values, "%(", ")");
		String html = sub.replace(wholeContent);
		values.clear();
		return html;
	}
	
	public String getBaseURL(Request baseRequest) {
		return "http://" + baseRequest.getServerName() + ":" + baseRequest.getServerPort() + "/";
	}

}
