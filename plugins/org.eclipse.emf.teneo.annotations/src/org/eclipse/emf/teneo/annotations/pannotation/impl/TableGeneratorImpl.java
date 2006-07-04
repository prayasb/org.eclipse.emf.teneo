/**
 * <copyright>
 * </copyright>
 *
 * $Id: TableGeneratorImpl.java,v 1.2 2006/07/04 21:56:29 mtaal Exp $
 */
package org.eclipse.emf.teneo.annotations.pannotation.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EModelElement;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.emf.teneo.annotations.pannotation.PannotationPackage;
import org.eclipse.emf.teneo.annotations.pannotation.TableGenerator;
import org.eclipse.emf.teneo.annotations.pannotation.UniqueConstraint;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Table Generator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getEModelElement <em>EModel Element</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getTable <em>Table</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getCatalog <em>Catalog</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getPkColumnName <em>Pk Column Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getValueColumnName <em>Value Column Name</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getPkColumnValue <em>Pk Column Value</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getInitialValue <em>Initial Value</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getAllocationSize <em>Allocation Size</em>}</li>
 *   <li>{@link org.eclipse.emf.teneo.annotations.pannotation.impl.TableGeneratorImpl#getUniqueConstraints <em>Unique Constraints</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TableGeneratorImpl extends EObjectImpl implements TableGenerator {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2005, 2006 Springsite BV (The Netherlands) and others.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public\nLicense v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\n\nContributors:\n   Martin Taal\n   Davide Marchignoli\n";

	/**
	 * The cached value of the '{@link #getEModelElement() <em>EModel Element</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEModelElement()
	 * @generated
	 * @ordered
	 */
	protected EModelElement eModelElement = null;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getTable() <em>Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected static final String TABLE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTable() <em>Table</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTable()
	 * @generated
	 * @ordered
	 */
	protected String table = TABLE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCatalog() <em>Catalog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalog()
	 * @generated
	 * @ordered
	 */
	protected static final String CATALOG_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCatalog() <em>Catalog</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCatalog()
	 * @generated
	 * @ordered
	 */
	protected String catalog = CATALOG_EDEFAULT;

	/**
	 * The default value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected static final String SCHEMA_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSchema() <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSchema()
	 * @generated
	 * @ordered
	 */
	protected String schema = SCHEMA_EDEFAULT;

	/**
	 * The default value of the '{@link #getPkColumnName() <em>Pk Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String PK_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPkColumnName() <em>Pk Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkColumnName()
	 * @generated
	 * @ordered
	 */
	protected String pkColumnName = PK_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueColumnName() <em>Value Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueColumnName()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_COLUMN_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueColumnName() <em>Value Column Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueColumnName()
	 * @generated
	 * @ordered
	 */
	protected String valueColumnName = VALUE_COLUMN_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getPkColumnValue() <em>Pk Column Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkColumnValue()
	 * @generated
	 * @ordered
	 */
	protected static final String PK_COLUMN_VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPkColumnValue() <em>Pk Column Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPkColumnValue()
	 * @generated
	 * @ordered
	 */
	protected String pkColumnValue = PK_COLUMN_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected static final int INITIAL_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getInitialValue() <em>Initial Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialValue()
	 * @generated
	 * @ordered
	 */
	protected int initialValue = INITIAL_VALUE_EDEFAULT;

	/**
	 * This is true if the Initial Value attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean initialValueESet = false;

	/**
	 * The default value of the '{@link #getAllocationSize() <em>Allocation Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationSize()
	 * @generated
	 * @ordered
	 */
	protected static final int ALLOCATION_SIZE_EDEFAULT = 50;

	/**
	 * The cached value of the '{@link #getAllocationSize() <em>Allocation Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAllocationSize()
	 * @generated
	 * @ordered
	 */
	protected int allocationSize = ALLOCATION_SIZE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getUniqueConstraints() <em>Unique Constraints</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUniqueConstraints()
	 * @generated
	 * @ordered
	 */
	protected EList uniqueConstraints = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TableGeneratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return PannotationPackage.eINSTANCE.getTableGenerator();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EModelElement getEModelElement() {
		if (eModelElement != null && eModelElement.eIsProxy()) {
			EModelElement oldEModelElement = eModelElement;
			eModelElement = (EModelElement)eResolveProxy((InternalEObject)eModelElement);
			if (eModelElement != oldEModelElement) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT, oldEModelElement, eModelElement));
			}
		}
		return eModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EModelElement basicGetEModelElement() {
		return eModelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEModelElement(EModelElement newEModelElement) {
		EModelElement oldEModelElement = eModelElement;
		eModelElement = newEModelElement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT, oldEModelElement, eModelElement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getAllocationSize() {
		return allocationSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAllocationSize(int newAllocationSize) {
		int oldAllocationSize = allocationSize;
		allocationSize = newAllocationSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__ALLOCATION_SIZE, oldAllocationSize, allocationSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTable() {
		return table;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTable(String newTable) {
		String oldTable = table;
		table = newTable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__TABLE, oldTable, table));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getCatalog() {
		return catalog;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCatalog(String newCatalog) {
		String oldCatalog = catalog;
		catalog = newCatalog;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__CATALOG, oldCatalog, catalog));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSchema() {
		return schema;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSchema(String newSchema) {
		String oldSchema = schema;
		schema = newSchema;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__SCHEMA, oldSchema, schema));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPkColumnName() {
		return pkColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkColumnName(String newPkColumnName) {
		String oldPkColumnName = pkColumnName;
		pkColumnName = newPkColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__PK_COLUMN_NAME, oldPkColumnName, pkColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValueColumnName() {
		return valueColumnName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValueColumnName(String newValueColumnName) {
		String oldValueColumnName = valueColumnName;
		valueColumnName = newValueColumnName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__VALUE_COLUMN_NAME, oldValueColumnName, valueColumnName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getInitialValue() {
		return initialValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialValue(int newInitialValue) {
		int oldInitialValue = initialValue;
		initialValue = newInitialValue;
		boolean oldInitialValueESet = initialValueESet;
		initialValueESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE, oldInitialValue, initialValue, !oldInitialValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetInitialValue() {
		int oldInitialValue = initialValue;
		boolean oldInitialValueESet = initialValueESet;
		initialValue = INITIAL_VALUE_EDEFAULT;
		initialValueESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE, oldInitialValue, INITIAL_VALUE_EDEFAULT, oldInitialValueESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetInitialValue() {
		return initialValueESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getPkColumnValue() {
		return pkColumnValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPkColumnValue(String newPkColumnValue) {
		String oldPkColumnValue = pkColumnValue;
		pkColumnValue = newPkColumnValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, PannotationPackage.TABLE_GENERATOR__PK_COLUMN_VALUE, oldPkColumnValue, pkColumnValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getUniqueConstraints() {
		if (uniqueConstraints == null) {
			uniqueConstraints = new EObjectContainmentEList(UniqueConstraint.class, this, PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS);
		}
		return uniqueConstraints;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs) {
		if (featureID >= 0) {
			switch (eDerivedStructuralFeatureID(featureID, baseClass)) {
				case PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS:
					return ((InternalEList)getUniqueConstraints()).basicRemove(otherEnd, msgs);
				default:
					return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
			}
		}
		return eBasicSetContainer(null, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(EStructuralFeature eFeature, boolean resolve) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT:
				if (resolve) return getEModelElement();
				return basicGetEModelElement();
			case PannotationPackage.TABLE_GENERATOR__NAME:
				return getName();
			case PannotationPackage.TABLE_GENERATOR__TABLE:
				return getTable();
			case PannotationPackage.TABLE_GENERATOR__CATALOG:
				return getCatalog();
			case PannotationPackage.TABLE_GENERATOR__SCHEMA:
				return getSchema();
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_NAME:
				return getPkColumnName();
			case PannotationPackage.TABLE_GENERATOR__VALUE_COLUMN_NAME:
				return getValueColumnName();
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_VALUE:
				return getPkColumnValue();
			case PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE:
				return new Integer(getInitialValue());
			case PannotationPackage.TABLE_GENERATOR__ALLOCATION_SIZE:
				return new Integer(getAllocationSize());
			case PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS:
				return getUniqueConstraints();
		}
		return eDynamicGet(eFeature, resolve);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(EStructuralFeature eFeature, Object newValue) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT:
				setEModelElement((EModelElement)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__NAME:
				setName((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__TABLE:
				setTable((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__CATALOG:
				setCatalog((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__SCHEMA:
				setSchema((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_NAME:
				setPkColumnName((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__VALUE_COLUMN_NAME:
				setValueColumnName((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_VALUE:
				setPkColumnValue((String)newValue);
				return;
			case PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE:
				setInitialValue(((Integer)newValue).intValue());
				return;
			case PannotationPackage.TABLE_GENERATOR__ALLOCATION_SIZE:
				setAllocationSize(((Integer)newValue).intValue());
				return;
			case PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				getUniqueConstraints().addAll((Collection)newValue);
				return;
		}
		eDynamicSet(eFeature, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT:
				setEModelElement((EModelElement)null);
				return;
			case PannotationPackage.TABLE_GENERATOR__NAME:
				setName(NAME_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__TABLE:
				setTable(TABLE_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__CATALOG:
				setCatalog(CATALOG_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__SCHEMA:
				setSchema(SCHEMA_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_NAME:
				setPkColumnName(PK_COLUMN_NAME_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__VALUE_COLUMN_NAME:
				setValueColumnName(VALUE_COLUMN_NAME_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_VALUE:
				setPkColumnValue(PK_COLUMN_VALUE_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE:
				unsetInitialValue();
				return;
			case PannotationPackage.TABLE_GENERATOR__ALLOCATION_SIZE:
				setAllocationSize(ALLOCATION_SIZE_EDEFAULT);
				return;
			case PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS:
				getUniqueConstraints().clear();
				return;
		}
		eDynamicUnset(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
			case PannotationPackage.TABLE_GENERATOR__EMODEL_ELEMENT:
				return eModelElement != null;
			case PannotationPackage.TABLE_GENERATOR__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case PannotationPackage.TABLE_GENERATOR__TABLE:
				return TABLE_EDEFAULT == null ? table != null : !TABLE_EDEFAULT.equals(table);
			case PannotationPackage.TABLE_GENERATOR__CATALOG:
				return CATALOG_EDEFAULT == null ? catalog != null : !CATALOG_EDEFAULT.equals(catalog);
			case PannotationPackage.TABLE_GENERATOR__SCHEMA:
				return SCHEMA_EDEFAULT == null ? schema != null : !SCHEMA_EDEFAULT.equals(schema);
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_NAME:
				return PK_COLUMN_NAME_EDEFAULT == null ? pkColumnName != null : !PK_COLUMN_NAME_EDEFAULT.equals(pkColumnName);
			case PannotationPackage.TABLE_GENERATOR__VALUE_COLUMN_NAME:
				return VALUE_COLUMN_NAME_EDEFAULT == null ? valueColumnName != null : !VALUE_COLUMN_NAME_EDEFAULT.equals(valueColumnName);
			case PannotationPackage.TABLE_GENERATOR__PK_COLUMN_VALUE:
				return PK_COLUMN_VALUE_EDEFAULT == null ? pkColumnValue != null : !PK_COLUMN_VALUE_EDEFAULT.equals(pkColumnValue);
			case PannotationPackage.TABLE_GENERATOR__INITIAL_VALUE:
				return isSetInitialValue();
			case PannotationPackage.TABLE_GENERATOR__ALLOCATION_SIZE:
				return allocationSize != ALLOCATION_SIZE_EDEFAULT;
			case PannotationPackage.TABLE_GENERATOR__UNIQUE_CONSTRAINTS:
				return uniqueConstraints != null && !uniqueConstraints.isEmpty();
		}
		return eDynamicIsSet(eFeature);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", table: ");
		result.append(table);
		result.append(", catalog: ");
		result.append(catalog);
		result.append(", schema: ");
		result.append(schema);
		result.append(", pkColumnName: ");
		result.append(pkColumnName);
		result.append(", valueColumnName: ");
		result.append(valueColumnName);
		result.append(", pkColumnValue: ");
		result.append(pkColumnValue);
		result.append(", initialValue: ");
		if (initialValueESet) result.append(initialValue); else result.append("<unset>");
		result.append(", allocationSize: ");
		result.append(allocationSize);
		result.append(')');
		return result.toString();
	}

} //TableGeneratorImpl
