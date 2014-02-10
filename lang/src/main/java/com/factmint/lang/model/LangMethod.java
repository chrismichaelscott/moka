package com.factmint.lang.model;

import java.util.ArrayList;
import java.util.List;

public class LangMethod extends LangMember {

	private String name;
	private Visibility visibility = Visibility.PUBLIC;
	private String returnType;
	private List<LangVariable> arguments = new ArrayList<LangVariable>();
	private boolean isStatic;
	private boolean isFinal;
	private String contents;
	
	public static LangMethod create(String name, Visibility visibility, String returnType, List<LangVariable> arguments, String contents) {
		LangMethod method = new LangMethod();
		
		method.setName(name);
		method.setVisibility(visibility);
		method.setReturnType(returnType);
		method.setArguments(arguments);
		method.setContents(contents);
		
		return method;
	}

	public static LangMethod getDefaultGetter(String name, LangVariable dependency) {
		String content = "\t\treturn " + dependency.getName() + ";";
		return create(name, Visibility.PUBLIC, dependency.getType(), new ArrayList<LangVariable>(), content );
	}

	public static LangMethod getDefaultSetter(String name, LangVariable dependency) {
		String content = "\t\tthis." + dependency.getName() + " = " + dependency.getName() + ";";
		ArrayList<LangVariable> setterArguments = new ArrayList<LangVariable>();
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

	public List<LangVariable> getArguments() {
		return arguments;
	}

	public void setArguments(List<LangVariable> arguments) {
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
