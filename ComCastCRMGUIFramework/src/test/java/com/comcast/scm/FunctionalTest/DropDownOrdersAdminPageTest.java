package com.comcast.scm.FunctionalTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;

import junit.framework.Assert;

public class DropDownOrdersAdminPageTest extends BaseClassforScm {
	
	
	@Test
	public void selectOption()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getOrdersBtn().click();
        Select sel=new Select(ahp.getOrderDrpDown());
        sel.selectByValue("id");
        boolean textBox = ahp.getOrderIdTextBox().isEnabled();
        Assert.assertTrue(textBox);
		
	}
	

	@Test
	public void dropDownIsEnabled()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getOrdersBtn().click();
        boolean textBox = ahp.getOrderDrpDown().isEnabled();
        Assert.assertTrue(textBox);
		
	}
	

	@Test
	public void dropDownByKeyBoard()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		WebElement order = ahp.getOrdersBtn();
		order.sendKeys(Keys.ENTER);
		    
	    WebElement dropdown = ahp.getOrderDrpDown();
	    dropdown.sendKeys(Keys.ENTER);
	    
	    dropdown.sendKeys(Keys.DOWN);
	    dropdown.sendKeys(Keys.ENTER);
        boolean textBox = ahp.getOrderDrpDown().isEnabled();
        Assert.assertTrue(textBox);
		
	}
	@Test
	public void dropDownByMouseOver()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		WebElement order = ahp.getOrdersBtn();
		      order.click();
		
	    WebElement dropdown = ahp.getOrderDrpDown();
	  
      Actions act=new Actions(driver);
      act.moveToElement(dropdown).click().perform();
      

      // Verify the options are displayed
      List<WebElement> options = dropdown.findElements(By.tagName("option"));
      Assert.assertTrue(options.size() > 0);
       
		
	}
	
	@Test
	public void dropDownNegativeDisabledTest()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.getOrdersBtn().click();
        boolean textBox = ahp.getOrderDrpDown().isEnabled();
        Assert.assertFalse(textBox);
		
	}
	@Test
	public void negAllOptionAreNotLoadedTest()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		WebElement order = ahp.getOrdersBtn();
		      order.click();
		
	    WebElement dropdown = ahp.getOrderDrpDown();
	    
	    // Verify the dropdown menu options are not loaded
	    List<WebElement> options = dropdown.findElements(By.tagName("option"));
	    Assert.assertTrue(options.isEmpty());

	  
	}
	@Test
	public void negDropdownOptionsNotSelectableTest()
	{
		AdminHomePage ahp=new AdminHomePage(driver);
		WebElement order = ahp.getOrdersBtn();
		      order.click();
		
	    WebElement dropdown = ahp.getOrderDrpDown();
	    
	 // Get the first option
	    WebElement option = dropdown.findElement(By.tagName("option"));
	    
	 // Verify the option is not selectable
	    Assert.assertFalse(option.isEnabled());
	}
	
}
