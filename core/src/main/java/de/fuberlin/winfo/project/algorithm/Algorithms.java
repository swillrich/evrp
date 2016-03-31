package de.fuberlin.winfo.project.algorithm;

import java.util.ArrayList;

import de.fuberlin.winfo.project.algorithm.impl.DCVRPTW_with_SimpleClusters_Alg;
import de.fuberlin.winfo.project.algorithm.impl.NN;
import de.fuberlin.winfo.project.algorithm.impl.TestClustering;
import de.fuberlin.winfo.project.algorithm.impl.TestNN;
import de.fuberlin.winfo.project.algorithm.impl.TestRouting;

/**
 * @author willrich
 * 
 *         This class holds all the algorithms being present in the
 *         ...algorithm.impl package. <br>
 *         <b>Please consider that all algorithms will be perceived
 *         automatically.</b>
 *
 */
public class Algorithms extends ArrayList<Algorithm> {
	private static Algorithms INSTANCE = new Algorithms();

	/*
	 * Add all algorithms here
	 */
	{
		int i = 0;
		add(i++, new DCVRPTW_with_SimpleClusters_Alg());
		add(i++, new TestNN());
		add(i++, new TestClustering());
		add(i++, new TestRouting());
		add(i++, new NN());
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < size(); i++) {
			b.append("[" + (i + 1) + "] " + get(i).getName());
			if (i + 1 < size()) {
				b.append("\n");
			}
		}
		return b.toString();
	}

	public static Algorithms get() {
		return INSTANCE;
	}
}
