package de.fuberlin.winfo.project.sometests;

import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

public class SampleRoute {

	private static NetworkFactoryImpl f = new NetworkFactoryImpl();
	private static SolutionFactoryImpl ff = new SolutionFactoryImpl();

	public static Route getExample(int n) {
		Route route = ff.createRoute();

		Edge[][] edges = getEdges(n);
		for (int i = 1; i < edges[0].length; i++) {
			UsedEdge usedEdge = ff.createUsedEdge();
			usedEdge.setEdge(edges[i - 1][i]);
			route.getWay().add(usedEdge);
		}
		UsedEdge usedEdge = ff.createUsedEdge();
		Edge edge = edges[route.getWay().get(route.getWay().size() - 1).getEdge().getEnd().getId()][0];
		usedEdge.setEdge(edge);
		route.getWay().add(usedEdge);
		System.out.println("Created route:");
		for (int i = 0; i < route.getWay().size(); i++) {
			UsedEdge e = route.getWay().get(i);
			System.out.print("(");
			System.out.print(e.getEdge().getStart().getId() + " -> " + e.getEdge().getEnd().getId());
			System.out.print(")  ");
		}
		System.out.println();
		return route;
	}

	public static Edge[][] getEdges(int numberOfNodes) {
		Node[] nodes = new Node[numberOfNodes];

		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = f.createNode();
			nodes[i].setId(i);
		}

		Edge[][] edges = new Edge[numberOfNodes][numberOfNodes];

		for (int i = 0; i < nodes.length; i++) {
			for (int j = 0; j < nodes.length; j++) {
				Edge edge = f.createEdge();
				edge.setStart(nodes[i]);
				edge.setEnd(nodes[j]);
				nodes[i].getEdgeOut().add(edge);
				nodes[j].getEdgeIn().add(edge);
				edge.setDistance((i + j) / 2);
				edges[i][j] = edge;
			}
		}
		return edges;
	}
}
