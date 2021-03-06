/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package lobj.impl;

import java.util.Collection;
import java.util.Date;

import lobj.Author;
import lobj.DidacMeta;
import lobj.Domain;
import lobj.Language;
import lobj.LobjPackage;
import lobj.LuMeta;
import lobj.PublishInfo;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Lu Meta</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link lobj.impl.LuMetaImpl#getDidacMeta <em>Didac Meta</em>}</li>
 *   <li>{@link lobj.impl.LuMetaImpl#getCreationDate <em>Creation Date</em>}</li>
 *   <li>{@link lobj.impl.LuMetaImpl#getDomain <em>Domain</em>}</li>
 *   <li>{@link lobj.impl.LuMetaImpl#getAuthors <em>Authors</em>}</li>
 *   <li>{@link lobj.impl.LuMetaImpl#getPublishInfo <em>Publish Info</em>}</li>
 *   <li>{@link lobj.impl.LuMetaImpl#getDefLang <em>Def Lang</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LuMetaImpl extends LearningObjectImpl implements LuMeta {
	/**
	 * The cached value of the '{@link #getDidacMeta() <em>Didac Meta</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDidacMeta()
	 * @generated
	 * @ordered
	 */
	protected EList didacMeta;

	/**
	 * The default value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected static final Date CREATION_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCreationDate() <em>Creation Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationDate()
	 * @generated
	 * @ordered
	 */
	protected Date creationDate = CREATION_DATE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDomain() <em>Domain</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomain()
	 * @generated
	 * @ordered
	 */
	protected Domain domain;

	/**
	 * The cached value of the '{@link #getAuthors() <em>Authors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthors()
	 * @generated
	 * @ordered
	 */
	protected EList authors;

	/**
	 * The cached value of the '{@link #getPublishInfo() <em>Publish Info</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPublishInfo()
	 * @generated
	 * @ordered
	 */
	protected PublishInfo publishInfo;

	/**
	 * The cached value of the '{@link #getDefLang() <em>Def Lang</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefLang()
	 * @generated
	 * @ordered
	 */
	protected Language defLang;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LuMetaImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return LobjPackage.Literals.LU_META;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getDidacMeta() {
		if (didacMeta == null) {
			didacMeta = new EObjectContainmentEList(DidacMeta.class, this, LobjPackage.LU_META__DIDAC_META);
		}
		return didacMeta;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Date getCreationDate() {
		return creationDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCreationDate(Date newCreationDate) {
		Date oldCreationDate = creationDate;
		creationDate = newCreationDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LobjPackage.LU_META__CREATION_DATE, oldCreationDate, creationDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain getDomain() {
		if (domain != null && domain.eIsProxy()) {
			InternalEObject oldDomain = (InternalEObject)domain;
			domain = (Domain)eResolveProxy(oldDomain);
			if (domain != oldDomain) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LobjPackage.LU_META__DOMAIN, oldDomain, domain));
			}
		}
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Domain basicGetDomain() {
		return domain;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomain(Domain newDomain) {
		Domain oldDomain = domain;
		domain = newDomain;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LobjPackage.LU_META__DOMAIN, oldDomain, domain));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getAuthors() {
		if (authors == null) {
			authors = new EObjectContainmentEList(Author.class, this, LobjPackage.LU_META__AUTHORS);
		}
		return authors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PublishInfo getPublishInfo() {
		return publishInfo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetPublishInfo(PublishInfo newPublishInfo, NotificationChain msgs) {
		PublishInfo oldPublishInfo = publishInfo;
		publishInfo = newPublishInfo;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, LobjPackage.LU_META__PUBLISH_INFO, oldPublishInfo, newPublishInfo);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPublishInfo(PublishInfo newPublishInfo) {
		if (newPublishInfo != publishInfo) {
			NotificationChain msgs = null;
			if (publishInfo != null)
				msgs = ((InternalEObject)publishInfo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - LobjPackage.LU_META__PUBLISH_INFO, null, msgs);
			if (newPublishInfo != null)
				msgs = ((InternalEObject)newPublishInfo).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - LobjPackage.LU_META__PUBLISH_INFO, null, msgs);
			msgs = basicSetPublishInfo(newPublishInfo, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LobjPackage.LU_META__PUBLISH_INFO, newPublishInfo, newPublishInfo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language getDefLang() {
		if (defLang != null && defLang.eIsProxy()) {
			InternalEObject oldDefLang = (InternalEObject)defLang;
			defLang = (Language)eResolveProxy(oldDefLang);
			if (defLang != oldDefLang) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, LobjPackage.LU_META__DEF_LANG, oldDefLang, defLang));
			}
		}
		return defLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Language basicGetDefLang() {
		return defLang;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefLang(Language newDefLang) {
		Language oldDefLang = defLang;
		defLang = newDefLang;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, LobjPackage.LU_META__DEF_LANG, oldDefLang, defLang));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case LobjPackage.LU_META__DIDAC_META:
				return ((InternalEList)getDidacMeta()).basicRemove(otherEnd, msgs);
			case LobjPackage.LU_META__AUTHORS:
				return ((InternalEList)getAuthors()).basicRemove(otherEnd, msgs);
			case LobjPackage.LU_META__PUBLISH_INFO:
				return basicSetPublishInfo(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case LobjPackage.LU_META__DIDAC_META:
				return getDidacMeta();
			case LobjPackage.LU_META__CREATION_DATE:
				return getCreationDate();
			case LobjPackage.LU_META__DOMAIN:
				if (resolve) return getDomain();
				return basicGetDomain();
			case LobjPackage.LU_META__AUTHORS:
				return getAuthors();
			case LobjPackage.LU_META__PUBLISH_INFO:
				return getPublishInfo();
			case LobjPackage.LU_META__DEF_LANG:
				if (resolve) return getDefLang();
				return basicGetDefLang();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case LobjPackage.LU_META__DIDAC_META:
				getDidacMeta().clear();
				getDidacMeta().addAll((Collection)newValue);
				return;
			case LobjPackage.LU_META__CREATION_DATE:
				setCreationDate((Date)newValue);
				return;
			case LobjPackage.LU_META__DOMAIN:
				setDomain((Domain)newValue);
				return;
			case LobjPackage.LU_META__AUTHORS:
				getAuthors().clear();
				getAuthors().addAll((Collection)newValue);
				return;
			case LobjPackage.LU_META__PUBLISH_INFO:
				setPublishInfo((PublishInfo)newValue);
				return;
			case LobjPackage.LU_META__DEF_LANG:
				setDefLang((Language)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case LobjPackage.LU_META__DIDAC_META:
				getDidacMeta().clear();
				return;
			case LobjPackage.LU_META__CREATION_DATE:
				setCreationDate(CREATION_DATE_EDEFAULT);
				return;
			case LobjPackage.LU_META__DOMAIN:
				setDomain((Domain)null);
				return;
			case LobjPackage.LU_META__AUTHORS:
				getAuthors().clear();
				return;
			case LobjPackage.LU_META__PUBLISH_INFO:
				setPublishInfo((PublishInfo)null);
				return;
			case LobjPackage.LU_META__DEF_LANG:
				setDefLang((Language)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case LobjPackage.LU_META__DIDAC_META:
				return didacMeta != null && !didacMeta.isEmpty();
			case LobjPackage.LU_META__CREATION_DATE:
				return CREATION_DATE_EDEFAULT == null ? creationDate != null : !CREATION_DATE_EDEFAULT.equals(creationDate);
			case LobjPackage.LU_META__DOMAIN:
				return domain != null;
			case LobjPackage.LU_META__AUTHORS:
				return authors != null && !authors.isEmpty();
			case LobjPackage.LU_META__PUBLISH_INFO:
				return publishInfo != null;
			case LobjPackage.LU_META__DEF_LANG:
				return defLang != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (creationDate: ");
		result.append(creationDate);
		result.append(')');
		return result.toString();
	}

} //LuMetaImpl
