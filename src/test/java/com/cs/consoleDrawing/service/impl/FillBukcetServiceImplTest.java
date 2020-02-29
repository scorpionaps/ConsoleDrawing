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
public class FillBukcetServiceImplTest {
	
	CanvasModel canvasModel;
	List argsList;
	
	FillBukcetServiceImpl fillBukcetServiceImpl;
	
	
	@Before
	public void setup()
	{
		canvasModel =  new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(20);
		canvasModel.setBitMapOfCanvas(new char[4+2][20]);
		
		
		argsList = new ArrayList();
		argsList.add("B");
		argsList.add(15);
		argsList.add(3);
		argsList.add('o');
		
		fillBukcetServiceImpl = new FillBukcetServiceImpl();
	}
	
	@Test
	public void testPerformAction()
	{
		canvasModel = fillBukcetServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals(argsList.get(3), canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)][(int) argsList.get(1)]);
		//Assert.assertNotEquals("x".charAt(0), canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)+1][(int) argsList.get(1)+1]);
	}

}
