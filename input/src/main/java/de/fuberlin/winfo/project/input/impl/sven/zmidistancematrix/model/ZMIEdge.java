package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model;

import java.io.Serializable;

public class ZMIEdge implements Serializable {
	int originId;
	int destId;
	int distance;
	int time;
	int energyMax;
	int energyMin;

	public int getDestId() {
		return destId;
	}

	public int getDistance() {
		return distance;
	}

	public int getOriginId() {
		return originId;
	}

	public int getTime() {
		return time;
	}

	public void setDestId(int destId) {
		this.destId = destId;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public void setOriginId(int originId) {
		this.originId = originId;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getEnergyMax() {
		return energyMax;
	}

	public int getEnergyMin() {
		return energyMin;
	}

	public void setEnergyMax(int energyMax) {
		this.energyMax = energyMax;
	}

	public void setEnergyMin(int energyMin) {
		this.energyMin = energyMin;
	}
}
