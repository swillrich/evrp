package de.fuberlin.winfo.project;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.solution.UseCase;

/**
 * @author willrich
 * 
 *         Locatables which do not change, but being static. Usecase-specific
 *         Transhipment Points do change dyniamically, therefore THIS list do
 *         not contain this elements directly. Customer nested Transhipment
 *         Points.
 */
public class StaticLocatables extends ArrayList<Locatable> {

	public void reinitializeByUseCase(UseCase useCase) {
		getCustomer().stream().map(l -> ((Customer) l)).forEachOrdered(c -> c.setHasTranshipmentPoint(null));
		// keep main depot, remove all the other usecase-specific stuff
		removeIf(l -> l instanceof Depot && l.eContainer() instanceof UseCase);
		assignNew(useCase.getTranshipmentPoints());
	}

	public List<Node> getTranshipmentPointsAsNodes() {
		return getCustomer(true);
	}

	public List<Node> getCustomerWithoutTranshipmentAsNodes() {
		return getCustomer(false);
	}

	private List<Node> getCustomer(boolean withTP) {
		return stream().filter(l -> l instanceof Customer).map(l -> (Customer) l)
				.filter(c -> (c.getHasTranshipmentPoint() == null) != withTP).map(c -> (Node) c.eContainer())
				.collect(Collectors.toList());
	}

	public Node getMainDepotAsNode() {
		return (Node) getMainDepot().eContainer();
	}

	public Depot getMainDepot() {
		return (Depot) stream().filter(l -> l instanceof Depot && !(l.eContainer() instanceof UseCase)).iterator()
				.next();
	}

	public List<Locatable> getCustomer() {
		return stream().filter(l -> l instanceof Customer).collect(Collectors.toList());
	}

	public List<Locatable> getTranshipmentPoints() {
		return stream().filter(l -> l instanceof Customer).map(l -> (Customer) l)
				.filter(c -> c.getHasTranshipmentPoint() != null).collect(Collectors.toList());
	}

	public static <T extends Locatable> Class<T> getTypeOf(Locatable locatable) {
		if (Customer.class.isAssignableFrom(locatable.getClass())) {
			return (Class<T>) Customer.class;
		} else if (Depot.class.isAssignableFrom(locatable.getClass())) {
			return (Class<T>) Depot.class;
		}
		return null;
	}

	public Iterator<Locatable> findLocatable(double lat, double lon, Class<? extends Locatable> clazz) {
		try {
			if (clazz == null) {
				return stream().filter(l -> l.getLatitude() == lat && l.getLongitude() == lon).iterator();
			} else {
				return stream().filter(l -> getTypeOf(l) == clazz && l.getLatitude() == lat && l.getLongitude() == lon)
						.iterator();
			}

		} catch (NoSuchElementException e) {
			return null;
		}
	}

	public Locatable addNewStaticLocatable(Locatable l) {
		boolean contains = contains(l);
		if (contains) {
			return findLocatable(l.getLatitude(), l.getLongitude(), getTypeOf(l)).next();
		} else {
			super.add(l);
			sort(new LocatableComparator());
			return l;
		}
	}

	public StaticLocatables sublist(int from, int to) {
		StaticLocatables locatables = new StaticLocatables();
		locatables.addAll(toList());
		return locatables;
	}

	public void limitBy(int n) {
		if (n == 0 || n == -1) {
			return;
		}
		List<Locatable> customerList = getCustomer();
		List<Locatable> keep = customerList.subList(0, n);
		removeIf(l -> l instanceof Customer && !keep.contains(l));
		sort(new LocatableComparator());
	}

	public List<Locatable> toList() {
		ArrayList<Locatable> list = new ArrayList<Locatable>(this);
		list.sort(new LocatableComparator());
		return list;
	}

	public void assignNew(List<? extends Locatable> list) {
		for (Locatable newL : list) {
			Iterator<Locatable> iterator = findLocatable(newL.getLatitude(), newL.getLongitude(), null);
			if (iterator.hasNext()) {
				Locatable next = iterator.next();
				if (next instanceof Customer && newL instanceof Depot) {
					Customer c = (Customer) next;
					c.setHasTranshipmentPoint((Depot) newL);
				}
			}
		}
		sort(new LocatableComparator());
	}

	public void print() {
		System.out.println("OVERVIEW CONTENT");
		System.out.println("Customer (all): " + getCustomer().size());
		System.out.println("Customer without TP: " + getCustomerWithoutTranshipmentAsNodes().size());
		System.out.println("Customer with TP: " + getTranshipmentPoints().size());
		System.out.println();
	}

	public void printDetail() {
		stream().forEachOrdered(
				l -> System.out.printf("%-20s%-20s%-20s%-20s%n", l.getClass().getSimpleName(), l.getLatitude(),
						l.getLongitude(), l instanceof Customer ? ((Customer) l).getOwnedOrders().size() : "non-customer"));
	}

	@Override
	public boolean add(Locatable e) {
		try {
			throw new Exception("use addStaticLocatable instead");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Locatable> c) {
		try {
			throw new Exception("use assignNew instead");
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return false;
	}
	
	public static StaticLocatables inflateBy(Network network) {
		StaticLocatables locatables = new StaticLocatables();
		network.getNodes().forEach(n -> locatables.addNewStaticLocatable(n.getRepresentative()));
		return locatables;
	}
}
