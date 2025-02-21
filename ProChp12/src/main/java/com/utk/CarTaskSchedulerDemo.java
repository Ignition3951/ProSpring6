package com.utk;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;

@SpringBootApplication
public class CarTaskSchedulerDemo {

	private static Logger logger = LoggerFactory.getLogger(CarTaskSchedulerDemo.class);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(CarTaskSchedulerDemo.class, args);
	}

	@Bean
	ApplicationRunner execute() {
		return env -> {
			try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
				context.refresh();
				var taskBean = context.getBean(ScheduledAnnotationBeanPostProcessor.DEFAULT_TASK_SCHEDULER_BEAN_NAME);
				logger.info(">>> Task Scheduler found : {}", taskBean.getClass());
			} catch (NoSuchBeanDefinitionException nbd) {
				logger.info("No 'taskScheduler' configured!");
			}
			System.in.read();
		};
	}
}
