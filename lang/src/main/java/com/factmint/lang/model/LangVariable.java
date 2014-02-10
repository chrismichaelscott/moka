package com.factmint.lang.model;

public class LangVariable {
	
	private String type;
	private String name;
	
	public static LangVariable create(String type, String name) {
		LangVariable variable = new LangVariable();
		
		variable.setType(type);
		variable.setName(name);
		
		return variable;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
