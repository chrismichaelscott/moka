/**
 */
package com.factmint.moka.eclipse.xtext.mokaDSL;

import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.common.types.JvmTypeReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getType <em>Type</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getVariable()
 * @model
 * @generated
 */
public interface Variable extends EObject
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(JvmTypeReference)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getVariable_Type()
   * @model containment="true"
   * @generated
   */
  JvmTypeReference getType();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(JvmTypeReference value);

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
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getVariable_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

} // Variable
