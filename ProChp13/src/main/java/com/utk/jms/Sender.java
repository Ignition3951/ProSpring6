package com.utk.jms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.utk.entity.Letter;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Component
@Slf4j
public class Sender {

	private final JmsTemplate jmsTemplate;

	@PostConstruct
	public void init() {
		jmsTemplate.setDeliveryDelay(2000l);
	}

	@Value("${spring.artemis.queue}")
	private String queueName;

	public void send(Letter letter) {
		log.info(">>> Sending letter = '{}'", letter);
		jmsTemplate.convertAndSend(queueName, letter);
	}
}
