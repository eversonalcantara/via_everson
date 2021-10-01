package com.everson.exceptions;

public class ValorNaoIniciadoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7542599410111599987L;

	// Parameterless Constructor
	public ValorNaoIniciadoException() {
	}

	// Constructor that accepts a message
	public ValorNaoIniciadoException(String message) {
		super(message);
	}
}