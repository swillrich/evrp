package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.Iterator;
import java.util.List;

public class KOptIteratorWrapper implements Iterator<List<Pair>> {
	private KOptHeuristic kOptHeuristic;
	private KOptOptions options;

	public KOptIteratorWrapper(int k, List<Pair> pairs) throws Exception {
		this.kOptHeuristic = new KOptHeuristic(k, pairs);
	}

	@Override
	public boolean hasNext() {
		if (kOptHeuristic.hasNext()) {
			return true;
		} else {
			return !options.isEmpty();
		}
	}

	@Override
	public List<Pair> next() {
		if (options == null || options.isEmpty()) {
			options = kOptHeuristic.next();
		}
		return options.remove(0);
	}

	public KOptOptions getOptions() {
		return options;
	}

	public KOptHeuristic getkOptHeuristic() {
		return kOptHeuristic;
	}
}
