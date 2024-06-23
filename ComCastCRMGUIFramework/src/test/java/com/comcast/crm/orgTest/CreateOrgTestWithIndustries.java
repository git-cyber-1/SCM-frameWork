package com.comcast.crm.orgTest;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.fileutility.FileUtility;
import com.comcast.crm.generic.webDriverUtility.JavaUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateOrgTestWithIndustries {
	@Test
	public void createorg() throws IOException {
		FileUtility fu=new FileUtility();
		JavaUtility ju=new JavaUtility();
	    ExcelUtility eu=new ExcelUtility();
	    WebDriverUtility wu=new WebDriverUtility();
		
	    String BROWSER = fu.getdatafromproperties("browser");
		String URL =fu.getdatafromproperties("url");
		String USERNAME = fu.getdatafromproperties("username");
		String PASSWORD =fu.getdatafromproperties("password");
		 String orgname=eu.getDataFromExcel("org", 1, 2)+ju.getRandomNumber();
		 String industry=eu.getDataFromExcel("org", 4, 3);
		 String type=eu.getDataFromExcel("org", 4, 4);
				 
		

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
		
		Select sel1=new Select(driver.findElement(By.name("industry")));
		sel1.selectByVisibleText(industry);
		
		Select sel2=new Select(driver.findElement(By.name("accounttype")));
		sel2.selectByValue(type);
		
		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[1]")).click();
		String actindustry1 = driver.findElement(By.id("dtlview_Industry")).getText();
		if(actindustry1.contains(industry)) {
			System.out.println(industry+ " industrty verified=====passed");
		}
		else {
			System.out.println(industry+ " not verified ====failed");
		}
		 String actType = driver.findElement(By.id("dtlview_Type")).getText();
		if(actType.equals(type)) {
			System.out.println(actType+" is created =====pass");
		}
		else {
			System.out.println(actType+" is not created ====fail");
		}
	driver.close();
	}

	}


