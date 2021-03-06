/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007, 2008, 2010 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal
 * </copyright>
 *
 * $Id: LibraryEAVAction.java,v 1.4 2010/10/31 22:09:12 mtaal Exp $
 */

package org.eclipse.emf.teneo.hibernate.test.emf.sample;

import java.util.List;
import java.util.Properties;

import org.eclipse.emf.teneo.PersistenceOptions;
import org.eclipse.emf.teneo.hibernate.HbUtil;
import org.eclipse.emf.teneo.hibernate.LazyCollectionUtils;
import org.eclipse.emf.teneo.hibernate.test.stores.HibernateTestStore;
import org.eclipse.emf.teneo.mapping.elist.PersistableDelegateList;
import org.eclipse.emf.teneo.samples.emf.sample.library.Book;
import org.eclipse.emf.teneo.samples.emf.sample.library.BookCategory;
import org.eclipse.emf.teneo.samples.emf.sample.library.Library;
import org.eclipse.emf.teneo.samples.emf.sample.library.LibraryFactory;
import org.eclipse.emf.teneo.samples.emf.sample.library.LibraryPackage;
import org.eclipse.emf.teneo.samples.emf.sample.library.Writer;
import org.eclipse.emf.teneo.test.AbstractTestAction;
import org.eclipse.emf.teneo.test.stores.TestStore;
import org.hibernate.collection.PersistentCollection;

/**
 * Tests the library example of emf/xsd using eav.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.4 $
 */
public class LibraryEAVAction extends AbstractTestAction {

	public LibraryEAVAction() {
		super(LibraryPackage.eINSTANCE);
	}

	@Override
	public Properties getExtraConfigurationProperties() {
		final Properties props = new Properties();
		props.setProperty(PersistenceOptions.EAV_MAPPING, "true");
		return props;
	}

	@Override
	public void doAction(TestStore store) {
		final LibraryFactory factory = LibraryFactory.eINSTANCE;

		// create a book, writer and library
		{
			store.beginTransaction();

			final Writer writer = factory.createWriter();
			writer.setName("JRR Tolkien");

			final Book book = factory.createBook();

			book.setAuthor(writer);
			book.setPages(5);
			book.setTitle("The Hobbit");
			book.setCategory(BookCategory.SCIENCE_FICTION_LITERAL);

			final Book book2 = factory.createBook();
			book2.setAuthor(writer);
			book2.setPages(5);
			book2.setTitle("The fellowship of the ring");
			book2.setCategory(BookCategory.SCIENCE_FICTION_LITERAL);

			final Library library = factory.createLibrary();
			library.getBooks().add(book);
			library.setName("Science Fiction Library");
			library.getBooks().add(book2);
			library.getWriters().add(writer);
			store.store(library);

			store.commitTransaction();
			assertEquals(2, writer.getBooks().size());
		}

		// walk through the structure starting from the library
		{
			store.beginTransaction();
			Library lib = store.getObjects(Library.class).get(0);

			testLazySize(lib.getWriters());
			testLazySize(lib.getBooks());

			assertTrue((lib.getWriters().get(0)).getName().compareTo(
					"JRR Tolkien") == 0);
			testLazySize(lib.getWriters().get(0).getBooks());

			// final Object[] eobjs =
			// store.getCrossReferencers((EObject)lib.getWriters().get(0),
			// false);

			// these two books should be the same as this book is the first in
			// the writers
			// collection
			// and in the library collection
			Book wBook = (lib.getWriters().get(0)).getBooks().get(0);
			Book lBook = lib.getBooks().get(0);

			// check container
			assertTrue(lBook.eContainer() == lib);

			assertTrue(wBook.getTitle().compareTo(lBook.getTitle()) == 0);
			assertTrue(wBook.getPages() == lBook.getPages());
			assertTrue(wBook.getCategory() instanceof BookCategory);
			assertTrue(wBook.getCategory().equals(BookCategory.SCIENCE_FICTION_LITERAL));
			store.commitTransaction();
		}
		testMerge(store);
	}
	
	protected void testMerge(TestStore store) {

		{
			store.beginTransaction();
			Library lib = store.getObjects(Library.class).get(0);
			Book bk = lib.getBooks().get(0);
			lib.setName("test123");
			bk.setPages(5000);
			for (Writer w : lib.getWriters()) {
				w.getBooks().size();
			}
			store.commitTransaction();

			// now do merge
			store.beginTransaction();
			final Library lib2 = (Library)HbUtil.merge(((HibernateTestStore)store).getSession(), lib, 3);
			assertTrue(lib2 != lib);
			assertTrue(lib2.getName().equals(lib.getName()));
			assertTrue(lib2.getBooks().get(0) != bk);
			assertTrue(lib2.getBooks().get(0).getTitle().equals(bk.getTitle()));
			assertTrue(lib2.getBooks().get(0).getPages() == bk.getPages());
			store.commitTransaction();
			
			store.beginTransaction();
			Library lib3 = store.getObjects(Library.class).get(0);
			assertTrue(lib3.getName().equals(lib.getName()));
			store.commitTransaction();
		}

	}

	protected void testLazySize(List<?> list) {
		final PersistableDelegateList<?> persistableEList = (PersistableDelegateList<?>)list;
		final PersistentCollection persistentCollection = (PersistentCollection)persistableEList.getDelegate();
		assertFalse(persistentCollection.wasInitialized());
		assertFalse(persistableEList.isLoaded());
		int size = LazyCollectionUtils.size(list);
		assertTrue(size > 0);
		assertFalse(persistentCollection.wasInitialized());
		assertFalse(persistableEList.isLoaded());
	}

}
