/**
 */
package com.factmint.moka.eclipse.xtext.mokaDSL;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Method Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getVariable <em>Variable</em>}</li>
 *   <li>{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getDefault <em>Default</em>}</li>
 * </ul>
 * </p>
 *
 * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethodVariable()
 * @model
 * @generated
 */
public interface MethodVariable extends EObject
{
  /**
   * Returns the value of the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Variable</em>' containment reference.
   * @see #setVariable(Variable)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethodVariable_Variable()
   * @model containment="true"
   * @generated
   */
  Variable getVariable();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getVariable <em>Variable</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Variable</em>' containment reference.
   * @see #getVariable()
   * @generated
   */
  void setVariable(Variable value);

  /**
   * Returns the value of the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Default</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Default</em>' containment reference.
   * @see #setDefault(DefaultValue)
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLPackage#getMethodVariable_Default()
   * @model containment="true"
   * @generated
   */
  DefaultValue getDefault();

  /**
   * Sets the value of the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getDefault <em>Default</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Default</em>' containment reference.
   * @see #getDefault()
   * @generated
   */
  void setDefault(DefaultValue value);

} // MethodVariable
