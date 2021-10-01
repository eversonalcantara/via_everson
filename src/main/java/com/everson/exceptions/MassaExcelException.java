package com.everson.exceptions;

public class MassaExcelException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 880103801061874537L;

	// Parameterless Constructor
	public MassaExcelException() {
	}

	// Constructor that accepts a message
	public MassaExcelException(String message) {
		super(message);
	}
}