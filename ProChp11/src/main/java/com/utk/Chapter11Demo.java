package com.utk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import com.utk.config.AppConfig;
import com.utk.config.CustomRegistrarConfig;
import com.utk.record.Blogger;

@SpringBootApplication
public class Chapter11Demo {

	private static Logger logger = LoggerFactory.getLogger(Chapter11Demo.class);

	public static void main(String[] args) {
		SpringApplication.run(Chapter11Demo.class, args);
	}

	@Bean
	public ApplicationRunner execute() {
		return env -> {
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class,
					CustomRegistrarConfig.class);
			Blogger awsBlogger = context.getBean("awsBlogger", Blogger.class);
			Blogger springBlogger = context.getBean("springBlogger", Blogger.class);

			logger.info("AWS Blogger --> {}", awsBlogger);
			logger.info("Spring Blogger --> {}", springBlogger);

			context.close();
		};
	}

}
