/**
 * <copyright>
 * </copyright>
 *
 * $Id: ThreadImpl.java,v 1.1 2006/11/23 06:12:10 mtaal Exp $
 */
package org.example.mindmap.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.example.mindmap.MindmapPackage;
import org.example.mindmap.Resource;
import org.example.mindmap.ThreadItem;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.example.mindmap.impl.ThreadImpl#getItems <em>Items</em>}</li>
 *   <li>{@link org.example.mindmap.impl.ThreadImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.example.mindmap.impl.ThreadImpl#getPostDate <em>Post Date</em>}</li>
 *   <li>{@link org.example.mindmap.impl.ThreadImpl#getSubject <em>Subject</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ThreadImpl extends EObjectImpl implements org.example.mindmap.Thread {
	/**
	 * The cached value of the '{@link #getItems() <em>Items</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getItems()
	 * @generated
	 * @ordered
	 */
	protected EList items = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected Resource author = null;

	/**
	 * The default value of the '{@link #getPostDate() <em>Post Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostDate()
	 * @generated
	 * @ordered
	 */
	protected static final Object POST_DATE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPostDate() <em>Post Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostDate()
	 * @generated
	 * @ordered
	 */
	protected Object postDate = POST_DATE_EDEFAULT;

	/**
	 * The default value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected static final String SUBJECT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSubject() <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubject()
	 * @generated
	 * @ordered
	 */
	protected String subject = SUBJECT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ThreadImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return MindmapPackage.Literals.THREAD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getItems() {
		if (items == null) {
			items = new EObjectContainmentEList(ThreadItem.class, this, MindmapPackage.THREAD__ITEMS);
		}
		return items;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource getAuthor() {
		if (author != null && author.eIsProxy()) {
			InternalEObject oldAuthor = (InternalEObject)author;
			author = (Resource)eResolveProxy(oldAuthor);
			if (author != oldAuthor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, MindmapPackage.THREAD__AUTHOR, oldAuthor, author));
			}
		}
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Resource basicGetAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAuthor(Resource newAuthor, NotificationChain msgs) {
		Resource oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, MindmapPackage.THREAD__AUTHOR, oldAuthor, newAuthor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAuthor(Resource newAuthor) {
		if (newAuthor != author) {
			NotificationChain msgs = null;
			if (author != null)
				msgs = ((InternalEObject)author).eInverseRemove(this, MindmapPackage.RESOURCE__COMMENTS, Resource.class, msgs);
			if (newAuthor != null)
				msgs = ((InternalEObject)newAuthor).eInverseAdd(this, MindmapPackage.RESOURCE__COMMENTS, Resource.class, msgs);
			msgs = basicSetAuthor(newAuthor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.THREAD__AUTHOR, newAuthor, newAuthor));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getPostDate() {
		return postDate;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPostDate(Object newPostDate) {
		Object oldPostDate = postDate;
		postDate = newPostDate;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.THREAD__POST_DATE, oldPostDate, postDate));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSubject(String newSubject) {
		String oldSubject = subject;
		subject = newSubject;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MindmapPackage.THREAD__SUBJECT, oldSubject, subject));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapPackage.THREAD__AUTHOR:
				if (author != null)
					msgs = ((InternalEObject)author).eInverseRemove(this, MindmapPackage.RESOURCE__COMMENTS, Resource.class, msgs);
				return basicSetAuthor((Resource)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MindmapPackage.THREAD__ITEMS:
				return ((InternalEList)getItems()).basicRemove(otherEnd, msgs);
			case MindmapPackage.THREAD__AUTHOR:
				return basicSetAuthor(null, msgs);
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
			case MindmapPackage.THREAD__ITEMS:
				return getItems();
			case MindmapPackage.THREAD__AUTHOR:
				if (resolve) return getAuthor();
				return basicGetAuthor();
			case MindmapPackage.THREAD__POST_DATE:
				return getPostDate();
			case MindmapPackage.THREAD__SUBJECT:
				return getSubject();
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
			case MindmapPackage.THREAD__ITEMS:
				getItems().clear();
				getItems().addAll((Collection)newValue);
				return;
			case MindmapPackage.THREAD__AUTHOR:
				setAuthor((Resource)newValue);
				return;
			case MindmapPackage.THREAD__POST_DATE:
				setPostDate((Object)newValue);
				return;
			case MindmapPackage.THREAD__SUBJECT:
				setSubject((String)newValue);
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
			case MindmapPackage.THREAD__ITEMS:
				getItems().clear();
				return;
			case MindmapPackage.THREAD__AUTHOR:
				setAuthor((Resource)null);
				return;
			case MindmapPackage.THREAD__POST_DATE:
				setPostDate(POST_DATE_EDEFAULT);
				return;
			case MindmapPackage.THREAD__SUBJECT:
				setSubject(SUBJECT_EDEFAULT);
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
			case MindmapPackage.THREAD__ITEMS:
				return items != null && !items.isEmpty();
			case MindmapPackage.THREAD__AUTHOR:
				return author != null;
			case MindmapPackage.THREAD__POST_DATE:
				return POST_DATE_EDEFAULT == null ? postDate != null : !POST_DATE_EDEFAULT.equals(postDate);
			case MindmapPackage.THREAD__SUBJECT:
				return SUBJECT_EDEFAULT == null ? subject != null : !SUBJECT_EDEFAULT.equals(subject);
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
		result.append(" (postDate: ");
		result.append(postDate);
		result.append(", subject: ");
		result.append(subject);
		result.append(')');
		return result.toString();
	}

} //ThreadImpl