/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.UsedArc;
import de.fuberlin.winfo.project.model.network.Vehicle;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl#getTotalDistanceInM <em>Total Distance In M</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl#getTotalTimeInSec <em>Total Time In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl#getTotalVehicleBatteryConsumption <em>Total Vehicle Battery Consumption</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl#getWay <em>Way</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RouteImpl extends MinimalEObjectImpl.Container implements Route {
	/**
	 * The cached value of the '{@link #getVehicle() <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicle()
	 * @generated
	 * @ordered
	 */
	protected Vehicle vehicle;

	/**
	 * The default value of the '{@link #getTotalDistanceInM() <em>Total Distance In M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDistanceInM()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_DISTANCE_IN_M_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalDistanceInM() <em>Total Distance In M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDistanceInM()
	 * @generated
	 * @ordered
	 */
	protected long totalDistanceInM = TOTAL_DISTANCE_IN_M_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalTimeInSec() <em>Total Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int TOTAL_TIME_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTotalTimeInSec() <em>Total Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected int totalTimeInSec = TOTAL_TIME_IN_SEC_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalVehicleBatteryConsumption() <em>Total Vehicle Battery Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehicleBatteryConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalVehicleBatteryConsumption() <em>Total Vehicle Battery Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehicleBatteryConsumption()
	 * @generated
	 * @ordered
	 */
	protected long totalVehicleBatteryConsumption = TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getWay() <em>Way</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWay()
	 * @generated
	 * @ordered
	 */
	protected EList<UsedArc> way;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RouteImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.ROUTE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle getVehicle() {
		if (vehicle != null && vehicle.eIsProxy()) {
			InternalEObject oldVehicle = (InternalEObject)vehicle;
			vehicle = (Vehicle)eResolveProxy(oldVehicle);
			if (vehicle != oldVehicle) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkPackage.ROUTE__VEHICLE, oldVehicle, vehicle));
			}
		}
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vehicle basicGetVehicle() {
		return vehicle;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVehicle(Vehicle newVehicle) {
		Vehicle oldVehicle = vehicle;
		vehicle = newVehicle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ROUTE__VEHICLE, oldVehicle, vehicle));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalDistanceInM() {
		return totalDistanceInM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDistanceInM(long newTotalDistanceInM) {
		long oldTotalDistanceInM = totalDistanceInM;
		totalDistanceInM = newTotalDistanceInM;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ROUTE__TOTAL_DISTANCE_IN_M, oldTotalDistanceInM, totalDistanceInM));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTotalTimeInSec() {
		return totalTimeInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalTimeInSec(int newTotalTimeInSec) {
		int oldTotalTimeInSec = totalTimeInSec;
		totalTimeInSec = newTotalTimeInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ROUTE__TOTAL_TIME_IN_SEC, oldTotalTimeInSec, totalTimeInSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalVehicleBatteryConsumption() {
		return totalVehicleBatteryConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalVehicleBatteryConsumption(long newTotalVehicleBatteryConsumption) {
		long oldTotalVehicleBatteryConsumption = totalVehicleBatteryConsumption;
		totalVehicleBatteryConsumption = newTotalVehicleBatteryConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION, oldTotalVehicleBatteryConsumption, totalVehicleBatteryConsumption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UsedArc> getWay() {
		if (way == null) {
			way = new EObjectContainmentEList<UsedArc>(UsedArc.class, this, NetworkPackage.ROUTE__WAY);
		}
		return way;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.ROUTE__WAY:
				return ((InternalEList<?>)getWay()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetworkPackage.ROUTE__VEHICLE:
				if (resolve) return getVehicle();
				return basicGetVehicle();
			case NetworkPackage.ROUTE__TOTAL_DISTANCE_IN_M:
				return getTotalDistanceInM();
			case NetworkPackage.ROUTE__TOTAL_TIME_IN_SEC:
				return getTotalTimeInSec();
			case NetworkPackage.ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				return getTotalVehicleBatteryConsumption();
			case NetworkPackage.ROUTE__WAY:
				return getWay();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NetworkPackage.ROUTE__VEHICLE:
				setVehicle((Vehicle)newValue);
				return;
			case NetworkPackage.ROUTE__TOTAL_DISTANCE_IN_M:
				setTotalDistanceInM((Long)newValue);
				return;
			case NetworkPackage.ROUTE__TOTAL_TIME_IN_SEC:
				setTotalTimeInSec((Integer)newValue);
				return;
			case NetworkPackage.ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				setTotalVehicleBatteryConsumption((Long)newValue);
				return;
			case NetworkPackage.ROUTE__WAY:
				getWay().clear();
				getWay().addAll((Collection<? extends UsedArc>)newValue);
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
			case NetworkPackage.ROUTE__VEHICLE:
				setVehicle((Vehicle)null);
				return;
			case NetworkPackage.ROUTE__TOTAL_DISTANCE_IN_M:
				setTotalDistanceInM(TOTAL_DISTANCE_IN_M_EDEFAULT);
				return;
			case NetworkPackage.ROUTE__TOTAL_TIME_IN_SEC:
				setTotalTimeInSec(TOTAL_TIME_IN_SEC_EDEFAULT);
				return;
			case NetworkPackage.ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				setTotalVehicleBatteryConsumption(TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT);
				return;
			case NetworkPackage.ROUTE__WAY:
				getWay().clear();
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
			case NetworkPackage.ROUTE__VEHICLE:
				return vehicle != null;
			case NetworkPackage.ROUTE__TOTAL_DISTANCE_IN_M:
				return totalDistanceInM != TOTAL_DISTANCE_IN_M_EDEFAULT;
			case NetworkPackage.ROUTE__TOTAL_TIME_IN_SEC:
				return totalTimeInSec != TOTAL_TIME_IN_SEC_EDEFAULT;
			case NetworkPackage.ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				return totalVehicleBatteryConsumption != TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT;
			case NetworkPackage.ROUTE__WAY:
				return way != null && !way.isEmpty();
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
		result.append(" (totalDistanceInM: ");
		result.append(totalDistanceInM);
		result.append(", totalTimeInSec: ");
		result.append(totalTimeInSec);
		result.append(", totalVehicleBatteryConsumption: ");
		result.append(totalVehicleBatteryConsumption);
		result.append(')');
		return result.toString();
	}

} //RouteImpl
