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

public class CreateContactWithSupportDateTest {
	@Test
	public void createorg() throws IOException {

		FileUtility fu = new FileUtility();
		JavaUtility ju = new JavaUtility();
		ExcelUtility eu = new ExcelUtility();
		WebDriverUtility wu=new WebDriverUtility();

		String BROWSER = fu.getdatafromproperties("browser");
		String URL = fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD = fu.getdatafromproperties("password");
		String lastname = eu.getDataFromExcel("contact", 4, 2) + ju.getRandomNumber();

		String startdate = ju.getSysDateYYYYDDMM();
		System.out.println("Start date : "+startdate);
		
		String enddate = ju.getRequiredDate(6);
		System.out.println("enddate : "+enddate);
		
		
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

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		
		driver.findElement(By.name("support_start_date")).clear();
		driver.findElement(By.name("support_start_date")).sendKeys(startdate);
		
		driver.findElement(By.name("support_end_date")).clear();
		driver.findElement(By.name("support_end_date")).sendKeys(enddate);

		driver.findElement(By.xpath("//input[contains(@class,'crmButton small save')]")).click();
		String header = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if (header.contains(lastname)) {
			System.out.println(lastname + " verified=====passed");
		} else {
			System.out.println(lastname + " not verified ====failed");

		}
		String actstartdate = driver.findElement(By.id("dtlview_Support Start Date")).getText();
		System.out.println("ACTUAL START DATE" + actstartdate);
		if (actstartdate.equals(startdate)) {
			System.out.println(startdate + "passed");

		} else {
			System.out.println(startdate + " failed");
		}
		String actenddate = driver.findElement(By.id("dtlview_Support End Date")).getText();
		System.out.println("ACTUAL ENDDATE " + actenddate);
		if (actenddate.equals(enddate)) {
			System.out.println(enddate + "passed");
		} else {
			System.out.println(enddate + "not passed");
		}
		driver.quit();

	}

}
