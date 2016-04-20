package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.algorithm.impl.sven.vns.CostFunction;
import de.fuberlin.winfo.project.algorithm.impl.sven.vns.NeighborhoodStructure;
import de.fuberlin.winfo.project.model.network.solution.Solution;

public class VNSHistory {

	private ChangeListener changeListener;
	private CostFunction costFunction;
	private List<VNSChange> vnsImprovements = new ArrayList<VNSChange>();
	private VNSChange currentNH;

	public VNSHistory(CostFunction f) {
		this.costFunction = f;
	}

	public List<VNSChange> getVnsImprovements() {
		return vnsImprovements;
	}

	public VNSChange getCurrentNH() {
		return currentNH;
	}

	public void vnsChange(NeighborhoodStructure nb, int k, Solution prev, Solution better) {
		currentNH.setPrevCost(costFunction.compute(prev));
		currentNH.setNewCost(costFunction.compute(better));
		currentNH.setName(nb.getName() + "(k=" + k + ")");
		currentNH.derive();
		vnsImprovements.add(currentNH);
		changeListener.vnsChange(this);
		currentNH = null;
	}

	public void neighborhoodChange(NeighborhoodStructure nb, Solution prev, Solution better, String string) {
		if (currentNH == null) {
			currentNH = new VNSChange();
			currentNH.setName(nb.getName());
		}
		NeighborhoodChange change = new NeighborhoodChange();
		change.setName(string);
		change.setCost(costFunction.compute(better));
		currentNH.getNeighborhoodChanges().add(change);
		changeListener.neighborhoodChange(this);
	}

	public void setChangeListener(ChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	public static interface ChangeListener {
		public void vnsChange(VNSHistory history);

		public void neighborhoodChange(VNSHistory history);
	}
}
