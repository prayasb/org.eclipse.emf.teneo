/**
 * <copyright>
 * </copyright>
 *
 * $Id: UniqueconstraintsXMLProcessor.java,v 1.2 2007/02/08 23:09:21 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.uniqueconstraints.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.eclipse.emf.teneo.samples.emf.annotations.uniqueconstraints.UniqueconstraintsPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class UniqueconstraintsXMLProcessor extends XMLProcessor {
	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UniqueconstraintsXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		UniqueconstraintsPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the UniqueconstraintsResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected Map<String, Resource.Factory> getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new UniqueconstraintsResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new UniqueconstraintsResourceFactoryImpl());
		}
		return registrations;
	}

} //UniqueconstraintsXMLProcessor
