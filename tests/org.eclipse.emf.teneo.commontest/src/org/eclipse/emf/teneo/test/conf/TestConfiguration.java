/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007, 2008 Springsite BV (The Netherlands) and others
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
 * $Id: TestConfiguration.java,v 1.5 2008/02/28 07:08:16 mtaal Exp $
 */

package org.eclipse.emf.teneo.test.conf;

import org.eclipse.emf.teneo.annotations.pannotation.InheritanceType;
import org.eclipse.emf.teneo.test.stores.TestDatabaseAdapter;

/**
 * Contains the parameters which define how the test should be run, for example inheritance mapping.
 * 
 * @author Davide Marchignoli
 * @author Martin Taal
 * @version $Revision: 1.5 $
 */
public class TestConfiguration {

	private final String name;

	private final TestDatabaseAdapter dbAdapter;

	private final InheritanceType mappingStrategy;

	private final boolean optimistic;

	private final boolean ejb3;

	private final boolean xml;

	/** Constructor */
	public TestConfiguration(String name, TestDatabaseAdapter dbAdapter, InheritanceType mappingStrategy,
			boolean optimistic, boolean ejb3, boolean xml) {
		this.name = name;
		this.dbAdapter = dbAdapter;
		this.mappingStrategy = mappingStrategy;
		this.optimistic = optimistic;
		this.ejb3 = ejb3;
		this.xml = xml;
	}

	/** ToString for logging */
	@Override
	public String toString() {
		StringBuffer s = new StringBuffer();
		s.append("HibernateTestConfiguration(name=").append(getName()).append(", dbAdapter=").append(getDbAdapter())
			.append(", ").append("mappingStrategy= ").append(getMappingStrategy().toString()).append(", ").append(
				"optimistic= ").append(isOptimistic());
		return s.toString();
	}

	/** Hashcode computed on the basis of the contents of the configuration */
	@Override
	public int hashCode() {
		return getDbAdapter().hashCode() + getMappingStrategy().hashCode() + (isOptimistic() ? 1 : 0);
	}

	/** Equal configuration */
	@Override
	public boolean equals(Object other) {
		if (other instanceof TestConfiguration) {
			TestConfiguration otherCfg = (TestConfiguration) other;
			return otherCfg.getDbAdapter() == getDbAdapter() && otherCfg.getMappingStrategy() == getMappingStrategy() &&
					otherCfg.isOptimistic() == isOptimistic() && otherCfg.isEjb3() == isEjb3() &&
					otherCfg.isXml() == isXml();
		}
		;
		return false;
	}

	/** The configuration name */
	public String getName() {
		return name;
	}

	/** Returns the test databaseadapter */
	public TestDatabaseAdapter getDbAdapter() {
		return dbAdapter;
	}

	/** Returns the current inheritance mapping */
	public InheritanceType getMappingStrategy() {
		return mappingStrategy;
	}

	/** Test optimistic locking */
	public boolean isOptimistic() {
		return optimistic;
	}

	/**
	 * @return the ejb3
	 */
	public boolean isEjb3() {
		return ejb3;
	}

	/**
	 * @return the xml
	 */
	public boolean isXml() {
		return xml;
	}

}
