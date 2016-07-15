package de.fuberlin.winfo.project;

import org.junit.Test;

import de.fuberlin.winfo.project.input.impl.sven.ZMIVRPInput;

public class TestRunner {

	@Test
	public void TestAlg() {
		try {
			RoutePlanningSystem is = new RoutePlanningSystem(new ZMIVRPInput());
			is.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void timeWindowTest() {
		try {
			for (double i = 0.2; i < 1.0; i = i + 0.1) {
				System.out.println("TEST ITERATION " + i);
				ZMIVRPInput input = new ZMIVRPInput();
				input.addRandomizedTimeWindows(input.getNetwork(), i);
				RoutePlanningSystem is = new RoutePlanningSystem(input);
				is.work();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
