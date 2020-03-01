package com.cs.consoleDrawing.utils;

/**
 * @author anand
 *
 */
import com.cs.consoleDrawing.model.CanvasModel;
import com.cs.consoleDrawing.viewBeans.CanvasPaper;

/**
 * 
 * @author anand
 * 
 *         This is Mapper class with is used to Map Model to FormDTO and Vice
 *         Versa
 *
 */
public class ViewToModelMapper {

	public CanvasModel mapDTOtoModel(CanvasPaper canvasPaper) {
		CanvasModel canvasModel = null;
		if (null != canvasPaper) {
			canvasModel = new CanvasModel();
			canvasModel.setWidthOfCanvas(canvasPaper.getcWidth());
			canvasModel.setHeightOfCanvas(canvasPaper.getcHeight());
			canvasModel.setBitMapOfCanvas(canvasPaper.getPixMap());
		}

		return canvasModel;
	}

	public CanvasPaper mapModeltoDTO(CanvasModel canvasModel) {
		CanvasPaper canvasPaper = null;
		if (null != canvasModel) {
			canvasPaper = new CanvasPaper(canvasModel.getHeightOfCanvas(), canvasModel.getWidthOfCanvas());
			canvasPaper.setPixMap(canvasModel.getBitMapOfCanvas());
		}
		return canvasPaper;

	}

}
