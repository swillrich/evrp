package de.fuberlin.winfo.project.visualization.web.start;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Options;

import de.fuberlin.winfo.project.visualization.web.VisualizationServer;

public class CLIStart {

	public static void main(String[] args) {
		try {
			Options options = new Options();
			options.addOption("port", true, "The port the Visualization Server uses");
			options.addOption("solution", true, "The Solution file");

			CommandLineParser parser = new BasicParser();
			CommandLine cl = parser.parse(options, args);
			int port = 8080;
			String file = null;
			if (cl.hasOption("port")) {
				port = Integer.valueOf(cl.getOptionValue("port"));
			}

			if (cl.hasOption("solution")) {
				file = cl.getOptionValue("solution");
			}

			new VisualizationServer(port).start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
