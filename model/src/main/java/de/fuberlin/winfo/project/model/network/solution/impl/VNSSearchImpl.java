/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch;
import de.fuberlin.winfo.project.model.network.solution.SolutionPackage;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;

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
 * An implementation of the model object '<em><b>VNS Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getPrevCost <em>Prev Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getNeighborhoodSearches <em>Neighborhood Searches</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @generated
 */
public class VNSSearchImpl extends MinimalEObjectImpl.Container implements VNSSearch {
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
	 * The default value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected static final long COST_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected long cost = COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrevCost() <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevCost()
	 * @generated
	 * @ordered
	 */
	protected static final long PREV_COST_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getPrevCost() <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevCost()
	 * @generated
	 * @ordered
	 */
	protected long prevCost = PREV_COST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getNeighborhoodSearches() <em>Neighborhood Searches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNeighborhoodSearches()
	 * @generated
	 * @ordered
	 */
	protected EList<NeighborhoodSearch> neighborhoodSearches;

	/**
	 * The default value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected static final String OPERATION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOperation() <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperation()
	 * @generated
	 * @ordered
	 */
	protected String operation = OPERATION_EDEFAULT;

	/**
	 * The default value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected static final long TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTime() <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTime()
	 * @generated
	 * @ordered
	 */
	protected long time = TIME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VNSSearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.VNS_SEARCH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.VNS_SEARCH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCost() {
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCost(long newCost) {
		long oldCost = cost;
		cost = newCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.VNS_SEARCH__COST, oldCost, cost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getPrevCost() {
		return prevCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrevCost(long newPrevCost) {
		long oldPrevCost = prevCost;
		prevCost = newPrevCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.VNS_SEARCH__PREV_COST, oldPrevCost, prevCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NeighborhoodSearch> getNeighborhoodSearches() {
		if (neighborhoodSearches == null) {
			neighborhoodSearches = new EObjectContainmentEList<NeighborhoodSearch>(NeighborhoodSearch.class, this, SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES);
		}
		return neighborhoodSearches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOperation() {
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperation(String newOperation) {
		String oldOperation = operation;
		operation = newOperation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.VNS_SEARCH__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTime() {
		return time;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTime(long newTime) {
		long oldTime = time;
		time = newTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.VNS_SEARCH__TIME, oldTime, time));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES:
				return ((InternalEList<?>)getNeighborhoodSearches()).basicRemove(otherEnd, msgs);
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
			case SolutionPackage.VNS_SEARCH__NAME:
				return getName();
			case SolutionPackage.VNS_SEARCH__COST:
				return getCost();
			case SolutionPackage.VNS_SEARCH__PREV_COST:
				return getPrevCost();
			case SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES:
				return getNeighborhoodSearches();
			case SolutionPackage.VNS_SEARCH__OPERATION:
				return getOperation();
			case SolutionPackage.VNS_SEARCH__TIME:
				return getTime();
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
			case SolutionPackage.VNS_SEARCH__NAME:
				setName((String)newValue);
				return;
			case SolutionPackage.VNS_SEARCH__COST:
				setCost((Long)newValue);
				return;
			case SolutionPackage.VNS_SEARCH__PREV_COST:
				setPrevCost((Long)newValue);
				return;
			case SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES:
				getNeighborhoodSearches().clear();
				getNeighborhoodSearches().addAll((Collection<? extends NeighborhoodSearch>)newValue);
				return;
			case SolutionPackage.VNS_SEARCH__OPERATION:
				setOperation((String)newValue);
				return;
			case SolutionPackage.VNS_SEARCH__TIME:
				setTime((Long)newValue);
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
			case SolutionPackage.VNS_SEARCH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case SolutionPackage.VNS_SEARCH__COST:
				setCost(COST_EDEFAULT);
				return;
			case SolutionPackage.VNS_SEARCH__PREV_COST:
				setPrevCost(PREV_COST_EDEFAULT);
				return;
			case SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES:
				getNeighborhoodSearches().clear();
				return;
			case SolutionPackage.VNS_SEARCH__OPERATION:
				setOperation(OPERATION_EDEFAULT);
				return;
			case SolutionPackage.VNS_SEARCH__TIME:
				setTime(TIME_EDEFAULT);
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
			case SolutionPackage.VNS_SEARCH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case SolutionPackage.VNS_SEARCH__COST:
				return cost != COST_EDEFAULT;
			case SolutionPackage.VNS_SEARCH__PREV_COST:
				return prevCost != PREV_COST_EDEFAULT;
			case SolutionPackage.VNS_SEARCH__NEIGHBORHOOD_SEARCHES:
				return neighborhoodSearches != null && !neighborhoodSearches.isEmpty();
			case SolutionPackage.VNS_SEARCH__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
			case SolutionPackage.VNS_SEARCH__TIME:
				return time != TIME_EDEFAULT;
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
		result.append(" (name: ");
		result.append(name);
		result.append(", cost: ");
		result.append(cost);
		result.append(", prevCost: ");
		result.append(prevCost);
		result.append(", operation: ");
		result.append(operation);
		result.append(", time: ");
		result.append(time);
		result.append(')');
		return result.toString();
	}

} //VNSSearchImpl
