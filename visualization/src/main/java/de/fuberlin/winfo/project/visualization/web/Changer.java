package de.fuberlin.winfo.project.visualization.web;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.XMIIO;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.Network;

public class Changer {
	public static void main(String[] args) throws IOException {
		Stream<Path> list = Files.list(Paths.get(".", "target", "networks"));
		list.forEach(p -> change(p));
	}

	private static void change(Path p) {
		try {
			Network nw = XMIIO.deserialize(new FileInputStream(p.toFile()));
			long start = nw.getSolution().get(0).getHistory().getEvents().get(0).getTime();
			for (Event event : nw.getSolution().get(0).getHistory().getEvents()) {
				long time = event.getTime();
				long diff = time - start;
				event.setTime(start + (diff / 60 * 4));
				String string = event.getDescription();
				if (string != null && string.contains("OQ")) {
					string = string.substring(0, string.indexOf(", REJ"));
					event.setDescription(string);
				}
			}
			long end = (nw.getSolution().get(0).getHistory().getEvents()
					.get(nw.getSolution().get(0).getHistory().getEvents().size() - 1).getTime());
			nw.getSolution().get(0).setSolvingTime(end - start);
			printEnd(end, start);
			XMIIO.serialize(nw, new FileOutputStream(p.toFile()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void printEnd(long end, long start) {
		System.out.println("DIFF: " + ((double) (end - start) / 1000d / 60d / 60d));
	}
}
