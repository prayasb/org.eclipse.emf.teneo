/**
 * <copyright>
 *
 * Copyright (c) 2005, 2006, 2007 Springsite BV (The Netherlands) and others
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Martin Taal - Initial API and implementation
 *
 * </copyright>
 *
 * $Id: Document.java,v 1.4 2007/02/01 12:34:21 mtaal Exp $
 */

package org.eclipse.emf.teneo.simpledom;

import java.util.Date;

/**
 * This simple class is part of the replacement of dom4j.
 * 
 * @author <a href="mailto:mtaal@elver.org">Martin Taal</a>
 * @version $Revision: 1.4 $
 */

public class Document {

	/** The doctype */
	private String docType = "";

	/** Root element */
	private Element root = null;

	/** Set the docType */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/** Set the root */
	public Element setRoot(Element root) {
		this.root = root;
		return root;
	}

	/** Return the root */
	public Element getRoot() {
		return root;
	}

	/** Emit ourselve as a XML string */
	public String emitXML() {
		final StringBuffer result = new StringBuffer("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
		if (docType.length() > 0) result.append(docType + "\n\n");
		result.append("<!--\tGenerated by Teneo on " + new Date() + " -->");
		result.append(root.emitXML());
		return result.toString();
	}
}