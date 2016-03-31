package de.fuberlin.winfo.project.output;

import java.util.LinkedList;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.ProgressBar;
import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

public class UnusedEdgeDeleter {

	public static void removeAllEdgesBeingUnused(Network network) {
		Log.info(Log.NETWORK_PROVIDER,
				"Removing of all unused edges (with temporarily use of linked list to remove in O(1))");

		int n = 0;
		for (Solution solution : network.getSolution()) {
			for (Route route : solution.getRoutes()) {
				n += route.getWay().size();
				for (UsedEdge usedEdge : route.getWay()) {
					usedEdge.getEdge().setIsUsed(true);
				}
			}
		}

		LinkedList<Edge> tmpLinkedList = new LinkedList<Edge>(network.getEdges());
		network.getEdges().clear();

		ProgressBar showProgress = Utils.showProgress(tmpLinkedList.size() - n);
		int removed = 0;
		for (int i = 0; true; i++) {
			if (i >= tmpLinkedList.size()) {
				break;
			}
			Edge edge = tmpLinkedList.get(i);
			if (!edge.isIsUsed()) {
				tmpLinkedList.remove(i);
				edge.getEnd().getEdgeIn().remove(edge);
				edge.getStart().getEdgeOut().remove(edge);
				removed++;
				i--;
				showProgress.update(removed);
			}
		}
		showProgress.done();

		network.getEdges().addAll(tmpLinkedList);
	}
}
