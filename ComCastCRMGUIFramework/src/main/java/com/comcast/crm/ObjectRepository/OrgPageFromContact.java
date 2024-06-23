package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class OrgPageFromContact {

	WebDriver driver;

	public OrgPageFromContact(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "search_txt")
	private WebElement searchbox;

	@FindBy(name = "search")
	private WebElement searchbtn;

	@FindBy(xpath = "//b[text()='In']/../child::select")
	private WebElement drpdwn;

	public WebElement getDrpdwn() {
		return drpdwn;
	}

	public WebElement getSearchbox() {
		return searchbox;
	}

	public WebElement getSearchbtn() {
		return searchbtn;
	}

	public void searchOrgName(String OrgName) {
		searchbox.sendKeys(OrgName);
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.select(drpdwn, "Organization Name");
		searchbtn.click();
		driver.findElement(By.xpath("//a[text()='" + OrgName + "']")).click();
		wlib.switchToTabOnTitle(driver,"module=Contacts");


	}
}
