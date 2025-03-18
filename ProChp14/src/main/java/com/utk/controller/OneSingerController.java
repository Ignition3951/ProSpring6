package com.utk.controller;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.utk.entity.Singer;
import com.utk.service.SingerService;

import jakarta.validation.Valid;

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

	@PreAuthorize(value = "hasRole('ADMIN')")
	@DeleteMapping
	public String deleteSinger(@PathVariable("id") Long id) {
		singerService.delete(id);
		return "redirect:/singers";
	}

	@GetMapping("/edit")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Singer singer = singerService.findById(id);
		model.addAttribute("singer", singer);
		return "singers/edit";
	}

	@PutMapping
	public String updateSingerInfo(@Valid Singer singer, Model model, BindingResult bindingResult, Locale locale) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("message", messageSource.getMessage("singer.save.fail", new Object[] {}, locale));
			model.addAttribute("singer", singer);
			return "singers/edit";
		} else {
			model.asMap().clear();
			Singer singerFromDB = singerService.findById(singer.getId());
			singerFromDB.setFistName(singer.getFistName());
			singerFromDB.setLastName(singer.getLastName());
			singerFromDB.setBirthDate(singer.getBirthDate());
			singerService.save(singerFromDB);
			return "redirect:/singer/" + singer.getId();
		}
	}

}
