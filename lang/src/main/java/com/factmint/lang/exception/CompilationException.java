package com.factmint.lang.exception;

public class CompilationException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1020740211187462033L;

	public CompilationException(String message) {
		super(message);
	}
	
	public CompilationException(Exception e) {
		super(e);
	}

	//TODO: The constructor should force a line and character number into the exception;
}
