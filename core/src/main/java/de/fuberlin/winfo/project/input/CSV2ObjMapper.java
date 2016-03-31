package de.fuberlin.winfo.project.input;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;

import de.fuberlin.winfo.project.InputData;
import de.fuberlin.winfo.project.StaticLocatables;
import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.Order;
import de.fuberlin.winfo.project.model.network.Vehicle;
import de.fuberlin.winfo.project.model.network.impl.NetworkFactoryImpl;
import de.fuberlin.winfo.project.model.network.solution.UseCase;
import de.fuberlin.winfo.project.model.network.solution.impl.SolutionFactoryImpl;

/**
 * @author willrich
 *
 *         The use of this class is transforming incoming CSV files into
 *         appropriate Domain Objects.
 */
public class CSV2ObjMapper {
	private NetworkFactoryImpl networkFactory = new NetworkFactoryImpl();
	private SolutionFactoryImpl solutionFactory = new SolutionFactoryImpl();

	private List<Vehicle> vehicleList;
	private List<UseCase> useCaseList;

	public List<UseCase> getUseCaseList() {
		return useCaseList;
	}

	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public StaticLocatables getLocatables() {
		return locatables;
	}

	private StaticLocatables locatables = new StaticLocatables();

	/**
	 * Transforms an incoming Vehicle CSV File into a certain Vehicle Domain
	 * Object for each line where an instance is existing.
	 * 
	 * @throws FileNotFoundException
	 */
	private List<Vehicle> getVehicles(File vehilceCSV) throws Exception {
		final List<Vehicle> list = new ArrayList<Vehicle>();
		new AbstractCSVInput(vehilceCSV, null, true, '"') {

			@Override
			public void nextLine(String[] line) {
				Vehicle vehicle = networkFactory.createVehicle();
				vehicle.setId(line[0]);
				vehicle.setBatteryType(line[2]);
				vehicle.setMaxReachInMeter(asInt(line[3]) * 1000);
				vehicle.setBatteryCapacityInWh(asInt(line[4]));
				vehicle.setMaxCapacatyPayLoadInKg(asDouble(line[5]) * 1000);
				vehicle.setChangeBatteryTime(asInt(line[6]));
				vehicle.setOperatingCostsPerMeter(asDouble(line[7]) / 1000);
				vehicle.setDriverCostsPerHour(asDouble(line[8]) * 60);
				vehicle.setTranshipmentTimeInMinutes(asDouble(line[9]));
				vehicle.setPayLoadDependingConsumptionRate(asDouble(line[10]));
				list.add(vehicle);
			}
		};
		return list;
	}

	private void addCustomers(File customerCSV) throws Exception {
		new AbstractCSVInput(customerCSV, null, true, '"') {

			@Override
			public void nextLine(String[] line) {
				double latidute = asDouble(line[1]);
				double longitude = asDouble(line[2]);
				Iterator<Locatable> iterator = locatables.findLocatable(latidute, longitude, Customer.class);
				if (!iterator.hasNext()) {
					Customer customer = networkFactory.createCustomer();
					customer.setLatitude(asDouble(line[1]));
					customer.setLongitude(asDouble(line[2]));
					customer.setServiceTimeInSec(-1);
					addOrder(customer, line);
					locatables.addNewStaticLocatable(customer);
				} else {
					Customer customer = (Customer) iterator.next();
					addOrder(customer, line);
				}
			}

			private void addOrder(Customer customer, String[] line) {
				Order newOrder = networkFactory.createOrder();
				newOrder.setId(line[0]);
				String[] split = line[3].split(",");
				newOrder.setNeedAsWeight(asDouble(split[0]));
				newOrder.setNeedAsVolume(asDouble(split[1]));
				newOrder.setTimeWindow(getDuration(line[5]));
				newOrder.setStandingTimeInSec(asInt(line[7]));
				customer.getOwnedOrders().add(newOrder);
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
				depot.setPlannedPeriod(getDuration(line[3]));
				depot.setMaxTourLength(asInt(line[4]));
				depot.setFixPlaceTimeIfMultipleOperations(asInt(line[5]));
				depot.setMaxEmployment(asInt(line[6]));
				locatables.addNewStaticLocatable(depot);
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
	final List<UseCase> list = new ArrayList<UseCase>();

	private List<UseCase> getUseCases(File useCaseCSV, List<Vehicle> vehicles) throws Exception {

		new AbstractCSVInput(useCaseCSV, null, true, '"') {
			@Override
			public void nextLine(String[] line) {
				UseCase useCase = solutionFactory.createUseCase();
				useCase.setId(asInt(line[0]));
				for (String vehicleId : getAsArr(line[1])) {
					Vehicle vehicle = vehicles.stream().filter(v -> v.getId().equals(vehicleId)).iterator().next();
					useCase.getVehicles().add(EcoreUtil.copy(vehicle));
				}
				for (String cS : getAsArr(line[4])) {
					Depot transhipmentPoint = networkFactory.createDepot();
					configureAsAdditionalService(cS, transhipmentPoint);
					useCase.getTranshipmentPoints().add(transhipmentPoint);
				}
				useCase.setMaxTourLengthInSec(asInt(line[5]));
				useCase.setStorageCostsPerKgPerSec(asDouble(line[6]));
				useCase.setName(line[7]);
				list.add(useCase);
			}
		};
		return list;
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
		Iterator<Locatable> iterator = locatables.findLocatable(latitudeAsDouble, longitudeAsDouble, Customer.class);
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

	static public CSV2ObjMapper inflateByCSV(InputData inputData) throws Exception {
		CSV2ObjMapper csv2ObjMapper = new CSV2ObjMapper();
		csv2ObjMapper.vehicleList = csv2ObjMapper.getVehicles(inputData.getVehicleFile());
		csv2ObjMapper.addCustomers(inputData.getCustomerFile());
		csv2ObjMapper.addDepots(inputData.getDepotFile());
		csv2ObjMapper.useCaseList = csv2ObjMapper.getUseCases(inputData.getUseCaseFile(), csv2ObjMapper.vehicleList);
		return csv2ObjMapper;
	}
}
