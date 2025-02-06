package com.utk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.utk.config.SimpleDataSourceConfig;
import com.utk.dao.impl.JdbcSingerDao;

public class DataSourceConfigTest {

	private static Logger logger = LoggerFactory.getLogger(DataSourceConfigTest.class);

	@Test
	public void testSimpleDataSource() throws SQLException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
				SimpleDataSourceConfig.class);
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		assertNotNull(dataSource);
		testDataSource(dataSource);
		testSpringJdbc(context);
		context.close();

	}

	private void testDataSource(DataSource dataSource) throws SQLException {
		try(Connection connection = dataSource.getConnection();
			PreparedStatement statement = connection.prepareStatement("Select 1");
				ResultSet resultSet = statement.executeQuery();
		) {
			while (resultSet.next()) {
				int mockVal = resultSet.getInt("1");
				assertEquals(1, mockVal);
			}
		} catch (Exception e) {
			logger.debug("Something unusual happened.", e);
		}
	}

	private void testSpringJdbc(AnnotationConfigApplicationContext context) {
		JdbcSingerDao singerDao = context.getBean("singerDao", JdbcSingerDao.class);
		assertEquals("John Mayer", singerDao.findNameById(1l));
	}
}
