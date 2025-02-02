package com.utk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.service.Singer;

public class GrammyGuitarist implements Singer {

	private static Logger logger = LoggerFactory.getLogger(GrammyGuitarist.class);

	@Override
	public void sing() {
		logger.info("sing: Gravity is working against me\n" + "And gravity wants to bring me down");
	}

	@Override
	public void rest() {
		logger.info("zzz");
	}

	@Override
	public void sing(String key) {
		logger.info("play: " + key);
	}

	public void talk() {
		logger.info("talk");
	}

}
