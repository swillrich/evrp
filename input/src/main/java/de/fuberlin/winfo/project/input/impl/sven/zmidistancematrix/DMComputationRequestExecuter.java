package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix;

import java.util.List;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.input.impl.sven.ZMIVRPInput;
import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.http.HttpMatrixRequest;
import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.http.HttpPostMatrixRequest;
import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model.ZMIEdge;
import de.fuberlin.winfo.project.model.network.Locatable;

public class DMComputationRequestExecuter {
	public static void executeRequestByGivenInput(List<Locatable> list) {
		try {
			HttpMatrixRequest postRequest = new HttpPostMatrixRequest(list);
			List<ZMIEdge> edges = postRequest.execute().getZmiEdges();
			System.out.println(edges.size() + " edges received");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		ZMIVRPInput zmivrpInput = new ZMIVRPInput("");
		zmivrpInput.getLocatables().stream().collect(Collectors.groupingBy(l -> l.getClass()))
				.forEach((k, v) -> System.out.println(k + " " + v.size()));
		executeRequestByGivenInput(zmivrpInput.getLocatables());
	}
}
