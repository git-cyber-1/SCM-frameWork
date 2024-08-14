package com.comcast.scm.FunctionalTest;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;

public class RadioButtonFT extends BaseClassforScm {

	@Test(groups = "FT")
	public void button_IsClickableTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is clickable
		Assert.assertTrue(button.isEnabled());
		Assert.assertTrue(button.isDisplayed());

	}

	@Test(groups = "FT")
	public void button_IsEnabledTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is enabled
		Assert.assertTrue(button.isEnabled());

	}

	@Test(groups = "FT")
	public void button_IsVisibleTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is visible
		Assert.assertTrue(button.isDisplayed());

	}
	@Test(groups = "FT")
	public void button_TextIsCorrectTest() {
	
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();
	 

	  // Verify the button text is correct
	  Assert.assertEquals(button.getText(), "Enable 			");

	 
	}
	@Test(groups = "FT")
	public void button_IsCheckedTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();
		
         button.click();
		// Verify the button is visible
		Assert.assertTrue(button.isSelected());
	
	}
	@Test(groups = "FT")
	public void negButton_IsNotClickableTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is clickable
		Assert.assertFalse(button.isEnabled());
		Assert.assertFalse(button.isDisplayed());

	}
	@Test(groups = "FT")
	public void negButton_IsNotEnabledTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is enabled
		Assert.assertFalse(button.isEnabled());

	}
	@Test(groups = "FT")
	public void negButton_IsNotVisibleTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();

		// Verify the button is visible
		Assert.assertFalse(button.isDisplayed());

	}
	@Test(groups = "FT")
	public void negButton_TextIsNotCorrectTest() {
	
		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();
	 

	  // Verify the button text is correct
	  Assert.assertEquals(button.getText(), "Enable 			");

	 
	}
	@Test(groups = "FT")
	public void negButton_IsNotCheckedTest() {

		AdminHomePage ahp = new AdminHomePage(driver);
		ahp.getAddProductsBtn().click();

		// Get the button
		WebElement button = ahp.getAddProductRadioBtn();
		
         button.click();
		// Verify the button is visible
		Assert.assertFalse(button.isSelected());
	
	}
	
	
}
