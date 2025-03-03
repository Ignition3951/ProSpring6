package com.utk.jms;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.utk.entity.Letter;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Reciever {

	@JmsListener(destination = "${spring.artemis.queue}")
	public void recieve(Letter letter) {
		log.info(">>> Recieved letter '{}'", letter);
	}
}
