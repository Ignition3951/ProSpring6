package com.utk.config;

import java.net.URL;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.utk.record.Blogger;

@Configuration
@PropertySource(value = "classpath:/blogger.properties")
public class AppConfig {

	@Bean
	public Blogger awsBlogger(@Value("Alex") String firstName, @Value("DeBrie") String lastName,
			@Value("https://www.alexdebrie.com") URL personalSite, @Value("1980-01-02") LocalDate birthDate)
			throws Exception {
		return new Blogger(firstName, lastName, birthDate, personalSite);
	}

	@Bean
	public Blogger springBlogger(@Value("${springBlogger.firstName}") String firstName,
			@Value("${springBlogger.lastName}") String lastName,
			@Value("${springBlogger.personalSite}") URL personalSite,
			@Value("${springBlogger.birthDate}") LocalDate birthDate) throws Exception {
		return new Blogger(firstName, lastName, birthDate, personalSite);
	}
}
