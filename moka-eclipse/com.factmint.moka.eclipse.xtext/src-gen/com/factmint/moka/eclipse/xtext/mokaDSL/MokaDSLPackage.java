/**
 */
package com.factmint.moka.eclipse.xtext.mokaDSL;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see com.factmint.moka.eclipse.xtext.mokaDSL.MokaDSLFactory
 * @model kind="package"
 * @generated
 */
public interface MokaDSLPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mokaDSL";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.factmint.com/moka/eclipse/xtext/MokaDSL";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mokaDSL";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MokaDSLPackage eINSTANCE = com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl.init();

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ModelImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The feature id for the '<em><b>Import Section</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__IMPORT_SECTION = 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL__ELEMENTS = 1;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ElementImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getElement()
   * @generated
   */
  int ELEMENT = 1;

  /**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.DependencyImpl <em>Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.DependencyImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getDependency()
   * @generated
   */
  int DEPENDENCY = 2;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY__VARIABLE = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.FieldImpl <em>Field</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.FieldImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getField()
   * @generated
   */
  int FIELD = 3;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD__VARIABLE = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Field</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FIELD_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstantImpl <em>Constant</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstantImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getConstant()
   * @generated
   */
  int CONSTANT = 4;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__TYPE = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__NAME = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT__BODY = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constant</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTANT_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstructorImpl <em>Constructor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstructorImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getConstructor()
   * @generated
   */
  int CONSTRUCTOR = 5;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR__VISIBILITY = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Constructor Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR__CONSTRUCTOR_ARGS = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR__BODY = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constructor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodImpl <em>Method</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getMethod()
   * @generated
   */
  int METHOD = 6;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__STATIC = ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Final</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__FINAL = ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Visibility</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__VISIBILITY = ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Return Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__RETURN_TYPE = ELEMENT_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__NAME = ELEMENT_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Constructor Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__CONSTRUCTOR_ARGS = ELEMENT_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD__BODY = ELEMENT_FEATURE_COUNT + 6;

  /**
   * The number of structural features of the '<em>Method</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_FEATURE_COUNT = ELEMENT_FEATURE_COUNT + 7;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.VariableImpl <em>Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.VariableImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getVariable()
   * @generated
   */
  int VARIABLE = 7;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__TYPE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE__NAME = 1;

  /**
   * The number of structural features of the '<em>Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodVariableImpl <em>Method Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodVariableImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getMethodVariable()
   * @generated
   */
  int METHOD_VARIABLE = 8;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_VARIABLE__VARIABLE = 0;

  /**
   * The feature id for the '<em><b>Default</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_VARIABLE__DEFAULT = 1;

  /**
   * The number of structural features of the '<em>Method Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int METHOD_VARIABLE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.DefaultValueImpl <em>Default Value</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.DefaultValueImpl
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getDefaultValue()
   * @generated
   */
  int DEFAULT_VALUE = 9;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_VALUE__VALUE = 0;

  /**
   * The number of structural features of the '<em>Default Value</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_VALUE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Visibility <em>Visibility</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getVisibility()
   * @generated
   */
  int VISIBILITY = 10;


  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Model#getImportSection <em>Import Section</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Import Section</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Model#getImportSection()
   * @see #getModel()
   * @generated
   */
  EReference getModel_ImportSection();

  /**
   * Returns the meta object for the containment reference list '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Model#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Model#getElements()
   * @see #getModel()
   * @generated
   */
  EReference getModel_Elements();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Element <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Element
   * @generated
   */
  EClass getElement();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Dependency <em>Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dependency</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Dependency
   * @generated
   */
  EClass getDependency();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Dependency#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Dependency#getVariable()
   * @see #getDependency()
   * @generated
   */
  EReference getDependency_Variable();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Field <em>Field</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Field</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Field
   * @generated
   */
  EClass getField();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Field#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Field#getVariable()
   * @see #getField()
   * @generated
   */
  EReference getField_Variable();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constant</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constant
   * @generated
   */
  EClass getConstant();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getType()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Type();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getName()
   * @see #getConstant()
   * @generated
   */
  EAttribute getConstant_Name();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constant#getBody()
   * @see #getConstant()
   * @generated
   */
  EReference getConstant_Body();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor <em>Constructor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constructor
   * @generated
   */
  EClass getConstructor();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getVisibility()
   * @see #getConstructor()
   * @generated
   */
  EAttribute getConstructor_Visibility();

  /**
   * Returns the meta object for the containment reference list '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getConstructorArgs <em>Constructor Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constructor Args</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getConstructorArgs()
   * @see #getConstructor()
   * @generated
   */
  EReference getConstructor_ConstructorArgs();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Constructor#getBody()
   * @see #getConstructor()
   * @generated
   */
  EReference getConstructor_Body();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method <em>Method</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method
   * @generated
   */
  EClass getMethod();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#isStatic()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Static();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#isFinal <em>Final</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Final</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#isFinal()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Final();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getVisibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Visibility</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#getVisibility()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Visibility();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getReturnType <em>Return Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Return Type</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#getReturnType()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_ReturnType();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#getName()
   * @see #getMethod()
   * @generated
   */
  EAttribute getMethod_Name();

  /**
   * Returns the meta object for the containment reference list '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getConstructorArgs <em>Constructor Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Constructor Args</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#getConstructorArgs()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_ConstructorArgs();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Method#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Method#getBody()
   * @see #getMethod()
   * @generated
   */
  EReference getMethod_Body();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Variable
   * @generated
   */
  EClass getVariable();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getType()
   * @see #getVariable()
   * @generated
   */
  EReference getVariable_Type();

  /**
   * Returns the meta object for the attribute '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Variable#getName()
   * @see #getVariable()
   * @generated
   */
  EAttribute getVariable_Name();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable <em>Method Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Method Variable</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable
   * @generated
   */
  EClass getMethodVariable();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Variable</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getVariable()
   * @see #getMethodVariable()
   * @generated
   */
  EReference getMethodVariable_Variable();

  /**
   * Returns the meta object for the containment reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getDefault <em>Default</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Default</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.MethodVariable#getDefault()
   * @see #getMethodVariable()
   * @generated
   */
  EReference getMethodVariable_Default();

  /**
   * Returns the meta object for class '{@link com.factmint.moka.eclipse.xtext.mokaDSL.DefaultValue <em>Default Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Default Value</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.DefaultValue
   * @generated
   */
  EClass getDefaultValue();

  /**
   * Returns the meta object for the reference '{@link com.factmint.moka.eclipse.xtext.mokaDSL.DefaultValue#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.DefaultValue#getValue()
   * @see #getDefaultValue()
   * @generated
   */
  EReference getDefaultValue_Value();

  /**
   * Returns the meta object for enum '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Visibility <em>Visibility</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Visibility</em>'.
   * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
   * @generated
   */
  EEnum getVisibility();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  MokaDSLFactory getMokaDSLFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ModelImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '<em><b>Import Section</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__IMPORT_SECTION = eINSTANCE.getModel_ImportSection();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODEL__ELEMENTS = eINSTANCE.getModel_Elements();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ElementImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getElement()
     * @generated
     */
    EClass ELEMENT = eINSTANCE.getElement();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.DependencyImpl <em>Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.DependencyImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getDependency()
     * @generated
     */
    EClass DEPENDENCY = eINSTANCE.getDependency();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY__VARIABLE = eINSTANCE.getDependency_Variable();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.FieldImpl <em>Field</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.FieldImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getField()
     * @generated
     */
    EClass FIELD = eINSTANCE.getField();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FIELD__VARIABLE = eINSTANCE.getField_Variable();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstantImpl <em>Constant</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstantImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getConstant()
     * @generated
     */
    EClass CONSTANT = eINSTANCE.getConstant();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__TYPE = eINSTANCE.getConstant_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTANT__NAME = eINSTANCE.getConstant_Name();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTANT__BODY = eINSTANCE.getConstant_Body();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstructorImpl <em>Constructor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.ConstructorImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getConstructor()
     * @generated
     */
    EClass CONSTRUCTOR = eINSTANCE.getConstructor();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR__VISIBILITY = eINSTANCE.getConstructor_Visibility();

    /**
     * The meta object literal for the '<em><b>Constructor Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR__CONSTRUCTOR_ARGS = eINSTANCE.getConstructor_ConstructorArgs();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR__BODY = eINSTANCE.getConstructor_Body();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodImpl <em>Method</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getMethod()
     * @generated
     */
    EClass METHOD = eINSTANCE.getMethod();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__STATIC = eINSTANCE.getMethod_Static();

    /**
     * The meta object literal for the '<em><b>Final</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__FINAL = eINSTANCE.getMethod_Final();

    /**
     * The meta object literal for the '<em><b>Visibility</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__VISIBILITY = eINSTANCE.getMethod_Visibility();

    /**
     * The meta object literal for the '<em><b>Return Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__RETURN_TYPE = eINSTANCE.getMethod_ReturnType();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute METHOD__NAME = eINSTANCE.getMethod_Name();

    /**
     * The meta object literal for the '<em><b>Constructor Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__CONSTRUCTOR_ARGS = eINSTANCE.getMethod_ConstructorArgs();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD__BODY = eINSTANCE.getMethod_Body();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.VariableImpl <em>Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.VariableImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getVariable()
     * @generated
     */
    EClass VARIABLE = eINSTANCE.getVariable();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE__TYPE = eINSTANCE.getVariable_Type();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE__NAME = eINSTANCE.getVariable_Name();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodVariableImpl <em>Method Variable</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MethodVariableImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getMethodVariable()
     * @generated
     */
    EClass METHOD_VARIABLE = eINSTANCE.getMethodVariable();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_VARIABLE__VARIABLE = eINSTANCE.getMethodVariable_Variable();

    /**
     * The meta object literal for the '<em><b>Default</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference METHOD_VARIABLE__DEFAULT = eINSTANCE.getMethodVariable_Default();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.impl.DefaultValueImpl <em>Default Value</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.DefaultValueImpl
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getDefaultValue()
     * @generated
     */
    EClass DEFAULT_VALUE = eINSTANCE.getDefaultValue();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFAULT_VALUE__VALUE = eINSTANCE.getDefaultValue_Value();

    /**
     * The meta object literal for the '{@link com.factmint.moka.eclipse.xtext.mokaDSL.Visibility <em>Visibility</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.Visibility
     * @see com.factmint.moka.eclipse.xtext.mokaDSL.impl.MokaDSLPackageImpl#getVisibility()
     * @generated
     */
    EEnum VISIBILITY = eINSTANCE.getVisibility();

  }

} //MokaDSLPackage
