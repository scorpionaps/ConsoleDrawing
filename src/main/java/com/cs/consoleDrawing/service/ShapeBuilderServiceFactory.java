package com.cs.consoleDrawing.service;

import com.cs.consoleDrawing.service.impl.DrawBlankCanvasServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawLineServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawRectangleServiceImpl;
import com.cs.consoleDrawing.service.impl.FillBukcetServiceImpl;

public class ShapeBuilderServiceFactory {
	
	public static DrawingService getShapeBuilderService(char keyWord)
	{	
		switch(keyWord)
		{
		case 'C':
			return new DrawBlankCanvasServiceImpl();
		case 'L':
			return new DrawLineServiceImpl();
		case 'R':
			return new DrawRectangleServiceImpl();
		case 'B':
			return new FillBukcetServiceImpl();
		}
		return null;
		
	}

}
