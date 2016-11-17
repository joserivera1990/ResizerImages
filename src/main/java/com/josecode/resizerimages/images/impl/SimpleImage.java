package com.josecode.resizerimages.images.impl;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.josecode.resizerimages.exception.ImagesException;
import com.josecode.resizerimages.images.Image;

public class SimpleImage implements Image {

	@Override
    public BufferedImage resizeImage(BufferedImage originalImage, int type, int width, int height) {
		BufferedImage resizedImage = new BufferedImage(width, height, type);
		Graphics2D g = resizedImage.createGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
	return resizedImage;
    }
	
	@Override
	public BufferedImage getOriginalImage(String path) throws ImagesException {
		try {
			return ImageIO.read(new File(path));
		} catch (IOException e) {
			throw new ImagesException("Path "+ path + " wasn't find for read the image, pleaase check");
		}
	}
	
	@Override
	public void writeNewImage(String path, String typeImage, BufferedImage resizeImageJpg) throws ImagesException {
		try {
			File folder = new File(path);
			ImageIO.write(resizeImageJpg, typeImage, folder);
		} catch (IOException e) {
			throw new ImagesException("Path "+ path + " wasn't find for write the new image, pleaase check");
		}
	}
}
