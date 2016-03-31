/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import de.fuberlin.winfo.project.model.network.Duration;
import de.fuberlin.winfo.project.model.network.Edge;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Used Edge</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getEdge <em>Edge</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getDuration <em>Duration</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUsedEdge()
 * @model
 * @generated
 */
public interface UsedEdge extends EObject {
	/**
	 * Returns the value of the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Edge</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Edge</em>' reference.
	 * @see #setEdge(Edge)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUsedEdge_Edge()
	 * @model required="true"
	 * @generated
	 */
	Edge getEdge();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getEdge <em>Edge</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Edge</em>' reference.
	 * @see #getEdge()
	 * @generated
	 */
	void setEdge(Edge value);

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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUsedEdge_CurrentVehicleCargoWeight()
	 * @model
	 * @generated
	 */
	double getCurrentVehicleCargoWeight();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}' attribute.
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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUsedEdge_Duration()
	 * @model containment="true" required="true"
	 * @generated
	 */
	Duration getDuration();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getDuration <em>Duration</em>}' containment reference.
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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUsedEdge_RemainingVehicleBatteryCapacityAtEnd()
	 * @model
	 * @generated
	 */
	int getRemainingVehicleBatteryCapacityAtEnd();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remaining Vehicle Battery Capacity At End</em>' attribute.
	 * @see #getRemainingVehicleBatteryCapacityAtEnd()
	 * @generated
	 */
	void setRemainingVehicleBatteryCapacityAtEnd(int value);

} // UsedEdge
