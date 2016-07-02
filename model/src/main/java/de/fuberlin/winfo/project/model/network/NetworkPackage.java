/**
 */
package de.fuberlin.winfo.project.model.network;

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
 * @see de.fuberlin.winfo.project.model.network.NetworkFactory
 * @model kind="package"
 * @generated
 */
public interface NetworkPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "network";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "de.fuberlin.winfo.project.model.network";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "de.fuberlin.winfo.project.model.network";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	NetworkPackage eINSTANCE = de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl.init();

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.VertexImpl <em>Vertex</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.VertexImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getVertex()
	 * @generated
	 */
	int VERTEX = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__ID = 0;

	/**
	 * The feature id for the '<em><b>Arc In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__ARC_IN = 1;

	/**
	 * The feature id for the '<em><b>Arc Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX__ARC_OUT = 2;

	/**
	 * The number of structural features of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Vertex</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VERTEX_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl <em>Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.ArcImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getArc()
	 * @generated
	 */
	int ARC = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ID = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__START = 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__END = 2;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__DISTANCE = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__TIME = 4;

	/**
	 * The feature id for the '<em><b>Is Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__IS_USED = 5;

	/**
	 * The feature id for the '<em><b>Energy Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ENERGY_MIN = 6;

	/**
	 * The feature id for the '<em><b>Energy Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC__ENERGY_MAX = 7;

	/**
	 * The number of structural features of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_FEATURE_COUNT = 8;

	/**
	 * The number of operations of the '<em>Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.NetworkImpl <em>Network</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getNetwork()
	 * @generated
	 */
	int NETWORK = 2;

	/**
	 * The feature id for the '<em><b>Arcs</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__ARCS = 0;

	/**
	 * The feature id for the '<em><b>Vertices</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__VERTICES = 1;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SOLUTION = 2;

	/**
	 * The feature id for the '<em><b>Locatables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__LOCATABLES = 3;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.OrderImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 3;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ID = VERTEX__ID;

	/**
	 * The feature id for the '<em><b>Arc In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ARC_IN = VERTEX__ARC_IN;

	/**
	 * The feature id for the '<em><b>Arc Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ARC_OUT = VERTEX__ARC_OUT;

	/**
	 * The feature id for the '<em><b>Order Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ORDER_ID = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__RECEIVER = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__VOLUME = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__WEIGHT = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__TIME_WINDOW = VERTEX_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Standing Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__STANDING_TIME_IN_SEC = VERTEX_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_OPERATION_COUNT = VERTEX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl <em>Locatable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.LocatableImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getLocatable()
	 * @generated
	 */
	int LOCATABLE = 8;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE__LATITUDE = 0;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE__LONGITUDE = 1;

	/**
	 * The feature id for the '<em><b>Service Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE__SERVICE_TIME_IN_SEC = 2;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE__TIME_WINDOW = 3;

	/**
	 * The number of structural features of the '<em>Locatable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Locatable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.CustomerImpl <em>Customer</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.CustomerImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getCustomer()
	 * @generated
	 */
	int CUSTOMER = 4;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LATITUDE = LOCATABLE__LATITUDE;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__LONGITUDE = LOCATABLE__LONGITUDE;

	/**
	 * The feature id for the '<em><b>Service Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__SERVICE_TIME_IN_SEC = LOCATABLE__SERVICE_TIME_IN_SEC;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__TIME_WINDOW = LOCATABLE__TIME_WINDOW;

	/**
	 * The feature id for the '<em><b>Orders</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__ORDERS = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_OPERATION_COUNT = LOCATABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl <em>Depot</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.DepotImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getDepot()
	 * @generated
	 */
	int DEPOT = 5;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__ID = VERTEX__ID;

	/**
	 * The feature id for the '<em><b>Arc In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__ARC_IN = VERTEX__ARC_IN;

	/**
	 * The feature id for the '<em><b>Arc Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__ARC_OUT = VERTEX__ARC_OUT;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__LATITUDE = VERTEX_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__LONGITUDE = VERTEX_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Service Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__SERVICE_TIME_IN_SEC = VERTEX_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__TIME_WINDOW = VERTEX_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Fix Place Time If Multiple Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS = VERTEX_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Max Tour Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__MAX_TOUR_LENGTH = VERTEX_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Max Employment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__MAX_EMPLOYMENT = VERTEX_FEATURE_COUNT + 6;

	/**
	 * The number of structural features of the '<em>Depot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT_FEATURE_COUNT = VERTEX_FEATURE_COUNT + 7;

	/**
	 * The number of operations of the '<em>Depot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT_OPERATION_COUNT = VERTEX_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.DurationImpl <em>Duration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.DurationImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getDuration()
	 * @generated
	 */
	int DURATION = 6;

	/**
	 * The feature id for the '<em><b>Start In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION__START_IN_SEC = 0;

	/**
	 * The feature id for the '<em><b>End In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION__END_IN_SEC = 1;

	/**
	 * The number of structural features of the '<em>Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Duration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DURATION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl <em>Vehicle</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.VehicleImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getVehicle()
	 * @generated
	 */
	int VEHICLE = 7;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ID = 0;

	/**
	 * The feature id for the '<em><b>Max Pay Load In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAX_PAY_LOAD_IN_KG = 1;

	/**
	 * The feature id for the '<em><b>Cargo Weight In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CARGO_WEIGHT_IN_KG = 2;

	/**
	 * The feature id for the '<em><b>Max Battery Capacity In WH</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAX_BATTERY_CAPACITY_IN_WH = 3;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl <em>Route</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.RouteImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getRoute()
	 * @generated
	 */
	int ROUTE = 9;

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
	 * The feature id for the '<em><b>Total Vehicle Battery Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION = 3;

	/**
	 * The feature id for the '<em><b>Way</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE__WAY = 4;

	/**
	 * The number of structural features of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Route</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ROUTE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl <em>Solution</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.SolutionImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getSolution()
	 * @generated
	 */
	int SOLUTION = 10;

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
	 * The feature id for the '<em><b>Total Vehicle Battery Consumption</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION = 4;

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
	 * The feature id for the '<em><b>Algorithm Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__ALGORITHM_NAME = 7;

	/**
	 * The feature id for the '<em><b>Creation Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__CREATION_TIME = 8;

	/**
	 * The feature id for the '<em><b>Solving Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION__SOLVING_TIME = 9;

	/**
	 * The number of structural features of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_FEATURE_COUNT = 10;

	/**
	 * The number of operations of the '<em>Solution</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SOLUTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl <em>Used Arc</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.UsedArcImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getUsedArc()
	 * @generated
	 */
	int USED_ARC = 11;

	/**
	 * The feature id for the '<em><b>Arc</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC__ARC = 0;

	/**
	 * The feature id for the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT = 1;

	/**
	 * The feature id for the '<em><b>Duration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC__DURATION = 2;

	/**
	 * The feature id for the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END = 3;

	/**
	 * The number of structural features of the '<em>Used Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Used Arc</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USED_ARC_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.UseCaseImpl <em>Use Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.UseCaseImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getUseCase()
	 * @generated
	 */
	int USE_CASE = 12;

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
	 * The feature id for the '<em><b>Max Tour Length In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE__MAX_TOUR_LENGTH_IN_SEC = 3;

	/**
	 * The number of structural features of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Use Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USE_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl <em>Global Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getGlobalSearch()
	 * @generated
	 */
	int GLOBAL_SEARCH = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH__NAME = 0;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH__COST = 1;

	/**
	 * The feature id for the '<em><b>Prev Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH__PREV_COST = 2;

	/**
	 * The feature id for the '<em><b>Local Searches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH__LOCAL_SEARCHES = 3;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH__OPERATION = 4;

	/**
	 * The number of structural features of the '<em>Global Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Global Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int GLOBAL_SEARCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.LocalSearchImpl <em>Local Search</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.LocalSearchImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getLocalSearch()
	 * @generated
	 */
	int LOCAL_SEARCH = 14;

	/**
	 * The feature id for the '<em><b>Operation</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH__OPERATION = 0;

	/**
	 * The feature id for the '<em><b>Cost</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH__COST = 1;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH__TIME = 2;

	/**
	 * The number of structural features of the '<em>Local Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Local Search</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_SEARCH_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.SearchHistoryImpl <em>Search History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.SearchHistoryImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getSearchHistory()
	 * @generated
	 */
	int SEARCH_HISTORY = 15;

	/**
	 * The feature id for the '<em><b>Searches</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SEARCH_HISTORY__SEARCHES = 0;

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
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Vertex <em>Vertex</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vertex</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vertex
	 * @generated
	 */
	EClass getVertex();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vertex#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vertex#getId()
	 * @see #getVertex()
	 * @generated
	 */
	EAttribute getVertex_Id();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.Vertex#getArcIn <em>Arc In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arc In</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vertex#getArcIn()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_ArcIn();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.Vertex#getArcOut <em>Arc Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Arc Out</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vertex#getArcOut()
	 * @see #getVertex()
	 * @generated
	 */
	EReference getVertex_ArcOut();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Arc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Arc</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc
	 * @generated
	 */
	EClass getArc();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getId()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Id();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Arc#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getStart()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_Start();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Arc#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getEnd()
	 * @see #getArc()
	 * @generated
	 */
	EReference getArc_End();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getDistance()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Distance();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getTime()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_Time();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#isIsUsed <em>Is Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Used</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#isIsUsed()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_IsUsed();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#getEnergyMin <em>Energy Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Min</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getEnergyMin()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_EnergyMin();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Arc#getEnergyMax <em>Energy Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Energy Max</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Arc#getEnergyMax()
	 * @see #getArc()
	 * @generated
	 */
	EAttribute getArc_EnergyMax();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Network <em>Network</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Network</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network
	 * @generated
	 */
	EClass getNetwork();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getArcs <em>Arcs</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arcs</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getArcs()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Arcs();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vertices</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getVertices()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Vertices();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getSolution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Solution</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getSolution()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Solution();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getLocatables <em>Locatables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Locatables</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getLocatables()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Locatables();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getOrderId <em>Order Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Order Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getOrderId()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_OrderId();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Order#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getReceiver()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_Receiver();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getVolume <em>Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Volume</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getVolume()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Volume();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getWeight <em>Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Weight</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getWeight()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Weight();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Order#getTimeWindow <em>Time Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Window</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getTimeWindow()
	 * @see #getOrder()
	 * @generated
	 */
	EReference getOrder_TimeWindow();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getStandingTimeInSec <em>Standing Time In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Standing Time In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getStandingTimeInSec()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_StandingTimeInSec();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.Customer#getOrders <em>Orders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Orders</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Customer#getOrders()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_Orders();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Depot <em>Depot</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Depot</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot
	 * @generated
	 */
	EClass getDepot();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Depot#getFixPlaceTimeIfMultipleOperations <em>Fix Place Time If Multiple Operations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Fix Place Time If Multiple Operations</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getFixPlaceTimeIfMultipleOperations()
	 * @see #getDepot()
	 * @generated
	 */
	EAttribute getDepot_FixPlaceTimeIfMultipleOperations();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Depot#getMaxTourLength <em>Max Tour Length</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Tour Length</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getMaxTourLength()
	 * @see #getDepot()
	 * @generated
	 */
	EAttribute getDepot_MaxTourLength();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Depot#getMaxEmployment <em>Max Employment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Employment</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getMaxEmployment()
	 * @see #getDepot()
	 * @generated
	 */
	EAttribute getDepot_MaxEmployment();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Duration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Duration</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Duration
	 * @generated
	 */
	EClass getDuration();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Duration#getStartInSec <em>Start In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Duration#getStartInSec()
	 * @see #getDuration()
	 * @generated
	 */
	EAttribute getDuration_StartInSec();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Duration#getEndInSec <em>End In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>End In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Duration#getEndInSec()
	 * @see #getDuration()
	 * @generated
	 */
	EAttribute getDuration_EndInSec();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Vehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vehicle</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle
	 * @generated
	 */
	EClass getVehicle();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getId()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxPayLoadInKg <em>Max Pay Load In Kg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Pay Load In Kg</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getMaxPayLoadInKg()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_MaxPayLoadInKg();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getCargoWeightInKg <em>Cargo Weight In Kg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cargo Weight In Kg</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getCargoWeightInKg()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_CargoWeightInKg();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxBatteryCapacityInWH <em>Max Battery Capacity In WH</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Battery Capacity In WH</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getMaxBatteryCapacityInWH()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_MaxBatteryCapacityInWH();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Locatable <em>Locatable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Locatable</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Locatable
	 * @generated
	 */
	EClass getLocatable();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Locatable#getLatitude <em>Latitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Latitude</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Locatable#getLatitude()
	 * @see #getLocatable()
	 * @generated
	 */
	EAttribute getLocatable_Latitude();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Locatable#getLongitude <em>Longitude</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Longitude</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Locatable#getLongitude()
	 * @see #getLocatable()
	 * @generated
	 */
	EAttribute getLocatable_Longitude();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Locatable#getServiceTimeInSec <em>Service Time In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service Time In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Locatable#getServiceTimeInSec()
	 * @see #getLocatable()
	 * @generated
	 */
	EAttribute getLocatable_ServiceTimeInSec();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Locatable#getTimeWindow <em>Time Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Window</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Locatable#getTimeWindow()
	 * @see #getLocatable()
	 * @generated
	 */
	EReference getLocatable_TimeWindow();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Route <em>Route</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Route</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route
	 * @generated
	 */
	EClass getRoute();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Route#getVehicle <em>Vehicle</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Vehicle</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route#getVehicle()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Vehicle();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Route#getTotalDistanceInM <em>Total Distance In M</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Distance In M</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route#getTotalDistanceInM()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_TotalDistanceInM();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Route#getTotalTimeInSec <em>Total Time In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route#getTotalTimeInSec()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_TotalTimeInSec();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Route#getTotalVehicleBatteryConsumption <em>Total Vehicle Battery Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Vehicle Battery Consumption</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route#getTotalVehicleBatteryConsumption()
	 * @see #getRoute()
	 * @generated
	 */
	EAttribute getRoute_TotalVehicleBatteryConsumption();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Route#getWay <em>Way</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Way</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Route#getWay()
	 * @see #getRoute()
	 * @generated
	 */
	EReference getRoute_Way();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Solution <em>Solution</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Solution</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution
	 * @generated
	 */
	EClass getSolution();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Solution#getRoutes <em>Routes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Routes</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getRoutes()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Routes();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getId()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getTotalDistance <em>Total Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Distance</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getTotalDistance()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_TotalDistance();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getTotalTime <em>Total Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getTotalTime()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_TotalTime();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getTotalVehicleBatteryConsumption <em>Total Vehicle Battery Consumption</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Total Vehicle Battery Consumption</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getTotalVehicleBatteryConsumption()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_TotalVehicleBatteryConsumption();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Solution#getUsecase <em>Usecase</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Usecase</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getUsecase()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_Usecase();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Solution#getHistory <em>History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>History</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getHistory()
	 * @see #getSolution()
	 * @generated
	 */
	EReference getSolution_History();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getAlgorithmName <em>Algorithm Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Algorithm Name</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getAlgorithmName()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_AlgorithmName();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getCreationTime <em>Creation Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getCreationTime()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_CreationTime();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Solution#getSolvingTime <em>Solving Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Solving Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Solution#getSolvingTime()
	 * @see #getSolution()
	 * @generated
	 */
	EAttribute getSolution_SolvingTime();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.UsedArc <em>Used Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Used Arc</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UsedArc
	 * @generated
	 */
	EClass getUsedArc();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.UsedArc#getArc <em>Arc</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Arc</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UsedArc#getArc()
	 * @see #getUsedArc()
	 * @generated
	 */
	EReference getUsedArc_Arc();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.UsedArc#getCurrentVehicleCargoWeight <em>Current Vehicle Cargo Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Current Vehicle Cargo Weight</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UsedArc#getCurrentVehicleCargoWeight()
	 * @see #getUsedArc()
	 * @generated
	 */
	EAttribute getUsedArc_CurrentVehicleCargoWeight();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.UsedArc#getDuration <em>Duration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Duration</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UsedArc#getDuration()
	 * @see #getUsedArc()
	 * @generated
	 */
	EReference getUsedArc_Duration();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.UsedArc#getRemainingVehicleBatteryCapacityAtEnd <em>Remaining Vehicle Battery Capacity At End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remaining Vehicle Battery Capacity At End</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UsedArc#getRemainingVehicleBatteryCapacityAtEnd()
	 * @see #getUsedArc()
	 * @generated
	 */
	EAttribute getUsedArc_RemainingVehicleBatteryCapacityAtEnd();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.UseCase <em>Use Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Use Case</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UseCase
	 * @generated
	 */
	EClass getUseCase();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.UseCase#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UseCase#getId()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Id();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.UseCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UseCase#getName()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.UseCase#getVehicles <em>Vehicles</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vehicles</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UseCase#getVehicles()
	 * @see #getUseCase()
	 * @generated
	 */
	EReference getUseCase_Vehicles();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.UseCase#getMaxTourLengthInSec <em>Max Tour Length In Sec</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Tour Length In Sec</em>'.
	 * @see de.fuberlin.winfo.project.model.network.UseCase#getMaxTourLengthInSec()
	 * @see #getUseCase()
	 * @generated
	 */
	EAttribute getUseCase_MaxTourLengthInSec();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.GlobalSearch <em>Global Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Global Search</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch
	 * @generated
	 */
	EClass getGlobalSearch();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch#getName()
	 * @see #getGlobalSearch()
	 * @generated
	 */
	EAttribute getGlobalSearch_Name();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch#getCost()
	 * @see #getGlobalSearch()
	 * @generated
	 */
	EAttribute getGlobalSearch_Cost();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getPrevCost <em>Prev Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Prev Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch#getPrevCost()
	 * @see #getGlobalSearch()
	 * @generated
	 */
	EAttribute getGlobalSearch_PrevCost();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getLocalSearches <em>Local Searches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Local Searches</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch#getLocalSearches()
	 * @see #getGlobalSearch()
	 * @generated
	 */
	EReference getGlobalSearch_LocalSearches();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.GlobalSearch#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.fuberlin.winfo.project.model.network.GlobalSearch#getOperation()
	 * @see #getGlobalSearch()
	 * @generated
	 */
	EAttribute getGlobalSearch_Operation();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.LocalSearch <em>Local Search</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Local Search</em>'.
	 * @see de.fuberlin.winfo.project.model.network.LocalSearch
	 * @generated
	 */
	EClass getLocalSearch();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.LocalSearch#getOperation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation</em>'.
	 * @see de.fuberlin.winfo.project.model.network.LocalSearch#getOperation()
	 * @see #getLocalSearch()
	 * @generated
	 */
	EAttribute getLocalSearch_Operation();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.LocalSearch#getCost <em>Cost</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cost</em>'.
	 * @see de.fuberlin.winfo.project.model.network.LocalSearch#getCost()
	 * @see #getLocalSearch()
	 * @generated
	 */
	EAttribute getLocalSearch_Cost();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.LocalSearch#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.LocalSearch#getTime()
	 * @see #getLocalSearch()
	 * @generated
	 */
	EAttribute getLocalSearch_Time();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.SearchHistory <em>Search History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Search History</em>'.
	 * @see de.fuberlin.winfo.project.model.network.SearchHistory
	 * @generated
	 */
	EClass getSearchHistory();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.SearchHistory#getSearches <em>Searches</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Searches</em>'.
	 * @see de.fuberlin.winfo.project.model.network.SearchHistory#getSearches()
	 * @see #getSearchHistory()
	 * @generated
	 */
	EReference getSearchHistory_Searches();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	NetworkFactory getNetworkFactory();

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
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.VertexImpl <em>Vertex</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.VertexImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getVertex()
		 * @generated
		 */
		EClass VERTEX = eINSTANCE.getVertex();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VERTEX__ID = eINSTANCE.getVertex_Id();

		/**
		 * The meta object literal for the '<em><b>Arc In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__ARC_IN = eINSTANCE.getVertex_ArcIn();

		/**
		 * The meta object literal for the '<em><b>Arc Out</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VERTEX__ARC_OUT = eINSTANCE.getVertex_ArcOut();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.ArcImpl <em>Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.ArcImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getArc()
		 * @generated
		 */
		EClass ARC = eINSTANCE.getArc();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__ID = eINSTANCE.getArc_Id();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__START = eINSTANCE.getArc_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARC__END = eINSTANCE.getArc_End();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__DISTANCE = eINSTANCE.getArc_Distance();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__TIME = eINSTANCE.getArc_Time();

		/**
		 * The meta object literal for the '<em><b>Is Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__IS_USED = eINSTANCE.getArc_IsUsed();

		/**
		 * The meta object literal for the '<em><b>Energy Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__ENERGY_MIN = eINSTANCE.getArc_EnergyMin();

		/**
		 * The meta object literal for the '<em><b>Energy Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARC__ENERGY_MAX = eINSTANCE.getArc_EnergyMax();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.NetworkImpl <em>Network</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getNetwork()
		 * @generated
		 */
		EClass NETWORK = eINSTANCE.getNetwork();

		/**
		 * The meta object literal for the '<em><b>Arcs</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__ARCS = eINSTANCE.getNetwork_Arcs();

		/**
		 * The meta object literal for the '<em><b>Vertices</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__VERTICES = eINSTANCE.getNetwork_Vertices();

		/**
		 * The meta object literal for the '<em><b>Solution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__SOLUTION = eINSTANCE.getNetwork_Solution();

		/**
		 * The meta object literal for the '<em><b>Locatables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__LOCATABLES = eINSTANCE.getNetwork_Locatables();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.OrderImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>Order Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__ORDER_ID = eINSTANCE.getOrder_OrderId();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__RECEIVER = eINSTANCE.getOrder_Receiver();

		/**
		 * The meta object literal for the '<em><b>Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__VOLUME = eINSTANCE.getOrder_Volume();

		/**
		 * The meta object literal for the '<em><b>Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__WEIGHT = eINSTANCE.getOrder_Weight();

		/**
		 * The meta object literal for the '<em><b>Time Window</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ORDER__TIME_WINDOW = eINSTANCE.getOrder_TimeWindow();

		/**
		 * The meta object literal for the '<em><b>Standing Time In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__STANDING_TIME_IN_SEC = eINSTANCE.getOrder_StandingTimeInSec();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.CustomerImpl <em>Customer</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.CustomerImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getCustomer()
		 * @generated
		 */
		EClass CUSTOMER = eINSTANCE.getCustomer();

		/**
		 * The meta object literal for the '<em><b>Orders</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__ORDERS = eINSTANCE.getCustomer_Orders();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.DepotImpl <em>Depot</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.DepotImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getDepot()
		 * @generated
		 */
		EClass DEPOT = eINSTANCE.getDepot();

		/**
		 * The meta object literal for the '<em><b>Fix Place Time If Multiple Operations</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS = eINSTANCE.getDepot_FixPlaceTimeIfMultipleOperations();

		/**
		 * The meta object literal for the '<em><b>Max Tour Length</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPOT__MAX_TOUR_LENGTH = eINSTANCE.getDepot_MaxTourLength();

		/**
		 * The meta object literal for the '<em><b>Max Employment</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEPOT__MAX_EMPLOYMENT = eINSTANCE.getDepot_MaxEmployment();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.DurationImpl <em>Duration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.DurationImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getDuration()
		 * @generated
		 */
		EClass DURATION = eINSTANCE.getDuration();

		/**
		 * The meta object literal for the '<em><b>Start In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DURATION__START_IN_SEC = eINSTANCE.getDuration_StartInSec();

		/**
		 * The meta object literal for the '<em><b>End In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DURATION__END_IN_SEC = eINSTANCE.getDuration_EndInSec();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.VehicleImpl <em>Vehicle</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.VehicleImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getVehicle()
		 * @generated
		 */
		EClass VEHICLE = eINSTANCE.getVehicle();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__ID = eINSTANCE.getVehicle_Id();

		/**
		 * The meta object literal for the '<em><b>Max Pay Load In Kg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MAX_PAY_LOAD_IN_KG = eINSTANCE.getVehicle_MaxPayLoadInKg();

		/**
		 * The meta object literal for the '<em><b>Cargo Weight In Kg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__CARGO_WEIGHT_IN_KG = eINSTANCE.getVehicle_CargoWeightInKg();

		/**
		 * The meta object literal for the '<em><b>Max Battery Capacity In WH</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MAX_BATTERY_CAPACITY_IN_WH = eINSTANCE.getVehicle_MaxBatteryCapacityInWH();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl <em>Locatable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.LocatableImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getLocatable()
		 * @generated
		 */
		EClass LOCATABLE = eINSTANCE.getLocatable();

		/**
		 * The meta object literal for the '<em><b>Latitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATABLE__LATITUDE = eINSTANCE.getLocatable_Latitude();

		/**
		 * The meta object literal for the '<em><b>Longitude</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATABLE__LONGITUDE = eINSTANCE.getLocatable_Longitude();

		/**
		 * The meta object literal for the '<em><b>Service Time In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCATABLE__SERVICE_TIME_IN_SEC = eINSTANCE.getLocatable_ServiceTimeInSec();

		/**
		 * The meta object literal for the '<em><b>Time Window</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LOCATABLE__TIME_WINDOW = eINSTANCE.getLocatable_TimeWindow();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.RouteImpl <em>Route</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.RouteImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getRoute()
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
		 * The meta object literal for the '<em><b>Total Vehicle Battery Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ROUTE__TOTAL_VEHICLE_BATTERY_CONSUMPTION = eINSTANCE.getRoute_TotalVehicleBatteryConsumption();

		/**
		 * The meta object literal for the '<em><b>Way</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ROUTE__WAY = eINSTANCE.getRoute_Way();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.SolutionImpl <em>Solution</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.SolutionImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getSolution()
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
		 * The meta object literal for the '<em><b>Total Vehicle Battery Consumption</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__TOTAL_VEHICLE_BATTERY_CONSUMPTION = eINSTANCE.getSolution_TotalVehicleBatteryConsumption();

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
		 * The meta object literal for the '<em><b>Algorithm Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__ALGORITHM_NAME = eINSTANCE.getSolution_AlgorithmName();

		/**
		 * The meta object literal for the '<em><b>Creation Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__CREATION_TIME = eINSTANCE.getSolution_CreationTime();

		/**
		 * The meta object literal for the '<em><b>Solving Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SOLUTION__SOLVING_TIME = eINSTANCE.getSolution_SolvingTime();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.UsedArcImpl <em>Used Arc</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.UsedArcImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getUsedArc()
		 * @generated
		 */
		EClass USED_ARC = eINSTANCE.getUsedArc();

		/**
		 * The meta object literal for the '<em><b>Arc</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_ARC__ARC = eINSTANCE.getUsedArc_Arc();

		/**
		 * The meta object literal for the '<em><b>Current Vehicle Cargo Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USED_ARC__CURRENT_VEHICLE_CARGO_WEIGHT = eINSTANCE.getUsedArc_CurrentVehicleCargoWeight();

		/**
		 * The meta object literal for the '<em><b>Duration</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference USED_ARC__DURATION = eINSTANCE.getUsedArc_Duration();

		/**
		 * The meta object literal for the '<em><b>Remaining Vehicle Battery Capacity At End</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USED_ARC__REMAINING_VEHICLE_BATTERY_CAPACITY_AT_END = eINSTANCE.getUsedArc_RemainingVehicleBatteryCapacityAtEnd();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.UseCaseImpl <em>Use Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.UseCaseImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getUseCase()
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
		 * The meta object literal for the '<em><b>Max Tour Length In Sec</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute USE_CASE__MAX_TOUR_LENGTH_IN_SEC = eINSTANCE.getUseCase_MaxTourLengthInSec();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl <em>Global Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.GlobalSearchImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getGlobalSearch()
		 * @generated
		 */
		EClass GLOBAL_SEARCH = eINSTANCE.getGlobalSearch();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_SEARCH__NAME = eINSTANCE.getGlobalSearch_Name();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_SEARCH__COST = eINSTANCE.getGlobalSearch_Cost();

		/**
		 * The meta object literal for the '<em><b>Prev Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_SEARCH__PREV_COST = eINSTANCE.getGlobalSearch_PrevCost();

		/**
		 * The meta object literal for the '<em><b>Local Searches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference GLOBAL_SEARCH__LOCAL_SEARCHES = eINSTANCE.getGlobalSearch_LocalSearches();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute GLOBAL_SEARCH__OPERATION = eINSTANCE.getGlobalSearch_Operation();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.LocalSearchImpl <em>Local Search</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.LocalSearchImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getLocalSearch()
		 * @generated
		 */
		EClass LOCAL_SEARCH = eINSTANCE.getLocalSearch();

		/**
		 * The meta object literal for the '<em><b>Operation</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH__OPERATION = eINSTANCE.getLocalSearch_Operation();

		/**
		 * The meta object literal for the '<em><b>Cost</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH__COST = eINSTANCE.getLocalSearch_Cost();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LOCAL_SEARCH__TIME = eINSTANCE.getLocalSearch_Time();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.SearchHistoryImpl <em>Search History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.SearchHistoryImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getSearchHistory()
		 * @generated
		 */
		EClass SEARCH_HISTORY = eINSTANCE.getSearchHistory();

		/**
		 * The meta object literal for the '<em><b>Searches</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SEARCH_HISTORY__SEARCHES = eINSTANCE.getSearchHistory_Searches();

	}

} //NetworkPackage
