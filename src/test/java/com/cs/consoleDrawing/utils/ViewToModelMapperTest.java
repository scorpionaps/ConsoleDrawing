package com.cs.consoleDrawing.utils;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.viewBeans.CanvasPaper;


@RunWith(SpringRunner.class)
public class ViewToModelMapperTest {
	
	CanvasModel canvasModel;
	CanvasPaper canvasPaper;
	
	ViewToModelMapper viewToModelMapper;
	
	@Before
	public void setup()
	{
		canvasModel = new CanvasModel();
		canvasModel.setBitMapOfCanvas(new char[5][15]);
		canvasModel.setHeightOfCanvas(15);
		canvasModel.setWidthOfCanvas(5);
		
		canvasPaper = new CanvasPaper(4, 20);
		viewToModelMapper = new ViewToModelMapper();
	}
	
	@Test
	public void testMapDTOtoModel()
	{
		canvasModel = viewToModelMapper.mapDTOtoModel(canvasPaper);
		Assert.assertEquals(canvasPaper.getcHeight(), canvasModel.getHeightOfCanvas()-2);
		Assert.assertEquals(canvasPaper.getcWidth(), canvasModel.getWidthOfCanvas()-2);
		Assert.assertEquals(canvasPaper.getPixMap()[2][3], canvasModel.getBitMapOfCanvas()[2][3]);
		
	}
	
	@Test
	public void testMapModeltoDTO()
	{
		canvasPaper = viewToModelMapper.mapModeltoDTO(canvasModel);
		Assert.assertEquals(canvasModel.getHeightOfCanvas(),canvasPaper.getcHeight());
		Assert.assertEquals(canvasModel.getWidthOfCanvas(), canvasPaper.getcWidth());
		Assert.assertEquals(canvasModel.getBitMapOfCanvas()[2][3], canvasPaper.getPixMap()[2][3]);
	}

}
