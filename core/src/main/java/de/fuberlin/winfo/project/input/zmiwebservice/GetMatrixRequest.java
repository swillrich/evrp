package de.fuberlin.winfo.project.input.zmiwebservice;

import java.util.List;

import de.fuberlin.winfo.project.model.network.Locatable;

public class GetMatrixRequest extends MatrixRequest {
	public GetMatrixRequest(List<Locatable> locatables) {
		super(locatables);
	}

	@Override
	public String getPath() {
		return "matrix?mode=car_fastest&applicationKey=" + getZMI_APPLICATION_KEY();
	}

	@Override
	public String getParameter() {
		return "&points=" + pointsToText();
	}

	@Override
	public String getRequestMethod() {
		return "GET";
	}
}
