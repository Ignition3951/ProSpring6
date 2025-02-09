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

//		logger.info("-----Listing singers with findAll");
//		singerDao.findAll().forEach(s -> logger.info(s.toString()));
		logger.info("-----Listing singers with findAllWithAlbum");
		singerDao.findAllWithAlbum().forEach(s -> logger.info(s.toString()));
		logger.info("----Listing findById using named Query : {}", singerDao.findById(1l));
		context.close();

	}

}
