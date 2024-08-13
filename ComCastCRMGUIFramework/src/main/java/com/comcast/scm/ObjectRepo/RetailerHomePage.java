 package com.comcast.scm.ObjectRepo;
/**
 * @author girija sankar
 * pom page for retailer 
 */

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RetailerHomePage
{   
	
	public WebDriver driver;
	 
	@FindAll({@FindBy(xpath="//a[text()='New Order']"),@FindBy(xpath="//a[@href='../retailer/order_items.php']")})
	private WebElement addNewOrderBtn;

	@FindAll({@FindBy(xpath="//a[text()='Products']"),@FindBy(xpath="//a[@href='../retailer/view_products.php']")})
	private WebElement poductsListBtn;
	
	@FindBy(xpath = "//table/tbody/tr/td[2]")
	private List<WebElement> listProduct;
	
	@FindAll({@FindBy(id="btnSubmit"),@FindBy(xpath="//input[@value='Post Order']")})
	private WebElement postOrderBtn;
	
	@FindAll({@FindBy(xpath="//a[text()='Products']"),@FindBy(xpath="//a[@href='../retailer/view_products.php']")})
	private WebElement MyOrdersListBtn;
	
	@FindBy(xpath="//input[@value='Log out']")
	private WebElement retailerSignOutBtn;
	
	@FindBy(xpath="//h1[text()='Order Items']")
	private WebElement orderItemMsg;
	
      
	public WebElement getOrderItemMsg() {
		return orderItemMsg;
	}

	public WebElement getMyOrdersListBtn() {
		return MyOrdersListBtn;
	}

	public WebElement getRetailerSignOutBtn() {
		return retailerSignOutBtn;
	}

	public WebElement getPostOrderBtn() {
		return postOrderBtn;
	}

	public WebElement getPoductsListBtn() {
		return poductsListBtn;
	}

	public List<WebElement> getListProduct() {
		return listProduct;
	}

	public WebElement getAddNewOrderBtn() 
	{
		return addNewOrderBtn;
	}
	
	public RetailerHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
       
}
