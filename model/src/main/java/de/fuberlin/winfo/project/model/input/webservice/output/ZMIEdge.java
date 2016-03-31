package de.fuberlin.winfo.project.model.input.webservice.output;

import java.io.Serializable;

public class ZMIEdge implements Serializable {
	int originId;
	int destId;
	int distance;
	int time;

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
}
