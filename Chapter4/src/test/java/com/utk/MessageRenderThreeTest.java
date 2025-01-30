package com.utk;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.utk.config.MessageConfigForMPMR;
import com.utk.service.MessageProvider;
import com.utk.service.MessageRenderer;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { MessageConfigForMPMR.class })
public class MessageRenderThreeTest {

	@Autowired
	private MessageProvider messageProvider;

	@Autowired
	private MessageRenderer messageRenderer;

	@Test
	void testProvider() {
		assertNotNull(messageProvider);
	}

	void testRenderer() {
		assertAll("messageTest", () -> assertNotNull(messageRenderer),
				() -> assertNotNull(messageRenderer.getMessageProvider()));
		messageRenderer.render();
	}
}
