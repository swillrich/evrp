package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.algorithm.RouteWrapper;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.AbstractRandomizedNeighborhoodStructure;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class RandomizedCyclingExchangeNeighborhoodStructure extends AbstractRandomizedNeighborhoodStructure {
	private int cycleSize;

	public RandomizedCyclingExchangeNeighborhoodStructure(int cycleSize, int iterations) {
		super(iterations);
		this.cycleSize = cycleSize;
	}

	@Override
	protected NeighborhoodOperation generateRandomOperation(Solution solution) {
		int[] routes = new int[cycleSize];
		int[] nodes = new int[cycleSize];
		int[] pathLengths = new int[cycleSize];

		fillArraysRecursively(solution, routes, nodes, pathLengths, 0);

		return new CyclingExchangeNeighborhoodOpereration(routes, nodes, pathLengths, networkProvider.getArcs());
	}

	private void fillArraysRecursively(Solution s, int[] routes, int[] nodes, int[] pathLengths, int i) {
		if (i >= routes.length) {
			return;
		}
		a: while (true) {
			int candidate = random.nextInt(s.getRoutes().size());
			for (int j = 0; j < i; j++) {
				if (routes[j] == candidate) {
					continue a;
				}
			}
			routes[i] = candidate;
			break;
		}
		nodes[i] = random.nextInt(s.getRoutes().get(routes[i]).getWay().size() - 1);
		pathLengths[i] = 1;
		if (nodes[i] < s.getRoutes().get(routes[i]).getWay().size() - 1) {
			pathLengths[i] += random.nextInt(s.getRoutes().get(routes[i]).getWay().size() - nodes[i] - 1);
		}

		fillArraysRecursively(s, routes, nodes, pathLengths, i + 1);
	}

	@Override
	public String getName() {
		return "R-" + cycleSize + "-Cycling Exchange";
	}

	public class CyclingExchangeNeighborhoodOpereration extends NeighborhoodOperation {

		private int[] routes;
		private int[] nodes;
		private int[] pathLengths;
		private Arc[][] A;

		public CyclingExchangeNeighborhoodOpereration(int[] routes, int[] nodes, int[] pathLengths, Arc[][] A) {
			this.routes = routes;
			this.nodes = nodes;
			this.pathLengths = pathLengths;
			this.A = A;
		}

		@Override
		public Solution apply(Solution solution) throws Exception {
			exchangeCyclically(solution, 0);
			return solution;
		}

		private void exchangeCyclically(Solution s, int i) throws Exception {
			if (i >= routes.length) {
				return;
			}
			int next = (i + 1) % routes.length;
			RouteWrapper routeWrapperNext = new RouteWrapper(s.getRoutes().get(routes[next]), null, A);
			RouteWrapper routeWrapper = new RouteWrapper(s.getRoutes().get(routes[i]), null, A);
			List<UsedArc> cache = getSubListById(next, routeWrapperNext);
			exchangeCyclically(s, i + 1);
			justifyStartAndEndArc(i, routeWrapper, cache);
			routeWrapper.replaceSubRoute(cache, nodes[i], nodes[i] + pathLengths[i]);
		}

		private List<UsedArc> getSubListById(int id, RouteWrapper wrapper) {
			List<UsedArc> subList = wrapper.getActualRoute().getWay().subList(nodes[id],
					nodes[id] + pathLengths[id] + 1);
			return (List<UsedArc>) EcoreUtil.copyAll(subList);
		}

		private void justifyStartAndEndArc(int id, RouteWrapper wrapper, List<UsedArc> toModify) {
			Arc startArc = wrapper.getActualRoute().getWay().get(nodes[id]).getArc();
			int pathBeginStartId = startArc.getStart().getId();
			int pathBeginEndId = toModify.get(0).getArc().getEnd().getId();
			Arc newStartArc = A[pathBeginStartId][pathBeginEndId];
			toModify.get(0).setArc(newStartArc);

			Arc endArc = wrapper.getActualRoute().getWay().get(nodes[id] + pathLengths[id]).getArc();
			int pathEndStartID = toModify.get(toModify.size() - 1).getArc().getStart().getId();
			int pathEndEndId = endArc.getEnd().getId();
			toModify.get(toModify.size() - 1).setArc(A[pathEndStartID][pathEndEndId]);
		}

		@Override
		public boolean isPreconditionSatisfied(Solution solution) {
			for (int i = 0; i < routes.length; i++) {
				if (solution.getRoutes().size() <= routes[i]) {
					return false;
				}
				if (solution.getRoutes().get(routes[i]).getWay().size() <= nodes[i] + pathLengths[i]) {
					return false;
				}
			}
			return true;
		}

		@Override
		public int operationHash() {
			StringBuilder b = new StringBuilder();
			for (int i = 0; i < routes.length; i++) {
				b.append("r" + routes[i] + "n" + nodes[i] + "p" + pathLengths[i] + "+");
			}
			return b.toString().hashCode();
		}

	}
}
