/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Route;
import de.fuberlin.winfo.project.model.network.SearchHistory;
import de.fuberlin.winfo.project.model.network.Solution;
import de.fuberlin.winfo.project.model.network.UseCase;

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
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getRoutes <em>Routes</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getTotalDistance <em>Total Distance</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getTotalTime <em>Total Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getTotalVehicleBatteryConsumption <em>Total Vehicle Battery Consumption</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getUsecase <em>Usecase</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getHistory <em>History</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getAlgorithmName <em>Algorithm Name</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getCreationTime <em>Creation Time</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl#getSolvingTime <em>Solving Time</em>}</li>
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
	 * The default value of the '{@link #getTotalVehicleBatteryConsumption() <em>Total Vehicle Battery Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehicleBatteryConsumption()
	 * @generated
	 * @ordered
	 */
	protected static final long TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getTotalVehicleBatteryConsumption() <em>Total Vehicle Battery Consumption</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTotalVehicleBatteryConsumption()
	 * @generated
	 * @ordered
	 */
	protected long totalVehicleBatteryConsumption = TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT;

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
	 * The default value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected static final long CREATION_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getCreationTime() <em>Creation Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationTime()
	 * @generated
	 * @ordered
	 */
	protected long creationTime = CREATION_TIME_EDEFAULT;

	/**
	 * The default value of the '{@link #getSolvingTime() <em>Solving Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvingTime()
	 * @generated
	 * @ordered
	 */
	protected static final long SOLVING_TIME_EDEFAULT = 0L;

	/**
	 * The cached value of the '{@link #getSolvingTime() <em>Solving Time</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSolvingTime()
	 * @generated
	 * @ordered
	 */
	protected long solvingTime = SOLVING_TIME_EDEFAULT;

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
		return NetworkPackage.Literals.SOLUTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Route> getRoutes() {
		if (routes == null) {
			routes = new EObjectContainmentEList<Route>(Route.class, this, NetworkPackage.SOLUTION__ROUTES);
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__ID, oldId, id));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__TOTAL_DISTANCE, oldTotalDistance, totalDistance));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__TOTAL_TIME, oldTotalTime, totalTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getTotalVehicleBatteryConsumption() {
		return totalVehicleBatteryConsumption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTotalVehicleBatteryConsumption(long newTotalVehicleBatteryConsumption) {
		long oldTotalVehicleBatteryConsumption = totalVehicleBatteryConsumption;
		totalVehicleBatteryConsumption = newTotalVehicleBatteryConsumption;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION, oldTotalVehicleBatteryConsumption, totalVehicleBatteryConsumption));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__USECASE, oldUsecase, newUsecase);
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
				msgs = ((InternalEObject)usecase).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.SOLUTION__USECASE, null, msgs);
			if (newUsecase != null)
				msgs = ((InternalEObject)newUsecase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.SOLUTION__USECASE, null, msgs);
			msgs = basicSetUsecase(newUsecase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__USECASE, newUsecase, newUsecase));
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__HISTORY, oldHistory, newHistory);
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
				msgs = ((InternalEObject)history).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.SOLUTION__HISTORY, null, msgs);
			if (newHistory != null)
				msgs = ((InternalEObject)newHistory).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.SOLUTION__HISTORY, null, msgs);
			msgs = basicSetHistory(newHistory, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__HISTORY, newHistory, newHistory));
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
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__ALGORITHM_NAME, oldAlgorithmName, algorithmName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getCreationTime() {
		return creationTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationTime(long newCreationTime) {
		long oldCreationTime = creationTime;
		creationTime = newCreationTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__CREATION_TIME, oldCreationTime, creationTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public long getSolvingTime() {
		return solvingTime;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSolvingTime(long newSolvingTime) {
		long oldSolvingTime = solvingTime;
		solvingTime = newSolvingTime;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.SOLUTION__SOLVING_TIME, oldSolvingTime, solvingTime));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.SOLUTION__ROUTES:
				return ((InternalEList<?>)getRoutes()).basicRemove(otherEnd, msgs);
			case NetworkPackage.SOLUTION__USECASE:
				return basicSetUsecase(null, msgs);
			case NetworkPackage.SOLUTION__HISTORY:
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
			case NetworkPackage.SOLUTION__ROUTES:
				return getRoutes();
			case NetworkPackage.SOLUTION__ID:
				return getId();
			case NetworkPackage.SOLUTION__TOTAL_DISTANCE:
				return getTotalDistance();
			case NetworkPackage.SOLUTION__TOTAL_TIME:
				return getTotalTime();
			case NetworkPackage.SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				return getTotalVehicleBatteryConsumption();
			case NetworkPackage.SOLUTION__USECASE:
				return getUsecase();
			case NetworkPackage.SOLUTION__HISTORY:
				return getHistory();
			case NetworkPackage.SOLUTION__ALGORITHM_NAME:
				return getAlgorithmName();
			case NetworkPackage.SOLUTION__CREATION_TIME:
				return getCreationTime();
			case NetworkPackage.SOLUTION__SOLVING_TIME:
				return getSolvingTime();
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
			case NetworkPackage.SOLUTION__ROUTES:
				getRoutes().clear();
				getRoutes().addAll((Collection<? extends Route>)newValue);
				return;
			case NetworkPackage.SOLUTION__ID:
				setId((String)newValue);
				return;
			case NetworkPackage.SOLUTION__TOTAL_DISTANCE:
				setTotalDistance((Long)newValue);
				return;
			case NetworkPackage.SOLUTION__TOTAL_TIME:
				setTotalTime((Long)newValue);
				return;
			case NetworkPackage.SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				setTotalVehicleBatteryConsumption((Long)newValue);
				return;
			case NetworkPackage.SOLUTION__USECASE:
				setUsecase((UseCase)newValue);
				return;
			case NetworkPackage.SOLUTION__HISTORY:
				setHistory((SearchHistory)newValue);
				return;
			case NetworkPackage.SOLUTION__ALGORITHM_NAME:
				setAlgorithmName((String)newValue);
				return;
			case NetworkPackage.SOLUTION__CREATION_TIME:
				setCreationTime((Long)newValue);
				return;
			case NetworkPackage.SOLUTION__SOLVING_TIME:
				setSolvingTime((Long)newValue);
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
			case NetworkPackage.SOLUTION__ROUTES:
				getRoutes().clear();
				return;
			case NetworkPackage.SOLUTION__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__TOTAL_DISTANCE:
				setTotalDistance(TOTAL_DISTANCE_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__TOTAL_TIME:
				setTotalTime(TOTAL_TIME_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				setTotalVehicleBatteryConsumption(TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__USECASE:
				setUsecase((UseCase)null);
				return;
			case NetworkPackage.SOLUTION__HISTORY:
				setHistory((SearchHistory)null);
				return;
			case NetworkPackage.SOLUTION__ALGORITHM_NAME:
				setAlgorithmName(ALGORITHM_NAME_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__CREATION_TIME:
				setCreationTime(CREATION_TIME_EDEFAULT);
				return;
			case NetworkPackage.SOLUTION__SOLVING_TIME:
				setSolvingTime(SOLVING_TIME_EDEFAULT);
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
			case NetworkPackage.SOLUTION__ROUTES:
				return routes != null && !routes.isEmpty();
			case NetworkPackage.SOLUTION__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case NetworkPackage.SOLUTION__TOTAL_DISTANCE:
				return totalDistance != TOTAL_DISTANCE_EDEFAULT;
			case NetworkPackage.SOLUTION__TOTAL_TIME:
				return totalTime != TOTAL_TIME_EDEFAULT;
			case NetworkPackage.SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION:
				return totalVehicleBatteryConsumption != TOTAL_VEHICLE_BATTERY_CONSUMPTION_EDEFAULT;
			case NetworkPackage.SOLUTION__USECASE:
				return usecase != null;
			case NetworkPackage.SOLUTION__HISTORY:
				return history != null;
			case NetworkPackage.SOLUTION__ALGORITHM_NAME:
				return ALGORITHM_NAME_EDEFAULT == null ? algorithmName != null : !ALGORITHM_NAME_EDEFAULT.equals(algorithmName);
			case NetworkPackage.SOLUTION__CREATION_TIME:
				return creationTime != CREATION_TIME_EDEFAULT;
			case NetworkPackage.SOLUTION__SOLVING_TIME:
				return solvingTime != SOLVING_TIME_EDEFAULT;
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
		result.append(", totalVehicleBatteryConsumption: ");
		result.append(totalVehicleBatteryConsumption);
		result.append(", algorithmName: ");
		result.append(algorithmName);
		result.append(", creationTime: ");
		result.append(creationTime);
		result.append(", solvingTime: ");
		result.append(solvingTime);
		result.append(')');
		return result.toString();
	}

} //SolutionImpl
