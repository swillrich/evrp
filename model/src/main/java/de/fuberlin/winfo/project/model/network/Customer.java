/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Customer</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Customer#getHasTranshipmentPoint <em>Has Transhipment Point</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Customer#getOrders <em>Orders</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCustomer()
 * @model
 * @generated
 */
public interface Customer extends Locatable {
	/**
	 * Returns the value of the '<em><b>Has Transhipment Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Has Transhipment Point</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has Transhipment Point</em>' reference.
	 * @see #setHasTranshipmentPoint(Depot)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCustomer_HasTranshipmentPoint()
	 * @model
	 * @generated
	 */
	Depot getHasTranshipmentPoint();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Customer#getHasTranshipmentPoint <em>Has Transhipment Point</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Has Transhipment Point</em>' reference.
	 * @see #getHasTranshipmentPoint()
	 * @generated
	 */
	void setHasTranshipmentPoint(Depot value);

	/**
	 * Returns the value of the '<em><b>Orders</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orders</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orders</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCustomer_Orders()
	 * @model
	 * @generated
	 */
	EList<Order> getOrders();

} // Customer
