/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>VNS Search</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getCost <em>Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getPrevCost <em>Prev Cost</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getNeighborhoodSearches <em>Neighborhood Searches</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getOperation <em>Operation</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getTime <em>Time</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch()
 * @model
 * @generated
 */
public interface VNSSearch extends EObject {
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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getName <em>Name</em>}' attribute.
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
	 * @see #setCost(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_Cost()
	 * @model
	 * @generated
	 */
	long getCost();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getCost <em>Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cost</em>' attribute.
	 * @see #getCost()
	 * @generated
	 */
	void setCost(long value);

	/**
	 * Returns the value of the '<em><b>Prev Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Prev Cost</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Prev Cost</em>' attribute.
	 * @see #setPrevCost(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_PrevCost()
	 * @model
	 * @generated
	 */
	long getPrevCost();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getPrevCost <em>Prev Cost</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Prev Cost</em>' attribute.
	 * @see #getPrevCost()
	 * @generated
	 */
	void setPrevCost(long value);

	/**
	 * Returns the value of the '<em><b>Neighborhood Searches</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Neighborhood Searches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Neighborhood Searches</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_NeighborhoodSearches()
	 * @model containment="true"
	 * @generated
	 */
	EList<NeighborhoodSearch> getNeighborhoodSearches();

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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_Operation()
	 * @model
	 * @generated
	 */
	String getOperation();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getOperation <em>Operation</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operation</em>' attribute.
	 * @see #getOperation()
	 * @generated
	 */
	void setOperation(String value);

	/**
	 * Returns the value of the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time</em>' attribute.
	 * @see #setTime(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getVNSSearch_Time()
	 * @model
	 * @generated
	 */
	long getTime();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getTime <em>Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time</em>' attribute.
	 * @see #getTime()
	 * @generated
	 */
	void setTime(long value);

} // VNSSearch
