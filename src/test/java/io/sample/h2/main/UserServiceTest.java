package io.sample.h2.main;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;

import io.sample.h2.bean.User;
import io.sample.h2.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig-test.xml"})
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DbUnitTestExecutionListener.class })
public class UserServiceTest {

	@Autowired
	private SampleService sampleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
	}

	@Test
	@DatabaseSetup("/xml/sampleData.xml")
	public void test1() { 
	    User user = sampleService.getName();;
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After");
	}

}