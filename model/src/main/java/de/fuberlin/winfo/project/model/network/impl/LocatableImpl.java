/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.NetworkPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Locatable</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl#getServiceTimeInSec <em>Service Time In Sec</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class LocatableImpl extends MinimalEObjectImpl.Container implements Locatable {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LocatableImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.LOCATABLE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.LOCATABLE__LATITUDE, oldLatitude, latitude));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.LOCATABLE__LONGITUDE, oldLongitude, longitude));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC, oldServiceTimeInSec, serviceTimeInSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetworkPackage.LOCATABLE__LATITUDE:
				return getLatitude();
			case NetworkPackage.LOCATABLE__LONGITUDE:
				return getLongitude();
			case NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC:
				return getServiceTimeInSec();
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
			case NetworkPackage.LOCATABLE__LATITUDE:
				setLatitude((Double)newValue);
				return;
			case NetworkPackage.LOCATABLE__LONGITUDE:
				setLongitude((Double)newValue);
				return;
			case NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC:
				setServiceTimeInSec((Integer)newValue);
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
			case NetworkPackage.LOCATABLE__LATITUDE:
				setLatitude(LATITUDE_EDEFAULT);
				return;
			case NetworkPackage.LOCATABLE__LONGITUDE:
				setLongitude(LONGITUDE_EDEFAULT);
				return;
			case NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC:
				setServiceTimeInSec(SERVICE_TIME_IN_SEC_EDEFAULT);
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
			case NetworkPackage.LOCATABLE__LATITUDE:
				return latitude != LATITUDE_EDEFAULT;
			case NetworkPackage.LOCATABLE__LONGITUDE:
				return longitude != LONGITUDE_EDEFAULT;
			case NetworkPackage.LOCATABLE__SERVICE_TIME_IN_SEC:
				return serviceTimeInSec != SERVICE_TIME_IN_SEC_EDEFAULT;
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
		result.append(" (latitude: ");
		result.append(latitude);
		result.append(", longitude: ");
		result.append(longitude);
		result.append(", serviceTimeInSec: ");
		result.append(serviceTimeInSec);
		result.append(')');
		return result.toString();
	}

} //LocatableImpl
