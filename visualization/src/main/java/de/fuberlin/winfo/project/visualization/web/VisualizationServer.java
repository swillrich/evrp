package de.fuberlin.winfo.project.visualization.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jetty.server.Server;

import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.visualization.web.handler.RequestHandler;

public class VisualizationServer extends Server {

	public static List<Network> networkCache = new ArrayList<Network>();
	public static Map<Network, File> map = new HashMap<Network, File>();
	private static Path nwDirectory = Paths.get("..", "networks");

	public VisualizationServer(int port) throws Exception {
		super(port);
		setAttribute("org.eclipse.jetty.server.Request.maxFormContentSize", -1);
		setHandler(new RequestHandler());
	}

	public static Path getNwDirectory() throws IOException {
		File nwDirectoryAsFile = nwDirectory.toFile();
		if (!nwDirectoryAsFile.exists()) {
			nwDirectoryAsFile.mkdirs();
		} else {
			if (!nwDirectoryAsFile.isDirectory()) {
				throw new IOException("The given directory " + nwDirectoryAsFile.toString() + " is a file");
			}
		}
		return nwDirectory;
	}

	public void setNWDirectory(String string) throws IOException {
		nwDirectory = new File(string).toPath();
		readInPersistedNetworks();
	}

	public static void readInPersistedNetworks() throws IOException {
		map.clear();
		File[] list = getNwDirectory().toFile().listFiles(new FilenameFilter() {

			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".network");
			}
		});
		for (File s : list) {
			FileInputStream stream = new FileInputStream(s);
			Network network = XMIIO.deserialize(stream);
			map.put(network, s);
			System.out.println("deserialize network: " + s.getName());
			networkCache.add(network);
		}
	}

	public static void removeNetwork(int id) throws IOException {
		Network network = networkCache.get(id);
		File file = map.get(network);
		if (file != null) {
			map.remove(network);
			file.delete();
		} else {
			System.out.println("Cannot delete, file is null");
		}
		networkCache.remove(id);
	}

	public static void save(int id) throws IOException {
		Network network = VisualizationServer.networkCache.get(id);
		Path path = getNwDirectory();
		File file = Paths
				.get(path.toString(), network.getNodes().size() + "-" + (new Date().getTime() / 1000) + ".network")
				.toFile();
		FileOutputStream stream = new FileOutputStream(file);
		XMIIO.serialize(network, stream);
		stream.close();
		map.put(network, file);
	}
}