package com.cs.consoleDrawing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.OutOfCanavsPaperException;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.service.DrawingService;

/**
 * @author anand
 * 
 *         This service is implementation for Drawing Line shape
 *
 */
@Service
public class DrawLineServiceImpl extends DrawBasicDesignServiceImpl implements DrawingService {

	/**
	 * This method is to perform the action of drawing the Line in the canvas based
	 * on parameters passed.
	 * 
	 * @param canvasModel: blank CanvasModel to be filled Line shape
	 * @param argsList:    This is arrayList of all arguments passed via command
	 *                     Line
	 */
	@Override
	public CanvasModel performAction(CanvasModel canvasModel, List argsList) {

		int x1 = 0;
		int y1 = 0;
		int x2 = 0;
		int y2 = 0;

		try {
			x1 = Integer.parseInt(argsList.get(1).toString());
			y1 = Integer.parseInt(argsList.get(2).toString());
			x2 = Integer.parseInt(argsList.get(3).toString());
			y2 = Integer.parseInt(argsList.get(4).toString());

			validateParamsForLine(canvasModel, x1, y1, x2, y2);

		} catch (IllegalArgumentException | NullPointerException exp) {
			throw new WrongArgumentsException();
		}

		return drawDesignFromLine(canvasModel, x1, y1, x2, y2, ConsoleDrawingConstants.SHAPE_CREATION_SYMBOL);
	}

	private void validateParamsForLine(CanvasModel canvasModel, int x1, int y1, int x2, int y2) {

		if (x1 <= 0 || x2 <= 0 || y1 <= 0 || y2 <= 0) {
			throw new WrongArgumentsException(ConsoleDrawingConstants.NEGATIVE_NOT_ALLOWED);
		}

		if (!((x1 == x2) || (y1 == y2))) {
			throw new WrongArgumentsException(ConsoleDrawingConstants.DIAGONAL_LINE_NOT_ALLOWED);
		}
		if (x1 > canvasModel.getWidthOfCanvas() - 2 || x2 > canvasModel.getWidthOfCanvas() - 2
				|| (y1 > canvasModel.getHeightOfCanvas() - 2) || (y2 > canvasModel.getHeightOfCanvas() - 2)) {
			throw new OutOfCanavsPaperException(ConsoleDrawingConstants.OUT_OF_CANVAS_MSSAGE);
		}
	}
}
