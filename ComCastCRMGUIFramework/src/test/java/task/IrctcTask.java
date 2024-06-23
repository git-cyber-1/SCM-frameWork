package task;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import com.comcast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.generic.webDriverUtility.WebDriverUtility;

public class IrctcTask {

	@Test()
	public void irctc() throws Exception {
		WebDriverUtility wlib = new WebDriverUtility();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		wlib.maximizePage(driver);
		wlib.waitForPageToLoad(driver);
		driver.get("https://www.google.co.in/");
		driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("irctc", Keys.ENTER);
		driver.findElement(By.xpath("//h3[text()='IRCTC Next Generation eTicketing System']")).click();
		driver.findElement(By.xpath("//span[contains(@class,'ng-tns-c57-8 ')]/child::input[@role=\"searchbox\"]"))
				.sendKeys(" BALESHWAR - BLS ");
		driver.findElement(By.xpath("//span[contains(@class,'ng-tns-c57-9')]/child::input[@role=\"searchbox\"]"))
				.sendKeys(" BHUBANESWAR - BBS ");
		driver.findElement(By.xpath("//span[@class=\"ng-tns-c58-10 ui-calendar\"]/child::input")).click();
		driver.findElement(By.xpath("//a[text()='17']")).click();
		driver.findElement(By.xpath(
				"//div[contains(@class,'ui-dropdown-label-container ng-tns-c65-11')]/following-sibling::div[@role='button']"))
				.click();
		driver.findElement(By.xpath("//span[text()='Sleeper (SL)']")).click();
		WebElement btn = driver.findElement(By.xpath("//button[@type='submit']"));
		btn.submit();
		ExcelUtility elib = new ExcelUtility();
		List<WebElement> trainslist = driver.findElements(By.xpath("//div[@class='col-sm-5 col-xs-11 train-heading']"));
		WebElement lastTrain = trainslist.get(trainslist.size() - 1);
		String trainname = lastTrain.getText();
		System.out.println(trainname);
		elib.setDataintoExcel("IRCTC", 1, 0, trainname);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,7300)");
		String arrivaltimesource = driver
				.findElement(By.xpath("//strong[contains(text(),'" + trainname
						+ "')]/ancestor::div[contains(@class,'form-group ')]/descendant::span[@class=\"time\"]"))
				.getText();
		elib.setDataintoExcel("IRCTC", 2, 1, arrivaltimesource);
		System.out.println(arrivaltimesource);
		String arrivaltimedestination = driver.findElement(By.xpath("//strong[contains(text(),'" + trainname
				+ "')]/ancestor::div[contains(@class,'form-group ')]/descendant::span[@class=\"pull-right\"]/child::strong"))
				.getText();
		System.out.println(arrivaltimedestination);

		elib.setDataintoExcel("IRCTC", 3, 2, arrivaltimedestination);
		driver.quit();

	}

}
