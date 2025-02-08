package com.utk.config;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
@PropertySource("classpath:db/jdbc.properties")
public class SimpleDataSourceConfig {

	private static Logger logger = LoggerFactory.getLogger(SimpleDataSourceConfig.class);

	@Value("${jdbc.driverClassName}")
	private String driverClassName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Bean
	public DataSource dataSource() {
		try {
			HikariConfig hikariConfig = new HikariConfig();
			hikariConfig.setDriverClassName(driverClassName);
			hikariConfig.setJdbcUrl(url);
			hikariConfig.setUsername(username);
			hikariConfig.setPassword(password);
			HikariDataSource dataSource = new HikariDataSource(hikariConfig);
			dataSource.setMaximumPoolSize(25);
			return dataSource;

		} catch (Exception e) {
			logger.error("DBCP datasource could not be created!", e);
			return null;
		}
	}

}
