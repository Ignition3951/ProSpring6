package com.utk;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.utk.service.MessageProvider;
import com.utk.service.MessageRenderer;
import com.utk.service.StandardOutMessageRenderer;

public class MessageRendererTest {

	@Test
	void testStandardOutMessageRenderer() {
		MessageProvider mockProvider = mock(MessageProvider.class);
		when(mockProvider.getMessage()).thenReturn("Test Message");

		MessageRenderer messageRenderer = new StandardOutMessageRenderer();
		messageRenderer.setMessageProvider(mockProvider);

		messageRenderer.render();
		verify(mockProvider, times(1)).getMessage();
	}

}
