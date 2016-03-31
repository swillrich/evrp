package de.fuberlin.winfo.project.output;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.zip.GZIPOutputStream;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Network;

public class VisualizationServerRequest {

	public VisualizationServerRequest(Network network, URI serverURI) {
		try {
			URL url = new URL(serverURI.toString() + "/network");
			out("Open URL connection to " + url.toString());
			URLConnection connection = url.openConnection();
			connection.setDoOutput(true);
			out("Serialize, zip and send bytes via stream. This process might take serverial seconds.");
			OutputStream outputStream = connection.getOutputStream();
			GZIPOutputStream gzipOutputStream = new GZIPOutputStream(outputStream);
			XMIIO.serialize(network, gzipOutputStream);
			gzipOutputStream.close();
			connection.getInputStream();
			out("Data sent successfully");
		} catch (IOException e) {
			Log.debug(Log.VISUALIZATION_REQUEST, e.getMessage(), e);
			out(e.getMessage());
		}
	}

	private void out(String msg) {
		Log.info(Log.VISUALIZATION_REQUEST, msg);
	}

}
