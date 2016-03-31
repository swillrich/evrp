/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Vehicle;

import de.fuberlin.winfo.project.model.network.solution.SolutionPackage;
import de.fuberlin.winfo.project.model.network.solution.UseCase;

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
 * An implementation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getTranshipmentPoints <em>Transhipment Points</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getMaxTourLengthInSec <em>Max Tour Length In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl#getStorageCostsPerKgPerSec <em>Storage Costs Per Kg Per Sec</em>}</li>
 * </ul>
 *
 * @generated
 */
public class UseCaseImpl extends MinimalEObjectImpl.Container implements UseCase {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVehicles() <em>Vehicles</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVehicles()
	 * @generated
	 * @ordered
	 */
	protected EList<Vehicle> vehicles;

	/**
	 * The cached value of the '{@link #getTranshipmentPoints() <em>Transhipment Points</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTranshipmentPoints()
	 * @generated
	 * @ordered
	 */
	protected EList<Depot> transhipmentPoints;

	/**
	 * The default value of the '{@link #getMaxTourLengthInSec() <em>Max Tour Length In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTourLengthInSec()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_TOUR_LENGTH_IN_SEC_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMaxTourLengthInSec() <em>Max Tour Length In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMaxTourLengthInSec()
	 * @generated
	 * @ordered
	 */
	protected int maxTourLengthInSec = MAX_TOUR_LENGTH_IN_SEC_EDEFAULT;

	/**
	 * The default value of the '{@link #getStorageCostsPerKgPerSec() <em>Storage Costs Per Kg Per Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageCostsPerKgPerSec()
	 * @generated
	 * @ordered
	 */
	protected static final double STORAGE_COSTS_PER_KG_PER_SEC_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getStorageCostsPerKgPerSec() <em>Storage Costs Per Kg Per Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStorageCostsPerKgPerSec()
	 * @generated
	 * @ordered
	 */
	protected double storageCostsPerKgPerSec = STORAGE_COSTS_PER_KG_PER_SEC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UseCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.USE_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USE_CASE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USE_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vehicle> getVehicles() {
		if (vehicles == null) {
			vehicles = new EObjectContainmentEList<Vehicle>(Vehicle.class, this, SolutionPackage.USE_CASE__VEHICLES);
		}
		return vehicles;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Depot> getTranshipmentPoints() {
		if (transhipmentPoints == null) {
			transhipmentPoints = new EObjectContainmentEList<Depot>(Depot.class, this, SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS);
		}
		return transhipmentPoints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMaxTourLengthInSec() {
		return maxTourLengthInSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMaxTourLengthInSec(int newMaxTourLengthInSec) {
		int oldMaxTourLengthInSec = maxTourLengthInSec;
		maxTourLengthInSec = newMaxTourLengthInSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USE_CASE__MAX_TOUR_LENGTH_IN_SEC, oldMaxTourLengthInSec, maxTourLengthInSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getStorageCostsPerKgPerSec() {
		return storageCostsPerKgPerSec;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStorageCostsPerKgPerSec(double newStorageCostsPerKgPerSec) {
		double oldStorageCostsPerKgPerSec = storageCostsPerKgPerSec;
		storageCostsPerKgPerSec = newStorageCostsPerKgPerSec;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC, oldStorageCostsPerKgPerSec, storageCostsPerKgPerSec));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolutionPackage.USE_CASE__VEHICLES:
				return ((InternalEList<?>)getVehicles()).basicRemove(otherEnd, msgs);
			case SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS:
				return ((InternalEList<?>)getTranshipmentPoints()).basicRemove(otherEnd, msgs);
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
			case SolutionPackage.USE_CASE__ID:
				return getId();
			case SolutionPackage.USE_CASE__NAME:
				return getName();
			case SolutionPackage.USE_CASE__VEHICLES:
				return getVehicles();
			case SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS:
				return getTranshipmentPoints();
			case SolutionPackage.USE_CASE__MAX_TOUR_LENGTH_IN_SEC:
				return getMaxTourLengthInSec();
			case SolutionPackage.USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC:
				return getStorageCostsPerKgPerSec();
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
			case SolutionPackage.USE_CASE__ID:
				setId((Integer)newValue);
				return;
			case SolutionPackage.USE_CASE__NAME:
				setName((String)newValue);
				return;
			case SolutionPackage.USE_CASE__VEHICLES:
				getVehicles().clear();
				getVehicles().addAll((Collection<? extends Vehicle>)newValue);
				return;
			case SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS:
				getTranshipmentPoints().clear();
				getTranshipmentPoints().addAll((Collection<? extends Depot>)newValue);
				return;
			case SolutionPackage.USE_CASE__MAX_TOUR_LENGTH_IN_SEC:
				setMaxTourLengthInSec((Integer)newValue);
				return;
			case SolutionPackage.USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC:
				setStorageCostsPerKgPerSec((Double)newValue);
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
			case SolutionPackage.USE_CASE__ID:
				setId(ID_EDEFAULT);
				return;
			case SolutionPackage.USE_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SolutionPackage.USE_CASE__VEHICLES:
				getVehicles().clear();
				return;
			case SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS:
				getTranshipmentPoints().clear();
				return;
			case SolutionPackage.USE_CASE__MAX_TOUR_LENGTH_IN_SEC:
				setMaxTourLengthInSec(MAX_TOUR_LENGTH_IN_SEC_EDEFAULT);
				return;
			case SolutionPackage.USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC:
				setStorageCostsPerKgPerSec(STORAGE_COSTS_PER_KG_PER_SEC_EDEFAULT);
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
			case SolutionPackage.USE_CASE__ID:
				return id != ID_EDEFAULT;
			case SolutionPackage.USE_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SolutionPackage.USE_CASE__VEHICLES:
				return vehicles != null && !vehicles.isEmpty();
			case SolutionPackage.USE_CASE__TRANSHIPMENT_POINTS:
				return transhipmentPoints != null && !transhipmentPoints.isEmpty();
			case SolutionPackage.USE_CASE__MAX_TOUR_LENGTH_IN_SEC:
				return maxTourLengthInSec != MAX_TOUR_LENGTH_IN_SEC_EDEFAULT;
			case SolutionPackage.USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC:
				return storageCostsPerKgPerSec != STORAGE_COSTS_PER_KG_PER_SEC_EDEFAULT;
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
		result.append(", name: ");
		result.append(name);
		result.append(", maxTourLengthInSec: ");
		result.append(maxTourLengthInSec);
		result.append(", storageCostsPerKgPerSec: ");
		result.append(storageCostsPerKgPerSec);
		result.append(')');
		return result.toString();
	}

} //UseCaseImpl
