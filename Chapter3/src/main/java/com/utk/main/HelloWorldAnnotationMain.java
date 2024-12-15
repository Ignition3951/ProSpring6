package com.utk.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.HelloWorldConfiguration;
import com.utk.service.MessageRenderer;

public class HelloWorldAnnotationMain {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
		System.out.println(mr.render());

	}

}
