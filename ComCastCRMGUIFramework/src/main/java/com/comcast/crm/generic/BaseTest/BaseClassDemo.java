package com.comcast.crm.generic.BaseTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseClassDemo {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("====CONNECT DB======,=======REPORT CONFIG=======");
	}
	@BeforeClass
	public void configBC() {
		System.out.println("launch browser");
	}
	@BeforeMethod
		public void configBM() {
			System.out.println("LOGIN TO APPLICATION");
		}
	@AfterMethod
	public void configAM() {
		System.out.println("LOGOUT FROM APPLICATION");
	}
	@AfterClass
	public void configAC() {
		System.out.println("CLOSE BROWSER");
	}
	@AfterSuite
	public void configAS() {
		System.out.println("======CLOSE DB CONNECTION======,=====REPORT BACKUP=======");
	}
	
	
	}


