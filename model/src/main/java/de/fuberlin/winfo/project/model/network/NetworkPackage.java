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
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl <em>Node</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.NodeImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getNode()
	 * @generated
	 */
	int NODE = 0;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__ID = 0;

	/**
	 * The feature id for the '<em><b>Edge In</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGE_IN = 1;

	/**
	 * The feature id for the '<em><b>Edge Out</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__EDGE_OUT = 2;

	/**
	 * The feature id for the '<em><b>Representative</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE__REPRESENTATIVE = 3;

	/**
	 * The number of structural features of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Node</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NODE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.EdgeImpl <em>Edge</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.EdgeImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getEdge()
	 * @generated
	 */
	int EDGE = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__ID = 0;

	/**
	 * The feature id for the '<em><b>Start</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__START = 1;

	/**
	 * The feature id for the '<em><b>End</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__END = 2;

	/**
	 * The feature id for the '<em><b>Distance</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__DISTANCE = 3;

	/**
	 * The feature id for the '<em><b>Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__TIME = 4;

	/**
	 * The feature id for the '<em><b>Is Used</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE__IS_USED = 5;

	/**
	 * The number of structural features of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Edge</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EDGE_OPERATION_COUNT = 0;

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
	 * The feature id for the '<em><b>Edges</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__EDGES = 0;

	/**
	 * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__NODES = 1;

	/**
	 * The feature id for the '<em><b>Solution</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK__SOLUTION = 2;

	/**
	 * The number of structural features of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Network</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NETWORK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.LocatableImpl <em>Locatable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.LocatableImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getLocatable()
	 * @generated
	 */
	int LOCATABLE = 7;

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
	 * The number of structural features of the '<em>Locatable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCATABLE_FEATURE_COUNT = 3;

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
	int CUSTOMER = 3;

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
	 * The feature id for the '<em><b>Owned Orders</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__OWNED_ORDERS = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has Transhipment Point</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER__HAS_TRANSHIPMENT_POINT = LOCATABLE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Customer</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CUSTOMER_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 2;

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
	int DEPOT = 4;

	/**
	 * The feature id for the '<em><b>Latitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__LATITUDE = LOCATABLE__LATITUDE;

	/**
	 * The feature id for the '<em><b>Longitude</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__LONGITUDE = LOCATABLE__LONGITUDE;

	/**
	 * The feature id for the '<em><b>Service Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__SERVICE_TIME_IN_SEC = LOCATABLE__SERVICE_TIME_IN_SEC;

	/**
	 * The feature id for the '<em><b>Fix Place Time If Multiple Operations</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__FIX_PLACE_TIME_IF_MULTIPLE_OPERATIONS = LOCATABLE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Planned Period</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__PLANNED_PERIOD = LOCATABLE_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Max Tour Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__MAX_TOUR_LENGTH = LOCATABLE_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Max Employment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__MAX_EMPLOYMENT = LOCATABLE_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__TIME_WINDOW = LOCATABLE_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Deliveries</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT__DELIVERIES = LOCATABLE_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Depot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT_FEATURE_COUNT = LOCATABLE_FEATURE_COUNT + 6;

	/**
	 * The number of operations of the '<em>Depot</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEPOT_OPERATION_COUNT = LOCATABLE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.DurationImpl <em>Duration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.DurationImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getDuration()
	 * @generated
	 */
	int DURATION = 5;

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
	int VEHICLE = 6;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__ID = 0;

	/**
	 * The feature id for the '<em><b>Max Capacaty Pay Load In Kg</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG = 1;

	/**
	 * The feature id for the '<em><b>Max Reach In Meter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__MAX_REACH_IN_METER = 2;

	/**
	 * The feature id for the '<em><b>Change Battery Time</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__CHANGE_BATTERY_TIME = 3;

	/**
	 * The feature id for the '<em><b>Battery Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__BATTERY_TYPE = 4;

	/**
	 * The feature id for the '<em><b>Battery Capacity In Wh</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__BATTERY_CAPACITY_IN_WH = 5;

	/**
	 * The feature id for the '<em><b>Operating Costs Per Meter</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__OPERATING_COSTS_PER_METER = 6;

	/**
	 * The feature id for the '<em><b>Driver Costs Per Hour</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__DRIVER_COSTS_PER_HOUR = 7;

	/**
	 * The feature id for the '<em><b>Transshipment Fix Costs Euro</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO = 8;

	/**
	 * The feature id for the '<em><b>Transhipment Time In Minutes</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES = 9;

	/**
	 * The feature id for the '<em><b>Pay Load Depending Consumption Rate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE = 10;

	/**
	 * The number of structural features of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_FEATURE_COUNT = 11;

	/**
	 * The number of operations of the '<em>Vehicle</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VEHICLE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl <em>Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.OrderImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getOrder()
	 * @generated
	 */
	int ORDER = 8;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__ID = 0;

	/**
	 * The feature id for the '<em><b>Need As Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__NEED_AS_VOLUME = 1;

	/**
	 * The feature id for the '<em><b>Need As Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__NEED_AS_WEIGHT = 2;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__TIME_WINDOW = 3;

	/**
	 * The feature id for the '<em><b>Standing Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER__STANDING_TIME_IN_SEC = 4;

	/**
	 * The number of structural features of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ORDER_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link de.fuberlin.winfo.project.model.network.impl.CollectiveOrderImpl <em>Collective Order</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see de.fuberlin.winfo.project.model.network.impl.CollectiveOrderImpl
	 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getCollectiveOrder()
	 * @generated
	 */
	int COLLECTIVE_ORDER = 9;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__ID = ORDER__ID;

	/**
	 * The feature id for the '<em><b>Need As Volume</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__NEED_AS_VOLUME = ORDER__NEED_AS_VOLUME;

	/**
	 * The feature id for the '<em><b>Need As Weight</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__NEED_AS_WEIGHT = ORDER__NEED_AS_WEIGHT;

	/**
	 * The feature id for the '<em><b>Time Window</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__TIME_WINDOW = ORDER__TIME_WINDOW;

	/**
	 * The feature id for the '<em><b>Standing Time In Sec</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__STANDING_TIME_IN_SEC = ORDER__STANDING_TIME_IN_SEC;

	/**
	 * The feature id for the '<em><b>Consist Of</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__CONSIST_OF = ORDER_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Receiver</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER__RECEIVER = ORDER_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Collective Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER_FEATURE_COUNT = ORDER_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Collective Order</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COLLECTIVE_ORDER_OPERATION_COUNT = ORDER_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Node <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Node</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Node
	 * @generated
	 */
	EClass getNode();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Node#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Node#getId()
	 * @see #getNode()
	 * @generated
	 */
	EAttribute getNode_Id();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.Node#getEdgeIn <em>Edge In</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge In</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Node#getEdgeIn()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EdgeIn();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.Node#getEdgeOut <em>Edge Out</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Edge Out</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Node#getEdgeOut()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_EdgeOut();

	/**
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Node#getRepresentative <em>Representative</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Representative</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Node#getRepresentative()
	 * @see #getNode()
	 * @generated
	 */
	EReference getNode_Representative();

	/**
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Edge <em>Edge</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Edge</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge
	 * @generated
	 */
	EClass getEdge();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Edge#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#getId()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Id();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Edge#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Start</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#getStart()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_Start();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Edge#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>End</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#getEnd()
	 * @see #getEdge()
	 * @generated
	 */
	EReference getEdge_End();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Edge#getDistance <em>Distance</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Distance</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#getDistance()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Distance();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Edge#getTime <em>Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#getTime()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_Time();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Edge#isIsUsed <em>Is Used</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Used</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Edge#isIsUsed()
	 * @see #getEdge()
	 * @generated
	 */
	EAttribute getEdge_IsUsed();

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
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getEdges <em>Edges</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Edges</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getEdges()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Edges();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Network#getNodes <em>Nodes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Nodes</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Network#getNodes()
	 * @see #getNetwork()
	 * @generated
	 */
	EReference getNetwork_Nodes();

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
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Customer <em>Customer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Customer</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Customer
	 * @generated
	 */
	EClass getCustomer();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Customer#getOwnedOrders <em>Owned Orders</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Owned Orders</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Customer#getOwnedOrders()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_OwnedOrders();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.Customer#getHasTranshipmentPoint <em>Has Transhipment Point</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Has Transhipment Point</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Customer#getHasTranshipmentPoint()
	 * @see #getCustomer()
	 * @generated
	 */
	EReference getCustomer_HasTranshipmentPoint();

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
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Depot#getPlannedPeriod <em>Planned Period</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Planned Period</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getPlannedPeriod()
	 * @see #getDepot()
	 * @generated
	 */
	EReference getDepot_PlannedPeriod();

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
	 * Returns the meta object for the containment reference '{@link de.fuberlin.winfo.project.model.network.Depot#getTimeWindow <em>Time Window</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Time Window</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getTimeWindow()
	 * @see #getDepot()
	 * @generated
	 */
	EReference getDepot_TimeWindow();

	/**
	 * Returns the meta object for the containment reference list '{@link de.fuberlin.winfo.project.model.network.Depot#getDeliveries <em>Deliveries</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Deliveries</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Depot#getDeliveries()
	 * @see #getDepot()
	 * @generated
	 */
	EReference getDepot_Deliveries();

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
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxCapacatyPayLoadInKg <em>Max Capacaty Pay Load In Kg</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Capacaty Pay Load In Kg</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getMaxCapacatyPayLoadInKg()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_MaxCapacatyPayLoadInKg();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getMaxReachInMeter <em>Max Reach In Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max Reach In Meter</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getMaxReachInMeter()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_MaxReachInMeter();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getChangeBatteryTime <em>Change Battery Time</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Change Battery Time</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getChangeBatteryTime()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_ChangeBatteryTime();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryType <em>Battery Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Battery Type</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getBatteryType()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_BatteryType();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getBatteryCapacityInWh <em>Battery Capacity In Wh</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Battery Capacity In Wh</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getBatteryCapacityInWh()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_BatteryCapacityInWh();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getOperatingCostsPerMeter <em>Operating Costs Per Meter</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operating Costs Per Meter</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getOperatingCostsPerMeter()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_OperatingCostsPerMeter();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getDriverCostsPerHour <em>Driver Costs Per Hour</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Driver Costs Per Hour</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getDriverCostsPerHour()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_DriverCostsPerHour();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getTransshipmentFixCostsEuro <em>Transshipment Fix Costs Euro</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transshipment Fix Costs Euro</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getTransshipmentFixCostsEuro()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_TransshipmentFixCostsEuro();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getTranshipmentTimeInMinutes <em>Transhipment Time In Minutes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Transhipment Time In Minutes</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getTranshipmentTimeInMinutes()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_TranshipmentTimeInMinutes();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Vehicle#getPayLoadDependingConsumptionRate <em>Pay Load Depending Consumption Rate</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Pay Load Depending Consumption Rate</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Vehicle#getPayLoadDependingConsumptionRate()
	 * @see #getVehicle()
	 * @generated
	 */
	EAttribute getVehicle_PayLoadDependingConsumptionRate();

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
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.Order <em>Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Order</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order
	 * @generated
	 */
	EClass getOrder();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsVolume <em>Need As Volume</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Need As Volume</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getNeedAsVolume()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_NeedAsVolume();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getNeedAsWeight <em>Need As Weight</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Need As Weight</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getNeedAsWeight()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_NeedAsWeight();

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
	 * Returns the meta object for class '{@link de.fuberlin.winfo.project.model.network.CollectiveOrder <em>Collective Order</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Collective Order</em>'.
	 * @see de.fuberlin.winfo.project.model.network.CollectiveOrder
	 * @generated
	 */
	EClass getCollectiveOrder();

	/**
	 * Returns the meta object for the reference list '{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getConsistOf <em>Consist Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Consist Of</em>'.
	 * @see de.fuberlin.winfo.project.model.network.CollectiveOrder#getConsistOf()
	 * @see #getCollectiveOrder()
	 * @generated
	 */
	EReference getCollectiveOrder_ConsistOf();

	/**
	 * Returns the meta object for the reference '{@link de.fuberlin.winfo.project.model.network.CollectiveOrder#getReceiver <em>Receiver</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Receiver</em>'.
	 * @see de.fuberlin.winfo.project.model.network.CollectiveOrder#getReceiver()
	 * @see #getCollectiveOrder()
	 * @generated
	 */
	EReference getCollectiveOrder_Receiver();

	/**
	 * Returns the meta object for the attribute '{@link de.fuberlin.winfo.project.model.network.Order#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see de.fuberlin.winfo.project.model.network.Order#getId()
	 * @see #getOrder()
	 * @generated
	 */
	EAttribute getOrder_Id();

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
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl <em>Node</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.NodeImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getNode()
		 * @generated
		 */
		EClass NODE = eINSTANCE.getNode();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute NODE__ID = eINSTANCE.getNode_Id();

		/**
		 * The meta object literal for the '<em><b>Edge In</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGE_IN = eINSTANCE.getNode_EdgeIn();

		/**
		 * The meta object literal for the '<em><b>Edge Out</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__EDGE_OUT = eINSTANCE.getNode_EdgeOut();

		/**
		 * The meta object literal for the '<em><b>Representative</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NODE__REPRESENTATIVE = eINSTANCE.getNode_Representative();

		/**
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.EdgeImpl <em>Edge</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.EdgeImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getEdge()
		 * @generated
		 */
		EClass EDGE = eINSTANCE.getEdge();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__ID = eINSTANCE.getEdge_Id();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__START = eINSTANCE.getEdge_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EDGE__END = eINSTANCE.getEdge_End();

		/**
		 * The meta object literal for the '<em><b>Distance</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__DISTANCE = eINSTANCE.getEdge_Distance();

		/**
		 * The meta object literal for the '<em><b>Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__TIME = eINSTANCE.getEdge_Time();

		/**
		 * The meta object literal for the '<em><b>Is Used</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EDGE__IS_USED = eINSTANCE.getEdge_IsUsed();

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
		 * The meta object literal for the '<em><b>Edges</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__EDGES = eINSTANCE.getNetwork_Edges();

		/**
		 * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__NODES = eINSTANCE.getNetwork_Nodes();

		/**
		 * The meta object literal for the '<em><b>Solution</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NETWORK__SOLUTION = eINSTANCE.getNetwork_Solution();

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
		 * The meta object literal for the '<em><b>Owned Orders</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__OWNED_ORDERS = eINSTANCE.getCustomer_OwnedOrders();

		/**
		 * The meta object literal for the '<em><b>Has Transhipment Point</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CUSTOMER__HAS_TRANSHIPMENT_POINT = eINSTANCE.getCustomer_HasTranshipmentPoint();

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
		 * The meta object literal for the '<em><b>Planned Period</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPOT__PLANNED_PERIOD = eINSTANCE.getDepot_PlannedPeriod();

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
		 * The meta object literal for the '<em><b>Time Window</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPOT__TIME_WINDOW = eINSTANCE.getDepot_TimeWindow();

		/**
		 * The meta object literal for the '<em><b>Deliveries</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DEPOT__DELIVERIES = eINSTANCE.getDepot_Deliveries();

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
		 * The meta object literal for the '<em><b>Max Capacaty Pay Load In Kg</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MAX_CAPACATY_PAY_LOAD_IN_KG = eINSTANCE.getVehicle_MaxCapacatyPayLoadInKg();

		/**
		 * The meta object literal for the '<em><b>Max Reach In Meter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__MAX_REACH_IN_METER = eINSTANCE.getVehicle_MaxReachInMeter();

		/**
		 * The meta object literal for the '<em><b>Change Battery Time</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__CHANGE_BATTERY_TIME = eINSTANCE.getVehicle_ChangeBatteryTime();

		/**
		 * The meta object literal for the '<em><b>Battery Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__BATTERY_TYPE = eINSTANCE.getVehicle_BatteryType();

		/**
		 * The meta object literal for the '<em><b>Battery Capacity In Wh</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__BATTERY_CAPACITY_IN_WH = eINSTANCE.getVehicle_BatteryCapacityInWh();

		/**
		 * The meta object literal for the '<em><b>Operating Costs Per Meter</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__OPERATING_COSTS_PER_METER = eINSTANCE.getVehicle_OperatingCostsPerMeter();

		/**
		 * The meta object literal for the '<em><b>Driver Costs Per Hour</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__DRIVER_COSTS_PER_HOUR = eINSTANCE.getVehicle_DriverCostsPerHour();

		/**
		 * The meta object literal for the '<em><b>Transshipment Fix Costs Euro</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__TRANSSHIPMENT_FIX_COSTS_EURO = eINSTANCE.getVehicle_TransshipmentFixCostsEuro();

		/**
		 * The meta object literal for the '<em><b>Transhipment Time In Minutes</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__TRANSHIPMENT_TIME_IN_MINUTES = eINSTANCE.getVehicle_TranshipmentTimeInMinutes();

		/**
		 * The meta object literal for the '<em><b>Pay Load Depending Consumption Rate</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VEHICLE__PAY_LOAD_DEPENDING_CONSUMPTION_RATE = eINSTANCE.getVehicle_PayLoadDependingConsumptionRate();

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
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.OrderImpl <em>Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.OrderImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getOrder()
		 * @generated
		 */
		EClass ORDER = eINSTANCE.getOrder();

		/**
		 * The meta object literal for the '<em><b>Need As Volume</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__NEED_AS_VOLUME = eINSTANCE.getOrder_NeedAsVolume();

		/**
		 * The meta object literal for the '<em><b>Need As Weight</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__NEED_AS_WEIGHT = eINSTANCE.getOrder_NeedAsWeight();

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
		 * The meta object literal for the '{@link de.fuberlin.winfo.project.model.network.impl.CollectiveOrderImpl <em>Collective Order</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see de.fuberlin.winfo.project.model.network.impl.CollectiveOrderImpl
		 * @see de.fuberlin.winfo.project.model.network.impl.NetworkPackageImpl#getCollectiveOrder()
		 * @generated
		 */
		EClass COLLECTIVE_ORDER = eINSTANCE.getCollectiveOrder();

		/**
		 * The meta object literal for the '<em><b>Consist Of</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIVE_ORDER__CONSIST_OF = eINSTANCE.getCollectiveOrder_ConsistOf();

		/**
		 * The meta object literal for the '<em><b>Receiver</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COLLECTIVE_ORDER__RECEIVER = eINSTANCE.getCollectiveOrder_Receiver();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ORDER__ID = eINSTANCE.getOrder_Id();

	}

} //NetworkPackage
