package com.factmint.lang.model;

import java.util.ArrayList;
import java.util.List;

public class LangClass {

	/**
	 * The class name - inferred from the file name
	 */
	private String name;
	
	/**
	 * The list of imports required for the class
	 */
	private List<String> imports = new ArrayList<String>();
	
	/**
	 * A list of implemented interfaces
	 */
	private List<String> implementedInterfaces = new ArrayList<String>();
	
	/**
	 * The class, if any, that is extended
	 */
	private String superClass = "Object";
	
	/**
	 * private fields which are to be set using setters in the DI model
	 */
	private List<LangVariable> dependencies = new ArrayList<LangVariable>();
	
	/**
	 * private fields which are to be managed by the class itself
	 */
	private List<LangVariable> fields = new ArrayList<LangVariable>();
	
	/**
	 * A list of the methods of the class
	 */
	private List<LangMethod> methods = new ArrayList<LangMethod>();
	
	/**
	 * A list of "contruct" methods which will be referenced by contructors
	 */
	private List<LangMethod> constructors = new ArrayList<LangMethod>();
	
	/**
	 * A list of explicit Java constructors
	 */
	private List<LangMethod> explicitConstructors = new ArrayList<LangMethod>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getImports() {
		return imports;
	}
	
	public void setImports(List<String> imports) {
		this.imports = imports;
	}
	
	public List<String> getImplementedInterfaces() {
		return implementedInterfaces;
	}
	
	public void setImplementedInterfaces(List<String> implementedInterfaces) {
		this.implementedInterfaces = implementedInterfaces;
	}
	
	public String getSuperClass() {
		return superClass;
	}
	
	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}
	
	public List<LangVariable> getDependencies() {
		return dependencies;
	}
	
	public void setDependencies(List<LangVariable> dependencies) {
		this.dependencies = dependencies;
	}
	
	public List<LangVariable> getFields() {
		return fields;
	}
	
	public void setFields(List<LangVariable> fields) {
		this.fields = fields;
	}
	
	public List<LangMethod> getMethods() {
		return methods;
	}
	
	public void setMethods(List<LangMethod> methods) {
		this.methods = methods;
	}
	
	public List<LangMethod> getConstructors() {
		return constructors;
	}
	
	public void setConstructors(List<LangMethod> constructors) {
		this.constructors = constructors;
	}

	public List<LangMethod> getExplicitConstructors() {
		return explicitConstructors;
	}

	public void setExplicitConstructors(List<LangMethod> explicitConstructors) {
		this.explicitConstructors = explicitConstructors;
	}
	
}
