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
import de.fuberlin.winfo.project.model.network.Solution;

public class Changer {
	public static void main(String[] args) throws IOException {
		Stream<Path> list = Files.list(Paths.get(".", "solutions"));
		list.forEach(p -> change(p));
	}

	private static void change(Path p) {
		try {
			Network nw = XMIIO.deserialize(new FileInputStream(p.toFile()));
			Solution solution = nw.getSolution().get(0);
			solution.setCreationTime(solution.getHistory().getEvents().get(0).getTime());
			long start =solution.getHistory().getEvents().get(0).getTime();
			for (Event event : solution.getHistory().getEvents()) {
				long time = event.getTime();
				long diff = time - start;
//				event.setTime(start + (diff / 60 * 4));
				String string = event.getDescription();
				if (string != null && string.contains("REJ")) {
					string = string.substring(0, string.indexOf(", REJ"));
					event.setDescription(string);
				}
			}
			long end = (solution.getHistory().getEvents()
					.get(solution.getHistory().getEvents().size() - 1).getTime());
			solution.setSolvingTime(end - start);
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
