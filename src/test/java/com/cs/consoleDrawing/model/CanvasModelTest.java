package com.cs.consoleDrawing.model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.exceptions.WrongArgumentsException;

@RunWith(SpringRunner.class)
public class CanvasModelTest {

	CanvasModel canvasModel;

	@Before
	public void setup() {
		canvasModel = new CanvasModel();
		canvasModel.setHeightOfCanvas(4);
		canvasModel.setWidthOfCanvas(20);

	}

	/**
	 * This test is to validate of Fill Character to bitMap works expected
	 */
	@Test
	public void testFillBitsToCanvasModel() {
		canvasModel.fillBitsToCanvasModel(3, 12, 'x');
		Assert.assertEquals('x', canvasModel.getBitMapOfCanvas()[3][12]);
	}

	/**
	 * This test is validate if WrongArgumentException comes in case input params
	 * are incorrect
	 */
	@Test
	public void testFillBitsToCanvasModelForIncorrectParams() {

		boolean isExceptionRaised = Boolean.FALSE;
		try {
			// 6,25 are Incorrect Params as Canvas Size is 4,20
			canvasModel.fillBitsToCanvasModel(6, 25, 'x');
		} catch (WrongArgumentsException wae) {
			isExceptionRaised = Boolean.TRUE;

		}
		Assert.assertEquals(Boolean.TRUE, isExceptionRaised);
	}

}
