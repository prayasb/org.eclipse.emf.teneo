/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdentityID.java,v 1.3 2007/08/10 16:41:10 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Identity ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdentityID#getMyid <em>Myid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdPackage#getIdentityID()
 * @model extendedMetaData="name='IdentityID' kind='elementOnly'"
 * @generated
 */
public interface IdentityID extends EObject {
	/**
	 * Returns the value of the '<em><b>Myid</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Myid</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Myid</em>' attribute.
	 * @see #isSetMyid()
	 * @see #unsetMyid()
	 * @see #setMyid(long)
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdPackage#getIdentityID_Myid()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 *        annotation="teneo.hibernate appinfo='\n\t\t\t\t\t\t@Id @GeneratedValue(strategy=\"IDENTITY\")\n\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='myid'"
	 * @generated
	 */
	long getMyid();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdentityID#getMyid <em>Myid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Myid</em>' attribute.
	 * @see #isSetMyid()
	 * @see #unsetMyid()
	 * @see #getMyid()
	 * @generated
	 */
	void setMyid(long value);

	/**
	 * Unsets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdentityID#getMyid <em>Myid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMyid()
	 * @see #getMyid()
	 * @see #setMyid(long)
	 * @generated
	 */
	void unsetMyid();

	/**
	 * Returns whether the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.hb.generator.id.IdentityID#getMyid <em>Myid</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Myid</em>' attribute is set.
	 * @see #unsetMyid()
	 * @see #getMyid()
	 * @see #setMyid(long)
	 * @generated
	 */
	boolean isSetMyid();

} // IdentityID