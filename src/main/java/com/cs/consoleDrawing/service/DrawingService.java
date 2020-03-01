package com.cs.consoleDrawing.service;

import java.util.List;

import com.cs.consoleDrawing.model.CanvasModel;

/**
 * 
 * @author anand
 * 
 *         DrawingService Interface common for all command services. It is used
 *         to implements Factory design pattern
 *
 */
public interface DrawingService {

	CanvasModel performAction(CanvasModel canvasModel, List argsList);

}
