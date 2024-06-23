package com.comcast.crm.ContactTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class DataProviderxcel {
	@Test(dataProvider = "logindata")
	public void getdata(String productname,String productPrice) {
		System.out.println("productname : "+productname+" product price: "+productPrice);
		
		
	}
	

	@DataProvider
	public Object[][] logindata() throws Exception {

		ExcelUtility Elib = new ExcelUtility();
		int rowCount = Elib.getRowcount("Sheet1");

		Object[][] obj = new Object[rowCount][2];
		for (int i = 1; i < rowCount; i++) {
			obj[i][0] = Elib.getDataFromExcel("Sheet1", i , 0);
			obj[i][1] = Elib.getDataFromExcel("Sheet1", i , 1);
		}

		return obj;
	}

}
