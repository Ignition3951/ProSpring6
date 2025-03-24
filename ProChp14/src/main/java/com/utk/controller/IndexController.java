package com.utk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class IndexController {

	@GetMapping("index")
	public String auth(Model model, HttpServletRequest request) {
		String requestUrl = request.getRequestURI().toString();
		String webSocketAddress = requestUrl.replace("http", "ws").replace("index", "echoHandler");
		model.addAttribute("webSocket", webSocketAddress);
		return "index";
	}
}
