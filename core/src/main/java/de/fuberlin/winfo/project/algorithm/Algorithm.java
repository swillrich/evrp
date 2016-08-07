package de.fuberlin.winfo.project.algorithm;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.ConsoleOutput;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Event;
import de.fuberlin.winfo.project.model.network.EventType;
import de.fuberlin.winfo.project.model.network.History;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.Vertex;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

/**
 * @author willrich
 *
 *         This abstract class is the super class for all specific algorithm
 *         implementation, e.g. several heuristics. <br>
 *         Each specific class has to implement the run(...) method, in which
 *         the core algorithm takes place.
 */
public abstract class Algorithm {

	protected NetworkProvider networkProvider;
	protected Solution solution;
	protected Restrictions restrictions;
	protected CostFunction f;
	private History history;
	public ConsoleOutput output = new ConsoleOutput();

	public abstract String getName();

	public abstract CostFunction getCostFunction();

	public abstract void run(Solution solution) throws Exception;

	private void replaceSolution(Solution update) {
		int indexOf = networkProvider.getNetwork().getSolution().indexOf(update);
		networkProvider.getNetwork().getSolution().remove(indexOf);
		networkProvider.getNetwork().getSolution().add(indexOf, this.solution);
	}

	public void prepareAndRun(NetworkProvider networkProvider, Solution solution) throws Exception {
		Log.info(Log.ALGORITHM,
				"*" + this.getName() + "* is selected and will run for UseCase " + solution.getUsecase().getName());
		this.networkProvider = networkProvider;
		NetworkFactoryImpl networkFactoryImpl = new NetworkFactoryImpl();
		this.history = networkFactoryImpl.createHistory();
		this.solution = solution;
		restrictions = new Restrictions(this.networkProvider);
		f = getCostFunction();
		StopWatch sw = Utils.stopWatchGo();
		run(this.solution);
		Log.info(Log.ALGORITHM, "Finished within " + sw.stop() + " min");
		this.solution.setSolvingTime(sw.getAfter() - sw.getBefore());
		this.solution.setCreationTime(sw.getBefore());
		this.solution.setAlgorithmName(getName());
		this.solution.setHistory(history);
		replaceSolution(solution);
		printResult();
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

	public RouteWrapper buildRoute(Vehicle vehicle, Vertex depot) {
		return RouteWrapper.instantiateByVehicle(vehicle, depot, networkProvider.getArcs());
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}

	private void printResult() {
		RouteWrapper.printSolution(solution);
		System.out.println();
		System.out.println("vertices serviced with cost: " + FormatConv.withSeparator(f.compute(solution), ""));
	}

	public static Solution getCopy(Solution original) {
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(original);
		c.copyReferences();
		return copy;
	}

	public void addEvent(EventType type, Solution s, String... desc) {
		NetworkFactoryImpl networkFactoryImpl = new NetworkFactoryImpl();
		if (history == null) {
			history = networkFactoryImpl.createHistory();
		}
		Event event = networkFactoryImpl.createEvent();
		event.setType(type);
		event.setTime(new Date().getTime());
		event.setValue(f.compute(s));
		if (desc != null && desc.length > 0) {
			event.setDescription(Arrays.stream(desc).collect(Collectors.joining(";")));
		}
		history.getEvents().add(event);
		output.change(history);
		output.writeTo(history, s, f);
	}
}
