/**
 * <copyright>
 * </copyright>
 *
 * $Id: SomeReferenceValidator.java,v 1.1 2007/03/29 22:13:50 mtaal Exp $
 */
package testinheritance.validation;


/**
 * A sample validator interface for {@link testinheritance.SomeReference}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface SomeReferenceValidator {
	boolean validate();

	boolean validateName(String value);
}
