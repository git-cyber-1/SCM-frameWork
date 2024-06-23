package com.crm.comcast.ContactusingTestNGTest;

import org.testng.annotations.Test;

import com.comcast.crm.generic.BaseTest.BaseClassDemo;

public class CreateContactTest extends BaseClassDemo{
	
	@Test
	public void createContactTest() {
		System.out.println("execute contact test & verify");
	}
	@Test
	public void createContactTestWithPhoneNumberTest() {
		System.out.println("execute contact with phoneNumber & verify");
	}

}
