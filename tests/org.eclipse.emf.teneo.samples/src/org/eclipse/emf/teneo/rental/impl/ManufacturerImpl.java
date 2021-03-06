/**
 * <copyright>
 * </copyright>
 *
 * $Id: ManufacturerImpl.java,v 1.2 2010/10/29 09:35:33 mtaal Exp $
 */
package org.eclipse.emf.teneo.rental.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.teneo.rental.Manufacturer;
import org.eclipse.emf.teneo.rental.RentalPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Manufacturer</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.rental.impl.ManufacturerImpl#getCode <em>Code</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.rental.impl.ManufacturerImpl#getTrusted <em>Trusted</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ManufacturerImpl extends EObjectImpl implements Manufacturer {
	/**
	 * The default value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected static final String CODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCode() <em>Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCode()
	 * @generated
	 * @ordered
	 */
	protected String code = CODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getTrusted() <em>Trusted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrusted()
	 * @generated
	 * @ordered
	 */
	protected static final Boolean TRUSTED_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTrusted() <em>Trusted</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTrusted()
	 * @generated
	 * @ordered
	 */
	protected Boolean trusted = TRUSTED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ManufacturerImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return RentalPackage.Literals.MANUFACTURER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCode() {
		return code;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCode(String newCode) {
		String oldCode = code;
		code = newCode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RentalPackage.MANUFACTURER__CODE, oldCode, code));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Boolean getTrusted() {
		return trusted;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTrusted(Boolean newTrusted) {
		Boolean oldTrusted = trusted;
		trusted = newTrusted;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, RentalPackage.MANUFACTURER__TRUSTED, oldTrusted, trusted));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case RentalPackage.MANUFACTURER__CODE:
				return getCode();
			case RentalPackage.MANUFACTURER__TRUSTED:
				return getTrusted();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case RentalPackage.MANUFACTURER__CODE:
				setCode((String)newValue);
				return;
			case RentalPackage.MANUFACTURER__TRUSTED:
				setTrusted((Boolean)newValue);
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
			case RentalPackage.MANUFACTURER__CODE:
				setCode(CODE_EDEFAULT);
				return;
			case RentalPackage.MANUFACTURER__TRUSTED:
				setTrusted(TRUSTED_EDEFAULT);
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
			case RentalPackage.MANUFACTURER__CODE:
				return CODE_EDEFAULT == null ? code != null : !CODE_EDEFAULT.equals(code);
			case RentalPackage.MANUFACTURER__TRUSTED:
				return TRUSTED_EDEFAULT == null ? trusted != null : !TRUSTED_EDEFAULT.equals(trusted);
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
		result.append(" (code: ");
		result.append(code);
		result.append(", trusted: ");
		result.append(trusted);
		result.append(')');
		return result.toString();
	}

} //ManufacturerImpl
