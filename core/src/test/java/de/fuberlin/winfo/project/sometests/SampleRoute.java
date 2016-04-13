package de.fuberlin.winfo.project.sometests;

import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Node;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

public class SampleRoute {

	public static Route getExample(int n) {
		NetworkFactoryImpl f = new NetworkFactoryImpl();
		SolutionFactoryImpl ff = new SolutionFactoryImpl();

		Node[] nodes = new Node[n];
		Route route = ff.createRoute();
		for (int i = 0; i < nodes.length; i++) {
			nodes[i] = f.createNode();
			nodes[i].setId(i);
		}

		Edge[][] edges = new Edge[(int) Math.pow(nodes.length, 2)][(int) Math.pow(nodes.length, 2)];

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

		for (int i = 0; i + 1 < nodes.length; i++) {
			Edge edge = edges[nodes[i].getId()][nodes[i + 1].getId()];
			UsedEdge usedEdge = ff.createUsedEdge();
			usedEdge.setEdge(edge);
			route.getWay().add(usedEdge);
		}
		UsedEdge usedEdge = ff.createUsedEdge();
		Edge edge = edges[route.getWay().get(route.getWay().size() - 1).getEdge().getEnd().getId()][0];
		usedEdge.setEdge(edge);
		route.getWay().add(usedEdge);
		System.out.println("Created route:");
		for (UsedEdge e : route.getWay()) {
			System.out.print(e.getEdge().getStart().getId() + " -> ");
		}
		System.out.print(route.getWay().get(route.getWay().size() - 1).getEdge().getEnd().getId());
		System.out.println();
		return route;
	}
}
