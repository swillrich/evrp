/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.NetworkPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Depot</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getServiceTimeInSec <em>Service Time In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getTimeWindow <em>Time Window</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getFixPlaceTimeIfMultipleOperations <em>Fix Place Time If Multiple Operations</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getMaxTourLength <em>Max Tour Length</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl#getMaxEmployment <em>Max Employment</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DepotImpl extends VertexImpl implements Depot {
	/**
	 * The default value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LATITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLatitude() <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLatitude()
	 * @generated
	 * @ordered
	 */
	protected double latitude = LATITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected static final double LONGITUDE_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLongitude() <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLongitude()
	 * @generated
	 * @ordered
	 */
	protected double longitude = LONGITUDE_EDEFAULT;

	/**
	 * The default value of the '{@link #getServiceTimeInSec() <em>Service Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int SERVICE_TIME_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getServiceTimeInSec() <em>Service Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getServiceTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected int serviceTimeInSec = SERVICE_TIME_IN_SEC_EDEFAULT;

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
	public double getLatitude() {
		return latitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLatitude(double newLatitude) {
		double oldLatitude = latitude;
		latitude = newLatitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__LATITUDE, oldLatitude, latitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLongitude(double newLongitude) {
		double oldLongitude = longitude;
		longitude = newLongitude;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__LONGITUDE, oldLongitude, longitude));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getServiceTimeInSec() {
		return serviceTimeInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setServiceTimeInSec(int newServiceTimeInSec) {
		int oldServiceTimeInSec = serviceTimeInSec;
		serviceTimeInSec = newServiceTimeInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC, oldServiceTimeInSec, serviceTimeInSec));
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
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return basicSetTimeWindow(null, msgs);
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
			case NetworkPackage.DEPOT__LATITUDE:
				return getLatitude();
			case NetworkPackage.DEPOT__LONGITUDE:
				return getLongitude();
			case NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC:
				return getServiceTimeInSec();
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return getTimeWindow();
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				return getFixPlaceTimeIfMultipleOperations();
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				return getMaxTourLength();
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				return getMaxEmployment();
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
			case NetworkPackage.DEPOT__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case NetworkPackage.DEPOT__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC:
				setServiceTimeInSec((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				setTimeWindow((Duration)newValue);
				return;
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				setFixPlaceTimeIfMultipleOperations((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				setMaxTourLength((Integer)newValue);
				return;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				setMaxEmployment((Integer)newValue);
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
			case NetworkPackage.DEPOT__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC:
				setServiceTimeInSec(SERVICE_TIME_IN_SEC_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				setTimeWindow((Duration)null);
				return;
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				setFixPlaceTimeIfMultipleOperations(FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				setMaxTourLength(MAX_TOUR_LENGTH_EDEFAULT);
				return;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				setMaxEmployment(MAX_EMPLOYMENT_EDEFAULT);
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
			case NetworkPackage.DEPOT__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case NetworkPackage.DEPOT__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC:
				return serviceTimeInSec != SERVICE_TIME_IN_SEC_EDEFAULT;
			case NetworkPackage.DEPOT__TIME_WINDOW:
				return timeWindow != null;
			case NetworkPackage.DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS:
				return fixPlaceTimeIfMultipleOperations != FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS_EDEFAULT;
			case NetworkPackage.DEPOT__MAX_TOUR_LENGTH:
				return maxTourLength != MAX_TOUR_LENGTH_EDEFAULT;
			case NetworkPackage.DEPOT__MAX_EMPLOYMENT:
				return maxEmployment != MAX_EMPLOYMENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == Locatable.class) {
			switch (derivedFeatureID) {
				case NetworkPackage.DEPOT__LATITUDE: return NetworkPackage.LOCATABLE__LATITUDE;
				case NetworkPackage.DEPOT__LONGITUDE: return NetworkPackage.LOCATABLE__LONGITUDE;
				case NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC: return NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC;
				case NetworkPackage.DEPOT__TIME_WINDOW: return NetworkPackage.LOCATABLE__TIME_WINDOW;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == Locatable.class) {
			switch (baseFeatureID) {
				case NetworkPackage.LOCATABLE__LATITUDE: return NetworkPackage.DEPOT__LATITUDE;
				case NetworkPackage.LOCATABLE__LONGITUDE: return NetworkPackage.DEPOT__LONGITUDE;
				case NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC: return NetworkPackage.DEPOT__SERVICE_TIME_IN_SEC;
				case NetworkPackage.LOCATABLE__TIME_WINDOW: return NetworkPackage.DEPOT__TIME_WINDOW;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(", serviceTimeInSec: ");
		result.append(serviceTimeInSec);
		result.append(", fixPlaceTimeIfMultipleOperations: ");
		result.append(fixPlaceTimeIfMultipleOperations);
		result.append(", maxTourLength: ");
		result.append(maxTourLength);
		result.append(", maxEmployment: ");
		result.append(maxEmployment);
		result.append(')');
		return result.toString();
	}

} //DepotImpl
