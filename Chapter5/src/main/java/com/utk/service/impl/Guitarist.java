package com.utk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.service.Singer;

public class Guitarist implements Singer {

	private static Logger logger = LoggerFactory.getLogger(Guitarist.class);

	@Override
	public void sing() {
		logger.info("Just keep me where the light is");
	}

	public void sing2() {
		logger.info("And wrap me in your arms");
	}

	@Override
	public void rest() {
		logger.info("zzzz.....");
	}

}
