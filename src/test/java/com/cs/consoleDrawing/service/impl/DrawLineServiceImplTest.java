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
public class DrawLineServiceImplTest {
	
	CanvasModel canvasModel;
	List argsList;
	
	DrawLineServiceImpl drawLineServiceImpl;
	
	
	@Before
	public void setup()
	{
		canvasModel =  new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(20);
		canvasModel.setBitMapOfCanvas(new char[4+2][20]);
		
		argsList = new ArrayList();
		argsList.add("L");
		argsList.add(1);
		argsList.add(2);
		argsList.add(6);
		argsList.add(2);
		
		drawLineServiceImpl = new DrawLineServiceImpl();
	}
	
	@Test
	public void testPerformAction()
	{
		canvasModel = drawLineServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals("x".charAt(0), canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)][(int) argsList.get(1)]);
	}

}
