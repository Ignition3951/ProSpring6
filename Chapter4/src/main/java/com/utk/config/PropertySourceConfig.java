package com.utk.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

import com.utk.service.ConfigurableMessageProvider;
import com.utk.service.MessageProvider;
import com.utk.service.MessageRenderer;
import com.utk.service.StandardOutMessageRenderer;

@Configuration
@PropertySource(value = "classpath:message.properties")
public class PropertySourceConfig {

	@Autowired
	Environment env;

	@Bean
	@Lazy
	public MessageProvider messageProvider() {
		return new ConfigurableMessageProvider(env.getProperty("message"));
	}

	@Bean(name = "messageRenderer")
	@Scope(value = "prototype")
	@DependsOn(value = "messageProvider")
	public MessageRenderer messageRenderer() {
		MessageRenderer renderer = new StandardOutMessageRenderer();
		renderer.setMessageProvider(messageProvider());
		return renderer;
	}

}
