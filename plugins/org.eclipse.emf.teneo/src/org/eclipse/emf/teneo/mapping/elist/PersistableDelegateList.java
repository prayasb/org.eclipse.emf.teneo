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
 * $Id: PersistableDelegateList.java,v 1.2 2007/02/01 12:34:21 mtaal Exp $
 */

package org.eclipse.emf.teneo.mapping.elist;

import java.util.List;

/**
 * A tag which signals that a list is either a persistable featuremap or elist.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.2 $
 */

public interface PersistableDelegateList {
	/** Return the delegate list without doing a load */
	public List getDelegate();

	/** Returns true if the elist is loaded */
	public boolean isLoaded();
}