/**
 * <copyright>
 * </copyright>
 *
 * $Id: BookValidator.java,v 1.1 2007/03/18 19:19:26 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.mapkey.validation;

import org.eclipse.emf.common.util.EMap;

import org.eclipse.emf.teneo.samples.emf.annotations.mapkey.Writer;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.annotations.mapkey.Book}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface BookValidator {
	boolean validate();

	boolean validateTitle(String value);
	boolean validateWriters(EMap<String, Writer> value);
}