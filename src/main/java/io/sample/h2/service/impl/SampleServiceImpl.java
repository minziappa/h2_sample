package io.sample.h2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sample.h2.bean.User;
import io.sample.h2.dao.UserDao;
import io.sample.h2.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private UserDao userDaoImpl;

	@Override
	public User getName(String name) {
		User user = userDaoImpl.findByName(name);
		System.out.println(">>> + " + user.getEmail());
		return user;
	}

	@Override
	public List<User> getAll() {
		return userDaoImpl.findAll();
	}

}