/**
 * <copyright>
 * </copyright>
 *
 * $Id: ExternalPackage.java,v 1.2 2011/02/27 20:10:43 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.external;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalFactory
 * @model kind="package"
 * @generated
 */
public interface ExternalPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "external";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipse.org/emf/teneo/samples/emf/annotations/external";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "external";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExternalPackage eINSTANCE = org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalTestImpl <em>Test</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalTestImpl
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalPackageImpl#getExternalTest()
	 * @generated
	 */
	int EXTERNAL_TEST = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__NAME = 0;

	/**
	 * The feature id for the '<em><b>EObject</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__EOBJECT = 1;

	/**
	 * The feature id for the '<em><b>EObjects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__EOBJECTS = 2;

	/**
	 * The feature id for the '<em><b>EClass</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__ECLASS = 3;

	/**
	 * The feature id for the '<em><b>External Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__EXTERNAL_OBJECT = 4;

	/**
	 * The feature id for the '<em><b>External Objects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST__EXTERNAL_OBJECTS = 5;

	/**
	 * The number of structural features of the '<em>Test</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_TEST_FEATURE_COUNT = 6;


	/**
	 * The meta object id for the '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalObjectImpl <em>Object</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalObjectImpl
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalPackageImpl#getExternalObject()
	 * @generated
	 */
	int EXTERNAL_OBJECT = 1;

	/**
	 * The number of structural features of the '<em>Object</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_OBJECT_FEATURE_COUNT = 0;


	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest <em>Test</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest
	 * @generated
	 */
	EClass getExternalTest();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getName()
	 * @see #getExternalTest()
	 * @generated
	 */
	EAttribute getExternalTest_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEObject <em>EObject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EObject</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEObject()
	 * @see #getExternalTest()
	 * @generated
	 */
	EReference getExternalTest_EObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEObjects <em>EObjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>EObjects</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEObjects()
	 * @see #getExternalTest()
	 * @generated
	 */
	EReference getExternalTest_EObjects();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEClass <em>EClass</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>EClass</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getEClass()
	 * @see #getExternalTest()
	 * @generated
	 */
	EReference getExternalTest_EClass();

	/**
	 * Returns the meta object for the reference '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getExternalObject <em>External Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>External Object</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getExternalObject()
	 * @see #getExternalTest()
	 * @generated
	 */
	EReference getExternalTest_ExternalObject();

	/**
	 * Returns the meta object for the reference list '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getExternalObjects <em>External Objects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>External Objects</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalTest#getExternalObjects()
	 * @see #getExternalTest()
	 * @generated
	 */
	EReference getExternalTest_ExternalObjects();

	/**
	 * Returns the meta object for class '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalObject <em>Object</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Object</em>'.
	 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.ExternalObject
	 * @generated
	 */
	EClass getExternalObject();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExternalFactory getExternalFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalTestImpl <em>Test</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalTestImpl
		 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalPackageImpl#getExternalTest()
		 * @generated
		 */
		EClass EXTERNAL_TEST = eINSTANCE.getExternalTest();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_TEST__NAME = eINSTANCE.getExternalTest_Name();

		/**
		 * The meta object literal for the '<em><b>EObject</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_TEST__EOBJECT = eINSTANCE.getExternalTest_EObject();

		/**
		 * The meta object literal for the '<em><b>EObjects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_TEST__EOBJECTS = eINSTANCE.getExternalTest_EObjects();

		/**
		 * The meta object literal for the '<em><b>EClass</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_TEST__ECLASS = eINSTANCE.getExternalTest_EClass();

		/**
		 * The meta object literal for the '<em><b>External Object</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_TEST__EXTERNAL_OBJECT = eINSTANCE.getExternalTest_ExternalObject();

		/**
		 * The meta object literal for the '<em><b>External Objects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXTERNAL_TEST__EXTERNAL_OBJECTS = eINSTANCE.getExternalTest_ExternalObjects();

		/**
		 * The meta object literal for the '{@link org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalObjectImpl <em>Object</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalObjectImpl
		 * @see org.eclipse.emf.teneo.samples.emf.annotations.external.impl.ExternalPackageImpl#getExternalObject()
		 * @generated
		 */
		EClass EXTERNAL_OBJECT = eINSTANCE.getExternalObject();

	}

} //ExternalPackage
