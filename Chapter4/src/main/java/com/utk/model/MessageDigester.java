package com.utk.model;

import java.security.MessageDigest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MessageDigester {

	private static Logger logger = LoggerFactory.getLogger(MessageDigester.class);

	private MessageDigest digest1;

	private MessageDigest digest2;

	public void setDigest1(MessageDigest digest1) {
		this.digest1 = digest1;
	}

	public void setDigest2(MessageDigest digest2) {
		this.digest2 = digest2;
	}

	public void digest(String message) {
		logger.info("Using digest1");
		digest(message, digest1);
		logger.info("Using digest2");
		digest(message, digest2);
	}

	private void digest(String message, MessageDigest digest) {
		logger.info("Using Algorithm : " + digest.getAlgorithm());
		digest.reset();
		byte[] bytes = message.getBytes();
		byte[] output = digest.digest(bytes);
		logger.info("Original message : {}", bytes);
		logger.info("Encrypted message: {}", output);
	}
}
