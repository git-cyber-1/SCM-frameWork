package com.comcast.task.ObjectRepository;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScoreTablePage {
	
	@FindBy(xpath="//div[@id='innings_1']/div[contains(.,'Namibia Innings')]/descendant::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@class='cb-col cb-col-8 text-right text-bold']")
     private List<WebElement> runs;
	
	@FindBy(xpath="//div[@id='innings_1']/div[contains(.,'Namibia Innings')]/descendant::div[@class='cb-col cb-col-25 ']")
	private List<WebElement> batters;
	
	@FindBy(xpath="//div[@id='innings_1']/div[contains(.,'Namibia Innings')]/descendant::div[@class='cb-col cb-col-8 text-right' and contains(text(),'SR')]/../following-sibling::div[@class='cb-col cb-col-100 cb-scrd-itms']/div[@style='padding-right:10px;']/following-sibling::div[@class='cb-col cb-col-8 text-right']")
	private List<WebElement> strikeRate;

	public List<WebElement> getRuns() {
		return runs;
	}

	public List<WebElement> getBatters() {
		return batters;
	}

	public List<WebElement> getStrikeRate() {
		return strikeRate;
	}
	
	public ScoreTablePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
