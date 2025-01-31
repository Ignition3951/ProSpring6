package com.utk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.service.Singer;

public class GreatGuitarist implements Singer {

	private static Logger logger = LoggerFactory.getLogger(GreatGuitarist.class);

	@Override
	public void sing() {
		logger.info("You've got my soul in your hand");
	}

}
