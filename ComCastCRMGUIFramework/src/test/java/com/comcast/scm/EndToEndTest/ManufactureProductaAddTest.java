package com.comcast.scm.EndToEndTest;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.ObjectRepo.ManufacturerPage;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;
/**
 * @author girija sankar
 * end to end scenario 
 * 
 */
public class ManufactureProductaAddTest {
          WebDriver driver;
	@Test(priority =1)
	public void addproductinManufactrePage() throws EncryptedDocumentException, IOException
	{
		
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		
		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4);
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);
		            
		 
		   driver=new ChromeDriver();
		   LoginPage lp=new LoginPage(driver);
		lp.manufacturerLogin(url,manuname, manpwd);
		
		ManufacturerPage mfp=new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);
		
		Alert alt=driver.switchTo().alert();
		 String expectedAltMsg = alt.getText();
		 alt.accept();
		 
		 String actualAltMsg = elib.getDataFromExcel("endtoend", 11, 7);
		 Assert.assertEquals(actualAltMsg,expectedAltMsg);
		 
		 mfp.getProductList().click();
		 List<WebElement> allproducts = mfp.getListProduct();
		        boolean flag=false;
		 for(WebElement Name:allproducts)
		 {    String productName = Name.getText();
			
		    if(productName.toString().equals(pname))
			 {
				 flag=true;
			 }
		 }
		Assert.assertTrue(flag);
	    	
	       mfp.getLogoutBtn().click();
	       driver.quit();
	
	}
	
	/**
	 * @throws IOException 
	 * @throws EncryptedDocumentException 
	 * @category end to end test
	 * to manufacturer updating stock and verifying that product updated in inventory or not
	 */
	
	@Test(priority = 2)
	public void manufactureUpdateInventory() throws EncryptedDocumentException, IOException
	{
		//creating object for generic utility class
		
		ExcelUtility elib=new ExcelUtility();
		JavaUtility jlib=new JavaUtility();
		WebDriverUtility wlib=new WebDriverUtility();
		
		//reading datas from excell 
		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4)+jlib.getRandomNumber();
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);
		            
		 //launching driver
		   driver=new ChromeDriver();
		  
		   //creating object for login pom class
		  LoginPage lp=new LoginPage(driver);
		lp.manufacturerLogin(url,manuname, manpwd);
		
		//creating object for Manufacturepage pom class
		ManufacturerPage mfp=new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);
		
		//to accept alert popup after sucessfull creation of product
		Alert alt=driver.switchTo().alert();
		alt.accept();
		 
		//getting all product lists from product list in manufacturer page
		mfp.getProductList().click();
		 List<WebElement> allproducts = mfp.getListProduct();
		       
		 String quantity = elib.getDataFromExcel("endtoend", 11, 8);
		
		 //using for each loop iterating all products
		 for(WebElement Name:allproducts)
		 {    String productName = Name.getText();
			
		    if(productName.toString().equals(pname))
			 {
		    	 mfp.getManageStockBtn().click();
			 WebElement ele = driver.findElement(By.xpath("//td[text()='"+pname+"']/following-sibling::td[text()='PC']/following-sibling::td/child::input"));
			 System.out.println(" Before updating : "+ele.getText());
			 ele.clear();
			 mfp.updateStock(quantity, ele) ; 
			 
			 }
		 }
		
		 mfp.getManageStockSubmtBtn().click();
		
		 // accepting alert popup after sucessfull update of stock
		 Alert alt1=driver.switchTo().alert();
		 String expectedAltMsg = alt1.getText();
		 alt1.accept();
		 
		 String actualAltMsg = elib.getDataFromExcel("endtoend", 11, 9);
		 //validation of alert msg
		 Assert.assertEquals(actualAltMsg, expectedAltMsg);
		 
		 
		 mfp.getProductList().click();
		 List<WebElement> allproductsUpdated = mfp.getListProduct();
		 for(WebElement Name:allproductsUpdated)
		 {    String productName = Name.getText();
			
		    if(productName.equals(pname))
			 {
		    	 mfp.getManageStockBtn().click();
			 WebElement ele = driver.findElement(By.xpath("//td[text()='"+pname+"']/following-sibling::td[text()='PC']/following-sibling::td/child::input"));
			 System.out.println(" Before updating : "+ele.getText());
			 
			 
			 }
		 }
		 
		 
		 
	}
	
}
