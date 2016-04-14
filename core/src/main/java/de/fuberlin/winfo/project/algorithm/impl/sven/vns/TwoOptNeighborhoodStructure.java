package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.List;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptIteratorWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {

	private int current = -1;
	private KOptIteratorWrapper optionIterator;

	@Override
	public String getName() {
		return "2-Opt";
	}

	@Override
	public boolean hasNext() {
		if (!optionIterator.hasNext()) {
			optionIterator = null;
			return current > 0;
		}
		return true;
	}

	@Override
	public Solution move(Solution solution) {
		if (optionIterator != null) {
			List<Pair> option = optionIterator.next();
			return actualMove(solution, option);
		} else {
			if (current == -1) {
				current = solution.getRoutes().size() - 1;
			} else {
				current--;
			}
			try {
				List<Pair> pairs = Route2KOptPairs.convert(solution.getRoutes().get(current));
				optionIterator = new KOptIteratorWrapper(2, pairs);
				return move(solution);
			} catch (Exception e) {
				return null;
			}
		}
	}

	private Solution actualMove(Solution solution, List<Pair> pairs) {
		return centralSol;
	}
}
