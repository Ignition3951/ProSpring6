package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.model.FileManager;

@Configuration
public class DestroyBeanConfig {

	@Bean(name = "fileManagerBean")
	FileManager getFileManager() {
		return new FileManager();
	}
}
