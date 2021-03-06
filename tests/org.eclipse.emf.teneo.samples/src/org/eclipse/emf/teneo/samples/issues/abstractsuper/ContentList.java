/**
 * <copyright>
 * </copyright>
 *
 * $Id: ContentList.java,v 1.1 2008/03/10 22:19:03 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.issues.abstractsuper;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Content List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.samples.issues.abstractsuper.ContentList#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.issues.abstractsuper.ContentList#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.issues.abstractsuper.ContentList#getPrice <em>Price</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.samples.issues.abstractsuper.AbstractsuperPackage#getContentList()
 * @model extendedMetaData="name='contentList' kind='elementOnly'"
 * @generated
 */
public interface ContentList extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.teneo.samples.issues.abstractsuper.AbstractsuperPackage#getContentList_Name()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        annotation="teneo.jpa appinfo='@Id'"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.issues.abstractsuper.ContentList#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.teneo.samples.issues.abstractsuper.Address}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' reference list.
	 * @see org.eclipse.emf.teneo.samples.issues.abstractsuper.AbstractsuperPackage#getContentList_Address()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='address'"
	 * @generated
	 */
	EList<Address> getAddress();

	/**
	 * Returns the value of the '<em><b>Price</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.teneo.samples.issues.abstractsuper.Price}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Price</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Price</em>' reference list.
	 * @see org.eclipse.emf.teneo.samples.issues.abstractsuper.AbstractsuperPackage#getContentList_Price()
	 * @model resolveProxies="false" required="true"
	 *        extendedMetaData="kind='element' name='price'"
	 * @generated
	 */
	EList<Price> getPrice();

} // ContentList
