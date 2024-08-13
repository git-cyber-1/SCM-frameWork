package com.comcast.scm.IntegartionTest;

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

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.ObjectRepo.LoginPage;
import com.comcast.scm.ObjectRepo.ManufacturerPage;
import com.comcast.scm.ObjectRepo.RetailerHomePage;
import com.comcast.scm.generic.fileutility.ExcelUtility;
import com.comcast.scm.generic.fileutility.FileUtility;
import com.comcast.scm.generic.webDriverUtility.JavaUtility;
import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

/**
 * @author girija sankar this is integartion test Data floe between addProducts
 *         and products module
 */

public class ManufacturerAddProductIntegartion {

	// this is to test after adding product as manufacturere same product is
	// available in productList in manufacturer page

	WebDriver driver;
	public static ExcelUtility elib = new ExcelUtility();
	public static JavaUtility jlib = new JavaUtility();
	public static WebDriverUtility wlib = new WebDriverUtility();
	public static FileUtility flib = new FileUtility();

	@Test
	public void addproductinManufactrePage() throws EncryptedDocumentException, IOException {

		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4);
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(url, manuname, manpwd);

		ManufacturerPage mfp = new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);

		Alert alt = driver.switchTo().alert();
		String expectedAltMsg = alt.getText();
		alt.accept();

		String actualAltMsg = elib.getDataFromExcel("endtoend", 11, 7);
		Assert.assertEquals(actualAltMsg, expectedAltMsg);

		mfp.getProductList().click();
		List<WebElement> allproducts = mfp.getListProduct();
		boolean flag = false;
		for (WebElement Name : allproducts) {
			String productName = Name.getText();

			if (productName.toString().equals(pname)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		mfp.getLogoutBtn().click();
		driver.quit();
	}

	@Test
	public void manProductDisplayRetailerProductList() throws EncryptedDocumentException, IOException {

		// this test to after adding product by manufactuerer same product should show
		// in Retailer product list

		// reading data from excell
		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4);
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(url, manuname, manpwd);

		// adding product by manufacturer
		ManufacturerPage mfp = new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);

		// accepting sucessfull alert popup
		Alert alt = driver.switchTo().alert();
		String expectedAltMsg = alt.getText();
		alt.accept();

		String actualAltMsg = elib.getDataFromExcel("endtoend", 11, 7);
		Assert.assertEquals(actualAltMsg, expectedAltMsg);

		mfp.getProductList().click();
		List<WebElement> allproducts = mfp.getListProduct();
		boolean flag = false;
		for (WebElement Name : allproducts) {
			String productName = Name.getText();

			if (productName.toString().equals(pname)) {
				flag = true;
			}
		}
		Assert.assertTrue(flag);
		mfp.getLogoutBtn().click();

		// reading datas from excell
		String retaileruname = elib.getDataFromExcel("endtoend", 14, 1);
		String retailerpwd = elib.getDataFromExcel("endtoend", 14, 2);
		String url1 = elib.getDataFromExcel("endtoend", 14, 3);

		// launching driver
		driver = new ChromeDriver();
		driver.get(url);

		// creating object for login pom class
		LoginPage lp1 = new LoginPage(driver);
		lp1.retailerLogin(retaileruname, retailerpwd);

		// creating object for retailerHomePage
		RetailerHomePage rhp = new RetailerHomePage(driver);

		rhp.getPoductsListBtn().click();
		List<WebElement> exixtingProducts = rhp.getListProduct();

		for (WebElement product : exixtingProducts) {
			String availbleProduct = product.getText();
			if (availbleProduct.equals(pname)) {
				Assert.assertTrue(true);
			}
			rhp.getRetailerSignOutBtn().click();
			driver.quit();
		}
	}

	@Test
	public void productaddByManufacturerDisplayInAdminPageProductListTest()
			throws EncryptedDocumentException, IOException {
		// this test to after adding product by manufactuerer same product should show
		// in Admin product list

		// reading data from excell
		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4);
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);

		driver = new ChromeDriver();
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(url, manuname, manpwd);

		// adding product by manufacturer
		ManufacturerPage mfp = new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);

		// accepting sucessfull alert popup
		Alert alt = driver.switchTo().alert();
		String expectedAltMsg = alt.getText();
		alt.accept();

		mfp.getLogoutBtn().click();

		FileUtility flib = new FileUtility();
		String USERNAME = flib.getdatafromproperties("username");
		String PASSWORD = flib.getdatafromproperties("password");

		LoginPage LP = new LoginPage(driver);
		LP.adminLogin(USERNAME, PASSWORD);

		AdminHomePage ahp = new AdminHomePage(driver);

		ahp.getAdminProductssBtn().click();
		List<WebElement> existingProducts = ahp.getProductListAdminPage();

		for (WebElement products : existingProducts) {
			String searchProduct = products.getText();
			if (searchProduct.equals(pname)) {
				Assert.assertTrue(true);
			}
		}

		ahp.getSignOut().click();
		driver.quit();
	}

	@Test
	public void manufacturerUpadteProductDisplayInProductList() throws EncryptedDocumentException, IOException {
		// In this test data flow between manufacturer manageStock and product list
		// module

		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		// reading datas from excell
		String manuname = elib.getDataFromExcel("endtoend", 11, 1);
		String manpwd = elib.getDataFromExcel("endtoend", 11, 2);
		String url = elib.getDataFromExcel("endtoend", 11, 3);
		String pname = elib.getDataFromExcel("endtoend", 11, 4) + jlib.getRandomNumber();
		String pprice = elib.getDataFromExcel("endtoend", 11, 5);
		String pdescription = elib.getDataFromExcel("endtoend", 11, 6);

		// launching driver
		driver = new ChromeDriver();

		// creating object for login pom class
		LoginPage lp = new LoginPage(driver);
		lp.manufacturerLogin(url, manuname, manpwd);

		// creating object for Manufacturepage pom class
		ManufacturerPage mfp = new ManufacturerPage(driver);
		mfp.addProduct(pname, pprice, pdescription);

		// to accept alert popup after sucessfull creation of product
		Alert alt = driver.switchTo().alert();
		alt.accept();

		// getting all product lists from product list in manufacturer page
		mfp.getProductList().click();
		List<WebElement> allproducts = mfp.getListProduct();

		String quantity = elib.getDataFromExcel("endtoend", 11, 8);

		// using for each loop iterating all products
		for (WebElement Name : allproducts) {
			String productName = Name.getText();

			if (productName.toString().equals(pname)) {
				mfp.getManageStockBtn().click();
				WebElement ele = driver.findElement(By.xpath("//td[text()='" + pname
						+ "']/following-sibling::td[text()='PC']/following-sibling::td/child::input"));
				ele.clear();
				mfp.updateStock(quantity, ele);

			}
		}

		mfp.getManageStockSubmtBtn().click();

		// accepting alert popup after sucessfull update of stock
		Alert alt1 = driver.switchTo().alert();
		String expectedAltMsg = alt1.getText();
		alt1.accept();

		mfp.getProductList().click();

		WebElement ele = driver.findElement(By.xpath("//td[normalize-space(.)='" + pname + "']//parent::tr//td[7]"));
		System.out.println("After updating : " + ele.getText());

		Assert.assertEquals(quantity, ele.getText());
		mfp.getLogoutBtn().click();
		driver.quit();

	}
}
