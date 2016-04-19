package io.sample.h2.service;

import java.util.List;

import io.sample.h2.bean.User;
import io.sample.h2.bean.Users;

public interface SampleService {

	public Users getName(String name);
	public List<Users> getAll();

}