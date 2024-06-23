package com.comcast.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	WebDriver driver;

	@FindBy(xpath ="//img[@title='Create Organization...']")
	private WebElement createNewOrgBtn;
	
	@FindBy(name="search_text")
	private WebElement searchBox;
	
	@FindBy(xpath="//b[text()='In']/parent::td/following-sibling::td/descendant::select[@name='search_field']")
	private WebElement searchDD;
	
	@FindBy(xpath="//input[@onclick=\"callSearch('Basic');\"]")
	private WebElement searchBtn;


	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public void setSearchBtn(WebElement searchBtn) {
		this.searchBtn = searchBtn;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSearchDD() {
		return searchDD;
	}

	public WebElement getCreateNewOrgBtn() {
		return createNewOrgBtn;
	}

	public OrganizationsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

}
