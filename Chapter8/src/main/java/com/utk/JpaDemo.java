package com.utk;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.JpaConfig;
import com.utk.entity.Singer;
import com.utk.service.SingerService;

public class JpaDemo {

	private static Logger logger = LoggerFactory.getLogger(JpaDemo.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(JpaConfig.class);
		SingerService singerService = context.getBean(SingerService.class);
		List<Singer> singers = singerService.findAll().toList();
		logger.info("SIZE OF SINGER IS : {}", singers.size());
		context.close();

	}

}
