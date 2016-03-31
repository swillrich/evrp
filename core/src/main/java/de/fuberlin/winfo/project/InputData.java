package de.fuberlin.winfo.project;

import java.io.File;

public interface InputData {
	public File getCustomerFile();
	public File getVehicleFile();
	public File getDepotFile();
	public File getDistanceMatrixAsSerializedAndZippedPojo() throws Exception;
	public int getDesiredProcedure();
	public String getVisualizationServer();
	public File getLogFile();
	public File getUseCaseFile();
	public int getCustomerMaximum();
}
