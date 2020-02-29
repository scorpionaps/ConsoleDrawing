package com.cs.consoleDrawing.viewBeans;

public class CanvasPaper {
	
	private final int cHeight;
	private final int cWidth;
	public char [][] pixMap;
	/**
	 * @param cHeight
	 * @param cWidth
	 */
	public CanvasPaper(int cHeight, int cWidth) {
		super();
		this.cHeight = cHeight;
		this.cWidth = cWidth;
		this.pixMap = new char [cHeight][cWidth];
	}
	/**
	 * @return the cHeight
	 */
	public int getcHeight() {
		return cHeight;
	}
	/**
	 * @return the cWidth
	 */
	public int getcWidth() {
		return cWidth;
	}
	/**
	 * @return the pixMap
	 */
	public char[][] getPixMap() {
		return pixMap;
	}

	public void setPixMap(char[][] pixMap) {
		this.pixMap = pixMap;
	}
}
