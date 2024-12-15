package com.utk.main;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.HelloWorldConfiguration;
import com.utk.model.ContructorConfusion;
import com.utk.service.MessageRenderer;

public class HelloWorldAnnotationMain {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		MessageRenderer mr = context.getBean("renderer", MessageRenderer.class);
		System.out.println(mr.render());
		context.close();
		
		AnnotationConfigApplicationContext contextConfusion = new AnnotationConfigApplicationContext();
		contextConfusion.register(ContructorConfusion.class);
		contextConfusion.refresh();
		
		ContructorConfusion confusion = contextConfusion.getBean(ContructorConfusion.class);
		System.out.println("Will this work : " + confusion.toString());
		contextConfusion.close();
	}

}
