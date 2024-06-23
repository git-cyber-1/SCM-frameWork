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

public class CreateOrgTestWithIndustrieswithpom {
	@Test
	public void createorg() throws IOException, InterruptedException {
		FileUtility fu = new FileUtility();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriverUtility wu = new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");
		String orgname = eu.getDataFromExcel("org", 1, 2) + ju.getRandomNumber();
		String industry = eu.getDataFromExcel("org", 4, 3);

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
		wu.maximizePage(driver);
		wu.waitForPageToLoad(driver);

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL,USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage opage = new OrganizationsPage(driver);
		opage.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage cnop = new CreateNewOrganizationsPage(driver);
		cnop.createOrg(orgname, industry);

		OrganizationInfoPage oipage = new OrganizationInfoPage(driver);
		String actindustry = oipage.getIndustry().getText();
		if (actindustry.contains(industry)) {
			System.out.println(industry + " industrty verified=====passed");
		} else {
			System.out.println(industry + " not verified ====failed");
		}
		Thread.sleep(3000);
		driver.quit();
	}

}
