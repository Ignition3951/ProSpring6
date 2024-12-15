package com.utk.service;

import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

	private final MessageProvider messageProvider;

	public StandardOutMessageRenderer(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}

	@Override
	public String render() {
		return messageProvider.getMessage();
	}

	@Override
	public void setMessageProvider(MessageProvider messageProvider) {

	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
