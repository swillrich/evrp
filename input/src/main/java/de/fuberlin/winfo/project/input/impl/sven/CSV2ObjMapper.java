package de.fuberlin.winfo.project.input.impl.sven;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.Locatables;
import de.fuberlin.winfo.project.input.helper.AbstractCSVInput;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.UseCase;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;

/**
 * @author willrich
 *
 *         The use of this class is transforming incoming CSV files into
 *         appropriate Domain Objects.
 */
public class CSV2ObjMapper {

	private NetworkFactoryImpl networkFactory = new NetworkFactoryImpl();
	private Locatables locatables = new Locatables();
	final List<UseCase> useCaseList = new ArrayList<UseCase>();
	private List<Vehicle> vehicleList = new ArrayList<Vehicle>();

	public CSV2ObjMapper(File vehicleFile, File customerFile, File depotFile, File useCaseFile) throws Exception {
		addVehicles(vehicleFile);
		addDepots(depotFile);
		addCustomers(customerFile);
		addUseCases(useCaseFile, vehicleList);
	}

	public Locatables getLocatables() {
		return locatables;
	}

	public List<UseCase> getUseCaseList() {
		return useCaseList;
	}

	/**
	 * Transforms an incoming Vehicle CSV File into a certain Vehicle Domain
	 * Object for each line where an instance is existing.
	 * 
	 * @throws FileNotFoundException
	 */
	private void addVehicles(File vehilceCSV) throws Exception {
		new AbstractCSVInput(vehilceCSV, null, true, '"') {

			@Override
			public void nextLine(String[] line) {
				Vehicle vehicle = networkFactory.createVehicle();
				vehicle.setId(line[0]);
				vehicle.setCargoWeightInKg(asInt(line[1]));
				vehicle.setMaxPayLoadInKg(asInt(line[2]));
				vehicle.setMaxBatteryCapacityInWH(asInt(line[3]));
				vehicleList.add(vehicle);
			}
		};
	}

	private void addCustomers(File customerCSV) throws Exception {
		new AbstractCSVInput(customerCSV, null, true, '"') {

			@Override
			public void nextLine(String[] line) {
				double latidute = asDouble(line[1]);
				double longitude = asDouble(line[2]);
				Iterator<Locatable> iterator = locatables.findLocatable(latidute, longitude);
				if (!iterator.hasNext()) {
					Customer customer = networkFactory.createCustomer();
					customer.setLatitude(asDouble(line[1]));
					customer.setLongitude(asDouble(line[2]));
					customer.setServiceTimeInSec(-1);
					addOrder(customer, line);
					locatables.addNewLocatable(customer);
				} else {
					Customer customer = (Customer) iterator.next();
					addOrder(customer, line);
				}
			}

			private void addOrder(Customer customer, String[] line) {
				Order newOrder = networkFactory.createOrder();
				newOrder.setOrderId(line[0]);
				String[] split = line[3].split(",");
				newOrder.setWeight(asDouble(split[0]));
				newOrder.setVolume(asDouble(split[1]));
				newOrder.setTimeWindow(getDuration(line[5]));
				newOrder.setStandingTimeInSec(asInt(line[7]));
				newOrder.setReceiver(customer);
				customer.getOrders().add(newOrder);
			}
		};
	}

	private void addDepots(File depotCSV) throws Exception {
		new AbstractCSVInput(depotCSV, null, true, '"') {

			@Override
			public void nextLine(String[] line) {
				Depot depot = networkFactory.createDepot();
				depot.setLatitude(asDouble(line[0]));
				depot.setLongitude(asDouble(line[1]));
				depot.setTimeWindow(getDuration(line[2]));
				depot.setMaxTourLength(asInt(line[4]));
				depot.setFixPlaceTimeIfMultipleOperations(asInt(line[5]));
				depot.setMaxEmployment(asInt(line[6]));
				locatables.addNewLocatable(depot);
			}
		};
	}

	/**
	 * Transforms an incoming UseCase CSV File into a certain UseCase Domain
	 * Object for each line where an instance is existing.
	 * 
	 * @param vehicles
	 * 
	 * @throws FileNotFoundException
	 */

	private void addUseCases(File useCaseCSV, List<Vehicle> vehicles) throws Exception {

		new AbstractCSVInput(useCaseCSV, null, true, '"') {
			@Override
			public void nextLine(String[] line) {
				UseCase useCase = networkFactory.createUseCase();
				useCase.setId(asInt(line[0]));
				for (String vehicleId : getAsArr(line[1])) {
					Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(vehicleId)).iterator().next();
					useCase.getVehicles().add(EcoreUtil.copy(vehicle));
				}
				useCase.setMaxTourLengthInSec(asInt(line[5]));
				useCase.setName(line[7]);
				useCaseList.add(useCase);
			}
		};
	}

	private void configureAsAdditionalService(String cS, Locatable additionalService) {
		String[] langLot = cS.split(",");
		double latitudeAsDouble = asDouble(langLot[0]);
		double longitudeAsDouble = asDouble(langLot[1]);
		additionalService.setLatitude(latitudeAsDouble);
		additionalService.setLongitude(longitudeAsDouble);
	}

	public Locatable getCustomerByCoordinates(String lanLon) {
		String[] langLot = lanLon.split(",");
		double latitudeAsDouble = asDouble(langLot[0]);
		double longitudeAsDouble = asDouble(langLot[1]);
		Iterator<Locatable> iterator = locatables.findLocatable(latitudeAsDouble, longitudeAsDouble);
		if (iterator.hasNext()) {
			return iterator.next();
		} else {
			return null;
		}
	}

	/*
	 * Helper methods
	 */

	private Duration getDuration(String string) {
		String[] durationSrc = string.split(",");
		int start = asInt(durationSrc[0]);
		int end = asInt(durationSrc[1]);
		if (start == 0 && end == 0) {
			return null;
		}
		return getDuration(start, end);
	}

	private Duration getDuration(int start, int end) {
		Duration duration = networkFactory.createDuration();
		duration.setStartInSec(start);
		duration.setEndInSec(end);
		return duration;
	}

	private int asInt(String value) throws NumberFormatException {
		try {
			return Integer.valueOf(value);
		} catch (NumberFormatException e) {
			if (value.length() == 0) {
				return 0;
			} else {
				throw e;
			}
		}
	}

	private double asDouble(String value) throws NumberFormatException {
		try {
			return Double.valueOf(value);
		} catch (NumberFormatException e) {
			if (value.length() == 0) {
				return 0d;
			} else {
				throw e;
			}
		}
	}
}
