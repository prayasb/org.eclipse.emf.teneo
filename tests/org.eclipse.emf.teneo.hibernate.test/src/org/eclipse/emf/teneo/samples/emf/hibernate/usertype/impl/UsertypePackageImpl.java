/**
 * <copyright>
 * </copyright>
 *
 * $Id: UsertypePackageImpl.java,v 1.13 2010/06/03 14:06:56 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.hibernate.usertype.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Address;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Certificate;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.City;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.CitySize;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Name;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.Person;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsaPhoneNumber;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypeFactory;
import org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class UsertypePackageImpl extends EPackageImpl implements UsertypePackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass addressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass certificateEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum citySizeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType nameEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType phoneNumberEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType intArrayEDataType = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType myDoubleTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.teneo.samples.emf.hibernate.usertype.UsertypePackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private UsertypePackageImpl() {
		super(eNS_URI, UsertypeFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link UsertypePackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static UsertypePackage init() {
		if (isInited) return (UsertypePackage)EPackage.Registry.INSTANCE.getEPackage(UsertypePackage.eNS_URI);

		// Obtain or create and register package
		UsertypePackageImpl theUsertypePackage = (UsertypePackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof UsertypePackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new UsertypePackageImpl());

		isInited = true;

		// Create package meta-data objects
		theUsertypePackage.createPackageContents();

		// Initialize created meta-data
		theUsertypePackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theUsertypePackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(UsertypePackage.eNS_URI, theUsertypePackage);
		return theUsertypePackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPerson() {
		return personEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Name() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Numbers() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_PhoneNumbers() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_EmergencyContact() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Addresses() {
		return (EReference)personEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_BirthPlace() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPerson_Double() {
		return (EAttribute)personEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Certificate() {
		return (EReference)personEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPerson_Certificates() {
		return (EReference)personEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAddress() {
		return addressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAddress_AddressInfo() {
		return (EAttribute)addressEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAddress_Person() {
		return (EReference)addressEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCity() {
		return cityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCity_Id() {
		return (EAttribute)cityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCity_Size() {
		return (EAttribute)cityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCertificate() {
		return certificateEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCertificate_Name() {
		return (EAttribute)certificateEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCertificate_Length() {
		return (EAttribute)certificateEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getCitySize() {
		return citySizeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getName_() {
		return nameEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getPhoneNumber() {
		return phoneNumberEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getIntArray() {
		return intArrayEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EDataType getmyDoubleType() {
		return myDoubleTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UsertypeFactory getUsertypeFactory() {
		return (UsertypeFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		personEClass = createEClass(PERSON);
		createEAttribute(personEClass, PERSON__NAME);
		createEAttribute(personEClass, PERSON__NUMBERS);
		createEAttribute(personEClass, PERSON__PHONE_NUMBERS);
		createEAttribute(personEClass, PERSON__EMERGENCY_CONTACT);
		createEReference(personEClass, PERSON__ADDRESSES);
		createEAttribute(personEClass, PERSON__BIRTH_PLACE);
		createEAttribute(personEClass, PERSON__DOUBLE);
		createEReference(personEClass, PERSON__CERTIFICATE);
		createEReference(personEClass, PERSON__CERTIFICATES);

		addressEClass = createEClass(ADDRESS);
		createEAttribute(addressEClass, ADDRESS__ADDRESS_INFO);
		createEReference(addressEClass, ADDRESS__PERSON);

		cityEClass = createEClass(CITY);
		createEAttribute(cityEClass, CITY__ID);
		createEAttribute(cityEClass, CITY__SIZE);

		certificateEClass = createEClass(CERTIFICATE);
		createEAttribute(certificateEClass, CERTIFICATE__NAME);
		createEAttribute(certificateEClass, CERTIFICATE__LENGTH);

		// Create enums
		citySizeEEnum = createEEnum(CITY_SIZE);

		// Create data types
		nameEDataType = createEDataType(NAME);
		phoneNumberEDataType = createEDataType(PHONE_NUMBER);
		intArrayEDataType = createEDataType(INT_ARRAY);
		myDoubleTypeEDataType = createEDataType(MY_DOUBLE_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(personEClass, Person.class, "Person", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPerson_Name(), this.getName_(), "name", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Numbers(), this.getIntArray(), "numbers", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_PhoneNumbers(), this.getPhoneNumber(), "phoneNumbers", null, 0, 100, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_EmergencyContact(), this.getPhoneNumber(), "emergencyContact", "", 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Addresses(), this.getAddress(), this.getAddress_Person(), "addresses", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_BirthPlace(), ecorePackage.getEString(), "birthPlace", null, 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getPerson_Double(), this.getmyDoubleType(), "double", "0", 1, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Certificate(), this.getCertificate(), null, "certificate", null, 0, 1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPerson_Certificates(), this.getCertificate(), null, "certificates", null, 0, -1, Person.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(addressEClass, Address.class, "Address", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAddress_AddressInfo(), ecorePackage.getEString(), "addressInfo", null, 1, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAddress_Person(), this.getPerson(), this.getPerson_Addresses(), "person", null, 0, 1, Address.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(cityEClass, City.class, "City", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCity_Id(), ecorePackage.getELong(), "id", "0", 0, 1, City.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCity_Size(), this.getCitySize(), "size", "MEDIUM", 0, 1, City.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(certificateEClass, Certificate.class, "Certificate", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCertificate_Name(), ecorePackage.getEString(), "name", null, 1, 1, Certificate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCertificate_Length(), ecorePackage.getEInt(), "length", null, 1, 1, Certificate.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(citySizeEEnum, CitySize.class, "CitySize");
		addEEnumLiteral(citySizeEEnum, CitySize.SMALL_LITERAL);
		addEEnumLiteral(citySizeEEnum, CitySize.MEDIUM_LITERAL);
		addEEnumLiteral(citySizeEEnum, CitySize.LARGE_LITERAL);

		// Initialize data types
		initEDataType(nameEDataType, Name.class, "Name", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(phoneNumberEDataType, UsaPhoneNumber.class, "PhoneNumber", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(intArrayEDataType, int[].class, "IntArray", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);
		initEDataType(myDoubleTypeEDataType, Double.class, "myDoubleType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// teneo.hibernate
		createTeneoAnnotations();
		// teneo.jpa
		createTeneo_1Annotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>teneo.hibernate</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.hibernate";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "appinfo", "\t\t\t\t\t\t@NamedQuery(name=\"getPersonByBirthPlace2\" query=\"select p from Person p where p.birthPlace=?\")\n\t\t\t\t\t"
		   });					
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@NamedQuery(name=\"getPersonByBirthPlace\" query=\"select p from Person p where p.birthPlace=?\")\n@HbEntity(dynamicInsert=true, dynamicUpdate=true, mutable=true, selectBeforeUpdate=true, persister=\"org.hibernate.persister.entity.SingleTableEntityPersister\", optimisticLock=NONE, polymorphism=EXPLICIT)"
		   });																
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createTeneo_1Annotations() {
		String source = "teneo.jpa";			
		addAnnotation
		  (nameEDataType, 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t\t\t@TypeDef(name=\"nameType\" typeClass=\"org.eclipse.emf.teneo.samples.emf.hibernate.usertype.NameType\")\n\t\t\t\t\t\t@Columns({@Column(name=\"first_name\"), @Column(name=\"last_name\")})\n\t\t\t\t\t"
		   });							
		addAnnotation
		  (getPerson_Addresses(), 
		   source, 
		   new String[] {
			 "appinfo", "@OnDelete(action=OnDeleteAction.CASCADE)\n@OneToMany(indexed=false, unique=true)"
		   });			
		addAnnotation
		  (getPerson_Certificate(), 
		   source, 
		   new String[] {
			 "appinfo", "@Columns({@Column(name=\"cert_name\"), @Column(name=\"cert_length\")})\n\t\t\t\t\t"
		   });		
		addAnnotation
		  (getPerson_Certificates(), 
		   source, 
		   new String[] {
			 "appinfo", "@Columns({@Column(name=\"cert_name\"), @Column(name=\"cert_length\")})\n\t\t\t\t\t"
		   });			
		addAnnotation
		  (intArrayEDataType, 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t\t\t@TypeDef(name=\"intArrayType\" typeClass=\"org.eclipse.emf.teneo.hibernate.mapping.DefaultToStringUserType\", parameters={@Parameter(name=\"epackage\" value=\"http://www.elver.org/samples/emf/hibernate/usertype\"), @Parameter(name=\"edatatype\", value=\"IntArray\")})\n\t\t\t\t\t"
		   });					
		addAnnotation
		  (myDoubleTypeEDataType, 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t\t\t@Type(type=\"org.eclipse.emf.teneo.hibernate.mapping.DefaultToStringUserType\", parameters={@Parameter(name=\"epackage\" value=\"http://www.elver.org/samples/emf/hibernate/usertype\"), @Parameter(name=\"edatatype\", value=\"myDoubleType\")})\n\t\t\t\t\t"
		   });		
		addAnnotation
		  (getCity_Id(), 
		   source, 
		   new String[] {
			 "value", "@GeneratedValue(strategy=\"ASSIGNED\")"
		   });		
		addAnnotation
		  (certificateEClass, 
		   source, 
		   new String[] {
			 "appinfo", "@Type(type=\"org.eclipse.emf.teneo.samples.emf.hibernate.usertype.CertificateType\")\n\t\t\t\t\t"
		   });		
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";				
		addAnnotation
		  (nameEDataType, 
		   source, 
		   new String[] {
			 "name", "Name"
		   });		
		addAnnotation
		  (personEClass, 
		   source, 
		   new String[] {
			 "name", "Person",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getPerson_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (getPerson_Numbers(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "intArray"
		   });			
		addAnnotation
		  (getPerson_Double(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "intArray"
		   });				
		addAnnotation
		  (intArrayEDataType, 
		   source, 
		   new String[] {
			 "name", "IntArray"
		   });			
		addAnnotation
		  (addressEClass, 
		   source, 
		   new String[] {
			 "name", "Person",
			 "kind", "elementOnly"
		   });		
		addAnnotation
		  (getAddress_AddressInfo(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (myDoubleTypeEDataType, 
		   source, 
		   new String[] {
			 "name", "IntArray"
		   });					
		addAnnotation
		  (getCertificate_Name(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });		
		addAnnotation
		  (getCertificate_Length(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "name"
		   });
	}

} //UsertypePackageImpl
