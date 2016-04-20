package de.fuberlin.winfo.project;

import java.net.URI;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.Algorithms;
import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.SolutionFactory;
import de.fuberlin.winfo.project.model.network.solution.UseCase;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;
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
		Log.info(Log.SYSTEM, "Welcome to the InfoSys to solve VRP (Vehicle Routing Problems)");
		NetworkProvider networkProvider = new NetworkProvider(input);

		input.getLocatables().getCustomer().stream().map(l -> ((Customer) l))
				.forEach(c -> input.getLocatables().getMainDepot().getDeliveries().addAll(c.getOrders()));

		SolutionFactory solutionFactory = new SolutionFactoryImpl();
		
		for (UseCase useCase : input.getUseCases()) {
			Solution solution = solutionFactory.createSolution();
			solution.setUsecase(useCase);
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

		Log.info(Log.SYSTEM, "Informationsystem finished.");
	}
}
