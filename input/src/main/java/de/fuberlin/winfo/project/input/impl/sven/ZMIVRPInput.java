package de.fuberlin.winfo.project.input.impl.sven;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.ProgressBar;
import de.fuberlin.winfo.project.input.VRPInput;
import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.ZMIJsonConverter;
import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model.ZMIEdge;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.impl.EdgeImpl;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.impl.NodeImpl;
import de.fuberlin.winfo.project.model.network.solution.UseCase;

public class ZMIVRPInput implements VRPInput {
	private CSV2ObjMapper mapper = null;
	private File zippedAndSerializedDM;
	private NetworkFactoryImpl networkFactory = new NetworkFactoryImpl();
	private Locatables locatables;

	public ZMIVRPInput() throws Exception {
		mapper = new CSV2ObjMapper(InputFilesBundles.vehicleFile, InputFilesBundles.customerFile,
				InputFilesBundles.depotFile, InputFilesBundles.useCaseFile);
		this.zippedAndSerializedDM = InputFilesBundles.zippedAndSerializedDM;
	}

	@Override
	public List<UseCase> getUseCases() {
		return mapper.getUseCaseList();
	}

	@Override
	public Locatables getLocatables() {
		if (locatables == null) {
			locatables = new Locatables();
			mapper.getLocatables().forEach(l -> locatables.addNewStaticLocatable(l));
			locatables.limitBy(getCustomerMaximum());
		}
		return locatables;
	}

	@Override
	public int getCustomerMaximum() {
		return 200;
	}

	@Override
	public String getVisualizationServer() {
		return "http://localhost:8080";
	}

	@Override
	public int getDesiredProcedure() {
		return 0;
	}

	@Override
	public Network getNetwork() {
		Network network = networkFactory.createNetwork();
		Log.info(Log.DATA_IMPORT, "Build network");

		try {
			Log.info(Log.DATA_IMPORT, "Read in the entire distance matrix ...");
			List<ZMIEdge> pojos = ZMIJsonConverter
					.deseriaizeZippedZMIEdges(new FileInputStream(this.zippedAndSerializedDM));
			Log.info(Log.DATA_IMPORT, "Build edge array based on the distance matrix");
			Edge[][] multidimensionalEdgeArray = getDistanceMatrixAsArray(pojos, getLocatables().size());
			Log.info(Log.DATA_IMPORT, "Build all nodes (" + getLocatables().size() + ")");
			Node[] nodes = inflateNodes();
			assignEdgesToNodes(multidimensionalEdgeArray, nodes);

			for (int i = 0; i < multidimensionalEdgeArray.length; i++) {
				for (int j = 0; j < multidimensionalEdgeArray[i].length; j++) {
					network.getEdges().add(multidimensionalEdgeArray[i][j]);
				}
			}

			for (int i = 0; i < nodes.length; i++) {
				network.getNodes().add(nodes[i]);
			}

			return network;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * HELPER METHODS
	 */

	private Edge[][] getDistanceMatrixAsArray(List<ZMIEdge> zmiEdges, int n) throws Exception {
		Edge[][] matrix = new EdgeImpl[n][n];
		ProgressBar showProgress = Utils.showProgress((int) Math.pow(n, 2));
		Iterator<ZMIEdge> iterator = zmiEdges.iterator();
		int i = 0;
		while (iterator.hasNext()) {
			ZMIEdge zmiEdge = iterator.next();
			int originId = zmiEdge.getOriginId();
			int destId = zmiEdge.getDestId();
			int distance = zmiEdge.getDistance();
			int time = zmiEdge.getTime();
			if (originId < n && destId < n) {
				showProgress.update(++i);
				matrix[originId][destId] = networkFactory.createEdge();
				Edge edge = matrix[originId][destId];
				edge.setTime(time);
				edge.setDistance(distance);
				edge.setId(originId + "-" + destId);
			}
		}
		showProgress.done();
		return matrix;
	}

	private Node[] inflateNodes() {
		ProgressBar showProgress = Utils.showProgress(getLocatables().size());
		Node[] nodes = new NodeImpl[getLocatables().size()];
		for (int i = 0; i < nodes.length; i++) {
			showProgress.update(i);
			Node node = networkFactory.createNode();
			node.setId(i);
			node.setRepresentative(getLocatables().get(i));
			nodes[i] = node;
		}
		showProgress.update(nodes.length);
		showProgress.done();
		return nodes;
	}

	private void assignEdgesToNodes(Edge[][] edges, Node[] nodes) {
		ProgressBar showProgress = Utils.showProgress(nodes.length);
		for (int i = 0; i < nodes.length; i++) {
			showProgress.update(i);
			for (int j = 0; j < nodes.length; j++) {
				Edge edge = edges[i][j];
				if (edge == null) {
					System.out.println("is null: " + i + " " + j);
				}
				edge.setStart(nodes[i]);
				edge.setEnd(nodes[j]);
				nodes[i].getEdgeOut().add(edge);
				nodes[j].getEdgeIn().add(edge);
			}
		}
		showProgress.update(nodes.length);
		showProgress.done();
	}
}
