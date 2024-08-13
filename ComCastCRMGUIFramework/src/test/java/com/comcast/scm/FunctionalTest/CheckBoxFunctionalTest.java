package com.comcast.scm.FunctionalTest;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;

public class CheckBoxFunctionalTest extends BaseClassforScm{

	@Test
	public void checkbox_IsCheckedTest() {
	  
    AdminHomePage ahp=new AdminHomePage(driver);
	ahp.getAdminProductssBtn().click();
    
    // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();
	           checkbox.click();

	  // Verify the checkbox is checked
	  Assert.assertTrue(checkbox.isSelected());

	
	}
	
	@Test
	public void checkbox_IsUncheckedTest() {
	 
		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();

	  // Verify the checkbox is unchecked
	  Assert.assertFalse(checkbox.isSelected());

	}
	
	@Test
	public void multipleCheckboxes_AreCheckedTest() {
	 
		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
	  // Get the checkboxes
	  List<WebElement> checkboxes = (List<WebElement>) ahp.getListOfCheckBox();
	 

	  // Verify all checkboxes are checked
	  for (WebElement checkbox : checkboxes) {
	    Assert.assertFalse(checkbox.isSelected());
	  }
	}
	@Test
	public void checkbox_CheckedAndUncheckedTest() {
	 
		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
		
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();

	  // Check the checkbox
	     checkbox.click();

	  // Verify the checkbox is checked
	  Assert.assertTrue(checkbox.isSelected());

	  // Uncheck the checkbox
	    checkbox.click();

	  // Verify the checkbox is unchecked
	   Assert.assertFalse(checkbox.isSelected());

	
	}
	@Test
	public void checkbox_IsEnabledAndClickableTest() {
	 
		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
		
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();
    
	  // Verify the checkbox is enabled
	  Assert.assertTrue(checkbox.isEnabled());

	  // Verify the checkbox is clickable
	  Assert.assertTrue(checkbox.isDisplayed());

	 
	}
	@Test
	public void negCheckbox_IsDisabled() {
	  

		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
		
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();

	  // Verify the checkbox is disabled
	  Assert.assertFalse(checkbox.isEnabled());

	
	}
	
	@Test
	public void negcheckbox_IsNotVisible() {
	

		 AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
		
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();

		
	  // Verify the checkbox is not visible
	  Assert.assertFalse(checkbox.isDisplayed());

	 
	}
	
	@Test
	public void negCheckbox_NotCheckedAfterClicking() {
	 
	     AdminHomePage ahp=new AdminHomePage(driver);
	     ahp.getAdminProductssBtn().click();
		
	  // Get the checkbox
	  WebElement checkbox = ahp.getViewProductsCheckBox();

	  // Click the checkbox
	  checkbox.click();

	  // Verify the checkbox is not checked
	  Assert.assertFalse(checkbox.isSelected());

	 
	}
	@Test
	public void negCheckbox_NotUncheckedAfterClickingTwice() {
	  
		  AdminHomePage ahp=new AdminHomePage(driver);
		     ahp.getAdminProductssBtn().click();
			
		  // Get the checkbox
		  WebElement checkbox = ahp.getViewProductsCheckBox();
		
		
	  // Check the checkbox
	  checkbox.click();

	  // Verify the checkbox is checked
	  Assert.assertTrue(checkbox.isSelected());

	  // Click the checkbox again
	  checkbox.click();

	  // Verify the checkbox is still checked
	  Assert.assertTrue(checkbox.isSelected());

	
	}
}
