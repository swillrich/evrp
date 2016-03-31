package de.fuberlin.winfo.project.input.zmiwebservice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import de.fuberlin.winfo.project.SampleInputDataImpl;
import de.fuberlin.winfo.project.StaticLocatables;
import de.fuberlin.winfo.project.TestData;
import de.fuberlin.winfo.project.input.CSV2ObjMapper;
import de.fuberlin.winfo.project.input.ZMIJson;
import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;

public class DMModifier {
	public static void main(String[] args) throws Exception {
		File file = TestData.SMALL_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS;
		SampleInputDataImpl inputData = new SampleInputDataImpl(true, 0, -1);
		StaticLocatables locatables = CSV2ObjMapper.inflateByCSV(inputData).getLocatables();
		locatables.print();
		System.out.println("PL Edges: " + locatables.size() + " and " + (int) Math.pow(locatables.size(), 2));
		List<ZMIEdge> list = ZMIJson.getZMIEdgesFromSerializedAndZippedPojos(new FileInputStream(file));

		for (int i = 0; true; i++) {
			if (list.size() <= i) {
				break;
			}
			ZMIEdge edge = list.get(i);
			if (edge.getOriginId() >= 1 && edge.getOriginId() <= 5) {
				list.remove(i--);
				continue;
			} else if (edge.getOriginId() > 5) {
				edge.setOriginId(edge.getOriginId() - 5);
			}
			if (edge.getDestId() >= 1 && edge.getDestId() <= 5) {
				list.remove(i--);
			} else if (edge.getDestId() > 5) {
				edge.setDestId(edge.getDestId() - 5);
			}
		}

		int nodes = (int) Math.sqrt(list.size());
		System.out.println("IS Edges: " + nodes + " and " + list.size());
		ZMIJson.saveZMIEdges(new ArrayList<ZMIEdge>(list), new FileOutputStream("dm.json.gzip"));
		List<ZMIEdge> list2 = ZMIJson.getZMIEdgesFromSerializedAndZippedPojos(new FileInputStream("dm.json.gzip"));
		System.out.println(list2.size());
	}
}
