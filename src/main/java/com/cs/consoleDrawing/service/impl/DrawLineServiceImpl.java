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
 */
@Service
public class DrawLineServiceImpl extends DrawBasicDesignServiceImpl implements DrawingService {

	
    @Override
	public CanvasModel performAction(CanvasModel canvasModel,List argsList) {
	
    	int x1=0;
		int y1=0;
		int x2=0;
		int y2=0;
		
		try
		{
			x1 = Integer.parseInt(argsList.get(1).toString());
			y1 = Integer.parseInt(argsList.get(2).toString());
			x2 = Integer.parseInt(argsList.get(3).toString());
			y2 = Integer.parseInt(argsList.get(4).toString());
		}
		catch(IllegalArgumentException | NullPointerException exp)
		{
			throw new WrongArgumentsException();
		}
    	
		if(x1 > canvasModel.getWidthOfCanvas() ||
				  x2 > canvasModel.getWidthOfCanvas() || 
				  (y1 >canvasModel.getHeightOfCanvas()-2) ||
				  (y2 > canvasModel.getHeightOfCanvas()-2))	 
		  				{ 
			  				throw new OutOfCanavsPaperException(); 
			  			}
		
    	return drawDesignFromLine(canvasModel,x1,y1,x2,y2,ConsoleDrawingConstants.SHAPE_CREATION_SYMBOL);
	}
}
