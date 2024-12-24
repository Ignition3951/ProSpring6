package com.utk.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.SingerConfig;
import com.utk.model.Singer;

public class InitMethodDemo {

	private static Logger logger = LoggerFactory.getLogger(InitMethodDemo.class);

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SingerConfig.class);

		getBean("singerOne", context);
		getBean("singerTwo", context);
		getBean("singerThree", context);

	}

	public static Singer getBean(String beanName, ApplicationContext context) {
		try {
			Singer singer = (Singer) context.getBean(beanName);
			logger.info("Found Bean : {}", singer.toString());
			return singer;
		} catch (BeanCreationException e) {
			logger.error("An error occurred while bean generation : {}", e.getMessage());
			return null;
		}
	}

}
