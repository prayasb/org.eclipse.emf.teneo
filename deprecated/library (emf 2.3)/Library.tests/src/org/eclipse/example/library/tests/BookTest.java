/**
 * <copyright>
 * </copyright>
 *
 * $Id: BookTest.java,v 1.1 2008/04/01 07:32:44 mtaal Exp $
 */
package org.eclipse.example.library.tests;

import junit.framework.TestCase;

import junit.textui.TestRunner;

import org.eclipse.example.library.Book;
import org.eclipse.example.library.LibraryFactory;

/**
 * <!-- begin-user-doc -->
 * A test case for the model object '<em><b>Book</b></em>'.
 * <!-- end-user-doc -->
 * @generated
 */
public class BookTest extends TestCase {

	/**
	 * The fixture for this Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Book fixture = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static void main(String[] args) {
		TestRunner.run(BookTest.class);
	}

	/**
	 * Constructs a new Book test case with the given name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BookTest(String name) {
		super(name);
	}

	/**
	 * Sets the fixture for this Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void setFixture(Book fixture) {
		this.fixture = fixture;
	}

	/**
	 * Returns the fixture for this Book test case.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private Book getFixture() {
		return fixture;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#setUp()
	 * @generated
	 */
	protected void setUp() throws Exception {
		setFixture(LibraryFactory.eINSTANCE.createBook());
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see junit.framework.TestCase#tearDown()
	 * @generated
	 */
	protected void tearDown() throws Exception {
		setFixture(null);
	}

} //BookTest