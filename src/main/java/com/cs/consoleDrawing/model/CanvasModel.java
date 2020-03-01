package com.cs.consoleDrawing.model;

import com.cs.consoleDrawing.constants.ConsoleDrawingConstants;
import com.cs.consoleDrawing.exceptions.WrongArgumentsException;

/**
 * 
 * @author anand
 * 
 *         This is Model Class which represents domain object which can be
 *         treated as DataBase Model. It is Model for MVC design pattern. int:
 *         heightOfCanvas int: widthOfCanvas char[][]: bitMapOfCanvas
 *
 */
public class CanvasModel {

	int heightOfCanvas;
	int widthOfCanvas;
	char[][] bitMapOfCanvas;

	/**
	 * @return the heightOfCanvas
	 */
	public int getHeightOfCanvas() {
		return heightOfCanvas;
	}

	/**
	 * @param heightOfCanvas the heightOfCanvas to set
	 */
	public void setHeightOfCanvas(int heightOfCanvas) {
		this.heightOfCanvas = heightOfCanvas + 2;
	}

	/**
	 * @return the widthOfCanvas
	 */
	public int getWidthOfCanvas() {
		return widthOfCanvas;
	}

	/**
	 * @param widthOfCanvas the widthOfCanvas to set
	 */

	public void setWidthOfCanvas(int widthOfCanvas) {
		this.widthOfCanvas = widthOfCanvas + 2;
	}

	/**
	 * @return the bitMapOfCanvas
	 */
	public char[][] getBitMapOfCanvas() {
		return bitMapOfCanvas;
	}

	/**
	 * @param bitMapOfCanvas the bitMapOfCanvas to set
	 */
	public void setBitMapOfCanvas(char[][] bitMapOfCanvas) {
		this.bitMapOfCanvas = bitMapOfCanvas;
	}

	/**
	 * This method is used to fill character value passed into the bitMap at the
	 * given coordinates.
	 * 
	 * @param yCord
	 * @param xCord
	 * @param key
	 */
	public void fillBitsToCanvasModel(int yCord, int xCord, char key) {
		try {
			if (null == this.bitMapOfCanvas) {
				this.bitMapOfCanvas = new char[this.heightOfCanvas][this.widthOfCanvas];
			}
			this.bitMapOfCanvas[yCord][xCord] = key;
		} catch (ArrayIndexOutOfBoundsException | NullPointerException exp) {
			throw new WrongArgumentsException(ConsoleDrawingConstants.ARUGMENTS_SIZE_EXCESS);
		}
	}

}
