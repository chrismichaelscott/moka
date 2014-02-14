/**
 */
package com.factmint.moka.eclipse.xtext.mokaDSL;

import org.eclipse.emf.common.util.EList;

import org.eclipse.xtext.common.types.JvmTypeReference;

import org.eclipse.xtext.xbase.XExpression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isStatic <em>Static</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isFinal <em>Final</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getVisibility <em>Visibility</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getReturnType <em>Return Type</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getName <em>Name</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getConstructorArgs <em>Constructor Args</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod()
 * @model
 * @generated
 */
public interface Method extends Element
{
  /**
   * Returns the value of the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Static</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Static</em>' attribute.
   * @see #setStatic(boolean)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_Static()
   * @model
   * @generated
   */
  boolean isStatic();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isStatic <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Static</em>' attribute.
   * @see #isStatic()
   * @generated
   */
  void setStatic(boolean value);

  /**
   * Returns the value of the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Final</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Final</em>' attribute.
   * @see #setFinal(boolean)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_Final()
   * @model
   * @generated
   */
  boolean isFinal();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isFinal <em>Final</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Final</em>' attribute.
   * @see #isFinal()
   * @generated
   */
  void setFinal(boolean value);

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
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_Visibility()
   * @model
   * @generated
   */
  Visibility getVisibility();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getVisibility <em>Visibility</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Visibility</em>' attribute.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
   * @see #getVisibility()
   * @generated
   */
  void setVisibility(Visibility value);

  /**
   * Returns the value of the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Return Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Return Type</em>' containment reference.
   * @see #setReturnType(JvmTypeReference)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_ReturnType()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getReturnType();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getReturnType <em>Return Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Return Type</em>' containment reference.
   * @see #getReturnType()
   * @generated
   */
  void setReturnType(JvmTypeReference value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

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
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_ConstructorArgs()
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
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethod_Body()
   * @model containment="true"
   * @generated
   */
  XExpression getBody();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getBody <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Body</em>' containment reference.
   * @see #getBody()
   * @generated
   */
  void setBody(XExpression value);

} // Method
