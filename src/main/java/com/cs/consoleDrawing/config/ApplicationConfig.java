package com.cs.consoleDrawing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cs.consoleDrawing.utils.ViewToModelMapper;
import com.cs.consoleDrawing.view.DrawingConsoleView;
import com.cs.consoleDrawing.view.impl.DrawingConsoleViewImpl;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public ViewToModelMapper viewToModelMapper()
	{
		ViewToModelMapper viewToModelMapper = new ViewToModelMapper();
		return viewToModelMapper;
	}
	
	@Bean
	public DrawingConsoleView drawingConsoleView()
	{
		return new DrawingConsoleViewImpl();
	}

}
