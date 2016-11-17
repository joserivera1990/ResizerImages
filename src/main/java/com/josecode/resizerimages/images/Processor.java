package com.josecode.resizerimages.images;

import com.josecode.resizerimages.exception.ImagesException;
import com.josecode.resizerimages.properties.Configuration;

public interface Processor {
	
	void processorImagesFromFolder(Configuration configuration) throws ImagesException;

}
