/**
 * <copyright>
 * </copyright>
 *
 * $Id: InheritancemappingFactory.java,v 1.4 2008/03/12 07:30:28 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.inheritancemapping;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipse.emf.teneo.samples.emf.annotations.inheritancemapping.InheritancemappingPackage
 * @generated
 */
public interface InheritancemappingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	InheritancemappingFactory eINSTANCE = org.eclipse.emf.teneo.samples.emf.annotations.inheritancemapping.impl.InheritancemappingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Content List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Content List</em>'.
	 * @generated
	 */
	ContentList createContentList();

	/**
	 * Returns a new object of class '<em>District UK Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>District UK Address</em>'.
	 * @generated
	 */
	DistrictUKAddress createDistrictUKAddress();

	/**
	 * Returns a new object of class '<em>International Price</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>International Price</em>'.
	 * @generated
	 */
	InternationalPrice createInternationalPrice();

	/**
	 * Returns a new object of class '<em>Price</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Price</em>'.
	 * @generated
	 */
	Price createPrice();

	/**
	 * Returns a new object of class '<em>UK Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UK Address</em>'.
	 * @generated
	 */
	UKAddress createUKAddress();

	/**
	 * Returns a new object of class '<em>US Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>US Address</em>'.
	 * @generated
	 */
	USAddress createUSAddress();

	/**
	 * Returns a new object of class '<em>Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Customer</em>'.
	 * @generated
	 */
	Customer createCustomer();

	/**
	 * Returns a new object of class '<em>Specific Customer</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Specific Customer</em>'.
	 * @generated
	 */
	SpecificCustomer createSpecificCustomer();

	/**
	 * Returns a new object of class '<em>UK Address List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>UK Address List</em>'.
	 * @generated
	 */
	UKAddressList createUKAddressList();

	/**
	 * Returns a new object of class '<em>Parent One</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parent One</em>'.
	 * @generated
	 */
	ParentOne createParentOne();

	/**
	 * Returns a new object of class '<em>Parent Two</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parent Two</em>'.
	 * @generated
	 */
	ParentTwo createParentTwo();

	/**
	 * Returns a new object of class '<em>Child One</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Child One</em>'.
	 * @generated
	 */
	ChildOne createChildOne();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	InheritancemappingPackage getInheritancemappingPackage();

} //InheritancemappingFactory
