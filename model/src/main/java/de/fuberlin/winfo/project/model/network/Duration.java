/**
 */
package de.fuberlin.winfo.project.model.network;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Duration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Duration#getStartInSec <em>Start In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.Duration#getEndInSec <em>End In Sec</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDuration()
 * @model
 * @generated
 */
public interface Duration extends EObject {
	/**
	 * Returns the value of the '<em><b>Start In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start In Sec</em>' attribute.
	 * @see #setStartInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDuration_StartInSec()
	 * @model
	 * @generated
	 */
	int getStartInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Duration#getStartInSec <em>Start In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start In Sec</em>' attribute.
	 * @see #getStartInSec()
	 * @generated
	 */
	void setStartInSec(int value);

	/**
	 * Returns the value of the '<em><b>End In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End In Sec</em>' attribute.
	 * @see #setEndInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.NetworkPackage#getDuration_EndInSec()
	 * @model
	 * @generated
	 */
	int getEndInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.Duration#getEndInSec <em>End In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End In Sec</em>' attribute.
	 * @see #getEndInSec()
	 * @generated
	 */
	void setEndInSec(int value);

} // Duration
