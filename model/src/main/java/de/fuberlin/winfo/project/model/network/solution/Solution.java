/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getRoutes <em>Routes</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalDistance <em>Total Distance</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getUsecase <em>Usecase</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getHistory <em>History</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.Solution#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 *
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution()
 * @model
 * @generated
 */
public interface Solution extends EObject {
	/**
	 * Returns the value of the '<em><b>Routes</b></em>' containment reference list.
	 * The list contents are of type {@link de.fuberlin.winfo.project.model.network.solution.Route}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Routes</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Routes</em>' containment reference list.
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_Routes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Route> getRoutes();

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
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

	/**
	 * Returns the value of the '<em><b>Total Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Distance</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Distance</em>' attribute.
	 * @see #setTotalDistance(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_TotalDistance()
	 * @model
	 * @generated
	 */
	long getTotalDistance();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalDistance <em>Total Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Distance</em>' attribute.
	 * @see #getTotalDistance()
	 * @generated
	 */
	void setTotalDistance(long value);

	/**
	 * Returns the value of the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Total Time</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Total Time</em>' attribute.
	 * @see #setTotalTime(long)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_TotalTime()
	 * @model
	 * @generated
	 */
	long getTotalTime();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalTime <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Total Time</em>' attribute.
	 * @see #getTotalTime()
	 * @generated
	 */
	void setTotalTime(long value);

	/**
	 * Returns the value of the '<em><b>Procedure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Procedure</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Procedure</em>' attribute.
	 * @see #setProcedure(String)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_Procedure()
	 * @model
	 * @generated
	 */
	String getProcedure();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getProcedure <em>Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Procedure</em>' attribute.
	 * @see #getProcedure()
	 * @generated
	 */
	void setProcedure(String value);

	/**
	 * Returns the value of the '<em><b>Usecase</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Usecase</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Usecase</em>' containment reference.
	 * @see #setUsecase(UseCase)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_Usecase()
	 * @model containment="true" required="true"
	 * @generated
	 */
	UseCase getUsecase();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getUsecase <em>Usecase</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Usecase</em>' containment reference.
	 * @see #getUsecase()
	 * @generated
	 */
	void setUsecase(UseCase value);

	/**
	 * Returns the value of the '<em><b>History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History</em>' containment reference.
	 * @see #setHistory(SearchHistory)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_History()
	 * @model containment="true"
	 * @generated
	 */
	SearchHistory getHistory();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getHistory <em>History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History</em>' containment reference.
	 * @see #getHistory()
	 * @generated
	 */
	void setHistory(SearchHistory value);

	/**
	 * Returns the value of the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Algorithm Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Algorithm Name</em>' attribute.
	 * @see #setAlgorithmName(String)
	 * @see de.fuberlin.winfo.project.model.network.solution.SolutionPackage#getSolution_AlgorithmName()
	 * @model
	 * @generated
	 */
	String getAlgorithmName();

	/**
	 * Sets the value of the '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getAlgorithmName <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Algorithm Name</em>' attribute.
	 * @see #getAlgorithmName()
	 * @generated
	 */
	void setAlgorithmName(String value);

} // Solution
