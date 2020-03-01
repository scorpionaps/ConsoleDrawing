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
public class FillBucketServiceImplTest {

	CanvasModel canvasModel;
	List argsList;

	FillBucketServiceImpl fillBucketServiceImpl;

	@Before
	public void setup() {
		canvasModel = new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(4);
		canvasModel.setBitMapOfCanvas(new char[4 + 2][4 + 2]);

		argsList = new ArrayList();
		argsList.add("B");
		argsList.add(2);
		argsList.add(3);
		argsList.add('o');

		fillBucketServiceImpl = new FillBucketServiceImpl();
	}

	/**
	 * This Test is to validate if filler is at right position FillerChar: o
	 */
	@Test
	public void testPerformActionForCorrectFill() {
		canvasModel = fillBucketServiceImpl.performAction(canvasModel, argsList);
		Assert.assertEquals('o', canvasModel.getBitMapOfCanvas()[(int) argsList.get(2)][(int) argsList.get(1)]);
	}

	/**
	 * This Test is to validate if filler had not overridden any existing shape
	 * FillerChar: o
	 */
	@Test
	public void testPerformActionForFillerOverride() {
		canvasModel = fillBucketServiceImpl.performAction(canvasModel, argsList);
		Assert.assertNotEquals('x',
				canvasModel.getBitMapOfCanvas()[(int) argsList.get(2) + 1][(int) argsList.get(1) + 1]);
	}

	/**
	 * This test is used to test that is shape is going out of canvas Test:
	 * OutOfCanvasException
	 */
	@Test
	public void testPerformActionForOutOfCanvas() {
		// Changing the value of x1 to 5 as canvas width is 4
		argsList.set(2, 5);
		boolean isExceptionRaised = Boolean.FALSE;
		try {
			canvasModel = fillBucketServiceImpl.performAction(canvasModel, argsList);
		} catch (OutOfCanavsPaperException ocp) {
			isExceptionRaised = Boolean.TRUE;
			Assert.assertEquals(ConsoleDrawingConstants.OUT_OF_CANVAS_MSSAGE, ocp.getMessage());

		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}

}
