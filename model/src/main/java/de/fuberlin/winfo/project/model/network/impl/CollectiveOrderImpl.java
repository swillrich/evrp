/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.CollectiveOrder;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Order;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collective Order</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.CollectiveOrderImpl#getSubOrder <em>Sub Order</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CollectiveOrderImpl extends OrderImpl implements CollectiveOrder {
	/**
	 * The cached value of the '{@link #getSubOrder() <em>Sub Order</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubOrder()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> subOrder;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CollectiveOrderImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.COLLECTIVE_ORDER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Order> getSubOrder() {
		if (subOrder == null) {
			subOrder = new EObjectContainmentEList<Order>(Order.class, this, NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER);
		}
		return subOrder;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER:
				return ((InternalEList<?>)getSubOrder()).basicRemove(otherEnd, msgs);
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
			case NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER:
				return getSubOrder();
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
			case NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER:
				getSubOrder().clear();
				getSubOrder().addAll((Collection<? extends Order>)newValue);
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
			case NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER:
				getSubOrder().clear();
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
			case NetworkPackage.COLLECTIVE_ORDER__SUB_ORDER:
				return subOrder != null && !subOrder.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //CollectiveOrderImpl
