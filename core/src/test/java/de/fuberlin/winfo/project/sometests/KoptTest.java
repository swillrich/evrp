package de.fuberlin.winfo.project.sometests;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.KOptHeuristic;
import de.fuberlin.winfo.project.model.network.solution.Route;

public class KoptTest {
	public static void main(String[] args) {
		Route example = SampleRoute.getExample(18);
		try {
			KOptHeuristic opt = new KOptHeuristic(2, example);
			opt.printAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
