/**
 * <copyright> Copyright (c) 2005, 2006, 2007 Springsite BV (The Netherlands) and others All rights
 * reserved. This program and the accompanying materials are made available under the terms of the
 * Eclipse Public License v1.0 which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html Contributors: Martin Taal </copyright> $Id:
 * LazyLibraryAction.java,v 1.9 2007/03/29 15:00:32 mtaal Exp $
 */

package org.eclipse.emf.teneo.test.emf.annotations;

import java.io.IOException;
import java.util.Properties;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.mapping.elist.PersistableEList;
import org.eclipse.emf.teneo.resource.StoreResource;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.Book;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.BookCategory;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.LazyFactory;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.LazyPackage;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.Library;
import org.eclipse.emf.teneo.samples.emf.annotations.lazy.Writer;
import org.eclipse.emf.teneo.test.AbstractTestAction;
import org.eclipse.emf.teneo.test.StoreTestException;
import org.eclipse.emf.teneo.test.stores.TestStore;

/**
 * Tests non-resolving behavior of containment references. Main test is that setTrackingModification
 * does not result in loaded containment elists.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.10 $
 */
public class LazyLibraryAction extends AbstractTestAction {
	/**
	 * Constructor for ClassHierarchyParsing.
	 * 
	 * @param arg0
	 */
	public LazyLibraryAction() {
		super(LazyPackage.eINSTANCE);
	}

	/** Sets USE_EMF_PROXIES to true */
	@Override
	public Properties getExtraConfigurationProperties() {
		final Properties props = new Properties();
		props.setProperty(PersistenceOptions.DISABLE_ECONTAINER_MAPPING, "true");
		return props;
	}

	/** Creates an item, an address and links them to a po. */
	@Override
	public void doAction(TestStore store) {
		final LazyFactory factory = LazyFactory.eINSTANCE;

		// create a book, writer and library
		try {
			{
				Resource res = store.getResource();
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
				res.unload();
			}

			// test settrackingmodification before load
			{
				Resource res = store.getResource();
				// default is false
				// ((StoreResource)res).setAutoResolve(false);
				res.setTrackingModification(true);
				res.load(null);
				testResolving(res);
			}

			// test settrackingmodification after load
			{
				Resource res = store.getResource();
				// default is false
				// ((StoreResource)res).setAutoResolve(false);
				res.load(null);
				res.setTrackingModification(true);
				testResolving(res);
			}

			// test with resolving
			{
				Resource res = store.getResource();
				// default is false
				res.load(null);
				res.setTrackingModification(true);
				testResolving(res);
			}

			// simple test without setTrackingModification
			{
				Resource res = store.getResource();
				res.load(null);

				Library lib = (Library) res.getContents().get(0);
				PersistableEList<?> writers = (PersistableEList<?>) lib.getWriters();
				assertTrue("Elist should be loaded", writers.isLoaded());
			}
		} catch (IOException e) {
			throw new StoreTestException("IOException during save", e);
		}
	}

	/** Check adapters and lazy loading of nonresolving */
	private void testResolving(Resource res) {
		final LibraryAdapter libraryAdapter = new LibraryAdapter();
		res.eAdapters().add(libraryAdapter);

		Library lib = (Library) res.getContents().get(0);
		PersistableEList<?> books = (PersistableEList<?>) lib.getBooks();
		PersistableEList<?> writers = (PersistableEList<?>) lib.getWriters();
		assertTrue("Elist is not loaded while the fetch is eager", writers.isLoaded());
		assertTrue("Elist is not loaded while the fetch is eager", books.isLoaded());
		assertTrue("BasicIterator should have next true", books.basicIterator().hasNext());
		assertTrue("BasicListIterator should have next true", books.basicListIterator().hasNext());
		assertTrue("BasicIterator should have next true", writers.basicIterator().hasNext());
		assertTrue("BasicListIterator should have next true", writers.basicListIterator().hasNext());
		Book book = (Book) books.get(0);
		assertTrue(book.getAuthor().getName() != null);

		Writer writer = (Writer) writers.get(0);
		PersistableEList<?> writerBooks = (PersistableEList<?>) writer.getBooks();
		assertTrue("Books of writers should not be loaded is lazy, but it seems to be eager", !writerBooks.isLoaded());

		lib.setName("test" + lib.getName());

		// change the first book
		book.setTitle("test" + book.getTitle());

		assertEquals(2, libraryAdapter.getCountNotifications());

		EObject[] modifieds = ((StoreResource) res).getModifiedEObjects();
		boolean fndLibrary = false;
		boolean fndBook = false;
		for (EObject element : modifieds) {
			fndLibrary = fndLibrary || element == lib;
			fndBook = fndBook || element == book;
		}
		assertTrue("Library should be a modified object", fndLibrary);
		assertTrue("Book should be a modified object", fndBook);
		assertEquals(2, modifieds.length);
		res.unload();
	}

	/** Small adapter test */
	private class LibraryAdapter extends AdapterImpl {
		/** Counts the number of changes */
		private int countNotifications = 0;

		/**
		 * Returns <code>false</code>
		 * 
		 * @param type
		 *            the type.
		 * @return <code>false</code>
		 */
		@Override
		public boolean isAdapterForType(Object type) {
			return type instanceof Writer;
		}

		/**
		 * Does nothing; clients may override so that it does something.
		 */
		@Override
		public void notifyChanged(Notification msg) {
			countNotifications++;
		}

		/** Returns the number of notifications */
		public int getCountNotifications() {
			return countNotifications;
		}
	}
}