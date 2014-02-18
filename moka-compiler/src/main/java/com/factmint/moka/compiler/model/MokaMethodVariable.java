package com.factmint.moka.compiler.model;

public class MokaMethodVariable extends MokaVariable {
	
	private String defaultValue;

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public static MokaMethodVariable create(MokaVariable dependency) {
		MokaMethodVariable variable = new MokaMethodVariable();
		variable.setName(dependency.getName());
		variable.setType(dependency.getType());
		
		return variable;
	}

}
