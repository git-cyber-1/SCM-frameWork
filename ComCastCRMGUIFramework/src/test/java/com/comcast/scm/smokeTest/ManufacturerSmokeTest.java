package com.comcast.scm.smokeTest;

import java.io.IOException;
import java.util.List;

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
import com.comcast.scm.generic.fileutility.FileUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class ManufacturerSmokeTest {
	/**
	 * @author girija sankar smoke test of manufacturer
	 */
	WebDriver driver;
	public static FileUtility flib = new FileUtility();
	public static ExcelUtility elib = new ExcelUtility();
	public static WebDriverUtility wlib = new WebDriverUtility();
	public static JavaUtility jlib=new JavaUtility();

	@Test
	public void manufacturerLoginTest() throws IOException {
		// this is to verify whether login page is opening or not
		String URL = flib.getdatafromproperties("url");

		String UNAME = elib.getDataFromExcel("SMOKE", 1, 1);
		String PWD = elib.getDataFromExcel("SMOKE", 1, 2);
		
		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(URL, UNAME, PWD);

		ManufacturerPage mpg = new ManufacturerPage(driver);
		boolean profile = mpg.getMyProfileMsg().isDisplayed();
		Assert.assertTrue(profile);

		String unameInManPage = driver.findElement(By.xpath(
				"//th[text()='Username']/../following-sibling::tr/child::td[normalize-space(.)='" +UNAME+ "']"))
				.getText();
		Assert.assertEquals(UNAME, unameInManPage);

		mpg.getLogoutBtn().click();
		driver.close();

	}
	
	@Test
	public void validateManufacturerPageWorking() throws IOException
	{
		//this is to verify whether modules in manufacture page is properly working or not
		
		String URL = flib.getdatafromproperties("url");

		String UNAME = elib.getDataFromExcel("SMOKE", 1, 1);
		String PWD = elib.getDataFromExcel("SMOKE", 1, 2);
		
		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(URL, UNAME, PWD);

		ManufacturerPage mpg = new ManufacturerPage(driver);
		mpg.getAddProductBtn().click();
		
		//validating whether add product is properly working or not
		boolean welcomemsg = mpg.getAddProductWelcomMsg().isDisplayed();
		Assert.assertTrue(welcomemsg);
		//validating whether manageStock is properly working or not
		mpg.getManageStockBtn().click();
		boolean stockMsg = mpg.getManageStockWelcomemsg().isDisplayed();
		Assert.assertTrue(stockMsg);
		//validating whether manageCatagory working or not
	    mpg.getManageCatagoryBtn().click();
	    boolean catBtn = mpg.getManageCatWelcomemsg().isDisplayed();
	    Assert.assertTrue(catBtn);
	    //validating whether editProfile is working or not
	    mpg.getEditProfileBtn().click();
	    boolean profileBtn = mpg.getEditProfileWelcomemsg().isDisplayed();
	    Assert.assertTrue(profileBtn);
	  //validating whether manageUnit is properly working or not
	  	mpg.getManageUnitBtn().click();
	  	boolean unitbtn = mpg.getManageUnitWelcomemsg().isDisplayed();
	  	Assert.assertTrue(unitbtn);
	  	mpg.getLogoutBtn().click();
	  	driver.quit();
		
	}
	
@Test
public void addProduct() throws IOException
{
	
	String URL = flib.getdatafromproperties("url");

	String UNAME = elib.getDataFromExcel("SMOKE", 1, 1);
	String PWD = elib.getDataFromExcel("SMOKE", 1, 2);
	String pname = elib.getDataFromExcel("SMOKE", 2, 3)+jlib.getRandomNumber();
	String pprice = elib.getDataFromExcel("SMOKE", 2, 4);
	String pdescription = elib.getDataFromExcel("SMOKE", 2, 5);
	
	driver = new ChromeDriver();
	LoginPage lp = new LoginPage(driver);
	lp.manufacturerLogin(URL, UNAME, PWD);

	ManufacturerPage mpg = new ManufacturerPage(driver);
	mpg.addProduct(pname, pprice, pdescription);
	
	//to accept alert popup after sucessfull creation of product
	Alert alt=driver.switchTo().alert();
	alt.accept();
	 
	//getting all product lists from product list in manufacturer page
	mpg.getProductList().click();
	 List<WebElement> allproducts = mpg.getListProduct();
	       
	 String quantity = elib.getDataFromExcel("SMOKE",2, 7);
	
	 //using for each loop iterating all products
	 for(WebElement Name:allproducts)
	 {    String productName = Name.getText();
		
	    if(productName.toString().equals(pname))
		 {
	    	 mpg.getManageStockBtn().click();
		 WebElement ele = driver.findElement(By.xpath("//td[text()='"+pname+"']/following-sibling::td[text()='PC']/following-sibling::td/child::input"));
		 System.out.println(" Before updating : "+ele.getText());
		 ele.clear();
		 mpg.updateStock(quantity, ele) ; 
		 
		 }
	 }
	
	 mpg.getManageStockSubmtBtn().click();
	
	 // accepting alert popup after sucessfull update of stock
	 Alert alt1=driver.switchTo().alert();
	 String expectedAltMsg = alt1.getText();
	 alt1.accept();
	 
		mpg.getLogoutBtn().click();
	  	driver.quit();
	
	
	
}

}






































































































































