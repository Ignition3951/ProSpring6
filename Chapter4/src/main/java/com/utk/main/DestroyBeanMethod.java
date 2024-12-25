package com.utk.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.DestroyBeanConfig;

public class DestroyBeanMethod {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DestroyBeanConfig.class);
		context.registerShutdownHook();// to register destroy method to be called from multiple exit points

	}

}
