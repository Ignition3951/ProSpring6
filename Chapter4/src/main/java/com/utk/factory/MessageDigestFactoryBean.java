package com.utk.factory;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

	private String algorithmName = "MD5";

	private MessageDigest messageDigest = null;

	@Override
	public MessageDigest getObject() throws Exception {
		return messageDigest;
	}

	@Override
	public Class<?> getObjectType() {
		return MessageDigest.class;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		messageDigest = MessageDigest.getInstance(algorithmName);
	}

	public void setAlgorithName(String name) {
		this.algorithmName = name;
	}

}
