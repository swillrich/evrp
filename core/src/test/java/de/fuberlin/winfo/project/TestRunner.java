package de.fuberlin.winfo.project;

import org.junit.Test;

import de.fuberlin.winfo.project.input.impl.sven.ZMIVRPInput;

public class TestRunner {

	@Test
	public void TestAlg() {
		try {
			RoutePlanningSystem is = new RoutePlanningSystem(new ZMIVRPInput("SINGLE"));
			is.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void timeWindowTest() {
		try {
			for (double i = 0.1; i < 1.0; i = i + 0.1) {
				System.out.println("ITERATION " + i);
				ZMIVRPInput input = new ZMIVRPInput("TW " + i);
				input.addRandomizedTimeWindows(input.getNetwork(), i);
				RoutePlanningSystem is = new RoutePlanningSystem(input);
				is.work();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void allRuns() {
		try {
			for (int i = 0; i < 10; i++) {
				System.out.println("ITERATION " + i);
				ZMIVRPInput input = new ZMIVRPInput("TOTAL " + i);
				input.addRandomizedTimeWindows(input.getNetwork(), i);
				RoutePlanningSystem is = new RoutePlanningSystem(input);
				is.work();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
