package de.fuberlin.winfo.project.algorithm.impl.sven.vns.logging;

import java.util.ArrayList;
import java.util.List;

public class VNSChange {
	private boolean isImprovement;
	private int prevCost;
	private int newCost;
	private int diff;
	private String neighborhoodStuctureName;
	private String reason;
	private List<NeighborhoodChange> neighborhoodChanges = new ArrayList<NeighborhoodChange>();

	public void derive() {
		isImprovement = newCost > prevCost;
		diff = prevCost - newCost;
	}

	public int getDiff() {
		return diff;
	}

	public String getNeighborhoodStuctureName() {
		return neighborhoodStuctureName;
	}

	public int getNewCost() {
		return newCost;
	}

	public int getPrevCost() {
		return prevCost;
	}

	public String getReason() {
		return reason;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public void setImprovement(boolean isImprovement) {
		this.isImprovement = isImprovement;
	}

	public void setName(String neighborhoodStuctureName) {
		this.neighborhoodStuctureName = neighborhoodStuctureName;
	}

	public void setNewCost(int newCost) {
		this.newCost = newCost;
	}

	public void setPrevCost(int prevCost) {
		this.prevCost = prevCost;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public boolean isImprovement() {
		return isImprovement;
	}
	
	public List<NeighborhoodChange> getNeighborhoodChanges() {
		return neighborhoodChanges;
	}
}