/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vertex#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vertex#getArcIn <em>Arc In</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vertex#getArcOut <em>Arc Out</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVertex()
 * @model
 * @generated
 */
public interface Vertex extends EObject {
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
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVertex_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vertex#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Arc In</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arc In</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arc In</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVertex_ArcIn()
	 * @model
	 * @generated
	 */
	EList<Arc> getArcIn();

	/**
	 * Returns the value of the '<em><b>Arc Out</b></em>' reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Arc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arc Out</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arc Out</em>' reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVertex_ArcOut()
	 * @model
	 * @generated
	 */
	EList<Arc> getArcOut();

} // Vertex
