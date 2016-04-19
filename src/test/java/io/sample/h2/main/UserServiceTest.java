package io.sample.h2.main;

import static org.junit.Assert.assertEquals;

import java.sql.PreparedStatement;
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
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;

import io.sample.h2.bean.User;
import io.sample.h2.bean.Users;
import io.sample.h2.dao.UserDao;
import io.sample.h2.service.SampleService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:springConfig-test.xml"})
@DbUnitConfiguration(databaseConnection="dataSource")
@TestExecutionListeners({
	  DependencyInjectionTestExecutionListener.class,
	  DirtiesContextTestExecutionListener.class,
//	  TransactionDbUnitTestExecutionListener.class, //<-- needed if using transactions otherwise use TransactionalTestExecutionListener.class
	  })
public class UserServiceTest {

	@Autowired
	private SampleService sampleService;
	@Autowired
	private UserDao userDao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
	}

	@Test
	@DatabaseSetup("/xml/sampleData.xml")
	public void test1() {
		// Users users = userDao.findByName("kim");

		Users users = sampleService.getName("kim");
	    System.out.println("email >>> " + users.getEmail());
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