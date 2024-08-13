package com.comcast.scm.IntegartionTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.ObjectRepo.ManufacturerPage;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.fileutility.FileUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class AdminRelatedIntegrationTest {
	WebDriver driver;
	public static ExcelUtility elib = new ExcelUtility();
	public static JavaUtility jlib = new JavaUtility();
	public static WebDriverUtility wlib = new WebDriverUtility();
	public static FileUtility flib = new FileUtility();

	@Test
	public void AdminAddRetailerDisplayInRetailerList()
			throws EncryptedDocumentException, IOException, InterruptedException {

		String USERNAME = flib.getdatafromproperties("username");
		String PASSWORD = flib.getdatafromproperties("password");
		String URL = flib.getdatafromproperties("url");

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);

		AdminHomePage ahp = new AdminHomePage(driver);
		// reading required data from excel file
		String username = elib.getDataFromExcel("endtoend", 4, 1) + jlib.getRandomNumber();
		String password = elib.getDataFromExcel("endtoend", 4, 2);
		String phone = elib.getDataFromExcel("endtoend", 4, 3);
		String email = elib.getDataFromExcel("endtoend", 4, 4);
		String address = elib.getDataFromExcel("endtoend", 4, 5);

		// adding new retailer as admin
		ahp.addRetailer(username, password, phone, email, address);

		Alert alt = driver.switchTo().alert();
		String expectedaltmsg = alt.getText();
		// accepting sucessfull alert popup
		alt.accept();

		ahp.getAdminRetailer().click();

		List<WebElement> retailers = ahp.getRetailerListAdminPage();
		for (WebElement retailer : retailers) {
			String retailerUname = retailer.getText();
			if (retailerUname.equals(username)) {
				Assert.assertEquals(username, retailerUname);
			}

		}
		ahp.getSignOut().click();
		driver.quit();
	}

	@Test
	public void adminAddingRetailerDisplayinManufacturePage()
			throws InterruptedException, EncryptedDocumentException, IOException {
		//

		String USERNAME = flib.getdatafromproperties("username");
		String PASSWORD = flib.getdatafromproperties("password");
		String URL = flib.getdatafromproperties("url");

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);

		AdminHomePage ahp = new AdminHomePage(driver);
		// reading required data from excel file
		String Rusername = elib.getDataFromExcel("endtoend", 4, 1) + jlib.getRandomNumber();
		String password = elib.getDataFromExcel("endtoend", 4, 2);
		String phone = elib.getDataFromExcel("endtoend", 4, 3);
		String email = elib.getDataFromExcel("endtoend", 4, 4);
		String address = elib.getDataFromExcel("endtoend", 4, 5);

		// adding new retailer as admin
		ahp.addRetailer(Rusername, password, phone, email, address);

		Alert alt = driver.switchTo().alert();
		String expectedaltmsg = alt.getText();
		// accepting sucessfull alert popup
		alt.accept();

		ahp.getSignOut().click();

		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);

		lp.manufact2Login(manuname, manpwd);

		ManufacturerPage mhp = new ManufacturerPage(driver);
		mhp.getRetailerListBtn().click();

		List<WebElement> retailers = mhp.getRetailerList();
		for (WebElement retailer : retailers) {
			if (retailer.equals(Rusername)) {
				Assert.assertTrue(true);
			}
		}
		mhp.getLogoutBtn().click();
		driver.quit();

	}
	
	/**
	 * this is integration testing of admin portal and data flow between admin add distrbutor and distributor list in admin page
	 * @throws IOException 
	 */
	
	@Test
	public void adminAddDistributorDisplayinAdminList() throws IOException
	{
		String USERNAME = flib.getdatafromproperties("username");
		String PASSWORD = flib.getdatafromproperties("password");
		String URL = flib.getdatafromproperties("url");

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);

		AdminHomePage ahp = new AdminHomePage(driver);
		
		ahp.getAddDistributorBtn().click();
		
		 String name = elib.getDataFromExcel("endtoend", 7, 1);
	  		String email= elib.getDataFromExcel("endtoend", 7, 2);
	  		String phone = elib.getDataFromExcel("endtoend", 7, 3);
	  		String address = elib.getDataFromExcel("endtoend", 7, 4); 
	  		
	  		
	  		//adding distributor with valid data
	  		ahp.addDistributor(name, email, phone, address);
	  	      
	  		Alert alt=driver.switchTo().alert();
	  		String expectedAltMsg = alt.getText();
	  		alt.accept();
		
	}

}
