package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.MessageDigestConfig;
import com.utk.model.MessageDigester;

public class BeanFactoryDemo {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
		context.registerShutdownHook();
		MessageDigester messageDigester = context.getBean("messageDigester", MessageDigester.class);
		messageDigester.digest("Hello World!!");
	}
}
