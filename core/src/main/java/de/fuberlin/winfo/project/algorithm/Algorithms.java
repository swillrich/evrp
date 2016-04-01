package de.fuberlin.winfo.project.algorithm;

import java.util.ArrayList;

import de.fuberlin.winfo.project.algorithm.impl.sven.SimpleNearestNeighbor;

/**
 * @author willrich
 *
 */
@SuppressWarnings("serial")
public class Algorithms extends ArrayList<Algorithm> {
	private static Algorithms INSTANCE = new Algorithms();

	/*
	 * Add all algorithms here
	 */
	{
		int i = 0;
		add(i++, new SimpleNearestNeighbor());
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
