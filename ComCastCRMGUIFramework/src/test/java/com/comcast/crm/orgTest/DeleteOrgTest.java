package com.comcast.crm.orgTest;

import java.io.IOException;

import org.openqa.selenium.By;
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

public class DeleteOrgTest {
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
		String orgname = eu.getDataFromExcel("org", 10, 2) + ju.getRandomNumber();

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

		LoginPage login = new LoginPage(driver);

		login.loginToApp(URL, USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		OrganizationsPage orgPage = new OrganizationsPage(driver);
		orgPage.getCreateNewOrgBtn().click();

		CreateNewOrganizationsPage createorgpage = new CreateNewOrganizationsPage(driver);
		createorgpage.createOrg(orgname);

		OrganizationInfoPage oinfo = new OrganizationInfoPage(driver);
		String actOrgName = oinfo.getHeaderMsg().getText();
		if (actOrgName.contains(orgname)) {
			System.out.println(orgname + " name is verified >>>>> passs");
		} else {
			System.out.println(orgname + "name is not verified >>>> failed");
		}

		// GO BACK TO ORGANISATION PAGE
		hp.getOrgLink().click();

		// search for organisation
		orgPage.getSearchBox().sendKeys(orgname);
		wlib.select(orgPage.getSearchDD(), "Organization Name");
		orgPage.getSearchBtn().click();

		driver.findElement(By.xpath(
				"//a[text()='" + orgname + "']/ancestor::tr[@bgcolor=\"white\"]/descendant::a[contains(text(),'del')]"))
				.click();

		Thread.sleep(3000);
		// hp.signOut();
		// driver.quit();

	}

}
