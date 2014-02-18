package com.factmint.moka.compiler.model;

import java.util.ArrayList;
import java.util.List;

public class MokaClass {

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
	 * private constants which are to be statically instantiated
	 */
	private List<MokaConstant> constants = new ArrayList<MokaConstant>();
	
	/**
	 * private fields which are to be set using setters in the DI model
	 */
	private List<MokaVariable> dependencies = new ArrayList<MokaVariable>();
	
	/**
	 * private fields which are to be managed by the class itself
	 */
	private List<MokaVariable> fields = new ArrayList<MokaVariable>();
	
	/**
	 * A list of the methods of the class
	 */
	private List<MokaMethod> methods = new ArrayList<MokaMethod>();
	
	/**
	 * A list of "contruct" methods which will be referenced by contructors
	 */
	private List<MokaMethod> constructors = new ArrayList<MokaMethod>();
	
	/**
	 * A list of explicit Java constructors
	 */
	private List<MokaMethod> explicitConstructors = new ArrayList<MokaMethod>();
	
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
	
	public List<MokaConstant> getConstants() {
		return constants;
	}

	public void setConstants(List<MokaConstant> constants) {
		this.constants = constants;
	}
	
	public List<MokaVariable> getDependencies() {
		return dependencies;
	}
	
	public void setDependencies(List<MokaVariable> dependencies) {
		this.dependencies = dependencies;
	}
	
	public List<MokaVariable> getFields() {
		return fields;
	}
	
	public void setFields(List<MokaVariable> fields) {
		this.fields = fields;
	}

	public List<MokaMethod> getMethods() {
		return methods;
	}
	
	public void setMethods(List<MokaMethod> methods) {
		this.methods = methods;
	}
	
	public List<MokaMethod> getConstructors() {
		return constructors;
	}
	
	public void setConstructors(List<MokaMethod> constructors) {
		this.constructors = constructors;
	}

	public List<MokaMethod> getExplicitConstructors() {
		return explicitConstructors;
	}

	public void setExplicitConstructors(List<MokaMethod> explicitConstructors) {
		this.explicitConstructors = explicitConstructors;
	}

	public boolean containsMethodWithMatchingSignature(MokaMethod other) {
		for (MokaMethod method : getMethods()) {
			if (! method.getReturnType().equals(other.getReturnType())) {
				continue;
			}
			
			if (method.getArguments().size() != other.getArguments().size()) {
				continue;
			}
			
			boolean match = true;
			for (int x = 0; x < method.getArguments().size(); x++) {
				if (! method.getArguments().get(x).getType().equals(other.getArguments().get(x).getType())) {
					match = false;
					break;
				}
			}
			
			if (match) {
				return true;
			}
		}
		
		return false;
	}
	
}
