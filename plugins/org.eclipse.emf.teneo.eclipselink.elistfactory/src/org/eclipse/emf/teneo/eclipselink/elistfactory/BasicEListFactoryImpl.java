/*******************************************************************************
 * Copyright (c) 2008 Oracle and Geensys.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Oracle and Geensys - initial API and implementation
 *******************************************************************************/
package org.eclipse.emf.teneo.eclipselink.elistfactory;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.BasicFeatureMap;
import org.eclipse.emf.ecore.util.BasicInternalEList;
import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.EcoreEMap;
import org.eclipse.emf.ecore.util.FeatureMap;

/**
 * An extensible EList factory implementation.  
 * <p>
 * There are overridable factory methods for all known types of
 * {@link org.eclipse.emf.common.util.EList <em><b>EList</b></em>}, 
 * {@link org.eclipse.emf.common.util.EMap <em><b>EMap</b></em>}, and 
 * {@link org.eclipse.emf.ecore.util.FeatureMap <em><b>FeatureMap</b></em>}. 
 * They create instances of the implementations as per the EMF framework by 
 * default but clients may provide their own implemetations depending to their 
 * needs (e.g. database persistence).
 * </p>
 * <p> 
 * There are also some overriding points which are used to provide the EList 
 * factory with generator model dependent settings (e.g. suppress containment, 
 * suppress notifiation, feature map wrapper class). They yield the generator 
 * model's default values but clients can return their own their own settings 
 * if required.  
 * </p>
*/
public class BasicEListFactoryImpl implements EListFactory {

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEList(java.lang.String, java.lang.String, java.lang.String)
   */
  public EList createEList(final String ePackageNsURI, final String eQualifiedOwnerClassName, final String eStructuralFeatureName) throws ClassNotFoundException {

    EObject eOwnerObject = createEOwnerObject(ePackageNsURI, eQualifiedOwnerClassName);
    return createEList(eOwnerObject, eStructuralFeatureName);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEList(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  public EList createEList(final EObject eOwnerObject, final String eStructuralFeatureName) throws ClassNotFoundException {

    EStructuralFeature eStructuralFeature = getEStructuralFeature(eOwnerObject, eStructuralFeatureName);
    return createEList(eOwnerObject, eStructuralFeature);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEList(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
   */
  public EList createEList(final EObject eOwnerObject, final EStructuralFeature eStructuralFeature) throws ClassNotFoundException {

    if (eOwnerObject == null) {
      String msg = "Argument for parameter 'eOwnerObject' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature == null) {
      String msg = "Argument for parameter 'eStructuralFeature' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature.isVolatile() || !EElementUtil.isListType(eStructuralFeature)) {
      String msg = "Argument for parameter 'eStructuralFeature' must be configured as non-volatile and many or has to be a non-volatile feature map entry type";
      throw new IllegalArgumentException(msg);
    }

    EList result = null;
    int derivedReferenceID = EElementUtil.getDerivedStructuralFeatureID(eOwnerObject, eStructuralFeature);
    if (EElementUtil.isMapType(eStructuralFeature)) {
      result = createEMap(eOwnerObject, eStructuralFeature);
    }
    else if (EElementUtil.isFeatureMapType(eStructuralFeature)) {
      result = createFeatureMap(eOwnerObject, eStructuralFeature);
    }
    else if (isSuppressNotification()) {
      String eQualifiedListItemTypeName = EElementUtil.getQualifiedListItemTypeName(eStructuralFeature);
      Class listItemClass = Class.forName(eQualifiedListItemTypeName);

      result = createBasicInternalEList(listItemClass);
    }
    else if (EElementUtil.isContainment(eStructuralFeature) && !isSuppressContainment(eStructuralFeature)) {
      String eQualifiedListItemTypeName = EElementUtil.getQualifiedListItemTypeName(eStructuralFeature);
      Class listItemClass = Class.forName(eQualifiedListItemTypeName);

      if (EElementUtil.isBidirectional(eStructuralFeature)) {
        EReference eReference = (EReference) eStructuralFeature;
        EReference eOppositeReference = eReference.getEOpposite();
        int derivedOppositeReferenceID = EElementUtil.getDerivedStructuralFeatureID(eOwnerObject, eOppositeReference);

        if (EElementUtil.isResolveProxies(eStructuralFeature, isContainmentProxies(eStructuralFeature))) {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectContainmentWithInverseEListUnsettableResolving(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
          }
          else {
            result = createEObjectContainmentWithInverseEListResolving(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
          }
        } // isResolveProxies()
        else {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectContainmentWithInverseEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
          }
          else {
            result = createEObjectContainmentWithInverseEList(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
          }
        }
      } // isBidirectional()
      else {
        if (EElementUtil.isResolveProxies(eStructuralFeature)) {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectContainmentEListUnsettableResolving(listItemClass, eOwnerObject, derivedReferenceID);
          }
          else {
            result = createEObjectContainmentEListResolving(listItemClass, eOwnerObject, derivedReferenceID);
          }
        } // isResolveProxies()
        else {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectContainmentEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID);
          }
          else {
            result = createEObjectContainmentEList(listItemClass, eOwnerObject, derivedReferenceID);
          }
        }
      }
    }
    else if (eStructuralFeature instanceof EReference) {
      String eQualifiedListItemTypeName = EElementUtil.getQualifiedListItemTypeName(eStructuralFeature);
      Class listItemClass = Class.forName(eQualifiedListItemTypeName);

      if (EElementUtil.isBidirectional(eStructuralFeature)) {
        EReference eReference = (EReference) eStructuralFeature;
        EReference eOppositeReference = eReference.getEOpposite();
        int derivedOppositeReferenceID = EElementUtil.getDerivedStructuralFeatureID(eOwnerObject, eOppositeReference);

        if (EElementUtil.isResolveProxies(eStructuralFeature)) {
          if (eStructuralFeature.isUnsettable()) {
            if (EElementUtil.isListType(eOppositeReference)) {
              result = createEObjectWithInverseResolvingEListUnsettableManyInverse(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
            else {
              result = createEObjectWithInverseResolvingEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
          }
          else {
            if (EElementUtil.isListType(eOppositeReference)) {
              result = createEObjectWithInverseResolvingEListManyInverse(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
            else {
              result = createEObjectWithInverseResolvingEList(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
          }
        } // isResolveProxies()
        else {
          if (eStructuralFeature.isUnsettable()) {
            if (EElementUtil.isListType(eOppositeReference)) {
              result = createEObjectWithInverseEListUnsettableManyInverse(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
            else {
              result = createEObjectWithInverseEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
          }
          else {
            if (EElementUtil.isListType(eOppositeReference)) {
              result = createEObjectWithInverseEListManyInverse(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
            else {
              result = createEObjectWithInverseEList(listItemClass, eOwnerObject, derivedReferenceID, derivedOppositeReferenceID);
            }
          }
        }
      } // isBidirectional()
      else {
        if (EElementUtil.isResolveProxies(eStructuralFeature)) {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectResolvingEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID);
          }
          else {
            result = createEObjectResolvingEList(listItemClass, eOwnerObject, derivedReferenceID);
          }
        } // isResolveProxies()
        else {
          if (eStructuralFeature.isUnsettable()) {
            result = createEObjectEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID);
          }
          else {
            result = createEObjectEList(listItemClass, eOwnerObject, derivedReferenceID);
          }
        }
      }
    }
    else if (eStructuralFeature instanceof EAttribute) {
      String eQualifiedListItemTypeName = EElementUtil.getQualifiedListItemTypeName(eStructuralFeature);
      Class listItemClass = Class.forName(eQualifiedListItemTypeName);

      if (eStructuralFeature.isUnique()) {
        if (eStructuralFeature.isUnsettable()) {
          result = createEDataTypeUniqueEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID);
        }
        else {
          result = createEDataTypeUniqueEList(listItemClass, eOwnerObject, derivedReferenceID);
        }
      } // isUnique()
      else {
        if (eStructuralFeature.isUnsettable()) {
          result = createEDataTypeEListUnsettable(listItemClass, eOwnerObject, derivedReferenceID);
        }
        else {
          result = createEDataTypeEList(listItemClass, eOwnerObject, derivedReferenceID);
        }
      }
    }

    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEMap(java.lang.String, java.lang.String, java.lang.String)
   */
  public EMap createEMap(final String ePackageNsURI, final String eQualifiedOwnerClassName, final String eStructuralFeatureName) throws ClassNotFoundException {

    EObject eOwnerObject = createEOwnerObject(ePackageNsURI, eQualifiedOwnerClassName);
    return createEMap(eOwnerObject, eStructuralFeatureName);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEMap(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  public EMap createEMap(final EObject eOwnerObject, final String eStructuralFeatureName) throws ClassNotFoundException {

    EStructuralFeature eStructuralFeature = getEStructuralFeature(eOwnerObject, eStructuralFeatureName);
    return createEMap(eOwnerObject, eStructuralFeature);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createEMap(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
   */
  public EMap createEMap(final EObject eOwnerObject, final EStructuralFeature eStructuralFeature) throws ClassNotFoundException {

    if (eOwnerObject == null) {
      String msg = "Argument for parameter 'eOwnerObject' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature == null) {
      String msg = "Argument for parameter 'eStructuralFeature' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature.isVolatile() || !EElementUtil.isMapType(eStructuralFeature)) {
      String msg = "Argument for parameter 'eStructuralFeature' must be configured as non-volatile and many and has to be a map entry type";
      throw new IllegalArgumentException(msg);
    }

    EPackage ePackage = eOwnerObject.eClass().getEPackage();
    String eMapEntryTypeName = eStructuralFeature.getEType().getName();
    EClass eMapEntryClass = EElementUtil.findEClass(ePackage, eMapEntryTypeName);

    String eQualifiedMapEntryTypeName = EElementUtil.getQualifiedClassName(eStructuralFeature.getEType());
    Class mapEntryClass = Class.forName(eQualifiedMapEntryTypeName);

    int derivedReferenceID = EElementUtil.getDerivedStructuralFeatureID(eOwnerObject, eStructuralFeature);

    EMap result;
    if (eStructuralFeature.isUnsettable()) {
      result = createEcoreEMapUnsettable(eMapEntryClass, mapEntryClass, eOwnerObject, derivedReferenceID);
    }
    else {
      result = createEcoreEMap(eMapEntryClass, mapEntryClass, eOwnerObject, derivedReferenceID);
    }
    return result;
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createFeatureMap(java.lang.String, java.lang.String, java.lang.String)
   */
  public FeatureMap createFeatureMap(final String ePackageNsURI, final String eQualifiedOwnerClassName, final String eStructuralFeatureName) throws ClassNotFoundException {

    EObject eOwnerObject = createEOwnerObject(ePackageNsURI, eQualifiedOwnerClassName);
    return createFeatureMap(eOwnerObject, eStructuralFeatureName);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createFeatureMap(org.eclipse.emf.ecore.EObject, java.lang.String)
   */
  public FeatureMap createFeatureMap(final EObject eOwnerObject, final String eStructuralFeatureName) throws ClassNotFoundException {

    EStructuralFeature eStructuralFeature = getEStructuralFeature(eOwnerObject, eStructuralFeatureName);
    return createFeatureMap(eOwnerObject, eStructuralFeature);
  }

  /* (non-Javadoc)
   * @see org.eclipse.emf.extras.elistfactory.EListFactory#createFeatureMap(org.eclipse.emf.ecore.EObject, org.eclipse.emf.ecore.EStructuralFeature)
   */
  public FeatureMap createFeatureMap(final EObject eOwnerObject, final EStructuralFeature eStructuralFeature) throws ClassNotFoundException {

    if (eOwnerObject == null) {
      String msg = "Argument for parameter 'eOwnerObject' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature == null) {
      String msg = "Argument for parameter 'eStructuralFeature' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if (eStructuralFeature.isVolatile() || !EElementUtil.isFeatureMapType(eStructuralFeature)) {
      String msg = "Argument for parameter 'eStructuralFeature' must be configured as non-volatile and has to be a feature map entry type";
      throw new IllegalArgumentException(msg);
    }

    int derivedReferenceID = EElementUtil.getDerivedStructuralFeatureID(eOwnerObject, eStructuralFeature);

    FeatureMap featureMap = createBasicFeatureMap(eOwnerObject, derivedReferenceID);
    return createWrappedFeatureMap(featureMap);
  }

  //
  // overriding points
  //

  protected boolean isContainmentProxies(final EStructuralFeature eStructuralFeature) {

    return false;
  }

  protected boolean isSuppressContainment(final EStructuralFeature eStructuralFeature) {

    return false;
  }

  protected boolean isSuppressNotification() {

    return false;
  }

  protected FeatureMap createWrappedFeatureMap(final FeatureMap featureMap) {

    return featureMap;
  }

  //
  // overridable factory methods
  //

  protected BasicInternalEList createBasicInternalEList(final Class listItemClass) {

    return new BasicInternalEList(listItemClass);
  }

  protected EObjectEList createEObjectEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectEList.Unsettable createEObjectEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectResolvingEList createEObjectResolvingEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectResolvingEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectResolvingEList.Unsettable createEObjectResolvingEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectResolvingEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectWithInverseEList createEObjectWithInverseEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseEList.Unsettable createEObjectWithInverseEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseEList.ManyInverse createEObjectWithInverseEListManyInverse(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseEList.ManyInverse(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseEList.Unsettable.ManyInverse createEObjectWithInverseEListUnsettableManyInverse(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseEList.Unsettable.ManyInverse(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseResolvingEList createEObjectWithInverseResolvingEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseResolvingEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseResolvingEList.Unsettable createEObjectWithInverseResolvingEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseResolvingEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseResolvingEList.ManyInverse createEObjectWithInverseResolvingEListManyInverse(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseResolvingEList.ManyInverse(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectWithInverseResolvingEList.Unsettable.ManyInverse createEObjectWithInverseResolvingEListUnsettableManyInverse(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectWithInverseResolvingEList.Unsettable.ManyInverse(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectContainmentEList createEObjectContainmentEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectContainmentEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectContainmentEList.Unsettable createEObjectContainmentEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {
    
    return new EObjectContainmentEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }
  
  protected EObjectContainmentEList.Resolving createEObjectContainmentEListResolving(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {

    return new EObjectContainmentEList.Resolving(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }

  protected EObjectContainmentEList.Unsettable.Resolving createEObjectContainmentEListUnsettableResolving(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID) {
    
    return new EObjectContainmentEList.Unsettable.Resolving(listItemClass, (InternalEObject) eOwnerObject, eReferenceID);
  }
  
  protected EObjectContainmentWithInverseEList createEObjectContainmentWithInverseEList(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectContainmentWithInverseEList(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectContainmentWithInverseEList.Unsettable createEObjectContainmentWithInverseEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {
    
    return new EObjectContainmentWithInverseEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }
  
  protected EObjectContainmentWithInverseEList.Resolving createEObjectContainmentWithInverseEListResolving(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectContainmentWithInverseEList.Resolving(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EObjectContainmentWithInverseEList.Unsettable.Resolving createEObjectContainmentWithInverseEListUnsettableResolving(final Class listItemClass, final EObject eOwnerObject, final int eReferenceID, final int eOppositeReferenceID) {

    return new EObjectContainmentWithInverseEList.Unsettable.Resolving(listItemClass, (InternalEObject) eOwnerObject, eReferenceID, eOppositeReferenceID);
  }

  protected EDataTypeEList createEDataTypeEList(final Class listItemClass, final EObject eOwnerObject, final int eAttributeID) {

    return new EDataTypeEList(listItemClass, (InternalEObject) eOwnerObject, eAttributeID);
  }

  protected EDataTypeEList.Unsettable createEDataTypeEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eAttributeID) {

    return new EDataTypeEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eAttributeID);
  }

  protected EDataTypeUniqueEList createEDataTypeUniqueEList(final Class listItemClass, final EObject eOwnerObject, final int eAttributeID) {

    return new EDataTypeUniqueEList(listItemClass, (InternalEObject) eOwnerObject, eAttributeID);
  }

  protected EDataTypeUniqueEList.Unsettable createEDataTypeUniqueEListUnsettable(final Class listItemClass, final EObject eOwnerObject, final int eAttributeID) {

    return new EDataTypeUniqueEList.Unsettable(listItemClass, (InternalEObject) eOwnerObject, eAttributeID);
  }

  protected EcoreEMap createEcoreEMap(final EClass eMapEntryClass, final Class mapEntryClass, final EObject eOwnerObject, final int eReferenceID) {
    
    return new EcoreEMap(eMapEntryClass, mapEntryClass, (InternalEObject) eOwnerObject, eReferenceID);
  }
  
  protected EcoreEMap.Unsettable createEcoreEMapUnsettable(final EClass eMapEntryClass, final Class mapEntryClass, final EObject eOwnerObject, final int eReferenceID) {
    
    return new EcoreEMap.Unsettable(eMapEntryClass, mapEntryClass, (InternalEObject) eOwnerObject, eReferenceID);
  }
  
  protected BasicFeatureMap createBasicFeatureMap(final EObject eOwnerObject, final int eReferenceID) {
    
    return new BasicFeatureMap((InternalEObject) eOwnerObject, eReferenceID);
  }
  
  //
  // helper methods
  //

  private EObject createEOwnerObject(final String ePackageNsURI, final String eQualifiedOwnerClassName) {

    EPackage ePackage = EElementUtil.findEPackage(ePackageNsURI);
    String eOwnerClassName = EElementUtil.getSimpleTypeName(eQualifiedOwnerClassName);
    EClass eOwnerClass = EElementUtil.findEClass(ePackage, eOwnerClassName);
    EFactory eFactory = ePackage.getEFactoryInstance();
    return eFactory.create(eOwnerClass);
  }

  private EStructuralFeature getEStructuralFeature(final EObject eOwnerObject, final String eStructuralFeatureName) {

    if (eOwnerObject == null) {
      String msg = "Argument for parameter 'eOwnerObject' must not be null.";
      throw new IllegalArgumentException(msg);
    }
    if ((eStructuralFeatureName == null) || (eStructuralFeatureName.trim().length() == 0)) {
      String msg = "Argument for parameter 'eStructuralFeatureName' must not be blank.";
      throw new IllegalArgumentException(msg);
    }

    EStructuralFeature eStructuralFeature = eOwnerObject.eClass().getEStructuralFeature(eStructuralFeatureName);
    if (eStructuralFeature == null) {
      String msg = "Could not find Ecore feature named '" + eStructuralFeatureName + "' on Ecore class '" + eOwnerObject.eClass().getName() + "'.";
      throw new IllegalStateException(msg);
    }
    return eStructuralFeature;
  }
}