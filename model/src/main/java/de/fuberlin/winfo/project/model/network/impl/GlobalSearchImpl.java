/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.GlobalSearch;
import de.fuberlin.winfo.project.model.network.LocalSearch;
import de.fuberlin.winfo.project.model.network.NetworkPackage;

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
 * An implementation of the model object '<em><b>Global Search</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl#getCost <em>Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl#getPrevCost <em>Prev Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl#getLocalSearches <em>Local Searches</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @generated
 */
public class GlobalSearchImpl extends MinimalEObjectImpl.Container implements GlobalSearch {
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
	protected static final double COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getCost() <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCost()
	 * @generated
	 * @ordered
	 */
	protected double cost = COST_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrevCost() <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevCost()
	 * @generated
	 * @ordered
	 */
	protected static final double PREV_COST_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPrevCost() <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrevCost()
	 * @generated
	 * @ordered
	 */
	protected double prevCost = PREV_COST_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLocalSearches() <em>Local Searches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLocalSearches()
	 * @generated
	 * @ordered
	 */
	protected EList<LocalSearch> localSearches;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected GlobalSearchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.GLOBAL_SEARCH;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.GLOBAL_SEARCH__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCost(double newCost) {
		double oldCost = cost;
		cost = newCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.GLOBAL_SEARCH__COST, oldCost, cost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getPrevCost() {
		return prevCost;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrevCost(double newPrevCost) {
		double oldPrevCost = prevCost;
		prevCost = newPrevCost;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.GLOBAL_SEARCH__PREV_COST, oldPrevCost, prevCost));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<LocalSearch> getLocalSearches() {
		if (localSearches == null) {
			localSearches = new EObjectContainmentEList<LocalSearch>(LocalSearch.class, this, NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES);
		}
		return localSearches;
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.GLOBAL_SEARCH__OPERATION, oldOperation, operation));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES:
				return ((InternalEList<?>)getLocalSearches()).basicRemove(otherEnd, msgs);
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
			case NetworkPackage.GLOBAL_SEARCH__NAME:
				return getName();
			case NetworkPackage.GLOBAL_SEARCH__COST:
				return getCost();
			case NetworkPackage.GLOBAL_SEARCH__PREV_COST:
				return getPrevCost();
			case NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES:
				return getLocalSearches();
			case NetworkPackage.GLOBAL_SEARCH__OPERATION:
				return getOperation();
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
			case NetworkPackage.GLOBAL_SEARCH__NAME:
				setName((String)newValue);
				return;
			case NetworkPackage.GLOBAL_SEARCH__COST:
				setCost((Double)newValue);
				return;
			case NetworkPackage.GLOBAL_SEARCH__PREV_COST:
				setPrevCost((Double)newValue);
				return;
			case NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES:
				getLocalSearches().clear();
				getLocalSearches().addAll((Collection<? extends LocalSearch>)newValue);
				return;
			case NetworkPackage.GLOBAL_SEARCH__OPERATION:
				setOperation((String)newValue);
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
			case NetworkPackage.GLOBAL_SEARCH__NAME:
				setName(NAME_EDEFAULT);
				return;
			case NetworkPackage.GLOBAL_SEARCH__COST:
				setCost(COST_EDEFAULT);
				return;
			case NetworkPackage.GLOBAL_SEARCH__PREV_COST:
				setPrevCost(PREV_COST_EDEFAULT);
				return;
			case NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES:
				getLocalSearches().clear();
				return;
			case NetworkPackage.GLOBAL_SEARCH__OPERATION:
				setOperation(OPERATION_EDEFAULT);
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
			case NetworkPackage.GLOBAL_SEARCH__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case NetworkPackage.GLOBAL_SEARCH__COST:
				return cost != COST_EDEFAULT;
			case NetworkPackage.GLOBAL_SEARCH__PREV_COST:
				return prevCost != PREV_COST_EDEFAULT;
			case NetworkPackage.GLOBAL_SEARCH__LOCAL_SEARCHES:
				return localSearches != null && !localSearches.isEmpty();
			case NetworkPackage.GLOBAL_SEARCH__OPERATION:
				return OPERATION_EDEFAULT == null ? operation != null : !OPERATION_EDEFAULT.equals(operation);
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
		result.append(')');
		return result.toString();
	}

} //GlobalSearchImpl
