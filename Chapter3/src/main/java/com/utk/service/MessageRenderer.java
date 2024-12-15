package com.utk.service;

public interface MessageRenderer {

	String render();

	void setMessageProvider(MessageProvider messageProvider);

	MessageProvider getMessageProvider();

}
