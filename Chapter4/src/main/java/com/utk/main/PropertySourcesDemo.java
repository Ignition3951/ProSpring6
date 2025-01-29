package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.PropertySourceConfig;
import com.utk.service.MessageRenderer;

public class PropertySourcesDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(PropertySourceConfig.class);
		MessageRenderer messageRenderer = context.getBean("messageRenderer", MessageRenderer.class);
		messageRenderer.render();
	}

}
