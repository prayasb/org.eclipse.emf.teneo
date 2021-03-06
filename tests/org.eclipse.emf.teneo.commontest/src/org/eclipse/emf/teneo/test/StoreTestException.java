/**
 * <copyright> Copyright (c) 2005, 2006, 2007, 2008 Springsite BV (The Netherlands) and others All rights
 * reserved. This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Martin Taal </copyright> $Id:
 * StoreTestException.java,v 1.4 2007/02/01 12:35:37 mtaal Exp $
 */

package org.eclipse.emf.teneo.test;

import org.eclipse.emf.teneo.TeneoException;

/**
 * This exception is the base class of all exceptions which occur in the generation process. This
 * class offers automatic logging to commons logging. Note that this class extends RuntimeException,
 * so no forced throws and catch statements. Although there are very differing views on this topic
 * but it is our experience that to many checked exceptions only distract the programmer and have no
 * added value.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.6 $ $Date: 2008/02/28 07:08:16 $
 */

public class StoreTestException extends TeneoException {
	/**
	 * A serialized version id
	 */
	private static final long serialVersionUID = -6313295414030858545L;

	/**
	 * The constructor, logs the exception also
	 */
	public StoreTestException(String msg, Throwable cause) {
		super(msg, cause);
	}

	/**
	 * The constructor, logs the exception also
	 */
	public StoreTestException(String msg) {
		super(msg);
	}
}
