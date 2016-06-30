package de.fuberlin.winfo.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Order;

/**
 * @author willrich
 * 
 *         Locatables which do not change, but being static. Usecase-specific
 *         Transhipment Points do change dyniamically, therefore THIS list do
 *         not contain this elements directly. Customer nested Transhipment
 *         Points.
 */
public class Locatables extends ArrayList<Locatable> {

	public List<Order> getAllOrders() {
		List<Order> orders = new ArrayList<Order>();
		stream().filter(l -> l instanceof Customer).map(l -> (Customer) l)
				.forEachOrdered(c -> orders.addAll(c.getOrders()));
		return orders;
	}

	public List<Customer> getCustomer() {
		return stream().filter(l -> l instanceof Customer).map(l -> (Customer) l).collect(Collectors.toList());
	}

	public Depot getDepot() {
		return (Depot) stream().filter(l -> l instanceof Depot).iterator().next();
	}

	public static <T extends Locatable> Class<T> getTypeOf(Locatable locatable) {
		if (Customer.class.isAssignableFrom(locatable.getClass())) {
			return (Class<T>) Customer.class;
		} else if (Depot.class.isAssignableFrom(locatable.getClass())) {
			return (Class<T>) Depot.class;
		}
		return null;
	}

	public Iterator<Locatable> findLocatable(double lat, double lon) {
		return stream().filter(l -> l.getLatitude() == lat && l.getLongitude() == lon).iterator();
	}

	public Locatable addNewLocatable(Locatable l) {
		boolean contains = contains(l);
		if (contains) {
			return findLocatable(l.getLatitude(), l.getLongitude()).next();
		} else {
			super.add(l);
			sort(new LocatableComparator());
			return l;
		}
	}

	public Locatables sublist(int from, int to) {
		Locatables locatables = new Locatables();
		List<Locatable> list = toList().subList(from, to);
		locatables.addAll(list);
		return locatables;
	}

	public List<Locatable> toList() {
		ArrayList<Locatable> list = new ArrayList<Locatable>(this);
		list.sort(new LocatableComparator());
		return list;
	}

	// @Override
	// public boolean add(Locatable e) {
	// try {
	// throw new Exception("use addStaticLocatable instead");
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// }
	// return false;
	// }
	//
	// @Override
	// public boolean addAll(Collection<? extends Locatable> c) {
	// try {
	// throw new Exception("use addNewLocatable instead");
	// } catch (Exception e1) {
	// e1.printStackTrace();
	// }
	// return false;
	// }

	public static Locatables inflateBy(Network network) {
		Locatables locatables = new Locatables();
		network.getVertices().stream().filter(v -> v instanceof Locatable).map(v -> (Locatable) v)
				.forEach(v -> locatables.addNewLocatable(v));
		network.getLocatables().forEach(l -> locatables.addNewLocatable(l));
		return locatables;
	}
}
