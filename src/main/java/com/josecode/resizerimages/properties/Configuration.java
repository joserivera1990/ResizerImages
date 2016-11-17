package com.josecode.resizerimages.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Configuration {

	private final int height;
	private final int weight;
	private final String pathRead;
	private final String pathWrite;
	
	public Configuration() throws IOException {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		Properties p = new Properties();
		p.load(inputStream);
		height = Integer.parseInt(p.getProperty("new.weight"));
		weight = Integer.parseInt(p.getProperty("new.height"));
		pathRead = p.getProperty("folder.read");
		pathWrite = p.getProperty("folder.write");
		
	}
    
	public int getHeight() {
		return height;
	}

	public int getWeight() {
		return weight;
	}

	public String getPathRead() {
		return pathRead;
	}

	public String getPathWrite() {
		return pathWrite;
	}
}

