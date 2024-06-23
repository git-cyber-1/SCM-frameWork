package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {

	WebDriver driver;

	public OrganizationInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(className="dvHeaderText")
	private WebElement headerMsg;

	public WebElement getHeaderMsg() {
		return headerMsg;
	}
	@FindBy(id="dtlview_Phone")
	private WebElement MobNum;

	public WebElement getMobNum() {
		return MobNum;
	}
     @FindBy(id="dtlview_Industry")
     private WebElement industry;
     
     @FindBy(id="dtlview_Organization Name")
     private WebElement ActOrgName;

	public WebElement getActOrgName() {
		return ActOrgName;
	}

	public WebElement getIndustry() {
		return industry;
	}
	

	
	

}
