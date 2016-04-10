package de.fuberlin.winfo.project.algorithm.impl.sven.vns;

import de.fuberlin.winfo.project.algorithm.NetworkProvider;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class TwoOptNeighborhoodStructure extends NeighborhoodStructure {
	public TwoOptNeighborhoodStructure(NetworkProvider np) {
		super(np);
	}

	@Override
	public String getName() {
		return "2-Opt";
	}

	@Override
	public boolean hasNext() {
		return false;
	}

	@Override
	public Solution move(Solution solution) {
		return null;
	}

	private class KOpt {
		int[] posArr;
		int n;

		KOpt(int k, int n) {
			posArr = new int[k];
			for (int i = 0; i < posArr.length; i++) {
				if (i > 0) {
					posArr[i] = posArr[i - 1] + 2;
				}
			}
			this.n = n;
		}

		void changeNext(Route route) {
			for (int i : posArr) {

			}
			increment();
		}
		
		void increment() {
			for (int i = posArr.length; i >= 1; i--) {
				int d = posArr[i - 1];
				
			}
		}
	}
}
