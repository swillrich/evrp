/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Order</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Order#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsVolume <em>Need As Volume</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsWeight <em>Need As Weight</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Order#getTimeWindow <em>Time Window</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Order#getStandingTimeInSec <em>Standing Time In Sec</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder()
 * @model
 * @generated
 */
public interface Order extends EObject {
	/**
	 * Returns the value of the '<em><b>Need As Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need As Volume</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need As Volume</em>' attribute.
	 * @see #setNeedAsVolume(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder_NeedAsVolume()
	 * @model
	 * @generated
	 */
	double getNeedAsVolume();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsVolume <em>Need As Volume</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need As Volume</em>' attribute.
	 * @see #getNeedAsVolume()
	 * @generated
	 */
	void setNeedAsVolume(double value);

	/**
	 * Returns the value of the '<em><b>Need As Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Need As Weight</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Need As Weight</em>' attribute.
	 * @see #setNeedAsWeight(double)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder_NeedAsWeight()
	 * @model
	 * @generated
	 */
	double getNeedAsWeight();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsWeight <em>Need As Weight</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Need As Weight</em>' attribute.
	 * @see #getNeedAsWeight()
	 * @generated
	 */
	void setNeedAsWeight(double value);

	/**
	 * Returns the value of the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Window</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Window</em>' containment reference.
	 * @see #setTimeWindow(Duration)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder_TimeWindow()
	 * @model containment="true"
	 * @generated
	 */
	Duration getTimeWindow();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Order#getTimeWindow <em>Time Window</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Window</em>' containment reference.
	 * @see #getTimeWindow()
	 * @generated
	 */
	void setTimeWindow(Duration value);

	/**
	 * Returns the value of the '<em><b>Standing Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Standing Time In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Standing Time In Sec</em>' attribute.
	 * @see #setStandingTimeInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder_StandingTimeInSec()
	 * @model
	 * @generated
	 */
	int getStandingTimeInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Order#getStandingTimeInSec <em>Standing Time In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Standing Time In Sec</em>' attribute.
	 * @see #getStandingTimeInSec()
	 * @generated
	 */
	void setStandingTimeInSec(int value);

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
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getOrder_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Order#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

} // Order
