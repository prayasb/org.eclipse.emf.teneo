/**
 * <copyright>
 * </copyright>
 *
 * $Id: TableID.java,v 1.1 2008/10/27 13:18:30 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.issues.bz250239;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Table ID</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.samples.issues.bz250239.TableID#getMyid <em>Myid</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.samples.issues.bz250239.Bz250239Package#getTableID()
 * @model extendedMetaData="name='TableID' kind='elementOnly'"
 * @generated
 */
public interface TableID extends EObject {
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
	 * @see org.eclipse.emf.teneo.samples.issues.bz250239.Bz250239Package#getTableID_Myid()
	 * @model unique="false" unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 *        annotation="teneo.jpa appinfo='\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=\"TABLE\")\n\t\t\t'"
	 *        extendedMetaData="kind='element' name='myid'"
	 * @generated
	 */
	long getMyid();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.issues.bz250239.TableID#getMyid <em>Myid</em>}' attribute.
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
	 * Unsets the value of the '{@link org.eclipse.emf.teneo.samples.issues.bz250239.TableID#getMyid <em>Myid</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetMyid()
	 * @see #getMyid()
	 * @see #setMyid(long)
	 * @generated
	 */
	void unsetMyid();

	/**
	 * Returns whether the value of the '{@link org.eclipse.emf.teneo.samples.issues.bz250239.TableID#getMyid <em>Myid</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Myid</em>' attribute is set.
	 * @see #unsetMyid()
	 * @see #getMyid()
	 * @see #setMyid(long)
	 * @generated
	 */
	boolean isSetMyid();

} // TableID
