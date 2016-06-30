package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.http;

import java.util.List;

import com.google.gson.Gson;

import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model.MatrixJsonRequest;
import de.fuberlin.winfo.project.model.network.Locatable;

public class HttpPostMatrixRequest extends HttpMatrixRequest {
	public HttpPostMatrixRequest(List<Locatable> locatables) {
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
		request.setMode("van_load_fastest");
		return new Gson().toJson(request);
	}

	@Override
	public String getRequestMethod() {
		return "POST";
	}
}
