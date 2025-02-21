package com.utk.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan(basePackages = { "com.utk.repo", "com.utk.service" })
@EnableScheduling
public class TaskSchedulingConfig {

}
