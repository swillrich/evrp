/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Route</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Route#getVehicle <em>Vehicle</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Route#getTotalDistanceInM <em>Total Distance In M</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Route#getTotalTimeInSec <em>Total Time In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Route#getWay <em>Way</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getRoute()
 * @model
 * @generated
 */
public interface Route extends EObject {
	/**
	 * Returns the value of the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicle</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicle</em>' reference.
	 * @see #setVehicle(Vehicle)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getRoute_Vehicle()
	 * @model required="true"
	 * @generated
	 */
	Vehicle getVehicle();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Route#getVehicle <em>Vehicle</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Vehicle</em>' reference.
	 * @see #getVehicle()
	 * @generated
	 */
	void setVehicle(Vehicle value);

	/**
	 * Returns the value of the '<em><b>Total Distance In M</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Distance In M</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Distance In M</em>' attribute.
	 * @see #setTotalDistanceInM(long)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getRoute_TotalDistanceInM()
	 * @model
	 * @generated
	 */
	long getTotalDistanceInM();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Route#getTotalDistanceInM <em>Total Distance In M</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Distance In M</em>' attribute.
	 * @see #getTotalDistanceInM()
	 * @generated
	 */
	void setTotalDistanceInM(long value);

	/**
	 * Returns the value of the '<em><b>Total Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time In Sec</em>' attribute.
	 * @see #setTotalTimeInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getRoute_TotalTimeInSec()
	 * @model
	 * @generated
	 */
	int getTotalTimeInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Route#getTotalTimeInSec <em>Total Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time In Sec</em>' attribute.
	 * @see #getTotalTimeInSec()
	 * @generated
	 */
	void setTotalTimeInSec(int value);

	/**
	 * Returns the value of the '<em><b>Way</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.UsedArc}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Way</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Way</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getRoute_Way()
	 * @model containment="true"
	 * @generated
	 */
	EList<UsedArc> getWay();

} // Route
