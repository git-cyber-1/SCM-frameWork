package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage {
	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createprdctbtn;

	public WebElement getCreateprdctbtn() {
		return createprdctbtn;
	} 

}
