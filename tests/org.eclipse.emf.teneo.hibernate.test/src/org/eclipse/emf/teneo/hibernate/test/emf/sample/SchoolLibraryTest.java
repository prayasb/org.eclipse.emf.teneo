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
 * </copyright>
 *
 * $Id: SchoolLibraryTest.java,v 1.3 2007/02/01 12:36:24 mtaal Exp $
 */

package org.eclipse.emf.teneo.hibernate.test.emf.sample;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.teneo.test.AbstractActionTest;
import org.eclipse.emf.teneo.test.emf.sample.SchoolLibraryAction;

/**
 * Tests the library example of emf/xsd.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.3 $
 */
public class SchoolLibraryTest extends AbstractActionTest {

	private static SchoolLibraryAction testAction = new SchoolLibraryAction() {
		/** Returns one test query */
		protected String getQuery1() {
			return "query1=FROM Writer&query2=FROM Book";
		}

		/** Returns one test query */
		protected String getQuery2() {
			return "query1=FROM Writer";
		}

		/** Returns one test query */
		protected String getQuery3() {
			return "query1=FROM Writer&query2=FROM Book";
		}

		/** Returns one test query */
		protected String getQuery4() {
			return "query1=FROM Book";
		}

		/** Container present */
		protected boolean hasContainer(InternalEObject obj) {
			return obj.eContainer() != null;
		}
	};

	public SchoolLibraryTest() {
		super(testAction);
	}
}