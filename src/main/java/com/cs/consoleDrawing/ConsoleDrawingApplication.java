package com.cs.consoleDrawing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
/**
 * @author anand
 *
 */
import com.cs.consoleDrawing.controller.DrawingBaseController;
import com.cs.consoleDrawing.exceptions.ConsoleDrawingException;

@SpringBootApplication
public class ConsoleDrawingApplication implements CommandLineRunner{

	@Autowired
	DrawingBaseController drawingController;
	
	public static void main(String[] args) {
		SpringApplication.run(ConsoleDrawingApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Running Spring Boot Console Drawing for CS");
		start();
	}
	
	private void start() throws IOException
	{
		try {
		System.out.println("Choose Options: C L R B Q");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
		System.out.println(line);
		drawingController.executeCommand(line);
		start();
		}
		catch(ConsoleDrawingException exp)
		{
			start();
		}
		catch(Exception exp)
		{
			System.out.println(ConsoleDrawingConstants.ERROR_MESSAGE_DEFAULT);
			/*
			 * exp.printStackTrace(); System.exit(0);
			 */
			start();
		}
	}

}
