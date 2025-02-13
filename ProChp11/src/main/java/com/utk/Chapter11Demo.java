package com.utk;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.ValidationUtils;

import com.utk.config.AppConfig;
import com.utk.config.CustomRegistrarConfig;
import com.utk.record.Blogger;
import com.utk.validator.ComplexBloggerValidator;

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

			com.utk.entity.Blogger validateBlogger = new com.utk.entity.Blogger(null, null, LocalDate.of(1979, 1, 1),
					new URL("https://com.utk"));
			ComplexBloggerValidator complexBloggerValidator = context.getBean("complexBloggerValidator",
					ComplexBloggerValidator.class);
			BeanPropertyBindingResult beanPropertyBindingResult = new BeanPropertyBindingResult(springBlogger,
					"springBlogger");

			logger.info("AWS Blogger --> {}", awsBlogger);
			logger.info("Spring Blogger --> {}", springBlogger);
			ValidationUtils.invokeValidator(complexBloggerValidator, springBlogger, beanPropertyBindingResult);
			List<ObjectError> allErrors = beanPropertyBindingResult.getAllErrors();
			allErrors.forEach(
					e -> logger.info("Object {} failed validation. Result code {}", e.getObjectName(), e.getCode()));

			context.close();
		};
	}

}
