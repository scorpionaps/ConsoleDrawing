package com.cs.consoleDrawing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cs.consoleDrawing.exceptions.OutOfCanavsPaperException;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.service.DrawingService;

@Service
public class FillBukcetServiceImpl implements DrawingService {
	
	@Override
	public CanvasModel performAction(CanvasModel canvasModel, List argsList) {
		
		int startIndex = 0;
		int endIndex = 0;
		char fillChar;
		
		try {
			startIndex = Integer.parseInt(argsList.get(1).toString());
			endIndex = Integer.parseInt(argsList.get(2).toString());
			fillChar = argsList.get(3).toString().charAt(0);
			
			if(startIndex > canvasModel.getWidthOfCanvas() ||
					  (endIndex > canvasModel.getHeightOfCanvas()-2))	 
			  				{ 
				  				throw new OutOfCanavsPaperException(); 
				  			}
			
		}
		catch(IllegalArgumentException | ArrayIndexOutOfBoundsException | NullPointerException | ClassCastException exp)
		{
			throw new WrongArgumentsException();
		}
		return fillBucketFromFiller(canvasModel,
									startIndex,
									endIndex,
									fillChar);
	}

	private CanvasModel fillBucketFromFiller(CanvasModel canvasModel, int x, int y, char filler) {
		char [][] pixArr = canvasModel.getBitMapOfCanvas();
		
		if(pixArr[y][x]!=0)
		{
			return canvasModel;
		}
		
		if(x > 0 || x < canvasModel.getHeightOfCanvas() || y > 0 || y < canvasModel.getWidthOfCanvas())
		{
			if(pixArr[y][x] == 0)
			{
				canvasModel.fillBitsToCanvasModel(y, x, filler);
			}
			
			// Recursive calls for All directions.
			fillBucketFromFiller(canvasModel, x+1, y, filler);
			fillBucketFromFiller(canvasModel, x-1, y, filler);
			fillBucketFromFiller(canvasModel, x, y-1, filler);
			fillBucketFromFiller(canvasModel, x, y+1, filler);
		}
		
		return canvasModel;
	}

}
