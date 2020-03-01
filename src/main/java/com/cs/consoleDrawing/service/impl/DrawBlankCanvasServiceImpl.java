package com.cs.consoleDrawing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.service.DrawingService;

/**
 * 
 * @author anand
 * 
 *         This is Service Implementation for Drawing Blank Canvas
 *
 */
@Service
public class DrawBlankCanvasServiceImpl extends DrawBasicDesignServiceImpl implements DrawingService {

	/**
	 * This method is to perform the action of drawing the blank canvas based on
	 * parameters passed.
	 * 
	 * @param canvasModel: blank CanvasModel to be filled with Canvas boundary
	 * @param argsList:    This is arrayList of all arguments passed via command
	 *                     Line
	 */
	@Override
	public CanvasModel performAction(CanvasModel canvasModel, List argsList) {
		int width = 0;
		int height = 0;
		try {
			width = Integer.parseInt(argsList.get(1).toString());
			height = Integer.parseInt(argsList.get(2).toString());

			if (!validateParamsForBlankCanvas(canvasModel, width, height)) {
				throw new WrongArgumentsException();
			}

		} catch (NumberFormatException | ArrayIndexOutOfBoundsException exp) {
			throw new WrongArgumentsException();
		}
		return drawBlankCanvas(width, height);
	}

	private CanvasModel drawBlankCanvas(int width, int height) {
		CanvasModel canvasModel = new CanvasModel();
		canvasModel.setWidthOfCanvas(width);
		canvasModel.setHeightOfCanvas(height);

		drawDesignFromLine(canvasModel, 0, 0, canvasModel.getWidthOfCanvas() - 1, 0,
				ConsoleDrawingConstants.HORIZONTAL_EDGE_SYMBOL);
		drawDesignFromLine(canvasModel, 0, canvasModel.getHeightOfCanvas() - 1, canvasModel.getWidthOfCanvas() - 1,
				canvasModel.getHeightOfCanvas() - 1, ConsoleDrawingConstants.HORIZONTAL_EDGE_SYMBOL);
		drawDesignFromLine(canvasModel, 0, 1, 0, canvasModel.getHeightOfCanvas() - 2,
				ConsoleDrawingConstants.VERTICAL_EDGE_SYMBOL);
		drawDesignFromLine(canvasModel, canvasModel.getWidthOfCanvas() - 1, 1, canvasModel.getWidthOfCanvas() - 1,
				canvasModel.getHeightOfCanvas() - 2, ConsoleDrawingConstants.VERTICAL_EDGE_SYMBOL);

		return canvasModel;
	}

	private boolean validateParamsForBlankCanvas(CanvasModel canvasModel, int width, int height) {
		if (width <= 0 || height <= 0) {
			return false;
		}
		return true;
	}
}
