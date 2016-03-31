package de.fuberlin.winfo.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class TestData {
	private static final int n = -1;
	public static File SMALL_SIZED_DEPOT_FILE;
	public static File VEHICLES_FILE;
	public static File SMALL_SIZED_USECASE_FILE;
	public static File SMALL_SIZED_CUSTOMER_FILE;
	public static File SMALL_SIZED_RESPONSE_MATRIX;
	public static File LARGE_SIZED_USECASE_FILE;
	public static File LARGE_SIZED_DEPOT_FILE;
	public static File LARGE_SIZED_CUSTOMER_FILE;
	public static File LARGE_SIZED_RESPONSE_MATRIX;
	public static File TEST_RESPONSE_MATRIX;
	public static File LARGE_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS;
	public static File SMALL_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS;

	static {
		try {
			String path = Paths.get("..", "..", "data").toFile().getCanonicalPath();
			/*
			 * Common
			 */
			VEHICLES_FILE = Paths.get(path.toString(), "vehicles.csv").toFile();
			TEST_RESPONSE_MATRIX = Paths.get(path.toString(), "test.json").toFile();

			/*
			 * Small-sized
			 */
			String smallSized = "small-sized";
			SMALL_SIZED_DEPOT_FILE = Paths.get(path.toString(), smallSized, "depot.csv").toFile();
			SMALL_SIZED_CUSTOMER_FILE = Paths.get(path.toString(), smallSized, "customer.csv").toFile();
			SMALL_SIZED_RESPONSE_MATRIX = Paths.get(path.toString(), smallSized, "dm.json").toFile();
			SMALL_SIZED_USECASE_FILE = Paths.get(path.toString(), smallSized, "usecase.csv").toFile();
			SMALL_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS = Paths
					.get(path.toString(), smallSized, "zmiedges.ser.zip").toFile();
			/*
			 * Large-sized
			 */

			String largeSized = "large-sized";
			LARGE_SIZED_DEPOT_FILE = Paths.get(path.toString(), largeSized, "depot.csv").toFile();
			LARGE_SIZED_CUSTOMER_FILE = Paths.get(path.toString(), largeSized, "customer.csv").toFile();
			LARGE_SIZED_USECASE_FILE = Paths.get(path.toString(), largeSized, "usecase.csv").toFile();
			LARGE_SIZED_RESPONSE_MATRIX = Paths.get(path.toString(), largeSized, "dm.json").toFile();
			LARGE_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS = Paths
					.get(path.toString(), largeSized, "zmiedges.ser.zip").toFile();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static InputData inputData = new SampleInputDataImpl(false, 0, n);

}
