package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.KOptHeuristic.KOptOptions;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.solution.Route;

public class KOptHeuristic implements Iterator<KOptOptions> {
	private int[] posArr;
	private int n;
	private int k;
	private Route route;

	public KOptHeuristic(int k, Route route) throws Exception {
		int edges = route.getWay().size();
		if (edges < 3 || k < 2) {
			throw new Exception("At least both 3 edges and 2-opt needed");
		}
		this.route = route;
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
		KOptOptions options = new KOptOptions(posArr);
		Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
		for (int i = 0; i < k; i++) {
			Edge edge = route.getWay().get(posArr[i]).getEdge();
			if (i == 0) {
				map.put(edge.getEnd().getId(), i);
			} else if (i == k - 1) {
				map.put(edge.getStart().getId(), i);
			} else {
				map.put(edge.getStart().getId(), i);
				map.put(edge.getEnd().getId(), i);
			}
		}
		ArrayList<List<Integer>> permutations = new ArrayList<List<Integer>>();
		permute(permutations, map, new ArrayList<Integer>(), new ArrayList<Integer>(map.keySet()));
		for (List<Integer> l : permutations) {
			l.add(0, route.getWay().get(posArr[0]).getEdge().getStart().getId());
			l.add(route.getWay().get(posArr[k - 1]).getEdge().getEnd().getId());
		}
		options.addAll(permutations);
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

				Edge tabuEdge = route.getWay().get(posArr[k - 2 - list.size() / 2]).getEdge();
				if (nodeId == tabuEdge.getEnd().getId()) {
					continue;
				}

				Integer edgeIndex = map.get(nodeId);
				int otherEnd;
				Edge edge = route.getWay().get(posArr[edgeIndex]).getEdge();
				int nextEdgeIndex = edgeIndex + (edge.getStart().getId() == nodeId ? -1 : 1);
				if (nextEdgeIndex < edgeIndex) {
					otherEnd = route.getWay().get(posArr[nextEdgeIndex]).getEdge().getEnd().getId();
				} else {
					otherEnd = route.getWay().get(posArr[nextEdgeIndex]).getEdge().getStart().getId();
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

	public static class KOptOptions extends ArrayList<List<Integer>> {
		int[] toReplace;

		public KOptOptions(int[] toReplace) {
			this.toReplace = toReplace;
		}

		@Override
		public String toString() {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < this.size(); i++) {
				List<Integer> sequence = this.get(i);
				for (int j = 0; j < sequence.size(); j = j + 2) {
					b.append(sequence.get(j) + "->" + sequence.get(j + 1));
					if (j + 2 < sequence.size()) {
						b.append(", ");
					}
				}
				b.append("\n");
			}
			return b.toString();
		}
	}
	
	public static interface Pair {
		int getId();
		int getStart();
		int getEnd();
		Object getSrc();
	}
}