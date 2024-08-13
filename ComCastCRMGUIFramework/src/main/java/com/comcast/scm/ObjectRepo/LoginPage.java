package com.comcast.scm.ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.scm.generic.webDriverUtility.WebDriverUtility;

public class LoginPage extends WebDriverUtility{
	WebDriver driver;
	
	@FindBy(id="login:username")
	private WebElement UserName;
	
	@FindBy(id="login:password")
	private WebElement Password;
	
	@FindBy(id="login:type")
	private WebElement dropdown;
	
	@FindAll({@FindBy(xpath="//input[@class='submit_button']"),@FindBy(xpath="//input[@value='Log out']")})
	private WebElement loginbtn;
	
	@FindBy(xpath="//img[@src='./images/logo/tekPyramidlogo.svg']")
	private WebElement logo;
	
	
	
	public WebElement getLogo() {
		return logo;
	}


	public void setLogo(WebElement logo) {
		this.logo = logo;
	}


	public LoginPage(WebDriver driver) {
		this.driver=driver;
	PageFactory.initElements(driver,this);
	}


	public WebElement getUserName() {
		return UserName;
	}


	public WebElement getPassword() {
		return Password;
	}


	public WebElement getDropdown() {
		return dropdown;
	}


	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	public void login(String url,String username,String password) {
		
		maximizePage(driver);
		waitForPageToLoad(driver);
		driver.get(url);
		UserName.sendKeys(username);
		Password.sendKeys(password);
		select(dropdown, "Admin");
		loginbtn.click();
	}
	 public void adminLogin(String username,String password)
	 {
		    UserName.sendKeys(username);
			Password.sendKeys(password);
			select(dropdown, "Admin");
			loginbtn.click();
	 }
	
	public void manufacturerLogin(String url,String username,String password)
	{
		maximizePage(driver);
		waitForPageToLoad(driver);
		driver.get(url);
		maximizePage(driver);
		waitForPageToLoad(driver);
		UserName.sendKeys(username);
		Password.sendKeys(password);
		select(dropdown, "Manufacturer");
		loginbtn.click();
	}
	
	public void retailerLogin(String username,String password)
	{
		maximizePage(driver);
		waitForPageToLoad(driver);
		UserName.sendKeys(username);
		Password.sendKeys(password);
		select(dropdown, "Retailer");
		loginbtn.click();
	}
	public void manufact2Login(String username,String password)
	{
		UserName.sendKeys(username);
		Password.sendKeys(password);
		select(dropdown, "Manufacturer");
		loginbtn.click();
	}

}
