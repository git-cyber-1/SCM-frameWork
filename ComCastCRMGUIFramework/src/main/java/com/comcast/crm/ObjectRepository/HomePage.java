package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(linkText = "Organizations")
	private WebElement orgLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactLink;

	@FindBy(linkText = "Campaigns")
	private WebElement CampaignsLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;
	
	@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement signOutLink;
	
	

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return CampaignsLink;
	}

	public WebElement getOrgLink() {
		return orgLink;
	}

	public WebElement getContactLink() {
		return contactLink;
	}
       //BUSINESS METHODS FOR MULTIPLE ACTIONS
	public void navigateToCampaign() {
		Actions act=new Actions(driver);
        act.moveToElement(moreLink)	.perform(); 	
		CampaignsLink.click();

	}

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void signOut() {
		Actions act=new Actions(driver);
		act.moveToElement(adminImg).perform();
		signOutLink.click();
	}

	
}
