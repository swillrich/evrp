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
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getMaxPayLoadInKg <em>Max Pay Load In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getCargoWeightInKg <em>Cargo Weight In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl#getMaxBatteryCapacityInWH <em>Max Battery Capacity In WH</em>}</li>
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
	 * The default value of the '{@link #getMaxPayLoadInKg() <em>Max Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxPayLoadInKg()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_PAY_LOAD_IN_KG_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxPayLoadInKg() <em>Max Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxPayLoadInKg()
	 * @generated
	 * @ordered
	 */
	protected int maxPayLoadInKg = MAX_PAY_LOAD_IN_KG_EDEFAULT;

	/**
	 * The default value of the '{@link #getCargoWeightInKg() <em>Cargo Weight In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCargoWeightInKg()
	 * @generated
	 * @ordered
	 */
	protected static final int CARGO_WEIGHT_IN_KG_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCargoWeightInKg() <em>Cargo Weight In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCargoWeightInKg()
	 * @generated
	 * @ordered
	 */
	protected int cargoWeightInKg = CARGO_WEIGHT_IN_KG_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxBatteryCapacityInWH() <em>Max Battery Capacity In WH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBatteryCapacityInWH()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_BATTERY_CAPACITY_IN_WH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxBatteryCapacityInWH() <em>Max Battery Capacity In WH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxBatteryCapacityInWH()
	 * @generated
	 * @ordered
	 */
	protected int maxBatteryCapacityInWH = MAX_BATTERY_CAPACITY_IN_WH_EDEFAULT;

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
	public int getMaxPayLoadInKg() {
		return maxPayLoadInKg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxPayLoadInKg(int newMaxPayLoadInKg) {
		int oldMaxPayLoadInKg = maxPayLoadInKg;
		maxPayLoadInKg = newMaxPayLoadInKg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__MAX_PAY_LOAD_IN_KG, oldMaxPayLoadInKg, maxPayLoadInKg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCargoWeightInKg() {
		return cargoWeightInKg;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCargoWeightInKg(int newCargoWeightInKg) {
		int oldCargoWeightInKg = cargoWeightInKg;
		cargoWeightInKg = newCargoWeightInKg;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__CARGO_WEIGHT_IN_KG, oldCargoWeightInKg, cargoWeightInKg));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxBatteryCapacityInWH() {
		return maxBatteryCapacityInWH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxBatteryCapacityInWH(int newMaxBatteryCapacityInWH) {
		int oldMaxBatteryCapacityInWH = maxBatteryCapacityInWH;
		maxBatteryCapacityInWH = newMaxBatteryCapacityInWH;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.VEHICLE__MAX_BATTERY_CAPACITY_IN_WH, oldMaxBatteryCapacityInWH, maxBatteryCapacityInWH));
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
			case NetworkPackage.VEHICLE__MAX_PAY_LOAD_IN_KG:
				return getMaxPayLoadInKg();
			case NetworkPackage.VEHICLE__CARGO_WEIGHT_IN_KG:
				return getCargoWeightInKg();
			case NetworkPackage.VEHICLE__MAX_BATTERY_CAPACITY_IN_WH:
				return getMaxBatteryCapacityInWH();
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
			case NetworkPackage.VEHICLE__MAX_PAY_LOAD_IN_KG:
				setMaxPayLoadInKg((Integer)newValue);
				return;
			case NetworkPackage.VEHICLE__CARGO_WEIGHT_IN_KG:
				setCargoWeightInKg((Integer)newValue);
				return;
			case NetworkPackage.VEHICLE__MAX_BATTERY_CAPACITY_IN_WH:
				setMaxBatteryCapacityInWH((Integer)newValue);
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
			case NetworkPackage.VEHICLE__MAX_PAY_LOAD_IN_KG:
				setMaxPayLoadInKg(MAX_PAY_LOAD_IN_KG_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__CARGO_WEIGHT_IN_KG:
				setCargoWeightInKg(CARGO_WEIGHT_IN_KG_EDEFAULT);
				return;
			case NetworkPackage.VEHICLE__MAX_BATTERY_CAPACITY_IN_WH:
				setMaxBatteryCapacityInWH(MAX_BATTERY_CAPACITY_IN_WH_EDEFAULT);
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
			case NetworkPackage.VEHICLE__MAX_PAY_LOAD_IN_KG:
				return maxPayLoadInKg != MAX_PAY_LOAD_IN_KG_EDEFAULT;
			case NetworkPackage.VEHICLE__CARGO_WEIGHT_IN_KG:
				return cargoWeightInKg != CARGO_WEIGHT_IN_KG_EDEFAULT;
			case NetworkPackage.VEHICLE__MAX_BATTERY_CAPACITY_IN_WH:
				return maxBatteryCapacityInWH != MAX_BATTERY_CAPACITY_IN_WH_EDEFAULT;
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
		result.append(", maxPayLoadInKg: ");
		result.append(maxPayLoadInKg);
		result.append(", cargoWeightInKg: ");
		result.append(cargoWeightInKg);
		result.append(", maxBatteryCapacityInWH: ");
		result.append(maxBatteryCapacityInWH);
		result.append(')');
		return result.toString();
	}

} //VehicleImpl
