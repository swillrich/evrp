package de.fuberlin.winfo.project.algorithm;

import org.eclipse.emf.common.util.EList;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Vertex;

/**
 * @author willrich
 *
 *         The Network Provider provides all the data being relevant for solving
 *         problems. <br>
 *         Furthermore, all the data being relevant are provided in multiple
 *         ways, so that at most each need for a specific ask of data is given.
 */
public class NetworkProvider {

	private Arc[][] arcs;
	private Vertex[] vertexs;
	private Network network;
	private Locatables locatables;

	public NetworkProvider(VRPInput input) throws Exception {
		locatables = input.getLocatables();
		network = input.getNetwork();
		buildArrays();
	}

	private void buildArrays() {
		EList<Vertex> nwVertices = network.getVertices();
		int size = nwVertices.size();
		arcs = new Arc[size][size];
		for (Arc arc : network.getArcs()) {
			int startId = arc.getStart().getId();
			int endId = arc.getEnd().getId();
			arcs[startId][endId] = arc;
		}

		vertexs = nwVertices.toArray(new Vertex[nwVertices.size()]);
	}

	public Locatables getLocatables() {
		return locatables;
	}

	public Network getNetwork() {
		return network;
	}

	public Arc[][] getArcs() {
		return arcs;
	}

	public Vertex[] getVertices() {
		return vertexs;
	}
}
