package com.comcast.crm.orgTest;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepository.CreateNewOrganizationsPage;
import com.comcast.crm.ObjectRepository.HomePage;
import com.comcast.crm.ObjectRepository.LoginPage;
import com.comcast.crm.ObjectRepository.OrganizationInfoPage;
import com.comcast.crm.ObjectRepository.OrganizationsPage;
import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgTestWithPhoneNumpom {
	@Test
	public void createorg() throws IOException {
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");
		String orgname = eu.getDataFromExcel("org", 7, 2) + ju.getRandomNumber();
		String phonenumber = eu.getDataFromExcel("org", 7, 3);

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
		wlib.maximizePage(driver);
		wlib.waitForPageToLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage opage = new OrganizationsPage(driver);
		opage.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage copage = new CreateNewOrganizationsPage(driver);
		copage.createOrgwithMobNum(orgname, phonenumber);

		OrganizationInfoPage oipage = new OrganizationInfoPage(driver);
		String actphno = oipage.getMobNum().getText();
		if (actphno.contains(phonenumber)) {
			System.out.println(phonenumber + "  verified=====passed");
		} else {
			System.out.println(phonenumber + " not verified ====failed");
		}

		driver.quit();
	}

}
