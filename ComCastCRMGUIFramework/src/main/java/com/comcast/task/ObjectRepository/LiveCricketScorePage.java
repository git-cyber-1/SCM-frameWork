package com.comcast.task.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LiveCricketScorePage {
	
	@FindBy(linkText="Recent")
	private WebElement recent;
	
	@FindBy(xpath="//a[text()='Namibia vs Scotland,']/ancestor::div[contains(@class,'cb-col-100 cb-')]/following-sibling::nav/child::a[contains(text(),'Scorecard')]")
	private WebElement scoretable;

	public WebElement getScoretable() {
		return scoretable;
	}


	public WebElement getRecent() {
		return recent;
	}
	

	public LiveCricketScorePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	

}
