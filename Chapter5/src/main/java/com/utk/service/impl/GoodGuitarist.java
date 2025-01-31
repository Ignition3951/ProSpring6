package com.utk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.service.Singer;

public class GoodGuitarist implements Singer {

	private static Logger logger = LoggerFactory.getLogger(GoodGuitarist.class);

	@Override
	public void sing() {
		logger.info("Head on your heart, arms around me");
	}

}
