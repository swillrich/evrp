package de.fuberlin.winfo.project.algorithm;

import java.util.ArrayList;

import de.fuberlin.winfo.project.algorithm.impl.sven.SvensAlg;

/**
 * @author willrich
 *
 */
@SuppressWarnings("serial")
public class Algorithms extends ArrayList<Algorithm> {
	private static Algorithms INSTANCE;

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

	public static Algorithm get(Class<? extends Algorithm> clazz) {
		return INSTANCE.stream().filter(a -> a.getClass().equals(clazz)).findFirst().get();
	}

	public static Algorithms get() {
		if (INSTANCE == null) {
			INSTANCE = new Algorithms();
		}
		return INSTANCE;
	}

	public static Algorithms init() {
		Algorithms algs = get();
		int i = 0;
		algs.add(i++, new SvensAlg());
		return algs;
	}
}
