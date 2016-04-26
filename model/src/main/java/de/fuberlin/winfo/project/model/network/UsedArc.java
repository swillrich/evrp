/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Used Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.UsedArc#getArc <em>Arc</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.UsedArc#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.UsedArc#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.UsedArc#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getUsedArc()
 * @model
 * @generated
 */
public interface UsedArc extends EObject {
	/**
	 * Returns the value of the '<em><b>Arc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arc</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arc</em>' reference.
	 * @see #setArc(Arc)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getUsedArc_Arc()
	 * @model required="true"
	 * @generated
	 */
	Arc getArc();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.UsedArc#getArc <em>Arc</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Arc</em>' reference.
	 * @see #getArc()
	 * @generated
	 */
	void setArc(Arc value);

	/**
	 * Returns the value of the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Current Vehicle Cargo Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Current Vehicle Cargo Weight</em>' attribute.
	 * @see #setCurrentVehicleCargoWeight(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getUsedArc_CurrentVehicleCargoWeight()
	 * @model
	 * @generated
	 */
	double getCurrentVehicleCargoWeight();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.UsedArc#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Current Vehicle Cargo Weight</em>' attribute.
	 * @see #getCurrentVehicleCargoWeight()
	 * @generated
	 */
	void setCurrentVehicleCargoWeight(double value);

	/**
	 * Returns the value of the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Duration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Duration</em>' containment reference.
	 * @see #setDuration(Duration)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getUsedArc_Duration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Duration getDuration();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.UsedArc#getDuration <em>Duration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Duration</em>' containment reference.
	 * @see #getDuration()
	 * @generated
	 */
	void setDuration(Duration value);

	/**
	 * Returns the value of the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Remaining Vehicle Battery Capacity At End</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remaining Vehicle Battery Capacity At End</em>' attribute.
	 * @see #setRemainingVehicleBatteryCapacityAtEnd(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getUsedArc_RemainingVehicleBatteryCapacityAtEnd()
	 * @model
	 * @generated
	 */
	int getRemainingVehicleBatteryCapacityAtEnd();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.UsedArc#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Vehicle Battery Capacity At End</em>' attribute.
	 * @see #getRemainingVehicleBatteryCapacityAtEnd()
	 * @generated
	 */
	void setRemainingVehicleBatteryCapacityAtEnd(int value);

} // UsedArc
