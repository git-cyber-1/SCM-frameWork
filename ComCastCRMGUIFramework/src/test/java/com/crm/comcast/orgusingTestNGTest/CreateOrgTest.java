package com.crm.comcast.orgusingTestNGTest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.BaseTest.BaseClassDemo;

public class CreateOrgTest extends BaseClassDemo {
	
	@Test
	public void createOrgTest() {
		System.out.println("execute orgTest & verify");
	}
	
	@Test
	public void CreateOrgWithIndustries() {
		System.out.println("execute orgTestWithIndustries & verify");
	}

}
