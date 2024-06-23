package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class CreateContactPage extends WebDriverUtility{
	
	WebDriver driver;

	@FindBy(name="lastname")
	private WebElement Lastname;
	 
	@FindBy(xpath="//input[@class=\"crmButton small save\"]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement StrtDate;
	
	@FindBy(name="support_end_date")
	private WebElement EndDate;
	
	@FindBy(xpath="//td[text()='Organization Name 			']/following-sibling::td/child::img")
	private WebElement orgbtnincontact;
	

	public WebElement getOrgbtnincontact() {
		return orgbtnincontact;
	}

	public WebElement getStrtDate() {
		return StrtDate;
	}

	public WebElement getEndDate() {
		return EndDate;
	}

	public WebElement getLastname() {
		return Lastname;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public void createcontact(String lastName) {
		Lastname.sendKeys(lastName);
		saveBtn.click();
	}
	public void createContactWithSupportDate(String lastName,String Startdate,String endDate) {
		Lastname.sendKeys(lastName);
		StrtDate.clear();
		StrtDate.sendKeys(Startdate);
		EndDate.clear();
		EndDate.sendKeys(endDate);
		saveBtn.click();
		
	}
	public void createcontactwithorg(String lastname) {
		Lastname.sendKeys(lastname);
		orgbtnincontact.click();
	    WebDriverUtility wlib=new WebDriverUtility();
	    wlib.switchToTabOnURL(driver, "module=Accounts");
	}
	public void saveBtn() {
		
		saveBtn.click();
		
	}


}
