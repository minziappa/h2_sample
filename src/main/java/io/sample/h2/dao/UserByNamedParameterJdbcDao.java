package io.sample.h2.dao;

import java.util.List;

import io.sample.h2.bean.User;
import io.sample.h2.bean.Users;

public interface UserByNamedParameterJdbcDao {
	public Users findByName(String name);
	public List<Users> findAll();
}