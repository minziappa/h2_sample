package io.sample.h2.service.impl;

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
	public void doTest() {

		User user = userDaoImpl.findByName("kim");
		System.out.println(">>> + " + user.getName());
	}

}
