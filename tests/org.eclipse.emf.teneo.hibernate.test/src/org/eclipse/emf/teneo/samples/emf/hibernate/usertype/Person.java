/**
 * <copyright>
 * </copyright>
 *
 * $Id: Person.java,v 1.10 2010/06/03 14:06:56 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.hibernate.usertype;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Person</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getNumbers <em>Numbers</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getPhoneNumbers <em>Phone Numbers</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getEmergencyContact <em>Emergency Contact</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getAddresses <em>Addresses</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getBirthPlace <em>Birth Place</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getDouble <em>Double</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getCertificate <em>Certificate</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getCertificates <em>Certificates</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson()
 * @model extendedMetaData="name='Person' kind='elementOnly'"
 *        annotation="teneo.hibernate appinfo='@NamedQuery(name=\"getPersonByBirthPlace\" query=\"select p from Person p where p.birthPlace=?\")\n@HbEntity(dynamicInsert=true, dynamicUpdate=true, mutable=true, selectBeforeUpdate=true, persister=\"org.hibernate.persister.entity.SingleTableEntityPersister\", optimisticLock=NONE, polymorphism=EXPLICIT)'"
 * @generated
 */
public interface Person extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(Name)
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Name()
	 * @model unique="false" dataType="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Name" required="true"
	 *        extendedMetaData="kind='element' name='name'"
	 * @generated
	 */
	Name getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(Name value);

	/**
	 * Returns the value of the '<em><b>Numbers</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Numbers</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Numbers</em>' attribute.
	 * @see #setNumbers(int[])
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Numbers()
	 * @model unique="false" dataType="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.IntArray" required="true"
	 *        extendedMetaData="kind='element' name='intArray'"
	 * @generated
	 */
	int[] getNumbers();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getNumbers <em>Numbers</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Numbers</em>' attribute.
	 * @see #getNumbers()
	 * @generated
	 */
	void setNumbers(int[] value);

	/**
	 * Returns the value of the '<em><b>Phone Numbers</b></em>' attribute list.
	 * The list contents are of type {@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsaPhoneNumber}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Phone Numbers</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Phone Numbers</em>' attribute list.
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_PhoneNumbers()
	 * @model dataType="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.PhoneNumber" upper="100"
	 * @generated
	 */
	EList getPhoneNumbers();

	/**
	 * Returns the value of the '<em><b>Emergency Contact</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Emergency Contact</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Emergency Contact</em>' attribute.
	 * @see #setEmergencyContact(UsaPhoneNumber)
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_EmergencyContact()
	 * @model default="" dataType="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.PhoneNumber"
	 * @generated
	 */
	UsaPhoneNumber getEmergencyContact();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getEmergencyContact <em>Emergency Contact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Emergency Contact</em>' attribute.
	 * @see #getEmergencyContact()
	 * @generated
	 */
	void setEmergencyContact(UsaPhoneNumber value);

	/**
	 * Returns the value of the '<em><b>Addresses</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Address}.
	 * It is bidirectional and its opposite is '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Address#getPerson <em>Person</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Addresses</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Addresses</em>' reference list.
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Addresses()
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Address#getPerson
	 * @model type="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Address" opposite="person"
	 *        annotation="teneo.jpa appinfo='@OnDelete(action=OnDeleteAction.CASCADE)\n@OneToMany(indexed=false, unique=true)'"
	 * @generated
	 */
	EList getAddresses();

	/**
	 * Returns the value of the '<em><b>Birth Place</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Birth Place</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Birth Place</em>' attribute.
	 * @see #setBirthPlace(String)
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_BirthPlace()
	 * @model required="true"
	 * @generated
	 */
	String getBirthPlace();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getBirthPlace <em>Birth Place</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Birth Place</em>' attribute.
	 * @see #getBirthPlace()
	 * @generated
	 */
	void setBirthPlace(String value);

	/**
	 * Returns the value of the '<em><b>Double</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Double</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Double</em>' attribute.
	 * @see #setDouble(Double)
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Double()
	 * @model default="0" unique="false" dataType="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.myDoubleType" required="true"
	 *        extendedMetaData="kind='element' name='intArray'"
	 * @generated
	 */
	Double getDouble();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getDouble <em>Double</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Double</em>' attribute.
	 * @see #getDouble()
	 * @generated
	 */
	void setDouble(Double value);

	/**
	 * Returns the value of the '<em><b>Certificate</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificate</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Certificate</em>' reference.
	 * @see #setCertificate(Certificate)
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Certificate()
	 * @model annotation="teneo.jpa appinfo='@Columns({@Column(name=\"cert_name\"), @Column(name=\"cert_length\")})\n\t\t\t\t\t'"
	 * @generated
	 */
	Certificate getCertificate();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person#getCertificate <em>Certificate</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Certificate</em>' reference.
	 * @see #getCertificate()
	 * @generated
	 */
	void setCertificate(Certificate value);

	/**
	 * Returns the value of the '<em><b>Certificates</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Certificate}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Certificates</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Certificates</em>' reference list.
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#getPerson_Certificates()
	 * @model type="org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Certificate"
	 *        annotation="teneo.jpa appinfo='@Columns({@Column(name=\"cert_name\"), @Column(name=\"cert_length\")})\n\t\t\t\t\t'"
	 * @generated
	 */
	EList getCertificates();

} // Person