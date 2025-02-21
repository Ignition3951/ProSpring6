//package com.utk;
//
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.context.annotation.Bean;
//
//import com.utk.config.AppConfig;
//import com.utk.task.RandomStringPrinter;
//
//@SpringBootApplication
//public class SimpleAsyncTaskExecutorDemo {
//
//	public static void main(String[] args) {
//		SpringApplication.run(SimpleAsyncTaskExecutorDemo.class, args);
//	}
//
//	@Bean
//	ApplicationRunner execute() {
//		return env -> {
//			try (AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(
//					RandomStringPrinter.class, AppConfig.class)) {
//				RandomStringPrinter randomStringPrinter = applicationContext.getBean("randomStringPrinter",
//						RandomStringPrinter.class);
//				randomStringPrinter.executeTask();
//			}
//		};
//	}
//
//}
