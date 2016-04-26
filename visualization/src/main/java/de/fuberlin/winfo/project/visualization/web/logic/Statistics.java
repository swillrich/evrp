package de.fuberlin.winfo.project.visualization.web.logic;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;

public class Statistics {
	private Network network;

	private Locatables sL = null;

	public Statistics(Network network) {
		this.network = network;
		sL = Locatables.inflateBy(network);
	}

	public double getAverageDistance(Solution sol) {
		return sol.getTotalDistance() / sol.getRoutes().size();
	}

	public Network getNetwork() {
		return network;
	}

	public double getTotalCosts(Solution s) {
		double totalCosts = 0;
		totalCosts += getPersonnalCosts(s);
		totalCosts += getMaterialCosts(s);
		return totalCosts;
	}

	public double getPersonnalCosts(Route route) {
		return route.getTotalTimeInSec() / 60 / 60 * route.getVehicle().getDriverCostsPerHour();
	}

	public double getMaterialCosts(Route route) {
		return route.getVehicle().getOperatingCostsPerMeter() * route.getTotalDistanceInM();
	}

	public double getMaterialCosts(Solution s) {
		double totalCosts = 0;
		for (Route route : s.getRoutes()) {
			totalCosts += getMaterialCosts(route);
		}
		return totalCosts;
	}

	public double getPersonnalCosts(Solution s) {
		double totalCosts = 0;
		for (Route route : s.getRoutes()) {
			totalCosts += getPersonnalCosts(route);
		}
		return totalCosts;
	}
}
