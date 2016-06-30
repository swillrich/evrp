package de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import de.fuberlin.winfo.project.input.impl.sven.zmidistancematrix.model.ZMIEdge;

public class ZMIJsonConverter {

	public static List<ZMIEdge> deseriaizeZippedZMIEdges(InputStream stream)
			throws ClassNotFoundException, IOException {
		return (ArrayList<ZMIEdge>) new ObjectInputStream(new GZIPInputStream(stream)).readObject();
	}

	public static void serializeAndZipZMIEdges(List<ZMIEdge> edges, OutputStream stream) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new GZIPOutputStream(stream));
		outputStream.writeObject(edges);
		outputStream.close();
	}

	public static List<ZMIEdge> deserializeJSON(InputStream stream, File outputFile)
			throws JsonParseException, IOException {
		List<ZMIEdge> zmiEdges = new ArrayList<ZMIEdge>();

		MappingJsonFactory factory = new MappingJsonFactory();
		JsonParser parser = factory.createParser(stream);

		// until routing matrix begins
		for (int i = 0; i < 13; i++) {
			parser.nextToken();
		}

		if (parser.nextToken() == JsonToken.START_ARRAY && parser.getCurrentName().equals("routingMatrix")) {
			// ["ORIGIN_ID","DESTINATION_ID","DISTANCE","TIME"]
			int counter = 0;
			parser.nextToken();
			parser.readValueAsTree();
			while (parser.nextToken() != JsonToken.END_ARRAY) {
				counter++;
				try {
					TreeNode tree = parser.readValueAsTree();
					String[] parts = tree.toString().substring(1, tree.toString().length() - 1).split(",");
					ZMIEdge zmiJsonEdges = new ZMIEdge();
					zmiJsonEdges.setOriginId(Integer.valueOf(parts[0]));
					zmiJsonEdges.setDestId(Integer.valueOf(parts[1]));
					zmiJsonEdges.setDistance(Integer.valueOf(parts[2]));
					zmiJsonEdges.setTime(Integer.valueOf(parts[3]));
					zmiJsonEdges.setEnergyMin(Integer.valueOf(parts[4]));
					zmiEdges.add(zmiJsonEdges);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		stream.close();
		if (outputFile == null) {
			return zmiEdges;
		}
		ObjectOutputStream streamWriter = new ObjectOutputStream(
				new GZIPOutputStream(new FileOutputStream(outputFile)));
		streamWriter.writeObject(zmiEdges);
		streamWriter.close();
		return zmiEdges;
	}
}
