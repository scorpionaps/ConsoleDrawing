package com.cs.consoleDrawing.controller;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.service.DrawingService;
import com.cs.consoleDrawing.service.impl.DrawBlankCanvasServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawLineServiceImpl;
import com.cs.consoleDrawing.service.impl.DrawRectangleServiceImpl;
import com.cs.consoleDrawing.service.impl.FillBucketServiceImpl;
import com.cs.consoleDrawing.utils.ViewToModelMapper;
import com.cs.consoleDrawing.view.DrawingConsoleView;
import com.cs.consoleDrawing.viewBeans.CanvasPaper;

@RunWith(SpringRunner.class)
public class DrawingBaseControllerTest {

	@InjectMocks
	DrawingBaseController drawingBaseController;
	String createCanavsCommand;
	String drawLineCommand;
	String drawRectangleCommand;
	String fillBucketCommand;
	@Mock
	ViewToModelMapper viewToModelMapper;
	@Mock
	DrawingConsoleView drawingConsoleView;
	@Mock
	CanvasModel cm;
	CanvasPaper cp;
	@Mock
	DrawingService ds;

	@Before
	public void setup() {

		createCanavsCommand = "C 20 4";
		drawLineCommand = "L 1 2 6 2";
		drawRectangleCommand = "R 14 1 18 3";
		fillBucketCommand = "B 10 3 o";
		drawingBaseController = new DrawingBaseController();
		cp = new CanvasPaper(0, 0);
		MockitoAnnotations.initMocks(this);
		Mockito.when(viewToModelMapper.mapModeltoDTO(Mockito.any(CanvasModel.class))).thenReturn(cp);
		Mockito.doNothing().when(drawingConsoleView).printCanvasToConsole(Mockito.any(CanvasPaper.class));
	}

	/**
	 * Test is to validate if DrawBlankCanvasService is returned from ServiceFactory
	 * on create Canvas Command
	 */
	@Test
	public void testCanvasService() {
		DrawBlankCanvasServiceImpl i = Mockito.mock(DrawBlankCanvasServiceImpl.class);
		Mockito.when(i.performAction(Mockito.any(CanvasModel.class), Mockito.anyList())).thenReturn(cm);
		drawingBaseController.executeCommand(createCanavsCommand);
		Mockito.verify(i, Mockito.atMostOnce()).performAction(Mockito.any(CanvasModel.class), Mockito.anyList());
		Assert.assertEquals(Boolean.TRUE,
				new DrawBlankCanvasServiceImpl().getClass().isInstance(drawingBaseController.getDrawingService()));

	}

	/**
	 * Test is to validate if DrawLineServiceImpl is returned from ServiceFactory on
	 * create Line Command
	 */
	@Test
	public void testLineService() {
		try {
			drawingBaseController.executeCommand(drawLineCommand);
		} catch (Exception e) {
			Mockito.verify(ds, Mockito.atMostOnce()).performAction(Mockito.any(CanvasModel.class), Mockito.anyList());
			Assert.assertEquals(Boolean.TRUE,
					new DrawLineServiceImpl().getClass().isInstance(drawingBaseController.getDrawingService()));

		}

	}

	/**
	 * Test is to validate if DrawRectangleServiceImpl is returned from
	 * ServiceFactory on create Line Command
	 */
	@Test
	public void testRectangleService() {
		try {
			drawingBaseController.executeCommand(drawRectangleCommand);
		} catch (Exception e) {
			Mockito.verify(ds, Mockito.atMostOnce()).performAction(Mockito.any(CanvasModel.class), Mockito.anyList());
			Assert.assertEquals(Boolean.TRUE,
					new DrawRectangleServiceImpl().getClass().isInstance(drawingBaseController.getDrawingService()));

		}

	}

	/**
	 * Test is to validate if FillBucketServiceImpl is returned from ServiceFactory
	 * on create Line Command
	 */
	@Test
	public void testBucketFillService() {
		try {
			drawingBaseController.executeCommand(fillBucketCommand);
		} catch (Exception e) {
			Mockito.verify(ds, Mockito.atMostOnce()).performAction(Mockito.any(CanvasModel.class), Mockito.anyList());
			Assert.assertEquals(Boolean.TRUE,
					new FillBucketServiceImpl().getClass().isInstance(drawingBaseController.getDrawingService()));

		}

	}

}
