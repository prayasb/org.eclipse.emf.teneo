/**
 * <copyright>
 * </copyright>
 *
 * $Id: ManyToManyItemProvider.java,v 1.1 2010/08/18 09:29:33 cbouhier Exp $
 */
package org.eclipse.emf.teneo.db2m.hbm30.provider;


import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.ResourceLocator;

import org.eclipse.emf.ecore.EStructuralFeature;

import org.eclipse.emf.ecore.util.FeatureMapUtil;

import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.eclipse.emf.edit.provider.ItemPropertyDescriptor;
import org.eclipse.emf.edit.provider.ItemProviderAdapter;
import org.eclipse.emf.edit.provider.ViewerNotification;

import org.eclipse.emf.teneo.db2m.hbm30.Hbm30Factory;
import org.eclipse.emf.teneo.db2m.hbm30.Hbm30Package;
import org.eclipse.emf.teneo.db2m.hbm30.ManyToMany;

/**
 * This is the item provider adapter for a {@link org.eclipse.emf.teneo.db2m.hbm30.ManyToMany} object.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ManyToManyItemProvider
	extends ItemProviderAdapter
	implements
		IEditingDomainItemProvider,
		IStructuredItemContentProvider,
		ITreeItemContentProvider,
		IItemLabelProvider,
		IItemPropertySource {
	/**
	 * This constructs an instance from a factory and a notifier.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ManyToManyItemProvider(AdapterFactory adapterFactory) {
		super(adapterFactory);
	}

	/**
	 * This returns the property descriptors for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List<IItemPropertyDescriptor> getPropertyDescriptors(Object object) {
		if (itemPropertyDescriptors == null) {
			super.getPropertyDescriptors(object);

			addFormulaPropertyDescriptor(object);
			addClassPropertyDescriptor(object);
			addColumn1PropertyDescriptor(object);
			addEmbedXmlPropertyDescriptor(object);
			addEntityNamePropertyDescriptor(object);
			addFetchPropertyDescriptor(object);
			addForeignKeyPropertyDescriptor(object);
			addFormula1PropertyDescriptor(object);
			addLazyPropertyDescriptor(object);
			addNodePropertyDescriptor(object);
			addNotFoundPropertyDescriptor(object);
			addOuterJoinPropertyDescriptor(object);
			addPropertyRefPropertyDescriptor(object);
			addUniquePropertyDescriptor(object);
			addWherePropertyDescriptor(object);
		}
		return itemPropertyDescriptors;
	}

	/**
	 * This adds a property descriptor for the Formula feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFormulaPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_formula_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_formula_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Formula(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Class feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addClassPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_class_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_class_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Class(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Column1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addColumn1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_column1_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_column1_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Column1(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Embed Xml feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEmbedXmlPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_embedXml_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_embedXml_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_EmbedXml(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Entity Name feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addEntityNamePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_entityName_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_entityName_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_EntityName(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Fetch feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFetchPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_fetch_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_fetch_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Fetch(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Foreign Key feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addForeignKeyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_foreignKey_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_foreignKey_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_ForeignKey(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Formula1 feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addFormula1PropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_formula1_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_formula1_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Formula1(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Lazy feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addLazyPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_lazy_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_lazy_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Lazy(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Node feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNodePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_node_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_node_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Node(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Not Found feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addNotFoundPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_notFound_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_notFound_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_NotFound(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Outer Join feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addOuterJoinPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_outerJoin_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_outerJoin_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_OuterJoin(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Property Ref feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addPropertyRefPropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_propertyRef_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_propertyRef_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_PropertyRef(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Unique feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addUniquePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_unique_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_unique_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Unique(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.BOOLEAN_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This adds a property descriptor for the Where feature.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void addWherePropertyDescriptor(Object object) {
		itemPropertyDescriptors.add
			(createItemPropertyDescriptor
				(((ComposeableAdapterFactory)adapterFactory).getRootAdapterFactory(),
				 getResourceLocator(),
				 getString("_UI_ManyToMany_where_feature"),
				 getString("_UI_PropertyDescriptor_description", "_UI_ManyToMany_where_feature", "_UI_ManyToMany_type"),
				 Hbm30Package.eINSTANCE.getManyToMany_Where(),
				 true,
				 false,
				 false,
				 ItemPropertyDescriptor.GENERIC_VALUE_IMAGE,
				 null,
				 null));
	}

	/**
	 * This specifies how to implement {@link #getChildren} and is used to deduce an appropriate feature for an
	 * {@link org.eclipse.emf.edit.command.AddCommand}, {@link org.eclipse.emf.edit.command.RemoveCommand} or
	 * {@link org.eclipse.emf.edit.command.MoveCommand} in {@link #createCommand}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Collection<? extends EStructuralFeature> getChildrenFeatures(Object object) {
		if (childrenFeatures == null) {
			super.getChildrenFeatures(object);
			childrenFeatures.add(Hbm30Package.eINSTANCE.getManyToMany_Meta());
			childrenFeatures.add(Hbm30Package.eINSTANCE.getManyToMany_Group());
			childrenFeatures.add(Hbm30Package.eINSTANCE.getManyToMany_Filter());
		}
		return childrenFeatures;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EStructuralFeature getChildFeature(Object object, Object child) {
		// Check the type of the specified child object and return the proper feature to use for
		// adding (see {@link AddCommand}) it as a child.

		return super.getChildFeature(object, child);
	}

	/**
	 * This returns ManyToMany.gif.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object getImage(Object object) {
		return overlayImage(object, getResourceLocator().getImage("full/obj16/ManyToMany"));
	}

	/**
	 * This returns the label text for the adapted class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getText(Object object) {
		String label = ((ManyToMany)object).getEntityName();
		return label == null || label.length() == 0 ?
			getString("_UI_ManyToMany_type") :
			getString("_UI_ManyToMany_type") + " " + label;
	}

	/**
	 * This handles model notifications by calling {@link #updateChildren} to update any cached
	 * children and by creating a viewer notification, which it passes to {@link #fireNotifyChanged}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void notifyChanged(Notification notification) {
		updateChildren(notification);

		switch (notification.getFeatureID(ManyToMany.class)) {
			case Hbm30Package.MANY_TO_MANY__FORMULA:
			case Hbm30Package.MANY_TO_MANY__CLASS:
			case Hbm30Package.MANY_TO_MANY__COLUMN1:
			case Hbm30Package.MANY_TO_MANY__EMBED_XML:
			case Hbm30Package.MANY_TO_MANY__ENTITY_NAME:
			case Hbm30Package.MANY_TO_MANY__FETCH:
			case Hbm30Package.MANY_TO_MANY__FOREIGN_KEY:
			case Hbm30Package.MANY_TO_MANY__FORMULA1:
			case Hbm30Package.MANY_TO_MANY__LAZY:
			case Hbm30Package.MANY_TO_MANY__NODE:
			case Hbm30Package.MANY_TO_MANY__NOT_FOUND:
			case Hbm30Package.MANY_TO_MANY__OUTER_JOIN:
			case Hbm30Package.MANY_TO_MANY__PROPERTY_REF:
			case Hbm30Package.MANY_TO_MANY__UNIQUE:
			case Hbm30Package.MANY_TO_MANY__WHERE:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), false, true));
				return;
			case Hbm30Package.MANY_TO_MANY__META:
			case Hbm30Package.MANY_TO_MANY__GROUP:
			case Hbm30Package.MANY_TO_MANY__FILTER:
				fireNotifyChanged(new ViewerNotification(notification, notification.getNotifier(), true, false));
				return;
		}
		super.notifyChanged(notification);
	}

	/**
	 * This adds {@link org.eclipse.emf.edit.command.CommandParameter}s describing the children
	 * that can be created under this object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected void collectNewChildDescriptors(Collection<Object> newChildDescriptors, Object object) {
		super.collectNewChildDescriptors(newChildDescriptors, object);

		newChildDescriptors.add
			(createChildParameter
				(Hbm30Package.eINSTANCE.getManyToMany_Meta(),
				 Hbm30Factory.eINSTANCE.createMeta()));

		newChildDescriptors.add
			(createChildParameter
				(Hbm30Package.eINSTANCE.getManyToMany_Group(),
				 FeatureMapUtil.createEntry
					(Hbm30Package.eINSTANCE.getManyToMany_Column(),
					 Hbm30Factory.eINSTANCE.createColumn())));

		newChildDescriptors.add
			(createChildParameter
				(Hbm30Package.eINSTANCE.getManyToMany_Group(),
				 FeatureMapUtil.createEntry
					(Hbm30Package.eINSTANCE.getManyToMany_Formula(),
					 "")));

		newChildDescriptors.add
			(createChildParameter
				(Hbm30Package.eINSTANCE.getManyToMany_Filter(),
				 Hbm30Factory.eINSTANCE.createFilter()));
	}

	/**
	 * Return the resource locator for this item provider's resources.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		return Hbm30EditPlugin.INSTANCE;
	}

}
