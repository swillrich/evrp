package de.fuberlin.winfo.project.input.impl.sven;

import java.io.File;
import java.nio.file.Paths;

public class InputFilesBundles {
	public static String folder = "../../vrpdata";
	public static File timeWindows = Paths.get(folder, "TimeWindows2").toFile();
	public static File vehicleFile = Paths.get(folder, "vehicles.csv").toFile();
	public static File customerFile = Paths.get(folder, "customer.csv").toFile();
	public static File depotFile = Paths.get(folder, "depot.csv").toFile();
	public static File useCaseFile = Paths.get(folder, "usecase.csv").toFile();
	public static File zippedAndSerializedDM = Paths.get(folder, "zmiedges.ser.zip").toFile();
}
