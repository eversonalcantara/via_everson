package com.everson.exceptions;

/**
 * Esta exceção deve ser usado para Caso de Testes que deva 
 * dar erro na tela durante a execução dos passos.
 * 
 * @author Everson
 *
 */
public class AssertFailException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6845377294135112963L;

	/**
	 * @param message
	 * @param cause
	 */
	public AssertFailException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 */
	public AssertFailException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AssertFailException(Throwable cause) {
		super(cause);
	}

}
