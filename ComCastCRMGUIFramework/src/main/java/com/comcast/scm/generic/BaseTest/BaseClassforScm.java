package com.comcast.scm.generic.BaseTest;

import java.io.IOException;
import java.sql.SQLException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.generic.databaseutility.DataBaseUtility;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.fileutility.FileUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.UtilityClassObject;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class BaseClassforScm extends WebDriverUtility {
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	public JavaUtility jlib = new JavaUtility();
	public DataBaseUtility dlib = new DataBaseUtility();

	public WebDriver driver = null;
	public static WebDriver sdriver = null;

	@BeforeSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configBS() throws SQLException {
		//System.out.println("get db connection");
		dlib.getDBconnection(null, null, null);
		
		
	}

	// @Parameters("BROWSER")
	// WHEN CROSS BROWSER EXECUTION IN configBC(String browser)change
	@BeforeClass(groups = { "SmokeTest", "RegressionTest" })
	public void configBC() throws IOException {
		System.out.println("browser launched");

		// String BROWSER = browser;
		String BROWSER = flib.getdatafromproperties("browser");

		if (BROWSER.equalsIgnoreCase("CHROME")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("FIREFOX")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equalsIgnoreCase("EDGE")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (BROWSER.equalsIgnoreCase("SAFARI")) {
			driver = new SafariDriver();
		}
		sdriver = driver;
		UtilityClassObject.setTest(driver);
	}

	@BeforeMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configBM() throws IOException {
		System.out.println("login done");
		String USERNAME = flib.getdatafromproperties("username");
		String PASSWORD = flib.getdatafromproperties("password");
		String URL = flib.getdatafromproperties("url");
		 LoginPage lp=new LoginPage(driver);
		lp.login(URL, USERNAME, PASSWORD);

	}

	@AfterMethod(groups = { "SmokeTest", "RegressionTest" })
	public void configAM()
	{
	/**	AdminHomePage hp=new AdminHomePage(driver);
		hp.signout();
		waitForPageToLoad(driver);
		LoginPage lp=new LoginPage(driver);
		boolean logo = lp.getLogo().isDisplayed();
		Assert.assertTrue(logo);
		System.out.println("logOut sucessfull");**/
	}

	@AfterClass(groups = { "SmokeTest", "RegressionTest" })
	public void configAC() {
		System.out.println("driver quit");
	//	driver.quit();
	}

	@AfterSuite(groups = { "SmokeTest", "RegressionTest" })
	public void configAS() {
		//System.out.println("close db conection");

	}

}
