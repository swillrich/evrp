/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.solution.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class SolutionFactoryImpl extends EFactoryImpl implements SolutionFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static SolutionFactory init() {
		try {
			SolutionFactory theSolutionFactory = (SolutionFactory)EPackage.Registry.INSTANCE.getEFactory(SolutionPackage.eNS_URI);
			if (theSolutionFactory != null) {
				return theSolutionFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new SolutionFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case SolutionPackage.ROUTE: return createRoute();
			case SolutionPackage.SOLUTION: return createSolution();
			case SolutionPackage.USED_EDGE: return createUsedEdge();
			case SolutionPackage.USE_CASE: return createUseCase();
			case SolutionPackage.DELIVERY: return createDelivery();
			case SolutionPackage.VNS_SEARCH: return createVNSSearch();
			case SolutionPackage.NEIGHBORHOOD_SEARCH: return createNeighborhoodSearch();
			case SolutionPackage.SEARCH_HISTORY: return createSearchHistory();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Route createRoute() {
		RouteImpl route = new RouteImpl();
		return route;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Solution createSolution() {
		SolutionImpl solution = new SolutionImpl();
		return solution;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsedEdge createUsedEdge() {
		UsedEdgeImpl usedEdge = new UsedEdgeImpl();
		return usedEdge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UseCase createUseCase() {
		UseCaseImpl useCase = new UseCaseImpl();
		return useCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Delivery createDelivery() {
		DeliveryImpl delivery = new DeliveryImpl();
		return delivery;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VNSSearch createVNSSearch() {
		VNSSearchImpl vnsSearch = new VNSSearchImpl();
		return vnsSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NeighborhoodSearch createNeighborhoodSearch() {
		NeighborhoodSearchImpl neighborhoodSearch = new NeighborhoodSearchImpl();
		return neighborhoodSearch;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SearchHistory createSearchHistory() {
		SearchHistoryImpl searchHistory = new SearchHistoryImpl();
		return searchHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SolutionPackage getSolutionPackage() {
		return (SolutionPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static SolutionPackage getPackage() {
		return SolutionPackage.eINSTANCE;
	}

} //SolutionFactoryImpl
