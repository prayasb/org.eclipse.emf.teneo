/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal
 * </copyright>
 *
 * $Id: DefaultAnnotator.java,v 1.3 2006/07/23 19:38:45 mtaal Exp $
 */

package org.eclipse.emf.teneo.mapper;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.FeatureMapUtil;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEAttribute;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEClass;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEPackage;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEReference;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEStructuralFeature;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedModel;
import org.eclipse.emf.teneo.annotations.pannotation.Basic;
import org.eclipse.emf.teneo.annotations.pannotation.CascadeType;
import org.eclipse.emf.teneo.annotations.pannotation.DiscriminatorColumn;
import org.eclipse.emf.teneo.annotations.pannotation.DiscriminatorValue;
import org.eclipse.emf.teneo.annotations.pannotation.Entity;
import org.eclipse.emf.teneo.annotations.pannotation.EnumType;
import org.eclipse.emf.teneo.annotations.pannotation.Enumerated;
import org.eclipse.emf.teneo.annotations.pannotation.FetchType;
import org.eclipse.emf.teneo.annotations.pannotation.Id;
import org.eclipse.emf.teneo.annotations.pannotation.Inheritance;
import org.eclipse.emf.teneo.annotations.pannotation.InheritanceType;
import org.eclipse.emf.teneo.annotations.pannotation.JoinColumn;
import org.eclipse.emf.teneo.annotations.pannotation.JoinTable;
import org.eclipse.emf.teneo.annotations.pannotation.ManyToMany;
import org.eclipse.emf.teneo.annotations.pannotation.ManyToOne;
import org.eclipse.emf.teneo.annotations.pannotation.OneToMany;
import org.eclipse.emf.teneo.annotations.pannotation.OneToOne;
import org.eclipse.emf.teneo.annotations.pannotation.PannotationFactory;
import org.eclipse.emf.teneo.annotations.pannotation.PrimaryKeyJoinColumn;
import org.eclipse.emf.teneo.annotations.pannotation.SecondaryTable;
import org.eclipse.emf.teneo.annotations.pannotation.SecondaryTables;
import org.eclipse.emf.teneo.annotations.pannotation.Table;
import org.eclipse.emf.teneo.annotations.pannotation.Temporal;
import org.eclipse.emf.teneo.annotations.pannotation.TemporalType;
import org.eclipse.emf.teneo.annotations.pannotation.Transient;
import org.eclipse.emf.teneo.util.SQLCaseStrategy;
import org.eclipse.emf.teneo.util.StoreUtil;

/**
 * Adds default annotations to an existing pamodel. Default annotations are added on the basis of the emf type
 * information. It sets the default annotations according to the ejb3 spec.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.3 $
 */
public class DefaultAnnotator {

	/** The source of the annotations of extended metadata used by emf */
	private static final String ANNOTATION_SOURCE_METADATA = "http:///org/eclipse/emf/ecore/util/ExtendedMetaData";

	/** The annotation source used to read additional facets */
	private static final String FACET_SOURCE_LIST = "http://facet.elver.org/List";

	/** Unique facet name */
	private static final String FACET_UNIQUE = "unique";

	/** Index facet name */
	private static final String FACET_INDEX = "indexed";

	/** The logger */
	protected static final Log log = LogFactory.getLog(DefaultAnnotator.class);

	/** Inheritance Mapping, with convenience bools, these values are default */
	private InheritanceType optionDefaultInheritanceMapping = InheritanceType.SINGLE_TABLE_LITERAL;

	/** Add entity if not present or only handle entied eclasses */
	private boolean optionAddEntityAnnotation = true;

	/** Determines if always a join table is used for non-contained relations */
	private boolean optionJoinTableForNonContainedAssociations = false;

	/** Set orphan delete on containment */
	private boolean optionSetCascadeAllOnContainment = true;

	/** Force eager containment */
	private boolean optionFetchContainmentEagerly = false;

	/** Option maximum column length */
	private int optionMaximumSqlLength = -1;

	/** The sql naming strategy */
	private SQLCaseStrategy optionSQLCaseStrategy = null;

	/** The eclass qualify approach */
	private String optionQualifyEClass = null;

	/** Convenience link to pamodel factory */
	private PannotationFactory aFactory = PannotationFactory.eINSTANCE;

	/** The annotated model which is being processed */
	private PAnnotatedModel annotatedModel;

	/**
	 * The list of processed eclasses, is used to ensure that a superclass is done before a subclass
	 */
	private ArrayList processedAClasses = new ArrayList();

	// todo: enable this again
	// private HashMap entityNames;

	/**
	 * Adds default annotations to a pamodel, the method is synchronized because globals are set. Not necessary because
	 * this class should always be used single threaded but okay.
	 */
	public synchronized void map(PAnnotatedModel annotatedModel, PersistenceOptions po) {
		setLocalOptions(po);
		this.annotatedModel = annotatedModel;
		// computeEntityNames();
		for (Iterator it = annotatedModel.getPaEPackages().iterator(); it.hasNext();) {
			processPackage((PAnnotatedEPackage) it.next());
		}
	}

	/**
	 * compute name of each entity TODO: enable this again private void computeEntityNames() { entityNames = new
	 * HashMap(); for (Iterator pi = annotatedModel.getPaEPackages().iterator(); pi.hasNext(); ) { for (Iterator ci =
	 * ((PAnnotatedEPackage) pi.next()).getPaEClasses().iterator(); ci.hasNext();) { PAnnotatedEClass paClass =
	 * (PAnnotatedEClass) ci.next(); EClass aClass = paClass.getAnnotatedEClass(); if (paClass.getEntity() != null &&
	 * paClass.getEntity().getName() != null) { entityNames.put(aClass, paClass.getEntity().getName()); } else if
	 * (paClass.getEmbeddable() == null && paClass.getMappedSuperclass() == null) { entityNames.put(aClass,
	 * aClass.getName()); } } } }
	 */

	/** Sets the options in a number of members */
	private void setLocalOptions(PersistenceOptions po) {
		if (po.getInheritanceMapping() != null) {
			switch (InheritanceType.get(po.getInheritanceMapping()).getValue()) {
			case InheritanceType.JOINED:
				optionDefaultInheritanceMapping = InheritanceType.JOINED_LITERAL;
				log.debug("Option inheritance: joined");
				break;
			case InheritanceType.SINGLE_TABLE:
				optionDefaultInheritanceMapping = InheritanceType.SINGLE_TABLE_LITERAL;
				log.debug("Option inheritance: single");
				break;
			default:
				throw new IllegalArgumentException("Inheritance mapping option: " + po.getInheritanceMapping()
						+ " is not supported");
			}
		}
		log.debug("Option: Default inheritance setting: " + optionDefaultInheritanceMapping.getName());

		optionAddEntityAnnotation = po.isSetEntityAutomatically();
		log.debug("Option: Automatically adding entity annotation: " + optionAddEntityAnnotation);

		optionFetchContainmentEagerly = po.isFetchContainmentEagerly();
		log.debug("Option: Eagerly load all containment relations: " + optionFetchContainmentEagerly);

		optionSetCascadeAllOnContainment = po.isSetCascadeAllOnContainment();
		log.debug("Option set cascade all on containment: " + optionSetCascadeAllOnContainment);

		optionQualifyEClass = po.getQualifyEntityName();
		log.debug("Qualify EClass name option: " + optionQualifyEClass);

		optionMaximumSqlLength = po.getMaximumSqlNameLength();
		log.debug("Maximum column length: " + optionMaximumSqlLength);

		optionJoinTableForNonContainedAssociations = po.isJoinTableForNonContainedAssociations();
		log.debug("JoinTableForNonContainedAssociations " + po.isJoinTableForNonContainedAssociations());

		optionSQLCaseStrategy = po.getSQLCaseStrategy();
		log.debug("SQLCaseStrategy " + optionSQLCaseStrategy.getClass().getName());
	}

	/** Maps one epackage */
	protected void processPackage(PAnnotatedEPackage aPackage) {
		log.debug(">>>> Adding default annotations for EPackage " + aPackage.getAnnotatedElement().getName());

		for (Iterator it = aPackage.getPaEClasses().iterator(); it.hasNext();) {
			processClass((PAnnotatedEClass) it.next());
		}
	}

	/** Returns the annotated version of an EClass */
	protected void processClass(PAnnotatedEClass aClass) {
		log.debug(" Adding default annotations for EClass: " + aClass.getAnnotatedElement().getName());

		// do not process the document root
		if (aClass.getAnnotatedEClass().getName().compareTo("DocumentRoot") == 0) {
			return;
		}

		// check if already processed
		if (processedAClasses.contains(aClass))
			return;

		// first do the superclasses
		for (Iterator it = aClass.getAnnotatedEClass().getESuperTypes().iterator(); it.hasNext();) {
			PAnnotatedEClass superAClass = aClass.getPaModel().getPAnnotated((EClass) it.next());
			processClass(superAClass);
		}

		final EClass eclass = (EClass) aClass.getAnnotatedElement();

		final String transientSource = "http://ejb.elver.org/Transient";
		if (aClass.getAnnotatedEClass().getEAnnotation(transientSource) != null) {
			log.debug("EClass " + aClass.getAnnotatedEClass().getName() + " has transient annotation ");
			return;
		}

		if (!optionAddEntityAnnotation && aClass.getEntity() == null && aClass.getEmbeddable() == null
				&& aClass.getMappedSuperclass() == null) {
			log.debug("Entities are not added automatically and this eclass: " + aClass.getAnnotatedEClass().getName()
					+ " does not have an entity/embeddable/mappedsuperclass annotation.");
			// NOTE: should the aClass be removed from its pamodel?
			return;
		}

		processedAClasses.add(aClass);

		// TODO: should eclasses with interface=true be mapped, i.e. have entity specified?

		// add entity or set entity name
		if (aClass.getEntity() == null && aClass.getEmbeddable() == null && aClass.getMappedSuperclass() == null) {
			Entity entity = aFactory.createEntity();
			entity.setEModelElement(eclass);
			entity.setName(StoreUtil.getEClassURI(eclass, optionQualifyEClass));
			aClass.setEntity(entity);
		} else if (aClass.getEntity() != null && aClass.getEntity().getName() == null) {
			aClass.getEntity().setName(eclass.getName());
		}

		// get the inheritance from the supertype or use the global inheritance setting
		// Note only an 'entitied' root gets an inheritance annotation. This is according to the spec.
		final boolean isInheritanceRoot = isInheritanceRoot(aClass);
		final InheritanceType inheritanceType;
		if (aClass.getInheritance() != null) {
			inheritanceType = aClass.getInheritance().getStrategy();
		} else if (isInheritanceRoot) { // use default
			Inheritance inheritance = aFactory.createInheritance();
			inheritance.setStrategy(optionDefaultInheritanceMapping);
			inheritance.setEModelElement(eclass);
			aClass.setInheritance(inheritance);
			inheritanceType = optionDefaultInheritanceMapping;
		} else { // try to get from the root from the inheritance tree
			Inheritance inheritance = getInheritanceFromSupers(aClass);
			if (inheritance == null) { // not found use default
				inheritanceType = optionDefaultInheritanceMapping;
			} else {
				inheritanceType = inheritance.getStrategy();
			}
		}

		// add PrimaryKeyJoinColumn
		if (!isInheritanceRoot && inheritanceType.getValue() == InheritanceType.JOINED) {
			ArrayList idFeatures = new ArrayList();
			boolean firstDone = false;
			EClass superClass = null;
			for (Iterator it = aClass.getAnnotatedEClass().getESuperTypes().iterator(); it.hasNext();) {
				final EClass eSuperClass = (EClass) it.next();
				final PAnnotatedEClass aSuperClass = annotatedModel.getPAnnotated(eSuperClass);
				if (!firstDone) {
					superClass = eSuperClass;
				}
				idFeatures.addAll(getIDFeaturesNames(aSuperClass));
				if (!idFeatures.isEmpty())
					break;
			}

			for (Iterator it = idFeatures.iterator(); it.hasNext();) {
				final String idFeature = (String) it.next();
				final PrimaryKeyJoinColumn pkjc = aFactory.createPrimaryKeyJoinColumn();
				final String colName = superClass.getName() + "_" + idFeature;
				pkjc.setName(trunc(colName.toUpperCase(), true));
				if (aClass.getPrimaryKeyJoinColumns() == null)
					aClass.setPrimaryKeyJoinColumns(aFactory.createPrimaryKeyJoinColumns());
				aClass.getPrimaryKeyJoinColumns().getValue().add(pkjc);
			}
		}

		// add the table annotation or the name annotation of the table
		// only do this if this is the root in case of singletable or when this is the joined table strategy
		if (aClass.getTable() == null
				&& ((isInheritanceRoot && inheritanceType.equals(InheritanceType.SINGLE_TABLE_LITERAL) || inheritanceType
						.equals(InheritanceType.JOINED_LITERAL)))) {
			final Table table = aFactory.createTable();
			table.setEModelElement(eclass);
			table.setName(trunc(eclass.getName().toUpperCase(), false));
			aClass.setTable(table);
		} else if (aClass.getTable() != null && aClass.getTable().getName() == null) {
			aClass.getTable().setName(trunc(eclass.getName().toUpperCase(), false));
		}

		// if the strategy is all classes of one hierarchy in one table and this is not the superclass
		// then all properties should be nullable
		// TODO when not all eclasses are entities then this computation is incorrect, the isInheritanceRoot
		// should be the top most class in the hierarchy which is an entity
		final boolean forceOptional = !isInheritanceRoot
				&& inheritanceType.equals(InheritanceType.SINGLE_TABLE_LITERAL);

		// For hibernate as well as jpox the discriminator column is only required for
		// single table, the ejb3 spec does not make a clear statement about the requirement
		// to also have a discriminator column for joined
		if (isInheritanceRoot && aClass.getDiscriminatorColumn() == null
				&& inheritanceType.equals(InheritanceType.SINGLE_TABLE_LITERAL)) {
			// note defaults of primitive types are all defined in the model
			final DiscriminatorColumn dc = aFactory.createDiscriminatorColumn();
			dc.setEModelElement(eclass);
			aClass.setDiscriminatorColumn(dc);
		}

		// add a discriminator value
		if (aClass.getDiscriminatorValue() == null && inheritanceType.equals(InheritanceType.SINGLE_TABLE_LITERAL)) {
			final DiscriminatorValue dv = aFactory.createDiscriminatorValue();
			dv.setValue(eclass.getName());
			dv.setEModelElement(eclass);
			aClass.setDiscriminatorValue(dv);
		}

		for (Iterator it = aClass.getPaEStructuralFeatures().iterator(); it.hasNext();) {
			PAnnotatedEStructuralFeature aStructuralFeature = (PAnnotatedEStructuralFeature) it.next();
			processEFeature(aStructuralFeature, forceOptional);
		}

		final SecondaryTables secondaryTables = aClass.getSecondaryTables();
		if (secondaryTables != null) {
			// Add default PkJoinColumns for SecondaryTables.
			for (Iterator iter = secondaryTables.getValue().iterator(); iter.hasNext();) {
				final SecondaryTable secondaryTable = (SecondaryTable) iter.next();
				final EList pkJoinColumns = secondaryTable.getPkJoinColumns();
				if (pkJoinColumns.size() == 0) {
					// No PkJoinColumns configured for this secondary table, so populate with defaults based on the ID
					// attributes of the primary table.
					final List aIdAttributes = aClass.getPaIdAttributes();
					for (Iterator iter2 = aIdAttributes.iterator(); iter2.hasNext();) {
						PAnnotatedEAttribute aIdAttribute = (PAnnotatedEAttribute) iter2.next();
						final PrimaryKeyJoinColumn pkJoinColumn = PannotationFactory.eINSTANCE
								.createPrimaryKeyJoinColumn();
						pkJoinColumn
								.setName(trunc(aIdAttribute.getAnnotatedEAttribute().getName().toUpperCase(), true));
						pkJoinColumns.add(pkJoinColumn);
					}
				}
			}
		}
	}

	/** Process the features of the eclass */
	protected void processEFeature(PAnnotatedEStructuralFeature aStructuralFeature, boolean forceOptional) {
		EStructuralFeature eStructuralFeature = aStructuralFeature.getAnnotatedEStructuralFeature();

		boolean errorOccured = true;
		try {
			// a feature is transient if:
			// - transient is true and it is an eattribute or
			// - transient is true and it does not have an opposite
			// - transietn is true and it's opposite is not a containment relation
			final boolean isTransient = eStructuralFeature.isTransient()
					&& (eStructuralFeature instanceof EAttribute
							|| ((EReference) eStructuralFeature).getEOpposite() == null || !((EReference) eStructuralFeature)
							.getEOpposite().isContainment());

			if (aStructuralFeature.getTransient() == null && (eStructuralFeature.isVolatile() || isTransient)) {
				log.debug("Structural feature " + eStructuralFeature.getName()
						+ " is transient, therefore adding transient annotation");
				final Transient trans = aFactory.createTransient();
				trans.setEModelElement(eStructuralFeature);
				aStructuralFeature.setTransient(trans);
				// note next statement will force continue
			}

			// do not do anything further for transients
			// process transients further because they can be part of a featuremap, the specific mapper should
			// handle transient
			// Note that this means that transient features will still have additional annotations such as basic etc.
			// if (aStructuralFeature.getTransient() != null) return;

			// set the indexed and unique
			setFacets(aStructuralFeature);

			if (aStructuralFeature instanceof PAnnotatedEAttribute) {
				final PAnnotatedEAttribute aAttribute = (PAnnotatedEAttribute) aStructuralFeature;
				if (((PAnnotatedEAttribute) aStructuralFeature).getVersion() != null)
					return; // do not add more info

				final Class instanceClass = eStructuralFeature.getEType().getInstanceClass();
				boolean isMany = false;
				// instanceClass will be null for enums
				// Lob-annotated attributes must not be treated as one-to-many.
				// eattributes with a hibernate type annotations should not be treated as a list
				final String typeSource = "http://annotations.hibernate.org/Type";
				if (instanceClass != null && aAttribute.getLob() == null
						&& aAttribute.getAnnotatedEAttribute().getEAttributeType().getEAnnotation(typeSource) == null) {
					isMany = eStructuralFeature.isMany() || instanceClass.isArray()
							|| Collection.class.isAssignableFrom(instanceClass)
							|| Set.class.isAssignableFrom(instanceClass) || List.class.isAssignableFrom(instanceClass);
					isMany = isMany && !StoreUtil.isElementOfAGroup(eStructuralFeature);
				}

				if (isMany) {
					processOneToManyAttribute(aAttribute, forceOptional);
				} else {
					processSingleAttribute(aAttribute, forceOptional);
				}

				if (aAttribute.getColumn() != null && aAttribute.getColumn().getName() == null) {
					aAttribute.getColumn().setName(
							trunc(aAttribute.getAnnotatedEAttribute().getName().toUpperCase(), true));
				}

			} else if (aStructuralFeature instanceof PAnnotatedEReference) {

				final PAnnotatedEReference aReference = (PAnnotatedEReference) aStructuralFeature;

				// detect the type of relation
				// note using the emf model it can not be checked if a relation is a
				// uni-manytoone (2.1.8.3.2) or a uni onetoone (2.1.8.3.1)
				// neither can a uni-manytomany (2.1.8.5.2) be detected
				// because there is no eopposite. However this can be
				// specified manually, the system as a default will choose uni-manytoone

				final EReference eReference = (EReference) aStructuralFeature.getAnnotatedElement();
				final EReference eOpposite = eReference.getEOpposite();

				// elements of a group are never multi-occurence because the multi-occurence is
				// handled by the containing featuremap
				final boolean isMany = eReference.isMany() && !StoreUtil.isElementOfAGroup(eReference);
				final boolean isOppositeMany = eOpposite != null && eOpposite.isMany()
						&& !StoreUtil.isElementOfAGroup(eOpposite);

				final boolean mtmBidirectionalRelation = isMany && eOpposite != null && isOppositeMany;
				final boolean mtmUnidirectionalRelation = isMany && eOpposite == null
						&& aReference.getManyToMany() != null;
				final boolean otmBidirectionalRelation = isMany && eOpposite != null && !isOppositeMany;
				final boolean otmUnidirectionalRelation = isMany && eOpposite == null;

				// note as a default if the system has to choose between oto uni or mto uni then it will
				// place a mto
				final boolean otoBidirectionalRelation = !isMany && eOpposite != null && !isOppositeMany;
				final boolean otoUnidirectionalRelation = !isMany && eOpposite == null
						&& (aReference.getOneToOne() != null || aReference.getPrimaryKeyJoinColumn() != null);
				final boolean mtoBidirectionalRelation = !isMany && eOpposite != null && isOppositeMany;
				final boolean mtoUnidirectionalRelation = !isMany && eOpposite == null && !otoUnidirectionalRelation;

				if (mtmBidirectionalRelation) {
					processBidirectionalManyToManyReference(aReference, forceOptional);
				} else if (mtmUnidirectionalRelation) {
					processUnidirectionalManyToManyReference(aReference, forceOptional);
				} else if (otmBidirectionalRelation || otmUnidirectionalRelation) {
					processOneToManyReference(aReference, forceOptional);
				} else if (otoBidirectionalRelation || otoUnidirectionalRelation) {
					processOneToOneReference(aReference, forceOptional);
				} else if (mtoBidirectionalRelation) {
					processManyToOneReference(aReference, forceOptional);
				} else if (mtoUnidirectionalRelation) {
					processManyToOneReference(aReference, forceOptional);
				}

				// handle column naming at this level
				if (aReference.getColumn() != null && aReference.getColumn().getName() == null) {
					aReference.getColumn().setName(trunc(eReference.getName().toUpperCase(), true));
				}

			} else {
				throw new IllegalArgumentException("This type of StructuralFeature is not supported: "
						+ aStructuralFeature.getClass().getName());
			}
			errorOccured = false;
		} finally {

			// check that at least one ann was set
			if (aStructuralFeature instanceof PAnnotatedEAttribute) {
				PAnnotatedEAttribute pae = (PAnnotatedEAttribute) aStructuralFeature;
				assert (errorOccured || pae.getBasic() != null || pae.getVersion() != null || pae.getId() != null
						|| pae.getTransient() != null || pae.getOneToMany() != null);
			} else {
				PAnnotatedEReference par = (PAnnotatedEReference) aStructuralFeature;
				assert (errorOccured || par.getTransient() != null || par.getOneToMany() != null
						|| par.getManyToMany() != null || par.getManyToOne() != null || par.getOneToOne() != null);
			}

		}
	}

	/** Add default annotation to aAttribute: these are id, basic and enum */
	protected void processSingleAttribute(PAnnotatedEAttribute aAttribute, boolean forceNullable) {

		log.debug(" Adding default annotations for EAttribute " + aAttribute.getAnnotatedElement().getName());

		final EAttribute eAttribute = (EAttribute) aAttribute.getAnnotatedElement();

		// this is done before adding the id because an enumerated can also be an id
		if (eAttribute.getEType() instanceof EEnum && aAttribute.getEnumerated() == null) {
			final Enumerated enumerated = aFactory.createEnumerated();
			enumerated.setValue(EnumType.STRING_LITERAL);
			enumerated.setEModelElement(eAttribute);
			aAttribute.setEnumerated(enumerated);
		}

		if (eAttribute.isID() && aAttribute.getId() == null) {
			final Id id = aFactory.createId();
			id.setEModelElement(eAttribute);
			aAttribute.setId(id);
			return; // after id do not add basic
		} else if (aAttribute.getId() != null) {
			return; // after id do not do basic
		}

		if (aAttribute.getTemporal() == null) {
			Class clazz = eAttribute.getEAttributeType().getInstanceClass();
			// clazz is hidden somewhere
			if (clazz == null || Object.class.equals(clazz)) {
				ArrayList eclassifiers = getItemTypes((EDataType) eAttribute.getEType());
				for (Iterator it = eclassifiers.iterator(); it.hasNext();) {
					EClassifier eclassifier = (EClassifier) it.next();
					if (eclassifier.getInstanceClass() != null) {
						clazz = eclassifier.getInstanceClass();
						break;
					}
				}
			}

			if (clazz != null && Date.class.isAssignableFrom(clazz)) {
				final Temporal temporal = aFactory.createTemporal();
				temporal.setValue(TemporalType.DATE_LITERAL);
				aAttribute.setTemporal(temporal);
				temporal.setEModelElement(eAttribute);
			} else if (clazz != null && Calendar.class.isAssignableFrom(clazz)) {
				final Temporal temporal = aFactory.createTemporal();
				temporal.setValue(TemporalType.DATE_LITERAL);
				aAttribute.setTemporal(temporal);
				temporal.setEModelElement(eAttribute);
			}
		}

		if (aAttribute.getBasic() == null) {
			// primitive defaults are set in the model itself
			final Basic basic = aFactory.createBasic();
			basic.setEModelElement(eAttribute);

			// NOTE: the ejb3 spec says that for primitivie optional does not apply, this is
			// confusing why having this then? If this applies then for each basic and nullable
			// field a column annotation has to be added to force nullability
			basic.setOptional(forceNullable || !eAttribute.isRequired() || eAttribute.isUnsettable());
			aAttribute.setBasic(basic);
		}
		if (forceNullable) {
			aAttribute.getBasic().setOptional(true);
		}

		if (aAttribute.getId() != null) {
			aAttribute.getBasic().setOptional(false);
			if (aAttribute.getColumn() != null && aAttribute.getColumn().isNullable()) {
				log.warn("The column of a primary key property is null, this will often result in database errors!");
			}
		}
	}

	/** Handles a many EAttribute which is a list of simple types */
	protected void processOneToManyAttribute(PAnnotatedEAttribute aAttribute, boolean forceNullable) {
		final String logStr = aAttribute.getAnnotatedEAttribute().getName() + "/"
				+ aAttribute.getAnnotatedEAttribute().getEContainingClass().getName();

		log.debug("EAttribute " + logStr + " needs a onetomany");

		final EAttribute eAttribute = (EAttribute) aAttribute.getAnnotatedElement();
		OneToMany otm = aAttribute.getOneToMany();
		if (otm == null) {
			log.debug("One to many not present adding one");
			otm = aFactory.createOneToMany();
			aAttribute.setOneToMany(otm);
			otm.setEModelElement(eAttribute);

			if (optionFetchContainmentEagerly) {
				otm.setFetch(FetchType.EAGER_LITERAL);
			}
		} else {
			log.debug("One to many present adding default information if required");
		}

		// set cascade if not set
		if (otm.getCascade().isEmpty())
			otm.getCascade().add(CascadeType.ALL_LITERAL);

		if (otm.getTargetEntity() == null || otm.getTargetEntity() == null) {
			otm.setTargetEntity(getTargetTypeName(eAttribute));
		}

		if (aAttribute.getJoinTable() == null) {
			// note not optional because lists of simple types are embedded
			addJoinColumns(aAttribute.getPaEClass(), aAttribute.getAnnotatedEAttribute(), aAttribute, FeatureMapUtil
					.isFeatureMap(eAttribute)); // with featuremap optional is true
		}
	}

	/** Returns the type name of a many attribute */
	private String getTargetTypeName(EAttribute eAttribute) {
		// check on equality on object.class is used for listunion simpleunions
		final Class instanceClass = eAttribute.getEAttributeType().getInstanceClass();
		if (!Object.class.equals(instanceClass) && !List.class.equals(instanceClass)) {
			return eAttribute.getEAttributeType().getInstanceClassName();
		} else {
			// the type is hidden somewhere deep get it
			// the edatatype is the java.util.list
			// it has an itemType which is the name of the element edatatype
			// which contains the instanceclass
			// takes also into account inheritance between datatypes
			// NOTE the otm.targetentity can consist of a comma delimited list of target
			// entities this is required for listunion types but is not according to the ejb3 spec!
			ArrayList eclassifiers = getItemTypes((EDataType) eAttribute.getEType());
			if (eclassifiers.size() > 0) {
				StringBuffer result = new StringBuffer();
				for (int i = 0; i < eclassifiers.size(); i++) {
					final EClassifier eclassifier = (EClassifier) eclassifiers.get(i);
					if (i > 0)
						result.append(",");
					result.append(eclassifier.getInstanceClassName());
				}
				return result.toString();
			} else {
				return Object.class.getName();
			}
		}
	}

	/**
	 * Adds default annotations to a onetomany ereference, this method handles both the uni- and the bidirectional case
	 */
	protected void processOneToManyReference(PAnnotatedEReference aReference, boolean forceOptional) {
		final String logStr = aReference.getAnnotatedEReference().getName() + "/"
				+ aReference.getAnnotatedEReference().getEContainingClass().getName();

		if (aReference.getManyToMany() != null || aReference.getOneToOne() != null || aReference.getManyToOne() != null) {
			throw new StoreMappingException("The feature/eclass " + logStr + " should be a OneToMany but "
					+ "it already has a ManyToMany, OneToOne or ManyToOne annotation");
		}

		final EReference eReference = (EReference) aReference.getAnnotatedElement();
		OneToMany otm = aReference.getOneToMany();
		if (otm == null) {
			log.debug("EReference + " + logStr + " does not have a onetomany annotation, adding one");
			otm = aFactory.createOneToMany();
			aReference.setOneToMany(otm);
			otm.setEModelElement(eReference);

			if (eReference.isContainment() && optionFetchContainmentEagerly) {
				otm.setFetch(FetchType.EAGER_LITERAL);
			}
		} else {
			log.debug("EReference + " + logStr + " has onetomany, check if defaults should be set");
		}

		if (otm.getMappedBy() == null && eReference.getEOpposite() != null) {
			otm.setMappedBy(eReference.getEOpposite().getName());
		}
		setCascade(otm.getCascade(), eReference.isContainment());

		// NOTE Sometimes EMF generated getters/setters have a
		// very generic type (EObject), if the type can be derived here then this should
		// be added here
		if (otm.getTargetEntity() == null) {
			otm.setTargetEntity(StoreUtil.getEClassURI(eReference.getEReferenceType(), optionQualifyEClass));
		}

		// only use a jointable if the relation is non unique
		if (!aReference.getUnique().isValue() && aReference.getAnnotatedEReference().getEOpposite() != null) {
			log.warn("The EReference " + logStr
					+ " is not unique (allows duplicates) but it is bi-directional, this is not logical");
		}
		if ((optionJoinTableForNonContainedAssociations && !eReference.isContainment())
				|| !aReference.getUnique().isValue() || aReference.getIdBag() != null) {
			JoinTable joinTable = aReference.getJoinTable();
			if (joinTable == null) {
				joinTable = aFactory.createJoinTable();
				aReference.setJoinTable(joinTable);
			}
			joinTable.setEModelElement(eReference);

			// see remark in manytomany about naming of jointables
			if (joinTable.getName() == null) {
				final String jTableName = getEntityName(eReference.getEContainingClass(), aReference.getPaModel())
						+ "_" + getEntityName(eReference.getEReferenceType(), aReference.getPaModel());
				joinTable.setName(trunc(jTableName.toUpperCase().toUpperCase(), false));
			}

			// note joincolumns in jointable can be generated automatically by hib/jpox.
		} else if (aReference.getJoinColumns() == null || aReference.getJoinColumns().getValue().isEmpty()) { // add
			// joincolum(s)
			// the name of this eclass, the name of the property on the other side
			if (aReference.getAnnotatedEReference().getEOpposite() != null) {
				addJoinColumns(aReference.getPaEClass(), aReference.getAnnotatedEReference().getEOpposite(),
						aReference, aReference.getEmbedded() == null);
			} else { // no prop on the other side just use this one
				addJoinColumns(aReference.getPaEClass(), aReference.getAnnotatedEReference(), aReference, aReference
						.getEmbedded() == null);
			}
		}
	}

	/** Adds default annotations to a bidirectional many to many ereference */
	protected void processBidirectionalManyToManyReference(PAnnotatedEReference aReference, boolean forceOptional) {
		final String featureLogStr = aReference.getAnnotatedEReference().getName() + "/"
				+ aReference.getAnnotatedEReference().getEContainingClass().getName();

		if (aReference.getOneToMany() != null || aReference.getOneToOne() != null || aReference.getManyToOne() != null) {
			throw new StoreMappingException("The feature/eclass " + featureLogStr + " should be a ManyToMany but "
					+ "it already has a OneToMany, OneToOne or ManyToOne annotation");
		}

		final EReference eReference = (EReference) aReference.getAnnotatedElement();
		final EReference eOpposite = eReference.getEOpposite();
		assert (eOpposite != null && eOpposite.isMany());

		ManyToMany mtm = aReference.getManyToMany();
		if (mtm == null) {
			log.debug("Adding manytomany annotations to ereference: " + featureLogStr);
			mtm = aFactory.createManyToMany();
			aReference.setManyToMany(mtm);
			mtm.setEModelElement(eReference);
		} else {
			log.debug("ManyToMany present check if default information should be added");
		}

		setCascade(mtm.getCascade(), eReference.isContainment());
		if (mtm.getTargetEntity() == null) {
			mtm.setTargetEntity(StoreUtil.getEClassURI(eReference.getEReferenceType(), optionQualifyEClass));
		}

		// determine where to place the jointable annotation and where to place the mappedby
		// use a certain logic to determine as each is only set on one side
		// note that the join is always set on the other side of mapped by!
		// note that we can not do setJoinHere = !setMappedByHere because there are situations
		// that even for mtm no mappedby is set on either side, nl. in case of containment
		if (mtm.getMappedBy() == null && setMappedBy(eReference)) {
			mtm.setMappedBy(eOpposite.getName());
		}

		JoinTable joinTable = aReference.getJoinTable();
		if (joinTable == null) {
			joinTable = aFactory.createJoinTable();
			aReference.setJoinTable(joinTable);
		}
		joinTable.setEModelElement(eReference);

		// NOTE that the ejb3 spec states that the jointable should be the concatenation of the
		// tablenames of the owning entities with an underscore, this will quickly lead to nameclashes
		// in the case there is more than one relation between two classes. This can be pretty likely
		// if the inheritance strategy is single_table.
		if (joinTable.getName() == null) {
			// In case the reference is not indexed then one join table can be used for both sides
			// If indexed then separate join tables should be used.
			final String jTableName;
			if (aReference.getIndexed().isValue()) {
				jTableName = getEntityName(eReference.getEContainingClass(), aReference.getPaModel()) + "_"
						+ getEntityName(eOpposite.getEContainingClass(), aReference.getPaModel());
			} else {
				if (compareNames(eReference, eOpposite)) {
					jTableName = getEntityName(eOpposite.getEContainingClass(), aReference.getPaModel()) + "_"
							+ getEntityName(eReference.getEContainingClass(), aReference.getPaModel());
				} else {
					jTableName = getEntityName(eReference.getEContainingClass(), aReference.getPaModel()) + "_"
							+ getEntityName(eOpposite.getEContainingClass(), aReference.getPaModel());
				}
			}

			joinTable.setName(trunc(jTableName.toUpperCase().toUpperCase(), false));
		}
		if (/* joinTable.getJoinColumns() == null || */joinTable.getJoinColumns().size() == 0) { // no joincolumns,
			// so
			// add them
			// if (joinTable.getJoinColumns() == null) joinTable.getJoinColumns().addAll(aFactory.createJoinColumns());
			joinTable.getJoinColumns().addAll(getJoinColumns(aReference.getPaEClass(), eReference, false, false));
		}
		if (/* joinTable.getInverseJoinColumns() == null || */joinTable.getInverseJoinColumns().size() == 0) { // no
			// inversejoincolumns,
			// so
			// add
			// them
			// if (joinTable.getInverseJoinColumns() == null)
			// joinTable.setInverseJoinColumns(aFactory.createJoinColumns());
			joinTable.getInverseJoinColumns().addAll(
					getJoinColumns(annotatedModel.getPAnnotated(eOpposite.getEContainingClass()), eOpposite, false,
							false));
		}
	}

	/** Adds default annotations to a unidirectional many to many ereference */
	protected void processUnidirectionalManyToManyReference(PAnnotatedEReference aReference, boolean forceOptional) {
		final String featureLogStr = aReference.getAnnotatedEReference().getName() + "/"
				+ aReference.getAnnotatedEReference().getEContainingClass().getName();

		if (aReference.getOneToMany() != null || aReference.getOneToOne() != null || aReference.getManyToOne() != null) {
			throw new StoreMappingException("The feature/eclass " + featureLogStr + " should be a ManyToMany but "
					+ "it already has a OneToMany, OneToOne or ManyToOne annotation");
		}

		final EReference eReference = (EReference) aReference.getAnnotatedElement();

		final ManyToMany mtm = aReference.getManyToMany();
		log.debug("ManyToMany present check if default information should be added");
		mtm.setEModelElement(eReference);

		setCascade(mtm.getCascade(), eReference.isContainment());

		if (mtm.getTargetEntity() == null) {
			mtm.setTargetEntity(StoreUtil.getEClassURI(eReference.getEReferenceType(), optionQualifyEClass));
		}

		// with a unidirectional mtm the join is always placed here
		JoinTable joinTable = aReference.getJoinTable();
		if (joinTable == null) {
			joinTable = aFactory.createJoinTable();
			aReference.setJoinTable(joinTable);
		}
		joinTable.setEModelElement(eReference);

		// note that here not the eclass name is used for the opposite side but the name of the targetentity
		// because that's the one which is known here
		if (joinTable.getName() == null) {
			final String oppName = mtm.getTargetEntity();
			final String jTableName = getEntityName(eReference.getEContainingClass(), aReference.getPaModel()) + "_"
					+ oppName;
			joinTable.setName(trunc(jTableName.toUpperCase().toUpperCase(), false));
		}
		// if (joinTable.getJoinColumns() == null) joinTable.setJoinColumns(aFactory.createJoinColumns());
		joinTable.getJoinColumns().addAll(getJoinColumns(aReference.getPaEClass(), eReference, forceOptional, false));
	}

	/** Adds default annotations for a one to one reference */
	protected void processOneToOneReference(PAnnotatedEReference aReference, boolean forceOptional) {
		final String logStr = aReference.getAnnotatedEReference().getName() + "/"
				+ aReference.getAnnotatedEReference().getEContainingClass().getName();

		if (aReference.getOneToMany() != null || aReference.getManyToMany() != null
				|| aReference.getManyToOne() != null) {
			throw new StoreMappingException("The feature/eclass " + logStr + " should be a OneToOne but "
					+ "it already has a OneToMany, ManyToMany or ManyToOne annotation");
		}

		final EReference eReference = (EReference) aReference.getAnnotatedElement();

		OneToOne oto = aReference.getOneToOne();
		if (oto == null) {
			log.debug("EReference + " + logStr + " does not have a onetoone annotation, adding one");
			oto = aFactory.createOneToOne();
			aReference.setOneToOne(oto);
			oto.setOptional(forceOptional || !eReference.isRequired() || eReference.isUnsettable());
			oto.setEModelElement(eReference);
		} else {
			log.debug("EReference + " + logStr + " has an onetoone annotation setting defaults if required");
		}
		if (forceOptional)
			oto.setOptional(true);

		// determine where to put the mapped-by
		if (oto.getMappedBy() == null && setMappedBy(eReference)) { // only works with different names
			oto.setMappedBy(eReference.getEOpposite().getName());
		}
		setCascade(oto.getCascade(), eReference.isContainment());

		// Note: Sometimes EMF generated getters/setters have a
		// very generic type (EObject), if the type can be derived here then this should
		// be added here
		if (oto.getTargetEntity() == null) {
			oto.setTargetEntity(StoreUtil.getEClassURI(eReference.getEReferenceType(), optionQualifyEClass));
		}
	}

	/** Handles many to one for bidirectional and unidirectional cases */
	protected void processManyToOneReference(PAnnotatedEReference aReference, boolean forceOptional) {
		final String logStr = aReference.getAnnotatedEReference().getName() + "/"
				+ aReference.getAnnotatedEReference().getEContainingClass().getName();

		if (aReference.getOneToMany() != null || aReference.getManyToMany() != null || aReference.getOneToOne() != null) {
			throw new StoreMappingException("The feature/eclass " + logStr + " should be a ManyToOne but "
					+ "it already has a OneToMany, ManyToMany or OneToOne annotation");
		}

		final EReference eReference = (EReference) aReference.getAnnotatedElement();

		ManyToOne mto = aReference.getManyToOne();
		if (mto == null) {
			log.debug("EReference + " + logStr + " does not have a manytoone annotation, adding one");
			mto = aFactory.createManyToOne();
			aReference.setManyToOne(mto);
			mto.setOptional(forceOptional || !eReference.isRequired() || eReference.isUnsettable()
					|| eReference.getEOpposite() != null);
			mto.setEModelElement(eReference);
		} else {
			log.debug("EReference + " + logStr + " does have a manytoone annotation, using it");
			log.debug("Setting optional because of inheritance mapping, this is a subclass");
			if (forceOptional)
				mto.setOptional(forceOptional);
		}

		setCascade(mto.getCascade(), eReference.isContainment());

		// NOTE: Sometimes EMF generated getters/setters have a
		// very generic type (EObject), if the type can be derived here then this should
		// be added here
		if (mto.getTargetEntity() == null) {
			mto.setTargetEntity(StoreUtil.getEClassURI(eReference.getEReferenceType(), optionQualifyEClass));
		}

		// create a set of joincolumns, note that if this is a two-way relation then
		// the other side will use the name of the ereference as second parameter,
		// matching the joincolumns on the other side
		if (aReference.getJoinColumns() == null || aReference.getJoinColumns().getValue().isEmpty()) {
			// the name of the joincolumns is defined by the name of the other entity and its primary key fields
			final PAnnotatedEClass aClass = aReference.getPaModel().getPAnnotated(eReference.getEReferenceType());
			if (aClass != null) { // aClass == null when the reference it to a high level type such as EObject
				addJoinColumns(aClass, aReference.getAnnotatedEReference(), aReference, mto.isOptional());
			}
		}
	}

	/** Creates a set of joincolumns for a reference to the annotated eclass */
	private void addJoinColumns(PAnnotatedEClass aClass, EStructuralFeature esf, PAnnotatedEStructuralFeature aFeature,
			boolean optional) {
		if (aFeature.getJoinColumns() == null)
			aFeature.setJoinColumns(aFactory.createJoinColumns());
		aFeature.getJoinColumns().getValue().addAll(getJoinColumns(aClass, esf, optional, true));
	}

	/** Return a list of join columns */
	private List getJoinColumns(PAnnotatedEClass aClass, EStructuralFeature esf, boolean optional,
			boolean useFeatureName) {
		final List result = new ArrayList();
		final List names = getIDFeaturesNames(aClass);
		for (Iterator it = names.iterator(); it.hasNext();) {
			String name = (String) it.next();
			JoinColumn jc = aFactory.createJoinColumn();
			final String jcName;
			if (useFeatureName) {
				jcName = esf.getName() + "_" + name;
			} else {
				jcName = aClass.getAnnotatedEClass().getName() + "_" + name;
			}
			jc.setName(trunc(jcName.toUpperCase(), true));
			jc.setNullable(optional);
			result.add(jc);
		}
		return result;
	}

	/** Returns true if this is the root of the inheritancetree which is persisted */
	private boolean isInheritanceRoot(PAnnotatedEClass aClass) {
		if (aClass.getMappedSuperclass() != null) {
			return false;
		}
		if (aClass.getTransient() != null) {
			return false;
		}
		for (Iterator it = aClass.getAnnotatedEClass().getESuperTypes().iterator(); it.hasNext();) {
			PAnnotatedEClass superAClass = aClass.getPaModel().getPAnnotated((EClass) it.next());
			if (superAClass != null && superAClass.getMappedSuperclass() == null
					&& processedAClasses.contains(superAClass)) {
				return false;
			}

			// and go up one level, can be used to skip non-entities in the structure
			if (isInheritanceRoot(superAClass)) {
				return false;
			}
		}
		return true;
	}

	/** Returns the inheritance of the passed annotated class or from one of its super annotated class */
	private Inheritance getInheritanceFromSupers(PAnnotatedEClass childPA) {
		if (childPA.getInheritance() != null && processedAClasses.contains(childPA))
			return childPA.getInheritance();
		final EClass eChild = childPA.getAnnotatedEClass();
		final List supers = eChild.getESuperTypes();
		for (Iterator it = supers.iterator(); it.hasNext();) {
			final EClass eSuper = (EClass) it.next();
			final PAnnotatedEClass pae = annotatedModel.getPAnnotated(eSuper);
			if (pae != null) {
				final Inheritance inheritance = getInheritanceFromSupers(pae);
				if (inheritance != null) {
					return inheritance;
				}
			}
		}
		return null;
	}

	/** Walks up a edatatype inheritance structure to find the itemType */
	private ArrayList getItemTypes(EDataType eDataType) {
		final ArrayList result = new ArrayList();
		if (eDataType == null)
			return result;
		final String itemType = getEAnnotationValue(eDataType, ANNOTATION_SOURCE_METADATA, "itemType");
		if (itemType != null) {
			result.add(getEClassifier(eDataType.getEPackage(), itemType));
			return result;
		}

		final String memberTypes = getEAnnotationValue(eDataType, ANNOTATION_SOURCE_METADATA, "memberTypes");
		if (memberTypes != null) {
			String[] mtypes = memberTypes.split(" ");
			for (int i = 0; i < mtypes.length; i++) {
				EClassifier eclassifier = getEClassifier(eDataType.getEPackage(), mtypes[i]);
				result.addAll(getItemTypes((EDataType) eclassifier));
			}
			return result;
		}

		final String baseType = getEAnnotationValue(eDataType, ANNOTATION_SOURCE_METADATA, "baseType");
		if (baseType != null) {
			final ArrayList tmpResult = getItemTypes((EDataType) getEClassifier(eDataType.getEPackage(), baseType));
			if (tmpResult.size() > 0) {
				result.addAll(tmpResult);
				return result;
			}
		}
		if (!Object.class.equals(eDataType.getInstanceClass())) {
			result.add(eDataType);
		}
		return result;
	}

	/** Returns the eclassifier using either the name of the eclassifier or the name element */
	private EClassifier getEClassifier(EPackage epackage, String searchName) {
		final Iterator it = epackage.getEClassifiers().iterator();
		while (it.hasNext()) {
			EClassifier eclassifier = (EClassifier) it.next();
			if (eclassifier.getName().compareTo(searchName) == 0)
				return eclassifier;
			String nameAnnotation = getEAnnotationValue(eclassifier, ANNOTATION_SOURCE_METADATA, "name");
			if (nameAnnotation != null && searchName.compareTo(nameAnnotation) == 0) {
				return eclassifier;
			}
		}
		return null;
	}

	/** Checks if the cascade should be set in the cascade list, is only done if the list is empty */
	private void setCascade(List cascadeList, boolean isContainment) {
		if (!cascadeList.isEmpty())
			return;

		if (isContainment && !optionSetCascadeAllOnContainment) {
			cascadeList.add(CascadeType.REMOVE_LITERAL);
			cascadeList.add(CascadeType.MERGE_LITERAL);
			cascadeList.add(CascadeType.PERSIST_LITERAL);
			cascadeList.add(CascadeType.REFRESH_LITERAL);
		} else if (isContainment) {
			cascadeList.add(CascadeType.ALL_LITERAL);
		} else {
			cascadeList.add(CascadeType.MERGE_LITERAL);
			cascadeList.add(CascadeType.PERSIST_LITERAL);
			cascadeList.add(CascadeType.REFRESH_LITERAL);
		}
	}

	/** Determines if mapped by should be set */
	private boolean setMappedBy(EReference eReference) {
		// only set in two way relation
		// if has not been set on the other side (mappedtoFields)
		// if not a containment relation, containment relations are handled differently
		// the other side may neither be containment
		final EReference eOpposite = eReference.getEOpposite();
		if (eOpposite == null)
			return false;
		return compareNames(eReference, eOpposite);
		// &&
		// !eReference.isContainment() && !eOpposite.isContainment();
	}

	/**
	 * Determines where to place a certain annotation/characteristic, this is done by comparing names..
	 */
	private boolean compareNames(EReference here, EReference there) {
		final String nameHere = here.eClass().getName() + here.getName();
		final String nameThere = there.eClass().getName() + there.getName();
		assert (nameHere.compareTo(nameThere) != 0);
		return nameHere.compareTo(nameThere) > 0;
	}

	/** Returns the entity name of the eclass of the passsed EStructuralFeature */
	private String getEntityName(EClass eclass, PAnnotatedModel pamodel) {
		final PAnnotatedEClass aclass = pamodel.getPAnnotated(eclass);
		if (aclass.getEntity() == null) { // create the name ourselved
			return StoreUtil.getEClassURI(aclass.getAnnotatedEClass(), optionQualifyEClass);
		}
		return aclass.getEntity().getName();
	}

	/** Returns the value of an annotation with a certain key */
	private String getEAnnotationValue(EClassifier eClassifier, String source, String key) {
		final EAnnotation eAnnotation = eClassifier.getEAnnotation(source);
		if (eAnnotation == null)
			return "";
		return (String) eAnnotation.getDetails().get(key);
	}

	/** Finds the additional annotations on a eReference */
	private void setFacets(PAnnotatedEStructuralFeature aFeature) {
		// note that currently emf always has ereference is ordered and always is unique
		final EStructuralFeature eFeature = aFeature.getAnnotatedEStructuralFeature();
		if (aFeature.getIndexed() == null) {
			aFeature.setIndexed(PannotationFactory.eINSTANCE.createIndexed());
			aFeature.getIndexed().setValue(eFeature.isOrdered());
		}
		if (aFeature.getUnique() == null) {
			aFeature.setUnique(PannotationFactory.eINSTANCE.createUnique());
			aFeature.getUnique().setValue(eFeature.isUnique());
		}

		final EAnnotation ean = aFeature.getAnnotatedElement().getEAnnotation(FACET_SOURCE_LIST);
		if (ean != null && ean.getDetails() != null) {
			if (ean.getDetails().get(FACET_INDEX) != null) {
				aFeature.getIndexed().setValue(((String) ean.getDetails().get(FACET_INDEX)).compareTo("true") == 0);
			}
			if (ean.getDetails().get(FACET_UNIQUE) != null) {
				aFeature.getUnique().setValue(((String) ean.getDetails().get(FACET_UNIQUE)).compareTo("true") == 0);
			}
		}

		// Force indexed to false if IdBag annotation is specified.
		if (aFeature.getIdBag() != null) {
			aFeature.getIndexed().setValue(false);
		}
	}

	/** Returns the list of names of id props of the eclass */
	private List getIDFeaturesNames(PAnnotatedEClass aClass) {
		final ArrayList list = new ArrayList();
		for (Iterator it = aClass.getAnnotatedEClass().getEStructuralFeatures().iterator(); it.hasNext();) {
			EStructuralFeature feature = (EStructuralFeature) it.next();
			PAnnotatedEStructuralFeature aStructuralFeature = aClass.getPaModel().getPAnnotated(feature);
			if (aStructuralFeature instanceof PAnnotatedEAttribute) {
				PAnnotatedEAttribute aAttribute = (PAnnotatedEAttribute) aStructuralFeature;
				if (aAttribute.getId() != null) {
					list.add(aAttribute.getAnnotatedEAttribute().getName());
				}
			}
		}

		if (list.isEmpty() && aClass.getAnnotatedEClass().getESuperTypes().size() > 0) {
			for (Iterator it = aClass.getAnnotatedEClass().getESuperTypes().iterator(); it.hasNext();) {
				final EClass eClass = (EClass) it.next();
				final PAnnotatedEClass aSuperClass = annotatedModel.getPAnnotated(eClass);
				if (aSuperClass != null) {
					list.addAll(getIDFeaturesNames(aSuperClass));
				}
				if (!list.isEmpty()) {
					return list;
				}
			}
			if (!list.isEmpty()) {
				return list;
			}
			// fall through
		}
		if (list.isEmpty()) {
			list.add("id"); // todo externalize
		}
		return list;
	}

	/** Utilit method to truncate a column name */
	private String trunc(String name, boolean truncSuffix) {
		if (optionMaximumSqlLength == -1)
			return optionSQLCaseStrategy.convert(name);
		if (name.length() < optionMaximumSqlLength)
			return optionSQLCaseStrategy.convert(name);

		// truncate the part before the last _ because this is often the suffix
		final int underscore = name.lastIndexOf('_');
		if (truncSuffix && underscore != -1 && underscore > 0) {
			final String usStr = name.substring(underscore);
			if ((optionMaximumSqlLength - usStr.length()) < 0)
				return optionSQLCaseStrategy.convert(name);
			return optionSQLCaseStrategy.convert(name.substring(0, optionMaximumSqlLength - usStr.length()) + usStr);
		}

		return optionSQLCaseStrategy.convert(name.substring(0, optionMaximumSqlLength));
	}
}