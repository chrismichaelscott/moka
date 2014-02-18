package com.factmint.moka.compiler.model;

public class MokaVariable {
	
	private String type;
	private String name;
	
	public static MokaVariable create(String type, String name) {
		MokaVariable variable = new MokaVariable();
		
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
	
	@Override
	public boolean equals(Object other) {
		if (! (other instanceof MokaMethodVariable)) {
			return false;
		}
		
		MokaMethodVariable otherMokaMethodVariable = (MokaMethodVariable) other;
		
		return 
				otherMokaMethodVariable.getName().equals(getName()) &&
				otherMokaMethodVariable.getType().equals(getType());
	}

}
