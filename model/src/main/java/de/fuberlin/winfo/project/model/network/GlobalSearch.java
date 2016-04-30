/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Global Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getCost <em>Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getPrevCost <em>Prev Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getLocalSearches <em>Local Searches</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getOperation <em>Operation</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch()
 * @model
 * @generated
 */
public interface GlobalSearch extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cost</em>' attribute.
	 * @see #setCost(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch_Cost()
	 * @model
	 * @generated
	 */
	double getCost();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(double value);

	/**
	 * Returns the value of the '<em><b>Prev Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev Cost</em>' attribute.
	 * @see #setPrevCost(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch_PrevCost()
	 * @model
	 * @generated
	 */
	double getPrevCost();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getPrevCost <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev Cost</em>' attribute.
	 * @see #getPrevCost()
	 * @generated
	 */
	void setPrevCost(double value);

	/**
	 * Returns the value of the '<em><b>Local Searches</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.LocalSearch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Local Searches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Local Searches</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch_LocalSearches()
	 * @model containment="true"
	 * @generated
	 */
	EList<LocalSearch> getLocalSearches();

	/**
	 * Returns the value of the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operation</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operation</em>' attribute.
	 * @see #setOperation(String)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getGlobalSearch_Operation()
	 * @model
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

} // GlobalSearch
