/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Edge;

import de.fuberlin.winfo.project.model.network.solution.SolutionPackage;
import de.fuberlin.winfo.project.model.network.solution.UsedEdge;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Used Edge</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl#getEdge <em>Edge</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UsedEdgeImpl extends MinimalEObjectImpl.Container implements UsedEdge {
	/**
	 * The cached value of the '{@link #getEdge() <em>Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdge()
	 * @generated
	 * @ordered
	 */
	protected Edge edge;

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
	protected UsedEdgeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.USED_EDGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge getEdge() {
		if (edge != null && edge.eIsProxy()) {
			InternalEObject oldEdge = (InternalEObject)edge;
			edge = (Edge)eResolveProxy(oldEdge);
			if (edge != oldEdge) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SolutionPackage.USED_EDGE__EDGE, oldEdge, edge));
			}
		}
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge basicGetEdge() {
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEdge(Edge newEdge) {
		Edge oldEdge = edge;
		edge = newEdge;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USED_EDGE__EDGE, oldEdge, edge));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT, oldCurrentVehicleCargoWeight, currentVehicleCargoWeight));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionPackage.USED_EDGE__DURATION, oldDuration, newDuration);
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
				msgs = ((InternalEObject)duration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.USED_EDGE__DURATION, null, msgs);
			if (newDuration != null)
				msgs = ((InternalEObject)newDuration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.USED_EDGE__DURATION, null, msgs);
			msgs = basicSetDuration(newDuration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USED_EDGE__DURATION, newDuration, newDuration));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END, oldRemainingVehicleBatteryCapacityAtEnd, remainingVehicleBatteryCapacityAtEnd));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolutionPackage.USED_EDGE__DURATION:
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
			case SolutionPackage.USED_EDGE__EDGE:
				if (resolve) return getEdge();
				return basicGetEdge();
			case SolutionPackage.USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT:
				return getCurrentVehicleCargoWeight();
			case SolutionPackage.USED_EDGE__DURATION:
				return getDuration();
			case SolutionPackage.USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
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
			case SolutionPackage.USED_EDGE__EDGE:
				setEdge((Edge)newValue);
				return;
			case SolutionPackage.USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT:
				setCurrentVehicleCargoWeight((Double)newValue);
				return;
			case SolutionPackage.USED_EDGE__DURATION:
				setDuration((Duration)newValue);
				return;
			case SolutionPackage.USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
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
			case SolutionPackage.USED_EDGE__EDGE:
				setEdge((Edge)null);
				return;
			case SolutionPackage.USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT:
				setCurrentVehicleCargoWeight(CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT);
				return;
			case SolutionPackage.USED_EDGE__DURATION:
				setDuration((Duration)null);
				return;
			case SolutionPackage.USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
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
			case SolutionPackage.USED_EDGE__EDGE:
				return edge != null;
			case SolutionPackage.USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT:
				return currentVehicleCargoWeight != CURRENT_VEHICLE_CARGO_WEIGHT_EDEFAULT;
			case SolutionPackage.USED_EDGE__DURATION:
				return duration != null;
			case SolutionPackage.USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END:
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

} //UsedEdgeImpl
