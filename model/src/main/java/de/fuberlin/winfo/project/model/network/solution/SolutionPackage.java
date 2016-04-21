/**
 */
package de.fuberlin.winfo.project.model.network.solution;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see de.fuberlin.winfo.project.model.network.solution.SolutionFactory
 * @model kind="package"
 * @generated
 */
public interface SolutionPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "solution";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "de.fuberlin.winfo.project.model.network.solution";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.fuberlin.winfo.project.model.network.solution";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	SolutionPackage eINSTANCE = de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.RouteImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 0;

	/**
	 * The feature id for the '<em><b>Vehicle</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__VEHICLE = 0;

	/**
	 * The feature id for the '<em><b>Total Distance In M</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__TOTAL_DISTANCE_IN_M = 1;

	/**
	 * The feature id for the '<em><b>Total Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__TOTAL_TIME_IN_SEC = 2;

	/**
	 * The feature id for the '<em><b>Way</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__WAY = 3;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 1;

	/**
	 * The feature id for the '<em><b>Routes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ROUTES = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ID = 1;

	/**
	 * The feature id for the '<em><b>Total Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__TOTAL_DISTANCE = 2;

	/**
	 * The feature id for the '<em><b>Total Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__TOTAL_TIME = 3;

	/**
	 * The feature id for the '<em><b>Procedure</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__PROCEDURE = 4;

	/**
	 * The feature id for the '<em><b>Usecase</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__USECASE = 5;

	/**
	 * The feature id for the '<em><b>History</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__HISTORY = 6;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl <em>Used Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getUsedEdge()
	 * @generated
	 */
	int USED_EDGE = 2;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE__EDGE = 0;

	/**
	 * The feature id for the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE__DURATION = 2;

	/**
	 * The feature id for the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END = 3;

	/**
	 * The number of structural features of the '<em>Used Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Used Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_EDGE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__ID = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__NAME = 1;

	/**
	 * The feature id for the '<em><b>Vehicles</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__VEHICLES = 2;

	/**
	 * The feature id for the '<em><b>Transhipment Points</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__TRANSHIPMENT_POINTS = 3;

	/**
	 * The feature id for the '<em><b>Max Tour Length In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__MAX_TOUR_LENGTH_IN_SEC = 4;

	/**
	 * The feature id for the '<em><b>Storage Costs Per Kg Per Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC = 5;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.DeliveryImpl <em>Delivery</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.DeliveryImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getDelivery()
	 * @generated
	 */
	int DELIVERY = 4;

	/**
	 * The feature id for the '<em><b>Edge</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__EDGE = USED_EDGE__EDGE;

	/**
	 * The feature id for the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__CURRENT_VEHICLE_CARGO_WEIGHT = USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__DURATION = USED_EDGE__DURATION;

	/**
	 * The feature id for the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END = USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END;

	/**
	 * The feature id for the '<em><b>Order</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY__ORDER = USED_EDGE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Delivery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_FEATURE_COUNT = USED_EDGE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Delivery</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DELIVERY_OPERATION_COUNT = USED_EDGE_OPERATION_COUNT + 0;


	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl <em>VNS Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getVNSSearch()
	 * @generated
	 */
	int VNS_SEARCH = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__COST = 1;

	/**
	 * The feature id for the '<em><b>Prev Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__PREV_COST = 2;

	/**
	 * The feature id for the '<em><b>Neighborhood Searches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__NEIGHBORHOOD_SEARCHES = 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__OPERATION = 4;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH__TIME = 5;

	/**
	 * The number of structural features of the '<em>VNS Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>VNS Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VNS_SEARCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.NeighborhoodSearchImpl <em>Neighborhood Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.NeighborhoodSearchImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getNeighborhoodSearch()
	 * @generated
	 */
	int NEIGHBORHOOD_SEARCH = 6;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_SEARCH__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_SEARCH__COST = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_SEARCH__TIME = 2;

	/**
	 * The number of structural features of the '<em>Neighborhood Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_SEARCH_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Neighborhood Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEIGHBORHOOD_SEARCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.SearchHistoryImpl <em>Search History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SearchHistoryImpl
	 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getSearchHistory()
	 * @generated
	 */
	int SEARCH_HISTORY = 7;

	/**
	 * The feature id for the '<em><b>Vns Searches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_HISTORY__VNS_SEARCHES = 0;

	/**
	 * The number of structural features of the '<em>Search History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_HISTORY_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Search History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_HISTORY_OPERATION_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.solution.Route#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Route#getVehicle()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Route#getTotalDistanceInM <em>Total Distance In M</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Distance In M</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Route#getTotalDistanceInM()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_TotalDistanceInM();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Route#getTotalTimeInSec <em>Total Time In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Route#getTotalTimeInSec()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_TotalTimeInSec();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.Route#getWay <em>Way</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Way</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Route#getWay()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Way();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getRoutes()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Routes();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getId()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalDistance <em>Total Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Distance</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getTotalDistance()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_TotalDistance();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getTotalTime()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_TotalTime();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getProcedure <em>Procedure</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Procedure</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getProcedure()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_Procedure();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Usecase</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getUsecase()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Usecase();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.solution.Solution#getHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>History</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Solution#getHistory()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_History();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge <em>Used Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Used Edge</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UsedEdge
	 * @generated
	 */
	EClass getUsedEdge();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getEdge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Edge</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UsedEdge#getEdge()
	 * @see #getUsedEdge()
	 * @generated
	 */
	EReference getUsedEdge_Edge();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Vehicle Cargo Weight</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UsedEdge#getCurrentVehicleCargoWeight()
	 * @see #getUsedEdge()
	 * @generated
	 */
	EAttribute getUsedEdge_CurrentVehicleCargoWeight();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UsedEdge#getDuration()
	 * @see #getUsedEdge()
	 * @generated
	 */
	EReference getUsedEdge_Duration();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UsedEdge#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remaining Vehicle Battery Capacity At End</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UsedEdge#getRemainingVehicleBatteryCapacityAtEnd()
	 * @see #getUsedEdge()
	 * @generated
	 */
	EAttribute getUsedEdge_RemainingVehicleBatteryCapacityAtEnd();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getId()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicles</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getVehicles()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Vehicles();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getTranshipmentPoints <em>Transhipment Points</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Transhipment Points</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getTranshipmentPoints()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_TranshipmentPoints();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getMaxTourLengthInSec <em>Max Tour Length In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Tour Length In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getMaxTourLengthInSec()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_MaxTourLengthInSec();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.UseCase#getStorageCostsPerKgPerSec <em>Storage Costs Per Kg Per Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Storage Costs Per Kg Per Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.UseCase#getStorageCostsPerKgPerSec()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_StorageCostsPerKgPerSec();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.Delivery <em>Delivery</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Delivery</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Delivery
	 * @generated
	 */
	EClass getDelivery();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.solution.Delivery#getOrder <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Order</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.Delivery#getOrder()
	 * @see #getDelivery()
	 * @generated
	 */
	EReference getDelivery_Order();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch <em>VNS Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>VNS Search</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch
	 * @generated
	 */
	EClass getVNSSearch();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getName()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EAttribute getVNSSearch_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getCost()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EAttribute getVNSSearch_Cost();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getPrevCost <em>Prev Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prev Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getPrevCost()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EAttribute getVNSSearch_PrevCost();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getNeighborhoodSearches <em>Neighborhood Searches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Neighborhood Searches</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getNeighborhoodSearches()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EReference getVNSSearch_NeighborhoodSearches();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getOperation()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EAttribute getVNSSearch_Operation();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.VNSSearch#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.VNSSearch#getTime()
	 * @see #getVNSSearch()
	 * @generated
	 */
	EAttribute getVNSSearch_Time();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch <em>Neighborhood Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Neighborhood Search</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch
	 * @generated
	 */
	EClass getNeighborhoodSearch();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getOperation()
	 * @see #getNeighborhoodSearch()
	 * @generated
	 */
	EAttribute getNeighborhoodSearch_Operation();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getCost()
	 * @see #getNeighborhoodSearch()
	 * @generated
	 */
	EAttribute getNeighborhoodSearch_Cost();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.NeighborhoodSearch#getTime()
	 * @see #getNeighborhoodSearch()
	 * @generated
	 */
	EAttribute getNeighborhoodSearch_Time();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.solution.SearchHistory <em>Search History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search History</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.SearchHistory
	 * @generated
	 */
	EClass getSearchHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.solution.SearchHistory#getVnsSearches <em>Vns Searches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vns Searches</em>'.
	 * @see de.fuberlin.winfo.project.model.network.solution.SearchHistory#getVnsSearches()
	 * @see #getSearchHistory()
	 * @generated
	 */
	EReference getSearchHistory_VnsSearches();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	SolutionFactory getSolutionFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.RouteImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getRoute()
		 * @generated
		 */
		EClass ROUTE = eINSTANCE.getRoute();

		/**
		 * The meta object literal for the '<em><b>Vehicle</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__VEHICLE = eINSTANCE.getRoute_Vehicle();

		/**
		 * The meta object literal for the '<em><b>Total Distance In M</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__TOTAL_DISTANCE_IN_M = eINSTANCE.getRoute_TotalDistanceInM();

		/**
		 * The meta object literal for the '<em><b>Total Time In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__TOTAL_TIME_IN_SEC = eINSTANCE.getRoute_TotalTimeInSec();

		/**
		 * The meta object literal for the '<em><b>Way</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__WAY = eINSTANCE.getRoute_Way();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getSolution()
		 * @generated
		 */
		EClass SOLUTION = eINSTANCE.getSolution();

		/**
		 * The meta object literal for the '<em><b>Routes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__ROUTES = eINSTANCE.getSolution_Routes();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__ID = eINSTANCE.getSolution_Id();

		/**
		 * The meta object literal for the '<em><b>Total Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__TOTAL_DISTANCE = eINSTANCE.getSolution_TotalDistance();

		/**
		 * The meta object literal for the '<em><b>Total Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__TOTAL_TIME = eINSTANCE.getSolution_TotalTime();

		/**
		 * The meta object literal for the '<em><b>Procedure</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__PROCEDURE = eINSTANCE.getSolution_Procedure();

		/**
		 * The meta object literal for the '<em><b>Usecase</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__USECASE = eINSTANCE.getSolution_Usecase();

		/**
		 * The meta object literal for the '<em><b>History</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SOLUTION__HISTORY = eINSTANCE.getSolution_History();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl <em>Used Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.UsedEdgeImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getUsedEdge()
		 * @generated
		 */
		EClass USED_EDGE = eINSTANCE.getUsedEdge();

		/**
		 * The meta object literal for the '<em><b>Edge</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_EDGE__EDGE = eINSTANCE.getUsedEdge_Edge();

		/**
		 * The meta object literal for the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USED_EDGE__CURRENT_VEHICLE_CARGO_WEIGHT = eINSTANCE.getUsedEdge_CurrentVehicleCargoWeight();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_EDGE__DURATION = eINSTANCE.getUsedEdge_Duration();

		/**
		 * The meta object literal for the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USED_EDGE__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END = eINSTANCE.getUsedEdge_RemainingVehicleBatteryCapacityAtEnd();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.UseCaseImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getUseCase()
		 * @generated
		 */
		EClass USE_CASE = eINSTANCE.getUseCase();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__ID = eINSTANCE.getUseCase_Id();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__NAME = eINSTANCE.getUseCase_Name();

		/**
		 * The meta object literal for the '<em><b>Vehicles</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__VEHICLES = eINSTANCE.getUseCase_Vehicles();

		/**
		 * The meta object literal for the '<em><b>Transhipment Points</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USE_CASE__TRANSHIPMENT_POINTS = eINSTANCE.getUseCase_TranshipmentPoints();

		/**
		 * The meta object literal for the '<em><b>Max Tour Length In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__MAX_TOUR_LENGTH_IN_SEC = eINSTANCE.getUseCase_MaxTourLengthInSec();

		/**
		 * The meta object literal for the '<em><b>Storage Costs Per Kg Per Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__STORAGE_COSTS_PER_KG_PER_SEC = eINSTANCE.getUseCase_StorageCostsPerKgPerSec();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.DeliveryImpl <em>Delivery</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.DeliveryImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getDelivery()
		 * @generated
		 */
		EClass DELIVERY = eINSTANCE.getDelivery();

		/**
		 * The meta object literal for the '<em><b>Order</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DELIVERY__ORDER = eINSTANCE.getDelivery_Order();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl <em>VNS Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.VNSSearchImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getVNSSearch()
		 * @generated
		 */
		EClass VNS_SEARCH = eINSTANCE.getVNSSearch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNS_SEARCH__NAME = eINSTANCE.getVNSSearch_Name();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNS_SEARCH__COST = eINSTANCE.getVNSSearch_Cost();

		/**
		 * The meta object literal for the '<em><b>Prev Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNS_SEARCH__PREV_COST = eINSTANCE.getVNSSearch_PrevCost();

		/**
		 * The meta object literal for the '<em><b>Neighborhood Searches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VNS_SEARCH__NEIGHBORHOOD_SEARCHES = eINSTANCE.getVNSSearch_NeighborhoodSearches();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNS_SEARCH__OPERATION = eINSTANCE.getVNSSearch_Operation();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VNS_SEARCH__TIME = eINSTANCE.getVNSSearch_Time();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.NeighborhoodSearchImpl <em>Neighborhood Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.NeighborhoodSearchImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getNeighborhoodSearch()
		 * @generated
		 */
		EClass NEIGHBORHOOD_SEARCH = eINSTANCE.getNeighborhoodSearch();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEIGHBORHOOD_SEARCH__OPERATION = eINSTANCE.getNeighborhoodSearch_Operation();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEIGHBORHOOD_SEARCH__COST = eINSTANCE.getNeighborhoodSearch_Cost();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NEIGHBORHOOD_SEARCH__TIME = eINSTANCE.getNeighborhoodSearch_Time();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.solution.impl.SearchHistoryImpl <em>Search History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SearchHistoryImpl
		 * @see de.fuberlin.winfo.project.model.network.solution.impl.SolutionPackageImpl#getSearchHistory()
		 * @generated
		 */
		EClass SEARCH_HISTORY = eINSTANCE.getSearchHistory();

		/**
		 * The meta object literal for the '<em><b>Vns Searches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_HISTORY__VNS_SEARCHES = eINSTANCE.getSearchHistory_VnsSearches();

	}

} //SolutionPackage
