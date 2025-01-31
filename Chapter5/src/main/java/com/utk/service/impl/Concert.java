package com.utk.service.impl;

import static java.time.Duration.ofMillis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.utk.service.Performance;

public class Concert implements Performance {

	private static Logger logger = LoggerFactory.getLogger(Concert.class);

	@Override
	public void execute() {
		logger.info("....LA LA LA LA......");
		try {
			Thread.sleep(ofMillis(2000).toMillis());
		} catch (Exception e) {
		}
	}


}
