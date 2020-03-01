package com.cs.consoleDrawing.exceptions;

/**
 * 
 * @author anand
 * 
 *         This exception is for Out of Canvas cases
 *
 */
public class OutOfCanavsPaperException extends ConsoleDrawingException {

	private static final long serialVersionUID = 1L;

	public OutOfCanavsPaperException() {
	}

	public OutOfCanavsPaperException(String message) {
		super(message);
		System.out.println(message);
	}

}
