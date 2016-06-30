/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Arc;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Vertex;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getStart <em>Start</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getEnd <em>End</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getDistance <em>Distance</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getTime <em>Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#isIsUsed <em>Is Used</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getEnergyMin <em>Energy Min</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl#getEnergyMax <em>Energy Max</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ArcImpl extends MinimalEObjectImpl.Container implements Arc {
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
	 * The cached value of the '{@link #getStart() <em>Start</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStart()
	 * @generated
	 * @ordered
	 */
	protected Vertex start;

	/**
	 * The cached value of the '{@link #getEnd() <em>End</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnd()
	 * @generated
	 * @ordered
	 */
	protected Vertex end;

	/**
	 * The default value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected static final int DISTANCE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getDistance() <em>Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDistance()
	 * @generated
	 * @ordered
	 */
	protected int distance = DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final int TIME_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected int time = TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #isIsUsed() <em>Is Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUsed()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_USED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsUsed() <em>Is Used</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsUsed()
	 * @generated
	 * @ordered
	 */
	protected boolean isUsed = IS_USED_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnergyMin() <em>Energy Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMin()
	 * @generated
	 * @ordered
	 */
	protected static final int ENERGY_MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnergyMin() <em>Energy Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMin()
	 * @generated
	 * @ordered
	 */
	protected int energyMin = ENERGY_MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getEnergyMax() <em>Energy Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMax()
	 * @generated
	 * @ordered
	 */
	protected static final int ENERGY_MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEnergyMax() <em>Energy Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEnergyMax()
	 * @generated
	 * @ordered
	 */
	protected int energyMax = ENERGY_MAX_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArcImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.ARC;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getStart() {
		if (start != null && start.eIsProxy()) {
			InternalEObject oldStart = (InternalEObject)start;
			start = (Vertex)eResolveProxy(oldStart);
			if (start != oldStart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkPackage.ARC__START, oldStart, start));
			}
		}
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetStart() {
		return start;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStart(Vertex newStart) {
		Vertex oldStart = start;
		start = newStart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__START, oldStart, start));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex getEnd() {
		if (end != null && end.eIsProxy()) {
			InternalEObject oldEnd = (InternalEObject)end;
			end = (Vertex)eResolveProxy(oldEnd);
			if (end != oldEnd) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkPackage.ARC__END, oldEnd, end));
			}
		}
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vertex basicGetEnd() {
		return end;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnd(Vertex newEnd) {
		Vertex oldEnd = end;
		end = newEnd;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__END, oldEnd, end));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getDistance() {
		return distance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDistance(int newDistance) {
		int oldDistance = distance;
		distance = newDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__DISTANCE, oldDistance, distance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(int newTime) {
		int oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsUsed() {
		return isUsed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsUsed(boolean newIsUsed) {
		boolean oldIsUsed = isUsed;
		isUsed = newIsUsed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__IS_USED, oldIsUsed, isUsed));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnergyMin() {
		return energyMin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyMin(int newEnergyMin) {
		int oldEnergyMin = energyMin;
		energyMin = newEnergyMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__ENERGY_MIN, oldEnergyMin, energyMin));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEnergyMax() {
		return energyMax;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEnergyMax(int newEnergyMax) {
		int oldEnergyMax = energyMax;
		energyMax = newEnergyMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.ARC__ENERGY_MAX, oldEnergyMax, energyMax));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NetworkPackage.ARC__ID:
				return getId();
			case NetworkPackage.ARC__START:
				if (resolve) return getStart();
				return basicGetStart();
			case NetworkPackage.ARC__END:
				if (resolve) return getEnd();
				return basicGetEnd();
			case NetworkPackage.ARC__DISTANCE:
				return getDistance();
			case NetworkPackage.ARC__TIME:
				return getTime();
			case NetworkPackage.ARC__IS_USED:
				return isIsUsed();
			case NetworkPackage.ARC__ENERGY_MIN:
				return getEnergyMin();
			case NetworkPackage.ARC__ENERGY_MAX:
				return getEnergyMax();
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
			case NetworkPackage.ARC__ID:
				setId((String)newValue);
				return;
			case NetworkPackage.ARC__START:
				setStart((Vertex)newValue);
				return;
			case NetworkPackage.ARC__END:
				setEnd((Vertex)newValue);
				return;
			case NetworkPackage.ARC__DISTANCE:
				setDistance((Integer)newValue);
				return;
			case NetworkPackage.ARC__TIME:
				setTime((Integer)newValue);
				return;
			case NetworkPackage.ARC__IS_USED:
				setIsUsed((Boolean)newValue);
				return;
			case NetworkPackage.ARC__ENERGY_MIN:
				setEnergyMin((Integer)newValue);
				return;
			case NetworkPackage.ARC__ENERGY_MAX:
				setEnergyMax((Integer)newValue);
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
			case NetworkPackage.ARC__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.ARC__START:
				setStart((Vertex)null);
				return;
			case NetworkPackage.ARC__END:
				setEnd((Vertex)null);
				return;
			case NetworkPackage.ARC__DISTANCE:
				setDistance(DISTANCE_EDEFAULT);
				return;
			case NetworkPackage.ARC__TIME:
				setTime(TIME_EDEFAULT);
				return;
			case NetworkPackage.ARC__IS_USED:
				setIsUsed(IS_USED_EDEFAULT);
				return;
			case NetworkPackage.ARC__ENERGY_MIN:
				setEnergyMin(ENERGY_MIN_EDEFAULT);
				return;
			case NetworkPackage.ARC__ENERGY_MAX:
				setEnergyMax(ENERGY_MAX_EDEFAULT);
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
			case NetworkPackage.ARC__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NetworkPackage.ARC__START:
				return start != null;
			case NetworkPackage.ARC__END:
				return end != null;
			case NetworkPackage.ARC__DISTANCE:
				return distance != DISTANCE_EDEFAULT;
			case NetworkPackage.ARC__TIME:
				return time != TIME_EDEFAULT;
			case NetworkPackage.ARC__IS_USED:
				return isUsed != IS_USED_EDEFAULT;
			case NetworkPackage.ARC__ENERGY_MIN:
				return energyMin != ENERGY_MIN_EDEFAULT;
			case NetworkPackage.ARC__ENERGY_MAX:
				return energyMax != ENERGY_MAX_EDEFAULT;
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
		result.append(", distance: ");
		result.append(distance);
		result.append(", time: ");
		result.append(time);
		result.append(", isUsed: ");
		result.append(isUsed);
		result.append(", energyMin: ");
		result.append(energyMin);
		result.append(", energyMax: ");
		result.append(energyMax);
		result.append(')');
		return result.toString();
	}

} //ArcImpl
