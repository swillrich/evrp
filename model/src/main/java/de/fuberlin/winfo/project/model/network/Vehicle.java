/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vehicle</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxPayLoadInKg <em>Max Pay Load In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getCargoWeightInKg <em>Cargo Weight In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxBatteryCapacityInWH <em>Max Battery Capacity In WH</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle()
 * @model
 * @generated
 */
public interface Vehicle extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Max Pay Load In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Pay Load In Kg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Pay Load In Kg</em>' attribute.
	 * @see #setMaxPayLoadInKg(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_MaxPayLoadInKg()
	 * @model
	 * @generated
	 */
	int getMaxPayLoadInKg();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxPayLoadInKg <em>Max Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Pay Load In Kg</em>' attribute.
	 * @see #getMaxPayLoadInKg()
	 * @generated
	 */
	void setMaxPayLoadInKg(int value);

	/**
	 * Returns the value of the '<em><b>Cargo Weight In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cargo Weight In Kg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cargo Weight In Kg</em>' attribute.
	 * @see #setCargoWeightInKg(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_CargoWeightInKg()
	 * @model
	 * @generated
	 */
	int getCargoWeightInKg();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getCargoWeightInKg <em>Cargo Weight In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Cargo Weight In Kg</em>' attribute.
	 * @see #getCargoWeightInKg()
	 * @generated
	 */
	void setCargoWeightInKg(int value);

	/**
	 * Returns the value of the '<em><b>Max Battery Capacity In WH</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Battery Capacity In WH</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Battery Capacity In WH</em>' attribute.
	 * @see #setMaxBatteryCapacityInWH(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_MaxBatteryCapacityInWH()
	 * @model
	 * @generated
	 */
	int getMaxBatteryCapacityInWH();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxBatteryCapacityInWH <em>Max Battery Capacity In WH</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Battery Capacity In WH</em>' attribute.
	 * @see #getMaxBatteryCapacityInWH()
	 * @generated
	 */
	void setMaxBatteryCapacityInWH(int value);

} // Vehicle
