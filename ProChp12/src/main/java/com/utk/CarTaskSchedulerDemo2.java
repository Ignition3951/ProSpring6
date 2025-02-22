package com.utk;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.ThreadSchedulerTaskConfig2;

public class CarTaskSchedulerDemo2 {

	private static Logger logger = LoggerFactory.getLogger(CarTaskSchedulerDemo2.class);

	public static void main(String[] args) throws IOException {
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				ThreadSchedulerTaskConfig2.class)) {
			try {
				var taskExecutor = context.getBean("taskExecutor");
				logger.info(">>> taskExecutor found : {}", taskExecutor.getClass());
			} catch (NoSuchBeanDefinitionException e) {
				logger.error("No taskExecutor configured!!!!");
			}
			System.in.read();
		}
	}

}
