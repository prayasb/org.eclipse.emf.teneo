/**
 * <copyright>
 * </copyright>
 *
 * $Id: ReportValidator.java,v 1.1 2007/02/08 23:09:18 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.sample.accounting.validation;

import org.eclipse.emf.teneo.samples.emf.sample.accounting.ReportGroup;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.sample.accounting.Report}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface ReportValidator {
	boolean validate();

	boolean validateName(String value);
	boolean validateDebitReportGroup(ReportGroup value);
	boolean validateCreditReportGroup(ReportGroup value);
}
