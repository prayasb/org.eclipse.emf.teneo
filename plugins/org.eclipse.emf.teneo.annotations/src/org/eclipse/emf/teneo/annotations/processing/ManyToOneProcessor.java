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
 *   Davide Marchignoli
 * </copyright>
 *
 * $Id: ManyToOneProcessor.java,v 1.2 2006/07/04 21:56:30 mtaal Exp $
 */

package org.eclipse.emf.teneo.annotations.processing;

import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEReference;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedEStructuralFeature;
import org.eclipse.emf.teneo.annotations.pannotation.ManyToOne;

/**
 * Process a {@link ManyToOne} annotated element.
 * <p>
 * Assumes that the given {@link PAnnotatedEStructuralFeature} is a normal ManyToOne, i.e.
 * <ul>
 * <li>it is a {@link PAnnotatedEReference};
 * <li>it has a {@link ManyToOne} annotation;
 * <li>TODO
 * </ul>
 * 
 * @author <a href="mailto:marchign at elver.org">Davide Marchignoli</a>
 * @author <a href="mailto:mtaal at elver.org">Martin Taal</a>
 */
public interface ManyToOneProcessor extends PAnnotatedProcessor {

	/**
	 * Many to One unidirectional
	 * 
	 * @param paReference
	 * @param manyToOne
	 * @param joinColumns
	 */
	public void processMtOUni(PAnnotatedEReference paReference);

	/**
	 * Many to One bidirectional owner
	 * 
	 * @param paReference
	 * @param manyToOne
	 * @param joinColumns
	 */
	public void processMtOBidiOwner(PAnnotatedEReference paReference);
}
