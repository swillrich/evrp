package de.fuberlin.winfo.project.input.zmiwebservice;

import java.util.List;
import java.util.stream.Collectors;

import de.fuberlin.winfo.project.TestData;
import de.fuberlin.winfo.project.input.CSV2ObjMapper;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;
import de.fuberlin.winfo.project.model.network.Locatable;

public class DMComputationRequestExecuter {
	public static void executeRequestByGivenInput(List<Locatable> list) {
		try {
			MatrixRequest postRequest = new PostMatrixRequest(list);
			List<ZMIEdge> edges = postRequest.execute().getZmiEdges();
			System.out.println(edges.size() + " edges received");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		CSV2ObjMapper mapper = CSV2ObjMapper.inflateByCSV(TestData.inputData);
		mapper.getLocatables().stream().collect(Collectors.groupingBy(l -> l.getClass()))
				.forEach((k, v) -> System.out.println(k + " " + v.size()));
		executeRequestByGivenInput(mapper.getLocatables());
	}
}
