package practiceTestFromTestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;

public class GetProductsInfoTest {
	
	@Test
	public void getProductInfoTest() {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone",Keys.ENTER);
	    String x="write the xpath here";
	    String price=driver.findElement(By.xpath(x)).getText();
	    driver.quit();
	}
    @DataProvider
    public Object[][] getData() throws Exception{
    	ExcelUtility Elib=new ExcelUtility();
    	   int rowCount = Elib.getRowcount("product");
    	   
    	   
    	
    	Object[][] obj=new Object[rowCount][2]; 
    	for(int i=0;i<rowCount;i++) {
    	obj[i][0]=Elib.getDataFromExcel("product",i+1, 0);
    	obj[i][1]=Elib.getDataFromExcel("product",i+1,1);
    	}
    	
   
    	
    	
		return obj;
    }



}

	
