package io.sample.h2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.sample.h2.bean.Users;
import io.sample.h2.dao.mapper.UserMapper;

@Repository
public class UserByNamedParameterJdbcTemplateDaoImpl implements UserByNamedParameterJdbcDao {

	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public Users findByName(String name) {

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

		String sql = "SELECT * FROM one.users WHERE name=:name";

		// 1. Using UserMapper
		// Users users = namedParameterJdbcTemplate.queryForObject(sql, params, new UserMapper());

		// 2. This case is using BeanPropertyRowMapper class ( Not use RowMapper)
		Users users = namedParameterJdbcTemplate.queryForObject(sql, params, new BeanPropertyRowMapper<>(Users.class));

        return users;
	}

	@Override
	public List<Users> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM one.users";
        List<Users> result = namedParameterJdbcTemplate.query(sql, params, new UserMapper());

        return result;
	}

}
