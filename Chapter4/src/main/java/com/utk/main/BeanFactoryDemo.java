package com.utk.main;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.MessageDigestConfig;
import com.utk.factory.MessageDigestFactoryBean;
import com.utk.model.MessageDigester;

public class BeanFactoryDemo {

	private static Logger logger = LoggerFactory.getLogger(BeanFactoryDemo.class);

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MessageDigestConfig.class);
		context.registerShutdownHook();
		for (String name : context.getBeanDefinitionNames()) {
			logger.info("NAME IS : {}",name);
		}
		MessageDigester messageDigester = context.getBean("messageDigester", MessageDigester.class);
		messageDigester.digest("Hello World!!");
		MessageDigestFactoryBean factoryBean = (MessageDigestFactoryBean) context.getBean("&shaDigest");
		try {
			MessageDigest shaDigest = factoryBean.getObject();
			logger.info("Explicitly using shaDigest bean : " + shaDigest.digest("Hello World!!".getBytes()));
		} catch (Exception e) {
			logger.error("Could not get bean", e);
		}
	}
}
