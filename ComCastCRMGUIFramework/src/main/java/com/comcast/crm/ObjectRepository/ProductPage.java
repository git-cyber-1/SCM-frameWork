package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createprdctbtn;

	public WebElement getCreateprdctbtn() {
		return createprdctbtn;
	} 
	@FindBy(name="searchBtn")
	private WebElement ele3;

	public WebElement getEle3() {
		return ele3;
	}
	@FindBy(xpath="//input[@onclick=\"callSearch('Basic');\"]")
	private WebElement ele4;

	public WebElement getEle4() {
		return ele4;
	}

}
