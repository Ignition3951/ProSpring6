package com.utk.service;

public interface MessageRenderer {

	void render();

	void setMessageProvider(MessageProvider messageProvider);

	MessageProvider getMessageProvider();

}
