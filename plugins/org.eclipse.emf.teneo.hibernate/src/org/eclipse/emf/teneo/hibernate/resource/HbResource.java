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
 * $Id: HbResource.java,v 1.1 2006/07/05 22:29:31 mtaal Exp $
 */

package org.eclipse.emf.teneo.hibernate.resource;

import org.hibernate.Session;

/**
 * Defines the common interface for HbResource Impls.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.1 $
 */

public interface HbResource {
	
	/**
	 * Returns the session of the resource.
	 */
	Session getSession();
	
	/** Returns the session to the resource so that it can do clean up (or not) */
	void returnSession(Session session);
	
	/** Set isloading on the resource */
	void setIsLoading(boolean isLoading);
}
