package com.utk.service;

public class StandardOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;

	@Override
	public String render() {
		return messageProvider.getMessage();
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
