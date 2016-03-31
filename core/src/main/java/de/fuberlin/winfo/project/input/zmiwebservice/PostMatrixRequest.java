package de.fuberlin.winfo.project.input.zmiwebservice;

import java.util.List;

import com.google.gson.Gson;

import de.fuberlin.winfo.project.model.input.webservice.MatrixJsonRequest;
import de.fuberlin.winfo.project.model.network.Locatable;

public class PostMatrixRequest extends MatrixRequest {
	public PostMatrixRequest(List<Locatable> locatables) {
		super(locatables);
	}

	@Override
	public String getPath() {
		return "matrix";
	}

	@Override
	public String getParameter() {
		String pointsToText = pointsToText();
		MatrixJsonRequest request = new MatrixJsonRequest();
		request.setPoints(pointsToText);
		request.setApplicationKey(getZMI_APPLICATION_KEY());
		request.setMode("car_fastest");
		return new Gson().toJson(request);
	}

	@Override
	public String getRequestMethod() {
		return "POST";
	}
}
