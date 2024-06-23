package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateNewOrganizationsPage {
	
	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(id="phone")
	private WebElement mobileNum;
	
	@FindBy(xpath="//input[@value='Cancel  ']/preceding-sibling::input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	@FindBy(name="industry")
	private WebElement industryDB;

	public WebElement getMobileNum() {
		return mobileNum;
	}

	public WebElement getOrgNameEdt() {
		return orgNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public CreateNewOrganizationsPage(WebDriver drievr) {
		this.driver=drievr;
		PageFactory.initElements(driver,this);
	}
	
	public void createOrg(String orgname) {
		orgNameEdt.sendKeys(orgname);
		saveBtn.click();
	}
	public void createOrg(String orgname,String industry) {
		orgNameEdt.sendKeys(orgname);
		Select sel= new Select(industryDB);
		sel.selectByVisibleText(industry);
		saveBtn.click();
	}
	public void createOrgwithMobNum(String orgname,String pnumber) {
		orgNameEdt.sendKeys(orgname);
		 mobileNum.sendKeys(pnumber);
		saveBtn.click();
	}
	
	
	

}
