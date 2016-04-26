package de.fuberlin.winfo.project.output;

import java.util.LinkedList;

import de.fuberlin.winfo.project.Log;
import de.fuberlin.winfo.project.Utils;
import de.fuberlin.winfo.project.Utils.ProgressBar;
import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Network;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UsedArc;

public class UnusedEdgeDeleter {

	public static void removeAllEdgesBeingUnused(Network network) {
		Log.info(Log.NETWORK_PROVIDER,
				"Removing of all unused edges (with temporarily use of linked list to remove in O(1))");

		int n = 0;
		for (Solution solution : network.getSolution()) {
			for (Route route : solution.getRoutes()) {
				n += route.getWay().size();
				for (UsedArc usedEdge : route.getWay()) {
					usedEdge.getArc().setIsUsed(true);
				}
			}
		}

		LinkedList<Arc> tmpLinkedList = new LinkedList<Arc>(network.getArcs());
		network.getArcs().clear();

		ProgressBar showProgress = Utils.showProgress(tmpLinkedList.size() - n);
		int removed = 0;
		for (int i = 0; true; i++) {
			if (i >= tmpLinkedList.size()) {
				break;
			}
			Arc edge = tmpLinkedList.get(i);
			if (!edge.isIsUsed()) {
				tmpLinkedList.remove(i);
				edge.getEnd().getArcIn().remove(edge);
				edge.getStart().getArcOut().remove(edge);
				removed++;
				i--;
				showProgress.update(removed);
			}
		}
		showProgress.done();

		network.getArcs().addAll(tmpLinkedList);
	}
}
