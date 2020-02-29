package com.cs.consoleDrawing.exceptions;

public class WrongArgumentsException extends ConsoleDrawingException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String WRONG_AGRS_EXP_MESSAGE = "Looks like your input arguments are incorrect. Please input correct input.";
	
	public WrongArgumentsException() {
		System.out.println(WRONG_AGRS_EXP_MESSAGE);
	}
	
	
	public WrongArgumentsException(String message) {
		System.out.println(message);
	}
	

}
