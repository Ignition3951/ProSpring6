package com.utk;

import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.utk.entity.Letter;
import com.utk.jms.Sender;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ArtemisApplicationDemo {

	public static void main(String[] args) {
		try (ConfigurableApplicationContext ctx = SpringApplication.run(ArtemisApplicationDemo.class, args)) {
			Sender sender = ctx.getBean("sender", Sender.class);
			for (int i = 0; i < 10; i++) {
				Letter letter = new Letter("Letter no. " + i, "Test", LocalDate.now(), UUID.randomUUID().toString());
				sender.send(letter);
			}
			System.in.read();
		} catch (IOException ex) {
			log.error("Problem in reading strokes.");
		}
	}

}
