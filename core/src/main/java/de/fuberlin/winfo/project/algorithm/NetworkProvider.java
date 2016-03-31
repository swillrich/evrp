package de.fuberlin.winfo.project.algorithm;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.NetworkFactory;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

/**
 * @author willrich
 *
 *         The Network Provider provides all the data being relevant for solving
 *         problems. <br>
 *         Furthermore, all the data being relevant, are provided in multiple
 *         ways, so that at most each demand for a specific provision of data is
 *         given.
 */
public class NetworkProvider {

	/**
	 * Creates new Domain Objects
	 */
	private NetworkFactory networkFactory = new NetworkFactoryImpl();
	private SolutionFactoryImpl solutionFactory = new SolutionFactoryImpl();
	private Edge[][] edges;
	private Node[] nodes;
	private Network network;
	private Locatables locatables;

	public NetworkProvider(VRPInput input) throws Exception {
		locatables = input.getLocatables();
		network = input.getNetwork();
		buildArrays();
	}

	private void buildArrays() {
		edges = new Edge[locatables.size()][locatables.size()];
		for (Edge edge : network.getEdges()) {
			int startId = edge.getStart().getId();
			int endId = edge.getEnd().getId();
			edges[startId][endId] = edge;
		}

		nodes = new Node[network.getNodes().size()];
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = network.getNodes().get(i);
		}
	}

	public Locatables getLocatables() {
		return locatables;
	}

	public Network getNetwork() {
		return network;
	}

	public NetworkFactory getNetworkFactory() {
		return networkFactory;
	}

	public SolutionFactoryImpl getSolutionFactory() {
		return solutionFactory;
	}

	public Edge[][] getEdges() {
		return edges;
	}

	public Node[] getNodes() {
		return nodes;
	}
}
