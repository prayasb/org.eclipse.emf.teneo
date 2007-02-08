/**
 * <copyright>
 * </copyright>
 *
 * $Id: EmbeddableValidator.java,v 1.1 2007/02/08 23:09:22 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.annotations.embedded.validation;


/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.annotations.embedded.Embeddable}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface EmbeddableValidator {
	boolean validate();

	boolean validateMyString(String value);
	boolean validateMyInteger(int value);
}
