package de.fuberlin.winfo.project.algorithm.impl.sven.vns.kopt;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class KOptHeuristic implements Iterator<KOptOptions> {
	private int[] posArr;
	private int n;
	private int k;
	private List<Pair> seq;

	public KOptHeuristic(int k, List<Pair> route) throws Exception {
		int edges = route.size();
		if ((double) edges / k < 1.5) {
			throw new Exception("Insufficient edges (" + route.size() + ") for using k = " + k);
		}
		this.seq = route;
		posArr = new int[k];
		this.k = k;
		this.n = edges;
		initAt(1);
	}

	private void initAt(int i) {
		for (; i < posArr.length; i++) {
			if (i > 0) {
				posArr[i] = posArr[i - 1] + 2;
			}
		}
	}

	@Override
	public boolean hasNext() {
		return posArr[0] != -1;
	}

	@Override
	public KOptOptions next() {
		KOptOptions options = createOptions();
		increment(0);
		return options;
	}

	private KOptOptions createOptions() {
		KOptOptions options = new KOptOptions(posArr, seq);
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < k; i++) {
			Pair pair = seq.get(posArr[i]);
			if (i == 0) {
				map.put(pair.getEnd(), i);
			} else if (i == k - 1) {
				map.put(pair.getStart(), i);
			} else {
				map.put(pair.getStart(), i);
				map.put(pair.getEnd(), i);
			}
		}
		ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();
		permute(permutations, map, new ArrayList<Integer>(), new ArrayList<Integer>(map.keySet()));
		for (List<Integer> l : permutations) {
			l.add(0, seq.get(posArr[0]).getStart());
			l.add(seq.get(posArr[k - 1]).getEnd());
		}
		options.fillBy(permutations);
		return options;
	}

	private void permute(ArrayList<List<Integer>> container, Map<Integer, Integer> map, ArrayList<Integer> prefix,
			ArrayList<Integer> nodes) {
		if (nodes.size() == 0) {
			container.add(new ArrayList<Integer>(prefix));
		} else {
			for (int i = 0; i < nodes.size(); i++) {
				ArrayList<Integer> list = new ArrayList<Integer>(nodes);
				Integer nodeId = list.remove(i);

				Pair tabuPair = seq.get(posArr[k - 2 - list.size() / 2]);
				if (nodeId == tabuPair.getEnd()) {
					continue;
				}

				Integer edgeIndex = map.get(nodeId);
				int otherEnd;
				Pair pair = seq.get(posArr[edgeIndex]);
				int nextEdgeIndex = edgeIndex + (pair.getStart() == nodeId ? -1 : 1);
				if (nextEdgeIndex < edgeIndex) {
					otherEnd = seq.get(posArr[nextEdgeIndex]).getEnd();
				} else {
					otherEnd = seq.get(posArr[nextEdgeIndex]).getStart();
				}

				list.remove((Integer) otherEnd);

				prefix.add(nodeId);
				prefix.add(otherEnd);

				permute(container, map, prefix, list);

				prefix.remove((Integer) nodeId);
				prefix.remove((Integer) otherEnd);
			}
		}
	}

	private boolean increment(int i) {
		if (i >= k) {
			return false;
		} else {
			boolean increment = increment(i + 1);
			if (i < k - 1) {
				if (increment) {
					if (posArr[i] + 1 >= n) {
						return true;
					} else {
						posArr[i]++;
						if (posArr[i] + 2 * (k - 1 - i) < n) {
							initAt(i + 1);
							return false;
						} else if (posArr[0] + 2 * (k - 1) > n - 1) {
							for (int j = 0; j < k; j++) {
								posArr[j] = -1;
							}
							return false;
						} else {
							return true;
						}

					}
				} else {
					return false;
				}
			} else {
				if (posArr[i] + 1 >= n) {
					return true;
				} else {
					posArr[i]++;
					return false;
				}
			}
		}
	}

	@Override
	public String toString() {
		String r = "[edges = " + n + "], [k-opt = " + posArr.length + "]";
		for (int i = 0; i < posArr.length; i++) {
			if (i == 0) {
				r += ", [";
			}
			r += posArr[i];
			if (i < posArr.length - 1) {
				r += ", ";
			}
			if (i == posArr.length - 1) {
				r += "]";
			}
		}
		return r;
	}

	public void printAll() {
		for (int i = 1; hasNext(); i++) {
			System.out.println(i + ". -> " + toString());
			KOptOptions next = next();
			System.out.println(next);
		}
		posArr[0] = 0;
		initAt(0);
	}
}