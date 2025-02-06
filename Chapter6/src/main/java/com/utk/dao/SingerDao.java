package com.utk.dao;

public interface SingerDao {

	String findNameById(Long id);

	String findNameByIdByJdbcTemplate(Long id);
}
