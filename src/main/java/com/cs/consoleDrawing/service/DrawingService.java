package com.cs.consoleDrawing.service;

import java.util.List;

import com.cs.consoleDrawing.model.CanvasModel;

public interface DrawingService {

	CanvasModel performAction(CanvasModel canvasModel, List argsList);

}
