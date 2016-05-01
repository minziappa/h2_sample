package io.sample.h2.service;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import io.sample.h2.bean.Users;
import io.sample.h2.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig-test.xml"})
@DbUnitConfiguration(databaseConnection="dataSource")
@TestExecutionListeners({
	  DependencyInjectionTestExecutionListener.class,
	  DirtiesContextTestExecutionListener.class,
	  TransactionDbUnitTestExecutionListener.class, //<-- needed if using transactions otherwise use TransactionalTestExecutionListener.class
	  })
public class SampleServiceTest {

	@Autowired
	private SampleService sampleService;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
	}

	@Test
	public void testSpringJdbc() {
		Users users = sampleService.getNameByNamedParameterJdbcOperations("kim");
	    System.out.println("NamedParameterJdbcOperations >>> " + users.getEmail());

		users = sampleService.getNameByNamedParameterJdbcTemplate("joon");
	    System.out.println("NamedParameterJdbcTemplate >>> " + users.getEmail());
	}

//	@Test
//	@DatabaseSetup(value="/xml/sampleData.xml", type=DatabaseOperation.CLEAN_INSERT)
//	@DatabaseTearDown(value="/xml/sampleData.xml", type=DatabaseOperation.DELETE_ALL)
//	@Transactional
//	public void test01() {
//	    //some code
//	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After");
	}

}