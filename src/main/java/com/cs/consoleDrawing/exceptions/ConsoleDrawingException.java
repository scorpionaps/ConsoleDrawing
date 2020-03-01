package com.cs.consoleDrawing.exceptions;

/**
 * @author anand
 * 
 *         this is base Exception for any Console Drawing Exception
 *
 */
public class ConsoleDrawingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConsoleDrawingException() {
		super();
	}

	public ConsoleDrawingException(String message) {
		super(message);
		// System.out.println(message);
	}

}
