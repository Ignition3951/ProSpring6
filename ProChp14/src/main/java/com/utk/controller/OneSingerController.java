package com.utk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utk.entity.Singer;
import com.utk.service.SingerService;

@Controller
@RequestMapping("/singer/{id}")
public class OneSingerController {

	private static Logger LOGGER = LoggerFactory.getLogger(OneSingerController.class);

	private final SingerService singerService;

	private final MessageSource messageSource;

	public OneSingerController(SingerService singerService, MessageSource messageSource) {
		this.singerService = singerService;
		this.messageSource = messageSource;
	}

	@GetMapping
	public String showSingerData(@PathVariable("id") Long id, Model model) {
		Singer singer = singerService.findById(id);
		model.addAttribute("singer", singer);
		return "singers/show";
	}

	@GetMapping("/photo")
	@ResponseBody
	public byte[] downloadPhoto(@PathVariable("id") Long id) {
		Singer singer = singerService.findById(id);
		if (singer.getPhoto() != null) {
			LOGGER.info(">>> Downloading photo for id : {} with size : {}", singer.getId(), singer.getPhoto().length);
			return singer.getPhoto();
		}
		return null;
	}

}
