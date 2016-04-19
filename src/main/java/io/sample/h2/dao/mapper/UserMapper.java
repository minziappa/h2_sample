package io.sample.h2.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import io.sample.h2.bean.Users;

public class UserMapper implements RowMapper<Users> {
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users users = new Users();
		users.setId(rs.getInt("id"));
		users.setName(rs.getString("name"));
		users.setEmail(rs.getString("email"));
		return users;
	}
}
