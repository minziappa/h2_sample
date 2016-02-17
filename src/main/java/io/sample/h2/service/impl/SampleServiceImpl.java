package io.sample.h2.service.impl;

import org.springframework.stereotype.Service;

import io.sample.h2.service.SampleService;

@Service
public class SampleServiceImpl implements SampleService {

	@Override
	public void doTest() {
		
		System.out.println(">>>");
		
	}

}
