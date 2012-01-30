/**
 * <copyright>
 * </copyright>
 *
 * $Id: MappedSuperclassValidator.java,v 1.1 2009/07/23 11:16:29 mtaal Exp $
 */
package org.eclipse.emf.teneo.jpa.orm.validation;

import org.eclipse.emf.teneo.jpa.orm.AccessType;
import org.eclipse.emf.teneo.jpa.orm.Attributes;
import org.eclipse.emf.teneo.jpa.orm.EmptyType;
import org.eclipse.emf.teneo.jpa.orm.EntityListeners;
import org.eclipse.emf.teneo.jpa.orm.IdClass;
import org.eclipse.emf.teneo.jpa.orm.PostLoad;
import org.eclipse.emf.teneo.jpa.orm.PostPersist;
import org.eclipse.emf.teneo.jpa.orm.PostRemove;
import org.eclipse.emf.teneo.jpa.orm.PostUpdate;
import org.eclipse.emf.teneo.jpa.orm.PrePersist;
import org.eclipse.emf.teneo.jpa.orm.PreRemove;
import org.eclipse.emf.teneo.jpa.orm.PreUpdate;

/**
 * A sample validator interface for {@link org.eclipse.emf.teneo.jpa.orm.MappedSuperclass}.
 * This doesn't really do anything, and it's not a real EMF artifact.
 * It was generated by the org.eclipse.emf.examples.generator.validator plug-in to illustrate how EMF's code generator can be extended.
 * This can be disabled with -vmargs -Dorg.eclipse.emf.examples.generator.validator=false.
 */
public interface MappedSuperclassValidator {
	boolean validate();

	boolean validateDescription(String value);
	boolean validateIdClass(IdClass value);
	boolean validateExcludeDefaultListeners(EmptyType value);
	boolean validateExcludeSuperclassListeners(EmptyType value);
	boolean validateEntityListeners(EntityListeners value);
	boolean validatePrePersist(PrePersist value);
	boolean validatePostPersist(PostPersist value);
	boolean validatePreRemove(PreRemove value);
	boolean validatePostRemove(PostRemove value);
	boolean validatePreUpdate(PreUpdate value);
	boolean validatePostUpdate(PostUpdate value);
	boolean validatePostLoad(PostLoad value);
	boolean validateAttributes(Attributes value);
	boolean validateAccess(AccessType value);
	boolean validateClass(String value);
	boolean validateMetadataComplete(boolean value);
}