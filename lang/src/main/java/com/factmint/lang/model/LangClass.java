package com.factmint.lang.model;

import java.util.ArrayList;
import java.util.List;

public class LangClass {

	private String name;
	private List<String> imports = new ArrayList<String>();
	private List<String> implementedInerfaces = new ArrayList<String>();
	private String superClass = "Object";
	private List<LangVariable> dependencies = new ArrayList<LangVariable>();
	private List<LangVariable> fields = new ArrayList<LangVariable>();
	private List<LangMethod> methods = new ArrayList<LangMethod>();
	private List<LangMethod> constructors = new ArrayList<LangMethod>();
	
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
	
	public List<String> getImplementedInerfaces() {
		return implementedInerfaces;
	}
	
	public void setImplementedInerfaces(List<String> implementedInerfaces) {
		this.implementedInerfaces = implementedInerfaces;
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
	
}
