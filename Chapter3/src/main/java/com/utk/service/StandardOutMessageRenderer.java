package com.utk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("renderer")
public class StandardOutMessageRenderer implements MessageRenderer {

	private MessageProvider messageProvider;

	@Override
	public String render() {
		return messageProvider.getMessage();
	}

	@Override
	@Autowired
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;

	}

	@Override
	public MessageProvider getMessageProvider() {
		return this.messageProvider;
	}

}
