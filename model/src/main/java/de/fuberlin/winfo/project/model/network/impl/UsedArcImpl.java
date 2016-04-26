/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.UsedArc;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Used Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl#getArc <em>Arc</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsedArcImpl extends MinimalEObjectImpl.Container implements UsedArc {
	/**
	 * The cached value of the '{@link #getArc() <em>Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getArc()
	 * @generated
	 * @ordered
	 */
	protected Arc arc;

	/**
	 * The default value of the '{@link #getCurrentVehicleCargoWeight() <em>Current Vehicle Cargo Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentVehicleCargoWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCurrentVehicleCargoWeight() <em>Current Vehicle Cargo Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCurrentVehicleCargoWeight()
	 * @generated
	 * @ordered
	 */
	protected double currentVehicleCargoWeight = CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDuration() <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDuration()
	 * @generated
	 * @ordered
	 */
	protected Duration duration;

	/**
	 * The default value of the '{@link #getRemainingVehicleBatteryCapacityAtEnd() <em>Remaining Vehicle Battery Capacity At End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingVehicleBatteryCapacityAtEnd()
	 * @generated
	 * @ordered
	 */
	protected static final int REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getRemainingVehicleBatteryCapacityAtEnd() <em>Remaining Vehicle Battery Capacity At End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemainingVehicleBatteryCapacityAtEnd()
	 * @generated
	 * @ordered
	 */
	protected int remainingVehicleBatteryCapacityAtEnd = REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UsedArcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.USED_ARC;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arc getArc() {
		if (arc != null && arc.eIsProxy()) {
			InternalEObject oldArc = (InternalEObject)arc;
			arc = (Arc)eResolveProxy(oldArc);
			if (arc != oldArc) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkPackage.USED_ARC__ARC, oldArc, arc));
			}
		}
		return arc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Arc basicGetArc() {
		return arc;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setArc(Arc newArc) {
		Arc oldArc = arc;
		arc = newArc;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.USED_ARC__ARC, oldArc, arc));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCurrentVehicleCargoWeight() {
		return currentVehicleCargoWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCurrentVehicleCargoWeight(double newCurrentVehicleCargoWeight) {
		double oldCurrentVehicleCargoWeight = currentVehicleCargoWeight;
		currentVehicleCargoWeight = newCurrentVehicleCargoWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT, oldCurrentVehicleCargoWeight, currentVehicleCargoWeight));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Duration getDuration() {
		return duration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDuration(Duration newDuration, NotificationChain msgs) {
		Duration oldDuration = duration;
		duration = newDuration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.USED_ARC__DURATION, oldDuration, newDuration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDuration(Duration newDuration) {
		if (newDuration != duration) {
			NotificationChain msgs = null;
			if (duration != null)
				msgs = ((InternalEObject)duration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.USED_ARC__DURATION, null, msgs);
			if (newDuration != null)
				msgs = ((InternalEObject)newDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.USED_ARC__DURATION, null, msgs);
			msgs = basicSetDuration(newDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.USED_ARC__DURATION, newDuration, newDuration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getRemainingVehicleBatteryCapacityAtEnd() {
		return remainingVehicleBatteryCapacityAtEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemainingVehicleBatteryCapacityAtEnd(int newRemainingVehicleBatteryCapacityAtEnd) {
		int oldRemainingVehicleBatteryCapacityAtEnd = remainingVehicleBatteryCapacityAtEnd;
		remainingVehicleBatteryCapacityAtEnd = newRemainingVehicleBatteryCapacityAtEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END, oldRemainingVehicleBatteryCapacityAtEnd, remainingVehicleBatteryCapacityAtEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.USED_ARC__DURATION:
				return basicSetDuration(null, msgs);
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
			case NetworkPackage.USED_ARC__ARC:
				if (resolve) return getArc();
				return basicGetArc();
			case NetworkPackage.USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT:
				return getCurrentVehicleCargoWeight();
			case NetworkPackage.USED_ARC__DURATION:
				return getDuration();
			case NetworkPackage.USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
				return getRemainingVehicleBatteryCapacityAtEnd();
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
			case NetworkPackage.USED_ARC__ARC:
				setArc((Arc)newValue);
				return;
			case NetworkPackage.USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT:
				setCurrentVehicleCargoWeight((Double)newValue);
				return;
			case NetworkPackage.USED_ARC__DURATION:
				setDuration((Duration)newValue);
				return;
			case NetworkPackage.USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
				setRemainingVehicleBatteryCapacityAtEnd((Integer)newValue);
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
			case NetworkPackage.USED_ARC__ARC:
				setArc((Arc)null);
				return;
			case NetworkPackage.USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT:
				setCurrentVehicleCargoWeight(CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT);
				return;
			case NetworkPackage.USED_ARC__DURATION:
				setDuration((Duration)null);
				return;
			case NetworkPackage.USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
				setRemainingVehicleBatteryCapacityAtEnd(REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END_EDEFAULT);
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
			case NetworkPackage.USED_ARC__ARC:
				return arc != null;
			case NetworkPackage.USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT:
				return currentVehicleCargoWeight != CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT;
			case NetworkPackage.USED_ARC__DURATION:
				return duration != null;
			case NetworkPackage.USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
				return remainingVehicleBatteryCapacityAtEnd != REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END_EDEFAULT;
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
		result.append(" (currentVehicleCargoWeight: ");
		result.append(currentVehicleCargoWeight);
		result.append(", remainingVehicleBatteryCapacityAtEnd: ");
		result.append(remainingVehicleBatteryCapacityAtEnd);
		result.append(')');
		return result.toString();
	}

} //UsedArcImpl
