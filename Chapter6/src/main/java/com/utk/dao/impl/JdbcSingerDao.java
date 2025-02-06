package com.utk.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.InitializingBean;

import com.utk.dao.SingerDao;

public class JdbcSingerDao implements SingerDao, InitializingBean {

	private static Logger logger = LoggerFactory.getLogger(JdbcSingerDao.class);

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		if (dataSource == null)
			throw new BeanCreationException("Must set datasource bean on SingerDao");
	}

	@Override
	public String findNameById(Long id) {
		String result = "";
		try (Connection connection = dataSource.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("select FIRST_NAME,LAST_NAME from singer where id=?");) {
			statement.setLong(1, 1);
			ResultSet resultSet = statement.executeQuery();
			while (resultSet.next()) {
				return resultSet.getString("FIRST_NAME") + " " + resultSet.getString("LAST_NAME");
			}
		} catch (Exception e) {
			logger.debug("Problem when executin select query.", e);
		}
		return result;
	}

}
