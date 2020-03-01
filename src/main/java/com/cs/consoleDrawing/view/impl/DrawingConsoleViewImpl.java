package com.cs.consoleDrawing.view.impl;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.ConsoleDrawingException;
import com.cs.consoleDrawing.view.DrawingConsoleView;
import com.cs.consoleDrawing.viewBeans.CanvasPaper;

/**
 * @author anand
 * 
 *         This is view Implementation for View which can be considered as View
 *         of MVC framework.
 *
 */
public class DrawingConsoleViewImpl implements DrawingConsoleView {

	/**
	 * @param CanvasPaper canvasPaper
	 * 
	 *                    Usage: This method is working as view which prints the
	 *                    drawing in the defined console.
	 */
	@Override
	public void printCanvasToConsole(CanvasPaper canvasPaper) {
		if (null != canvasPaper) {
			char[][] pixelmap = canvasPaper.getPixMap();
			for (int h = 0; h < canvasPaper.getcHeight(); h++) {
				for (int w = 0; w < canvasPaper.getcWidth(); w++) {
					System.out.print(pixelmap[h][w]);
				}
				System.out.println();
			}
		} else {
			throw new ConsoleDrawingException(ConsoleDrawingConstants.NO_DATA_TO_PRINT_IN_CANVAS);
		}

	}

}
