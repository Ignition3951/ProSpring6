package com.utk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EntityScan(basePackages = { "com.utk.entity" })
@EnableJpaRepositories(basePackages = { "com.utk.repo" })
@EnableTransactionManagement
@SpringBootApplication
public class ProChp14Main {

	public static void main(String[] args) {
		System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, "dev");
		SpringApplication.run(ProChp14Main.class, args);
	}

}
