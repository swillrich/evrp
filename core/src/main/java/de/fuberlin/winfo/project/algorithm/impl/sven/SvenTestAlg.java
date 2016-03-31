package de.fuberlin.winfo.project.algorithm.impl.sven;

import java.util.List;

import de.fuberlin.winfo.project.algorithm.AlgHelper;
import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.ExtendedRoute;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class SvenTestAlg extends Algorithm {

	@Override
	public String getName() {
		return "Sven Test Alg";
	}

	@Override
	public void run(Solution solution) throws Exception {
		List<Locatable> customer = networkProvider.getLocatables().getCustomer();
		ExtendedRoute route = AlgHelper.getRouteHelper(this, solution.getUsecase().getVehicles().get(0),
				networkProvider.getNodes()[0]);
		for (Locatable locatable : customer) {
			Customer c = (Customer) locatable;
			for (Order order : c.getOwnedOrders()) {
				route.addDelivery(order);
			}
		}
		solution.getRoutes().add(route.getRoute());
	}
}
