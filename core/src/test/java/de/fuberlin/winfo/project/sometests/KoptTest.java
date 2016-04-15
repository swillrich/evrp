package de.fuberlin.winfo.project.sometests;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.KOptHeuristic;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt.Route2KOptPairs;
import de.fuberlin.winfo.project.model.network.solution.Route;

public class KoptTest {
	public static void main(String[] args) {
		Route example = SampleRoute.getExample(6);
		try {
			KOptHeuristic opt = new KOptHeuristic(3, Route2KOptPairs.convert(example));
			opt.printAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
