package com.josecode.resizerimages.images.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import com.josecode.resizerimages.exception.ImagesException;

public class SimpleImageTest {

	@Test
	public void resizeImageTest() throws IOException {
		SimpleImage simpleImage = new SimpleImage();
		BufferedImage image = ImageIO.read(getClass().getClassLoader().getResourceAsStream("Chrysanthemum.jpg"));
		BufferedImage  resized =  simpleImage.resizeImage(image, 5, 10, 10);
		assertEquals(10, resized.getWidth());   
	}
	
	@Test(expected = ImagesException.class) 
	public void getExceptionImage() throws IOException, ImagesException {
		SimpleImage simpleImage = new SimpleImage();
		simpleImage.getOriginalImage("Chrysanthemum.jpg");  
	}
	
	@Test 
	public void getImage() throws IOException, ImagesException {
		SimpleImage simpleImage = new SimpleImage();
		BufferedImage image = simpleImage.getOriginalImage("src/test/resources/Chrysanthemum.jpg");  
		assertNotNull(image);
	}
	
}
