/**
 * <copyright>
 * </copyright>
 *
 * $Id: Person.java,v 1.4 2010/02/06 18:17:47 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getId <em>Id</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getAddress <em>Address</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getPhoto <em>Photo</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.SecondarytablehibernatePackage#getPerson()
 * @model annotation="teneo.jpa appinfo='@SecondaryTables({\n\t\t\t\t@SecondaryTable(name=\"person_address\"),\n\t\t\t\t@SecondaryTable(name=\"person_photo\")})'"
 *        extendedMetaData="name='Person' kind='elementOnly'"
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #setId(long)
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.SecondarytablehibernatePackage#getPerson_Id()
	 * @model unsettable="true" dataType="org.eclipse.emf.ecore.xml.type.Long" required="true"
	 *        annotation="teneo.jpa appinfo='@Id'"
	 *        extendedMetaData="kind='element' name='id'"
	 * @generated
	 */
	long getId();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #isSetId()
	 * @see #unsetId()
	 * @see #getId()
	 * @generated
	 */
	void setId(long value);

	/**
	 * Unsets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	void unsetId();

	/**
	 * Returns whether the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getId <em>Id</em>}' attribute is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Id</em>' attribute is set.
	 * @see #unsetId()
	 * @see #getId()
	 * @see #setId(long)
	 * @generated
	 */
	boolean isSetId();

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
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.SecondarytablehibernatePackage#getPerson_Name()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String" required="true"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Address</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Address</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Address</em>' attribute.
	 * @see #setAddress(String)
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.SecondarytablehibernatePackage#getPerson_Address()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        annotation="teneo.jpa appinfo='@Lob\n\t\t\t\t\t@Column(table=\"person_address\" nullable=false)\n\t\t\t\t\t@Basic(optional=false)\n\t\t\t\t\t'"
	 *        extendedMetaData="kind='element' name='address'"
	 * @generated
	 */
	String getAddress();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getAddress <em>Address</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Address</em>' attribute.
	 * @see #getAddress()
	 * @generated
	 */
	void setAddress(String value);

	/**
	 * Returns the value of the '<em><b>Photo</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Photo</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Photo</em>' attribute.
	 * @see #setPhoto(byte[])
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.SecondarytablehibernatePackage#getPerson_Photo()
	 * @model dataType="org.eclipse.emf.ecore.xml.type.Base64Binary"
	 *        annotation="teneo.jpa appinfo='@Lob\n\t\t\t\t\t@Column(table=\"person_photo\" length=\"1000000\")'"
	 *        extendedMetaData="kind='element' name='photo'"
	 * @generated
	 */
	byte[] getPhoto();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.annotations.secondarytablehibernate.Person#getPhoto <em>Photo</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Photo</em>' attribute.
	 * @see #getPhoto()
	 * @generated
	 */
	void setPhoto(byte[] value);

} // Person