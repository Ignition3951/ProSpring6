package com.utk.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.cfg.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.utk.dao.impl.SingerDaoImpl;

@Import(SimpleDataSourceConfig.class)
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = { SingerDaoImpl.class })
public class HibernateConfig {

	private static Logger logger = LoggerFactory.getLogger(HibernateConfig.class);

	@Autowired
	DataSource dataSource;

	@Bean
	public Properties hibernateProperties() {
		Properties hibernateProps = new Properties();
		hibernateProps.put(Environment.HBM2DDL_AUTO, "none");
		hibernateProps.put(Environment.FORMAT_SQL, false);
		hibernateProps.put(Environment.SHOW_SQL, false);
		hibernateProps.put(Environment.USE_SQL_COMMENTS, false);
		hibernateProps.put(Environment.MAX_FETCH_DEPTH, 3);
		hibernateProps.put(Environment.STATEMENT_BATCH_SIZE, 10);
		hibernateProps.put(Environment.STATEMENT_FETCH_SIZE, 50);
		return hibernateProps;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setPackagesToScan("com.utk.entity");
		factoryBean.setHibernateProperties(hibernateProperties());
		return factoryBean;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		HibernateTransactionManager jpaTransactionManager = new HibernateTransactionManager();
		jpaTransactionManager.setSessionFactory(sessionFactory().getObject());
		return jpaTransactionManager;

	}

}
