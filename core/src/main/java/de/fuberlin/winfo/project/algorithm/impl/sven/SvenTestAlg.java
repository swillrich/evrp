package de.fuberlin.winfo.project.algorithm.impl.sven;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class SvenTestAlg extends Algorithm {

	@Override
	public String getName() {
		return "Sven Test Alg";
	}

	@Override
	public void run(Solution solution) throws Exception {
		System.out.println("do something ...");
	}

}
