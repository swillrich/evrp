package de.fuberlin.winfo.project.input.zmiwebservice;

import java.util.List;

import de.fuberlin.winfo.project.model.network.Locatable;

public abstract class MatrixRequest extends AbstractZMIWebserviceRequest {
	public MatrixRequest(List<Locatable> locatables) {
		this.locatables = locatables;
	}

	private List<Locatable> locatables;

	String pointsToText() {
		StringBuilder b = new StringBuilder();
		for (int i = 0; i < locatables.size(); i++) {
			Locatable locatable = locatables.get(i);
			String toAppend = locatable.getLatitude() + "," + locatable.getLongitude();
			b.append(toAppend);
			if (1 < locatables.size() - i) {
				b.append(";");
			}
		}
		return b.toString();
	}

	@Override
	public String getCustomizedMessage() {
		return "Requests with a total number of " + locatables.size() + " coordinates. Request Method is: "
				+ getRequestMethod();
	}
}
