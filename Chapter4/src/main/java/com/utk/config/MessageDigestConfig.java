package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.factory.MessageDigestFactoryBean;
import com.utk.model.MessageDigester;

@Configuration
public class MessageDigestConfig {

	@Bean
	public MessageDigestFactoryBean shaDigest() {
		MessageDigestFactoryBean factoryBean = new MessageDigestFactoryBean();
		factoryBean.setAlgorithName("SHA1");
		return factoryBean;
	}

	@Bean
	public MessageDigestFactoryBean defaultDigest() {
		return new MessageDigestFactoryBean();
	}

	@Bean
	public MessageDigester messageDigester() throws Exception {
		MessageDigester messageDigester = new MessageDigester();
		messageDigester.setDigest1(shaDigest().getObject());
		messageDigester.setDigest2(defaultDigest().getObject());
		return messageDigester;
	}
}
