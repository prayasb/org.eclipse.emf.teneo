/**
 * <copyright>
 * </copyright>
 *
 * $Id: MindmapXMLProcessor.java,v 1.1 2006/11/23 06:12:16 mtaal Exp $
 */
package org.example.mindmap.util;

import java.util.Map;

import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.xmi.util.XMLProcessor;

import org.example.mindmap.MindmapPackage;

/**
 * This class contains helper methods to serialize and deserialize XML documents
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class MindmapXMLProcessor extends XMLProcessor {
	/**
	 * Public constructor to instantiate the helper.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MindmapXMLProcessor() {
		super((EPackage.Registry.INSTANCE));
		MindmapPackage.eINSTANCE.eClass();
	}
	
	/**
	 * Register for "*" and "xml" file extensions the MindmapResourceFactoryImpl factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Map getRegistrations() {
		if (registrations == null) {
			super.getRegistrations();
			registrations.put(XML_EXTENSION, new MindmapResourceFactoryImpl());
			registrations.put(STAR_EXTENSION, new MindmapResourceFactoryImpl());
		}
		return registrations;
	}

} //MindmapXMLProcessor
