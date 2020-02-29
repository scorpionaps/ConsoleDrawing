package com.cs.consoleDrawing.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.cs.consoleDrawing.service.DrawingService;

@RunWith(SpringRunner.class)
public class DrawingBaseControllerTest {
	
	String createCanavsCommand;
	String drawLineCommand;
	String drawRectangleCommand;
	String fillBucketCommand;
	
	DrawingService drawingService;
	
	@Before
	public void setup() {
		
		createCanavsCommand = "C 20 4";
		drawLineCommand = "L 1 2 6 2";
		drawRectangleCommand = "R 14 1 18 3";
		fillBucketCommand = "B 10 3 o";
		
	}
	
	public void testCreateBlankCanavs()
	{
		ArrayList<String> argsList = (ArrayList<String>) Arrays.asList(createCanavsCommand);
	}

}
