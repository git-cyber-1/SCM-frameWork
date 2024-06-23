package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	
	@FindBy(id="dtlview_Last Name")
	private WebElement cntName;
	
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement HeaderMsg;
	
	@FindBy(id="dtlview_Support Start Date")
	private WebElement ActStrtDate;
	
	@FindBy(id="dtlview_Support End Date")
	private WebElement ActEndDATE;
	
	@FindBy(id="mouseArea_Organization Name")
	private WebElement OrgnameinContactInfo;

	public WebElement getOrgnameinContactInfo() {
		return OrgnameinContactInfo;
	}

	public WebElement getActStrtDate() {
		return ActStrtDate;
	}

	public WebElement getActEndDATE() {
		return ActEndDATE;
	}

	public WebElement getHeaderMsg() {
		return HeaderMsg;
	}

	public WebElement getCntName() {
		return cntName;
	}
	
	public ContactInfoPage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}

}
