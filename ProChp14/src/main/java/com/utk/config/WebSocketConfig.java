package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import com.utk.websocket.EchoHandler;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler(), "/echoHandler");
		registry.addHandler(echoHandler2(), "/sockjs/echoHandler").withSockJS();
	}

	@Bean
	public EchoHandler echoHandler() {
		return new EchoHandler();
	}

	@Bean
	public EchoHandler echoHandler2() {
		return new EchoHandler();
	}

}
