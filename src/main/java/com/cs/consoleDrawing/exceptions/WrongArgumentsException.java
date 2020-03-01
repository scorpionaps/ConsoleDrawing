package com.cs.consoleDrawing.exceptions;

/**
 * 
 * @author anand This Exception is raised if there are any Wrong Arguments are
 *         passed.
 *
 */
public class WrongArgumentsException extends ConsoleDrawingException {

	private static final long serialVersionUID = 1L;
	private static final String WRONG_AGRS_EXP_MESSAGE = "The input arguments are incorrect. Please correct.";

	public WrongArgumentsException() {
		System.out.println(WRONG_AGRS_EXP_MESSAGE);
	}

	public WrongArgumentsException(String message) {
		super(message);
		System.out.println(message);
	}

}
