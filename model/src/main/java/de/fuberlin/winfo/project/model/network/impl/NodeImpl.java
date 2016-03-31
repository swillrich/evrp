/**
 */
package de.fuberlin.winfo.project.model.network.impl;

import de.fuberlin.winfo.project.model.network.Edge;
import de.fuberlin.winfo.project.model.network.Locatable;
import de.fuberlin.winfo.project.model.network.NetworkPackage;
import de.fuberlin.winfo.project.model.network.Node;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl#getId <em>Id</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl#getEdgeIn <em>Edge In</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl#getEdgeOut <em>Edge Out</em>}</li>
 *   <li>{@link de.fuberlin.winfo.project.model.network.impl.NodeImpl#getRepresentative <em>Representative</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NodeImpl extends MinimalEObjectImpl.Container implements Node {
	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final int ID_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected int id = ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getEdgeIn() <em>Edge In</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeIn()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgeIn;

	/**
	 * The cached value of the '{@link #getEdgeOut() <em>Edge Out</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEdgeOut()
	 * @generated
	 * @ordered
	 */
	protected EList<Edge> edgeOut;

	/**
	 * The cached value of the '{@link #getRepresentative() <em>Representative</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepresentative()
	 * @generated
	 * @ordered
	 */
	protected Locatable representative;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NodeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NetworkPackage.Literals.NODE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setId(int newId) {
		int oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.NODE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgeIn() {
		if (edgeIn == null) {
			edgeIn = new EObjectResolvingEList<Edge>(Edge.class, this, NetworkPackage.NODE__EDGE_IN);
		}
		return edgeIn;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Edge> getEdgeOut() {
		if (edgeOut == null) {
			edgeOut = new EObjectResolvingEList<Edge>(Edge.class, this, NetworkPackage.NODE__EDGE_OUT);
		}
		return edgeOut;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Locatable getRepresentative() {
		return representative;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRepresentative(Locatable newRepresentative, NotificationChain msgs) {
		Locatable oldRepresentative = representative;
		representative = newRepresentative;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, NetworkPackage.NODE__REPRESENTATIVE, oldRepresentative, newRepresentative);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepresentative(Locatable newRepresentative) {
		if (newRepresentative != representative) {
			NotificationChain msgs = null;
			if (representative != null)
				msgs = ((InternalEObject)representative).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.NODE__REPRESENTATIVE, null, msgs);
			if (newRepresentative != null)
				msgs = ((InternalEObject)newRepresentative).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - NetworkPackage.NODE__REPRESENTATIVE, null, msgs);
			msgs = basicSetRepresentative(newRepresentative, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, NetworkPackage.NODE__REPRESENTATIVE, newRepresentative, newRepresentative));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NetworkPackage.NODE__REPRESENTATIVE:
				return basicSetRepresentative(null, msgs);
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
			case NetworkPackage.NODE__ID:
				return getId();
			case NetworkPackage.NODE__EDGE_IN:
				return getEdgeIn();
			case NetworkPackage.NODE__EDGE_OUT:
				return getEdgeOut();
			case NetworkPackage.NODE__REPRESENTATIVE:
				return getRepresentative();
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
			case NetworkPackage.NODE__ID:
				setId((Integer)newValue);
				return;
			case NetworkPackage.NODE__EDGE_IN:
				getEdgeIn().clear();
				getEdgeIn().addAll((Collection<? extends Edge>)newValue);
				return;
			case NetworkPackage.NODE__EDGE_OUT:
				getEdgeOut().clear();
				getEdgeOut().addAll((Collection<? extends Edge>)newValue);
				return;
			case NetworkPackage.NODE__REPRESENTATIVE:
				setRepresentative((Locatable)newValue);
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
			case NetworkPackage.NODE__ID:
				setId(ID_EDEFAULT);
				return;
			case NetworkPackage.NODE__EDGE_IN:
				getEdgeIn().clear();
				return;
			case NetworkPackage.NODE__EDGE_OUT:
				getEdgeOut().clear();
				return;
			case NetworkPackage.NODE__REPRESENTATIVE:
				setRepresentative((Locatable)null);
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
			case NetworkPackage.NODE__ID:
				return id != ID_EDEFAULT;
			case NetworkPackage.NODE__EDGE_IN:
				return edgeIn != null && !edgeIn.isEmpty();
			case NetworkPackage.NODE__EDGE_OUT:
				return edgeOut != null && !edgeOut.isEmpty();
			case NetworkPackage.NODE__REPRESENTATIVE:
				return representative != null;
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
		result.append(')');
		return result.toString();
	}

} //NodeImpl
