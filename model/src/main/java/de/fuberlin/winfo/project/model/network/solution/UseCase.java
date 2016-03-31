/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import de.fuberlin.winfo.project.model.network.Depot;
import de.fuberlin.winfo.project.model.network.Vehicle;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Use Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getName <em>Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getVehicles <em>Vehicles</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getTranshipmentPoints <em>Transhipment Points</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getMaxTourLengthInSec <em>Max Tour Length In Sec</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getStorageCostsPerKgPerSec <em>Storage Costs Per Kg Per Sec</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase()
 * @model
 * @generated
 */
public interface UseCase extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_Id()
	 * @model required="true"
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Vehicles</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Vehicle}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vehicles</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vehicles</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_Vehicles()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vehicle> getVehicles();

	/**
	 * Returns the value of the '<em><b>Transhipment Points</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.Depot}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transhipment Points</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transhipment Points</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_TranshipmentPoints()
	 * @model containment="true"
	 * @generated
	 */
	EList<Depot> getTranshipmentPoints();

	/**
	 * Returns the value of the '<em><b>Max Tour Length In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Max Tour Length In Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Max Tour Length In Sec</em>' attribute.
	 * @see #setMaxTourLengthInSec(int)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_MaxTourLengthInSec()
	 * @model
	 * @generated
	 */
	int getMaxTourLengthInSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getMaxTourLengthInSec <em>Max Tour Length In Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Max Tour Length In Sec</em>' attribute.
	 * @see #getMaxTourLengthInSec()
	 * @generated
	 */
	void setMaxTourLengthInSec(int value);

	/**
	 * Returns the value of the '<em><b>Storage Costs Per Kg Per Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Storage Costs Per Kg Per Sec</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Storage Costs Per Kg Per Sec</em>' attribute.
	 * @see #setStorageCostsPerKgPerSec(double)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getUseCase_StorageCostsPerKgPerSec()
	 * @model
	 * @generated
	 */
	double getStorageCostsPerKgPerSec();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getStorageCostsPerKgPerSec <em>Storage Costs Per Kg Per Sec</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Storage Costs Per Kg Per Sec</em>' attribute.
	 * @see #getStorageCostsPerKgPerSec()
	 * @generated
	 */
	void setStorageCostsPerKgPerSec(double value);

} // UseCase
