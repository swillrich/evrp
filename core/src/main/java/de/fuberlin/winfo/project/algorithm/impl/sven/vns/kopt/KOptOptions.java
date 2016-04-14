package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KOptOptions extends ArrayList<List<Pair>> {
	public int[] toReplace;

	public KOptOptions(int[] toReplace) {
		this.toReplace = Arrays.copyOf(toReplace, toReplace.length);
	}

	public void fillBy(ArrayList<List<Integer>> permutations) {
		for (List<Integer> list : permutations) {
			List<Pair> l = new ArrayList<Pair>();
			for (int i = 0; i < list.size(); i = i + 2) {
				final int src = list.get(i);
				final int target = list.get(i + 1);
				Pair pair = new Pair() {

					@Override
					public int getStart() {
						return src;
					}

					@Override
					public int getEnd() {
						return target;
					}

					@Override
					public Object getSrc() {
						return null;
					}

				};
				l.add(pair);
			}
			add(l);
		}
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < this.size(); i++) {
			List<Pair> sequence = this.get(i);
			for (int j = 0; j < sequence.size(); j++) {
				b.append(sequence.get(j).getStart() + "->" + sequence.get(j).getEnd());
				if (j + 1 < sequence.size()) {
					b.append(", ");
				}
			}
			b.append("\n");
		}
		return b.toString();
	}
}