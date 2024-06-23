package com.comcast.task.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CrickBuzzHomePage {

	
	@FindBy(linkText="MATCHES")
	private WebElement matches;

	public WebElement getMatches() {
		return matches;
	}
	
	public CrickBuzzHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
