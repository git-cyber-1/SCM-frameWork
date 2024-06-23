package com.comcast.crm.ContactTest;

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

public class CreateContactTest {
	@Test
	public void createorg() throws IOException {

		// create object
		FileUtility fu = new FileUtility();
		ExcelUtility eu = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();

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
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(39));
		driver.findElement(By.xpath("//input[@name='user_name']")).sendKeys(USERNAME);
		driver.findElement(By.xpath("//input[@name='user_password']")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//input[@id='submitButton']")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastname);
		driver.findElement(By.xpath("//input[contains(@class,'crmButton small save')]")).click();
		String header = driver.findElement(By.xpath("//td[@id='mouseArea_Last Name']")).getText();
		if (header.contains(lastname)) {
			System.out.println(lastname + " verified=====passed");
		} else {
			System.out.println(lastname + " not verified ====failed");
		}

		driver.close();
	}

}
