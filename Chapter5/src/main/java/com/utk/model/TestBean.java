package com.utk.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestBean {

	private static Logger logger = LoggerFactory.getLogger(TestBean.class);

	public void foo() {
		logger.info("foo() method is being called of TestBean");
	}

}
