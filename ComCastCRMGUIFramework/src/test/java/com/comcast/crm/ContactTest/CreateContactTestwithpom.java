package com.comcast.crm.ContactTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.ContactInfoPage;
import com.comcast.crm.ObjectRepository.ContactPage;
import com.comcast.crm.ObjectRepository.CreateContactPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactTestwithpom {
	@Test
	public void createorg() throws IOException {

		// create object
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");

		// data from excelfile
		String lastname = eu.getDataFromExcel("contact", 1, 2) +jlib.getRandomNumber();

		WebDriver driver = null;
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.get(URL);
		wlib.maximizePage(driver);
		wlib.waitForPageToLoad(driver);
		
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);
		
		HomePage hp=new HomePage(driver);
		hp.getContactLink().click();
		
		ContactPage cp=new ContactPage(driver);
		cp.getCrtcontactBtn().click();
		
		CreateContactPage ccp=new CreateContactPage(driver);
		ccp.createcontact(lastname);
		
		ContactInfoPage cipage=new ContactInfoPage(driver);
		String actheadmsg = cipage.getHeaderMsg().getText();
		
		if (actheadmsg.contains(lastname)) {
			System.out.println(lastname + " verified=====passed");
		} else {
			System.out.println(lastname + " not verified ====failed");
		}

		driver.close();
	}

}
