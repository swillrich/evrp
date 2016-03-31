/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collective Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getConsistOf <em>Consist Of</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getReceiver <em>Receiver</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCollectiveOrder()
 * @model
 * @generated
 */
public interface CollectiveOrder extends Order {
	/**
	 * Returns the value of the '<em><b>Consist Of</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Consist Of</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Consist Of</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCollectiveOrder_ConsistOf()
	 * @model
	 * @generated
	 */
	EList<Order> getConsistOf();

	/**
	 * Returns the value of the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Receiver</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Receiver</em>' reference.
	 * @see #setReceiver(Locatable)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCollectiveOrder_Receiver()
	 * @model
	 * @generated
	 */
	Locatable getReceiver();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getReceiver <em>Receiver</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Receiver</em>' reference.
	 * @see #getReceiver()
	 * @generated
	 */
	void setReceiver(Locatable value);

} // CollectiveOrder
