package com.utk;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.utk.config.JpaConfig;
import com.utk.entity.Singer;
import com.utk.service.SingerService;

@SpringBootApplication
public class Chapter10Demo {

	private static Logger logger = LoggerFactory.getLogger(Chapter10Demo.class);

	public static void main(String[] args) {
		SpringApplication.run(Chapter10Demo.class, args);
	}

	@Bean
	public ApplicationRunner execute() {
		return env -> {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
			SingerService singerService = context.getBean(SingerService.class);
			List<Singer> singers = singerService.findAll().toList();
			singers.forEach(singer -> logger.info("Singer is : {}", singer));
			context.close();
		};
	}
}
