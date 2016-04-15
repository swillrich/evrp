package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KOptOptions extends ArrayList<List<Pair>> {
	private int[] toReplace;
	private List<Pair> sequence;

	public KOptOptions(int[] toReplace, List<Pair> seq) {
		this.toReplace = Arrays.copyOf(toReplace, toReplace.length);
		this.sequence = seq;
	}

	public void fillBy(ArrayList<List<Integer>> permutations) {
		for (List<Integer> list : permutations) {
			List<Pair> l = new ArrayList<Pair>();
			for (int i = 0; i < list.size(); i = i + 2) {
				final int src = list.get(i);
				final int target = list.get(i + 1);
				// withIntermediatePoints(list, l, i, src);
				l.add(new Pair() {

					@Override
					public int getStart() {
						return src;
					}

					@Override
					public int getEnd() {
						return target;
					}

				});
			}
			add(l);
		}
	}

	private void withIntermediatePoints(List<Integer> list, List<Pair> l, int i, final int src) {
		if (i > 0) {
			int prevTarget = list.get(i - 1);
			l.add(new Pair() {

				@Override
				public int getStart() {
					return prevTarget;
				}

				@Override
				public int getEnd() {
					return src;
				}

			});
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

	public List<Pair> getSequence() {
		return sequence;
	}

	public int[] getToReplace() {
		return toReplace;
	}
}