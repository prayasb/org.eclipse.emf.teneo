/**
 * <copyright>
 * </copyright>
 *
 * $Id: IdPackageImpl.java,v 1.7 2008/07/12 13:09:07 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.id.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.eclipse.emf.ecore.xml.type.XMLTypePackage;
import org.eclipse.emf.teneo.samples.emf.annotations.id.AutoID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.IdFactory;
import org.eclipse.emf.teneo.samples.emf.annotations.id.IdPackage;
import org.eclipse.emf.teneo.samples.emf.annotations.id.IdentityID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.OtherTableGeneratorID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.SequenceID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.SequenceStyleID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.SimpleID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.TableGeneratorID;
import org.eclipse.emf.teneo.samples.emf.annotations.id.TableID;

/**
 * <!-- begin-user-doc --> An implementation of the model <b>Package</b>. <!-- end-user-doc -->
 * @generated
 */
public class IdPackageImpl extends EPackageImpl implements IdPackage {
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass identityIDEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass simpleIDEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableIDEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tableGeneratorIDEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass autoIDEClass = null;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherTableGeneratorIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceIDEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sequenceStyleIDEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.id.IdPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private IdPackageImpl() {
		super(eNS_URI, IdFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link IdPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static IdPackage init() {
		if (isInited) return (IdPackage)EPackage.Registry.INSTANCE.getEPackage(IdPackage.eNS_URI);

		// Obtain or create and register package
		IdPackageImpl theIdPackage = (IdPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof IdPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new IdPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		XMLTypePackage.eINSTANCE.eClass();

		// Create package meta-data objects
		theIdPackage.createPackageContents();

		// Initialize created meta-data
		theIdPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theIdPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(IdPackage.eNS_URI, theIdPackage);
		return theIdPackage;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIdentityID() {
		return identityIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getIdentityID_Myid() {
		return (EAttribute)identityIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSimpleID() {
		return simpleIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSimpleID_AutoID() {
		return (EAttribute)simpleIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableID() {
		return tableIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableID_Myid() {
		return (EAttribute)tableIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTableGeneratorID() {
		return tableGeneratorIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTableGeneratorID_Myid() {
		return (EAttribute)tableGeneratorIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAutoID() {
		return autoIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutoID_AutoID() {
		return (EAttribute)autoIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAutoID_Name() {
		return (EAttribute)autoIDEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherTableGeneratorID() {
		return otherTableGeneratorIDEClass;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getOtherTableGeneratorID_Myid() {
		return (EAttribute)otherTableGeneratorIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceID() {
		return sequenceIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceID_Myid() {
		return (EAttribute)sequenceIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSequenceStyleID() {
		return sequenceStyleIDEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSequenceStyleID_Myid() {
		return (EAttribute)sequenceStyleIDEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public IdFactory getIdFactory() {
		return (IdFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		identityIDEClass = createEClass(IDENTITY_ID);
		createEAttribute(identityIDEClass, IDENTITY_ID__MYID);

		simpleIDEClass = createEClass(SIMPLE_ID);
		createEAttribute(simpleIDEClass, SIMPLE_ID__AUTO_ID);

		tableIDEClass = createEClass(TABLE_ID);
		createEAttribute(tableIDEClass, TABLE_ID__MYID);

		tableGeneratorIDEClass = createEClass(TABLE_GENERATOR_ID);
		createEAttribute(tableGeneratorIDEClass, TABLE_GENERATOR_ID__MYID);

		autoIDEClass = createEClass(AUTO_ID);
		createEAttribute(autoIDEClass, AUTO_ID__AUTO_ID);
		createEAttribute(autoIDEClass, AUTO_ID__NAME);

		otherTableGeneratorIDEClass = createEClass(OTHER_TABLE_GENERATOR_ID);
		createEAttribute(otherTableGeneratorIDEClass, OTHER_TABLE_GENERATOR_ID__MYID);

		sequenceIDEClass = createEClass(SEQUENCE_ID);
		createEAttribute(sequenceIDEClass, SEQUENCE_ID__MYID);

		sequenceStyleIDEClass = createEClass(SEQUENCE_STYLE_ID);
		createEAttribute(sequenceStyleIDEClass, SEQUENCE_STYLE_ID__MYID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		XMLTypePackage theXMLTypePackage = (XMLTypePackage)EPackage.Registry.INSTANCE.getEPackage(XMLTypePackage.eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(identityIDEClass, IdentityID.class, "IdentityID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getIdentityID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, IdentityID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(simpleIDEClass, SimpleID.class, "SimpleID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSimpleID_AutoID(), theXMLTypePackage.getLong(), "autoID", null, 1, 1, SimpleID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableIDEClass, TableID.class, "TableID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTableID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, TableID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tableGeneratorIDEClass, TableGeneratorID.class, "TableGeneratorID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTableGeneratorID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, TableGeneratorID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(autoIDEClass, AutoID.class, "AutoID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAutoID_AutoID(), theXMLTypePackage.getLong(), "autoID", null, 1, 1, AutoID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAutoID_Name(), theXMLTypePackage.getString(), "name", null, 0, 1, AutoID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherTableGeneratorIDEClass, OtherTableGeneratorID.class, "OtherTableGeneratorID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOtherTableGeneratorID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, OtherTableGeneratorID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceIDEClass, SequenceID.class, "SequenceID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequenceID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, SequenceID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sequenceStyleIDEClass, SequenceStyleID.class, "SequenceStyleID", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSequenceStyleID_Myid(), theXMLTypePackage.getLong(), "myid", null, 1, 1, SequenceStyleID.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// teneo.jpa
		createTeneoAnnotations();
		// http:///org/eclipse/emf/ecore/util/ExtendedMetaData
		createExtendedMetaDataAnnotations();
	}

	/**
	 * Initializes the annotations for <b>teneo.jpa</b>. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @generated
	 */
	protected void createTeneoAnnotations() {
		String source = "teneo.jpa";		
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "appinfo", "\t\t\t@SequenceStyleGenerator(name=\"StyleGENERATOR\" sequenceName=\"myOtherSequenceName\" optimizer=HILO initialValue=5 incrementSize=25)\n\t\t\t@SequenceStyleGenerator(name=\"StyleGENERATOR2\" sequenceName=\"myOtherSequenceName\" initialValue=5 incrementSize=25)\n\t\t\t@SequenceGenerator(name=\"GENERATOR\" sequenceName=\"mySequenceName\" initialValue=10 allocationSize=100)\n\t\t\t@SequenceGenerator(name=\"GENERATORTWO\" sequenceName=\"myOtherSequenceName\" initialValue=5 allocationSize=50)"
		   });			
		addAnnotation
		  (getIdentityID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=\"IDENTITY\")\n\t\t\t"
		   });				
		addAnnotation
		  (getSimpleID_AutoID(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue\n\t\t\t\t@Column(name=\"AUTOD\" nullable=\"false\")\n\t\t\t"
		   });				
		addAnnotation
		  (getTableID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=\"TABLE\")\n\t\t\t"
		   });				
		addAnnotation
		  (getTableGeneratorID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@TableGenerator(name=\"TGENERATOR\", table=\"TGEN\", initialValue=\"2\", valueColumnName=\"VAL_COL\")\n\t\t\t\t@GeneratedValue(strategy=TABLE, generator=\"TGENERATOR\")\n\t\t\t"
		   });				
		addAnnotation
		  (otherTableGeneratorIDEClass, 
		   source, 
		   new String[] {
			 "appinfo", "\t\t\t\t@TableGenerator(name=\"OTHERTGENERATOR\", table=\"OTHERTGEN\", initialValue=\"2\", valueColumnName=\"VAL_COL\")\n\t\t\t"
		   });		
		addAnnotation
		  (getOtherTableGeneratorID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=TABLE, generator=\"OTHERTGENERATOR\")\n\t\t\t"
		   });				
		addAnnotation
		  (getSequenceID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=\"SEQUENCE\" generator=\"GENERATOR\")\n\t\t\t"
		   });				
		addAnnotation
		  (getSequenceStyleID_Myid(), 
		   source, 
		   new String[] {
			 "appinfo", "\n\t\t\t\t@Id\n\t\t\t\t@GeneratedValue(strategy=\"SEQUENCESTYLE\" generator=\"StyleGENERATOR2\")\n\t\t\t"
		   });	
	}

	/**
	 * Initializes the annotations for <b>http:///org/eclipse/emf/ecore/util/ExtendedMetaData</b>.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected void createExtendedMetaDataAnnotations() {
		String source = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";			
		addAnnotation
		  (identityIDEClass, 
		   source, 
		   new String[] {
			 "name", "IdentityID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getIdentityID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });		
		addAnnotation
		  (simpleIDEClass, 
		   source, 
		   new String[] {
			 "name", "SimpleID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSimpleID_AutoID(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "autoID"
		   });		
		addAnnotation
		  (tableIDEClass, 
		   source, 
		   new String[] {
			 "name", "TableID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTableID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });		
		addAnnotation
		  (tableGeneratorIDEClass, 
		   source, 
		   new String[] {
			 "name", "TableID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getTableGeneratorID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });		
		addAnnotation
		  (otherTableGeneratorIDEClass, 
		   source, 
		   new String[] {
			 "name", "TableID",
			 "kind", "elementOnly"
		   });				
		addAnnotation
		  (getOtherTableGeneratorID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });		
		addAnnotation
		  (sequenceIDEClass, 
		   source, 
		   new String[] {
			 "name", "IdentityID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSequenceID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });		
		addAnnotation
		  (sequenceStyleIDEClass, 
		   source, 
		   new String[] {
			 "name", "IdentityID",
			 "kind", "elementOnly"
		   });			
		addAnnotation
		  (getSequenceStyleID_Myid(), 
		   source, 
		   new String[] {
			 "kind", "element",
			 "name", "myid"
		   });
	}

} // IdPackageImpl
