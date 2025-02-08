package com.utk;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.HibernateConfig;
import com.utk.dao.SingerDao;

public class HibernateDemoV1 {

	private static final Logger logger = LoggerFactory.getLogger(HibernateDemoV1.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
		SingerDao singerDao = context.getBean(SingerDao.class);

		logger.info("-----Listing singers");
		singerDao.findAll().forEach(s -> logger.info(s.toString()));
		context.close();

	}

}
