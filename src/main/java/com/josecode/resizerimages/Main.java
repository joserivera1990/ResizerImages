package com.josecode.resizerimages;

import java.io.IOException;

import com.josecode.resizerimages.exception.ImagesException;
import com.josecode.resizerimages.images.Processor;
import com.josecode.resizerimages.images.impl.SimpleProcessor;
import com.josecode.resizerimages.properties.Configuration;

public class Main {

	public static void main(String [] args){
		try {
			Processor processor = new SimpleProcessor();
			Configuration configuration = new Configuration();	
			processor.processorImagesFromFolder(configuration);	
		} catch(IOException | ImagesException e) {
			System.out.println(e.getMessage());
		}
    }
}
