package com.cs.consoleDrawing.service;

import com.cs.consoleDrawing.service.impl.DrawBlankCanvasServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawLineServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawRectangleServiceImpl;
import com.cs.consoleDrawing.service.impl.FillBucketServiceImpl;

/**
 * 
 * @author anand
 * 
 *         This is ShapeBuilderServiceFactory which is used to return the
 *         command Service based on command character passed in arguments
 *         C : It will return the service draw Blank Canvas
 *         L : It will return the service to draw the Line
 *         R : It will return the service to draw the rectangle
 *         B : It will return the service to fill the canvas bucket with given filler.
 *
 */
public class ShapeBuilderServiceFactory {

	public static DrawingService getShapeBuilderService(char keyWord) {
		switch (keyWord) {
		case 'C':
			return new DrawBlankCanvasServiceImpl();
		case 'L':
			return new DrawLineServiceImpl();
		case 'R':
			return new DrawRectangleServiceImpl();
		case 'B':
			return new FillBucketServiceImpl();
		}
		return null;

	}

}
