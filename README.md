# Console Drawing Java Application

This is Shape Drawing Application for Console, developed in java and SpringBoot Framework. It is developed with MVC design pattern
At this time, the functionality of the program is quite limited but this might change in the future. 
In a nutshell, the program should work as follows:
 1. Create a new canvas
 2. Start drawing on the canvas by issuing various commands
 3. Quit

## Getting Started

Please follow below instructions to get a copy of the project up and running on your local machine for development and testing purposes. 

### Prerequisites

1. Java/JDK version 1.8 or above should be installed in local machine.
2. If Porject needs to be cloned from github then Git needs to insatlled in local machine.
3. To review the Code, any Java development IDE is recommended to installed in local machine.
4. For running the application code or Test Module via command Line, Mavan needs to installed in you local Machine.
5. Application and Test module can be executed from development IDE as well

### Assumptions

1. As per Requirements, commands for action should always be given in CAPS
2. As per Requirements, Diagnol Lines are not allowed to be made.
3. Bucket Fill for already painted shape is not considered.

### Installing

A step by step series of examples that tell you how to get a development env running

1. Clone the project from gitHub repository [GitHub Link](https://github.com/scorpionaps/ConsoleDrawing.git)
2. Copy/Download the zip Project from Dropbox [DropBox Link] ()
3. Open Developemt IDE for Code Review and Run, Import "Exisitng Maven Project" into your local workspace.
## Running the tests
	1. From Command Line: Go to Project root folder--> Run "mvn test"
	2. From IDE: Select Mavan Build/Run config, select Project root as Base Directory. Set goal as "test".  Click on Run(Assumption, JRE is configured correctly)
	3. From IDE: Select "/consoleDrawing/src/test/java" and run as Junit Test.
## Running the Application
	1. From Command Line: Go to Project /consoleDrawing/target folder--> Run java -jar consoleDrawing-0.0.1-SNAPSHOT-jar-with-dependencies.jar
	2. From IDE: Select Mavan Build/Run config, select Project root as Base Directory. Set goal as "exec:java".  Click on Run(Assumption, JRE is configured correctly)
	3. From IDE: Select "/consoleDrawing/" and run as Java application.

__Sample I/O__
```
Below is a sample run of the program. User input is prefixed with enter command:
Choose Options: C L R B Q
C 20 4
----------------------
|                    |
|                    |
|                    |
|                    |
----------------------

L 1 2 6 2
----------------------
|                    |
|xxxxxx              |
|                    |
|                    |
----------------------

L 6 3 6 4
----------------------
|                    |
|xxxxxx              |
|     x              |
|     x              |
----------------------

R 14 1 18 3
----------------------
|             xxxxx  |
|xxxxxx       x   x  |
|     x       xxxxx  |
|     x              |
----------------------

B 10 3 o
----------------------
|oooooooooooooxxxxxoo|
|xxxxxxooooooox   xoo|
|     xoooooooxxxxxoo|
|     xoooooooooooooo|
----------------------
Q
Thank You For Using Drawing Console
```
### Development Style and Design Pattern Used

1. TDD Basic development approach was followed.
2. SpringBoot is used to developer core framework
3. MVC Design Pattern is followed
	Controller: DrawingBaseController.java
	View: DrawingConsoleView.java
	Model: CanvasModel.java
4. To Loose coupling and high cohesion, Factory pattern is used to generate Service based on Command selected.
	DrawingService.java -> Interface
	ShapeBuilderServiceFactory.java --> Service Factory
	DrawBlankCanvasServiceImpl.java,DrawLineServiceImpl.java,DrawRectangleServiceImpl.java,FillBucketServiceImpl.java --> Implemenation


## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - framework used
* [Maven](https://maven.apache.org/) - Dependency Management

## Authors

* **Anand Pratap Singh** - *Initial work* - [scorpionaps](https://github.com/scorpionaps)


