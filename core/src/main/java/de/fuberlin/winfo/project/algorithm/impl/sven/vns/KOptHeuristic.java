package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import java.util.Iterator;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.KOptHeuristic.Options;

public class KOptHeuristic implements Iterator<Options> {
	private int[] posArr;
	private int n;
	private int k;

	KOptHeuristic(int k, int edges) throws Exception {
		if (edges < 3 || k < 2) {
			throw new Exception("At least both 3 edges and 2-opt needed");
		}
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
	public Options next() {
		Options options = new Options(posArr);
		increment(0);
		return options;
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
			increment(0);
		}
		posArr[0] = 0;
		initAt(0);
	}

	public static class Options {
		int[] edges;
		

		public Options(int[] edges) {
			this.edges = edges;
		}
		
	}

	public static void main(String[] args) {
		try {
			KOptHeuristic opt = new KOptHeuristic(2, 4);
			opt.printAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}