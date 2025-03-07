package com.utk.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	private static Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping(path = "/home")
	public String home(Model model) {
		logger.info(">>>>>>>>> Inside home method >>>>>>>>>>>>>");
		model.addAttribute("message", "Spring MVC ThymeleafExample!!");
		return "home";
	}
}