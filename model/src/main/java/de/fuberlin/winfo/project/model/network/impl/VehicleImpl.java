/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Vehicle;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getMaxCapacatyPayLoadInKg <em>Max Capacaty Pay Load In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getMaxReachInMeter <em>Max Reach In Meter</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getChangeBatteryTime <em>Change Battery Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getBatteryType <em>Battery Type</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getBatteryCapacityInWh <em>Battery Capacity In Wh</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getOperatingCostsPerMeter <em>Operating Costs Per Meter</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getDriverCostsPerHour <em>Driver Costs Per Hour</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getTransshipmentFixCostsEuro <em>Transshipment Fix Costs Euro</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getTranshipmentTimeInMinutes <em>Transhipment Time In Minutes</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getPayLoadDependingConsumptionRate <em>Pay Load Depending Consumption Rate</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VehicleImpl extends MinimalEObjectImpl.Container implements Vehicle {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxCapacatyPayLoadInKg() <em>Max Capacaty Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCapacatyPayLoadInKg()
	 * @generated
	 * @ordered
	 */
	protected static final double MAX_CAPACATY_PAY_LOAD_IN_KG_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMaxCapacatyPayLoadInKg() <em>Max Capacaty Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxCapacatyPayLoadInKg()
	 * @generated
	 * @ordered
	 */
	protected double maxCapacatyPayLoadInKg = MAX_CAPACATY_PAY_LOAD_IN_KG_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxReachInMeter() <em>Max Reach In Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxReachInMeter()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_REACH_IN_METER_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxReachInMeter() <em>Max Reach In Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxReachInMeter()
	 * @generated
	 * @ordered
	 */
	protected int maxReachInMeter = MAX_REACH_IN_METER_EDEFAULT;

	/**
	 * The default value of the '{@link #getChangeBatteryTime() <em>Change Battery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeBatteryTime()
	 * @generated
	 * @ordered
	 */
	protected static final long CHANGE_BATTERY_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getChangeBatteryTime() <em>Change Battery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getChangeBatteryTime()
	 * @generated
	 * @ordered
	 */
	protected long changeBatteryTime = CHANGE_BATTERY_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getBatteryType() <em>Battery Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatteryType()
	 * @generated
	 * @ordered
	 */
	protected static final String BATTERY_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getBatteryType() <em>Battery Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatteryType()
	 * @generated
	 * @ordered
	 */
	protected String batteryType = BATTERY_TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getBatteryCapacityInWh() <em>Battery Capacity In Wh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatteryCapacityInWh()
	 * @generated
	 * @ordered
	 */
	protected static final int BATTERY_CAPACITY_IN_WH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getBatteryCapacityInWh() <em>Battery Capacity In Wh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBatteryCapacityInWh()
	 * @generated
	 * @ordered
	 */
	protected int batteryCapacityInWh = BATTERY_CAPACITY_IN_WH_EDEFAULT;

	/**
	 * The default value of the '{@link #getOperatingCostsPerMeter() <em>Operating Costs Per Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingCostsPerMeter()
	 * @generated
	 * @ordered
	 */
	protected static final double OPERATING_COSTS_PER_METER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getOperatingCostsPerMeter() <em>Operating Costs Per Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperatingCostsPerMeter()
	 * @generated
	 * @ordered
	 */
	protected double operatingCostsPerMeter = OPERATING_COSTS_PER_METER_EDEFAULT;

	/**
	 * The default value of the '{@link #getDriverCostsPerHour() <em>Driver Costs Per Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverCostsPerHour()
	 * @generated
	 * @ordered
	 */
	protected static final double DRIVER_COSTS_PER_HOUR_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getDriverCostsPerHour() <em>Driver Costs Per Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDriverCostsPerHour()
	 * @generated
	 * @ordered
	 */
	protected double driverCostsPerHour = DRIVER_COSTS_PER_HOUR_EDEFAULT;

	/**
	 * The default value of the '{@link #getTransshipmentFixCostsEuro() <em>Transshipment Fix Costs Euro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransshipmentFixCostsEuro()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSSHIPMENT_FIX_COSTS_EURO_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTransshipmentFixCostsEuro() <em>Transshipment Fix Costs Euro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransshipmentFixCostsEuro()
	 * @generated
	 * @ordered
	 */
	protected double transshipmentFixCostsEuro = TRANSSHIPMENT_FIX_COSTS_EURO_EDEFAULT;

	/**
	 * The default value of the '{@link #getTranshipmentTimeInMinutes() <em>Transhipment Time In Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranshipmentTimeInMinutes()
	 * @generated
	 * @ordered
	 */
	protected static final double TRANSHIPMENT_TIME_IN_MINUTES_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getTranshipmentTimeInMinutes() <em>Transhipment Time In Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranshipmentTimeInMinutes()
	 * @generated
	 * @ordered
	 */
	protected double transhipmentTimeInMinutes = TRANSHIPMENT_TIME_IN_MINUTES_EDEFAULT;

	/**
	 * The default value of the '{@link #getPayLoadDependingConsumptionRate() <em>Pay Load Depending Consumption Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayLoadDependingConsumptionRate()
	 * @generated
	 * @ordered
	 */
	protected static final double PAY_LOAD_DEPENDING_CONSUMPTION_RATE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPayLoadDependingConsumptionRate() <em>Pay Load Depending Consumption Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPayLoadDependingConsumptionRate()
	 * @generated
	 * @ordered
	 */
	protected double payLoadDependingConsumptionRate = PAY_LOAD_DEPENDING_CONSUMPTION_RATE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VehicleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.VEHICLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getMaxCapacatyPayLoadInKg() {
		return maxCapacatyPayLoadInKg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxCapacatyPayLoadInKg(double newMaxCapacatyPayLoadInKg) {
		double oldMaxCapacatyPayLoadInKg = maxCapacatyPayLoadInKg;
		maxCapacatyPayLoadInKg = newMaxCapacatyPayLoadInKg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG, oldMaxCapacatyPayLoadInKg, maxCapacatyPayLoadInKg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxReachInMeter() {
		return maxReachInMeter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxReachInMeter(int newMaxReachInMeter) {
		int oldMaxReachInMeter = maxReachInMeter;
		maxReachInMeter = newMaxReachInMeter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__MAX_REACH_IN_METER, oldMaxReachInMeter, maxReachInMeter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getChangeBatteryTime() {
		return changeBatteryTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setChangeBatteryTime(long newChangeBatteryTime) {
		long oldChangeBatteryTime = changeBatteryTime;
		changeBatteryTime = newChangeBatteryTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__CHANGE_BATTERY_TIME, oldChangeBatteryTime, changeBatteryTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getBatteryType() {
		return batteryType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBatteryType(String newBatteryType) {
		String oldBatteryType = batteryType;
		batteryType = newBatteryType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__BATTERY_TYPE, oldBatteryType, batteryType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBatteryCapacityInWh() {
		return batteryCapacityInWh;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBatteryCapacityInWh(int newBatteryCapacityInWh) {
		int oldBatteryCapacityInWh = batteryCapacityInWh;
		batteryCapacityInWh = newBatteryCapacityInWh;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__BATTERY_CAPACITY_IN_WH, oldBatteryCapacityInWh, batteryCapacityInWh));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getOperatingCostsPerMeter() {
		return operatingCostsPerMeter;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperatingCostsPerMeter(double newOperatingCostsPerMeter) {
		double oldOperatingCostsPerMeter = operatingCostsPerMeter;
		operatingCostsPerMeter = newOperatingCostsPerMeter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__OPERATING_COSTS_PER_METER, oldOperatingCostsPerMeter, operatingCostsPerMeter));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getDriverCostsPerHour() {
		return driverCostsPerHour;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDriverCostsPerHour(double newDriverCostsPerHour) {
		double oldDriverCostsPerHour = driverCostsPerHour;
		driverCostsPerHour = newDriverCostsPerHour;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__DRIVER_COSTS_PER_HOUR, oldDriverCostsPerHour, driverCostsPerHour));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTransshipmentFixCostsEuro() {
		return transshipmentFixCostsEuro;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransshipmentFixCostsEuro(double newTransshipmentFixCostsEuro) {
		double oldTransshipmentFixCostsEuro = transshipmentFixCostsEuro;
		transshipmentFixCostsEuro = newTransshipmentFixCostsEuro;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO, oldTransshipmentFixCostsEuro, transshipmentFixCostsEuro));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getTranshipmentTimeInMinutes() {
		return transhipmentTimeInMinutes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTranshipmentTimeInMinutes(double newTranshipmentTimeInMinutes) {
		double oldTranshipmentTimeInMinutes = transhipmentTimeInMinutes;
		transhipmentTimeInMinutes = newTranshipmentTimeInMinutes;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES, oldTranshipmentTimeInMinutes, transhipmentTimeInMinutes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPayLoadDependingConsumptionRate() {
		return payLoadDependingConsumptionRate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPayLoadDependingConsumptionRate(double newPayLoadDependingConsumptionRate) {
		double oldPayLoadDependingConsumptionRate = payLoadDependingConsumptionRate;
		payLoadDependingConsumptionRate = newPayLoadDependingConsumptionRate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE, oldPayLoadDependingConsumptionRate, payLoadDependingConsumptionRate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetworkPackage.VEHICLE__ID:
				return getId();
			case NetworkPackage.VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG:
				return getMaxCapacatyPayLoadInKg();
			case NetworkPackage.VEHICLE__MAX_REACH_IN_METER:
				return getMaxReachInMeter();
			case NetworkPackage.VEHICLE__CHANGE_BATTERY_TIME:
				return getChangeBatteryTime();
			case NetworkPackage.VEHICLE__BATTERY_TYPE:
				return getBatteryType();
			case NetworkPackage.VEHICLE__BATTERY_CAPACITY_IN_WH:
				return getBatteryCapacityInWh();
			case NetworkPackage.VEHICLE__OPERATING_COSTS_PER_METER:
				return getOperatingCostsPerMeter();
			case NetworkPackage.VEHICLE__DRIVER_COSTS_PER_HOUR:
				return getDriverCostsPerHour();
			case NetworkPackage.VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO:
				return getTransshipmentFixCostsEuro();
			case NetworkPackage.VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES:
				return getTranshipmentTimeInMinutes();
			case NetworkPackage.VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE:
				return getPayLoadDependingConsumptionRate();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NetworkPackage.VEHICLE__ID:
				setId((String)newValue);
				return;
			case NetworkPackage.VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG:
				setMaxCapacatyPayLoadInKg((Double)newValue);
				return;
			case NetworkPackage.VEHICLE__MAX_REACH_IN_METER:
				setMaxReachInMeter((Integer)newValue);
				return;
			case NetworkPackage.VEHICLE__CHANGE_BATTERY_TIME:
				setChangeBatteryTime((Long)newValue);
				return;
			case NetworkPackage.VEHICLE__BATTERY_TYPE:
				setBatteryType((String)newValue);
				return;
			case NetworkPackage.VEHICLE__BATTERY_CAPACITY_IN_WH:
				setBatteryCapacityInWh((Integer)newValue);
				return;
			case NetworkPackage.VEHICLE__OPERATING_COSTS_PER_METER:
				setOperatingCostsPerMeter((Double)newValue);
				return;
			case NetworkPackage.VEHICLE__DRIVER_COSTS_PER_HOUR:
				setDriverCostsPerHour((Double)newValue);
				return;
			case NetworkPackage.VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO:
				setTransshipmentFixCostsEuro((Double)newValue);
				return;
			case NetworkPackage.VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES:
				setTranshipmentTimeInMinutes((Double)newValue);
				return;
			case NetworkPackage.VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE:
				setPayLoadDependingConsumptionRate((Double)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case NetworkPackage.VEHICLE__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG:
				setMaxCapacatyPayLoadInKg(MAX_CAPACATY_PAY_LOAD_IN_KG_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__MAX_REACH_IN_METER:
				setMaxReachInMeter(MAX_REACH_IN_METER_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__CHANGE_BATTERY_TIME:
				setChangeBatteryTime(CHANGE_BATTERY_TIME_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__BATTERY_TYPE:
				setBatteryType(BATTERY_TYPE_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__BATTERY_CAPACITY_IN_WH:
				setBatteryCapacityInWh(BATTERY_CAPACITY_IN_WH_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__OPERATING_COSTS_PER_METER:
				setOperatingCostsPerMeter(OPERATING_COSTS_PER_METER_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__DRIVER_COSTS_PER_HOUR:
				setDriverCostsPerHour(DRIVER_COSTS_PER_HOUR_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO:
				setTransshipmentFixCostsEuro(TRANSSHIPMENT_FIX_COSTS_EURO_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES:
				setTranshipmentTimeInMinutes(TRANSHIPMENT_TIME_IN_MINUTES_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE:
				setPayLoadDependingConsumptionRate(PAY_LOAD_DEPENDING_CONSUMPTION_RATE_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case NetworkPackage.VEHICLE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NetworkPackage.VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG:
				return maxCapacatyPayLoadInKg != MAX_CAPACATY_PAY_LOAD_IN_KG_EDEFAULT;
			case NetworkPackage.VEHICLE__MAX_REACH_IN_METER:
				return maxReachInMeter != MAX_REACH_IN_METER_EDEFAULT;
			case NetworkPackage.VEHICLE__CHANGE_BATTERY_TIME:
				return changeBatteryTime != CHANGE_BATTERY_TIME_EDEFAULT;
			case NetworkPackage.VEHICLE__BATTERY_TYPE:
				return BATTERY_TYPE_EDEFAULT == null ? batteryType != null : !BATTERY_TYPE_EDEFAULT.equals(batteryType);
			case NetworkPackage.VEHICLE__BATTERY_CAPACITY_IN_WH:
				return batteryCapacityInWh != BATTERY_CAPACITY_IN_WH_EDEFAULT;
			case NetworkPackage.VEHICLE__OPERATING_COSTS_PER_METER:
				return operatingCostsPerMeter != OPERATING_COSTS_PER_METER_EDEFAULT;
			case NetworkPackage.VEHICLE__DRIVER_COSTS_PER_HOUR:
				return driverCostsPerHour != DRIVER_COSTS_PER_HOUR_EDEFAULT;
			case NetworkPackage.VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO:
				return transshipmentFixCostsEuro != TRANSSHIPMENT_FIX_COSTS_EURO_EDEFAULT;
			case NetworkPackage.VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES:
				return transhipmentTimeInMinutes != TRANSHIPMENT_TIME_IN_MINUTES_EDEFAULT;
			case NetworkPackage.VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE:
				return payLoadDependingConsumptionRate != PAY_LOAD_DEPENDING_CONSUMPTION_RATE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", maxCapacatyPayLoadInKg: ");
		result.append(maxCapacatyPayLoadInKg);
		result.append(", maxReachInMeter: ");
		result.append(maxReachInMeter);
		result.append(", changeBatteryTime: ");
		result.append(changeBatteryTime);
		result.append(", batteryType: ");
		result.append(batteryType);
		result.append(", batteryCapacityInWh: ");
		result.append(batteryCapacityInWh);
		result.append(", operatingCostsPerMeter: ");
		result.append(operatingCostsPerMeter);
		result.append(", driverCostsPerHour: ");
		result.append(driverCostsPerHour);
		result.append(", transshipmentFixCostsEuro: ");
		result.append(transshipmentFixCostsEuro);
		result.append(", transhipmentTimeInMinutes: ");
		result.append(transhipmentTimeInMinutes);
		result.append(", payLoadDependingConsumptionRate: ");
		result.append(payLoadDependingConsumptionRate);
		result.append(')');
		return result.toString();
	}

} //VehicleImpl
