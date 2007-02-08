/**
 * <copyright>
 * </copyright>
 *
 * $Id: LetterBodyTypeValidator.java,v 1.1 2007/02/08 23:09:27 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.schemaconstructs.mixed.validation;

import java.math.BigInteger;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.eclipse.emf.teneo.samples.emf.schemaconstructs.mixed.SalutationType;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.schemaconstructs.mixed.LetterBodyType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface LetterBodyTypeValidator {
	boolean validate();

	boolean validateMixed(FeatureMap value);
	boolean validateSalutation(SalutationType value);
	boolean validateQuantity(BigInteger value);
	boolean validateProductName(String value);
	boolean validateShipDate(Object value);
}
