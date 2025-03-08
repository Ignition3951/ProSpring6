package com.utk.controller;

import java.util.Comparator;
import java.util.List;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.utk.entity.AbstractEntity;
import com.utk.entity.Singer;
import com.utk.service.SingerService;

@Controller
@RequestMapping("/singers")
public class SingersController {

	private static Comparator<AbstractEntity> COMPARATOR_ID = Comparator.comparing(AbstractEntity::getId);

	private final SingerService singerService;

	private final MessageSource messageSource;

	public SingersController(SingerService singerService, MessageSource messageSource) {
		this.singerService = singerService;
		this.messageSource = messageSource;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Singer> singers = singerService.findAll();
		singers.sort(COMPARATOR_ID);
		model.addAttribute("singers", singers);
		return "singers/list";
	}

}
