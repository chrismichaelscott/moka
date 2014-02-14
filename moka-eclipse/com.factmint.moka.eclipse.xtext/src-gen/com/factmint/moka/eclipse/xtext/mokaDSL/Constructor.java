/**
 */
package com.factmint.moka.eclipse.xtext.mokaDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constructor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getConstructorArgs <em>Constructor Args</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getConstructor()
 * @model
 * @generated
 */
public interface Constructor extends Element
{
  /**
   * Returns the value of the '<em><b>Visibility</b></em>' attribute.
   * The literals are from the enumeration {@link com.factmint.moka.eclipse.xtext.mokaDSL.Visibility}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Visibility</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Visibility</em>' attribute.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
   * @see #setVisibility(Visibility)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getConstructor_Visibility()
   * @model
   * @generated
   */
  Visibility getVisibility();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(Visibility value);

  /**
   * Returns the value of the '<em><b>Constructor Args</b></em>' containment reference list.
   * The list contents are of type {@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Constructor Args</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Constructor Args</em>' containment reference list.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getConstructor_ConstructorArgs()
   * @model containment="true"
   * @generated
   */
  EList<MethodVariable> getConstructorArgs();

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference.
   * @see #setBody(XExpression)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getConstructor_Body()
   * @model containment="true"
   * @generated
   */
  XExpression getBody();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XExpression value);

} // Constructor
