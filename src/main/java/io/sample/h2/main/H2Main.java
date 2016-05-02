package io.sample.h2.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.sample.h2.service.SampleService;

public class H2Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("springConfig.xml");
		SampleService sampleService = (SampleService) context.getBean("sampleServiceImpl");
		sampleService.getNameByNamedParameterJdbcOperations("kim");
		sampleService.getNameByNamedParameterJdbcTemplate("kim");
	}

}