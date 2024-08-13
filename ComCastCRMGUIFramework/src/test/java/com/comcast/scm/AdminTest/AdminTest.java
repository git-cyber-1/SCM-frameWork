package com.comcast.scm.AdminTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.comcast.scm.ObjectRepo.AdminHomePage;
import com.comcast.scm.generic.BaseTest.BaseClassforScm;

public class AdminTest extends BaseClassforScm {

	@Test
	public void loginAdminTest() {
		
		AdminHomePage ahp=new AdminHomePage(driver);
		ahp.addManufacturer("NIGGABRO", "niggabro123@gmail.com","8888888880","nigga1", "nigga2");
		  List<WebElement> ele2 = driver.findElements(By.xpath("//table//tr//td[position()=1]"));
		
		  
		  for(WebElement ele:ele2) {
			
			System.out.println(ele.getText());
			
		}
	}
	
}
