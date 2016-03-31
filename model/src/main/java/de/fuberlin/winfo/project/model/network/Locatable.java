/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Locatable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Locatable#getLatitude <em>Latitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Locatable#getLongitude <em>Longitude</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Locatable#getServiceTimeInSec <em>Service Time In Sec</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getLocatable()
 * @model abstract="true"
 * @generated
 */
public interface Locatable extends EObject {
	/**
	 * Returns the value of the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Latitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Latitude</em>' attribute.
	 * @see #setLatitude(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getLocatable_Latitude()
	 * @model
	 * @generated
	 */
	double getLatitude();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Locatable#getLatitude <em>Latitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Latitude</em>' attribute.
	 * @see #getLatitude()
	 * @generated
	 */
	void setLatitude(double value);

	/**
	 * Returns the value of the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Longitude</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Longitude</em>' attribute.
	 * @see #setLongitude(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getLocatable_Longitude()
	 * @model
	 * @generated
	 */
	double getLongitude();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Locatable#getLongitude <em>Longitude</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Longitude</em>' attribute.
	 * @see #getLongitude()
	 * @generated
	 */
	void setLongitude(double value);

	/**
	 * Returns the value of the '<em><b>Service Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service Time In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service Time In Sec</em>' attribute.
	 * @see #setServiceTimeInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getLocatable_ServiceTimeInSec()
	 * @model
	 * @generated
	 */
	int getServiceTimeInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Locatable#getServiceTimeInSec <em>Service Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service Time In Sec</em>' attribute.
	 * @see #getServiceTimeInSec()
	 * @generated
	 */
	void setServiceTimeInSec(int value);

} // Locatable
