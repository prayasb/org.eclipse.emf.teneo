/**
 * <copyright>
 * </copyright>
 *
 * $Id: CarFrameValidator.java,v 1.1 2007/08/10 20:17:32 mtaal Exp $
 */
package com.example.car.validation;

import com.example.car.CarLink;
import com.example.car.CarWheel;

import org.eclipse.emf.common.util.EList;

/**
 * A sample validator interface for {@link com.example.car.CarFrame}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface CarFrameValidator {
	boolean validate();

	boolean validateCarWheel(EList<CarWheel> value);
	boolean validateCarLinkRef(CarLink value);
	boolean validateName(String value);
}
