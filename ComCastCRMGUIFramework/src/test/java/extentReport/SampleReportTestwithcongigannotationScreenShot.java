package extentReport;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTestwithcongigannotationScreenShot {

	public ExtentReports er;

	@BeforeSuite
	public void configBS() {
		ExtentSparkReporter esr = new ExtentSparkReporter("./AdvanceReport/report.html");
		esr.config().setDocumentTitle("CRM Test Suite Results");
		esr.config().setReportName("CRM report");
		esr.config().setTheme(Theme.DARK);
		er = new ExtentReports();
		er.attachReporter(esr);
		er.setSystemInfo("OS", "Windows-10");
		er.setSystemInfo("Browser", "chrome");
	}

	@AfterSuite
	public void configAS() {
		er.flush();

	}

	@Test
	public void createContact() throws IOException {
		
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		TakesScreenshot ts=(TakesScreenshot)driver;
		String src=ts.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = er.createTest("createcontacttest");

		test.log(Status.INFO, "login to app");
		test.log(Status.INFO, "navigate to contact");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HDFgC")) {
			test.log(Status.PASS, "contact creatd");
		} else {
			test.addScreenCaptureFromBase64String(src,"ErrorFile");
		}
		System.out.println("login to app");
		driver.quit();

	}
	
	
}
