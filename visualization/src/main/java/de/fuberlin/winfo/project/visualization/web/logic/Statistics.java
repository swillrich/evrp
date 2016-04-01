package de.fuberlin.winfo.project.visualization.web.logic;

import java.util.Iterator;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Delivery;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

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
		totalCosts += getStorageCosts(s);
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

	public double getTotalWait(Solution solution) {
		double sum = 0;
		for (Route route : solution.getRoutes()) {
			sum += getTotalWait(route);
		}
		return sum;
	}

	public double getTotalWait(Route route) {
		Iterator<UsedEdge> iterator = route.getWay().stream().filter(
				ue -> ue.getDuration().getEndInSec() - ue.getDuration().getStartInSec() > ue.getEdge().getTime())
				.iterator();
		double sum = 0;
		while (iterator.hasNext()) {
			UsedEdge ue = iterator.next();
			sum += (ue.getDuration().getEndInSec() - ue.getDuration().getStartInSec()) - ue.getEdge().getTime();
		}
		return sum;
	}

	public double getStorageCosts(Solution solution) {
		sL.reinitializeByUseCase(solution.getUsecase());
		double storageCosts = 0;
		for (Route route : solution.getRoutes()) {
			Locatable locatable = route.getWay().get(0).getEdge().getStart().getRepresentative();
			if (locatable instanceof Depot) {
				for (int i = 0; i < route.getWay().size(); i++) {
					if (route.getWay().get(i) instanceof Delivery) {

						int[] id = extractOrderInfo(((Delivery) route.getWay().get(i)).getOrder());

						if (id.length == 2) {

							int routeNumber = id[1];

							int arrival = route.getWay().get(i).getDuration().getStartInSec();
							int depature = solution.getRoutes().get(routeNumber).getWay().get(0).getDuration()
									.getStartInSec();

							int storageTimeInSec = depature - arrival;
							double storageWeightInKg = ((Delivery) route.getWay().get(i)).getOrder().getWeight();

							storageCosts += storageTimeInSec * storageWeightInKg
									* solution.getUsecase().getStorageCostsPerKgPerSec();
						}
					}
				}
			}
		}
		return storageCosts;
	}

	private int[] extractOrderInfo(Order order) {
		String code = order.getId();
		int numberOfMinus = code.length() - code.replace("-", "").length();
		if (numberOfMinus == 2) {
			int firstMinus = code.indexOf("-");
			int secondMinus = code.lastIndexOf("-");
			int firstInt = Integer.valueOf(code.substring(firstMinus + 1, secondMinus));
			int secondInt = Integer.valueOf(code.substring(secondMinus + 1, code.length()));
			return new int[] { firstInt, secondInt };
		}
		return new int[0];
	}
}
