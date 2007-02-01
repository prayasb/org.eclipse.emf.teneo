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
 * $Id: HibernateTestbed.java,v 1.11 2007/02/01 12:36:24 mtaal Exp $
 */

package org.eclipse.emf.teneo.hibernate.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbConstants;
import org.eclipse.emf.teneo.hibernate.HbHelper;
import org.eclipse.emf.teneo.hibernate.test.stores.HibernateTestStoreFactory;
import org.eclipse.emf.teneo.test.AbstractTest;
import org.eclipse.emf.teneo.test.StoreTestException;
import org.eclipse.emf.teneo.test.conf.TestConfiguration;
import org.eclipse.emf.teneo.test.conf.Testbed;
import org.eclipse.emf.teneo.test.stores.TestStore;

/**
 * Is the testbed which models the base in which a testrun is run.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.11 $
 */
public class HibernateTestbed extends Testbed {

	/** The logger */
	private static Log log = LogFactory.getLog(HibernateTestbed.class);

	/** The property file to use */
	private static final String propFileName;

	/**
	 * The directory in which the mapping files are generated TODO make insesitive to user.dir
	 */
	private static String RUN_BASE_DIR = System.getProperty("user.dir") + File.separatorChar + "run";

	/** Test the rundir */
	static {
		try {
			if (RUN_BASE_DIR.indexOf("www-data") != -1) { // UGLY, replace with smarter solution!
				propFileName = "/emft_test.properties";
			} else {
				propFileName = "/local_test.properties";
			}
			Testbed.setTestBed(new HibernateTestbed());
		} catch (Exception e) {
			throw new StoreTestException("Exception while checking directory " + RUN_BASE_DIR, e);
		}
	}

	/** Delegates to the test bed */
	public static Testbed instance() {
		return Testbed.instance();
	}

	/** The factory which creates test stores */
	private HibernateTestStoreFactory storeFactory;

	/** Constructor */
	private HibernateTestbed() {
		super(propFileName);
		storeFactory = new HibernateTestStoreFactory();
	}

	/**
	 * Request a store for the given configuration.
	 */
	public TestStore createStore(AbstractTest testCase) {
		try {

			// get and write the mapping xml for debugging purposes.
			// this is actually double as the storeFactory.get does the same thing
			// but okay
			writeMappingToFile(testCase);

			TestStore store = storeFactory.get(getDbName(testCase, getActiveConfiguration()), 
					testCase.getEPackages(), (String)null,
					getActiveConfiguration(), testCase.getExtraConfigurationProperties());

			// setup store
			store.setUp();

			return store;
		} catch (IOException e) {
			throw new StoreTestException("Exception while writing hbm file/creating mapping file " + e.getMessage(), e);
		}
	}

	/** Creates the mapping xml and writes it to a mapping file */
	private void writeMappingToFile(AbstractTest testCase) throws IOException {
		final Properties props = testCase.getExtraConfigurationProperties();
		props.put(PersistenceOptions.INHERITANCE_MAPPING, getActiveConfiguration().getMappingStrategy().getName());
		final Properties properties = new Properties();
		properties.putAll(props);
		final String mappingXML = HbHelper.INSTANCE.generateMapping(testCase.getEPackages(), properties); 
		writeMappingToFile(getHBMFile(testCase, getActiveConfiguration()), mappingXML);
	}

	/** Write the mapping file for debugging purposes */
	private void writeMappingToFile(File mappingFile, String mappingXML) throws IOException {
		if (false) {
			log.debug("Disabled writing of hibernate.hbm.xml file for tests on the vserver");
			return;
		}
		if (mappingFile.exists()) mappingFile.delete();
		mappingFile.createNewFile();
		final FileWriter fileWriter = new FileWriter(mappingFile);
		
		fileWriter.write(mappingXML);
		fileWriter.close();
	}

	/** Returns the file to which the mapping file is written */
	protected File getHBMFile(AbstractTest testCase, TestConfiguration cfg) {
		return new File(getRunTestDir(testCase, cfg), HbConstants.HBM_FILE_NAME);
	}

	/** Return the directory in which the mapping file is stored */
	protected File getRunTestDir(AbstractTest testCase, TestConfiguration cfg) {
		File dir = new File(new File(RUN_BASE_DIR, testCase.getName()), cfg.getName());
		dir.mkdirs();
		return dir;
	}
}
