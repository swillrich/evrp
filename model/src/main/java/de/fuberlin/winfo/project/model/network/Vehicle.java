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
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxCapacatyPayLoadInKg <em>Max Capacaty Pay Load In Kg</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxReachInMeter <em>Max Reach In Meter</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getChangeBatteryTime <em>Change Battery Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryType <em>Battery Type</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryCapacityInWh <em>Battery Capacity In Wh</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getOperatingCostsPerMeter <em>Operating Costs Per Meter</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getDriverCostsPerHour <em>Driver Costs Per Hour</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getTransshipmentFixCostsEuro <em>Transshipment Fix Costs Euro</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getTranshipmentTimeInMinutes <em>Transhipment Time In Minutes</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Vehicle#getPayLoadDependingConsumptionRate <em>Pay Load Depending Consumption Rate</em>}</li>
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
	 * Returns the value of the '<em><b>Max Capacaty Pay Load In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Capacaty Pay Load In Kg</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Capacaty Pay Load In Kg</em>' attribute.
	 * @see #setMaxCapacatyPayLoadInKg(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_MaxCapacatyPayLoadInKg()
	 * @model
	 * @generated
	 */
	double getMaxCapacatyPayLoadInKg();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxCapacatyPayLoadInKg <em>Max Capacaty Pay Load In Kg</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Capacaty Pay Load In Kg</em>' attribute.
	 * @see #getMaxCapacatyPayLoadInKg()
	 * @generated
	 */
	void setMaxCapacatyPayLoadInKg(double value);

	/**
	 * Returns the value of the '<em><b>Max Reach In Meter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Reach In Meter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Reach In Meter</em>' attribute.
	 * @see #setMaxReachInMeter(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_MaxReachInMeter()
	 * @model
	 * @generated
	 */
	int getMaxReachInMeter();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxReachInMeter <em>Max Reach In Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Reach In Meter</em>' attribute.
	 * @see #getMaxReachInMeter()
	 * @generated
	 */
	void setMaxReachInMeter(int value);

	/**
	 * Returns the value of the '<em><b>Change Battery Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Change Battery Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Change Battery Time</em>' attribute.
	 * @see #setChangeBatteryTime(long)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_ChangeBatteryTime()
	 * @model
	 * @generated
	 */
	long getChangeBatteryTime();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getChangeBatteryTime <em>Change Battery Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Change Battery Time</em>' attribute.
	 * @see #getChangeBatteryTime()
	 * @generated
	 */
	void setChangeBatteryTime(long value);

	/**
	 * Returns the value of the '<em><b>Battery Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Battery Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Battery Type</em>' attribute.
	 * @see #setBatteryType(String)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_BatteryType()
	 * @model
	 * @generated
	 */
	String getBatteryType();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryType <em>Battery Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Battery Type</em>' attribute.
	 * @see #getBatteryType()
	 * @generated
	 */
	void setBatteryType(String value);

	/**
	 * Returns the value of the '<em><b>Battery Capacity In Wh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Battery Capacity In Wh</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Battery Capacity In Wh</em>' attribute.
	 * @see #setBatteryCapacityInWh(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_BatteryCapacityInWh()
	 * @model
	 * @generated
	 */
	int getBatteryCapacityInWh();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryCapacityInWh <em>Battery Capacity In Wh</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Battery Capacity In Wh</em>' attribute.
	 * @see #getBatteryCapacityInWh()
	 * @generated
	 */
	void setBatteryCapacityInWh(int value);

	/**
	 * Returns the value of the '<em><b>Operating Costs Per Meter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operating Costs Per Meter</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operating Costs Per Meter</em>' attribute.
	 * @see #setOperatingCostsPerMeter(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_OperatingCostsPerMeter()
	 * @model
	 * @generated
	 */
	double getOperatingCostsPerMeter();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getOperatingCostsPerMeter <em>Operating Costs Per Meter</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operating Costs Per Meter</em>' attribute.
	 * @see #getOperatingCostsPerMeter()
	 * @generated
	 */
	void setOperatingCostsPerMeter(double value);

	/**
	 * Returns the value of the '<em><b>Driver Costs Per Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Driver Costs Per Hour</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Costs Per Hour</em>' attribute.
	 * @see #setDriverCostsPerHour(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_DriverCostsPerHour()
	 * @model
	 * @generated
	 */
	double getDriverCostsPerHour();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getDriverCostsPerHour <em>Driver Costs Per Hour</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Costs Per Hour</em>' attribute.
	 * @see #getDriverCostsPerHour()
	 * @generated
	 */
	void setDriverCostsPerHour(double value);

	/**
	 * Returns the value of the '<em><b>Transshipment Fix Costs Euro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transshipment Fix Costs Euro</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transshipment Fix Costs Euro</em>' attribute.
	 * @see #setTransshipmentFixCostsEuro(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_TransshipmentFixCostsEuro()
	 * @model
	 * @generated
	 */
	double getTransshipmentFixCostsEuro();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getTransshipmentFixCostsEuro <em>Transshipment Fix Costs Euro</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transshipment Fix Costs Euro</em>' attribute.
	 * @see #getTransshipmentFixCostsEuro()
	 * @generated
	 */
	void setTransshipmentFixCostsEuro(double value);

	/**
	 * Returns the value of the '<em><b>Transhipment Time In Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transhipment Time In Minutes</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transhipment Time In Minutes</em>' attribute.
	 * @see #setTranshipmentTimeInMinutes(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_TranshipmentTimeInMinutes()
	 * @model
	 * @generated
	 */
	double getTranshipmentTimeInMinutes();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getTranshipmentTimeInMinutes <em>Transhipment Time In Minutes</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transhipment Time In Minutes</em>' attribute.
	 * @see #getTranshipmentTimeInMinutes()
	 * @generated
	 */
	void setTranshipmentTimeInMinutes(double value);

	/**
	 * Returns the value of the '<em><b>Pay Load Depending Consumption Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pay Load Depending Consumption Rate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pay Load Depending Consumption Rate</em>' attribute.
	 * @see #setPayLoadDependingConsumptionRate(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getVehicle_PayLoadDependingConsumptionRate()
	 * @model
	 * @generated
	 */
	double getPayLoadDependingConsumptionRate();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Vehicle#getPayLoadDependingConsumptionRate <em>Pay Load Depending Consumption Rate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Pay Load Depending Consumption Rate</em>' attribute.
	 * @see #getPayLoadDependingConsumptionRate()
	 * @generated
	 */
	void setPayLoadDependingConsumptionRate(double value);

} // Vehicle
