package com.cs.consoleDrawing.service.impl;

import org.springframework.stereotype.Service;

import com.cs.consoleDrawing.model.CanvasModel;
/**
 * @author anand
 *
 */
@Service
public abstract class DrawBasicDesignServiceImpl  {
	
	public CanvasModel drawDesignFromLine(CanvasModel canvasModel, int x1, int y1, int x2, int y2, char key) {
		 
		for(int i=y1;i<=y2;i++)
				{
					for (int j=x1;j<=x2;j++)
					{
						canvasModel.fillBitsToCanvasModel(i, j, key);
					}
				}
		return canvasModel;
	}

}
