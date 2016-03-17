package io.sample.h2.service;

import java.util.List;

import io.sample.h2.bean.User;

public interface SampleService {

	public User getName();
	public List<User> getAll();

}