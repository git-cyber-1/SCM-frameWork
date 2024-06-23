package com.comcast.crm.orgTest;

import java.io.IOException;
import java.time.Duration;
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

public class CreateOrgTest {
	@Test
	public void createorg() throws IOException {
		FileUtility fu = new FileUtility();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();

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
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(39));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
		driver.findElement(By.xpath("//b[contains(.,'Organiz')]/parent::td/../preceding-sibling::tr/descendant::input[@title='Save [Alt+S]']")).click();
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
		driver.quit();
	}

}
