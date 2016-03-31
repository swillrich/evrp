package de.fuberlin.winfo.project;

import java.util.Comparator;

import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Locatable;

public class LocatableComparator implements Comparator<Locatable> {

	@Override
	public int compare(Locatable o1, Locatable o2) {
		return compareType(o1, o2);
	}

	public int compareType(Locatable o1, Locatable o2) {
		if (StaticLocatables.getTypeOf(o1).equals(StaticLocatables.getTypeOf(o2))) {
			return 0;
		} else {
			if (o1 instanceof Depot) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	public boolean isLocatableEqualByCoordinates(double lat1, double lon1, double lat2, double lon2) {
		if (lat1 - lat2 == 0) {
			if (lon1 - lon2 == 0) {
				return true;
			} else
				return false;
		} else {
			return false;
		}
	}
}
