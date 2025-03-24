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

	@GetMapping(path = "index2")
	public String index2(Model model, HttpServletRequest request) {
		var requestUrl = request.getRequestURL().toString();
		var webSocketAddress = requestUrl.replace("index2", "sockjs/echoHandler");
		model.addAttribute("webSocket", webSocketAddress);
		return "index2";
	}

	@GetMapping(path = "index3")
	public String index3(Model model, HttpServletRequest request) {
		var requestUrl = request.getRequestURL().toString();
		var endpointAddress = requestUrl.replace("index3", "ws");
		model.addAttribute("endpoint", endpointAddress);
		return "index3";
	}
}
