package com.comcast.crm.ContactTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactWithOrgIntegration {
	@Test
	public void contactOrg() throws IOException, InterruptedException {

		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility ju = new JavaUtility();
		WebDriverUtility wu = new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");

		String orgname = eu.getDataFromExcel("contact", 7, 2) + ju.getRandomNumber();
		String ContactLastname = eu.getDataFromExcel("contact", 7, 3) + ju.getRandomNumber();

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
		driver.manage().window().maximize();
		wu.waitForPageToLoad(driver);
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String header = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (header.contains(orgname)) {
			System.out.println(orgname + " header verified=====passed");
		} else {
			System.out.println(orgname + "header not verified ====failed");
		}
		String actorgname = driver.findElement(By.xpath("//*[@id=\"dtlview_Organization Name\"]")).getText();
		if (actorgname.equals(orgname)) {
			System.out.println(orgname + " information is created =====pass");
		} else {
			System.out.println(orgname + " information is not created ====fail");
		}
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(ContactLastname);
		driver.findElement(By.xpath("//td[text()='Organization Name 			']/following-sibling::td/child::img")).click();
		// switch to childWindow
		wu.switchToTabOnURL(driver, "module=Accounts");

		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		driver.findElement(By.name("search")).click();
		// dynamicxpath
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
		// switch to parentwindow
		wu.switchToTabOnURL(driver, "module=Contacts");

		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		String lastnameincontactpage = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
		if (lastnameincontactpage.trim().contains(ContactLastname)) {
			System.out.println(ContactLastname + " is verified");
		} else {
			System.out.println(ContactLastname + "not verified");
		}
		String orgnameincontactpage = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		if (orgnameincontactpage.contains(orgname)) {
			System.out.println(orgname + "passed");
		} else {
			System.out.println(orgname + "not passed");
		}
		Thread.sleep(3000);
		driver.quit();

	}

}
