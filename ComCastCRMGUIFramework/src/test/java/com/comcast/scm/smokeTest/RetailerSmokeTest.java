package com.comcast.scm.smokeTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.ObjectRepo.RetailerHomePage;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class RetailerSmokeTest {
	public WebDriver driver;
	public static ExcelUtility elib = new ExcelUtility();
	public static JavaUtility jlib = new JavaUtility();
	public static WebDriverUtility wlib = new WebDriverUtility();

	
	
	@Test(groups= "ST",priority = 1)
	public void ratailerLoginTest() throws EncryptedDocumentException, IOException
	{
		
		
		// reading datas from excell
		String retaileruname = elib.getDataFromExcel("endtoend", 14, 1);
		String retailerpwd = elib.getDataFromExcel("endtoend", 14, 2);
		String url = elib.getDataFromExcel("endtoend", 14, 3);

		// launching driver
		driver = new ChromeDriver();
		driver.get(url);

		// creating object for login pom class
		LoginPage lp = new LoginPage(driver);
		lp.retailerLogin(retaileruname, retailerpwd);
		
		RetailerHomePage rp=new RetailerHomePage(driver);
		boolean btn = rp.getPoductsListBtn().isDisplayed();
		Assert.assertTrue(btn);
		
		rp.getRetailerSignOutBtn();
		driver.quit();
		
	}
	@Test(groups= "ST",priority = 2)
	public void retailerAddNewOrderTest() throws EncryptedDocumentException, IOException
	{
		// reading datas from excell
		String retaileruname = elib.getDataFromExcel("endtoend", 14, 1);
		String retailerpwd = elib.getDataFromExcel("endtoend", 14, 2);
		String url = elib.getDataFromExcel("endtoend", 14, 3);

		// launching driver
		driver = new ChromeDriver();
		driver.get(url);

		// creating object for login pom class
		LoginPage lp = new LoginPage(driver);
		lp.retailerLogin(retaileruname, retailerpwd);
		
		RetailerHomePage rp=new RetailerHomePage(driver);	
		rp.getAddNewOrderBtn().click();
		
		boolean orderMsg = rp.getOrderItemMsg().isDisplayed();
		Assert.assertTrue(orderMsg);
		
		rp.getRetailerSignOutBtn();
		driver.quit();
	}
	@Test(enabled = false,groups= "ST",priority = 3)
	public void retailerPostNewOrder() throws EncryptedDocumentException, IOException
	{
		String retaileruname = elib.getDataFromExcel("endtoend", 14, 1);
		String retailerpwd = elib.getDataFromExcel("endtoend", 14, 2);
		String url = elib.getDataFromExcel("endtoend", 14, 3);

		// launching driver
		driver = new ChromeDriver();
		driver.get(url);

		// creating object for login pom class
		LoginPage lp = new LoginPage(driver);
		lp.retailerLogin(retaileruname, retailerpwd);

		// creating object for retailerHomePage
		RetailerHomePage rhp = new RetailerHomePage(driver);

		String searchProduct = elib.getDataFromExcel("endtoend", 14, 4);
		String reqQuantity = elib.getDataFromExcel("endtoend", 14, 5);
		
		System.out.println(searchProduct);
		rhp.getPoductsListBtn().click();
		List<WebElement> exixtingProducts = rhp.getListProduct();
		for(WebElement ele:exixtingProducts)
		{
			if (ele.getText().equals(searchProduct)) {
				System.out.println("product is availbale");
				rhp.getAddNewOrderBtn().click();
				String stock = driver.findElement(By.xpath("//td[normalize-space(.)='"+searchProduct+"']/following-sibling::td[last()-2]")).getText();
				System.out.println(stock);
				String str =stock;
				int stocki = Integer.parseInt(str);
				
				String str1 =reqQuantity;
				int  reqQuantityi= Integer.parseInt(str);
				
				if(stocki>=reqQuantityi)
					
				{
					System.out.println("ok");
					WebElement ele1 = driver.findElement(By.xpath("//td[normalize-space(.)='"+searchProduct+"']/following-sibling::td[last()-1]/input"));
					wlib.waitforElementPresent(driver, ele1);
				   // wlib.moveToElement(driver, ele, reqQuantity);
					wlib.sendDataUsingjavaScript(driver, reqQuantity, ele1);
					wlib.scrollToElement(driver, rhp.getPostOrderBtn());  
					rhp.getRetailerSignOutBtn().click();}
					
				}
				

			}
         }
		 
        
	
	}
