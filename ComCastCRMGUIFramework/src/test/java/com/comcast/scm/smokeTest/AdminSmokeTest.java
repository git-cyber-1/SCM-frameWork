package com.comcast.scm.smokeTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.fileutility.FileUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;
/**
 * @author girija sankar
 * smoke test script
 */

public class AdminSmokeTest extends BaseClassforScm{
	    
	@Test(groups= {"ST"},priority = 1)
	public void loginPageValidationTest() throws IOException
	{
		// this is to verify whether login page is opening or not
		LoginPage lp=new LoginPage(driver);
		FileUtility flib=new FileUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		//WebDriver driver=null;
		String URL =flib.getdatafromproperties("url");
		 driver=new ChromeDriver();
		wlib.maximizePage(driver);
		wlib.waitForPageToLoad(driver);
		driver.get(URL);
	    String title = driver.getTitle();
	     Assert.assertEquals("Login",title);
	      System.out.println("==============page validation passed=====================");
	    
	      
	      // driver.close();
		    
		}
	@Test(groups= {"ST"},priority = 2)
	public void adminLoginValidationTest()
	{
	         //To verify after login as admin whether Admin page is loaded or not
	            AdminHomePage ahp=new AdminHomePage(driver);
		        String msg = ahp.getWelcomemsg().getText();
		        System.out.println(msg);
		        Assert.assertEquals("Welcome Admin",msg);
		        
		      
   
	}

     @Test(groups= {"ST"},priority = 3)
     public void adminableToClickOnAddManufacturerTest() throws InterruptedException
     {
    	 // to verify whether add manufacturer page is loading or not
    	 AdminHomePage ahp=new AdminHomePage(driver);
    	 ahp.getAddMaucaturer().click();
    	    String message = ahp.getManufactuererMsgInAdminPage().getText();
    	 Assert.assertEquals("Add Manufacturer",message);
    	 
    	 
     }
    
     @Test(groups= {"ST"},priority = 4)
     public void adminAbleToAddManufacturerSucessfullyTest() throws EncryptedDocumentException, IOException
     {
    	 //to verify whether admin able to add Manufacturer sucessfully or not
    	
    	 
    	 ExcelUtility elib = new ExcelUtility();
 		
		
		String name = elib.getDataFromExcel("endtoend", 1, 1);
		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
		String email = elib.getDataFromExcel("endtoend", 1, 4);
		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
		String mobile = elib.getDataFromExcel("endtoend", 1, 5);
    	 
    	 
    	 
    	 
    	 AdminHomePage ahp=new AdminHomePage(driver);
           // navigate to add manufacturer page
    	 ahp.getAddMaucaturer().click();
    	 
        // providing all valid details to add manufacturer
 		ahp.addManufacturer(name, email, mobile, userName, password);
 		
 		//handling alert popup
 		Alert alt = driver.switchTo().alert();
 		String altmsg = alt.getText();
 		alt.accept();
 		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
 		
 		//validating alert popup msg
 		Assert.assertEquals(actualAlertresult, altmsg);
 		String expectedMsg = ahp.getManufactuererMsgInAdminPage().getText();
 		String actmsg = elib.getDataFromExcel("endtoend", 1, 7);
 		//validating welcome msg of manufacturer page
 		Assert.assertEquals(actmsg, expectedMsg);

    	 
    	 
     }
	
       @Test
       public void logOutManufactuerTest() throws IOException
       {
    	       
              System.out.println("BASE CLASS WILL TAKE CARE OF IT");
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