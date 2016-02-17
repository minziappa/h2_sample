package io.sample.h2.dao;

import java.util.List;

import io.sample.h2.bean.User;

public interface UserDao {
	public User findByName(String name);
	public List<User> findAll();
}
