/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Node#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Node#getEdgeIn <em>Edge In</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Node#getEdgeOut <em>Edge Out</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Node#getRepresentative <em>Representative</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getNode()
 * @model
 * @generated
 */
public interface Node extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getNode_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Node#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Edge In</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge In</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getNode_EdgeIn()
	 * @model
	 * @generated
	 */
	EList<Edge> getEdgeIn();

	/**
	 * Returns the value of the '<em><b>Edge Out</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Edge}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge Out</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getNode_EdgeOut()
	 * @model
	 * @generated
	 */
	EList<Edge> getEdgeOut();

	/**
	 * Returns the value of the '<em><b>Representative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Representative</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Representative</em>' containment reference.
	 * @see #setRepresentative(Locatable)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getNode_Representative()
	 * @model containment="true"
	 * @generated
	 */
	Locatable getRepresentative();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Node#getRepresentative <em>Representative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Representative</em>' containment reference.
	 * @see #getRepresentative()
	 * @generated
	 */
	void setRepresentative(Locatable value);

} // Node
