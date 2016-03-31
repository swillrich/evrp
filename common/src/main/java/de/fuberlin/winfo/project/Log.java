package de.fuberlin.winfo.project;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

public class Log {

	public static final String USER_ARGS = "User Args";
	public static final String CSV_PARSING = "CSV Parsing";
	public static final String ALGORITHM_DETAIL_LOG = "ALGORITHM DETAIL LOG";
	public static final String SYSTEM = "System";
	public static final String WS_MATRIX_REQUEST = "WS Matrix Request";
	public static final String ALGORITHM = "Algorithm";
	public static final String ALGORITHM_PROVIDER = "Algorithm Provider";
	public static final String DATA_IMPORT = "Data Import";
	public static final String ALGORITHM_RESULT = "VRP Solver Result";
	public static final String NETWORK_PROVIDER = "Network Provider";
	public static final String VISUALIZATION = "Visualization";
	public static final String VISUALIZATION_REQUEST = "Visualization Request";

	private static String currentLogStage;
	private static FileAppender fileAppender;
	private static ConsoleAppender consoleAppender;

	static {
		useConsoleAppender();
	}

	public static void useFileAppender() {
		Logger.getRootLogger().removeAppender(fileAppender);
		fileAppender = new FileAppender();
		fileAppender.setName("file");
		PatternLayout layout = new PatternLayout("%d{yyyy-MM-dd HH:mm:ss} %-5p %c{1}: - %m%n");
		fileAppender.setLayout(layout);
		fileAppender.setAppend(true);
		File file = new File("target");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		fileAppender.setFile(file.getAbsolutePath());
		fileAppender.activateOptions();
		fileAppender.setThreshold(Level.DEBUG);
		Logger.getRootLogger().addAppender(fileAppender);
	}

	public static void useConsoleAppender() {
		consoleAppender = new ConsoleAppender(new PatternLayout("%c{1}: %m%n"));
		consoleAppender.setTarget("System.out");
		consoleAppender.setThreshold(Level.INFO);
		Logger.getRootLogger().addAppender(consoleAppender);
	}

	public static void setLogStage(String logStage) {
		if (!logStage.equals(currentLogStage)) {
			Log.currentLogStage = logStage;
			System.out.println();
		}
	}

	public static void info(String src, String msg) {
		setLogStage(src);
		Logger logger = Logger.getLogger(src);
		logger.info(msg);
	}

	public static void debug(String src, String msg, Exception e) {
		// setLogStage(src);
		Logger logger = Logger.getLogger(src);
		if (e == null) {
			logger.debug(msg);
		} else {
			logger.debug(msg, e);
		}
	}

}
