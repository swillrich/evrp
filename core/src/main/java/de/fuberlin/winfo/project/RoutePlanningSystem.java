package de.fuberlin.winfo.project;

import java.net.URI;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UseCase;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.output.VisualizationServerRequest;

/**
 * @author willrich
 *
 *         Main component which coordinates the interchange / intercommunication
 *         between all participating components.
 */
public class RoutePlanningSystem {

	private VRPInput input;

	public RoutePlanningSystem(VRPInput input) {
		this.input = input;
	}

	public void work() throws Exception {
		Log.info(Log.SYSTEM, "Welcome to the RPS to solve VRP");
		NetworkProvider networkProvider = new NetworkProvider(input);

		NetworkFactory networkfactory = new NetworkFactoryImpl();

		for (UseCase useCase : input.getUseCases()) {
			Solution solution = networkfactory.createSolution();
			solution.setUsecase(useCase);
			solution.setAlgorithmName(input.getDescription());
			networkProvider.getNetwork().getSolution().add(solution);
		}

		for (int i = 0; i < networkProvider.getNetwork().getSolution().size(); i++) {
			Solution solution = networkProvider.getNetwork().getSolution().get(i);
			Algorithm procedure = Algorithms.get().get(input.getDesiredProcedure());
			procedure.prepareAndRun(networkProvider, solution);
		}

		if (input.getVisualizationServer() != null) {
			new VisualizationServerRequest(networkProvider.getNetwork(), URI.create(input.getVisualizationServer()));
		}

		Log.info(Log.SYSTEM, "System finished.");
	}
}
