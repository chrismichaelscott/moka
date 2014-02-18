package com.factmint.moka.compiler.model;

public class MokaConstant extends MokaVariable {
	
	private String initialValue;
	private String initializationBody;
	
	public static MokaConstant create(String type, String name, String initialValue, String initializationBody) {
		MokaConstant constant = new MokaConstant();
		
		constant.setType(type);
		constant.setName(name);
		constant.setInitialValue(initialValue);
		constant.setInitializationBody(initializationBody);
		
		return constant;
	}
	
	public String getInitialValue() {
		return initialValue;
	}
	
	public void setInitialValue(String initialValue) {
		this.initialValue = initialValue;
	}
	
	public String getInitializationBody() {
		return initializationBody;
	}
	
	public void setInitializationBody(String initializationBody) {
		this.initializationBody = initializationBody;
	}

}
