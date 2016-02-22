package io.sample.h2.main;

import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.github.springtestdbunit.DbUnitTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
//@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
//        DirtiesContextTestExecutionListener.class,
//        TransactionalTestExecutionListener.class,
//        DbUnitTestExecutionListener.class })
@ContextConfiguration(locations = {"classpath:springConfig-test.xml"})
public class H2MainTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Before");
	}
	
	@Test
	public void test1() { 
		assertEquals(new Double(1),new Double(1)); 
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("After");
	}

}
