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
import com.cs.consoleDrawing.model.CanvasModel;

@RunWith(SpringRunner.class)
public class DrawRectangleServiceImplTest {

	CanvasModel canvasModel;
	List argsList;

	DrawRectangleServiceImpl drawRectangleServiceImpl;

	@Before
	public void setup() {
		canvasModel = new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(20);
		canvasModel.setBitMapOfCanvas(new char[4 + 2][20]);

		argsList = new ArrayList();
		argsList.add("R");
		argsList.add(14);
		argsList.add(1);
		argsList.add(18);
		argsList.add(3);

		drawRectangleServiceImpl = new DrawRectangleServiceImpl();
	}

	/**
	 * This Test is to validate if rectangle periphery is with character x
	 * fillerChar: x
	 */
	@Test
	public void testPerformActionForRectanglePeriphery() {
		canvasModel = drawRectangleServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals('x', canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)][(int) argsList.get(1)]);
	}

	/**
	 * This Test is to validate if rectangle is hollow fillerChar: x
	 */
	@Test
	public void testPerformActionForRectangleisHollow() {
		canvasModel = drawRectangleServiceImpl.performAction(canvasModel, argsList);
		Assert.assertNotEquals('x',
				canvasModel.getBitMapOfCanvas()[(int) argsList.get(2) + 1][(int) argsList.get(1) + 1]);
	}

	/**
	 * This test is used to test that is shape is going out of canvas Test:
	 * OutOfCanvasException
	 */
	@Test
	public void testPerformActionForOutOfCanvas() {
		// Changing the value of x1 to 21 as canvas width is 20
		argsList.set(3, 21);
		boolean isExceptionRaised = Boolean.FALSE;
		try {
			canvasModel = drawRectangleServiceImpl.performAction(canvasModel, argsList);
		} catch (OutOfCanavsPaperException ocp) {
			isExceptionRaised = Boolean.TRUE;
			Assert.assertEquals(ConsoleDrawingConstants.OUT_OF_CANVAS_MSSAGE, ocp.getMessage());

		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}

}
