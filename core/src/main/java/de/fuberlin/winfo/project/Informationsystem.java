package de.fuberlin.winfo.project;

import java.net.URI;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UseCase;
import de.fuberlin.winfo.project.output.VisualizationServerRequest;

/**
 * @author willrich
 *
 *         Main component which coordinates the interchange / intercommunication
 *         between all participating components.
 */
public class Informationsystem {

	private VRPInput input;

	public Informationsystem(VRPInput input) {
		Log.info(Log.SYSTEM, "Welcome to the InfoSys to solve VRP (Vehicle Routing Problems)");
		this.input = input;
	}

	public void work() throws Exception {
		NetworkProvider networkProvider = new NetworkProvider(input);
		
		for (UseCase useCase : input.getUseCases()) {
			Solution solution = networkProvider.getSolutionFactory().createSolution();
			solution.setUsecase(useCase);
			networkProvider.getNetwork().getSolution().add(solution);
		}

		for (Solution solution : networkProvider.getNetwork().getSolution()) {
			Algorithm procedure = Algorithms.get().get(input.getDesiredProcedure());
			procedure.prepareAndRun(networkProvider, solution);
		}

		if (input.getVisualizationServer() != null) {
			new VisualizationServerRequest(networkProvider.getNetwork(), URI.create(input.getVisualizationServer()));
		}

		Log.info(Log.SYSTEM, "Informationsystem finished.");
	}
}
