package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	
	WebDriver driver;

	@FindBy(xpath="//img[@title='Create Contact...']")
	private WebElement crtcontactBtn;
	
	@FindBy(name="lastname")
	private WebElement lastname;
	 
	@FindBy(xpath="//input[@class=\"crmButton small save\"]")
	private WebElement saveBtn;

	public WebElement getCrtcontactBtn() {
		return crtcontactBtn;
	}

	public WebElement getLastname() {
		return lastname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public ContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	
	
	
}
