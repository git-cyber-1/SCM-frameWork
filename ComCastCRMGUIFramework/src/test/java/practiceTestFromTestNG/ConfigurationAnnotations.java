package practiceTestFromTestNG;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
/**
  
 **/

public class ConfigurationAnnotations {
	@BeforeSuite
	public void beforesuit() {
		System.out.println("before suit");
	}

	@BeforeTest
	public void beforetest() {
		System.out.println("before test");
	}

	@BeforeClass
	public void beforeclass() {
		System.out.println("before class");
	}

	@BeforeMethod
	public String configBM() {
		System.out.println("before method");
		return null;
	}

	@Test
	public void createOrgTest() {
		System.out.println("Execute OrgTest");
	}

	@AfterMethod
	public void aftermethod() {
		System.out.println("after method");

	}

	@AfterClass
	public void afterclass() {
		System.out.println("after class");

	}

	@Test
	public void createOrgWithIndustry() {
		System.out.println("execute createOrgWithIndustry");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
	}

	@AfterSuite
	public void aftersuit() {
		System.out.println("after suit");
	}

}
