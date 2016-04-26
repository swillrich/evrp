/**
 */
package de.fuberlin.winfo.project.model.network;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Depot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Depot#getFixPlaceTimeIfMultipleOperations <em>Fix Place Time If Multiple Operations</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Depot#getMaxTourLength <em>Max Tour Length</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Depot#getMaxEmployment <em>Max Employment</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDepot()
 * @model
 * @generated
 */
public interface Depot extends Vertex, Locatable {
	/**
	 * Returns the value of the '<em><b>Fix Place Time If Multiple Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fix Place Time If Multiple Operations</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fix Place Time If Multiple Operations</em>' attribute.
	 * @see #setFixPlaceTimeIfMultipleOperations(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDepot_FixPlaceTimeIfMultipleOperations()
	 * @model
	 * @generated
	 */
	int getFixPlaceTimeIfMultipleOperations();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Depot#getFixPlaceTimeIfMultipleOperations <em>Fix Place Time If Multiple Operations</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fix Place Time If Multiple Operations</em>' attribute.
	 * @see #getFixPlaceTimeIfMultipleOperations()
	 * @generated
	 */
	void setFixPlaceTimeIfMultipleOperations(int value);

	/**
	 * Returns the value of the '<em><b>Max Tour Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Tour Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Tour Length</em>' attribute.
	 * @see #setMaxTourLength(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDepot_MaxTourLength()
	 * @model
	 * @generated
	 */
	int getMaxTourLength();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Depot#getMaxTourLength <em>Max Tour Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Tour Length</em>' attribute.
	 * @see #getMaxTourLength()
	 * @generated
	 */
	void setMaxTourLength(int value);

	/**
	 * Returns the value of the '<em><b>Max Employment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Employment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Employment</em>' attribute.
	 * @see #setMaxEmployment(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDepot_MaxEmployment()
	 * @model
	 * @generated
	 */
	int getMaxEmployment();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Depot#getMaxEmployment <em>Max Employment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Employment</em>' attribute.
	 * @see #getMaxEmployment()
	 * @generated
	 */
	void setMaxEmployment(int value);

} // Depot
