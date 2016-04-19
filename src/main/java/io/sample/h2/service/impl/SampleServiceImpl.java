package io.sample.h2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.sample.h2.bean.Users;
import io.sample.h2.dao.UserDao;
import io.sample.h2.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Autowired
	private UserDao userDaoImpl;

	@Override
	public Users getName(String name) {
		Users users = userDaoImpl.findByName(name);
		System.out.println(">>> + " + users.getEmail());
		return users;
	}

	@Override
	public List<Users> getAll() {
		return userDaoImpl.findAll();
	}

}