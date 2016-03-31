package de.fuberlin.winfo.project;

import org.junit.Test;

import de.fuberlin.winfo.project.input.impl.sven.ZMIVRPInput;

public class TestRunner {

	@Test
	public void TestAlg() {
		try {
			Informationsystem is = new Informationsystem(new ZMIVRPInput());
			is.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
