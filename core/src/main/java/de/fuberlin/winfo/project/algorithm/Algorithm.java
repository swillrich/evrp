package de.fuberlin.winfo.project.algorithm;

import java.util.Date;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.GlobalSearch;
import de.fuberlin.winfo.project.model.network.LocalSearch;
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

	/**
	 * Provides the name of the algorithm
	 */
	public abstract String getName();

	protected NetworkProvider networkProvider;

	/**
	 * The solution on which this algorithm operates.
	 */
	private Solution solution;
	protected Restrictions restrictions;

	/**
	 * The run method performs the algorithm being implemented.
	 * 
	 * @return
	 * 
	 */
	public abstract void run(Solution solution) throws Exception;

	public void updateSolution(Solution update) {
		int indexOf = networkProvider.getNetwork().getSolution().indexOf(this.solution);
		long creationTime = 0;
		long solvingTime = creationTime;
		if (indexOf > -1) {
			creationTime = networkProvider.getNetwork().getSolution().get(indexOf).getCreationTime();
			solvingTime = networkProvider.getNetwork().getSolution().get(indexOf).getSolvingTime();
			networkProvider.getNetwork().getSolution().remove(indexOf);
			networkProvider.getNetwork().getSolution().add(indexOf, update);
		} else {
			networkProvider.getNetwork().getSolution().add(update);
		}
		if (update.getHistory() != null) {
			EList<GlobalSearch> searches = update.getHistory().getSearches();
			if (!searches.isEmpty()) {
				EList<LocalSearch> lastLS = searches.get(searches.size() - 1).getLocalSearches();
				if (!lastLS.isEmpty()) {
					solvingTime += lastLS.get(lastLS.size() - 1).getTime();
				}
			}
		}
		update.setCreationTime(creationTime);
		update.setSolvingTime(solvingTime + creationTime);
		this.solution = update;
	}

	public void prepareAndRun(NetworkProvider networkProvider, Solution solution) throws Exception {
		Log.info(Log.ALGORITHM,
				"*" + this.getName() + "* is selected and will run for UseCase " + solution.getUsecase().getName());
		this.networkProvider = networkProvider;
		restrictions = new Restrictions(this.networkProvider);
		updateSolution(solution);
		runAlgorithm();
	}

	private void runAlgorithm() throws Exception {
		solution.setAlgorithmName(getName());
		StopWatch sw = Utils.stopWatchGo();
		solution.setCreationTime(new Date().getTime());
		run(solution);
		Log.info(Log.ALGORITHM, "Finished within " + sw.stop() + " min");
		solution.setSolvingTime(sw.getAfter() - sw.getBefore());
	}

	public Solution getSolution() {
		return solution;
	}

	public RouteWrapper buildRoute(Vehicle vehicle, Vertex depot) {
		return RouteWrapper.instantiateByVehicle(vehicle, depot, networkProvider.getArcs());
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}
}
