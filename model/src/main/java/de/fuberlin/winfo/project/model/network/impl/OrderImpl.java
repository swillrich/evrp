/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Order;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl#getNeedAsVolume <em>Need As Volume</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl#getNeedAsWeight <em>Need As Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl#getTimeWindow <em>Time Window</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl#getStandingTimeInSec <em>Standing Time In Sec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class OrderImpl extends MinimalEObjectImpl.Container implements Order {
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
	 * The default value of the '{@link #getNeedAsVolume() <em>Need As Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeedAsVolume()
	 * @generated
	 * @ordered
	 */
	protected static final double NEED_AS_VOLUME_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNeedAsVolume() <em>Need As Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeedAsVolume()
	 * @generated
	 * @ordered
	 */
	protected double needAsVolume = NEED_AS_VOLUME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNeedAsWeight() <em>Need As Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeedAsWeight()
	 * @generated
	 * @ordered
	 */
	protected static final double NEED_AS_WEIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getNeedAsWeight() <em>Need As Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeedAsWeight()
	 * @generated
	 * @ordered
	 */
	protected double needAsWeight = NEED_AS_WEIGHT_EDEFAULT;

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
	 * The default value of the '{@link #getStandingTimeInSec() <em>Standing Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandingTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int STANDING_TIME_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStandingTimeInSec() <em>Standing Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStandingTimeInSec()
	 * @generated
	 * @ordered
	 */
	protected int standingTimeInSec = STANDING_TIME_IN_SEC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.ORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNeedAsVolume() {
		return needAsVolume;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedAsVolume(double newNeedAsVolume) {
		double oldNeedAsVolume = needAsVolume;
		needAsVolume = newNeedAsVolume;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__NEED_AS_VOLUME, oldNeedAsVolume, needAsVolume));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getNeedAsWeight() {
		return needAsWeight;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNeedAsWeight(double newNeedAsWeight) {
		double oldNeedAsWeight = needAsWeight;
		needAsWeight = newNeedAsWeight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__NEED_AS_WEIGHT, oldNeedAsWeight, needAsWeight));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__TIME_WINDOW, oldTimeWindow, newTimeWindow);
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
				msgs = ((InternalEObject)timeWindow).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.ORDER__TIME_WINDOW, null, msgs);
			if (newTimeWindow != null)
				msgs = ((InternalEObject)newTimeWindow).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.ORDER__TIME_WINDOW, null, msgs);
			msgs = basicSetTimeWindow(newTimeWindow, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__TIME_WINDOW, newTimeWindow, newTimeWindow));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStandingTimeInSec() {
		return standingTimeInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStandingTimeInSec(int newStandingTimeInSec) {
		int oldStandingTimeInSec = standingTimeInSec;
		standingTimeInSec = newStandingTimeInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__STANDING_TIME_IN_SEC, oldStandingTimeInSec, standingTimeInSec));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ORDER__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.ORDER__TIME_WINDOW:
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
			case NetworkPackage.ORDER__ID:
				return getId();
			case NetworkPackage.ORDER__NEED_AS_VOLUME:
				return getNeedAsVolume();
			case NetworkPackage.ORDER__NEED_AS_WEIGHT:
				return getNeedAsWeight();
			case NetworkPackage.ORDER__TIME_WINDOW:
				return getTimeWindow();
			case NetworkPackage.ORDER__STANDING_TIME_IN_SEC:
				return getStandingTimeInSec();
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
			case NetworkPackage.ORDER__ID:
				setId((String)newValue);
				return;
			case NetworkPackage.ORDER__NEED_AS_VOLUME:
				setNeedAsVolume((Double)newValue);
				return;
			case NetworkPackage.ORDER__NEED_AS_WEIGHT:
				setNeedAsWeight((Double)newValue);
				return;
			case NetworkPackage.ORDER__TIME_WINDOW:
				setTimeWindow((Duration)newValue);
				return;
			case NetworkPackage.ORDER__STANDING_TIME_IN_SEC:
				setStandingTimeInSec((Integer)newValue);
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
			case NetworkPackage.ORDER__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.ORDER__NEED_AS_VOLUME:
				setNeedAsVolume(NEED_AS_VOLUME_EDEFAULT);
				return;
			case NetworkPackage.ORDER__NEED_AS_WEIGHT:
				setNeedAsWeight(NEED_AS_WEIGHT_EDEFAULT);
				return;
			case NetworkPackage.ORDER__TIME_WINDOW:
				setTimeWindow((Duration)null);
				return;
			case NetworkPackage.ORDER__STANDING_TIME_IN_SEC:
				setStandingTimeInSec(STANDING_TIME_IN_SEC_EDEFAULT);
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
			case NetworkPackage.ORDER__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NetworkPackage.ORDER__NEED_AS_VOLUME:
				return needAsVolume != NEED_AS_VOLUME_EDEFAULT;
			case NetworkPackage.ORDER__NEED_AS_WEIGHT:
				return needAsWeight != NEED_AS_WEIGHT_EDEFAULT;
			case NetworkPackage.ORDER__TIME_WINDOW:
				return timeWindow != null;
			case NetworkPackage.ORDER__STANDING_TIME_IN_SEC:
				return standingTimeInSec != STANDING_TIME_IN_SEC_EDEFAULT;
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
		result.append(", needAsVolume: ");
		result.append(needAsVolume);
		result.append(", needAsWeight: ");
		result.append(needAsWeight);
		result.append(", standingTimeInSec: ");
		result.append(standingTimeInSec);
		result.append(')');
		return result.toString();
	}

} //OrderImpl
