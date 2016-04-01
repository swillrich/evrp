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
 *   <li>{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getSubOrder <em>Sub Order</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCollectiveOrder()
 * @model
 * @generated
 */
public interface CollectiveOrder extends Order {
	/**
	 * Returns the value of the '<em><b>Sub Order</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Order}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Order</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Order</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getCollectiveOrder_SubOrder()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<Order> getSubOrder();

} // CollectiveOrder
