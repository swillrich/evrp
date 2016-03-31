package de.fuberlin.winfo.project.input.zmiwebservice;

import java.util.List;

import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;

public class ReceiveAvailableMatrixRequest extends AbstractZMIWebserviceRequest {

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
		ReceiveAvailableMatrixRequest receiveAvailableMatrixRequest = new ReceiveAvailableMatrixRequest();
		List<ZMIEdge> edges = receiveAvailableMatrixRequest.execute().getZmiEdges();
		System.out.println("done");
	}

}
