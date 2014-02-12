package com.factmint.moka.compiler.model;

import java.util.ArrayList;
import java.util.List;

public class MokaMethod extends MokaMember {

	private String name;
	private Visibility visibility = Visibility.PUBLIC;
	private String returnType;
	private List<MokaVariable> arguments = new ArrayList<MokaVariable>();
	private boolean isStatic;
	private boolean isFinal;
	private String contents;
	
	public static MokaMethod create(String name, Visibility visibility, String returnType, List<MokaVariable> arguments, String contents) {
		MokaMethod method = new MokaMethod();
		
		method.setName(name);
		method.setVisibility(visibility);
		method.setReturnType(returnType);
		method.setArguments(arguments);
		method.setContents(contents);
		
		return method;
	}

	public static MokaMethod getDefaultGetter(String name, MokaVariable dependency) {
		String content = "\t\treturn " + dependency.getName() + ";";
		return create(name, Visibility.PUBLIC, dependency.getType(), new ArrayList<MokaVariable>(), content );
	}

	public static MokaMethod getDefaultSetter(String name, MokaVariable dependency) {
		String content = "\t\tthis." + dependency.getName() + " = " + dependency.getName() + ";";
		ArrayList<MokaVariable> setterArguments = new ArrayList<MokaVariable>();
		setterArguments.add(dependency);
		return create(name, Visibility.PUBLIC, void.class.getName(), setterArguments, content );
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Visibility getVisibility() {
		return visibility;
	}

	public void setVisibility(Visibility visibility) {
		this.visibility = visibility;
	}

	public String getReturnType() {
		return returnType;
	}

	public void setReturnType(String returnType) {
		this.returnType = returnType;
	}

	public List<MokaVariable> getArguments() {
		return arguments;
	}

	public void setArguments(List<MokaVariable> arguments) {
		this.arguments = arguments;
	}

	public boolean isStatic() {
		return isStatic;
	}

	public void setStatic(boolean isStatic) {
		this.isStatic = isStatic;
	}

	public boolean isFinal() {
		return isFinal;
	}

	public void setFinal(boolean isFinal) {
		this.isFinal = isFinal;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
