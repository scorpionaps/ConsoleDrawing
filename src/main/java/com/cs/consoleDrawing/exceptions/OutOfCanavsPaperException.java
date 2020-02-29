package com.cs.consoleDrawing.exceptions;

public class OutOfCanavsPaperException extends ConsoleDrawingException {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final String OUT_OF_CANVAS_MSSAGE = "Shape is going out of canavs";
	
	public OutOfCanavsPaperException() {
		System.out.println(OUT_OF_CANVAS_MSSAGE);
	}

	public OutOfCanavsPaperException(String message) {
		super(message);
	}
	
	

}
