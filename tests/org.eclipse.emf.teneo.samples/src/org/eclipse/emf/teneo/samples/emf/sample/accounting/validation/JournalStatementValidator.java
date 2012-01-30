/**
 * <copyright>
 * </copyright>
 *
 * $Id: JournalStatementValidator.java,v 1.1 2007/02/08 23:09:18 mtaal Exp $
 */
package org.eclipse.emf.teneo.samples.emf.sample.accounting.validation;

import java.util.Date;

import org.eclipse.emf.teneo.samples.emf.sample.accounting.Account;
import org.eclipse.emf.teneo.samples.emf.sample.accounting.Vat;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.samples.emf.sample.accounting.JournalStatement}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface JournalStatementValidator {
	boolean validate();

	boolean validateDescription(String value);
	boolean validateDate(Date value);
	boolean validateAmount(float value);
	boolean validateDebitAccount(Account value);
	boolean validateCreditAccount(Account value);
	boolean validateVat(Vat value);
}