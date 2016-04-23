package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

@SuppressWarnings("serial")
public class SortedOperationList extends ArrayList<Operation> {
	private int maxSize;
	private CostFunction f;
	private Comparator<Operation> comparator = new Comparator<Operation>() {
		@Override
		public int compare(Operation o1, Operation o2) {
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
	public boolean add(Operation e) {
		boolean add = super.add(e);
		Collections.sort(this, comparator);
		while (maxSize < size() && maxSize > 0) {
			remove(size() - 1);
		}
		return add;
	}

	@Override
	public boolean addAll(Collection<? extends Operation> c) {
		for (Operation p : c) {
			add(p);
		}
		return true;
	}
}
