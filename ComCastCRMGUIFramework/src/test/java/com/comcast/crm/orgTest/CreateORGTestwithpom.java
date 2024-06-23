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

public class CreateORGTestwithpom {
	@Test
	public void createorg() throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");
		String orgname = eu.getDataFromExcel("org", 1, 2) + ju.getRandomNumber();

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

		// LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		// for simplify
		LoginPage login = new LoginPage(driver);

		// USING SINGLE ELEMENT ACCESS
		/*
		 * login.getUsernameEdt().sendKeys(USERNAME);
		 * login.getPasswordEdt().sendKeys(PASSWORD); login.getLoginBtn().click();
		 */

		// USING BUSINESS LIBRARY
		login.loginToApp(URL,USERNAME, PASSWORD);

		// navigation to organisationpage by homepage
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		// click on create organisation

		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		// enter all details and save createNewOrganization

		CreateNewOrganizationsPage orgpage = new CreateNewOrganizationsPage(driver);
		orgpage.createOrg(orgname);

		// verifyHeaderMsg ExpectedResult
		OrganizationInfoPage oinfo = new OrganizationInfoPage(driver);
		String actOrgName = oinfo.getHeaderMsg().getText();
		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + " name is verified >>>>> passs");
		} else {
			System.out.println(orgname + "name is not verified >>>> failed");
		}

		/*
		 * driver.findElement(By.
		 * xpath("//b[contains(.,'Organiz')]/parent::td/../preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']"
		 * )).click(); String header =
		 * driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText(); if
		 * (header.contains(orgname)) { System.out.println(orgname +
		 * " header verified=====passed"); } else { System.out.println(orgname +
		 * "header not verified ====failed"); } String actorgname =
		 * driver.findElement(By.xpath("//*[@id=\"dtlview_Organization Name\"]")).
		 * getText(); if (actorgname.equals(orgname)) { System.out.println(orgname +
		 * " information is created =====pass"); } else { System.out.println(orgname +
		 * " information is not created ====fail"); }
		 */
		// signout
		Thread.sleep(3000);
		hp.signOut();
		driver.quit();

	}

}
