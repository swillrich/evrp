/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Search History</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.SearchHistory#getVnsSearches <em>Vns Searches</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.SearchHistory#getCreationTime <em>Creation Time</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSearchHistory()
 * @model
 * @generated
 */
public interface SearchHistory extends EObject {
	/**
	 * Returns the value of the '<em><b>Vns Searches</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.solution.VNSSearch}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vns Searches</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vns Searches</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSearchHistory_VnsSearches()
	 * @model containment="true"
	 * @generated
	 */
	EList<VNSSearch> getVnsSearches();

	/**
	 * Returns the value of the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Creation Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Time</em>' attribute.
	 * @see #setCreationTime(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSearchHistory_CreationTime()
	 * @model
	 * @generated
	 */
	long getCreationTime();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.SearchHistory#getCreationTime <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Time</em>' attribute.
	 * @see #getCreationTime()
	 * @generated
	 */
	void setCreationTime(long value);

} // SearchHistory
