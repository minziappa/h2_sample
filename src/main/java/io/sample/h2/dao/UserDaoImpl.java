package io.sample.h2.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcOperations;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.sample.h2.bean.Users;
import io.sample.h2.dao.mapper.UserMapper;

@Repository
public class UserDaoImpl implements UserDao {

	NamedParameterJdbcOperations namedParameterJdbcOperations;

	@Autowired
	public void setNamedParameterJdbcOperations(DataSource dataSource) {
		this.namedParameterJdbcOperations = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public Users findByName(String name) {

		Map<String, Object> params = new HashMap<String, Object>();
        params.put("name", name);

		String sql = "SELECT * FROM one.users WHERE name=:name";
        Users result = namedParameterJdbcOperations.queryForObject(sql, params, new UserMapper());

        return result;
	}

	@Override
	public List<Users> findAll() {
		Map<String, Object> params = new HashMap<String, Object>();

		String sql = "SELECT * FROM one.users";
        List<Users> result = namedParameterJdbcOperations.query(sql, params, new UserMapper());

        return result;
	}

}
