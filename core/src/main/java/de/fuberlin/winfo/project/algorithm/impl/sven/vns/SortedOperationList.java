package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class SortedOperationList extends ArrayList<NeighborhoodOperation> {
	private int maxSize;
	private CostFunction f;
	private Comparator<NeighborhoodOperation> comparator = new Comparator<NeighborhoodOperation>() {
		@Override
		public int compare(NeighborhoodOperation o1, NeighborhoodOperation o2) {
			return f.compare(o1.getResult(), o2.getResult());
		}
	};

	public SortedOperationList(int size, CostFunction f) {
		this.maxSize = size;
		this.f = f;
	}

	public SortedOperationList(CostFunction f) {
		this.maxSize = -1;
		this.f = f;
	}

	@Override
	public boolean add(NeighborhoodOperation e) {
		boolean add = super.add(e);
		Collections.sort(this, comparator);
		while (maxSize < size() && maxSize > 0) {
			remove(size() - 1);
		}
		return add;
	}

	@Override
	public boolean addAll(Collection<? extends NeighborhoodOperation> c) {
		for (NeighborhoodOperation p : c) {
			add(p);
		}
		return true;
	}
}
