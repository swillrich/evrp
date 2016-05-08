package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging.VNSMonitor;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.restriction.Restrictions;
import de.fuberlin.winfo.project.model.network.Solution;

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
	private Solution initialSolution;
	private VNSMonitor history;

	public SortedOperationList(int size, CostFunction f, VNSMonitor history) {
		this.maxSize = size;
		this.f = f;
		this.history = history;
	}

	@Override
	public boolean add(NeighborhoodOperation e) {
		if (initialSolution != null && f.compare(initialSolution, e.getResult()) <= 0) {
			return false;
		}
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

	public void setInitialSolution(Solution solution) {
		this.initialSolution = solution;
	}

	public Solution apply(Restrictions restrictions) throws Exception {
		int counter = 0;
		Solution incumbent = null;
		for (NeighborhoodOperation operation : this) {
			Solution candidate = operation.execute(initialSolution, true);
			if (f.compare(initialSolution, candidate) > 0 && restrictions.isAllRight(candidate)) {
				incumbent = candidate;
				counter++;
			}
		}
		history.operationListApplied(incumbent, "OpList applied (" + counter + ")");
		return incumbent;
	}
}
