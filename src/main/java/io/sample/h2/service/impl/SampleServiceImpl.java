package io.sample.h2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sample.h2.bean.Users;
import io.sample.h2.dao.UserByNamedParameterJdbcDao;
import io.sample.h2.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private UserByNamedParameterJdbcDao userByNamedParameterJdbcOperationsDao;

	@Autowired
	private UserByNamedParameterJdbcDao userByNamedParameterJdbcTemplateDao;

	@Override
	public Users getNameByNamedParameterJdbcOperations(String name) {
		Users users = userByNamedParameterJdbcOperationsDao.findByName(name);
		System.out.println(">>> + " + users.getEmail());
		return users;
	}

	@Override
	public Users getNameByNamedParameterJdbcTemplate(String name) {
		Users users = userByNamedParameterJdbcTemplateDao.findByName(name);
		System.out.println(">>>2 + " + users.getEmail());
		return null;
	}

	@Override
	public List<Users> getAll() {
		return userByNamedParameterJdbcOperationsDao.findAll();
	}

}