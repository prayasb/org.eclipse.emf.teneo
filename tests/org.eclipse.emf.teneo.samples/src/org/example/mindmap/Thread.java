/**
 * <copyright>
 * </copyright>
 *
 * $Id: Thread.java,v 1.1 2006/11/23 06:12:14 mtaal Exp $
 */
package org.example.mindmap;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Thread</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.example.mindmap.Thread#getItems <em>Items</em>}</li>
 *   <li>{@link org.example.mindmap.Thread#getAuthor <em>Author</em>}</li>
 *   <li>{@link org.example.mindmap.Thread#getPostDate <em>Post Date</em>}</li>
 *   <li>{@link org.example.mindmap.Thread#getSubject <em>Subject</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.example.mindmap.MindmapPackage#getThread()
 * @model extendedMetaData="name='Thread' kind='elementOnly'"
 * @generated
 */
public interface Thread extends EObject {
	/**
	 * Returns the value of the '<em><b>Items</b></em>' containment reference list.
	 * The list contents are of type {@link org.example.mindmap.ThreadItem}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Items</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Items</em>' containment reference list.
	 * @see org.example.mindmap.MindmapPackage#getThread_Items()
	 * @model type="org.example.mindmap.ThreadItem" containment="true"
	 *        extendedMetaData="kind='element' name='items'"
	 * @generated
	 */
	EList getItems();

	/**
	 * Returns the value of the '<em><b>Author</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.example.mindmap.Resource#getComments <em>Comments</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' reference.
	 * @see #setAuthor(Resource)
	 * @see org.example.mindmap.MindmapPackage#getThread_Author()
	 * @see org.example.mindmap.Resource#getComments
	 * @model opposite="comments"
	 *        extendedMetaData="kind='attribute' name='author'"
	 * @generated
	 */
	Resource getAuthor();

	/**
	 * Sets the value of the '{@link org.example.mindmap.Thread#getAuthor <em>Author</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' reference.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(Resource value);

	/**
	 * Returns the value of the '<em><b>Post Date</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Date</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Date</em>' attribute.
	 * @see #setPostDate(Object)
	 * @see org.example.mindmap.MindmapPackage#getThread_PostDate()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.Date"
	 *        extendedMetaData="kind='attribute' name='postDate'"
	 * @generated
	 */
	Object getPostDate();

	/**
	 * Sets the value of the '{@link org.example.mindmap.Thread#getPostDate <em>Post Date</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Post Date</em>' attribute.
	 * @see #getPostDate()
	 * @generated
	 */
	void setPostDate(Object value);

	/**
	 * Returns the value of the '<em><b>Subject</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subject</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject</em>' attribute.
	 * @see #setSubject(String)
	 * @see org.example.mindmap.MindmapPackage#getThread_Subject()
	 * @model unique="false" dataType="org.eclipse.emf.ecore.xml.type.String"
	 *        extendedMetaData="kind='attribute' name='subject'"
	 * @generated
	 */
	String getSubject();

	/**
	 * Sets the value of the '{@link org.example.mindmap.Thread#getSubject <em>Subject</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Subject</em>' attribute.
	 * @see #getSubject()
	 * @generated
	 */
	void setSubject(String value);

} // Thread