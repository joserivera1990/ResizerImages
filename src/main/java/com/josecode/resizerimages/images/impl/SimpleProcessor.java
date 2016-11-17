package com.josecode.resizerimages.images.impl;

import java.awt.image.BufferedImage;
import java.io.File;

import com.josecode.resizerimages.exception.ImagesException;
import com.josecode.resizerimages.images.Image;
import com.josecode.resizerimages.images.Processor;
import com.josecode.resizerimages.properties.Configuration;

public class SimpleProcessor implements Processor {
	
	@Override
	public void processorImagesFromFolder(Configuration configuration) throws ImagesException {
		Image image = new SimpleImage();			
		File folder = new File(configuration.getPathRead());
		
		File[] listOfFiles = folder.listFiles();
        if (listOfFiles == null) {
        	throw new ImagesException("Path "+ configuration.getPathRead() + " doesn't have images");
        }
		
	    for (int i = 0; i < listOfFiles.length; i++) {
		    if (listOfFiles[i].isFile()) {
				BufferedImage originalImage = image.getOriginalImage(configuration.getPathRead() + listOfFiles[i].getName());
				int type = originalImage.getType() == 0 ? BufferedImage.TYPE_INT_ARGB : originalImage.getType();
				BufferedImage resizeImageJpg = image.resizeImage(originalImage, type, configuration.getWeight(), configuration.getHeight());	
				final String typeImaage = listOfFiles[i].getName().split("\\.")[listOfFiles[i].getName().split("\\.").length-1];
				image.writeNewImage(configuration.getPathWrite() + listOfFiles[i].getName(), typeImaage, resizeImageJpg);
		        
		    } 
	    }	
	}

}
