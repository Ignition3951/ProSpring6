package com.utk.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;

public class NamedSinger implements BeanNameAware {

	private static final Logger logger = LoggerFactory.getLogger(NamedSinger.class);
	private String name;

	@Override
	public void setBeanName(String beanName) {
		this.name = beanName;
	}

	public void sing() {
		logger.info("Singer " + name + " - sing()");
	}

}
