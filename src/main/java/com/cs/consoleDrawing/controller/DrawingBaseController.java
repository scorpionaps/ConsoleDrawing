/**
 * 
 */
package com.cs.consoleDrawing.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.ConsoleDrawingException;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;
import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.service.DrawingService;
import com.cs.consoleDrawing.service.ShapeBuilderServiceFactory;
import com.cs.consoleDrawing.utils.ViewToModelMapper;
import com.cs.consoleDrawing.view.DrawingConsoleView;
import com.cs.consoleDrawing.viewBeans.CanvasPaper;

import ch.qos.logback.core.util.AggregationType;

/**
 * @author anand
 *
 */
@Controller
public class DrawingBaseController {
	
 
   CanvasPaper canvasPaper;
   CanvasModel canvasModel;
   DrawingService drawingService;
   @Autowired
   ViewToModelMapper viewModelMapper;
   @Autowired
   DrawingConsoleView drawingConsoleView;
   
   public void executeCommand(String commandLine) {
	   
	   String [] splitArrOfCommands = commandLine.split(ConsoleDrawingConstants.SPLIT_IDENTIFIER);
	   if(splitArrOfCommands.length > 0)
	   {
		  char command =  splitArrOfCommands[0].charAt(0);
		  List argsList = new ArrayList();
		  argsList = Arrays.asList(splitArrOfCommands);
		  switch(command) 
		  {
		  case 'C' :
			  drawingService = ShapeBuilderServiceFactory.getShapeBuilderService(command);
			  if(argsList!=null && argsList.size() == 3)
			  {
			  canvasModel = drawingService.performAction
					  (canvasModel,argsList);
			  }
			  else
			  {
				  throw new WrongArgumentsException();
			  }
			  break;
		  case 'L' :
			  drawingService = ShapeBuilderServiceFactory.getShapeBuilderService(command);
			  if(argsList!=null && argsList.size() == 5)
			  {
			  canvasModel = drawingService.performAction
					  (canvasModel,argsList);
			  }
			  else
			  {
				  throw new WrongArgumentsException();
			  }
			  break;
		  case 'R' :
			  drawingService = ShapeBuilderServiceFactory.getShapeBuilderService(command);
			  if(argsList!=null && argsList.size() == 5)
			  {
			  canvasModel = drawingService.performAction
					  (canvasModel,argsList);
			  }
			  else
			  {
				  throw new WrongArgumentsException();
			  }
			  break;
			  
		  case 'B' :
			  drawingService = ShapeBuilderServiceFactory.getShapeBuilderService(command);
			  if(argsList!=null && argsList.size() == 4)
			  {
			  canvasModel = drawingService.performAction
					  (canvasModel,argsList);
			  }
			  else
			  {
				  throw new WrongArgumentsException();
			  }
			  break;
			  
		  case 'Q' :
			  System.out.println(ConsoleDrawingConstants.CLOSING_MESSAGE);
			  System.exit(1);
			  break;
		  default :
			  throw new ConsoleDrawingException(ConsoleDrawingConstants.WRONG_OPTION_SELECTED);
			  
		  }
		  // Converting CanvasModel to CanvasPaper(View)
		  canvasPaper = viewModelMapper.mapModeltoDTO(canvasModel);
		  // Printing CanvasPaper to Console
		  drawingConsoleView.printCanvasToConsole(canvasPaper);
	   }
	   else
	   {
		   throw new ConsoleDrawingException(ConsoleDrawingConstants.WRONG_OPTION_SELECTED);
			  
	   }
	   
   }

}
