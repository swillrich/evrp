/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getFixPlaceTimeIfMultipleOperations <em>Fix Place Time If Multiple Operations</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getPlannedPeriod <em>Planned Period</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getMaxTourLength <em>Max Tour Length</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getMaxEmployment <em>Max Employment</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getTimeWindow <em>Time Window</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getDeliveries <em>Deliveries</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepotImpl extends LocatableImpl implements Depot {
	/**
	 * The default value of the '{@link #getFixPlaceTimeIfMultipleOperations() <em>Fix Place Time If Multiple Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixPlaceTimeIfMultipleOperations()
	 * @generated
	 * @ordered
	 */
	protected static final int FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFixPlaceTimeIfMultipleOperations() <em>Fix Place Time If Multiple Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixPlaceTimeIfMultipleOperations()
	 * @generated
	 * @ordered
	 */
	protected int fixPlaceTimeIfMultipleOperations = FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getPlannedPeriod() <em>Planned Period</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPlannedPeriod()
	 * @generated
	 * @ordered
	 */
	protected Duration plannedPeriod;

	/**
	 * The default value of the '{@link #getMaxTourLength() <em>Max Tour Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTourLength()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_TOUR_LENGTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxTourLength() <em>Max Tour Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTourLength()
	 * @generated
	 * @ordered
	 */
	protected int maxTourLength = MAX_TOUR_LENGTH_EDEFAULT;

	/**
	 * The default value of the '{@link #getMaxEmployment() <em>Max Employment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEmployment()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EMPLOYMENT_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxEmployment() <em>Max Employment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxEmployment()
	 * @generated
	 * @ordered
	 */
	protected int maxEmployment = MAX_EMPLOYMENT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTimeWindow() <em>Time Window</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeWindow()
	 * @generated
	 * @ordered
	 */
	protected Duration timeWindow;

	/**
	 * The cached value of the '{@link #getDeliveries() <em>Deliveries</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDeliveries()
	 * @generated
	 * @ordered
	 */
	protected EList<CollectiveOrder> deliveries;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DepotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.DEPOT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFixPlaceTimeIfMultipleOperations() {
		return fixPlaceTimeIfMultipleOperations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixPlaceTimeIfMultipleOperations(int newFixPlaceTimeIfMultipleOperations) {
		int oldFixPlaceTimeIfMultipleOperations = fixPlaceTimeIfMultipleOperations;
		fixPlaceTimeIfMultipleOperations = newFixPlaceTimeIfMultipleOperations;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS, oldFixPlaceTimeIfMultipleOperations, fixPlaceTimeIfMultipleOperations));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Duration getPlannedPeriod() {
		return plannedPeriod;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPlannedPeriod(Duration newPlannedPeriod, NotificationChain msgs) {
		Duration oldPlannedPeriod = plannedPeriod;
		plannedPeriod = newPlannedPeriod;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__PLANNED_PERIOD, oldPlannedPeriod, newPlannedPeriod);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPlannedPeriod(Duration newPlannedPeriod) {
		if (newPlannedPeriod != plannedPeriod) {
			NotificationChain msgs = null;
			if (plannedPeriod != null)
				msgs = ((InternalEObject)plannedPeriod).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.DEPOT__PLANNED_PERIOD, null, msgs);
			if (newPlannedPeriod != null)
				msgs = ((InternalEObject)newPlannedPeriod).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.DEPOT__PLANNED_PERIOD, null, msgs);
			msgs = basicSetPlannedPeriod(newPlannedPeriod, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__PLANNED_PERIOD, newPlannedPeriod, newPlannedPeriod));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxTourLength() {
		return maxTourLength;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTourLength(int newMaxTourLength) {
		int oldMaxTourLength = maxTourLength;
		maxTourLength = newMaxTourLength;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__MAX_TOUR_LENGTH, oldMaxTourLength, maxTourLength));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxEmployment() {
		return maxEmployment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxEmployment(int newMaxEmployment) {
		int oldMaxEmployment = maxEmployment;
		maxEmployment = newMaxEmployment;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__MAX_EMPLOYMENT, oldMaxEmployment, maxEmployment));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Duration getTimeWindow() {
		return timeWindow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTimeWindow(Duration newTimeWindow, NotificationChain msgs) {
		Duration oldTimeWindow = timeWindow;
		timeWindow = newTimeWindow;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__TIME_WINDOW, oldTimeWindow, newTimeWindow);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeWindow(Duration newTimeWindow) {
		if (newTimeWindow != timeWindow) {
			NotificationChain msgs = null;
			if (timeWindow != null)
				msgs = ((InternalEObject)timeWindow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.DEPOT__TIME_WINDOW, null, msgs);
			if (newTimeWindow != null)
				msgs = ((InternalEObject)newTimeWindow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.DEPOT__TIME_WINDOW, null, msgs);
			msgs = basicSetTimeWindow(newTimeWindow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__TIME_WINDOW, newTimeWindow, newTimeWindow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<CollectiveOrder> getDeliveries() {
		if (deliveries == null) {
			deliveries = new EObjectContainmentEList<CollectiveOrder>(CollectiveOrder.class, this, NetworkPackage.DEPOT__DELIVERIES);
		}
		return deliveries;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.DEPOT__PLANNED_PERIOD:
				return basicSetPlannedPeriod(null, msgs);
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return basicSetTimeWindow(null, msgs);
			case NetworkPackage.DEPOT__DELIVERIES:
				return ((InternalEList<?>)getDeliveries()).basicRemove(otherEnd, msgs);
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
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				return getFixPlaceTimeIfMultipleOperations();
			case NetworkPackage.DEPOT__PLANNED_PERIOD:
				return getPlannedPeriod();
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				return getMaxTourLength();
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				return getMaxEmployment();
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return getTimeWindow();
			case NetworkPackage.DEPOT__DELIVERIES:
				return getDeliveries();
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
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				setFixPlaceTimeIfMultipleOperations((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__PLANNED_PERIOD:
				setPlannedPeriod((Duration)newValue);
				return;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				setMaxTourLength((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				setMaxEmployment((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				setTimeWindow((Duration)newValue);
				return;
			case NetworkPackage.DEPOT__DELIVERIES:
				getDeliveries().clear();
				getDeliveries().addAll((Collection<? extends CollectiveOrder>)newValue);
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
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				setFixPlaceTimeIfMultipleOperations(FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__PLANNED_PERIOD:
				setPlannedPeriod((Duration)null);
				return;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				setMaxTourLength(MAX_TOUR_LENGTH_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				setMaxEmployment(MAX_EMPLOYMENT_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				setTimeWindow((Duration)null);
				return;
			case NetworkPackage.DEPOT__DELIVERIES:
				getDeliveries().clear();
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
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				return fixPlaceTimeIfMultipleOperations != FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT;
			case NetworkPackage.DEPOT__PLANNED_PERIOD:
				return plannedPeriod != null;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				return maxTourLength != MAX_TOUR_LENGTH_EDEFAULT;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				return maxEmployment != MAX_EMPLOYMENT_EDEFAULT;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return timeWindow != null;
			case NetworkPackage.DEPOT__DELIVERIES:
				return deliveries != null && !deliveries.isEmpty();
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
		result.append(" (fixPlaceTimeIfMultipleOperations: ");
		result.append(fixPlaceTimeIfMultipleOperations);
		result.append(", maxTourLength: ");
		result.append(maxTourLength);
		result.append(", maxEmployment: ");
		result.append(maxEmployment);
		result.append(')');
		return result.toString();
	}

} //DepotImpl
