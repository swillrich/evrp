package de.fuberlin.winfo.project.input.zmiwebservice;

import java.io.FileInputStream;
import java.util.List;

import de.fuberlin.winfo.project.TestData;
import de.fuberlin.winfo.project.input.ZMIJson;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;

public class JSONDistanceMatrix {
	public void deserializeAndSerializeAsZip() throws Exception {
		FileInputStream stream = new FileInputStream(TestData.LARGE_SIZED_RESPONSE_MATRIX);
		ZMIJson.getZMIEdgesFromJSONInputStream(stream, TestData.LARGE_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS);
	}

	public void deserialize() throws Exception {
		FileInputStream stream = new FileInputStream(TestData.SMALL_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS);
		List<ZMIEdge> zmiEdges = ZMIJson.getZMIEdgesFromSerializedAndZippedPojos(stream);
		System.out.println(zmiEdges.size() + " edges");
	}
	
	public static void main(String[] args) throws Exception {
		new JSONDistanceMatrix().deserializeAndSerializeAsZip();
	}
}
