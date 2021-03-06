/**
 * <copyright>
 * </copyright>
 *
 * $Id: RentalCarValidator.java,v 1.1 2007/03/07 23:34:08 mtaal Exp $
 */
package org.eclipse.emf.teneo.rental.validation;

import org.eclipse.emf.teneo.rental.RentalCarSize;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.rental.RentalCar}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface RentalCarValidator {
	boolean validate();

	boolean validateSize(RentalCarSize value);
}
