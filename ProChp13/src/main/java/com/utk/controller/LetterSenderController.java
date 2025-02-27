package com.utk.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.utk.entity.Letter;

@RestController
public class LetterSenderController {

	private final RestTemplate restTemplate;
	private final String correspondentAddress;
	private final String sender;

	public LetterSenderController(RestTemplate restTemplate,
			@Value("#{senderApplication.correspondentAddress}") String correspondentAddress,
			@Value("#{senderApplication.sender}") String sender) {
		this.restTemplate = restTemplate;
		this.correspondentAddress = correspondentAddress;
		this.sender = sender;
	}

	@PostMapping(path = "send", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
	public void sendLetter(@RequestBody Letter letter) {
		letter.setSender(sender);
		letter.setSentOn(LocalDate.now());
		HttpEntity<Letter> request = new HttpEntity<Letter>(letter);
		restTemplate.exchange(correspondentAddress + "/letters", HttpMethod.POST, request, Letter.class);
	}

}
