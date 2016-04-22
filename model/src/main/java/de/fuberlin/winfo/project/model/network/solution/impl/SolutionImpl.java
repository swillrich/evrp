/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.solution.Route;
import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.Solution;
import de.fuberlin.winfo.project.model.network.solution.SolutionPackage;
import de.fuberlin.winfo.project.model.network.solution.UseCase;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Solution</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getTotalDistance <em>Total Distance</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getProcedure <em>Procedure</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getUsecase <em>Usecase</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getHistory <em>History</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl#getAlgorithmName <em>Algorithm Name</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SolutionImpl extends MinimalEObjectImpl.Container implements Solution {
	/**
	 * The cached value of the '{@link #getRoutes() <em>Routes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRoutes()
	 * @generated
	 * @ordered
	 */
	protected EList<Route> routes;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalDistance() <em>Total Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDistance()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_DISTANCE_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalDistance() <em>Total Distance</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalDistance()
	 * @generated
	 * @ordered
	 */
	protected long totalDistance = TOTAL_DISTANCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalTime() <em>Total Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalTime()
	 * @generated
	 * @ordered
	 */
	protected long totalTime = TOTAL_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected static final String PROCEDURE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getProcedure() <em>Procedure</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcedure()
	 * @generated
	 * @ordered
	 */
	protected String procedure = PROCEDURE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUsecase() <em>Usecase</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsecase()
	 * @generated
	 * @ordered
	 */
	protected UseCase usecase;

	/**
	 * The cached value of the '{@link #getHistory() <em>History</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistory()
	 * @generated
	 * @ordered
	 */
	protected SearchHistory history;

	/**
	 * The default value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected static final String ALGORITHM_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAlgorithmName() <em>Algorithm Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAlgorithmName()
	 * @generated
	 * @ordered
	 */
	protected String algorithmName = ALGORITHM_NAME_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SolutionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Route> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList<Route>(Route.class, this, SolutionPackage.SOLUTION__ROUTES);
		}
		return routes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalDistance() {
		return totalDistance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalDistance(long newTotalDistance) {
		long oldTotalDistance = totalDistance;
		totalDistance = newTotalDistance;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__TOTAL_DISTANCE, oldTotalDistance, totalDistance));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalTime() {
		return totalTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalTime(long newTotalTime) {
		long oldTotalTime = totalTime;
		totalTime = newTotalTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__TOTAL_TIME, oldTotalTime, totalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getProcedure() {
		return procedure;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setProcedure(String newProcedure) {
		String oldProcedure = procedure;
		procedure = newProcedure;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__PROCEDURE, oldProcedure, procedure));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase getUsecase() {
		return usecase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetUsecase(UseCase newUsecase, NotificationChain msgs) {
		UseCase oldUsecase = usecase;
		usecase = newUsecase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__USECASE, oldUsecase, newUsecase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUsecase(UseCase newUsecase) {
		if (newUsecase != usecase) {
			NotificationChain msgs = null;
			if (usecase != null)
				msgs = ((InternalEObject)usecase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.SOLUTION__USECASE, null, msgs);
			if (newUsecase != null)
				msgs = ((InternalEObject)newUsecase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.SOLUTION__USECASE, null, msgs);
			msgs = basicSetUsecase(newUsecase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__USECASE, newUsecase, newUsecase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchHistory getHistory() {
		return history;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistory(SearchHistory newHistory, NotificationChain msgs) {
		SearchHistory oldHistory = history;
		history = newHistory;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__HISTORY, oldHistory, newHistory);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistory(SearchHistory newHistory) {
		if (newHistory != history) {
			NotificationChain msgs = null;
			if (history != null)
				msgs = ((InternalEObject)history).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.SOLUTION__HISTORY, null, msgs);
			if (newHistory != null)
				msgs = ((InternalEObject)newHistory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SolutionPackage.SOLUTION__HISTORY, null, msgs);
			msgs = basicSetHistory(newHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__HISTORY, newHistory, newHistory));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getAlgorithmName() {
		return algorithmName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAlgorithmName(String newAlgorithmName) {
		String oldAlgorithmName = algorithmName;
		algorithmName = newAlgorithmName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SolutionPackage.SOLUTION__ALGORITHM_NAME, oldAlgorithmName, algorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolutionPackage.SOLUTION__ROUTES:
				return ((InternalEList<?>)getRoutes()).basicRemove(otherEnd, msgs);
			case SolutionPackage.SOLUTION__USECASE:
				return basicSetUsecase(null, msgs);
			case SolutionPackage.SOLUTION__HISTORY:
				return basicSetHistory(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SolutionPackage.SOLUTION__ROUTES:
				return getRoutes();
			case SolutionPackage.SOLUTION__ID:
				return getId();
			case SolutionPackage.SOLUTION__TOTAL_DISTANCE:
				return getTotalDistance();
			case SolutionPackage.SOLUTION__TOTAL_TIME:
				return getTotalTime();
			case SolutionPackage.SOLUTION__PROCEDURE:
				return getProcedure();
			case SolutionPackage.SOLUTION__USECASE:
				return getUsecase();
			case SolutionPackage.SOLUTION__HISTORY:
				return getHistory();
			case SolutionPackage.SOLUTION__ALGORITHM_NAME:
				return getAlgorithmName();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SolutionPackage.SOLUTION__ROUTES:
				getRoutes().clear();
				getRoutes().addAll((Collection<? extends Route>)newValue);
				return;
			case SolutionPackage.SOLUTION__ID:
				setId((String)newValue);
				return;
			case SolutionPackage.SOLUTION__TOTAL_DISTANCE:
				setTotalDistance((Long)newValue);
				return;
			case SolutionPackage.SOLUTION__TOTAL_TIME:
				setTotalTime((Long)newValue);
				return;
			case SolutionPackage.SOLUTION__PROCEDURE:
				setProcedure((String)newValue);
				return;
			case SolutionPackage.SOLUTION__USECASE:
				setUsecase((UseCase)newValue);
				return;
			case SolutionPackage.SOLUTION__HISTORY:
				setHistory((SearchHistory)newValue);
				return;
			case SolutionPackage.SOLUTION__ALGORITHM_NAME:
				setAlgorithmName((String)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SolutionPackage.SOLUTION__ROUTES:
				getRoutes().clear();
				return;
			case SolutionPackage.SOLUTION__ID:
				setId(ID_EDEFAULT);
				return;
			case SolutionPackage.SOLUTION__TOTAL_DISTANCE:
				setTotalDistance(TOTAL_DISTANCE_EDEFAULT);
				return;
			case SolutionPackage.SOLUTION__TOTAL_TIME:
				setTotalTime(TOTAL_TIME_EDEFAULT);
				return;
			case SolutionPackage.SOLUTION__PROCEDURE:
				setProcedure(PROCEDURE_EDEFAULT);
				return;
			case SolutionPackage.SOLUTION__USECASE:
				setUsecase((UseCase)null);
				return;
			case SolutionPackage.SOLUTION__HISTORY:
				setHistory((SearchHistory)null);
				return;
			case SolutionPackage.SOLUTION__ALGORITHM_NAME:
				setAlgorithmName(ALGORITHM_NAME_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SolutionPackage.SOLUTION__ROUTES:
				return routes != null && !routes.isEmpty();
			case SolutionPackage.SOLUTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case SolutionPackage.SOLUTION__TOTAL_DISTANCE:
				return totalDistance != TOTAL_DISTANCE_EDEFAULT;
			case SolutionPackage.SOLUTION__TOTAL_TIME:
				return totalTime != TOTAL_TIME_EDEFAULT;
			case SolutionPackage.SOLUTION__PROCEDURE:
				return PROCEDURE_EDEFAULT == null ? procedure != null : !PROCEDURE_EDEFAULT.equals(procedure);
			case SolutionPackage.SOLUTION__USECASE:
				return usecase != null;
			case SolutionPackage.SOLUTION__HISTORY:
				return history != null;
			case SolutionPackage.SOLUTION__ALGORITHM_NAME:
				return ALGORITHM_NAME_EDEFAULT == null ? algorithmName != null : !ALGORITHM_NAME_EDEFAULT.equals(algorithmName);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (id: ");
		result.append(id);
		result.append(", totalDistance: ");
		result.append(totalDistance);
		result.append(", totalTime: ");
		result.append(totalTime);
		result.append(", procedure: ");
		result.append(procedure);
		result.append(", algorithmName: ");
		result.append(algorithmName);
		result.append(')');
		return result.toString();
	}

} //SolutionImpl
