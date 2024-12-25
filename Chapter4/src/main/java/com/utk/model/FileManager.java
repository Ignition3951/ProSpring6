package com.utk.model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PreDestroy;

public class FileManager {

	private static final Logger logger = LoggerFactory.getLogger(FileManager.class);
	private Path file;

	public FileManager() {
		logger.info("Creating bean of type : {}", FileManager.class);
		try {
			file = Files.createFile(Path.of("sample"));
		} catch (IOException e) {
			logger.error("Error in creating file");
		}
	}

	@PreDestroy
	private void destroyMethod() throws IOException {
		logger.info("Destroying bean of type : {}", FileManager.class);
		logger.info("Value of file is : {}", file);
		if (file != null) {
			Files.deleteIfExists(file);
		}
	}

}
