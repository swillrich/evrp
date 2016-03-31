/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Customer;
import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Order;

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
 * An implementation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.CustomerImpl#getOwnedOrders <em>Owned Orders</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.CustomerImpl#getHasTranshipmentPoint <em>Has Transhipment Point</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CustomerImpl extends LocatableImpl implements Customer {
	/**
	 * The cached value of the '{@link #getOwnedOrders() <em>Owned Orders</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedOrders()
	 * @generated
	 * @ordered
	 */
	protected EList<Order> ownedOrders;

	/**
	 * The cached value of the '{@link #getHasTranshipmentPoint() <em>Has Transhipment Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHasTranshipmentPoint()
	 * @generated
	 * @ordered
	 */
	protected Depot hasTranshipmentPoint;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CustomerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.CUSTOMER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Order> getOwnedOrders() {
		if (ownedOrders == null) {
			ownedOrders = new EObjectContainmentEList<Order>(Order.class, this, NetworkPackage.CUSTOMER__OWNED_ORDERS);
		}
		return ownedOrders;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Depot getHasTranshipmentPoint() {
		if (hasTranshipmentPoint != null && hasTranshipmentPoint.eIsProxy()) {
			InternalEObject oldHasTranshipmentPoint = (InternalEObject)hasTranshipmentPoint;
			hasTranshipmentPoint = (Depot)eResolveProxy(oldHasTranshipmentPoint);
			if (hasTranshipmentPoint != oldHasTranshipmentPoint) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT, oldHasTranshipmentPoint, hasTranshipmentPoint));
			}
		}
		return hasTranshipmentPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Depot basicGetHasTranshipmentPoint() {
		return hasTranshipmentPoint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHasTranshipmentPoint(Depot newHasTranshipmentPoint) {
		Depot oldHasTranshipmentPoint = hasTranshipmentPoint;
		hasTranshipmentPoint = newHasTranshipmentPoint;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT, oldHasTranshipmentPoint, hasTranshipmentPoint));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.CUSTOMER__OWNED_ORDERS:
				return ((InternalEList<?>)getOwnedOrders()).basicRemove(otherEnd, msgs);
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
			case NetworkPackage.CUSTOMER__OWNED_ORDERS:
				return getOwnedOrders();
			case NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT:
				if (resolve) return getHasTranshipmentPoint();
				return basicGetHasTranshipmentPoint();
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
			case NetworkPackage.CUSTOMER__OWNED_ORDERS:
				getOwnedOrders().clear();
				getOwnedOrders().addAll((Collection<? extends Order>)newValue);
				return;
			case NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT:
				setHasTranshipmentPoint((Depot)newValue);
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
			case NetworkPackage.CUSTOMER__OWNED_ORDERS:
				getOwnedOrders().clear();
				return;
			case NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT:
				setHasTranshipmentPoint((Depot)null);
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
			case NetworkPackage.CUSTOMER__OWNED_ORDERS:
				return ownedOrders != null && !ownedOrders.isEmpty();
			case NetworkPackage.CUSTOMER__HAS_TRANSHIPMENT_POINT:
				return hasTranshipmentPoint != null;
		}
		return super.eIsSet(featureID);
	}

} //CustomerImpl
