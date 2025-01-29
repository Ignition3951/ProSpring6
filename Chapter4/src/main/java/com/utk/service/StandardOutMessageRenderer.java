package com.utk.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StandardOutMessageRenderer implements MessageRenderer {

	private static Logger logger = LoggerFactory.getLogger(StandardOutMessageRenderer.class);

	private MessageProvider messageProvider;

	@Override
	public void render() {
		logger.info(messageProvider.getMessage());
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
