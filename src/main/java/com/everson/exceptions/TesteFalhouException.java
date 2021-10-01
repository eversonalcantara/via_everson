package com.everson.exceptions;

public class TesteFalhouException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3488192867119800586L;

	// Parameterless Constructor
	public TesteFalhouException() {
	}

	// Constructor that accepts a message
	public TesteFalhouException(String message) {
		super(message);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public TesteFalhouException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


}