/**
 * <copyright>
 * </copyright>
 *
 * $Id: PersonaeTypeValidator.java,v 1.1 2007/02/08 23:09:24 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.sample.play.validation;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.util.FeatureMap;

import org.eclipse.emf.teneo.samples.emf.sample.play.PersonaGroupType;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.sample.play.PersonaeType}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface PersonaeTypeValidator {
	boolean validate();

	boolean validateGroup(FeatureMap value);
	boolean validateTitle(EList<String> value);
	boolean validatePersona(EList<String> value);
	boolean validatePersonaGroup(EList<PersonaGroupType> value);
}
