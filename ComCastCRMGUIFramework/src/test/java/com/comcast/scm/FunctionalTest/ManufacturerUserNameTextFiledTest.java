package com.comcast.scm.FunctionalTest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.ObjectRepo.ManufacturerPage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;
/**
 * @author girija sankar
 * functional test of manufacturer username textField
 */

   
public class ManufacturerUserNameTextFiledTest extends BaseClassforScm {
	
      WebDriverUtility wlib=new WebDriverUtility();
	
	
	@Test
	public void muserNameValidTest() throws EncryptedDocumentException, IOException {
		
		String name = elib.getDataFromExcel("endtoend", 1, 1);
		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
		String email = elib.getDataFromExcel("endtoend", 1, 4);
		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getAddMaucaturer().click();
		ahp.addManufacturer(name, email, mobile, "ramkumar",password);
		
		Alert alt = driver.switchTo().alert();
		String altmsg = alt.getText();
		alt.accept();
		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
		Assert.assertEquals(actualAlertresult, altmsg);
		ahp.getSignOut().click();
		
		
	}
	
     @Test
     public void muserNameminCharTest() throws EncryptedDocumentException, IOException {
 		
 		String name = elib.getDataFromExcel("endtoend", 1, 1);
 		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
 		String email = elib.getDataFromExcel("endtoend", 1, 4);
 		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
 		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

 		AdminHomePage ahp=new AdminHomePage(driver);
 		ahp.getAddMaucaturer().click();
 		ahp.addManufacturer(name, email, mobile,"ramku", password);
 		
 		Alert alt = driver.switchTo().alert();
 		String altmsg = alt.getText();
 		alt.accept();
 		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
 		Assert.assertEquals(actualAlertresult, altmsg);
 		ahp.getSignOut().click();
     }	
     
     @Test
     public void muserNamemaxCharTest() throws EncryptedDocumentException, IOException {
 		
 		String name = elib.getDataFromExcel("endtoend", 1, 1);
 		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
 		String email = elib.getDataFromExcel("endtoend", 1, 4);
 		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
 		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

 		AdminHomePage ahp=new AdminHomePage(driver);
 		ahp.getAddMaucaturer().click();
 		ahp.addManufacturer(name, email, mobile,"ramkumarDasnew", password);
 		
 		Alert alt = driver.switchTo().alert();
 		String altmsg = alt.getText();
 		alt.accept();
 		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
 		Assert.assertEquals(actualAlertresult, altmsg);
 		ahp.getSignOut().click();
     }	
     
     @Test
     public void muserNameAlphaNumericTest() throws EncryptedDocumentException, IOException {
 		
 		String name = elib.getDataFromExcel("endtoend", 1, 1);
 		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
 		String email = elib.getDataFromExcel("endtoend", 1, 4);
 		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
 		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

 		AdminHomePage ahp=new AdminHomePage(driver);
 		ahp.getAddMaucaturer().click();
 		ahp.addManufacturer(name, email, mobile,"ramkumardas123", password);
 		
 		Alert alt = driver.switchTo().alert();
 		String altmsg = alt.getText();
 		alt.accept();
 		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
 		Assert.assertEquals(actualAlertresult, altmsg);
 		ahp.getSignOut().click();
     }		
     @Test
     public void muserNameMixCaseTest() throws EncryptedDocumentException, IOException {
 		
 		String name = elib.getDataFromExcel("endtoend", 1, 1);
 		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
 		String email = elib.getDataFromExcel("endtoend", 1, 4);
 		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
 		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

 		AdminHomePage ahp=new AdminHomePage(driver);
 		ahp.getAddMaucaturer().click();
 		ahp.addManufacturer(name, email, mobile,"ramkumarScm", password);
 		
 		Alert alt = driver.switchTo().alert();
 		String altmsg = alt.getText();
 		alt.accept();
 		String actualAlertresult = elib.getDataFromExcel("endtoend", 1, 6);
 		Assert.assertEquals(actualAlertresult, altmsg);
 		ahp.getSignOut().click();
     }		

     @Test
     public void muserNameNegativeEmpty() throws EncryptedDocumentException, IOException {
 		
 		String name = elib.getDataFromExcel("endtoend", 1, 1);
 		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
 		String email = elib.getDataFromExcel("endtoend", 1, 4);
 		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
 		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

 		AdminHomePage ahp=new AdminHomePage(driver);
 		ahp.getAddMaucaturer().click();
 		ahp.addManufacturer(name, email, mobile,"", password);
 	
 		  wlib.waitforElementPresent(driver, ahp.getEmptyErroMsg());
 		  boolean errorMsg = ahp.getEmptyErroMsg().isDisplayed();
 		  Assert.assertTrue(errorMsg);
 	
     }	
     @Test
     public void muserNameExceedingChar() throws EncryptedDocumentException, IOException {
  		
  		String name = elib.getDataFromExcel("endtoend", 1, 1);
  		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
  		String email = elib.getDataFromExcel("endtoend", 1, 4);
  		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
  		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

  		AdminHomePage ahp=new AdminHomePage(driver);
  		ahp.getAddMaucaturer().click();
  		ahp.addManufacturer(name, email, mobile,"girijasanakarkumar", password);
  	
  		  boolean errorMsg = ahp.getErrorMsg().isDisplayed();
  		  Assert.assertTrue(errorMsg);
     }
     
     @Test
     public void muserNameWithSpecialChar() throws EncryptedDocumentException, IOException {
  		
  		String name = elib.getDataFromExcel("endtoend", 1, 1);
  		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
  		String email = elib.getDataFromExcel("endtoend", 1, 4);
  		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
  		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

  		AdminHomePage ahp=new AdminHomePage(driver);
  		ahp.getAddMaucaturer().click();
  		ahp.addManufacturer(name, email, mobile,"girijasanaka@a", password);
  	
  		  boolean errorMsg = ahp.getErrorMsg().isDisplayed();
  		  Assert.assertTrue(errorMsg);
     }
     @Test
     public void muserNameWithSpace() throws EncryptedDocumentException, IOException {
  		
  		String name = elib.getDataFromExcel("endtoend", 1, 1);
  		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
  		String email = elib.getDataFromExcel("endtoend", 1, 4);
  		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
  		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

  		AdminHomePage ahp=new AdminHomePage(driver);
  		ahp.getAddMaucaturer().click();
  		ahp.addManufacturer(name, email, mobile,"girijasanaka  ", password);
  	
  		  boolean errorMsg = ahp.getErrorMsg().isDisplayed();
  		  Assert.assertTrue(errorMsg);
     }
     @Test
     public void muserNameHtmlTags() throws EncryptedDocumentException, IOException {
  		
  		String name = elib.getDataFromExcel("endtoend", 1, 1);
  		String userName = elib.getDataFromExcel("endtoend", 1, 2) ;
  		String email = elib.getDataFromExcel("endtoend", 1, 4);
  		String password = elib.getDataFromExcel("endtoend", 1, 3) ;
  		String mobile = elib.getDataFromExcel("endtoend", 1, 5);

  		AdminHomePage ahp=new AdminHomePage(driver);
  		ahp.getAddMaucaturer().click();
  		ahp.addManufacturer(name, email, mobile,"<script>alert('XSS')</script>", password);
  	
  		  boolean errorMsg = ahp.getErrorMsg().isDisplayed();
  		  Assert.assertTrue(errorMsg);
     }
     
}
