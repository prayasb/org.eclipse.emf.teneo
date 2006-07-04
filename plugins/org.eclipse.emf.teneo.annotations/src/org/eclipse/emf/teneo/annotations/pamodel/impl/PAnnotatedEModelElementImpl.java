/**
 * <copyright>
 * </copyright>
 *
 * $Id: PAnnotatedEModelElementImpl.java,v 1.2 2006/07/04 21:56:30 mtaal Exp $
 */
package org.eclipse.emf.teneo.annotations.pamodel.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.ENamedElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEModelElement;
import org.eclipse.emf.teneo.annotations.pamodel.PamodelPackage;
import org.eclipse.emf.teneo.annotations.pannotation.PAnnotation;
import org.eclipse.emf.teneo.annotations.pannotation.Transient;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>PAnnotated EModel Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pamodel.impl.PAnnotatedEModelElementImpl#getAnnotatedElement <em>Annotated Element</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pamodel.impl.PAnnotatedEModelElementImpl#getTransient <em>Transient</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class PAnnotatedEModelElementImpl extends EObjectImpl implements PAnnotatedEModelElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 Springsite BV (The Netherlands) and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public\nLicense v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n   Martin Taal\n   Davide Marchignoli\n";

	/**
	 * The cached value of the '{@link #getTransient() <em>Transient</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransient()
	 * @generated
	 * @ordered
	 */
	protected Transient transient_ = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PAnnotatedEModelElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return PamodelPackage.eINSTANCE.getPAnnotatedEModelElement();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ENamedElement getAnnotatedElement() {
		ENamedElement annotatedElement = basicGetAnnotatedElement();
		return annotatedElement == null ? null : (ENamedElement)eResolveProxy((InternalEObject)annotatedElement);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract ENamedElement basicGetAnnotatedElement();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public abstract void setAnnotatedElement(ENamedElement newAnnotatedElement);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transient getTransient() {
		return transient_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTransient(Transient newTransient, NotificationChain msgs) {
		Transient oldTransient = transient_;
		transient_ = newTransient;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT, oldTransient, newTransient);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransient(Transient newTransient) {
		if (newTransient != transient_) {
			NotificationChain msgs = null;
			if (transient_ != null)
				msgs = ((InternalEObject)transient_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT, null, msgs);
			if (newTransient != null)
				msgs = ((InternalEObject)newTransient).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT, null, msgs);
			msgs = basicSetTransient(newTransient, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT, newTransient, newTransient));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT:
					return basicSetTransient(null, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__ANNOTATED_ELEMENT:
				if (resolve) return getAnnotatedElement();
				return basicGetAnnotatedElement();
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT:
				return getTransient();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__ANNOTATED_ELEMENT:
				setAnnotatedElement((ENamedElement)newValue);
				return;
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT:
				setTransient((Transient)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__ANNOTATED_ELEMENT:
				setAnnotatedElement((ENamedElement)null);
				return;
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT:
				setTransient((Transient)null);
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__ANNOTATED_ELEMENT:
				return basicGetAnnotatedElement() != null;
			case PamodelPackage.PANNOTATED_EMODEL_ELEMENT__TRANSIENT:
				return transient_ != null;
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * {@inheritDoc }
	 */
	public List getAnnotations() {
		// TODO implement as wrapper on eContents?
		List annotations = new ArrayList();
		Iterator i = eContents().iterator();
		while (i.hasNext()) {
			Object x = i.next();
			if (x instanceof PAnnotation)
				annotations.add(x);
		}
		return annotations;
	}

	/** 
	 * Overridden to provide type info
	 * @see org.eclipse.emf.ecore.impl.BasicEObjectImpl#toString()
	 */
	public String toString() {
		ENamedElement em = getAnnotatedElement();
		return em.eClass().getName() + "/" + em.getName(); 
	}
} //PAnnotatedEModelElementImpl
