package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.http;

import java.util.List;

import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model.ZMIEdge;

public class DownloadMatrixRequest extends HttpAbstractZMIWebserviceRequest {

	/*
	 * 1454442133780 --> depot + all customer
	 */
	private String matrixId = "1454442133780";

	@Override
	public String getPath() {
		return "matrixInformation";
	}

	@Override
	public String getParameter() {
		return "?id=" + matrixId + "&applicationKey=" + getZMI_APPLICATION_KEY();
	}

	@Override
	public String getCustomizedMessage() {
		return "Receiving matix with id " + matrixId;
	}

	@Override
	public String getRequestMethod() {
		return "GET";
	}

	public static void main(String[] args) throws Exception {
		DownloadMatrixRequest receiveAvailableMatrixRequest = new DownloadMatrixRequest();
		List<ZMIEdge> edges = receiveAvailableMatrixRequest.execute().getZmiEdges();
		System.out.println("done");
	}

}
