package com.cs.consoleDrawing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.model.CanvasModel;

@RunWith(SpringRunner.class)
public class DrawBlankCanvasServiceImplTest {
	
	CanvasModel canvasModel;
	List argsList;
	
	DrawBlankCanvasServiceImpl drawBlankCanvasServiceImpl;
	
	
	@Before
	public void setup()
	{
		canvasModel =  new CanvasModel();
		argsList = new ArrayList();
		argsList.add("C");
		argsList.add(20);
		argsList.add(4);
		
		drawBlankCanvasServiceImpl = new DrawBlankCanvasServiceImpl();
	}
	
	@Test
	public void testPerformAction()
	{
		canvasModel = drawBlankCanvasServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals(4, canvasModel.getHeightOfCanvas()-2);
		Assert.assertEquals(20, canvasModel.getWidthOfCanvas());
		Assert.assertEquals("|".charAt(0), canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)][(int) argsList.get(1)-1]);
	}

}
