package com.cs.consoleDrawing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
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
	
	/*
	 * This test is used for validating size of Blank canvas
	 */
	@Test
	public void testPerformActionForSizeOfBlankCanvas()
	{
		canvasModel = drawBlankCanvasServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals(4, canvasModel.getHeightOfCanvas()-2);
		Assert.assertEquals(20, canvasModel.getWidthOfCanvas()-2);
	}

	/*
	 * This test is used for validating boundry of Blank canvas
	 * Horizontal Border: '-'
	 * Vertical Border: '|'
	 */
	@Test
	public void testPerformActionForBoundryOfBlankCanvas()
	{
		canvasModel = drawBlankCanvasServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals('-', canvasModel.getBitMapOfCanvas()[0][4]);
		Assert.assertEquals('|', canvasModel.getBitMapOfCanvas()[3][0]);
	}
	
	/*
	 * This test is used for validating width & height parameter of Blank canvas
	 */
	@Test
	public void testPerformActionWithNegativeWidthAndHeight() {
		argsList.remove(1);
		argsList.remove(1);
		argsList.add(new Integer(-20));
		argsList.add(new Integer(-4));
		boolean isExceptionRaised = Boolean.FALSE;
		try {
		canvasModel = drawBlankCanvasServiceImpl.performAction(canvasModel, argsList);
		}
		catch(WrongArgumentsException wae) {
			isExceptionRaised = Boolean.TRUE;
			
		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}

}
