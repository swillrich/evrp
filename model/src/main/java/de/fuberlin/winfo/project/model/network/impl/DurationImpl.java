/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.NetworkPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Duration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DurationImpl#getStartInSec <em>Start In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.DurationImpl#getEndInSec <em>End In Sec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DurationImpl extends MinimalEObjectImpl.Container implements Duration {
	/**
	 * The default value of the '{@link #getStartInSec() <em>Start In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int START_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartInSec() <em>Start In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartInSec()
	 * @generated
	 * @ordered
	 */
	protected int startInSec = START_IN_SEC_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndInSec() <em>End In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int END_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndInSec() <em>End In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndInSec()
	 * @generated
	 * @ordered
	 */
	protected int endInSec = END_IN_SEC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.DURATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStartInSec() {
		return startInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStartInSec(int newStartInSec) {
		int oldStartInSec = startInSec;
		startInSec = newStartInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DURATION__START_IN_SEC, oldStartInSec, startInSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndInSec() {
		return endInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndInSec(int newEndInSec) {
		int oldEndInSec = endInSec;
		endInSec = newEndInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.DURATION__END_IN_SEC, oldEndInSec, endInSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetworkPackage.DURATION__START_IN_SEC:
				return getStartInSec();
			case NetworkPackage.DURATION__END_IN_SEC:
				return getEndInSec();
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
			case NetworkPackage.DURATION__START_IN_SEC:
				setStartInSec((Integer)newValue);
				return;
			case NetworkPackage.DURATION__END_IN_SEC:
				setEndInSec((Integer)newValue);
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
			case NetworkPackage.DURATION__START_IN_SEC:
				setStartInSec(START_IN_SEC_EDEFAULT);
				return;
			case NetworkPackage.DURATION__END_IN_SEC:
				setEndInSec(END_IN_SEC_EDEFAULT);
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
			case NetworkPackage.DURATION__START_IN_SEC:
				return startInSec != START_IN_SEC_EDEFAULT;
			case NetworkPackage.DURATION__END_IN_SEC:
				return endInSec != END_IN_SEC_EDEFAULT;
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
		result.append(" (startInSec: ");
		result.append(startInSec);
		result.append(", endInSec: ");
		result.append(endInSec);
		result.append(')');
		return result.toString();
	}

} //DurationImpl
