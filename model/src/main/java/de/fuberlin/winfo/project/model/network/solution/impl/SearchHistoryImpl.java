/**
 */
package de.fuberlin.winfo.project.model.network.solution.impl;

import de.fuberlin.winfo.project.model.network.solution.SearchHistory;
import de.fuberlin.winfo.project.model.network.solution.SolutionPackage;
import de.fuberlin.winfo.project.model.network.solution.VNSSearch;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Search History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.solution.impl.SearchHistoryImpl#getVnsSearches <em>Vns Searches</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SearchHistoryImpl extends MinimalEObjectImpl.Container implements SearchHistory {
	/**
	 * The cached value of the '{@link #getVnsSearches() <em>Vns Searches</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVnsSearches()
	 * @generated
	 * @ordered
	 */
	protected EList<VNSSearch> vnsSearches;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SearchHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SolutionPackage.Literals.SEARCH_HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VNSSearch> getVnsSearches() {
		if (vnsSearches == null) {
			vnsSearches = new EObjectContainmentEList<VNSSearch>(VNSSearch.class, this, SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES);
		}
		return vnsSearches;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES:
				return ((InternalEList<?>)getVnsSearches()).basicRemove(otherEnd, msgs);
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
			case SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES:
				return getVnsSearches();
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
			case SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES:
				getVnsSearches().clear();
				getVnsSearches().addAll((Collection<? extends VNSSearch>)newValue);
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
			case SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES:
				getVnsSearches().clear();
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
			case SolutionPackage.SEARCH_HISTORY__VNS_SEARCHES:
				return vnsSearches != null && !vnsSearches.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SearchHistoryImpl
