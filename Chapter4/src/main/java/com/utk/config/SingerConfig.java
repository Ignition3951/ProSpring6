package com.utk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.utk.model.Singer;

@Configuration
public class SingerConfig {

	@Bean(initMethod = "init")
	Singer singerOne() {
		Singer singer = new Singer();
		singer.setName("SingerOne");
		singer.setAge(43);
		return singer;
	}

	@Bean(initMethod = "init")
	Singer singerTwo() {
		Singer singer = new Singer();
		singer.setAge(42);
		return singer;
	}

	@Bean(initMethod = "init")
	Singer singerThree() {
		Singer singer = new Singer();
		return singer;
	}

}
