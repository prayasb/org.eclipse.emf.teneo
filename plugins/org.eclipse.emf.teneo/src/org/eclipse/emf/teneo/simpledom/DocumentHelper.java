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
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: DocumentHelper.java,v 1.3 2007/02/01 12:34:21 mtaal Exp $
 */

package org.eclipse.emf.teneo.simpledom;

/**
 * This simple class is part of the replacement of dom4j.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.3 $
 */

public class DocumentHelper {

	/** Create an element */
	public static Element createElement(String name) {
		final Element element = new Element();
		element.setName(name);
		return element;
	}
}