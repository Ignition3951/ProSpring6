package com.utk.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.annotation.AdviceRequired;
import com.utk.model.Guitar;
import com.utk.service.Singer;

public class AnnotatedGuitarist implements Singer {

	private static Logger logger = LoggerFactory.getLogger(AnnotatedGuitarist.class);

	@Override
	public void sing() {

	}

	@AdviceRequired
	public void sing(Guitar guitar) {
		logger.info("Play : " + guitar.play());
	}

}
