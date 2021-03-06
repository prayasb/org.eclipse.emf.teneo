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
 * </copyright>
 *
 * $Id: CascadeNotallAction.java,v 1.11 2008/02/28 07:08:14 mtaal Exp $
 */

package org.eclipse.emf.teneo.test.emf.annotations;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.Book;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.BookCategory;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.CascadenotallFactory;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.CascadenotallPackage;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.Library;
import org.eclipse.emf.teneo.samples.emf.annotations.cascadenotall.Writer;
import org.eclipse.emf.teneo.test.AbstractTestAction;
import org.eclipse.emf.teneo.test.StoreTestException;
import org.eclipse.emf.teneo.test.stores.TestStore;

/**
 * Tests the library example without orphan delete or dependent element
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.11 $
 */
public class CascadeNotallAction extends AbstractTestAction {
	/**
	 * Constructor for ClassHierarchyParsing.
	 * 
	 * @param arg0
	 */
	public CascadeNotallAction() {
		super(CascadenotallPackage.eINSTANCE);
	}

	@Override
	public Properties getExtraConfigurationProperties() {
		final Properties props = new Properties();
		props.setProperty("org.jpox.deletionPolicy", "JDO2");
		return props;
	}

	/** Creates an item, an address and links them to a po. */
	@Override
	public void doAction(TestStore store) {
		final CascadenotallFactory factory = CascadenotallFactory.eINSTANCE;

		// create a book, writer and library
		try {
			{
				final Resource res = store.getResource();
				res.load(null);

				final Writer writer = factory.createWriter();
				writer.setName("JRR Tolkien");

				final Book book = factory.createBook();
				book.setAuthor(writer);
				book.setPages(510);
				book.setTitle("Fellowship of the Ring");
				book.setCategory(BookCategory.SCIENCE_FICTION_LITERAL);

				final Book book2 = factory.createBook();
				book2.setAuthor(writer);
				book2.setPages(500);
				book2.setTitle("The Hobbit");
				book2.setCategory(BookCategory.SCIENCE_FICTION_LITERAL);

				// sorry george making a mistake here, will correct this below
				final Book book3 = factory.createBook();
				book3.setAuthor(writer);
				book3.setPages(500);
				book3.setTitle("1984");
				book3.setCategory(BookCategory.SCIENCE_FICTION_LITERAL);

				final Library library = factory.createLibrary();
				library.setName("Science Fiction");
				library.getBooks().add(book);
				library.getBooks().add(book2);
				library.getBooks().add(book3);
				library.getWriters().add(writer);

				res.getContents().add(library);
				res.save(null);
				res.save(null);
				res.unload();
			}

			// walk through the structure starting from the library
			{
				final Resource res = store.getResource();
				res.load(null);

				final Library lib = (Library) res.getContents().get(0);

				final Writer tolkien = lib.getWriters().get(0);

				/*
				 * final Object[] obj = ((StoreResource)res).getCrossReferencers(tolkien); for (int
				 * i = 0; i < obj.length; i++) {
				 */

				/*
				 * assertEquals(3, tolkien.getBooks().size());
				 * 
				 * assertEquals(0 , tolkien.getName().compareTo("JRR Tolkien")); Book wBook =
				 * (Book)tolkien.getBooks().get(0); Book lBook = (Book)lib.getBooks().get(0);
				 * assertTrue("Book is contained in the library", wBook.eContainer() == lib);
				 * assertTrue("Book is contained in the library", lBook.eContainer() == lib);
				 * 
				 * assertTrue(lBook.getAuthor() == tolkien);
				 * assertTrue(tolkien.getBooks().contains(lBook));
				 * assertTrue(tolkien.getBooks().contains(wBook)); // ordering is the same
				 * assertTrue(wBook.getTitle().compareTo(lBook.getTitle()) == 0);
				 * assertTrue(wBook.getPages() == lBook.getPages()); assertTrue(wBook.getCategory()
				 * instanceof BookCategory); assertTrue(wBook.getCategory() ==
				 * BookCategory.SCIENCE_FICTION_LITERAL);
				 */
				// correct the mistake we made
				final Book orwellsBook = tolkien.getBooks().get(2);
				assertTrue(orwellsBook.getTitle().compareTo("1984") == 0);

				// add orwell as a writer
				final Writer george = factory.createWriter();
				george.setName("George Orwell");
				orwellsBook.setAuthor(george);

				// and put george in our library
				lib.getWriters().add(george);

				assertEquals(2, tolkien.getBooks().size());

				// and save it all
				res.save(null);
				res.save(null);

				george.setName("G. Orwell"); // there was a bug in which this failed, reported by
				// Georgi Manev
				res.save(null);
				res.save(null);
				res.unload();
			}

			// TODO put in JPOX specific test code
			// // now retrieve the writer using a simple query
			// if (store instanceof JPOXTestStore)
			// {
			// store.beginTransaction();
			// Writer george = (Writer)store.query("SELECT FROM " +
			// JPOXHelper.INSTANCE.getInstanceClassName(Writer.class) +
			// " WHERE name == \"G. Orwell\"", 1).get(0);
			// assertTrue(george.getBooks().size() == 1);
			// Book georgesBook = (Book)george.getBooks().get(0);
			// assertTrue(georgesBook.getAuthor() == george);
			// store.commitTransaction();
			// }
		} catch (final IOException e) {
			throw new StoreTestException("IOException during save", e);
		}

		try {
			final Resource res = store.getResource();
			res.load(null);

			final Library lib = (Library) res.getContents().get(0);

			final Writer writer = lib.getWriters().get(0);

			final Library newLib = factory.createLibrary();
			newLib.setName("tstlib");
			res.getContents().add(newLib);

			// this save was required to get the entitymanager working
			// because if not there then newLib would not have been saved and
			// the persistent writer would through its econtainer relation point
			// to a non-saved newLib resulting in transient errors.
			res.save(null);
			assertTrue(lib.getBooks().size() > 0); // force load of books to prevent dangling error
			// in jpox
			lib.getWriters().remove(writer);
			newLib.getWriters().add(writer);
			res.save(null);
			res.unload();

		} catch (final IOException e) {
			throw new StoreTestException("IOException during save", e);
		}

		// and check if cascade delete works!

		try {
			final Resource res = store.getResource();
			res.load(null);

			final Library lib = (Library) res.getContents().get(0);

			assertTrue(lib.getName() != null); // get rid of warning

			// delete both libraries
			res.getContents().remove(0);
			res.getContents().remove(0);
			res.save(null);
			res.unload();
		} catch (final IOException e) {
			throw new StoreTestException("IOException during save", e);
		}

		store.beginTransaction();
		store.checkNumber(Writer.class, 0);
		store.checkNumber(Book.class, 0);
		store.checkNumber(Library.class, 0);
		store.commitTransaction();
	}

	protected boolean hibernateEnabled() {
		return true;
	}
}
