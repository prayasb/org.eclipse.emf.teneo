/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal
 *   Davide Marchignoli
 * </copyright>
 *
 * $Id: ManyToManyMapper.java,v 1.9 2007/03/18 19:19:44 mtaal Exp $
 */

package org.eclipse.emf.teneo.hibernate.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEReference;
import org.eclipse.emf.teneo.annotations.pannotation.JoinColumn;
import org.eclipse.emf.teneo.annotations.pannotation.JoinTable;
import org.eclipse.emf.teneo.annotations.pannotation.ManyToMany;
import org.eclipse.emf.teneo.hibernate.hbmodel.HbAnnotatedEReference;
import org.eclipse.emf.teneo.simpledom.Element;
import org.eclipse.emf.teneo.util.StoreUtil;

/**
 * Maps a many to many relation.
 * 
 * @author <a href="mailto:marchign at elver.org">Davide Marchignoli</a>
 * @author <a href="mailto:mtaal at elver.org">Martin Taal</a>
 */
class ManyToManyMapper extends AbstractAssociationMapper {

	/** Logger */
	private static final Log log = LogFactory.getLog(ManyToManyMapper.class);

	/**
	 * @param hbmContext
	 */
	public ManyToManyMapper(MappingContext hbmContext) {
		super(hbmContext);
	}

	/**
	 * Process a many to many for all cases
	 */
	public void process(PAnnotatedEReference paReference) {
		log.debug("Creating many-to-many for " + paReference);

		final HbAnnotatedEReference hbReference = (HbAnnotatedEReference) paReference;
		final EReference eref = paReference.getAnnotatedEReference();
		final JoinTable jt = hbReference.getJoinTable();
		final ManyToMany mtm = hbReference.getManyToMany();

		if (jt == null) {
			throw new MappingException("Jointable is mandatory "
					+ StoreUtil.toString(hbReference.getAnnotatedEReference()));
		}

		final Element collElement = addCollectionElement(hbReference);

		if (((HbAnnotatedEReference) paReference).getHbCache() != null) {
			addCacheElement(collElement, ((HbAnnotatedEReference) paReference)
					.getHbCache());
		}

		final Element keyElement = collElement.addElement("key");
		handleOndelete(keyElement, hbReference.getHbOnDelete());

		boolean isMap = StoreUtil.isMap(eref)
				&& getHbmContext().isMapEMapAsTrueMap();
		if (mtm.isIndexed()) {
			// now we check if it is a list or a map
			if (hbReference.getMapKey() != null) {
				addMapKey(collElement, paReference, hbReference.getMapKey());
			} else if (isMap) {
				addMapKey(collElement, hbReference);
			} else {
				assert (hbReference.getHbIdBag() == null);
				addListIndex(collElement, hbReference);
			}
		}

		addFetchType(collElement, mtm.getFetch(), false);
		addCascades(collElement, mtm.getCascade(), false);

		final EClass referedTo = hbReference.getAnnotatedEReference()
				.getEReferenceType();

		boolean isEasyEMFGenerated = getHbmContext().isEasyEMFGenerated(
				referedTo);
		String targetName = mtm.getTargetEntity();
		if (targetName == null || isEasyEMFGenerated) {
			targetName = getHbmContext().getEntityName(referedTo);
		}
		log.debug("Target entity-name " + targetName);

		final Element mtmElement;
		if (isEasyEMFGenerated) {
			mtmElement = collElement.addElement("many-to-many").addAttribute(
					"class", targetName).addAttribute("unique", "false");
		} else {
			mtmElement = collElement.addElement("many-to-many").addAttribute(
					"entity-name", targetName).addAttribute("unique", "false");
		}

		// inverse is not supported by indexed lists
		if (mtm.getMappedBy() != null && !mtm.isIndexed()) {
			collElement.addAttribute("inverse", "true");
		} else if (mtm.getMappedBy() != null && !mtm.isIndexed()) {
			log
					.warn("Indexed is true but indexed is not supported for inverse=true and many-to-many, not setting inverse=true");
		}

		addJoinTable(collElement, keyElement, jt);
		if (jt.getInverseJoinColumns() != null) {
			for (JoinColumn joinColumn : jt.getInverseJoinColumns()) {
				mtmElement.addElement("column").addAttribute("name",
						getHbmContext().trunc(joinColumn.getName()))
						.addAttribute("not-null",
								joinColumn.isNullable() ? "false" : "true")
						.addAttribute("unique",
								joinColumn.isUnique() ? "true" : "false");
			}
		}
	}
}
