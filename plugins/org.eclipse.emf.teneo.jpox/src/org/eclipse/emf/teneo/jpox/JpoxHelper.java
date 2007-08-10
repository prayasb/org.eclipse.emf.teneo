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
 * $Id: JpoxHelper.java,v 1.8 2007/08/10 16:40:49 mtaal Exp $
 */

package org.eclipse.emf.teneo.jpox;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.teneo.ERuntime;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.annotations.mapper.PersistenceMappingBuilder;
import org.eclipse.emf.teneo.annotations.pamodel.PAnnotatedModel;
import org.eclipse.emf.teneo.extension.ExtensionManager;
import org.eclipse.emf.teneo.extension.ExtensionManagerFactory;
import org.eclipse.emf.teneo.jpox.mapper.JPOXMappingGenerator;
import org.eclipse.emf.teneo.jpox.resource.JPOXResourceFactory;

/**
 * Is the main entry point for 'outside' users to create persistence manager factories and register
 * EMF Data Stores.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.8 $
 */
public class JpoxHelper {
	/** The logger */
	private static Log log = LogFactory.getLog(JpoxHelper.class);

	/** The singleton instance of this class */
	public static final JpoxHelper INSTANCE = new JpoxHelper();

	/** The persistence manager factory creator used to create pmf's */
	private PMFCreator pmfCreator = new DefaultPMFCreator();

	/** The standard jdo suffix, can be overridden */
	private String jdoFileExtension = "jdo";

	/** Initialize the extensions and protocols */
	static {
		log.info("Registering a jpox resource factory for all uri's with jpox as the protocol/extension");
		log.info("Registering a jpox resource factory for all uri's with ejdo as the protocol/extension");
		log.info("Registering a jpox resource dao factory for all uri's with jpoxdao as the protocol/extension");

		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("jpox", new JPOXResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("jpox", new JPOXResourceFactory());

		// support old way
		Resource.Factory.Registry.INSTANCE.getProtocolToFactoryMap().put("jpoxdao", new JPOXResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("jpoxdao", new JPOXResourceFactory());
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(JpoxConstants.EJDO_EXTENSION,
			new JPOXResourceFactory());
		System.setProperty("org.jpox.cache.level1.type", "org.eclipse.emf.teneo.jpox.cache.EMFWeakRefCache");
	}

	/** The list of EMF Datastores mapped by name */
	private final Hashtable emfDataStores = new Hashtable();

	/**
	 * Sets the suffix to use for searching for the jdo file. This method must be called before the
	 * PersistenceManagerFactory is created.
	 */
	public void setJdoFileExtension(String newExtension) {
		log.debug("Setting jdofileextension to " + newExtension);
		jdoFileExtension = newExtension;
	}

	/**
	 * @return the jdoFileExtension
	 */
	public String getJdoFileExtension() {
		return jdoFileExtension;
	}

	/**
	 * Set the persistencemanager factory creator, this allows the client to override the creation
	 * of persistence manager factories and persistence managers.
	 */
	public void setPMFCreator(PMFCreator pmfc) {
		log.info("Setting persistence manager factory creator to " + pmfc.getClass().getName());
		pmfCreator = pmfc;
	}

	/** Returns the current persistence manager factory creator */
	public PMFCreator getPMFCreator() {
		return pmfCreator;
	}

	/** Clears the list of persistance manager factories */
	public void closeAll() {
		final Iterator it = emfDataStores.values().iterator();
		while (it.hasNext()) {
			final JpoxDataStore jds = (JpoxDataStore) it.next();
			jds.close();
		}
		emfDataStores.clear();
		ERuntime.INSTANCE.clear();
	}

	/** Returns a jpox data store, note if not found then null is returned */
	public synchronized JpoxDataStore getDataStore(String name) {
		JpoxDataStore jds = (JpoxDataStore) emfDataStores.get(name);
		if (jds == null) {
			log.debug("No jpox datastore found using name: " + name);
		}
		return jds;
	}

	/** Removes a pm factory/emf datastore from the registry */
	public synchronized void deRegisterDataStore(String name) {
		final JpoxDataStore ds = (JpoxDataStore) emfDataStores.get(name);
		if (ds == null) {
			log.warn("No pmf or emf datastore registered under the name " + name);
			return;
		}
		ds.close();
		emfDataStores.remove(name);
	}

	/**
	 * Creates and registers an EMF DataStore and returns it
	 */
	public synchronized JpoxDataStore createRegisterDataStore(String name) {

		JpoxDataStore jds = (JpoxDataStore) emfDataStores.get(name);
		if (jds != null) {
			log.warn("JpoxDataStore already registered under: " + name + " returning that one");
		}

		jds = new JpoxDataStore();
		jds.setName(name);
		emfDataStores.put(name, jds);
		return jds;
	}

	/**
	 * Returns the instanceclass for a passed interface,
	 */
	public Class getInstanceClass(Class interfaze) {
		if (!interfaze.isInterface() || !EObject.class.isAssignableFrom(interfaze)) {
			throw new JpoxStoreException(
				"This method may only be called with a class which is an interface (extending from EObject), " +
						interfaze.getName() + " is not an interface or does not extend EObject.");
		}
		return ERuntime.INSTANCE.getInstanceClass(interfaze);
	}

	/** Generate a jpox mapping for a set of epackages and options */
	public String generateMapping(EPackage[] epackages, Properties props) {
		return generateMapping(epackages, props, ExtensionManagerFactory.getInstance().create());
	}

	/** Generate a jpox mapping for a set of epackages and options */
	public String generateMapping(EPackage[] epackages, Properties props, ExtensionManager extensionManager) {
		log.debug("Generating mapping file passed epackages");

		// set the eruntime as the emodel resolver!
		ERuntime.setAsEModelResolver();

		final PersistenceOptions po = extensionManager.getExtension(PersistenceOptions.class, new Object[] { props });
		final PAnnotatedModel paModel =
				extensionManager.getExtension(PersistenceMappingBuilder.class).buildMapping(epackages, po,
					extensionManager);
		final JPOXMappingGenerator jmg = extensionManager.getExtension(JPOXMappingGenerator.class);
		jmg.setPersistenceOptions(po);
		return jmg.generate(paModel);
	}

	/**
	 * Creates a persistence manager factory (pmf) and registers it under the passed name. Before
	 * creating the pmf first the jpox schema tool is run. Because the schema tool runs upfront the
	 * pmf parameters autoCreateSchema and validate properties are all set to false. The created pmf
	 * can be retrieved using the passed name.
	 * 
	 * @param name
	 *            the name under which the pmf is retrievable
	 * @param epackages
	 *            the list of epackages which are to be stored in this relational store
	 * @param dbDriver
	 *            the database driver (e.g. com.mysql.jdbc.Driver)
	 * @param dbUrl
	 *            the database url, for mysql this includes the dbname, (e.g.
	 *            jdbc:mysql://127.0.0.1:3306/JPOX)
	 * @param dbName
	 *            the database name
	 * @param dbUser
	 *            the database user which is allowed to drop and create databases
	 * @param dbPwd
	 *            the password of this user.
	 * @param options
	 *            a hashmap with jdo and jpox options which can be used to override the standard
	 *            options
	 * @return the created persistence manager factory
	 * 
	 * public synchronized PersistenceManagerFactory createRegisterPersistenceManagerFactory(String
	 * name, EPackage[] epackages, String dbDriver, String dbUrl, String dbUser, String dbPwd,
	 * String dbName, Map specificOptions) { Properties properties = new Properties();
	 * properties.setProperty(PMFConfiguration.JDO_DATASTORE_DRIVERNAME_PROPERTY, dbDriver);
	 * properties.setProperty(PMFConfiguration.JDO_DATASTORE_URL_PROPERTY, dbUrl);
	 * properties.setProperty(PMFConfiguration.JDO_DATASTORE_USERNAME_PROPERTY, dbUser);
	 * properties.setProperty(PMFConfiguration.JDO_DATASTORE_PASSWORD_PROPERTY, dbPwd);
	 * properties.setProperty(PMFConfiguration.JDO_MAPPING_CATALOG_PROPERTY,dbName);
	 * //properties.setProperty(PMFConfiguration.JDO_DETACHONCLOSE_PROPERTY,"true");
	 * //properties.setProperty(PMFConfiguration.JDO_DETACHALLONCOMMIT_PROPERTY,"true");
	 * //properties.setProperty(PMFConfiguration.JDO_CACHE_COLLECTIONS_LAZY_PROPERTY, "true");
	 * properties.setProperty("javax.jdo.PersistenceManagerFactoryClass",
	 * "org.jpox.PersistenceManagerFactoryImpl");
	 * properties.setProperty(PMFConfiguration.JDO_IGNORECACHE_PROPERTY,"false");
	 * properties.setProperty(PMFConfiguration.JDO_RETAINVALUES_PROPERTY, "true");
	 * properties.setProperty(PMFConfiguration.JDO_NONTRANSACTIONAL_READ_PROPERTY, "true"); // set
	 * it all to false because of performance
	 * properties.setProperty(PMFConfiguration.AUTO_CREATE_SCHEMA_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.AUTO_CREATE_CONSTRAINTS_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.AUTO_CREATE_SCHEMA_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.AUTO_CREATE_TABLES_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.VALIDATE_COLUMNS_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.VALIDATE_CONSTRAINTS_PROPERTY, "false");
	 * properties.setProperty(PMFConfiguration.VALIDATE_TABLES_PROPERTY, "false");
	 * 
	 * properties.setProperty(PMFConfiguration.CACHE_LEVEL_1_TYPE_PROPERTY,
	 * "org.eclipse.emf.teneo.jpox.cache.EMFWeakRefCache");
	 * properties.setProperty(PMFConfiguration.DEFAULT_INHERITANCE_STRATEGY_PROPERTY,
	 * defaultInheritanceStrategy);
	 * properties.setProperty(PMFConfiguration.METADATA_JDO_FILE_EXTENSION_PROPERTY,
	 * jdoFileExtension);
	 * 
	 * //properties.setProperty("org.jpox.rdbms.dateTimezone", "Europe/Amsterdam"); // override the
	 * defaults properties.putAll(specificOptions); // added to enable easy testing of optimistic
	 * transactions, not very elegant but effective if (optimisticTransactions) {
	 * properties.setProperty(PMFConfiguration.JDO_OPTIMISTIC_PROPERTY, "true"); }
	 * 
	 * //properties.setProperty("org.jpox.delayDatastoreOperationsUntilCommit","true");
	 * //properties.setProperty("org.jpox.cache.level2.type", "org.jpox.cache.DefaultLevel2Cache");
	 * //properties.setProperty("org.jpox.cache.collections.lazy", "false");
	 * 
	 * return createRegisterPersistenceManagerFactory(name, epackages, properties); }
	 */
}