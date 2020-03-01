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
 *         This service is implementation for Filling the canvas Bucket with
 *         given character
 *
 */
@Service
public class FillBucketServiceImpl implements DrawingService {

	/**
	 * This method is to perform the action of filling the canvas based on
	 * parameters passed.
	 * 
	 * @param canvasModel: blank CanvasModel to be filled with given filler char
	 * @param argsList:    This is arrayList of all arguments passed via command
	 *                     Line
	 */
	@Override
	public CanvasModel performAction(CanvasModel canvasModel, List argsList) {

		int startIndex = 0;
		int endIndex = 0;
		char fillChar;

		try {
			startIndex = Integer.parseInt(argsList.get(1).toString());
			endIndex = Integer.parseInt(argsList.get(2).toString());
			fillChar = argsList.get(3).toString().charAt(0);

			validateParamsForFillBukcet(canvasModel, startIndex, endIndex);

		} catch (IllegalArgumentException | ArrayIndexOutOfBoundsException | NullPointerException
				| ClassCastException exp) {
			throw new WrongArgumentsException();
		}
		return fillBucketFromFiller(canvasModel, startIndex, endIndex, fillChar);
	}

	private CanvasModel fillBucketFromFiller(CanvasModel canvasModel, int x, int y, char filler) {
		char[][] pixArr = canvasModel.getBitMapOfCanvas();
		if (x > 0 && x <= canvasModel.getWidthOfCanvas() - 2 && y > 0 && y <= canvasModel.getHeightOfCanvas() - 2) {
			if (pixArr[y][x] != 0) {
				return canvasModel;
			}

			canvasModel.fillBitsToCanvasModel(y, x, filler);

			// Recursive calls for All directions.
			fillBucketFromFiller(canvasModel, x + 1, y, filler);
			fillBucketFromFiller(canvasModel, x - 1, y, filler);
			fillBucketFromFiller(canvasModel, x, y - 1, filler);
			fillBucketFromFiller(canvasModel, x, y + 1, filler);
		}
		return canvasModel;
	}

	private void validateParamsForFillBukcet(CanvasModel canvasModel, int startIndex, int endIndex) {

		if (startIndex > canvasModel.getWidthOfCanvas() - 2 || (endIndex > canvasModel.getHeightOfCanvas() - 2)) {
			throw new OutOfCanavsPaperException(ConsoleDrawingConstants.OUT_OF_CANVAS_MSSAGE);
		}
	}

}
