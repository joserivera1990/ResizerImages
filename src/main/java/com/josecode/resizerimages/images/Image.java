package com.josecode.resizerimages.images;

import java.awt.image.BufferedImage;

import com.josecode.resizerimages.exception.ImagesException;

public interface Image {

	BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int height);
	
	BufferedImage getOriginalImage(String path) throws ImagesException;
	
	void writeNewImage(String path, String typeImage, BufferedImage resizeImageJpg) throws ImagesException;
	
}
