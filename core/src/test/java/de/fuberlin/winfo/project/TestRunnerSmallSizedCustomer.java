package de.fuberlin.winfo.project;

import org.junit.Test;

public class TestRunnerSmallSizedCustomer {

	int n = 0;

//	@Test
//	public void TestNN() {
//		runAlg(1);
//	}
//
//	@Test
//	public void TestCluster() {
//		runAlg(2);
//	}
//
//	@Test
//	public void TestRouting() {
//		runAlg(3);
//	}

	@Test
	public void DCVRPTW() {
		runAlg(0);
	}
	
//	@Test
//	public void NN() {
//		runAlg(4);
//	}

	public void runAlg(int nr) {
		try {
			SampleInputDataImpl sampleInputDataImpl = new SampleInputDataImpl(true, nr, n);
			Informationsystem is = new Informationsystem(sampleInputDataImpl);
			is.work();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
