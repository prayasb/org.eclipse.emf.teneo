/**
 * <copyright>
 * </copyright>
 *
 * $Id: SequenceGenerator.java,v 1.2 2006/07/04 21:56:29 mtaal Exp $
 */
package org.eclipse.emf.teneo.annotations.pannotation;

/**
 * <!-- begin-user-doc --> A representation of the model object '<em><b>Sequence Generator</b></em>'. <!--
 * end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getSequenceName <em>Sequence Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getAllocationSize <em>Allocation Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage#getSequenceGenerator()
 * @model annotation="http://annotation.elver.org/internal/Target 0='EClass' 1='EStructuralFeature' 2='EPackage'"
 * @generated
 */
public interface SequenceGenerator extends PAnnotation{
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2005, 2006 Springsite BV (The Netherlands) and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public\nLicense v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n   Martin Taal\n   Davide Marchignoli\n";

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage#getSequenceGenerator_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' attribute.
	 * @see #setInitialValue(int)
	 * @see org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage#getSequenceGenerator_InitialValue()
	 * @model default="0"
	 * @generated
	 */
	int getInitialValue();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getInitialValue <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' attribute.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(int value);

	/**
	 * Returns the value of the '<em><b>Sequence Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sequence Name</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sequence Name</em>' attribute.
	 * @see #setSequenceName(String)
	 * @see org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage#getSequenceGenerator_SequenceName()
	 * @model
	 * @generated
	 */
	String getSequenceName();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getSequenceName <em>Sequence Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sequence Name</em>' attribute.
	 * @see #getSequenceName()
	 * @generated
	 */
	void setSequenceName(String value);

	/**
	 * Returns the value of the '<em><b>Allocation Size</b></em>' attribute.
	 * The default value is <code>"50"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Allocation Size</em>' attribute isn't clear, there really should be more of a
	 * description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Allocation Size</em>' attribute.
	 * @see #setAllocationSize(int)
	 * @see org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage#getSequenceGenerator_AllocationSize()
	 * @model default="50"
	 * @generated
	 */
	int getAllocationSize();

	/**
	 * Sets the value of the '{@link org.eclipse.emf.teneo.annotations.pannotation.SequenceGenerator#getAllocationSize <em>Allocation Size</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @param value the new value of the '<em>Allocation Size</em>' attribute.
	 * @see #getAllocationSize()
	 * @generated
	 */
	void setAllocationSize(int value);

} // SequenceGenerator
