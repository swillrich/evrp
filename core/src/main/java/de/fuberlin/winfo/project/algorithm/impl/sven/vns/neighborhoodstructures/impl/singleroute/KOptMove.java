package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.singleroute;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.algorithm.Algorithm;
import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.Move;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class KOptMove extends Move {
	private int currentRoute;
	private List<UsedArc> newUsedArcList;
	private int[] toReplace;
	private Arc[][] A;

	public KOptMove(int current, List<UsedArc> newUsedArcList, int[] toReplace, Arc[][] A) {
		this.currentRoute = current;
		this.newUsedArcList = newUsedArcList;
		this.toReplace = toReplace;
		this.A = A;
	}

	@Override
	public Solution apply(Solution solution) throws Exception {
		RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(currentRoute), null, A);
		wrapper.replaceSubRoute(newUsedArcList, toReplace[0], toReplace[toReplace.length - 1]);
		return solution;
	}

	@Override
	public boolean isPreconditionSatisfied(Solution solution) {
		RouteWrapper wrapper = new RouteWrapper(solution.getRoutes().get(currentRoute), null, A);
		for (int i : toReplace) {
			if (wrapper.getActualRoute().getWay().size() <= i) {
				return false;
			}
		}

		Solution copy = Algorithm.getCopy(solution);
		try {
			apply(copy);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public int operationHash() {
		String collect = newUsedArcList.stream().map(u -> u.getArc().getEnd().getId() + "")
				.collect(Collectors.joining("-"));
		return "kopt".concat(currentRoute + Arrays.toString(toReplace) + collect).hashCode();
	}
}