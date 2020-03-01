package com.cs.consoleDrawing.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.OutOfCanavsPaperException;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
import com.cs.consoleDrawing.model.CanvasModel;

@RunWith(SpringRunner.class)
public class DrawLineServiceImplTest {

	CanvasModel canvasModel;
	List argsList;

	DrawLineServiceImpl drawLineServiceImpl;
	int x1 = 1;
	int y1 = 2;
	int x2 = 6;
	int y2 = 2;

	@Before
	public void setup() {
		canvasModel = new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(20);
		canvasModel.setBitMapOfCanvas(new char[4 + 2][20 + 2]);
		argsList = new ArrayList();
		argsList.add("L");
		argsList.add(x1);
		argsList.add(y1);
		argsList.add(x2);
		argsList.add(y2);

		drawLineServiceImpl = new DrawLineServiceImpl();
	}

	/**
	 * This test will check that the line is correctly drawn based on coordinates
	 */
	@Test
	public void testPerformActionForLine() {
		canvasModel = drawLineServiceImpl.performAction(canvasModel, argsList);
		for (int i = x1; i < x2; i++) {
			for (int j = y1; j < y2; j++) {
				Assert.assertEquals('x', canvasModel.getBitMapOfCanvas()[i][j]);
			}
		}
	}

	/**
	 * This test is used to test that diagonal line is not allowed
	 */
	@Test
	public void testPerformActionForDiagonalLine() {
		// Changing the value of y1 to 3
		argsList.set(2, 3);
		boolean isExceptionRaised = Boolean.FALSE;
		try {
			canvasModel = drawLineServiceImpl.performAction(canvasModel, argsList);
		} catch (WrongArgumentsException wae) {
			isExceptionRaised = Boolean.TRUE;
			Assert.assertEquals(ConsoleDrawingConstants.DIAGONAL_LINE_NOT_ALLOWED, wae.getMessage());

		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}

	/**
	 * This test is used to test that is shape is going out of canvas Exception
	 * Test: OutOfCanvasException
	 */
	@Test
	public void testPerformActionForOutOfCanvas() {
		// Changing the value of x1 to 21 as canvas width is 20
		argsList.set(3, 21);
		boolean isExceptionRaised = Boolean.FALSE;
		try {
			canvasModel = drawLineServiceImpl.performAction(canvasModel, argsList);
		} catch (OutOfCanavsPaperException ocp) {
			isExceptionRaised = Boolean.TRUE;
			Assert.assertEquals(ConsoleDrawingConstants.OUT_OF_CANVAS_MSSAGE, ocp.getMessage());

		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}
}
