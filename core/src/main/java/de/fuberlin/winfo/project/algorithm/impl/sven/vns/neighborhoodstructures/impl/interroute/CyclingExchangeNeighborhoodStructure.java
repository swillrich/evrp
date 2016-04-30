package de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.impl.interroute;

import java.util.TreeMap;
import java.util.stream.IntStream;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodOperation;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.neighborhoodstructures.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.Solution;

public class CyclingExchangeNeighborhoodStructure extends NeighborhoodStructure {

	private int pathLengte;
	private int cycleSize;
	private int currentRoute;
	private TreeMap<Integer, Integer> routeIndeces;

	public CyclingExchangeNeighborhoodStructure(int pathLength, int cycleSize) {
		this.pathLengte = pathLength;
		this.cycleSize = cycleSize;
	}

	@Override
	public void initSearch() {
		super.initSearch();
		currentRoute = 0;
		routeIndeces = new TreeMap<Integer, Integer>();
		IntStream.range(0, initialSol.getRoutes().size()).forEach(i -> routeIndeces.put((Integer) i, i));
	}

	@Override
	public boolean hasNext() {
		return hasNextRoute();
	}

	private boolean hasNextRoute() {
		return currentRoute < initialSol.getRoutes().size() - 1;
	}

	@Override
	public String getName() {
		return "Cycling Exchange";
	}

	@Override
	public NeighborhoodOperation generateOperation(Solution solution) throws Exception {
		return null;
	}
}
