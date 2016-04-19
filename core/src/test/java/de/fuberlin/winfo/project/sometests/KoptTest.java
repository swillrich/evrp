package de.fuberlin.winfo.project.sometests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Pair;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class KoptTest {
	public static void main(String[] args) {
		Route example = SampleRoute.getExample(6);
		try {
			Route2KOptPairs optPairs = new Route2KOptPairs();
			optPairs.convert(example);
			List<Pair> pairs = optPairs.getPairs();
			KOptHeuristic opt = new KOptHeuristic(2, pairs);
			opt.printAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		RouteWrapper routeWrapper = new RouteWrapper(example, null, null);
		routeWrapper.print();
	}

	private static void sort(EList<UsedEdge> way) {
		List<UsedEdge> list = new ArrayList<UsedEdge>(way);
		way.clear();
		Collections.sort(list, new Comparator<UsedEdge>() {

			@Override
			public int compare(UsedEdge a, UsedEdge b) {
				int aStart = a.getEdge().getStart().getId();
				int aEnd = a.getEdge().getEnd().getId();
				int bStart = b.getEdge().getStart().getId();
				int bEnd = b.getEdge().getEnd().getId();

				if (aStart == 0) {
					return -1;
				} else if (bEnd == 0) {
					return 1;
				} else {
					if (aStart == bEnd) {
						return 1;
					}
					if (aEnd == bStart) {
						return -1;
					}
					return 0;
				}
			}
		});
		way.addAll(list);

	}

	private static void shuffle(EList<UsedEdge> way) {
		List<UsedEdge> list = new ArrayList<UsedEdge>(way);
		way.clear();
		Collections.shuffle(list);
		way.addAll(list);
	}
}
