package de.fuberlin.winfo.project;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.Iterator;
import java.util.List;

import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.Commissioning;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.input.CSV2ObjMapper;
import de.fuberlin.winfo.project.input.ZMIJson;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UseCase;
import de.fuberlin.winfo.project.output.UnusedEdgeDeleter;
import de.fuberlin.winfo.project.output.VisualizationServerRequest;

/**
 * @author willrich
 *
 *         Main component which coordinates the interchange / intercommunication
 *         between all participating components.
 */
public class Informationsystem {

	private InputData inputData;

	public Informationsystem(InputData input) {
		Log.info(Log.SYSTEM, "Welcome to the InfoSys to solve VRP (Vehicle Routing Problems)");
		this.inputData = input;
	}

	/**
	 * Starts the process
	 */
	public void work() throws Exception {
		configureLogging();

		NetworkProvider networkProvider = inflateNetwork();

		for (Solution solution : networkProvider.getNetwork().getSolution()) {
			Algorithm procedure = Algorithms.get().get(inputData.getDesiredProcedure() - 1);
			procedure.prepareAndRun(networkProvider, solution);
		}

		UnusedEdgeDeleter.removeAllEdgesBeingUnused(networkProvider.getNetwork());

		if (inputData.getVisualizationServer() != null) {
			new VisualizationServerRequest(networkProvider.getNetwork(),
					URI.create(inputData.getVisualizationServer()));
		}

		Log.info(Log.SYSTEM, "Informationsystem finished.");
	}

	public NetworkProvider inflateNetwork()
			throws FileNotFoundException, Exception, ClassNotFoundException, IOException {
		Log.info(Log.DATA_IMPORT, "Read in Distance Matrix and CSV rows");

		StopWatch watch = Utils.stopWatchGo();

		FileInputStream fileInputStream = new FileInputStream(inputData.getDistanceMatrixAsSerializedAndZippedPojo());
		List<ZMIEdge> zmiEdges = ZMIJson.getZMIEdgesFromSerializedAndZippedPojos(fileInputStream);

		CSV2ObjMapper mapper = CSV2ObjMapper.inflateByCSV(inputData);
		StaticLocatables locatables = mapper.getLocatables();
		locatables.limitBy(this.inputData.getCustomerMaximum());

		Log.info(Log.DATA_IMPORT, "Data import finished within " + watch.stop());

		NetworkProvider networkProvider = new NetworkProvider(zmiEdges, locatables);

		for (UseCase useCase : mapper.getUseCaseList()) {
			Solution solution = networkProvider.getSolutionFactory().createSolution();
			solution.setUsecase(useCase);
			networkProvider.getNetwork().getSolution().add(solution);
		}

		return networkProvider;
	}

	/*
	 * The behavior in more detail as follows
	 */

	private void configureLogging() {
		if (inputData.getLogFile() != null) {
			Log.useFileAppender(inputData.getLogFile());
			Log.debug(Log.USER_ARGS, "Log file successfully specified at " + inputData.getLogFile().getAbsolutePath(),
					null);
		}
	}
}
