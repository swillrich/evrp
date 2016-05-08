package de.fuberlin.winfo.project.algorithm;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;

import de.fuberlin.winfo.project.FormatConv;
import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.Vertex;

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
		this.solution = solution;
		restrictions = new Restrictions(this.networkProvider);
		f = getCostFunction();
		StopWatch sw = Utils.stopWatchGo();
		run(this.solution);
		Log.info(Log.ALGORITHM, "Finished within " + sw.stop() + " min");
		this.solution.setSolvingTime(sw.getAfter() - sw.getBefore());
		this.solution.setCreationTime(sw.getBefore());
		this.solution.setAlgorithmName(getName());
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
		System.out.println();
		HashSet<Vertex> set = new HashSet<Vertex>();
		for (int i = 0; i < solution.getRoutes().size(); i++) {
			Route route = solution.getRoutes().get(i);
			RouteWrapper wrapper = new RouteWrapper(route, null, null);
			List<Vertex> vertices = wrapper.getVertices();
			System.out.println("Route #" + (i + 1) + " with " + vertices.size() + " vertices: " + route.getWay()
					.stream().map(a -> a.getArc().getStart().getId() + "").collect(Collectors.joining(" ")));
			for (int j = 1; j < vertices.size(); j++) {
				Vertex vertex = vertices.get(j);
				boolean add = set.add(vertex);
				if (!add) {
					System.out.println(
							"Vertex " + vertex.getId() + " is multiple contained. Duplicate found in route " + i);
					wrapper.print();
				}
			}
		}
		System.out.println();
		System.out.println(
				set.size() + " nodes serviced with cost: " + FormatConv.withSeparator(f.compute(solution), ""));
	}

	public static Solution getCopy(Solution original) {
		EcoreUtil.Copier c = new Copier();
		Solution copy = (Solution) c.copy(original);
		c.copyReferences();
		return copy;
	}
}
