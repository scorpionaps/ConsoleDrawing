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

/**
 * 
 * @author anand
 * 
 * This is main class which implements springBoot's CommandLiner interface to implements run method and Logic to execute commands is implemented under start()
 *
 */
@SpringBootApplication
public class ConsoleDrawingApplication implements CommandLineRunner {

	@Autowired
	DrawingBaseController drawingController;

	public static void main(String[] args) {
		SpringApplication.run(ConsoleDrawingApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("Running Spring Boot Console Drawing for CS");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("C w h                   This will create a new canvas of width w and height h.");
		System.out.println("L x1 y1 x2 y2           This will create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the 'x' character.");
		System.out.println("R x1 y1 x2 y2           This will a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2). Horizontal and vertical lines will be drawn using the 'x' character.");
		System.out.println("B x y c           		This will fill the entire area connected to (x,y) with \"colour\" c. The behavior of this is the same as that of the \"bucket fill\" tool in paint programs.");
		System.out.println("Q           			This will quit the program.");
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");	
		System.out.println("Assumptions: 1. Only CAPS character allowed for command as per Requirements");
		System.out.println("Assumptions: 2. No diagnol Lines are allowed as per requirements");
		
		System.out.println("----------------------------------------------------------------------------------------------------------------------------------------------------");	
		start();
	}

	private void start() throws IOException {
		try {
			System.out.println("Choose Options: C L R B Q");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			String line = reader.readLine();
			System.out.println(line);
			drawingController.executeCommand(line);
			start();
		} catch (ConsoleDrawingException exp) {
			//exp.printStackTrace();
			start();
		} catch (Exception exp) {
			System.out.println(ConsoleDrawingConstants.ERROR_MESSAGE_DEFAULT);
			//exp.printStackTrace();
			start();
		}
	}

}
