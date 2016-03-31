package de.fuberlin.winfo.project;

import java.io.File;
import java.nio.file.Paths;

public class SampleInputDataImpl implements InputData {

	private int algNr;

	private File customerFile;
	private File useCaseFile;
	private File depoFile;
	private File dm;
	private int n;

	public SampleInputDataImpl(boolean isSmallSized, int algNr, int n) {
		this.n = n;
		if (isSmallSized) {
			this.customerFile = TestData.SMALL_SIZED_CUSTOMER_FILE;
			this.depoFile = TestData.SMALL_SIZED_DEPOT_FILE;
			this.useCaseFile = TestData.SMALL_SIZED_USECASE_FILE;
			this.dm = TestData.SMALL_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS;
		} else {
			this.customerFile = TestData.LARGE_SIZED_CUSTOMER_FILE;
			this.depoFile = TestData.LARGE_SIZED_DEPOT_FILE;
			this.useCaseFile = TestData.LARGE_SIZED_USECASE_FILE;
			this.dm = TestData.LARGE_SIZED_RESPONSE_MATRIX_SERIALIZED_ZIPPED_POJOS;
		}

		this.algNr = algNr;
	}

	@Override
	public File getCustomerFile() {
		return this.customerFile;
	}

	@Override
	public File getVehicleFile() {
		return TestData.VEHICLES_FILE;
	}

	@Override
	public File getDepotFile() {
		return this.depoFile;
	}

	@Override
	public int getDesiredProcedure() {
		return algNr + 1;
	}

	@Override
	public String getVisualizationServer() {
		return "http://localhost:8080";
	}

	@Override
	public File getLogFile() {
		return Paths.get(".", "target", "log.log").toFile();
	}

	@Override
	public File getUseCaseFile() {
		return this.useCaseFile;
	}

	@Override
	public File getDistanceMatrixAsSerializedAndZippedPojo() throws Exception {
		return dm;
	}

	@Override
	public int getCustomerMaximum() {
		return n;
	}
}
