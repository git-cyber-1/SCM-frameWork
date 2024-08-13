package com.comcast.scm.EndToEndTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;

/**
 * @author Girija Sankar
 * EndToEnd scenario
 */



public class AdminAddManRetailDistruburorTest extends BaseClassforScm {

	
	
	@Test
	public void admincreatingManufacturer() throws EncryptedDocumentException, IOException, InterruptedException {
		//this method for adding manufacture and creating credentials for manufacture
		
		JavaUtility jlb = new JavaUtility();
		ExcelUtility elib = new ExcelUtility();
		
		 AdminHomePage ahp = new AdminHomePage(driver);
		String name = elib.getDataFromExcel("endtoend", 1, 1);
		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
		String email = elib.getDataFromExcel("endtoend", 1, 4);
		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

		// navigate to add manufacturer page
	
		// providing all valid details to add manufacturer
		ahp.addManufacturer(name, email, mobile, userName, password);
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
		Assert.assertEquals(actualAlertresult, altmsg);
		String expectedMsg = ahp.getManufactuererMsgInAdminPage().getText();
		String actmsg = elib.getDataFromExcel("endtoend", 1, 7);
		Assert.assertEquals(actmsg, expectedMsg);

	}
	
     @Test
     public void adminAddRetailerTest() throws EncryptedDocumentException, IOException, InterruptedException
     {
    	  AdminHomePage ahp = new AdminHomePage(driver);
    	  //reading required data from excel file
 		String username = elib.getDataFromExcel("endtoend", 4, 1);
 		String password = elib.getDataFromExcel("endtoend", 4, 2);
 		String phone = elib.getDataFromExcel("endtoend", 4, 3);
 		String email = elib.getDataFromExcel("endtoend", 4, 4); 
 		String address = elib.getDataFromExcel("endtoend", 4, 5);

 		//adding new retailer as admin
    	ahp.addRetailer(username, password, phone, email, address);
    	
    	
    	Alert alt = driver.switchTo().alert();
		String expectedaltmsg = alt.getText();
		//accepting sucessfull alert popup
		alt.accept();
     
		String actaltmsg = elib.getDataFromExcel("endtoend", 4, 6);
		//validating popup message
		Assert.assertEquals(actaltmsg ,expectedaltmsg);
		String expectedMsg = ahp.getRetailerWelcomeMsg().getText();
		
		//validating welcome message in retailer page
		String actualMsg = elib.getDataFromExcel("endtoend", 4, 7);
		Assert.assertEquals(actualMsg,expectedMsg);
		
     }
     @Test
     public void adminAddDistributorTest() throws EncryptedDocumentException, IOException
     {
    	 AdminHomePage ahp = new AdminHomePage(driver);
    	 //reading required data from excel file
    	 String name = elib.getDataFromExcel("endtoend", 7, 1);
  		String email= elib.getDataFromExcel("endtoend", 7, 2);
  		String phone = elib.getDataFromExcel("endtoend", 7, 3);
  		String address = elib.getDataFromExcel("endtoend", 7, 4); 
  		
  		
  		//adding distributor with valid data
  		ahp.addDistributor(name, email, phone, address);
  	      
  		Alert alt=driver.switchTo().alert();
  		String expectedAltMsg = alt.getText();
  		alt.accept();
  		
  		String actualAltMsg = elib.getDataFromExcel("endtoend", 7, 6);
  		Assert.assertEquals(actualAltMsg,expectedAltMsg );
  		
  		String expectedWelcomeMsg = ahp.getDistributorWelcomMsg().getText();
  		String actualWelcomeMsg = elib.getDataFromExcel("endtoend", 7, 7);
    	 
  		Assert.assertEquals(actualWelcomeMsg,expectedWelcomeMsg);
    	 
     }
 
}
