package de.fuberlin.winfo.project.input.zmiwebservice;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.List;

import org.joda.time.format.DateTimeFormat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.input.ZMIJson;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;

public abstract class AbstractZMIWebserviceRequest {

	private static final String DOMAIN_WITH_PORT = "http://www.z-m-i.info:8890/";
	private String ZMI_APPLICATION_KEY = "NtM7Ev5t1q2AY25M6ocrmF780QyK5V1w";

	private JsonElement jsonElement;
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private List<ZMIEdge> zmiEdges;
	private File outputFile = new File("dm.json.tmp");

	public File getOutputFile() {
		return outputFile;
	}

	public void setOutputFile(File outputFile) {
		this.outputFile = outputFile;
	}

	public AbstractZMIWebserviceRequest() {
		Log.info(Log.WS_MATRIX_REQUEST, "Initialize ZMI WS request for receipt of a JSON object");
	}

	protected String getZMI_APPLICATION_KEY() {
		return ZMI_APPLICATION_KEY;
	}

	public abstract String getPath();

	public abstract String getParameter();

	public abstract String getCustomizedMessage();

	public abstract String getRequestMethod();

	public AbstractZMIWebserviceRequest execute() throws MalformedURLException, IOException {
		if (getCustomizedMessage() != null) {
			Log.info(Log.WS_MATRIX_REQUEST, getCustomizedMessage());
		}
		Log.info(Log.WS_MATRIX_REQUEST, "Execute " + getRequestMethod() + " request ...");
		Log.debug(Log.WS_MATRIX_REQUEST, buildURL().toString(), null);
		long before = new Date().getTime();

		byte[] data = getParameter().getBytes(StandardCharsets.UTF_8);
		HttpURLConnection conn = (HttpURLConnection) buildURL().openConnection();
		Log.info(Log.WS_MATRIX_REQUEST, "Use URL:" + buildURL());
		if (getRequestMethod().equalsIgnoreCase("GET")) {
			conn.setRequestMethod(getRequestMethod());
		} else if (getRequestMethod().equalsIgnoreCase("POST")) {
			conn.setDoOutput(true);
			conn.setRequestMethod(getRequestMethod());
			try (DataOutputStream wr = new DataOutputStream(conn.getOutputStream())) {
				wr.write(data);
			}
		}

		// StringBuilder b = new StringBuilder();
		// Reader in = new BufferedReader(new
		// InputStreamReader(conn.getInputStream(), "UTF-8"));
		// for (int c = in.read(); c != -1; c = in.read()) {
		// b.append((char) c);
		// }

		FileOutputStream fileOutputStream = new FileOutputStream(outputFile);
		Reader in = new InputStreamReader(conn.getInputStream(), "UTF-8");
		for (int c = in.read(); c != -1; c = in.read()) {
			fileOutputStream.write(c);
		}
		fileOutputStream.close();

		FileInputStream fileInputStream = new FileInputStream(outputFile);
		this.zmiEdges = ZMIJson.getZMIEdgesFromJSONInputStream(fileInputStream, null);

		long after = new Date().getTime();
		Log.info(Log.WS_MATRIX_REQUEST,
				"Response received within " + DateTimeFormat.forPattern("mm:ss.SSS").print(after - before) + " min");
		String prettyLookingJson = getPrettyLookingJson();
		Log.debug(Log.WS_MATRIX_REQUEST, prettyLookingJson, null);
		return this;
	}

	public URL buildURL() throws MalformedURLException {
		if (getRequestMethod().equalsIgnoreCase("GET")) {
			URL url = new URL(DOMAIN_WITH_PORT + "/" + getPath() + getParameter());
			return url;
		} else {
			URL url = new URL(DOMAIN_WITH_PORT + "/" + getPath());
			return url;
		}
	}

	public String getPrettyLookingJson() {
		return gson.toJson(jsonElement);
	}

	public List<ZMIEdge> getZmiEdges() {
		return zmiEdges;
	}
}
