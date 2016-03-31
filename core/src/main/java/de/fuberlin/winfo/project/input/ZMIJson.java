package de.fuberlin.winfo.project.input;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
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
import java.util.List;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.MappingJsonFactory;

import de.fuberlin.winfo.project.model.input.webservice.output.ZMIEdge;

public class ZMIJson {

	public static List<ZMIEdge> getZMIEdgesFromSerializedAndZippedPojos(InputStream stream)
			throws ClassNotFoundException, IOException {
		return (ArrayList<ZMIEdge>) new ObjectInputStream(new GZIPInputStream(stream)).readObject();
	}
	
	public static void saveZMIEdges(ArrayList<ZMIEdge> edges, OutputStream stream) throws IOException {
		ObjectOutputStream outputStream = new ObjectOutputStream(new GZIPOutputStream(stream));
		outputStream.writeObject(edges);
		outputStream.close();
	}

	public static List<ZMIEdge> getZMIEdgesFromJSONInputStream(InputStream stream, File outputFile)
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

	public static void saveAsZip(File matrix, String name) throws FileNotFoundException, IOException {
		FileInputStream stream = new FileInputStream(matrix);
		BufferedInputStream stream2 = new BufferedInputStream(stream);
		byte[] b = new byte[1024];
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		for (int i = stream2.read(b); i != -1; i = stream2.read(b)) {
			byteArrayOutputStream.write(b);
		}
		System.out.println(byteArrayOutputStream.size());
		GZIPOutputStream outputStream = new GZIPOutputStream(new FileOutputStream(new File(name)));
		outputStream.write(byteArrayOutputStream.toByteArray());
		System.out.println("done");
	}
}
