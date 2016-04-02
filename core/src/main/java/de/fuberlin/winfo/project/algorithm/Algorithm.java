package de.fuberlin.winfo.project.algorithm;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.StopWatch;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

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

	public void prepareAndRun(NetworkProvider networkProvider, Solution solution) throws Exception {
		Log.info(Log.ALGORITHM,
				"*" + this.getName() + "* is selected and will run for UseCase " + solution.getUsecase().getName());
		this.networkProvider = networkProvider;
		restrictions = new Restrictions(this.networkProvider);
		this.networkProvider.getLocatables().reinitializeByUseCase(solution.getUsecase());
		this.solution = solution;
		runAlgorithm();
	}

	private void runAlgorithm() throws Exception {
		solution.setProcedure(getName());
		StopWatch sw = Utils.stopWatchGo();
		run(solution);
		Log.info(Log.ALGORITHM, "Finished within " + sw.stop() + " min");
		Log.debug(Log.ALGORITHM, "Calculate statistics such as total distance and total time", null);
		calculateTotalValuesForEachRoute();
	}

	/**
	 * All the values which are stored in the model and could be calculated,
	 * will be calculated after finishing this method. Especially the total
	 * distance and total time values are getting calculated.
	 * 
	 * @throws Exception
	 */
	private void calculateTotalValuesForEachRoute() throws Exception {
		long totalSolutionDistance = 0;
		int totalSolutionTime = 0;
		for (Route route : solution.getRoutes()) {
			long totalRouteDistance = 0;
			int totalRouteTime = route.getWay().get(route.getWay().size() - 1).getDuration().getEndInSec()
					- route.getWay().get(0).getDuration().getStartInSec();
			for (UsedEdge usedEdge : route.getWay()) {
				totalRouteDistance += usedEdge.getEdge().getDistance();
				// totalRouteTime += usedEdge.getDuration().getEndInSec() -
				// usedEdge.getDuration().getStartInSec();
				// totalRouteTime +=
				// usedEdge.getEdge().getEnd().getRepresentative().getServiceTimeInSec();
			}
			route.setTotalDistanceInM(totalRouteDistance);
			totalSolutionDistance += totalRouteDistance;
			route.setTotalTimeInSec(totalRouteTime);
			totalSolutionTime += totalRouteTime;
		}
		solution.setTotalDistance(totalSolutionDistance);
		solution.setTotalTime(totalSolutionTime);
	}

	public Solution getSolution() {
		return solution;
	}

	public ExtRoute buildRoute(Vehicle vehicle, Node depot) {
		return new ExtRoute(this, vehicle, depot);
	}

	public Restrictions getRestrictions() {
		return restrictions;
	}
}
