package com.utk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.utk.service.impl.SingerServiceImpl;

@Import(BasicDataSourceConfig.class)
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = { SingerServiceImpl.class })
@EnableJpaRepositories(basePackages = "com.utk.repo")
public class JpaConfig {

	@Autowired
	DataSource dataSource;

	@Bean
	public PlatformTransactionManager transactionManager() {
		JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
		jpaTransactionManager.setEntityManagerFactory(entityManagerFactory().getObject());
		return jpaTransactionManager;
	}

	@Bean
	public JpaVendorAdapter vendorAdapter() {
		return new HibernateJpaVendorAdapter();
	}

	@Bean
	public Properties properties() {
		Properties properties = new Properties();
		properties.put(Environment.HBM2DDL_AUTO, "none");
		properties.put(Environment.FORMAT_SQL, false);
		properties.put(Environment.USE_SQL_COMMENTS, false);
		properties.put(Environment.SHOW_SQL, false);
		properties.put("BATCH_SIZE", 30);
		return properties;
	}

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
		LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setJpaVendorAdapter(vendorAdapter());
		factoryBean.setPackagesToScan("com.utk.entity");
		factoryBean.setJpaProperties(properties());
		return factoryBean;
	}
}
