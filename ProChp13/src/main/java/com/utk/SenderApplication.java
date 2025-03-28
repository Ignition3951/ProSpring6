package com.utk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SenderApplication {

	public static void main(String[] args) {
		SpringApplication.run(SenderApplication.class, args);
	}

	@Value("${app.sender.name}")
	public String sender;

	@Value("${app.correspondent.address}")
	public String correspondentAddress;

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public CommandLineRunner initCmd() {
		return (args) -> {
			log.info(">>> Sender {} ready to send the letters to {} ", sender, correspondentAddress);
		};
	}
}
