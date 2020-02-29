package com.cs.consoleDrawing.exceptions;
/**
 * @author anand
 *
 */
public class ConsoleDrawingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String EXCEPTION_GENERIC_MESSAGE = "There is some issue. Please Try Again";

	public ConsoleDrawingException() {
		super();
		System.out.println(EXCEPTION_GENERIC_MESSAGE);
	}
	
	public ConsoleDrawingException(String message) {

			System.out.println(message);
	}

}
